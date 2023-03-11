bl_info = {
    "name": "Parzi 3D Intermediary format",
    "author": "parzivail",
    "version": (1, 0, 0),
    "blender": (2, 80, 0),
    "location": "File > Import-Export",
    "description": "Export objects, sockets, and relationships to a P3DI file",
    "warning": "",
    "wiki_url": "",
    "category": "Import-Export"}

import bpy
from bpy.props import (
        BoolProperty,
        FloatProperty,
        StringProperty,
        EnumProperty,
        )
from bpy_extras.io_utils import (
        ImportHelper,
        ExportHelper,
        orientation_helper,
        path_reference_mode,
        axis_conversion,
        )

from mathutils import Vector, Matrix
import bmesh

class ExportP3DI(bpy.types.Operator, ExportHelper):

    bl_idname = "export_scene.p3di"
    bl_label = 'Export P3DI'
    bl_options = {'PRESET'}

    filename_ext = ".p3di"
    filter_glob: StringProperty(
            default="*.p3di",
            options={'HIDDEN'},
            )

    path_mode: path_reference_mode

    check_extension = True
    
    def getSocket(self, o):
        return {
            "name": o.name,
            "parent": o.parent.name if o.parent != None else None,
            "transform": [list(row) for row in o.matrix_local]
        }

    def getMesh(self, mesh):
        me = mesh.to_mesh()

        transform = mesh.matrix_local

        meshObj = {
            "name": mesh.name,
            "transform": [list(row) for row in transform],
            "parent": mesh.parent.name if mesh.parent != None else None,
            "material": mesh.active_material.name if mesh.active_material != None else None,
            "faces": [],
            "children": [self.getMesh(cm) for cm in mesh.children if cm.type == "MESH"]
        }
        
        for i, face in enumerate(me.polygons):
            faceObj = []

            for loop_index in face.loop_indices:
                vert = me.vertices[me.loops[loop_index].vertex_index]
                uv = me.uv_layers.active.data[loop_index].uv
                v = vert.co

                faceObj.append({
                    "v": v[:],
                    "t": uv[:]
                })
            
            meshObj["faces"].append({
                "normal": face.normal[:],
                "vertices": faceObj
            })
        
        return meshObj

    def execute(self, context):
        import json

        modelObj = {
            "version": 2,
            "sockets": [],
            "meshes": [],
        }

        for o in context.scene.objects:
            if (not o.visible_get()):
                continue
            
            parentType = o.parent_type

            if parentType != "OBJECT":
                continue

            parentName = o.parent.name if o.parent != None else None
            type = o.type

            if type == "EMPTY":
                if o.empty_display_type == "ARROWS":
                    modelObj["sockets"].append(self.getSocket(o))
            elif type == "MESH" and o.parent == None:
                modelObj["meshes"].append(self.getMesh(o))
        
        with open(self.filepath, 'w') as f:
            json.dump(modelObj, f)

        return {'FINISHED'}


def menu_func_export(self, context):
    self.layout.operator(ExportP3DI.bl_idname, text="Parzi 3D Intermediary (.p3di)")


classes = (
    ExportP3DI,
)


def register():
    for cls in classes:
        bpy.utils.register_class(cls)

    bpy.types.TOPBAR_MT_file_export.append(menu_func_export)


def unregister():
    bpy.types.TOPBAR_MT_file_export.remove(menu_func_export)

    for cls in classes:
        bpy.utils.unregister_class(cls)


if __name__ == "__main__":
    register()
