package com.parzivail.pswg.container;

import com.parzivail.pswg.Galaxies;
import com.parzivail.pswg.Resources;
import com.parzivail.pswg.api.PswgContent;
import com.parzivail.pswg.item.CableItem;
import com.parzivail.pswg.item.DebugItem;
import com.parzivail.pswg.item.DoorInsertItem;
import com.parzivail.pswg.item.blaster.BlasterItem;
import com.parzivail.pswg.item.blaster.BlasterPowerPackItem;
import com.parzivail.pswg.item.jetpack.JetpackItem;
import com.parzivail.pswg.item.lightsaber.LightsaberItem;
import com.parzivail.pswg.item.material.BeskarToolMaterial;
import com.parzivail.pswg.item.material.DurasteelToolMaterial;
import com.parzivail.pswg.item.material.TitaniumToolMaterial;
import com.parzivail.util.item.*;
import com.parzivail.util.registry.*;
import dev.emi.trinkets.api.TrinketItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;

public class SwgItems
{
	@RegistryOrder(0)
	public static class Debug
	{
		@RegistryName("debug")
		@TabIgnore
		public static final DebugItem Debug = new DebugItem(new Item.Settings().maxCount(1));
	}

	@RegistryOrder(1)
	public static class Armor
	{
		@RegistryName("stormtrooper")
		public static final ArmorItems Stormtrooper = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));
		@RegistryName("purgetrooper")
		public static final ArmorItems Purgetrooper = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));
		@RegistryName("sandtrooper")
		public static final ArmorItems Sandtrooper = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));
		@RegistryName("sandtrooper_backpack")
		public static final TrinketItem SandtrooperBackpack = new TrinketItem(new Item.Settings().maxCount(1));
		@RegistryName("deathtrooper")
		public static final ArmorItems Deathtrooper = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));
		@RegistryName("scouttrooper")
		public static final ArmorItems Scouttrooper = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));
		@RegistryName("jumptrooper")
		public static final ArmorItems Jumptrooper = new ArmorItems(ArmorMaterials.DIAMOND, new Item.Settings().maxCount(1));
		@RegistryName("jumptrooper_jetpack")
		public static final TrinketItem JumptrooperJetpack = new JetpackItem(new Item.Settings().maxCount(1), new JetpackItem.Stats());
		@RegistryName("imperial_pilot_helmet")
		public static final ArmorItem ImperialPilotHelmet = new ArmorItem(ArmorMaterials.DIAMOND, EquipmentSlot.HEAD, new Item.Settings().maxCount(1));
		@RegistryName("imperial_pilot_kit")
		public static final ArmorItem ImperialPilotKit = new ArmorItem(ArmorMaterials.DIAMOND, EquipmentSlot.CHEST, new Item.Settings().maxCount(1));
		@RegistryName("rebel_pilot_helmet")
		public static final ArmorItem RebelPilot = new ArmorItem(ArmorMaterials.DIAMOND, EquipmentSlot.HEAD, new Item.Settings().maxCount(1));
		@RegistryName("rebel_forest_helmet")
		public static final ArmorItem RebelForest = new ArmorItem(ArmorMaterials.DIAMOND, EquipmentSlot.HEAD, new Item.Settings().maxCount(1));
		@RegistryName("rebel_tropical_helmet")
		public static final ArmorItem RebelTropical = new ArmorItem(ArmorMaterials.DIAMOND, EquipmentSlot.HEAD, new Item.Settings().maxCount(1));
		@RegistryName("black_imperial_officer_hat")
		public static final ArmorItem BlackImperialOfficer = new ArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, new Item.Settings().maxCount(1));
		@RegistryName("gray_imperial_officer_hat")
		public static final ArmorItem GrayImperialOfficer = new ArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, new Item.Settings().maxCount(1));
		@RegistryName("light_gray_imperial_officer_hat")
		public static final ArmorItem LightGrayImperialOfficer = new ArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, new Item.Settings().maxCount(1));
		@RegistryName("khaki_imperial_officer_hat")
		public static final ArmorItem KhakiImperialOfficer = new ArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, new Item.Settings().maxCount(1));
	}

	@RegistryOrder(2)
	public static class Door
	{
		@RegistryName("door_insert")
		public static final DyedItems DoorInsert = new DyedItems(color -> new DoorInsertItem(color, new Item.Settings()));
	}

	@RegistryOrder(3)
	public static class Cable
	{
		@RegistryName("insulated_desh_cable")
		public static final Item Power = new CableItem(new Item.Settings());
	}

	@RegistryOrder(4)
	public static class CraftingComponents
	{
		@RegistryName("electric_motor")
		public static final Item ElectricMotor = new Item(new Item.Settings());
		@RegistryName("turbine")
		public static final Item Turbine = new Item(new Item.Settings());
		@RegistryName("ball_bearing")
		public static final Item BallBearing = new Item(new Item.Settings());

		@RegistryName("desh_wire")
		public static final Item DeshWire = new Item(new Item.Settings());
		@RegistryName("desh_coil")
		public static final Item DeshCoil = new Item(new Item.Settings());

		@RegistryName("light_panel")
		public static final Item LightPanel = new Item(new Item.Settings());
		@RegistryName("display_panel")
		public static final Item DisplayPanel = new Item(new Item.Settings());

		@RegistryName("plasteel_rod")
		public static final Item PlasteelRod = new Item(new Item.Settings());
		@RegistryName("durasteel_rod")
		public static final Item DurasteelRod = new Item(new Item.Settings());
	}

	@RegistryOrder(5)
	public static class Material
	{
		@RegistryName("raw_beskar")
		public static final Item BeskarRaw = new Item(new Item.Settings());
		@RegistryName("beskar_ingot")
		public static final Item BeskarIngot = new Item(new Item.Settings());
		@RegistryName("beskar_shovel")
		public static final ToolItem BeskarShovel = new ShovelItem(BeskarToolMaterial.INSTANCE, 1.5F, -3.0F, new Item.Settings());
		@RegistryName("beskar_pickaxe")
		public static final ToolItem BeskarPickaxe = new PPickaxeItem(BeskarToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings());
		@RegistryName("beskar_axe")
		public static final ToolItem BeskarAxe = new PAxeItem(BeskarToolMaterial.INSTANCE, 5, -3.0F, new Item.Settings());
		@RegistryName("beskar_hoe")
		public static final ToolItem BeskarHoe = new PHoeItem(BeskarToolMaterial.INSTANCE, 0, 0.0F, new Item.Settings());

		@RegistryName("raw_chromium")
		public static final Item ChromiumRaw = new Item(new Item.Settings());
		@RegistryName("chromium_ingot")
		public static final Item ChromiumIngot = new Item(new Item.Settings());
		@RegistryName("chromium_nugget")
		public static final Item ChromiumNugget = new Item(new Item.Settings());

		@RegistryName("raw_cortosis")
		public static final Item CortosisRaw = new Item(new Item.Settings());
		@RegistryName("cortosis_ingot")
		public static final Item CortosisIngot = new Item(new Item.Settings());

		@RegistryName("raw_desh")
		public static final Item DeshRaw = new Item(new Item.Settings());
		@RegistryName("desh_ingot")
		public static final Item DeshIngot = new Item(new Item.Settings());
		@RegistryName("desh_nugget")
		public static final Item DeshNugget = new Item(new Item.Settings());

		@RegistryName("raw_diatium")
		public static final Item DiatiumRaw = new Item(new Item.Settings());
		@RegistryName("diatium_ingot")
		public static final Item DiatiumIngot = new Item(new Item.Settings());
		@RegistryName("diatium_nugget")
		public static final Item DiatiumNugget = new Item(new Item.Settings());

		@RegistryName("durasteel_ingot")
		public static final Item DurasteelIngot = new Item(new Item.Settings());
		@RegistryName("durasteel_nugget")
		public static final Item DurasteelNugget = new Item(new Item.Settings());
		@RegistryName("durasteel_shovel")
		public static final ToolItem DurasteelShovel = new ShovelItem(DurasteelToolMaterial.INSTANCE, 1.5F, -3.0F, new Item.Settings());
		@RegistryName("durasteel_axe")
		public static final ToolItem DurasteelAxe = new PAxeItem(DurasteelToolMaterial.INSTANCE, 5, -3.0F, new Item.Settings());
		@RegistryName("durasteel_hoe")
		public static final ToolItem DurasteelHoe = new PHoeItem(DurasteelToolMaterial.INSTANCE, 0, 0.0F, new Item.Settings());
		@RegistryName("durasteel_pickaxe")
		public static final ToolItem DurasteelPickaxe = new PPickaxeItem(DurasteelToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings());

		@RegistryName("exonium")
		public static final Item ExoniumCrystal = new Item(new Item.Settings());

		@RegistryName("helicite_crystal")
		public static final Item HeliciteCrystal = new Item(new Item.Settings());
		@RegistryName("helicite_dust")
		public static final Item HeliciteDust = new Item(new Item.Settings());

		@RegistryName("raw_ionite")
		public static final Item IoniteRaw = new Item(new Item.Settings());
		@RegistryName("ionite_ingot")
		public static final Item IoniteIngot = new Item(new Item.Settings());
		@RegistryName("ionite_nugget")
		public static final Item IoniteNugget = new Item(new Item.Settings());

		@RegistryName("raw_kelerium")
		public static final Item KeleriumRaw = new Item(new Item.Settings());
		@RegistryName("kelerium_ingot")
		public static final Item KeleriumIngot = new Item(new Item.Settings());

		@RegistryName("lommite_crystal")
		public static final Item LommiteCrystal = new Item(new Item.Settings());
		@RegistryName("lommite_dust")
		public static final Item LommiteDust = new Item(new Item.Settings());

		@RegistryName("plasteel_ingot")
		public static final Item PlasteelIngot = new Item(new Item.Settings());
		@RegistryName("plasteel_nugget")
		public static final Item PlasteelNugget = new Item(new Item.Settings());

		@RegistryName("raw_rubindum")
		public static final Item RubindumRaw = new Item(new Item.Settings());
		@RegistryName("rubindum_shard")
		public static final Item RubindumShard = new Item(new Item.Settings());

		@RegistryName("thorilide_crystal")
		public static final Item ThorilideCrystal = new Item(new Item.Settings());
		@RegistryName("thorilide_dust")
		public static final Item ThorilideDust = new Item(new Item.Settings());

		@RegistryName("raw_titanium")
		public static final Item TitaniumRaw = new Item(new Item.Settings());
		@RegistryName("titanium_ingot")
		public static final Item TitaniumIngot = new Item(new Item.Settings());
		@RegistryName("titanium_nugget")
		public static final Item TitaniumNugget = new Item(new Item.Settings());
		@RegistryName("titanium_shovel")
		public static final ToolItem TitaniumShovel = new ShovelItem(TitaniumToolMaterial.INSTANCE, 1.5F, -3.0F, new Item.Settings());
		@RegistryName("titanium_pickaxe")
		public static final ToolItem TitaniumPickaxe = new PPickaxeItem(TitaniumToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings());
		@RegistryName("titanium_axe")
		public static final ToolItem TitaniumAxe = new PAxeItem(TitaniumToolMaterial.INSTANCE, 5, -3.0F, new Item.Settings());
		@RegistryName("titanium_hoe")
		public static final ToolItem TitaniumHoe = new PHoeItem(TitaniumToolMaterial.INSTANCE, 0, 0.0F, new Item.Settings());

		@RegistryName("transparisteel_ingot")
		public static final Item TransparisteelIngot = new Item(new Item.Settings());

		@RegistryName("zersium_crystal")
		public static final Item ZersiumCrystal = new Item(new Item.Settings());
		@RegistryName("zersium_dust")
		public static final Item ZersiumDust = new Item(new Item.Settings());
	}

	@RegistryOrder(6)
	public static class Natural
	{
		@RegistryName("stripped_japor_branch")
		public static final Item StrippedJaporBranch = new Item(new Item.Settings());
		@RegistryName("molo_flower")
		public static final Item MoloFlower = new Item(new Item.Settings());
		@RegistryName("salt_pile")
		public static final Item SaltPile = new Item(new Item.Settings());
	}

	@RegistryOrder(7)
	public static class Seeds
	{
		@RegistryName("chasuka_seeds")
		public static final Item ChasukaSeeds = new AliasedBlockItem(SwgBlocks.Plant.Chasuka, new Item.Settings());
	}

	@RegistryOrder(8)
	public static class FoodPrep
	{
		@RegistryName("durasteel_cup")
		public static final Item DurasteelCup = new Item(new Item.Settings());
		@RegistryName("desh_cup")
		public static final Item DeshCup = new Item(new Item.Settings());
		@RegistryName("cup")
		public static final DyedItems Cups = new DyedItems(color -> new Item(new Item.Settings()));
		@RegistryName("glass")
		public static final NumberedItems Glasses = new NumberedItems(10, i -> new Item(new Item.Settings()));
		@RegistryName("glass_bottle")
		public static final NumberedItems GlassBottles = new NumberedItems(3, i -> new Item(new Item.Settings()));
		@RegistryName("plastic_bottle")
		public static final NumberedItems PlasticBottles = new NumberedItems(2, i -> new Item(new Item.Settings()));
	}

	@RegistryOrder(9)
	public static class Food
	{
		@RegistryName("jogan_fruit")
		public static final Item JoganFruit = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build()));
		@RegistryName("chasuka_leaf")
		public static final Item ChasukaLeaf = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build()));
		@RegistryName("meiloorun")
		public static final Item Meiloorun = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build()));

		@RegistryName("mynock_wing")
		public static final Item MynockWing = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).meat().build()));
		@RegistryName("cooked_mynock_wing")
		public static final Item FriedMynockWing = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).meat().build()));
		@RegistryName("bantha_chop")
		public static final Item BanthaChop = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).meat().build()));
		@RegistryName("cooked_bantha_chop")
		public static final Item BanthaSteak = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).meat().build()));
		@RegistryName("nerf_chop")
		public static final Item NerfChop = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).meat().build()));
		@RegistryName("cooked_nerf_chop")
		public static final Item NerfSteak = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).meat().build()));
		@RegistryName("gizka_chop")
		public static final Item GizkaChop = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).meat().build()));
		@RegistryName("cooked_gizka_chop")
		public static final Item GizkaSteak = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).meat().build()));

		// TODO: are these meat?
		@RegistryName("flangth_takeout")
		public static final Item FlangthTakeout = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).meat().build()));
		@RegistryName("flangth_plate")
		public static final Item FlangthPlate = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.8F).meat().build()));

		@RegistryName("death_stick_red")
		public static final Item DeathStickRed = new LiquidFoodItem(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).snack().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 200), 1).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200), 1).build()));
		@RegistryName("death_stick_yellow")
		public static final Item DeathStickYellow = new LiquidFoodItem(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).snack().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200), 1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 1).build()));

		@RegistryName("mysterious_smoothie")
		public static final Item MysteriousSmoothie = new LiquidFoodItem(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).snack().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200), 1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.5f).build()));
		@RegistryName("kreetlejuice")
		public static final Item Kreetlejuice = new LoreLiquidFoodItem(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).snack().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 200), 1).build()));

		@RegistryName("absynthesized_malt")
		public static final Item AbsynthesizedMalt = new LiquidFoodItem(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).snack().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200), 1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.5f).build()));
		@RegistryName("coronet_cocktail")
		public static final Item CoronetCocktail = new LiquidFoodItem(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).snack().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200), 1).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.5f).build()));

		@RegistryName("classic_soda")
		public static final Item ClassicSoda = new LiquidFoodItem(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).snack().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200), 1).build()));
		@RegistryName("diet_soda")
		public static final Item DietSoda = new LiquidFoodItem(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).snack().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200), 1).build()));
		@RegistryName("citrus_soda")
		public static final Item CitrusSoda = new LiquidFoodItem(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).snack().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200), 1).build()));

		@RegistryName("bottled_water")
		public static final Item BottledWater = new LiquidFoodItem(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).snack().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200), 1).build()));

		// TODO: consider turning this into a Fluid
		@RegistryName("blue_milk")
		public static final Item BlueMilk = new LiquidFoodItem(new Item.Settings().food(new FoodComponent.Builder().hunger(4).snack().saturationModifier(0.3F).build()));
		@RegistryName("blue_milk_glass")
		public static final Item BlueMilkGlass = new LiquidFoodItem(new Item.Settings().food(new FoodComponent.Builder().hunger(4).snack().saturationModifier(0.3F).build()));
		@RegistryName("blue_yogurt")
		public static final Item BlueYogurt = new LiquidFoodItem(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build()));
		@RegistryName("bantha_cookie")
		public static final Item BanthaCookie = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6F).build()));

		@RegistryName("qrikki_bread")
		public static final Item QrikkiBread = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6F).build()));
		@RegistryName("qrikki_waffle")
		public static final Item QrikkiWaffle = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.7F).build()));

		@RegistryName("ahrisa_bowl")
		public static final Item AhrisaBowl = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build()));
		@RegistryName("black_melon")
		public static final Item BlackMelon = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).build()));
		@RegistryName("desert_plums")
		public static final Item DesertPlums = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).build()));
		@RegistryName("dried_poonten_grass_bushel")
		public static final Item DriedPoontenGrass = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).build()));
		@RegistryName("haroun_bread")
		public static final Item HarounBread = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(5).saturationModifier(0.3F).build()));
		@RegistryName("hkak_bean")
		public static final Item HkakBean = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).build()));
		@RegistryName("pallie_fruit")
		public static final Item PallieFruit = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).build()));
		@RegistryName("pika_fruit")
		public static final Item PikaFruit = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).build()));
		@RegistryName("tuber")
		public static final Item Tuber = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).build()));
		@RegistryName("cooked_eopie_loin")
		public static final Item CookedEopieLoin = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.3F).build()));
		@RegistryName("crispy_gorg")
		public static final Item CrispyGorg = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.3F).build()));
		@RegistryName("dewback_egg")
		public static final Item DewbackEgg = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build()));
		@RegistryName("dewback_omelette")
		public static final Item DewbackOmelette = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.3F).build()));
		@RegistryName("jerba_rack")
		public static final Item JerbaRack = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build()));
		@RegistryName("jerba_rib")
		public static final Item JerbaRib = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.3F).build()));
		@RegistryName("krayt_meat")
		public static final Item KraytMeat = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.3F).build()));
		@RegistryName("raw_sketto_nugget")
		public static final Item RawSkettoNugget = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).build()));
		@RegistryName("roast_krayt")
		public static final Item RoastKrayt = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(8).saturationModifier(0.3F).build()));
		@RegistryName("ronto_chuck")
		public static final Item RontoChuck = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).build()));
		@RegistryName("tuber_mash")
		public static final Item TuberMash = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(4).saturationModifier(0.3F).build()));
		@RegistryName("vaporator_mushroom")
		public static final Item VaporatorMushroom = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).build()));
		@RegistryName("worrt_egg")
		public static final Item WorrtEgg = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).build()));
		@RegistryName("deb_deb")
		public static final Item DebDeb = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).build()));
		@RegistryName("eopie_loin")
		public static final Item EopieLoin = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).build()));
		@RegistryName("hubba_gourd")
		public static final Item HubbaGourd = new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3F).build()));
	}

	@RegistryOrder(10)
	public static class MobDrops
	{
		@RegistryName("faa_bucket")
		public static final Item FaaBucket = new EntityBucketItem(SwgEntities.Fish.Faa, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, (new Item.Settings()).maxCount(1));
		@RegistryName("laa_bucket")
		public static final Item LaaBucket = new EntityBucketItem(SwgEntities.Fish.Laa, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, (new Item.Settings()).maxCount(1));
		@RegistryName("corpse_of_gorg")
		public static final Item CorpseOfGorg = new Item(new Item.Settings());
		@RegistryName("bantha_horn")
		public static final Item BanthaHorn = new Item(new Item.Settings());
		@RegistryName("dewback_bone")
		public static final Item DewbackBone = new Item(new Item.Settings());
		@RegistryName("dewback_bone_shard")
		public static final Item DewbackBoneShard = new Item(new Item.Settings());
		@RegistryName("eye_of_sketto")
		public static final Item EyeOfSketto = new Item(new Item.Settings());
		@RegistryName("hide")
		public static final Item Hide = new Item(new Item.Settings());
		@RegistryName("krayt_pearl")
		public static final Item KraytPearl = new Item(new Item.Settings());
		@RegistryName("krayt_tooth")
		public static final Item KraytTooth = new Item(new Item.Settings());
		@RegistryName("kreetle_husk")
		public static final Item KreetleHusk = new Item(new Item.Settings());
		@RegistryName("lizard_gizzard")
		public static final Item LizardGizzard = new Item(new Item.Settings());
		@RegistryName("squill_liver")
		public static final Item SquillLiver = new Item(new Item.Settings());
		@RegistryName("tongue_of_worrt")
		public static final Item TongueOfWorrt = new Item(new Item.Settings());
		@RegistryName("tough_hide")
		public static final Item ToughHide = new Item(new Item.Settings());
	}

	@RegistryOrder(11)
	public static class Blaster
	{
		@RegistryName("small_power_pack")
		@TabInclude("pswg:blasters")
		public static final BlasterPowerPackItem SmallPowerPack = new BlasterPowerPackItem(75, new Item.Settings());
	}

	@RegistryOrder(12)
	public static class Spawners
	{
		@RegistryName("spawn_xwing_t65b")
		public static final Item XwingT65b = new SpawnEntityItem(SwgEntities.Ship.T65bXwing, new Item.Settings(), 3);

		@RegistryName("spawn_landspeeder_x34")
		public static final Item LandspeederX34 = new SpawnEntityItem(SwgEntities.Speeder.X34, new Item.Settings(), 0);

		@RegistryName("spawn_zephyr_j")
		public static final Item ZephyrJ = new SpawnEntityItem(SwgEntities.Speeder.ZephyrJ, new Item.Settings(), 0);

		@RegistryName("spawn_faa")
		public static final Item Faa = new SpawnEggItem(SwgEntities.Fish.Faa, 0xE9933E, 0x9471EB, new Item.Settings());

		@RegistryName("spawn_laa")
		public static final Item Laa = new SpawnEggItem(SwgEntities.Fish.Laa, 0x2F5747, 0xD5BC92, new Item.Settings());

		@RegistryName("spawn_worrt")
		public static final Item Worrt = new SpawnEggItem(SwgEntities.Amphibian.Worrt, 0x5B482C, 0x635735, new Item.Settings());

		@RegistryName("spawn_bantha")
		public static final Item Bantha = new SpawnEggItem(SwgEntities.Mammal.Bantha, 0x362318, 0xD1B693, new Item.Settings());

		@RegistryName("spawn_sand_skitter")
		public static final Item SandSkitter = new SpawnEggItem(SwgEntities.Rodent.SandSkitter, 0x4F3733, 0xE2946E, new Item.Settings());
	}

	@RegistryOrder(13)
	public static class Lightsaber
	{
		@RegistryName("lightsaber")
		@TabInclude("pswg:lightsabers")
		public static final LightsaberItem Lightsaber = new LightsaberItem(new Item.Settings().maxCount(1));
	}

	static HashMap<Identifier, ArrayList<ItemConvertible>> ITEM_GROUPS = new HashMap<>();

	public static void register()
	{
		RegistryHelper.registerAutoId(Resources.MODID, SwgItems.class, Object.class, SwgItems::tryRegisterItem);

		for (var entry : ITEM_GROUPS.entrySet())
		{
			var group = entry.getKey();
			var items = entry.getValue();

			ItemGroupEvents.modifyEntriesEvent(group).register(entries -> {
				for (var item : items)
					if (item instanceof ITabStackProvider customStacks)
						customStacks.appendStacks(entries);
					else
						entries.add(item);
			});
		}
	}

	public static void tryRegisterItem(Object o, Identifier identifier, boolean ignoreTab, String tabOverride)
	{
		if (o instanceof Item item)
			registerWithTab(identifier, item, ignoreTab, tabOverride);
		else if (o instanceof ArmorItems armorItems)
		{
			registerWithTab(new Identifier(identifier.getNamespace(), identifier.getPath() + "_helmet"), armorItems.helmet, ignoreTab, tabOverride);
			registerWithTab(new Identifier(identifier.getNamespace(), identifier.getPath() + "_chestplate"), armorItems.chestplate, ignoreTab, tabOverride);
			registerWithTab(new Identifier(identifier.getNamespace(), identifier.getPath() + "_leggings"), armorItems.leggings, ignoreTab, tabOverride);
			registerWithTab(new Identifier(identifier.getNamespace(), identifier.getPath() + "_boots"), armorItems.boots, ignoreTab, tabOverride);
		}
		else if (o instanceof DyedItems items)
			for (var entry : items.entrySet())
				registerWithTab(new Identifier(identifier.getNamespace(), entry.getKey().getName() + "_" + identifier.getPath()), entry.getValue(), ignoreTab, tabOverride);
		else if (o instanceof NumberedItems items)
			for (var i = 0; i < items.size(); i++)
				registerWithTab(new Identifier(identifier.getNamespace(), identifier.getPath() + "_" + (i + 1)), items.get(i), ignoreTab, tabOverride);
	}

	private static void registerWithTab(Identifier identifier, Item item, boolean ignoreTab, String tabOverride)
	{
		if (!ignoreTab)
		{
			var tab = tabOverride == null ? Galaxies.TabItems.getId() : new Identifier(tabOverride);
			if (!ITEM_GROUPS.containsKey(tab))
				ITEM_GROUPS.put(tab, new ArrayList<>());

			ITEM_GROUPS.get(tab).add(item);
		}

		Registry.register(Registries.ITEM, identifier, item);
	}

	public static void registerAddons()
	{
		for (var blaster : PswgContent.getBlasterPresets().entrySet())
		{
			var id = blaster.getKey();
			registerWithTab(
					new Identifier(id.getNamespace(), "blaster_" + id.getPath()),
					new BlasterItem(new Item.Settings().maxCount(1), id, blaster.getValue()),
					false,
					Galaxies.TabBlasters.getId().toString()
			);
		}
	}
}
