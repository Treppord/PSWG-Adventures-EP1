package com.example.addon;

import com.google.common.collect.ImmutableSet;
import com.parzivail.pswg.container.SwgBlocks;
import com.parzivail.pswg.container.SwgItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class TestVillagers {
    public static final PointOfInterestType ARMOR_POI = registerPOI("armorpoi", TestBlocks.ARMOR_STATION);

    public static final PointOfInterestType MERCHANT_POI = registerPOI("merchantpoi", TestBlocks.MARKET_STATION);
    public static final VillagerProfession ARMOR_MASTER = registerProfession("armormaster",
            RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(TestAddon.MODID, "armorpoi")));

    public static final VillagerProfession MERCHANT = registerProfession("merchant",
            RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(TestAddon.MODID, "merchantpoi")));

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(TestAddon.MODID, name),
                VillagerProfessionBuilder.create().id(new Identifier(TestAddon.MODID, name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(TestAddon.MODID, name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static void registerVillagers() {
        TestAddon.LOGGER.debug("Registering Villagers for " + TestAddon.MODID);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(TestVillagers.ARMOR_MASTER,1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(TestItems.BRONZE_CREDIT, 8),
                            new ItemStack(SwgItems.CraftingComponents.BallBearing, 2),
                            12,2,0.08f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(TestItems.SILVER_CREDIT, 5),
                            new ItemStack(TestItems.BESKAR_LUMP, 2),
                            12,5,0.08f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(TestItems.GOLD_CREDIT, 10),
                            new ItemStack(TestItems.HOLODRIVE, 1),
                            12,7,0.08f));
                });

        TradeOfferHelper.registerVillagerOffers(TestVillagers.ARMOR_MASTER,2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(TestItems.GOLD_CREDIT, 2),
                            new ItemStack(SwgBlocks.Workbench.Blaster, 1),
                            12,7,0.08f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(TestItems.GOLD_CREDIT, 3),
                            new ItemStack(SwgBlocks.Workbench.Lightsaber, 1),
                            12,7,0.08f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(TestItems.BRONZE_CREDIT, 30),
                            new ItemStack(TestItems.IMPERIAL_HOLODRIVE, 1),
                            12,2,0.08f));
                });

        TradeOfferHelper.registerVillagerOffers(TestVillagers.ARMOR_MASTER,3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(TestItems.SILVER_CREDIT, 4),
                            new ItemStack(TestItems.SUPER_COMMANDO_EMBLEM, 1),
                            12,5,0.08f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(TestItems.GOLD_CREDIT, 4),
                            new ItemStack(TestItems.BESKAR_ALLOY, 1),
                            12,7,0.08f));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(TestItems.BRONZE_CREDIT, 26),
                            new ItemStack(TestItems.TROOPER_HOLODRIVE, 1),
                            12,2,0.08f));
                });



        TradeOfferHelper.registerVillagerOffers(TestVillagers.MERCHANT,1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(SwgBlocks.Stone.PolishedCanyon, 64),
                            new ItemStack(TestItems.HOTH_HOLODRIVE, 1),
                            12,10,0.01f));
                });

        TradeOfferHelper.registerVillagerOffers(TestVillagers.MERCHANT,2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(SwgItems.MobDrops.EyeOfSketto, 16),
                            new ItemStack(TestItems.DAGOBAH_HOLODRIVE, 1),
                            12,10,0.01f));
                });

        TradeOfferHelper.registerVillagerOffers(TestVillagers.MERCHANT,3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(SwgBlocks.Stone.IlumSmooth, 64),
                            new ItemStack(TestItems.ILUM_HOLODRIVE, 1),
                            12,10,0.01f));
                });




    }
}