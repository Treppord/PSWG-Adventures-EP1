package com.trep.addon;

import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil.Test;

import com.parzivail.pswg.api.PswgClientAddon;
import com.parzivail.pswg.client.render.armor.ArmorRenderer;
import com.trep.addon.blocks.AdventureBlocks;
import com.trep.addon.client.Clone2ArmorTransformer;
import com.trep.addon.client.JediArmorTransformer;
import com.trep.addon.client.Mando1ArmorTransformer;
import com.trep.addon.client.VaderArmorTransformer;
import com.trep.addon.entity.CloneEntityRenderer;
import com.trep.addon.entity.DroidEntityRenderer;
import com.trep.addon.entity.TestEntities;
import com.trep.addon.items.AdventureItems;
import com.trep.addon.screen.*;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class TestAddonClient implements PswgClientAddon {
	@Override
	public void onPswgClientReady() {
		TrinketRendererRegistry.registerRenderer(TestAddon.TEST_TRINKET, (TrinketRenderer) TestAddon.TEST_TRINKET);
		TrinketRendererRegistry.registerRenderer(TestAddon.TEST_TRINKET_2, (TrinketRenderer) TestAddon.TEST_TRINKET_2);
		TrinketRendererRegistry.registerRenderer(TestAddon.TEST_TRINKET_3, (TrinketRenderer) TestAddon.TEST_TRINKET_3);
		TrinketRendererRegistry.registerRenderer(TestAddon.TEST_TRINKET_4, (TrinketRenderer) TestAddon.TEST_TRINKET_4);
		TrinketRendererRegistry.registerRenderer(TestAddon.TEST_TRINKET_5, (TrinketRenderer) TestAddon.TEST_TRINKET_5);
		TrinketRendererRegistry.registerRenderer(TestAddon.TEST_TRINKET_6, (TrinketRenderer) TestAddon.TEST_TRINKET_6);
		TrinketRendererRegistry.registerRenderer(TestAddon.TEST_TRINKET_7, (TrinketRenderer) TestAddon.TEST_TRINKET_7);

		var cloneArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/clonetrooper"),
				TestAddon.id("textures/armor/clonetrooper.png"));

		var beskarArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando.png")

		);

		var cyanbeskarArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/cyanmando.png")

		);

		var bluebeskarArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/bluemando.png")

		);

		var redbeskarArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/redmando.png")

		);

		var vaderArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/vader"),
				TestAddon.id("textures/armor/vader.png"));

		var jediArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/jedi"),
				TestAddon.id("textures/armor/jedi.png"));


		var jedirobeArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/jedi"),
				TestAddon.id("textures/armor/jedi_robe.png"));
		var sithrobeArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/jedi"),
				TestAddon.id("textures/armor/sith_robe.png"));

		var bobaArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/boba.png")

		);

		var mandoblackArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_black.png")

		);

		var mandoblueArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_blue.png")

		);

		var mandobrownArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_brown.png")

		);

		var mandocyanArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_cyan.png")

		);

		var mandograyArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_gray.png")

		);

		var mandogreenArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_green.png")

		);

		var mandolight_blueArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_light_blue.png")

		);

		var mandolight_grayArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_light_gray.png")

		);

		var mandolimeArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_lime.png")

		);

		var mandomagentaArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_magenta.png")

		);

		var mandoorangeArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_orange.png")

		);

		var mandopinkArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_pink.png")

		);

		var mandopurpleArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_purple.png")

		);

		var mandoredArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_red.png")

		);

		var mandowhiteArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_white.png")

		);

		var mandoyellowArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/mando_var/mando_yellow.png")

		);

		var clonePhase1ArmorModelKey = TestAddon.id("beskar_alloy");
		ArmorRenderer.register(
				AdventureItems.Armor.PhaseAClone,
				clonePhase1ArmorModelKey,
				cloneArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(clonePhase1ArmorModelKey, new Clone2ArmorTransformer(false));

		var clonePhase2ArmorModelKey = TestAddon.id("beskar_alloy_alternative");
		ArmorRenderer.register(
				AdventureItems.Armor.PhaseBClone,
				clonePhase2ArmorModelKey,
				cloneArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(clonePhase2ArmorModelKey, new Clone2ArmorTransformer(true));

		var MandoArmorModelKey = TestAddon.id("mando");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandalorian,
				MandoArmorModelKey,
				beskarArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(MandoArmorModelKey, new Mando1ArmorTransformer());

		var CyanMandoArmorModelKey = TestAddon.id("cyanmando");
		ArmorRenderer.register(
				AdventureItems.Armor.CyanMandalorian,
				CyanMandoArmorModelKey,
				cyanbeskarArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(CyanMandoArmorModelKey, new Mando1ArmorTransformer());

		var RedMandoArmorModelKey = TestAddon.id("redmando");
		ArmorRenderer.register(
				AdventureItems.Armor.RedMandalorian,
				RedMandoArmorModelKey,
				redbeskarArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(RedMandoArmorModelKey, new Mando1ArmorTransformer());

		var BlueMandoArmorModelKey = TestAddon.id("bluemando");
		ArmorRenderer.register(
				AdventureItems.Armor.BlueMandalorian,
				BlueMandoArmorModelKey,
				bluebeskarArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(BlueMandoArmorModelKey, new Mando1ArmorTransformer());

		var VaderArmorModelKey = TestAddon.id("vader");
		ArmorRenderer.register(
				AdventureItems.Armor.VADER,
				VaderArmorModelKey,
				vaderArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(VaderArmorModelKey, new VaderArmorTransformer());

		var JediArmorModelKey = TestAddon.id("jedi");
		ArmorRenderer.register(
				AdventureItems.Armor.Jedi,
				JediArmorModelKey,
				jediArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(JediArmorModelKey, new JediArmorTransformer());

		var JediRobeArmorModelKey = TestAddon.id("jedi_robe");
		ArmorRenderer.register(
				AdventureItems.Armor.JediRobe,
				JediRobeArmorModelKey,
				jedirobeArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(JediRobeArmorModelKey, new JediArmorTransformer());

		var SithRobeArmorModelKey = TestAddon.id("sith_robe");
		ArmorRenderer.register(
				AdventureItems.Armor.SithRobe,
				SithRobeArmorModelKey,
				sithrobeArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(SithRobeArmorModelKey, new JediArmorTransformer());

		var BobaArmorModelKey = TestAddon.id("boba");
		ArmorRenderer.register(
				AdventureItems.Armor.Boba,
				BobaArmorModelKey,
				bobaArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(BobaArmorModelKey, new Mando1ArmorTransformer());

		var MandoblackArmorModelKey = TestAddon.id("mando_black");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandalorianblack,
				MandoblackArmorModelKey,
				mandoblackArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(MandoblackArmorModelKey, new Mando1ArmorTransformer());

		var MandoblueArmorModelKey = TestAddon.id("mando_blue");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandalorianblue,
				MandoblueArmorModelKey,
				mandoblueArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(MandoblueArmorModelKey, new Mando1ArmorTransformer());

		var MandobrownArmorModelKey = TestAddon.id("mando_brown");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandalorianbrown,
				MandobrownArmorModelKey,
				mandobrownArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(MandobrownArmorModelKey, new Mando1ArmorTransformer());

		var MandocyanArmorModelKey = TestAddon.id("mando_cyan");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandaloriancyan,
				MandocyanArmorModelKey,
				mandocyanArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(MandocyanArmorModelKey, new Mando1ArmorTransformer());

		var MandograyArmorModelKey = TestAddon.id("mando_gray");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandaloriangray,
				MandograyArmorModelKey,
				mandograyArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(MandograyArmorModelKey, new Mando1ArmorTransformer());

		var MandogreenArmorModelKey = TestAddon.id("mando_green");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandaloriangreen,
				MandogreenArmorModelKey,
				mandogreenArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(MandogreenArmorModelKey, new Mando1ArmorTransformer());

		var Mandolight_blueArmorModelKey = TestAddon.id("mando_light_blue");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandalorianlight_blue,
				Mandolight_blueArmorModelKey,
				mandolight_blueArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(Mandolight_blueArmorModelKey, new Mando1ArmorTransformer());

		var Mandolight_grayArmorModelKey = TestAddon.id("mando_light_gray");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandalorianlight_gray,
				Mandolight_grayArmorModelKey,
				mandolight_grayArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(Mandolight_grayArmorModelKey, new Mando1ArmorTransformer());

		var MandolimeArmorModelKey = TestAddon.id("mando_lime");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandalorianlime,
				MandolimeArmorModelKey,
				mandolimeArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(MandolimeArmorModelKey, new Mando1ArmorTransformer());

		var MandomagentaArmorModelKey = TestAddon.id("mando_magenta");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandalorianmagenta,
				MandomagentaArmorModelKey,
				mandomagentaArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(MandomagentaArmorModelKey, new Mando1ArmorTransformer());

		var MandoorangeArmorModelKey = TestAddon.id("mando_orange");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandalorianorange,
				MandoorangeArmorModelKey,
				mandoorangeArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(MandoorangeArmorModelKey, new Mando1ArmorTransformer());

		var MandopinkArmorModelKey = TestAddon.id("mando_pink");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandalorianpink,
				MandopinkArmorModelKey,
				mandopinkArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(MandopinkArmorModelKey, new Mando1ArmorTransformer());

		var MandopurpleArmorModelKey = TestAddon.id("mando_purple");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandalorianpurple,
				MandopurpleArmorModelKey,
				mandopurpleArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(MandopurpleArmorModelKey, new Mando1ArmorTransformer());

		var MandoredArmorModelKey = TestAddon.id("mando_red");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandalorianred,
				MandoredArmorModelKey,
				mandoredArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(MandoredArmorModelKey, new Mando1ArmorTransformer());

		var MandowhiteArmorModelKey = TestAddon.id("mando_white");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandalorianwhite,
				MandowhiteArmorModelKey,
				mandowhiteArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(MandowhiteArmorModelKey, new Mando1ArmorTransformer());

		var MandoyellowArmorModelKey = TestAddon.id("mando_yellow");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandalorianyellow,
				MandoyellowArmorModelKey,
				mandoyellowArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS,
						ArmorRenderer.FemaleChestplateAction.HIDE_CUBE));
		ArmorRenderer.registerTransformer(MandoyellowArmorModelKey, new Mando1ArmorTransformer());

		TestAddon.LOG.log("Hello, Client World!");
		BlockRenderLayerMap.INSTANCE.putBlock(AdventureBlocks.ARMOR_STATION, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(AdventureBlocks.MARKET_STATION, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(AdventureBlocks.BLASTER_TABLE, RenderLayer.getCutout());

		ScreenRegistry.register(ModScreenHandlers.ARMOR_STATION_SCREEN_HANDLER, ArmorStationScreen::new);
		ScreenRegistry.register(ModScreenHandlers.MARKET_STATION_SCREEN_HANDLER, MarketScreen::new);
		ScreenRegistry.register(ModScreenHandlers.BLASTER_TABLE_SCREEN_HANDLER, BlasterTableScreen::new);

		ScreenRegistry.register(ModScreenHandlers.SMITHING_ANVIL_SCREEN_HANDLER_TYPE, FabricatorScreen::new);

		EntityRendererRegistry.register(TestEntities.Clones.Clone, CloneEntityRenderer::new);
		EntityRendererRegistry.register(TestEntities.Droids.Droids, DroidEntityRenderer::new);
		EntityRendererRegistry.register(TestAddon.CustomSnowballEntityType,
				(context) -> new FlyingItemEntityRenderer(context));
		EntityRendererRegistry.register(TestAddon.ForceLightEntityType,
				(context) -> new FlyingItemEntityRenderer(context));
		EntityRendererRegistry.register(TestAddon.ForceDarkEntityType,
				(context) -> new FlyingItemEntityRenderer(context));
	}
}
