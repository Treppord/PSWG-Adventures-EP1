package com.example.addon;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;

public class ModStatistics
{
    public static final Identifier INTERACT_WITH_SMITHING_ANVIL = TestAddon.id("interact_with_smithing_anvil");

    public static void register()
    {
        Registry.register(Registries.CUSTOM_STAT, "interact_with_smithing_anvil", INTERACT_WITH_SMITHING_ANVIL);

        Stats.CUSTOM.getOrCreateStat(INTERACT_WITH_SMITHING_ANVIL, StatFormatter.DEFAULT);
    }
}