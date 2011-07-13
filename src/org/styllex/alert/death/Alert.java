package org.styllex.alert.death;

import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.event.Event;
import org.bukkit.event.entity.*;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.plugin.java.JavaPlugin;

public class Alert extends JavaPlugin{
	public int t = 0;
	public int lt= 0;
	public void onDisable(){	
	}
	public void onEnable(){
		
		System.out.println("DethAl3rtz enabled:");
		System.out.println("--)> DethAl3rtz Version 1.1");
		
		getServer().getPluginManager().registerEvent(Event.Type.ENTITY_DEATH, new AlertListener(this), Event.Priority.Monitor, this);
		
		/*As seeing it will not alter the event, being monitor does no harm*/
		
	}
	
	public class AlertListener extends EntityListener{//Make a new inhereited class, a class inside a class
		public Alert plugin;
		
		public AlertListener(Alert plug){//Constructor
			this.plugin=plug;
		}
		
		public void onEntityDeath(EntityDeathEvent event){//Void to run on the Entity_Death Event
			if(event.getEntity() instanceof HumanEntity){//if the entity hurt was a human entity
				HumanEntity human = (HumanEntity)event.getEntity();//get the human entity
				if(human instanceof Player){//if the human entity was a player
					Player p = (Player)human;//get the player
					DamageCause cause = p.getLastDamageCause().getCause();//get the cause
					Location l = p.getLocation();//get the location it happened at
					if(cause.toString().equalsIgnoreCase(DamageCause.BLOCK_EXPLOSION.toString())){//if explosion by tnt
						System.out.println("Player "+p.getDisplayName()+" got blown up by TNT at "+(int)l.getX()+", "+(int)l.getY()+", "+(int)l.getZ());
						return;
					}
					else if(cause.toString().equalsIgnoreCase(DamageCause.DROWNING.toString())){//drowned in water
						System.out.println("Player "+p.getDisplayName()+" drowned at "+(int)l.getX()+", "+(int)l.getY()+", "+(int)l.getZ());
						return;
					}
					else if(cause.toString().equalsIgnoreCase(DamageCause.ENTITY_ATTACK.toString())){//killed by some entity
						System.out.println("Player "+p.getDisplayName()+" was attacked by an entity at "+(int)l.getX()+", "+(int)l.getY()+", "+(int)l.getZ());
						return;
					}
					else if(cause.toString().equalsIgnoreCase(DamageCause.ENTITY_EXPLOSION.toString())){//killed by creeper
						System.out.println("Player "+p.getDisplayName()+" got blown up by creeper at "+(int)l.getX()+", "+(int)l.getY()+", "+(int)l.getZ());
						return;
					}
					else if(cause.toString().equalsIgnoreCase(DamageCause.FALL.toString())){//killed by fall damage
						System.out.println("Player "+p.getDisplayName()+" landed too hard at "+(int)l.getX()+", "+(int)l.getY()+", "+(int)l.getZ()+" and died");
						return;
					}
					else if(cause.toString().equalsIgnoreCase(DamageCause.FIRE.toString())){//killed by inital fire
						System.out.println("Player "+p.getDisplayName()+" burned to death at "+(int)l.getX()+", "+(int)l.getY()+", "+(int)l.getZ());

						return;
					}
					else if(cause.toString().equalsIgnoreCase(DamageCause.FIRE_TICK.toString())){//killed by lingering
						System.out.println("Player "+p.getDisplayName()+" burned to death at "+(int)l.getX()+", "+(int)l.getY()+", "+(int)l.getZ());

						return;
					}
					else if(cause.toString().equalsIgnoreCase(DamageCause.LAVA.toString())){//killed by lava
						System.out.println("Player "+p.getDisplayName()+" died by lava at "+(int)l.getX()+", "+(int)l.getY()+", "+(int)l.getZ());

						return;
					}
					else if(cause.toString().equalsIgnoreCase(DamageCause.LIGHTNING.toString())){//killed by lightning strike
						System.out.println("Player "+p.getDisplayName()+" got struck by lightning at "+(int)l.getX()+", "+(int)l.getY()+", "+(int)l.getZ()+" and died");
						return;
					}
					else if(cause.toString().equalsIgnoreCase(DamageCause.SUFFOCATION.toString())){//killed by suffocation (inside a block)
						System.out.println("Player "+p.getDisplayName()+" suffocated at "+(int)l.getX()+", "+(int)l.getY()+", "+(int)l.getZ());
						return;
					}
					else if(cause.toString().equalsIgnoreCase(DamageCause.VOID.toString())){//killed by going below the map
						System.out.println("Player "+p.getDisplayName()+" eaten by void at "+(int)l.getX()+", "+(int)l.getY()+", "+(int)l.getZ());
						return;
					}
					else if(cause.toString().equalsIgnoreCase(DamageCause.CONTACT.toString())){//killed by some type of contact
						System.out.println("Player "+p.getDisplayName()+" died by contact with unknown object at "+(int)l.getX()+", "+(int)l.getY()+", "+(int)l.getZ());
						return;
					}
					else if(cause.toString().equalsIgnoreCase(DamageCause.CUSTOM.toString())){//killed by some other know reason
						System.out.println("Player "+p.getDisplayName()+" strangely died at "+(int)l.getX()+", "+(int)l.getY()+", "+(int)l.getZ());
						return;
					}else{//if no specific reason, just died, maybe a plugin set health to 0?
						System.out.println("Player "+p.getDisplayName()+" died of "+cause.toString()+" at "+(int)l.getX()+", "+(int)l.getY()+", "+(int)l.getZ());
						lt=t;
					}
				}
			}
		}
		public boolean isDead(Player player){
			return player.getHealth()<=0;
		}
	}
}
