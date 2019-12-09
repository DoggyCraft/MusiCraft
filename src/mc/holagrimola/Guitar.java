package mc.holagrimola;


import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import org.bukkit.event.block.Action;

import net.md_5.bungee.api.ChatColor;

public class Guitar implements Listener {
	
	private static final ItemStack itemGuitar = getGuitar();
	
	
	
	
	/*public static void spawnGuitar (Player player){
		
		
		player.getInventory().addItem(itemGuitar);
		
	}
*/
	
	public static ShapedRecipe craftGuitar(){
		
		ShapedRecipe gr = new ShapedRecipe(itemGuitar);
		
		gr.shape(" #*","#¤#","%# ");
		gr.setIngredient('#', Material.STRING);
		gr.setIngredient('*', Material.STICK);
		gr.setIngredient('¤', Material.REDSTONE_BLOCK);
		gr.setIngredient('%', Material.LOG);
		
	return gr;
	}
	
	
	
	private static ItemStack getGuitar() {
		ItemStack item = new ItemStack(Material.WOOD_SWORD,1);
		ItemMeta meta = item.getItemMeta(); 
		
		meta.setDisplayName(ChatColor.GOLD + "Guitar");
		item.setItemMeta(meta);
		return item;
	}
	
	
	
	private static float pitchHandlerRight(Player player){
				
		float pitch = (float) 1.0;
		

		
			if(player.isSneaking()){
				switch(player.getInventory().getHeldItemSlot()){
				
				case 0 : pitch = (float) 1.334840; break;
				case 1 : pitch = (float) 1.414214; break; 
				case 2 : pitch = (float) 1.498307; break;
				case 3 : pitch = (float) 1.587401; break;
				case 4 : pitch = (float) 1.681793; break;
				case 5 : pitch = (float) 1.781797; break;
				case 6 : pitch = (float) 1.887749; break;
				default : pitch = (float) 2;
				}
		
			}
			else{
				switch(player.getInventory().getHeldItemSlot()){
				
				case 0 : pitch = (float) 0.840896; break; 
				case 1 : pitch = (float) 0.890899; break;
				case 2 : pitch = (float) 0.943900; break;
				case 3 : pitch = (float) 1; break;
				case 4 : pitch = (float) 1.059463; break;
				case 5 : pitch = (float) 1.122462; break;
				case 6 : pitch = (float) 1.189207; break;
				default : pitch = (float) 1.259921;
				}
			
			
			}
			
		
				
				return pitch;
	}
	
	private static float pitchHandlerLeft(Player player){
		
		float pitch = (float) 1.0;
		

		
			
			switch(player.getInventory().getHeldItemSlot()){
			
			case 0 : pitch = (float) 0.529732; break; 
			case 1 : pitch = (float) 0.561231; break;
			case 2 : pitch = (float) 0.594604; break;
			case 3 : pitch = (float) 0.629961; break;
			case 4 : pitch = (float) 0.667420; break;
			case 5 : pitch = (float) 0.707107; break;
			case 6 : pitch = (float) 0.749154; break;
			default : pitch = (float) 0.793701;
			}
			
			
			

			
		
				
		return pitch;
	}
	
	@EventHandler
	private void onRightClick(PlayerInteractEvent pie){
		
		Player player = pie.getPlayer();
		
		Action action = pie.getAction();
		
		Location loc = player.getLocation();
		
		Location loc2 = loc.add(0, 2.3, 0);
		
		if(player.getInventory().getItemInOffHand().equals(itemGuitar)){
			if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)){
				
				loc.getWorld().playSound(loc, Sound.BLOCK_NOTE_BASS, 1, pitchHandlerRight(player));
				loc.getWorld().playEffect(loc2, Effect.NOTE, 0);
				
				}
			if(action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)){
				
				loc.getWorld().playSound(loc, Sound.BLOCK_NOTE_BASS, 1, pitchHandlerLeft(player));
				loc.getWorld().playEffect(loc2, Effect.NOTE, 0);
				
			}
		}
		
	}
}










