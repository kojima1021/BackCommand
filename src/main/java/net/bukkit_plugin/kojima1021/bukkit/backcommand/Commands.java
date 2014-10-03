package net.bukkit_plugin.kojima1021.bukkit.backcommand;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @license GPL3
 * @author kojima1021
 */
public class Commands implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if (cs instanceof Player) {
            if (cmnd.getName().equalsIgnoreCase("back")) {
                Main.DebugMessage("BACK Send ! (Player)");
                Back.SendCommand(cs, strings);
            }else if (cmnd.getName().equalsIgnoreCase("bcd")) {
                Main.DebugMessage("DEBUG Send! (Player)");
                Debug.SendCommand(cs, strings);
            }else{
                Main.DebugMessage("NoCMD (Player)");
                return true;
            }
        }else{
            if (cmnd.getName().equalsIgnoreCase("bcd")) {
                Main.DebugMessage("DEBUG Send! (NoPlayer)");
                Debug.SendCommand(cs, strings);
            }else{
                Main.DebugMessage("NoCMD (Player)");
                return true;
            }
        }
        return true;
    }
         /**
	 * パーミッションの有無を調べる
	 * @param par1Perm 調べたいパーミッション
	 * @param par2Player プレイヤーのインスタンス
	 * @return パーミッションの有無
	 */
	public static boolean hasPerm(String par1Perm, CommandSender par2Player){
		if(!(par2Player.hasPermission(par1Perm)) && !(par2Player.isOp())) {
 
			return false;
		}
		return true;
	}
}
