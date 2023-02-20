package com.example.addon;

import com.example.addon.entity.TestEntities;
import com.example.addon.recipe.ModRecipes;
import com.example.addon.recipe.TestRecipeType;
import com.example.addon.screen.ModScreenHandlers;
import com.parzivail.pswg.api.PswgAddon;
import com.parzivail.pswg.container.SwgItems;
import com.parzivail.util.Lumberjack;
import com.parzivail.util.registry.RegistryHelper;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAddon implements PswgAddon
{
	public static final String MODID = "pswg-addon-test";
	public static final Lumberjack LOG = new Lumberjack(MODID);

	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static Item PSWGADDON_TAB_ITEM = Registry.register(Registries.ITEM, TestAddon.id("alloygery_tab_item"), new Item(new Item.Settings()));


	@Override
	public void onPswgReady()
	{
		TestItems.registerModItems();
		TestBlocks.registerModBlocks();



		TestVillagers.registerVillagers();
		TestVillagers.registerTrades();

		TestEntities.register();

		TestAddonEntities.registerAllBlockEntities();

		ModScreenHandlers.registerAllScreenHandlers();
		ModRecipes.registerRecipes();
		TestRecipeType.register();

		ModStatistics.register();
		TestTags.register();



		RegistryHelper.registerAutoId(MODID, TestItems.class, Object.class, SwgItems::tryRegisterItem);

		LOG.log("PSWG Legends Enabled!");
	}
	public static Identifier id(String path)
	{
		return new Identifier(MODID, path);
	}
}
