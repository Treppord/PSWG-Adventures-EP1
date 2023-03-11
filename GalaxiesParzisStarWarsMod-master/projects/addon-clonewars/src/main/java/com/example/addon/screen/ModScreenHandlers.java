package com.example.addon.screen;

import com.example.addon.TestAddon;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<ArmorStationScreenHandler> ARMOR_STATION_SCREEN_HANDLER;
    public static void registerAllScreenHandlers() {
        ARMOR_STATION_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(TestAddon.MODID, "armor_station"),
                        ArmorStationScreenHandler::new);
    }
}