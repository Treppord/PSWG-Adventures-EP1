package com.trep.addon.items;

import com.parzivail.pswg.Galaxies;
import com.parzivail.pswg.container.SwgItems;
import com.parzivail.pswg.item.jetpack.JetpackItem;
import com.parzivail.pswg.item.material.BeskarToolMaterial;
import com.parzivail.util.registry.ArmorItems;
import com.parzivail.util.registry.RegistryName;
import com.parzivail.util.registry.RegistryOrder;
import com.trep.addon.TestAddon;
import com.trep.addon.entity.TestEntities;
import com.trep.addon.items.*;

import dev.emi.trinkets.api.TrinketItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AdventureItems {

    @RegistryOrder(0)
    public static class Armor
    {

        @RegistryName("spawn_mandalorian")
        public static final Item CloneEgg = new SpawnEggItem(TestEntities.Clones.Clone, 0x1F17FF, 0xE4921E, new Item.Settings());
        @RegistryName("beskar_alloy")
        public static final ArmorItems PhaseAClone = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));
        @RegistryName("beskar_alloy_alternative")
        public static final ArmorItems PhaseBClone = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

        @RegistryName("mando")
        public static final ArmorItems Mandalorian = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));


        @RegistryName("cyanmando")
        public static final ArmorItems CyanMandalorian = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

        @RegistryName("vader")
        public static final ArmorItems VADER = new ArmorItems(ArmorMaterials.NETHERITE, new Item.Settings().maxCount(1));


        @RegistryName("bluemando")
        public static final ArmorItems BlueMandalorian = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));


        @RegistryName("redmando")
        public static final ArmorItems RedMandalorian = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));


        @RegistryName("jedi")
        public static final ArmorItems Jedi = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

        @RegistryName("boba")
        public static final ArmorItems Boba = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1)); 

        
        @RegistryName("jedi_robe")
        public static final ArmorItems JediRobe = new ArmorItems(ArmorMaterials.CHAIN, new Item.Settings().maxCount(1));
        @RegistryName("sith_robe")
        public static final ArmorItems SithRobe = new ArmorItems(ArmorMaterials.CHAIN, new Item.Settings().maxCount(1));

@RegistryName("mando_black")
public static final ArmorItems Mandalorianblack = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

@RegistryName("mando_blue")
public static final ArmorItems Mandalorianblue = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

@RegistryName("mando_brown")
public static final ArmorItems Mandalorianbrown = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

@RegistryName("mando_cyan")
public static final ArmorItems Mandaloriancyan = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

@RegistryName("mando_gray")
public static final ArmorItems Mandaloriangray = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

@RegistryName("mando_green")
public static final ArmorItems Mandaloriangreen = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

@RegistryName("mando_light_blue")
public static final ArmorItems Mandalorianlight_blue = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

@RegistryName("mando_light_gray")
public static final ArmorItems Mandalorianlight_gray = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

@RegistryName("mando_lime")
public static final ArmorItems Mandalorianlime = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

@RegistryName("mando_magenta")
public static final ArmorItems Mandalorianmagenta = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

@RegistryName("mando_orange")
public static final ArmorItems Mandalorianorange = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

@RegistryName("mando_pink")
public static final ArmorItems Mandalorianpink = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

@RegistryName("mando_purple")
public static final ArmorItems Mandalorianpurple = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

@RegistryName("mando_red")
public static final ArmorItems Mandalorianred = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

@RegistryName("mando_white")
public static final ArmorItems Mandalorianwhite = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));

@RegistryName("mando_yellow")
public static final ArmorItems Mandalorianyellow = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));





    }

    public static final Item CUSTOM_SNOWBALL = registerItem("thermal_detonator",
            new CustomSnowballItem(new Item.Settings().maxCount(4)));
    public static final Item FORCE_DARK = registerItem("force_dark",
            new ForceDarkItem(new Item.Settings().maxCount(1)));
    public static final Item FORCE_LIGHT = registerItem("force_light",
            new ForceLightItem(new Item.Settings().maxCount(1)));


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







    public static final Item OVERWORLD_ITEM = registerItem("overworld_item",
            new OverworldItem(new FabricItemSettings()));
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

    public static final Item BESKAR_ALLOY_NUGGET = registerItem("beskar_alloy_nugget",
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
        addToItemGroup(TestAddon.AdventuresTab, HOLODRIVE);
        addToItemGroup(TestAddon.AdventuresTab, TROOPER_HOLODRIVE);
        addToItemGroup(TestAddon.AdventuresTab, IMPERIAL_HOLODRIVE);
        addToItemGroup(TestAddon.AdventuresTab, TATOOINE_HOLODRIVE);
        addToItemGroup(TestAddon.AdventuresTab, NEVARRO_HOLODRIVE);
        addToItemGroup(TestAddon.AdventuresTab, HOTH_HOLODRIVE);
        addToItemGroup(TestAddon.AdventuresTab, OVERWORLD_HOLODRIVE);
        addToItemGroup(TestAddon.AdventuresTab, DAGOBAH_HOLODRIVE);


        
        addToItemGroup(TestAddon.AdventuresTab, WARPDRIVE);
        addToItemGroup(TestAddon.AdventuresTab, TATOOINE_ITEM);
        addToItemGroup(TestAddon.AdventuresTab, NEVARRO_ITEM);
        addToItemGroup(TestAddon.AdventuresTab, HOTH_ITEM);
        addToItemGroup(TestAddon.AdventuresTab, OVERWORLD_ITEM);
        addToItemGroup(TestAddon.AdventuresTab, DAGOBAH_ITEM);

        
        addToItemGroup(TestAddon.AdventuresTab, FORCE_DARK);
        addToItemGroup(TestAddon.AdventuresTab, FORCE_LIGHT);
        addToItemGroup(TestAddon.AdventuresTab, CUSTOM_SNOWBALL);

        addToItemGroup(TestAddon.AdventuresTab, BESKAR_ALLOY);
        addToItemGroup(TestAddon.AdventuresTab, BESKAR_ALLOY_NUGGET);
        addToItemGroup(TestAddon.AdventuresTab, BESKAR_SCRAPS);
        addToItemGroup(TestAddon.AdventuresTab, BESKAR_LUMP);
        addToItemGroup(TestAddon.AdventuresTab, BRONZE_CREDIT);
        addToItemGroup(TestAddon.AdventuresTab, SILVER_CREDIT);
        addToItemGroup(TestAddon.AdventuresTab, GOLD_CREDIT);

        addToItemGroup(TestAddon.AdventuresTab, EMBLEM);
        addToItemGroup(TestAddon.AdventuresTab, DEATH_WATCH_EMBLEM);
        addToItemGroup(TestAddon.AdventuresTab, FETT_EMBLEM);
        addToItemGroup(TestAddon.AdventuresTab, SUPER_COMMANDO_EMBLEM);

        addToItemGroup(TestAddon.AdventuresTab, MANDALORIAN_SPEAR_1);
        addToItemGroup(TestAddon.AdventuresTab, MANDALORIAN_SPEAR_2);
        addToItemGroup(TestAddon.AdventuresTab, MANDALORIAN_SPEAR_3);

        addToItemGroup(TestAddon.AdventuresTab, WAMPA_HIDE);

        



    }

    private static void addToItemGroup(ItemGroup group, Item item){
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));

    }



    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + TestAddon.MODID);

        addItemsToItemGroup();


    }


}
