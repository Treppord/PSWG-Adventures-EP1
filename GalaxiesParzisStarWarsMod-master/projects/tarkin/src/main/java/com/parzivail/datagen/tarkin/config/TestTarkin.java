package com.parzivail.datagen.tarkin.config;

import com.example.addon.TestAddon;
import com.example.addon.TestItems;
import com.parzivail.datagen.tarkin.*;
import com.parzivail.pswg.Config;
import com.parzivail.pswg.Resources;

import java.util.List;

public class TestTarkin
{
	public static void build(List<BuiltAsset> assets)
	{
		ItemGenerator.armor(TestItems.Armor.Phase1Clone, assets);
		ItemGenerator.armor(TestItems.Armor.Phase2Clone, assets);

		var lang = new LanguageBuilder(TestAddon.id(LanguageProvider.OUTPUT_LOCALE));

		// Species
		Tarkin.generateSpeciesLang(assets, lang, Resources.MODID);

		// Blaster attachments
		Tarkin.generateBlasterLang(assets, lang, Resources.MODID);

		// Autoconfig
		Tarkin.generateConfigLang(assets, lang, Config.class);
	}
}
