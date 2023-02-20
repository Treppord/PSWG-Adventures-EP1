val cloth_config_version: String by project.ext
val modmenu_version: String by project.ext
val rei_version: String by project.ext


dependencies {
    "api"(project(":projects:pswg", configuration = "namedElements"))

    // Cloth Config
    "modImplementation"("me.shedaniel.cloth:cloth-config-fabric:${cloth_config_version}") {
        exclude(group = "net.fabricmc.fabric-api")
    }
    "include"("me.shedaniel.cloth:cloth-config-fabric:${cloth_config_version}")

    // Mod Menu
    "modImplementation"("com.terraformersmc:modmenu:${modmenu_version}")

    "modImplementation"("vazkii.patchouli:Patchouli:1.19.3-78")





    // Roughly Enough Items
    "modCompileOnly"("me.shedaniel:RoughlyEnoughItems-api-fabric:${rei_version}")
    "modRuntimeOnly"("me.shedaniel:RoughlyEnoughItems-fabric:${rei_version}")
    "modRuntimeOnly"("dev.architectury:architectury-fabric:7.0.52") // TODO: remove once REI gets their stuff together
}
