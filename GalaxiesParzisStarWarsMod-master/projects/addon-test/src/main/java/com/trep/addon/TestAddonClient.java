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

public class TestAddonClient implements PswgClientAddon
{
	@Override
	public void onPswgClientReady()
	{
		TrinketRendererRegistry.registerRenderer(TestAddon.TEST_TRINKET, (TrinketRenderer) TestAddon.TEST_TRINKET);
		TrinketRendererRegistry.registerRenderer(TestAddon.TEST_TRINKET_2, (TrinketRenderer) TestAddon.TEST_TRINKET_2);
		TrinketRendererRegistry.registerRenderer(TestAddon.TEST_TRINKET_3, (TrinketRenderer) TestAddon.TEST_TRINKET_3);
		TrinketRendererRegistry.registerRenderer(TestAddon.TEST_TRINKET_4, (TrinketRenderer) TestAddon.TEST_TRINKET_4);
		TrinketRendererRegistry.registerRenderer(TestAddon.TEST_TRINKET_5, (TrinketRenderer) TestAddon.TEST_TRINKET_5);
		TrinketRendererRegistry.registerRenderer(TestAddon.TEST_TRINKET_6, (TrinketRenderer) TestAddon.TEST_TRINKET_6);
		TrinketRendererRegistry.registerRenderer(TestAddon.TEST_TRINKET_7, (TrinketRenderer) TestAddon.TEST_TRINKET_7);

		var cloneArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/clonetrooper"),
				TestAddon.id("textures/armor/clonetrooper.png")
		);

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
				TestAddon.id("textures/armor/vader.png")
		);

		var jediArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/jedi"),
				TestAddon.id("textures/armor/jedi.png")
		);

		var bobaArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/mando"),
				TestAddon.id("textures/armor/boba.png")

		);




		var clonePhase1ArmorModelKey = TestAddon.id("beskar_alloy");
		ArmorRenderer.register(
				AdventureItems.Armor.PhaseAClone,
				clonePhase1ArmorModelKey,
				cloneArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(clonePhase1ArmorModelKey, new Clone2ArmorTransformer(false));

		var clonePhase2ArmorModelKey = TestAddon.id("beskar_alloy_alternative");
		ArmorRenderer.register(
				AdventureItems.Armor.PhaseBClone,
				clonePhase2ArmorModelKey,
				cloneArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(clonePhase2ArmorModelKey, new Clone2ArmorTransformer(true));

		var MandoArmorModelKey = TestAddon.id("mando");
		ArmorRenderer.register(
				AdventureItems.Armor.Mandalorian,
				MandoArmorModelKey,
				beskarArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(MandoArmorModelKey, new Mando1ArmorTransformer());

		var CyanMandoArmorModelKey = TestAddon.id("cyanmando");
		ArmorRenderer.register(
				AdventureItems.Armor.CyanMandalorian,
				CyanMandoArmorModelKey,
				cyanbeskarArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(CyanMandoArmorModelKey, new Mando1ArmorTransformer());

		var RedMandoArmorModelKey = TestAddon.id("redmando");
		ArmorRenderer.register(
				AdventureItems.Armor.RedMandalorian,
				RedMandoArmorModelKey,
				redbeskarArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(RedMandoArmorModelKey, new Mando1ArmorTransformer());

		var BlueMandoArmorModelKey = TestAddon.id("bluemando");
		ArmorRenderer.register(
				AdventureItems.Armor.BlueMandalorian,
				BlueMandoArmorModelKey,
				bluebeskarArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(BlueMandoArmorModelKey, new Mando1ArmorTransformer());

		var VaderArmorModelKey = TestAddon.id("vader");
		ArmorRenderer.register(
				AdventureItems.Armor.VADER,
				VaderArmorModelKey,
				vaderArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(VaderArmorModelKey, new VaderArmorTransformer());

		var JediArmorModelKey = TestAddon.id("jedi");
		ArmorRenderer.register(
				AdventureItems.Armor.Jedi,
				JediArmorModelKey,
				jediArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(JediArmorModelKey, new JediArmorTransformer());

		var BobaArmorModelKey = TestAddon.id("boba");
		ArmorRenderer.register(
				AdventureItems.Armor.Boba,
				BobaArmorModelKey,
				bobaArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(BobaArmorModelKey, new Mando1ArmorTransformer());



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
		EntityRendererRegistry.register(TestAddon.CustomSnowballEntityType, (context) ->
		new FlyingItemEntityRenderer(context));
		EntityRendererRegistry.register(TestAddon.ForceLightEntityType, (context) ->
		new FlyingItemEntityRenderer(context));
		EntityRendererRegistry.register(TestAddon.ForceDarkEntityType, (context) ->
		new FlyingItemEntityRenderer(context));
	}
}
