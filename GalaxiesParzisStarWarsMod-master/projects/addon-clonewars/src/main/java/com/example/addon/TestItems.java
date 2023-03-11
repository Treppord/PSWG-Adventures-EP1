package com.example.addon;

import com.parzivail.util.registry.ArmorItems;
import com.parzivail.util.registry.RegistryName;
import com.parzivail.util.registry.RegistryOrder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TestItems {
    public static final Item WAMPA_HIDE = registerItem("wampa_hide",
            new Item(new FabricItemSettings()));

    public static final Item BESKAR_ALLOY = registerItem("beskar_alloy",
            new Item(new FabricItemSettings()));

    public static final Item BESKAR_SCRAPS = registerItem("beskar_scraps",
            new Item(new FabricItemSettings()));

    public static final Item BESKAR_LUMP = registerItem("beskar_lump",
            new Item(new FabricItemSettings()));


    public static final Item EMBLEM = registerItem("emblem",
            new Item(new FabricItemSettings()));

    public static final Item FETT_EMBLEM = registerItem("fett_emblem",
            new Item(new FabricItemSettings()));

    public static final Item DEATH_WATCH_EMBLEM = registerItem("death_watch_emblem",
            new Item(new FabricItemSettings()));

    public static final Item SUPER_COMMANDO_EMBLEM = registerItem("super_commando_emblem",
            new Item(new FabricItemSettings()));


    public static final Item BRONZE_CREDIT = registerItem("bronze_credit",
            new Item(new FabricItemSettings()));

    public static final Item SILVER_CREDIT = registerItem("silver_credit",
            new Item(new FabricItemSettings()));

    public static final Item GOLD_CREDIT = registerItem("gold_credit",
            new Item(new FabricItemSettings()));

    @RegistryOrder(0)
    public static class Armor
    {
        @RegistryName("phase1_clonetrooper")
        public static final ArmorItems Phase1Clone = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));
        @RegistryName("phase2_clonetrooper")
        public static final ArmorItems Phase2Clone = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));
    }



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TestAddon.MODID, name), item);



    }

    public static void addItemsToItemGroup(){
        addToItemGroup(ItemGroups.INGREDIENTS, WAMPA_HIDE);
        addToItemGroup(ItemGroups.INGREDIENTS, BESKAR_ALLOY);
        addToItemGroup(ItemGroups.INGREDIENTS, BESKAR_LUMP);
        addToItemGroup(ItemGroups.INGREDIENTS, BESKAR_SCRAPS);
        addToItemGroup(ItemGroups.INGREDIENTS, BRONZE_CREDIT);
        addToItemGroup(ItemGroups.INGREDIENTS, SILVER_CREDIT);
        addToItemGroup(ItemGroups.INGREDIENTS, GOLD_CREDIT);
        addToItemGroup(ItemGroups.INGREDIENTS, EMBLEM);
        addToItemGroup(ItemGroups.INGREDIENTS, DEATH_WATCH_EMBLEM);
        addToItemGroup(ItemGroups.INGREDIENTS, FETT_EMBLEM);
        addToItemGroup(ItemGroups.INGREDIENTS, SUPER_COMMANDO_EMBLEM);


    }

    private static void addToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));

    }



    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + TestAddon.MODID);

        addItemsToItemGroup();


    }


}
