



package mc.holagrimola;


import org.bukkit.Bukkit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
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

public class Guitar implements Listener  {
	
	private static final ItemStack itemGuitar = getGuitar();
	
	
	
	
	/*public static void spawnGuitar (Player player){
		
		
		player.getInventory().addItem(itemGuitar);
		
	}
*/
	
	public static void craftGuitar(MusiCraft plugin){
		
		
		
		NamespacedKey key = new NamespacedKey(plugin, "MCGuitar");
		NamespacedKey key1 = new NamespacedKey(plugin, "MCGuitar1");
		NamespacedKey key2 = new NamespacedKey(plugin, "MCGuitar2");
		NamespacedKey key3 = new NamespacedKey(plugin, "MCGuitar3");
		NamespacedKey key4 = new NamespacedKey(plugin, "MCGuitar4");
		NamespacedKey key5 = new NamespacedKey(plugin, "MCGuitar5");
		
		ShapedRecipe gr = new ShapedRecipe(key, getGuitar());
		ShapedRecipe gr1 = new ShapedRecipe(key1, getGuitar());
		ShapedRecipe gr2 = new ShapedRecipe(key2, getGuitar());
		ShapedRecipe gr3 = new ShapedRecipe(key3, getGuitar());
		ShapedRecipe gr4 = new ShapedRecipe(key4, getGuitar());
		ShapedRecipe gr5 = new ShapedRecipe(key5, getGuitar());
		
		gr.shape(" #*","#¤#","%# ");
		gr1.shape(" #*","#¤#","%# ");
		gr2.shape(" #*","#¤#","%# ");
		gr3.shape(" #*","#¤#","%# ");
		gr4.shape(" #*","#¤#","%# ");
		gr5.shape(" #*","#¤#","%# ");
		
		gr.setIngredient('#', Material.STRING);
		gr1.setIngredient('#', Material.STRING);
		gr2.setIngredient('#', Material.STRING);
		gr3.setIngredient('#', Material.STRING);
		gr4.setIngredient('#', Material.STRING);
		gr5.setIngredient('#', Material.STRING);
		
		gr.setIngredient('*', Material.STICK);
		gr1.setIngredient('*', Material.STICK);
		gr2.setIngredient('*', Material.STICK);
		gr3.setIngredient('*', Material.STICK);
		gr4.setIngredient('*', Material.STICK);
		gr5.setIngredient('*', Material.STICK);
		
		gr.setIngredient('¤', Material.REDSTONE);
		gr1.setIngredient('¤', Material.REDSTONE);
		gr2.setIngredient('¤', Material.REDSTONE);
		gr3.setIngredient('¤', Material.REDSTONE);
		gr4.setIngredient('¤', Material.REDSTONE);
		gr5.setIngredient('¤', Material.REDSTONE);
		
		
		gr.setIngredient('%', Material.STRIPPED_SPRUCE_WOOD);
		gr1.setIngredient('%', Material.STRIPPED_ACACIA_WOOD);
		gr2.setIngredient('%', Material.STRIPPED_BIRCH_WOOD);
		gr3.setIngredient('%', Material.STRIPPED_OAK_WOOD);
		gr4.setIngredient('%', Material.STRIPPED_DARK_OAK_WOOD);
		gr5.setIngredient('%', Material.STRIPPED_JUNGLE_WOOD);
		

		
		Bukkit.addRecipe(gr);
		Bukkit.addRecipe(gr1);
		Bukkit.addRecipe(gr2);
		Bukkit.addRecipe(gr3);
		Bukkit.addRecipe(gr4);
		Bukkit.addRecipe(gr5);
		
		
	}
	

	
	
	
	public static ItemStack getGuitar() {
		ItemStack item = new ItemStack(Material.WOODEN_SWORD,1);
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
				
				loc.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_GUITAR, 1, pitchHandlerRight(player));
				loc.getWorld().spawnParticle(Particle.NOTE, loc2, 1);
				
				}
			if(action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)){
				
				loc.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_GUITAR, 1, pitchHandlerLeft(player));
				loc.getWorld().spawnParticle(Particle.NOTE, loc2, 1);
				
			}
		}
		
	}
}










