package com.example.addon;

import com.example.addon.blocks.AdventureBlocks;
import com.example.addon.blocks.entity.AdventureBlockEntities;
import com.example.addon.entity.AdventureVillagers;
import com.example.addon.entity.TestEntities;
import com.example.addon.items.AdventureItems;
import com.example.addon.recipe.ModRecipes;
import com.example.addon.recipe.TestRecipeType;
import com.example.addon.screen.ModScreenHandlers;
import com.example.addon.util.AdventureStatistics;
import com.example.addon.util.AdventureTags;
import com.example.addon.util.PlanetGuiCommandRunner;
import com.parzivail.pswg.api.PswgAddon;
import com.parzivail.pswg.container.SwgItems;
import com.parzivail.util.Lumberjack;
import com.parzivail.util.registry.RegistryHelper;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAddon implements PswgAddon
{
	public static final String MODID = "pswg-adventures";
	public static final Lumberjack LOG = new Lumberjack(MODID);

	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static Item PSWGADDON_TAB_ITEM = Registry.register(Registries.ITEM, TestAddon.id("alloygery_tab_item"), new Item(new Item.Settings()));


	@Override
	public void onPswgReady()
	{
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			MinecraftClient client = MinecraftClient.getInstance();
			PlanetGuiCommandRunner commandRunner = new PlanetGuiCommandRunner(client);
			commandRunner.checkPlayerYLevel();
		});

		AdventureItems.registerModItems();
		AdventureBlocks.registerModBlocks();



		AdventureVillagers.registerVillagers();
		AdventureVillagers.registerTrades();

		TestEntities.register();

		AdventureBlockEntities.registerAllBlockEntities();

		ModScreenHandlers.registerAllScreenHandlers();
		ModRecipes.registerRecipes();
		TestRecipeType.register();

		AdventureStatistics.register();
		AdventureTags.register();



		RegistryHelper.registerAutoId(MODID, AdventureItems.class, Object.class, SwgItems::tryRegisterItem);

		LOG.log("PSWG Legends Enabled!");
	}
	public static Identifier id(String path)
	{
		return new Identifier(MODID, path);
	}
}
