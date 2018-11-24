package mc.holagrimola;

import org.bukkit.ChatColor;
import org.bukkit.Material;
//import org.bukkit.Location;
//import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class MusiCraft extends JavaPlugin implements Listener {

	public void onEnable()
	{	
		
		getServer().getPluginManager().registerEvents(new Guitar(), this);
		
		//Sends a message to the server console that the plugin has started.
		getLogger().info("MusiCraft plugin has started.");
		
		getServer().addRecipe(Guitar.craftGuitar());
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(cmd.getName().equalsIgnoreCase("MusiCraft") || cmd.getName().equalsIgnoreCase("MC")){
			if(sender instanceof Player){
				Player player = (Player)sender;
				
				if(args.length == 0){
					player.sendMessage(ChatColor.AQUA + "Welcome to MusiCraft!\nThis gives you the access to play instruments! :D\nFor further information, please type:\n/MusiCraft help");
				}
				
				if(args.length == 1){
					
					//Location l = player.getLocation();

					
					switch(args[0].toLowerCase()){
						//case "guitar" : Guitar.spawnGuitar(player); break;
						case "help" : this.getHelp(player); break;
						case "manual" : MusiCraft.manual(player); break;
						case "recipe" : this.getCrafting(player); break;
						/*case "basedrum" : player.playSound(l, Sound.BLOCK_NOTE_BASEDRUM, 1, 1); break;
						case "bass" : player.playSound(l, Sound.BLOCK_NOTE_BASS, 1, 1); break;
						case "harp" : player.playSound(l, Sound.BLOCK_NOTE_HARP, 1, 1); break;
						case "hat" : player.playSound(l, Sound.BLOCK_NOTE_HAT, 1, 1); break;
						case "pling" : player.playSound(l, Sound.BLOCK_NOTE_PLING, 1, 1); break;
						case "snare" : player.playSound(l, Sound.BLOCK_NOTE_SNARE, 1, 1); break;
						*/
						default : player.sendMessage(ChatColor.DARK_RED + "MusiCraft wasn't able to understand your command. \n Please type /MusiCraft for further info.");
					
					}
				}
				
				
			}
			
			return true;
			
		}
		return true;
		
	}
	
	
	
	
	public void getHelp(Player player){
		player.sendMessage(ChatColor.GOLD + " * * * MusiCraft * * * \n" + ChatColor.AQUA + "- " + ChatColor.WHITE + "/mc help\n" + ChatColor.AQUA + "- " + ChatColor.WHITE + "/mc recipe\n" + ChatColor.AQUA + "- " + ChatColor.WHITE + "/mc info");
	}
	
	public void getCrafting(Player player){
		player.sendMessage(ChatColor.AQUA + "Put the following items into a crafting table:\n" + ChatColor.WHITE + "Nothing, String, Stick,\nString, Redstone, String,\nOak log, String, Nothing.");
	}
	
	public static void manual(Player player){
		ItemStack manual = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta meta = (BookMeta) manual.getItemMeta();
		
		meta.setAuthor("Holagrimola");
		meta.setTitle(ChatColor.DARK_BLUE + "MusiCraft Manual - How to do MusiCraft");
		meta.setPage(1, "Hello, and welcome to MusiCraft! \n This plugin gives you the freedom to make your own Guitar on your minecraft server, without mods! \n Do note that more instruments are coming \n Now you might wonder, how do I get started on Musicraft?");
		
		manual.setItemMeta(meta);
		player.getInventory().addItem(manual);
		
		
	}
}

