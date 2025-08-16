package honny;

import lombok.Getter;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;

public class MainConfigManager {
    @Getter private final String north;
    @Getter private final String northSelected;

    @Getter private final String east;
    @Getter private final String eastSelected;

    @Getter private final String south;
    @Getter private final String southSelected;

    @Getter private final String west;
    @Getter private final String westSelected;

    @Getter private final String fill;
    @Getter private final String fillCenter;

    @Getter private final String fillSelect;
    @Getter private final String fillCenterSelect;

    @Getter private final String compassTarget;
    @Getter private final String compassTargetSelected;
    @Getter private final String compassTargetAbove;
    @Getter private final String compassTargetSelectedAbove;
    @Getter private final String compassTargetBelow;
    @Getter private final String compassTargetSelectedBelow;

    @Getter private final String selectedCompassTarget;
    @Getter private final String selectedCompassTargetSelected;
    @Getter private final String selectedCompassTargetAbove;
    @Getter private final String selectedCompassTargetSelectedAbove;
    @Getter private final String selectedCompassTargetBelow;
    @Getter private final String selectedCompassTargetSelectedBelow;

    @Getter private final String symbolStart;
    @Getter private final String symbolEnd;

    @Getter private final String prefixString;
    @Getter private final String prefixFormatString;

    @Getter private final String postfixString;
    @Getter private final String postfixFormatString;

    @Getter private final String titleMessage;
    @Getter private final String titleMessageSelected;

    @Getter private final BarColor barColor;
    @Getter private final BarStyle barStyle;

    @Getter private final int compassLocationsUpdateDelaySeconds;
    @Getter private final int ticksUpdateCompass;
    @Getter private final double yDifferenceIcons;

    @Getter private final List<String> originCompass;
    @Getter private final Map<String, String> replacers = new HashMap<>();

    public MainConfigManager(FileConfiguration config) {
        south = getString(config, "south", "&e&lS");
        southSelected = getString(config, "south-selected", "&6&lS");
        replacers.put(south, southSelected);

        west = getString(config, "west", "&e&lW");
        westSelected = getString(config, "west-selected", "&6&lW");
        replacers.put(west, westSelected);

        north = getString(config, "north", "&e&lN");
        northSelected = getString(config, "north-selected", "&6&lN");
        replacers.put(north, northSelected);

        east = getString(config, "east", "&e&lE");
        eastSelected = getString(config, "east-selected", "&6&lE");
        replacers.put(east, eastSelected);

        fill = getString(config, "fill", "&7═");
        fillSelect = getString(config, "fill-select", "&f═");
        replacers.put(fill, fillSelect);

        fillCenter = getString(config, "fill-center", "&7╪");
        fillCenterSelect = getString(config, "fill-center-select", "&f╪");
        replacers.put(fillCenter, fillCenterSelect);

        compassTarget = getString(config, "default.compass-target", "&2□");
        compassTargetSelected = getString(config, "default.compass-target-selected", "&a■");

        compassTargetAbove = getString(config, "default.compass-target-above", "&2△");
        compassTargetSelectedAbove = getString(config, "default.compass-target-selected-above", "&a▲");

        compassTargetBelow = getString(config, "default.compass-target-below", "&2▽");
        compassTargetSelectedBelow = getString(config, "default.compass-target-selected-below", "&a▼");

        selectedCompassTarget = getString(config, "selected.compass-target", "&2□");
        selectedCompassTargetSelected = getString(config, "selected.compass-target-selected", "&a■");

        selectedCompassTargetAbove = getString(config, "selected.compass-target-above", "&2△");
        selectedCompassTargetSelectedAbove = getString(config, "selected.compass-target-selected-above", "&a▲");

        selectedCompassTargetBelow = getString(config, "selected.compass-target-below", "&2▽");
        selectedCompassTargetSelectedBelow = getString(config, "selected.compass-target-selected-below", "&a▼");

        symbolStart = getString(config, "symbol-start", "&e&l╠");
        symbolEnd = getString(config, "symbol-end", "&e&l╣");

        prefixString = getString(config, "prefix-string", "%-10s");
        prefixFormatString = getString(config, "prefix-format-string", "%-10s");

        postfixString = getString(config, "postfix-string", "%10s");
        postfixFormatString = getString(config, "postfix-format-string", "%10s");

        titleMessage = getString(config, "title-message", "&6{name} &e{distance} м.");
        titleMessageSelected = getString(config, "title-message-selected", "&a{name} &2{distance} м.");

        barColor = BarColor.valueOf(getString(config, "bar-color", "white").toUpperCase(Locale.ROOT));
        barStyle = BarStyle.valueOf(getString(config, "bar-style", "solid").toUpperCase(Locale.ROOT));

        compassLocationsUpdateDelaySeconds = config.getInt("compass-locations-update-delay-seconds", 3);
        ticksUpdateCompass = config.getInt("ticks-update-compass", 20);
        yDifferenceIcons = config.getDouble("y-difference-icons", 10);

        originCompass = formatOriginCompass();
    }

