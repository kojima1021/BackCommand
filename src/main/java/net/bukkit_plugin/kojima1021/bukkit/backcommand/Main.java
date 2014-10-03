package net.bukkit_plugin.kojima1021.bukkit.backcommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @license GPL3
 * @author kojima1021
 */
public class Main extends JavaPlugin implements Listener {

    static String prefix = ChatColor.AQUA + "[" + ChatColor.YELLOW + "BackCommand" + ChatColor.AQUA + "]" + ChatColor.RESET + " ";
    //インスタンス
    private static Main instance;

    /**
     * メインクラスを取得します
     *
     * @return instance
     */
    public static Main getInstance() {
        return instance;
    }

    public static String GetPrefix() {
        return prefix;
    }

    //Plugin開始時

    @Override
    public void onEnable() {
        /**
         * 初期設定完了;
         */
        //リスナー登録
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getCommand("back").setExecutor(new Commands());
        getCommand("bcd").setExecutor(new Commands());
        //インスタンス設定
        instance = this;
        //Config
        this.saveDefaultConfig();
    }

    //Plugin終了時

    @Override
    public void onDisable() {
    }

    public static Boolean GetDebug() {
        FileConfiguration config = getInstance().getConfig();
        Boolean tof = config.getBoolean("debug");
        return tof;
    }

    public static void DebugMessage(String message) {
        if (GetDebug()) {
            Bukkit.broadcastMessage(message);
            System.out.print(message);
        }
    }
}
