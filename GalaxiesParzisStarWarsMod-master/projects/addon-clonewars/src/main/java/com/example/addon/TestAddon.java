package com.example.addon;

import com.example.addon.recipe.ModRecipes;
import com.example.addon.screen.ModScreenHandlers;
import com.parzivail.pswg.api.PswgAddon;
import com.parzivail.pswg.api.PswgContent;
import com.parzivail.pswg.container.SwgItems;
import com.parzivail.pswg.item.blaster.data.*;
import com.parzivail.util.Lumberjack;
import com.parzivail.util.registry.RegistryHelper;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TestAddon implements PswgAddon
{
	public static final String MODID = "pswg-addon-test";
	public static final Lumberjack LOG = new Lumberjack(MODID);

	@Override
	public void onPswgReady()
	{
		TestItems.registerModItems();
		TestBlocks.registerModBlocks();
		TestAddonEntities.registerAllBlockEntities();
		ModRecipes.registerRecipes();
		ModScreenHandlers.registerAllScreenHandlers();
		RegistryHelper.registerAutoId(MODID, TestAddon.class, Object.class, SwgItems::tryRegisterItem);

		LOG.log("PSWG Legends Enabled!");

	}
	public static Identifier id(String path)
	{
		return new Identifier(MODID, path);
	}
}
