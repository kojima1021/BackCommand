package net.bukkit_plugin.kojima1021.bukkit.backcommand;

import org.bukkit.command.CommandSender;

/**
 * @license GPL3
 * @author kojima1021
 */
public class Debug {
    public static void SendCommand(CommandSender cs , String[] args) {
        if (!Commands.hasPerm("backcommand.use", cs)) {
           cs.sendMessage(Main.GetPrefix() + "パーミッションがありません");
        }
        if (Main.GetDebug()) {
            Main.getInstance().getConfig().set("debug", false);
            cs.sendMessage(Main.GetPrefix() + "OFF");
            Main.getInstance().saveConfig();
            return;
        }else{
            Main.getInstance().getConfig().set("debug", true);
            cs.sendMessage(Main.GetPrefix() + "ON");
            Main.getInstance().saveConfig();
            return;
        }
    }
}
