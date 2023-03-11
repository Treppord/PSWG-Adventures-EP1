package com.trep.addon.screen;

import com.trep.addon.TestAddon;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<ArmorStationScreenHandler> ARMOR_STATION_SCREEN_HANDLER;
    public static ScreenHandlerType<MarketScreenHandler> MARKET_STATION_SCREEN_HANDLER;
    public static ScreenHandlerType<BlasterTableScreenHandler> BLASTER_TABLE_SCREEN_HANDLER;


    public static ScreenHandlerType<FabricatorScreenHandler> SMITHING_ANVIL_SCREEN_HANDLER_TYPE;

    public static void registerAllScreenHandlers() {
        ARMOR_STATION_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(TestAddon.MODID, "armor_station"),
                        ArmorStationScreenHandler::new);
        MARKET_STATION_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(TestAddon.MODID, "market_station"),
                        MarketScreenHandler::new);
        BLASTER_TABLE_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(TestAddon.MODID, "blaster_table"),
                        BlasterTableScreenHandler::new);
        SMITHING_ANVIL_SCREEN_HANDLER_TYPE =
                ScreenHandlerRegistry.registerSimple(new Identifier(TestAddon.MODID, "smithing_anvil"),
                        FabricatorScreenHandler::new);
    }
}