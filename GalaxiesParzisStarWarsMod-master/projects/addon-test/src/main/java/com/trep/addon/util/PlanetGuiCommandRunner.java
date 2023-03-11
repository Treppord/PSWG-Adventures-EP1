package com.trep.addon.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class PlanetGuiCommandRunner {
    private final MinecraftClient client;

    public PlanetGuiCommandRunner(MinecraftClient client) {
        this.client = client;
    }

    public void checkPlayerYLevel() {
        if (client.player != null && client.player.getY() > 650) {
            client.player.sendMessage(Text.keybind("/planetgui"));
            client.player.teleport(~0, ~10, ~0);
        }
    }
}