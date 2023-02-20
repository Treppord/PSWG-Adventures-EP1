package com.example.addon;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TestAddonEntities {

    //smithing anvil

    public static BlockEntityType<FabricatorBlockEntity> SMITHING_ANVIL_BLOCK_ENTITY;
    public static BlockEntityType<ArmorStationBlockEntity> ARMOR_STATION;
    public static BlockEntityType<MarketStationBlockEntity> MARKET_STATION;
    public static BlockEntityType<BlasterTableBlockEntity> BLASTER_TABLE;

    public static void registerAllBlockEntities() {

        ARMOR_STATION = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(TestAddon.MODID, "armor_station"),
                FabricBlockEntityTypeBuilder.create(ArmorStationBlockEntity::new,
                        TestBlocks.ARMOR_STATION).build(null));
        MARKET_STATION = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(TestAddon.MODID, "market_station"),
                FabricBlockEntityTypeBuilder.create(MarketStationBlockEntity::new,
                        TestBlocks.MARKET_STATION).build(null));
        BLASTER_TABLE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(TestAddon.MODID, "blaster_table"),
                FabricBlockEntityTypeBuilder.create(BlasterTableBlockEntity::new,
                        TestBlocks.BLASTER_TABLE).build(null));

        SMITHING_ANVIL_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(TestAddon.MODID,"smithing_anvil_block_entity"),
                FabricBlockEntityTypeBuilder.create(FabricatorBlockEntity::new,
                        TestBlocks.SMITHING_ANVIL).build(null));

    }
}
