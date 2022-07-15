package whatever;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import whateverutils.Utils;

public class Fly implements CommandExecutor {

	
	private Main plugin;
	
	public Fly(Main plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("fly").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("no_console")));
			return true;
	
		}

		Player p = (Player) sender;
		
		if (p.hasPermission("whatever.fly")) {
			if (p.getAllowFlight()) {
				p.setAllowFlight(false);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("fly_disabled")));
				return true;
			} else {
				p.setAllowFlight(true);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("fly_enabled")));
				return true;
			}
			} else {
				p.sendMessage(Utils.chat(plugin.getConfig().getString("no_perm")));
			}
		return false;
	}
}

