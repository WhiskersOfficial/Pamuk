package org.whiskersofficial.pamuk.threads;

import com.github.zafarkhaja.semver.Version;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.whiskersofficial.pamuk.util.HTTPUtils;

public class PamukUpdater implements Runnable {
    public void run() {
        System.out.println("[Updater] Updater started...");

        String repoOwner = "Admicos"; //NOTE TO SELF: WhiskersOfficial by default
        String[] pluginsToUpdate = {
             /* "Pamuk" //NOTE TO SELF: Uncomment after testing */
                "VKick" //NOTE TO SELF: Remove after testing
        };

        for (String plugins : pluginsToUpdate) {

        }
    }
}
