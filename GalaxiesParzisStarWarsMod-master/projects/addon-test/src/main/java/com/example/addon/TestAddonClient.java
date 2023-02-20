package com.example.addon;

import com.example.addon.client.Clone2ArmorTransformer;
import com.example.addon.client.Mando1ArmorTransformer;
import com.example.addon.client.VaderArmorTransformer;
import com.example.addon.entity.CloneEntityRenderer;
import com.example.addon.entity.TestEntities;
import com.example.addon.screen.*;
import com.parzivail.pswg.api.PswgClientAddon;
import com.parzivail.pswg.client.render.armor.ArmorRenderer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

public class TestAddonClient implements PswgClientAddon
{
	@Override
	public void onPswgClientReady()
	{
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

		var clonePhase1ArmorModelKey = TestAddon.id("beskar_alloy");
		ArmorRenderer.register(
				TestItems.Armor.PhaseAClone,
				clonePhase1ArmorModelKey,
				cloneArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(clonePhase1ArmorModelKey, new Clone2ArmorTransformer(false));

		var clonePhase2ArmorModelKey = TestAddon.id("beskar_alloy_alternative");
		ArmorRenderer.register(
				TestItems.Armor.PhaseBClone,
				clonePhase2ArmorModelKey,
				cloneArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(clonePhase2ArmorModelKey, new Clone2ArmorTransformer(true));

		var MandoArmorModelKey = TestAddon.id("mando");
		ArmorRenderer.register(
				TestItems.Armor.Mandalorian,
				MandoArmorModelKey,
				beskarArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(MandoArmorModelKey, new Mando1ArmorTransformer());

		var CyanMandoArmorModelKey = TestAddon.id("cyanmando");
		ArmorRenderer.register(
				TestItems.Armor.CyanMandalorian,
				CyanMandoArmorModelKey,
				cyanbeskarArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(CyanMandoArmorModelKey, new Mando1ArmorTransformer());

		var RedMandoArmorModelKey = TestAddon.id("redmando");
		ArmorRenderer.register(
				TestItems.Armor.RedMandalorian,
				RedMandoArmorModelKey,
				redbeskarArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(RedMandoArmorModelKey, new Mando1ArmorTransformer());

		var BlueMandoArmorModelKey = TestAddon.id("bluemando");
		ArmorRenderer.register(
				TestItems.Armor.BlueMandalorian,
				BlueMandoArmorModelKey,
				bluebeskarArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(BlueMandoArmorModelKey, new Mando1ArmorTransformer());

		var VaderArmorModelKey = TestAddon.id("vader");
		ArmorRenderer.register(
				TestItems.Armor.VADER,
				VaderArmorModelKey,
				vaderArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(VaderArmorModelKey, new VaderArmorTransformer());

		TestAddon.LOG.log("Hello, Client World!");
		BlockRenderLayerMap.INSTANCE.putBlock(TestBlocks.ARMOR_STATION, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(TestBlocks.MARKET_STATION, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(TestBlocks.BLASTER_TABLE, RenderLayer.getCutout());


		ScreenRegistry.register(ModScreenHandlers.ARMOR_STATION_SCREEN_HANDLER, ArmorStationScreen::new);
		ScreenRegistry.register(ModScreenHandlers.MARKET_STATION_SCREEN_HANDLER, MarketScreen::new);
		ScreenRegistry.register(ModScreenHandlers.BLASTER_TABLE_SCREEN_HANDLER, BlasterTableScreen::new);

		ScreenRegistry.register(ModScreenHandlers.SMITHING_ANVIL_SCREEN_HANDLER_TYPE, FabricatorScreen::new);

		EntityRendererRegistry.register(TestEntities.Clones.Clone, CloneEntityRenderer::new);
	}
}
