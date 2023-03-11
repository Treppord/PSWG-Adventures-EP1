package com.trep.addon.util;

import com.trep.addon.TestAddon;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;

public class AdventureTags
{
    public static TagKey<Item> HOLODRIVE;

    public static void register()
    {
        HOLODRIVE = TagKey.of(Registries.ITEM.getKey(), TestAddon.id("holodrive"));
    }
}
