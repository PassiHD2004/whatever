package whatever;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
			new Fly(this);
			new Feed(this);
			new Heal(this);
			new Nuke(this);
			saveDefaultConfig();
	}
	
}
