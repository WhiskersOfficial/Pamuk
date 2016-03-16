package org.whiskersofficial.pamuk;

import org.bukkit.plugin.java.JavaPlugin;

public class PamukPlugin extends JavaPlugin {

    private static Pamuk api;

    @Override
    public void onEnable() {
        api = new Pamuk(this);
    }

    @Override
    public void onDisable() {

    }

    public static Pamuk getPamuk() {
        return api;
    }
}
