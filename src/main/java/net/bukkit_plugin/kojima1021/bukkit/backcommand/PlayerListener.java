package net.bukkit_plugin.kojima1021.bukkit.backcommand;

import java.util.HashMap;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * @license GPL3
 * @author kojima1021
 */
public class PlayerListener implements Listener{
    public static HashMap<Player, Double[]> map = new HashMap<Player, Double[]>();
    public static HashMap<Player, World> map2 = new HashMap<Player, World>();
    @EventHandler
    public void PD(PlayerDeathEvent e) {
        Player p = e.getEntity();
        double x = p.getLocation().getX();
        double y = p.getLocation().getY();
        double z = p.getLocation().getZ();
        World w = p.getLocation().getWorld();
        Double[] Location = {x , y, z};
        map.put(p, Location);
        map2.put(p, w);
        Main.DebugMessage("Location Save Done!");
    }
    public static World HashMapWorld(Player p) {
        World world = map2.get(p);
        return world;
    }
    public static Location HashMapLocation(Player p) {
        Double[] lg = map.get(p);
        if (HashMapWorld(p) == null) {
            return null;
        }
        if (lg == null) {
            return null;
        }else{
        Location l = new Location(HashMapWorld(p) , lg[0], lg[1], lg[2]);
        return l;
        }
    }
}
