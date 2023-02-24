package com.example.addon;

import com.example.addon.custom.*;
import com.example.addon.entity.TestEntities;
import com.parzivail.pswg.Galaxies;
import com.parzivail.pswg.item.material.BeskarToolMaterial;
import com.parzivail.util.registry.ArmorItems;
import com.parzivail.util.registry.RegistryName;
import com.parzivail.util.registry.RegistryOrder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TestItems {

    @RegistryOrder(0)
    public static class Armor
    {

        @RegistryName("spawn_clone")
        public static final Item CloneEgg = new SpawnEggItem(TestEntities.Clones.Clone, 0x1F1733, 0xE1946E, new Item.Settings());
        @RegistryName("beskar_alloy")
        public static final ArmorItems PhaseAClone = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));
        @RegistryName("beskar_alloy_alternative")
        public static final ArmorItems PhaseBClone = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

        @RegistryName("mando")
        public static final ArmorItems Mandalorian = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));


        @RegistryName("cyanmando")
        public static final ArmorItems CyanMandalorian = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

        @RegistryName("vader")
        public static final ArmorItems VADER = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));


        @RegistryName("bluemando")
        public static final ArmorItems BlueMandalorian = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));


        @RegistryName("redmando")
        public static final ArmorItems RedMandalorian = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));
    }

    public static final Item MANDALORIAN_SPEAR_1 = registerItem("mandalorian_spear_1",
            new SwordItem(BeskarToolMaterial.INSTANCE, 9, -2.85F, new Item.Settings()));
    public static final Item MANDALORIAN_SPEAR_2 = registerItem("mandalorian_spear_2",
            new SwordItem(BeskarToolMaterial.INSTANCE, 8, -2.75F, new Item.Settings()));
    public static final Item MANDALORIAN_SPEAR_3 = registerItem("mandalorian_spear_3",
            new SwordItem(BeskarToolMaterial.INSTANCE, 10, -2.9F, new Item.Settings()));
    public static final Item WAMPA_HIDE = registerItem("wampa_hide",
            new Item(new FabricItemSettings()));

    public static final Item HOLODRIVE = registerItem("holodrive",
            new HolodriveItem(new FabricItemSettings()));
    public static final Item TROOPER_HOLODRIVE = registerItem("trooper_holodrive",
            new TrooperHolodriveItem(new FabricItemSettings()));

    public static final Item HOTH_HOLODRIVE = registerItem("hoth_holodrive",
            new HothHolodriveItem(new FabricItemSettings()));

    public static final Item TATOOINE_HOLODRIVE = registerItem("tatooine_holodrive",
            new TatooineHolodriveItem(new FabricItemSettings()));

    public static final Item OVERWORLD_HOLODRIVE = registerItem("overworld_holodrive",
            new OverworldHolodriveItem(new FabricItemSettings()));

    public static final Item DAGOBAH_HOLODRIVE = registerItem("dagobah_holodrive",
            new DagobahHolodriveItem(new FabricItemSettings()));

    public static final Item ILUM_HOLODRIVE = registerItem("ilum_holodrive",
            new IlumHolodriveItem(new FabricItemSettings()));

    public static final Item NEVARRO_HOLODRIVE = registerItem("nevarro_holodrive",
            new NevarroHolodriveItem(new FabricItemSettings()));








    public static final Item TATOOINE_ITEM = registerItem("tatooine_item",
            new TatooineItem(new FabricItemSettings()));

    public static final Item ILUM_ITEM = registerItem("ilum_item",
            new IlumItem(new FabricItemSettings()));

    public static final Item HOTH_ITEM = registerItem("hoth_item",
            new HothItem(new FabricItemSettings()));

    public static final Item DAGOBAH_ITEM = registerItem("dagobah_item",
            new DagobahItem(new FabricItemSettings()));

    public static final Item NEVARRO_ITEM = registerItem("nevarro_item",
            new NevarroItem(new FabricItemSettings()));

    public static final Item WARPDRIVE = registerItem("warpdrive",
            new WarpdriveItem(new FabricItemSettings()));
    public static final Item IMPERIAL_HOLODRIVE = registerItem("imperial_holodrive",
            new ImperialHolodriveItem(new FabricItemSettings()));

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


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TestAddon.MODID, name), item);



    }

    public static void addItemsToItemGroup(){
        addToItemGroup(Galaxies.TabItems, WAMPA_HIDE);
        addToItemGroup(Galaxies.TabItems, HOLODRIVE);
        addToItemGroup(Galaxies.TabItems, TROOPER_HOLODRIVE);
        addToItemGroup(Galaxies.TabItems, IMPERIAL_HOLODRIVE);
        addToItemGroup(Galaxies.TabItems, TATOOINE_ITEM);

        addToItemGroup(Galaxies.TabItems, BESKAR_ALLOY);
        addToItemGroup(Galaxies.TabItems, BESKAR_LUMP);
        addToItemGroup(Galaxies.TabItems, BESKAR_SCRAPS);
        addToItemGroup(Galaxies.TabItems, BRONZE_CREDIT);
        addToItemGroup(Galaxies.TabItems, SILVER_CREDIT);
        addToItemGroup(Galaxies.TabItems, GOLD_CREDIT);
        addToItemGroup(Galaxies.TabItems, EMBLEM);
        addToItemGroup(Galaxies.TabItems, DEATH_WATCH_EMBLEM);
        addToItemGroup(Galaxies.TabItems, FETT_EMBLEM);
        addToItemGroup(Galaxies.TabItems, SUPER_COMMANDO_EMBLEM);

        addToItemGroup(Galaxies.TabItems, MANDALORIAN_SPEAR_1);
        addToItemGroup(Galaxies.TabItems, MANDALORIAN_SPEAR_2);
        addToItemGroup(Galaxies.TabItems, MANDALORIAN_SPEAR_3);


    }

    private static void addToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));

    }



    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + TestAddon.MODID);

        addItemsToItemGroup();


    }


}
