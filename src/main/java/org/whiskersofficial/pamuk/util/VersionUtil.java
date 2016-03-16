package org.whiskersofficial.pamuk.util;

import com.github.zafarkhaja.semver.Version;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class VersionUtil {

    public static boolean isPluginUpToDate(Whisker plugin) {
        Version latest = getLatestVersion(plugin);
        Version current = getCurrentVersion(plugin);

        return !latest.greaterThan(current);
    }

    public static Version getLatestVersion(Whisker plugin) {
        String releasesJSON = HTTPUtils.getRequest("https://api.github.com/repos/" +
                "WhiskersOfficial/" + plugin.whiskerName + "releases");

        Gson gson = new Gson();
        JsonArray releases = gson.fromJson(releasesJSON, JsonArray.class);
        return Version.valueOf(((JsonObject) releases.get(0))
                .get("tag_name")
                .toString()
                .replace("\"", ""));
    }

    public static Version getCurrentVersion(Whisker plugin) {
        return Version.valueOf(plugin.whiskerVersion);
    }
}