    private List<String> formatOriginCompass() {
        List<String> allSection = new ArrayList<>();

        // Length 9
        List<String> fillSection = Arrays.asList(this.fill, this.fill, this.fill, this.fill, this.fillCenter, this.fill, this.fill, this.fill, this.fill);

        // offset 20 slots
        allSection.add(this.north);
        allSection.addAll(fillSection);
        allSection.add(this.east);
        allSection.addAll(fillSection);

        // starts 0
        allSection.add(this.south);
        allSection.addAll(fillSection);
        allSection.add(this.west);
        allSection.addAll(fillSection);
        allSection.add(this.north);
        allSection.addAll(fillSection);
        allSection.add(this.east);
        allSection.addAll(fillSection);

        // 20 slots after
        allSection.add(this.south);
        allSection.addAll(fillSection);
        allSection.add(this.west);
        allSection.addAll(fillSection);

        return allSection;
    }

    public BarColor getBarColor() {
        return barColor;
    }

    public BarStyle getBarStyle() {
        return barStyle;
    }

    public String getNorth() {
        return north;
    }

    public String getNorthSelected() {
        return northSelected;
    }

    public String getEast() {
        return east;
    }

    public String getEastSelected() {
        return eastSelected;
    }

    public String getSouth() {
        return south;
    }

    public String getSouthSelected() {
        return southSelected;
    }

    public String getWest() {
        return west;
    }

    public String getWestSelected() {
        return westSelected;
    }

    public String getFill() {
        return fill;
    }

    public String getFillCenter() {
        return fillCenter;
    }

    public String getFillSelect() {
        return fillSelect;
    }

    public String getFillCenterSelect() {
        return fillCenterSelect;
    }

    public String getCompassTarget() {
        return compassTarget;
    }

    public String getCompassTargetSelected() {
        return compassTargetSelected;
    }

    public String getCompassTargetAbove() {
        return compassTargetAbove;
    }

    public String getCompassTargetSelectedAbove() {
        return compassTargetSelectedAbove;
    }

    public String getCompassTargetBelow() {
        return compassTargetBelow;
    }

    public String getCompassTargetSelectedBelow() {
        return compassTargetSelectedBelow;
    }

    public String getSelectedCompassTarget() {
        return selectedCompassTarget;
    }

    public String getSelectedCompassTargetSelected() {
        return selectedCompassTargetSelected;
    }

    public String getSelectedCompassTargetAbove() {
        return selectedCompassTargetAbove;
    }

    public String getSelectedCompassTargetSelectedAbove() {
        return selectedCompassTargetSelectedAbove;
    }

    public String getSelectedCompassTargetBelow() {
        return selectedCompassTargetBelow;
    }

    public String getSelectedCompassTargetSelectedBelow() {
        return selectedCompassTargetSelectedBelow;
    }

    public String getSymbolStart() {
        return symbolStart;
    }

    public String getSymbolEnd() {
        return symbolEnd;
    }

    public String getPrefixString() {
        return prefixString;
    }

    public String getPrefixFormatString() {
        return prefixFormatString;
    }

    public String getPostfixString() {
        return postfixString;
    }

    public String getPostfixFormatString() {
        return postfixFormatString;
    }

    public String getTitleMessage() {
        return titleMessage;
    }

    public String getTitleMessageSelected() {
        return titleMessageSelected;
    }

    public int getCompassLocationsUpdateDelaySeconds() {
        return compassLocationsUpdateDelaySeconds;
    }

    public int getTicksUpdateCompass() {
        return ticksUpdateCompass;
    }

    public double getYDifferenceIcons() {
        return yDifferenceIcons;
    }

    public List<String> getOriginCompass() {
        return originCompass;
    }

    public Map<String, String> getReplacers() {
        return replacers;
    }

    private static String getString(FileConfiguration config, String path, String defaultValue) {
        String value = config.getString(path);
        if (value == null) return defaultValue;
        return value.replace("&", "§");
    }

    private static String getString(FileConfiguration config, String path) {
        String value = config.getString(path);
        if (value == null) {
            HonnyCompass.getInstance().getLogger().warning("§4Config string \"" + path + "\" not found");
            return null;
        }
        return value.replace("&", "§");
    }
}
