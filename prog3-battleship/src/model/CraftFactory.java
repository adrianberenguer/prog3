package model;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

import model.aircraft.Bomber;
import model.aircraft.Fighter;
import model.aircraft.Transport;
import model.ship.Battleship;
import model.ship.Carrier;
import model.ship.Cruiser;
import model.ship.Destroyer;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Craft objects.
 */
public class CraftFactory 
{
	
	/**
	 * Creates a new Craft object.
	 *
	 * @param type the type
	 * @param orientation the orientation
	 * @return the craft
	 */
	public static Craft createCraft(String type, Orientation orientation)
	{
		
		switch(type)
		{
			case "Bomber":
				return new Bomber(orientation);
			case "Fighter":
				return new Fighter(orientation);
				
			case "Transport":
				return new Transport(orientation);
			
			case "Battleship":
				return new Battleship(orientation);
			
			case "Carrier":
				return new Carrier(orientation);
			
			case "Cruiser":
				return new Cruiser(orientation);
			
			case "Destroyer":
				return new Destroyer(orientation);
			
			default: return null;
		}
	}
	
}