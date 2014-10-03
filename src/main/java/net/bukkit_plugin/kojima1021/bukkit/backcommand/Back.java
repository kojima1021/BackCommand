package net.bukkit_plugin.kojima1021.bukkit.backcommand;

import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @license GPL3
 * @author kojima1021
 */
public class Back {
    public static void SendCommand(CommandSender cs , String[] args) {
        Player p = (Player)cs;
        if (args.length < 1) {
            Main.DebugMessage("Args < 1");
            HashMap<Player,Double[]> lm = PlayerListener.map;
            HashMap<Player, World> w = PlayerListener.map2;
            if (!Commands.hasPerm("backcommand.use", p)) {
                Main.DebugMessage("Player NoPermission");
                p.sendMessage(Main.GetPrefix() + "あなたがコマンドを実行する権限がありません。");
                return;
            }
            Location l = PlayerListener.HashMapLocation(p);
            if (l == null) {
                p.sendMessage(Main.GetPrefix() +"最後に死んだ場所がありません。");
                return;
            }
            p.teleport(l);
            p.sendMessage(Main.GetPrefix() + "最後に死んだ場所にテレポートしました。");
            Main.DebugMessage("Teleport Done!");
        }else{
            p.sendMessage(Main.GetPrefix() +ChatColor.YELLOW +"/back");
        }
    }
}
