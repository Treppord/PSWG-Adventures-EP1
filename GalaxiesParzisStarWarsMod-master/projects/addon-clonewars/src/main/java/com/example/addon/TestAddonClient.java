package com.example.addon;

import com.example.addon.client.CloneArmorTransformer;
import com.example.addon.screen.ArmorStationScreen;
import com.example.addon.screen.ModScreenHandlers;
import com.parzivail.pswg.api.PswgClientAddon;
import com.parzivail.pswg.client.render.armor.ArmorRenderer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

public class TestAddonClient implements PswgClientAddon
{
	@Override
	public void onPswgClientReady()
	{
		TestAddon.LOG.log("Hello, Client World!");
		BlockRenderLayerMap.INSTANCE.putBlock(TestBlocks.ARMOR_STATION, RenderLayer.getCutout());
		ScreenRegistry.register(ModScreenHandlers.ARMOR_STATION_SCREEN_HANDLER, ArmorStationScreen::new);

		var cloneArmorAssets = new ArmorRenderer.Assets(
				TestAddon.id("armor/clonetrooper"),
				TestAddon.id("textures/armor/clonetrooper.png")
		);

		var clonePhase1ArmorModelKey = TestAddon.id("phase1_clone");
		ArmorRenderer.register(
				TestItems.Armor.Phase1Clone,
				clonePhase1ArmorModelKey,
				cloneArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(clonePhase1ArmorModelKey, new CloneArmorTransformer(false));

		var clonePhase2ArmorModelKey = TestAddon.id("phase2_clone");
		ArmorRenderer.register(
				TestItems.Armor.Phase2Clone,
				clonePhase2ArmorModelKey,
				cloneArmorAssets,
				new ArmorRenderer.Metadata(ArmorRenderer.ArmThicknessAction.AUTO_THICKNESS, ArmorRenderer.FemaleChestplateAction.HIDE_CUBE)
		);
		ArmorRenderer.registerTransformer(clonePhase2ArmorModelKey, new CloneArmorTransformer(true));
	}
}