package org.whiskersofficial.pamuk.threads;

import org.whiskersofficial.pamuk.PamukPlugin;
import org.whiskersofficial.pamuk.util.HTTPUtils;

public class PamukUpdater implements Runnable {

    PamukPlugin plugin;

    public PamukUpdater(PamukPlugin plugin) {
        this.plugin = plugin;
    }

    public void run() {
        plugin.getLogger().info("[Updater] Updater started...");

        String[] pluginsToUpdate = {
                "Pamuk",
                "BaskaPlugin"
        };

        for (String plugins : pluginsToUpdate) {
            if (plugin.getServer().getPluginManager().getPlugin(plugins) == null) {
                plugin.getLogger().info("[Updater] Plugin " + plugins + " is not installed on this server. Updater will skip it.");
            } else {
                String releasesJSON = HTTPUtils.GETRequest("https://api.github.com/repos/WhiskersOfficial/" + plugins + "/releases");
            }
        }
    }
}
