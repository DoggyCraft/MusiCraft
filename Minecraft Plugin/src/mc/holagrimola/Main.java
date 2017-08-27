package mc.holagrimola;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

  public void onEnable(){
	  
    getLogger().info("Calculator plugin is Enabled.");
    
    
    
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
      if(cmd.getName().equalsIgnoreCase("calculator") || cmd.getName().equalsIgnoreCase("calc") || cmd.getName().equalsIgnoreCase("c") || cmd.getName().equalsIgnoreCase("calculate")){
        //doSomething
        if(sender instanceof Player){
          Player player = (Player)sender;
          try {
              if(args.length == 3){
        	      if(args[1].equalsIgnoreCase("+")){

        		      float svar = Float.parseFloat(args[0]) + Float.parseFloat(args[2]);
        		      player.sendMessage(String.valueOf(svar));
        	      }
        	      if(args[1].equalsIgnoreCase("-")){
        		  
        		      float svar = Float.parseFloat(args[0]) - Float.parseFloat(args[2]);
        		      player.sendMessage(String.valueOf(svar));
        	      }
        	      if(args[1].equalsIgnoreCase("*")){
        		  
        		      float svar = Float.parseFloat(args[0]) * Float.parseFloat(args[2]);
        		      player.sendMessage(String.valueOf(svar));
        	      }
        	      if(args[1].equalsIgnoreCase("/")){
        		      if(Float.parseFloat(args[2]) != 0){
        			  
        			      float svar = Float.parseFloat(args[0]) / Float.parseFloat(args[2]);
        		          player.sendMessage(String.valueOf(svar));
        		      }
        		      else {
        			      player.sendMessage("Error: Divide by zero.");
        		      }
        		  
        	      }
              }
              else if(args.length == 1){
        	       if(args[0].equalsIgnoreCase("help")){
        		      player.sendMessage("Welcome to Calculator! To calculate type */calculator <first number> <+, -, * or /> <second number>*");
        	      }
        	      else
        	      player.sendMessage("Argument error.");
              }
          }
          
          catch (Exception e){
        	  player.sendMessage("Unable to calculate. Please check /c help.");
          }
          
        }else{
          sender.sendMessage("This command can only be used as a player. Sorry 'bout dat.");
        }
        return true;
      }
      return false;
  }
}
