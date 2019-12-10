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
		
		Guitar.craftGuitar(this);
		
		
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
						case "guitar" : Guitar.getGuitar(); break;
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
		player.sendMessage(ChatColor.AQUA + "Put the following items into a crafting table:\n" + ChatColor.WHITE + "Nothing, String, Stick,\nString, Redstone Block, String,\nOak log, String, Nothing.");
	}
	
	public static void manual(Player player){
		ItemStack manual = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta meta = (BookMeta) manual.getItemMeta();
		
		meta.setAuthor("Holagrimola");
		meta.setTitle(ChatColor.DARK_BLUE + "MusiCraft Manual - How to do MusiCraft");
		meta.addPage("Hello, and welcome to MusiCraft! \n\nThis plugin gives you the freedom to make your own Guitar on your minecraft-server, even without mods! \n\nDo note that more instruments are coming...");
		meta.addPage("Now you might wonder, how do I get started on Musicraft? \n\nThat is something we will be exploring in the following pages!");
		meta.addPage("Table of contents: \n\nCrafting Recipe \nHow to play");
		meta.addPage("Crafting Recipe \nS = String \nT = Stick \nR = Redstone dust \nL = Log \nN = Nothing \n\n NST \n SRS \n LSN");
		meta.addPage("How to play: \n\nTo play the guitar you need to place it in the off-hand. \n\nWhen it is in the off-hand, play it by right-clicking or left-clicking. \n\nYour equipped slot in your hotbar changes the pitch.");
		meta.addPage("The scale is adjusted to fit 24 different nodes.\nLeft-click is the lowest\nNormal right click is the middle section\nShift + right click is the highest."); 
		meta.addPage("The following pages describes the way how the scales areadjusted in slot on hotbar and pitch. Slot 9 is the same as slot 8.\n\nThe lower scale goes like this: \n\n1  2 3  4 5  6 7  8\nF♯ G G# A A# B C C#\n");
		meta.addPage("Middle like this:\n\n1 2  3 4  5 6  7 8\nD D# E F F# G G# A");
		meta.addPage("Higher scale:\n\n1  2 3  4 5  6 7  8\nA# B C C# D D# E F F#");
		meta.addPage("It might take a while to get the hold of, just like any other instrument, but keep training, and I'm sure you'll be able to create some awesome songs! :D \n\n And please be sure to show off your music-skills! ;)");
		meta.addPage("Oh and btw, please give me information of what needs to be improved and so on ^^");
		
		manual.setItemMeta(meta);
		player.getInventory().addItem(manual);
		
		
	}
}



