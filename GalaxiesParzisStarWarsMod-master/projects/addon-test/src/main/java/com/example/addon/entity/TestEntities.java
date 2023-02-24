package com.example.addon.entity;

import com.parzivail.pswg.Resources;
import com.parzivail.pswg.container.SwgEntities;
import com.parzivail.pswg.entity.mammal.BanthaEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.ArrayList;

public class TestEntities {

    public static final ArrayList<EntityType<?>> entityTypes = new ArrayList<>();


    public static class Clones
    {
        public static final EntityType<CloneEntity> Clone = Registry.register(Registries.ENTITY_TYPE, Resources.id("clone"), FabricEntityTypeBuilder
                .create(SpawnGroup.MISC, CloneEntity::new)
                .dimensions(EntityDimensions.fixed(1, 2))
                .build());

        static void register()
        {
            entityTypes.add(Clone);
            FabricDefaultAttributeRegistry.register(Clone, CloneEntity.createAttributes());
        }
    }
    public static class Droids
    {
        public static final EntityType<DroidEntity> Droids = Registry.register(Registries.ENTITY_TYPE, Resources.id("droid"), FabricEntityTypeBuilder
                .create(SpawnGroup.MISC, DroidEntity::new)
                .dimensions(EntityDimensions.fixed(1, 2))
                .build());

        static void register()
        {
            entityTypes.add(Droids);
            FabricDefaultAttributeRegistry.register(Droids, DroidEntity.createAttributes());
        }
    }

    public static void register()
    {
        TestEntities.Clones.register();
        TestEntities.Droids.register();
    }
}
