package dev.tonimatas.litefun.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Messages {
    public static void sendConsole(String string) {
        Bukkit.getConsoleSender().sendMessage(translateString(string));
    }
    
    public static String translateString(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
