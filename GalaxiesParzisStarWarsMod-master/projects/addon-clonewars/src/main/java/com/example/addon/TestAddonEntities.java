package com.example.addon;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TestAddonEntities {
    public static BlockEntityType<ArmorStationBlockEntity> ARMOR_STATION;

    public static void registerAllBlockEntities() {
        ARMOR_STATION = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(TestAddon.MODID, "armor_station"),
                FabricBlockEntityTypeBuilder.create(ArmorStationBlockEntity::new,
                        TestBlocks.ARMOR_STATION).build(null));
    }
}
