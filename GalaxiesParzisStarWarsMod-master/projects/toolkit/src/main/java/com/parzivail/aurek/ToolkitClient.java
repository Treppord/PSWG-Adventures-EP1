package com.parzivail.aurek;

import com.google.common.collect.ImmutableList;
import com.parzivail.aurek.imgui.ToolkitHomeScreen;
import com.parzivail.aurek.ui.NemiCompilerScreen;
import com.parzivail.aurek.ui.ToolkitWorldgenScreen;
import com.parzivail.aurek.util.LangUtil;
import com.parzivail.pswg.Resources;
import com.parzivail.pswg.api.PswgClientAddon;
import com.parzivail.util.Lumberjack;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class ToolkitClient implements PswgClientAddon
{
	public static class Tool
	{
		private final String id;
		private final Function<Screen, Screen> screenProvider;

		public Tool(String id, Function<Screen, Screen> screenProvider)
		{
			this.id = id;
			this.screenProvider = screenProvider;
		}

		public String getTitle()
		{
			return LangUtil.translate("tool.title." + id);
		}

		public String getDescription()
		{
			return LangUtil.translate("tool.description." + id);
		}

		public Screen getScreen()
		{
			var mc = MinecraftClient.getInstance();
			return screenProvider.apply(mc.currentScreen);
		}
	}

	//	public static final ExecutorService UI_WORKER = WorkerUtil.createWorker("ui", 1);
	//	public static final ExecutorService WORLDGEN_WORKER = WorkerUtil.createWorker("worldgen", 8);

	public static final String MODID = "aurek";
	public static final Lumberjack LOG = new Lumberjack(MODID);

	public static final String I18N_TOOLKIT = Resources.screen("toolkit");
	public static final Identifier TEX_TOOLKIT = id("textures/gui/toolkit_button.png");
	public static final Identifier TEX_DEBUG = id("textures/debug.png");

	public static final HashMap<String, List<Tool>> TOOLS = new HashMap<>();

	static
	{
		TOOLS.put(LangUtil.translate("tool.category.modeling"), ImmutableList.of(
				new Tool("nemi_compiler", NemiCompilerScreen::new),
				new Tool("p3di_compiler", null)
		));
		TOOLS.put(LangUtil.translate("tool.category.worldgen"), ImmutableList.of(
				new Tool("worldgen_visualizer", ToolkitWorldgenScreen::new)
		));
	}

	public static Screen createHomeScreen(Screen parent)
	{
		return new ToolkitHomeScreen(parent);
	}

	public static Identifier id(String path)
	{
		return new Identifier(MODID, path);
	}

	@Override
	public void onPswgClientReady()
	{
	}
}
