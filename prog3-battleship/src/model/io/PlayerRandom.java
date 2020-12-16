package model.io;

import java.util.Objects;
import java.util.Random;

import model.Board;
import model.CellStatus;
import model.Coordinate;
import model.CoordinateFactory;
import model.Craft;
import model.CraftFactory;
import model.Orientation;
import model.aircraft.Bomber;
import model.aircraft.Fighter;
import model.aircraft.Transport;
import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.ship.Battleship;
import model.ship.Carrier;
import model.ship.Cruiser;
import model.ship.Destroyer;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class PlayerRandom.
 */
public class PlayerRandom implements IPlayer
{
	
	/** The last shot status. */
	private CellStatus lastShotStatus;
	
	/** The random. */
	private Random random;
	
	/** The name. */
	private String name;
	
	/**
	 * Instantiates a new player random.
	 *
	 * @param name the name
	 * @param seed the seed
	 */
	public PlayerRandom(String name, long seed)
	{
		this.name = name;
		Random rand = new Random(seed);
		this.random = rand;
		//int r = random.nextInt(100);
	}
	
	/**
	 * Gets the last shot status.
	 *
	 * @return the last shot status
	 */
	public CellStatus getLastShotStatus()
	{
		return lastShotStatus;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return name + " (" + /*"PlayerFile"*/ getClass().getSimpleName() + ")";
	}
	
	/**
	 * Put crafts.
	 *
	 * @param b the b
	 */
	public void putCrafts(Board b) 
	{
		Coordinate c = null;
		Craft craft = null;
		boolean comprobar = false; //para comprobar que crea una coordenada correcta antes de 100 intentos
		
		if(b.getClass().getName() == "model.ship.Board2D")
		{
			for(int x=0; x<4; x++) //for de 4 porque hay 4 ships 
			{
				// int r = genRandomInt(0,4); no hacerlo asi si no con nextInt 
				Orientation o = null;
				switch(random.nextInt(4)) //random orientation
				{
					case 0: o = Orientation.NORTH;break;
					case 1: o = Orientation.EAST;break;
					case 2:	o = Orientation.SOUTH;break;
					case 3: o = Orientation.WEST;break;
				}
				switch(x)
				{
				    case 0: craft = CraftFactory.createCraft("ship.Battleship", o);break;
				    case 1: craft = CraftFactory.createCraft("ship.Carrier", o);break;
					case 2: craft = CraftFactory.createCraft("ship.Cruiser", o);break;
					case 3: craft = CraftFactory.createCraft("ship.Destroyer", o);break;
					
				    /*case 0: craft = new Battleship(o);break;
					case 1: craft = new Carrier(o);break;
					case 2: craft = new Cruiser(o);break;
					case 3: craft = new Destroyer(o);break;*/
				}
				comprobar = false;
				for(int i=0;i<100 && !comprobar;i++)
				{
					c = genRandomCoordinate(b, Craft.BOUNDING_SQUARE_SIZE);
					try
					{
						b.addCraft(craft, c);
						
						comprobar = true;
					}
					catch(Exception e)
					{
						
					}
					
				}
	
			}
			
		}
		if(b.getClass().getName() == "model.aircraft.Board3D")
		{
			
			for(int x=0;x<7;x++) //for de 6 porque hay 4 crafts y tres aircrafts
			{
				int r = random.nextInt(4);
				Orientation o = null;
				switch(r) //random orientation
				{
					case 0: o = Orientation.NORTH;break;
					case 1: o = Orientation.EAST;break;
					case 2:	o = Orientation.SOUTH;break;
					case 3: o = Orientation.WEST;break;
				}
				switch(x)
				{
			    	case 0: craft = CraftFactory.createCraft("ship.Battleship", o);break;
			    	case 1: craft = CraftFactory.createCraft("ship.Carrier", o);break;
			    	case 2: craft = CraftFactory.createCraft("ship.Cruiser", o);break;
			    	case 3: craft = CraftFactory.createCraft("ship.Destroyer", o);break;//ships
			    	case 4: craft = CraftFactory.createCraft("aircraft.Bomber", o);break;
			    	case 5: craft = CraftFactory.createCraft("aircraft.Fighter", o);break;
			    	case 6: craft = CraftFactory.createCraft("aircraft.Transport", o);break;//aircrafts
				
					/*case 0: craft = new Battleship(o);break;
					case 1: craft = new Carrier(o);break;
					case 2: craft = new Cruiser(o);break;
					case 3: craft = new Destroyer(o);break;//crafts
					case 4: craft = new Bomber(o);break;
					case 5: craft = new Fighter(o);break;
					case 6: craft = new Transport(o);break;//aircrafts*/
					
				}
				comprobar = false;
				for(int i = 0; i< 100 && !comprobar; i++)
				{
					c = genRandomCoordinate(b, Craft.BOUNDING_SQUARE_SIZE);					
					try
					{
						b.addCraft(craft, c);
						comprobar = true;
					}
					catch(Exception e)
					{
						
					}
				}
			}
		}
		
	}
	
	/**
	 * Next shoot.
	 *
	 * @param b the b
	 * @return the coordinate
	 * @throws InvalidCoordinateException the invalid coordinate exception
	 * @throws CoordinateAlreadyHitException the coordinate already hit exception
	 */
	public Coordinate nextShoot(Board b) throws InvalidCoordinateException, CoordinateAlreadyHitException
	{
		Objects.requireNonNull(b);	
		Coordinate c = null;
		
		c = genRandomCoordinate(b,0);
		//b.hit(c);
		
		lastShotStatus = b.hit(c);
		
		return c;
	}
	
	/**
	 * Gen random int.
	 *
	 * @param min the min
	 * @param max the max
	 * @return the int
	 */
	private int genRandomInt(int min, int max)
	{
		return random.nextInt(max-min)+min;
	}
	
	/**
	 * Gen random coordinate.
	 *
	 * @param b the b
	 * @param offset the offset
	 * @return the coordinate
	 */
	private Coordinate genRandomCoordinate(Board b, int offset)
	{
		Coordinate c = null;
		int x,y,z;
		
		if(b.getClass().getName() == "model.ship.Board2D")
		{
			x = genRandomInt(0-offset, b.getSize());
			y = genRandomInt(0-offset, b.getSize());
			c = CoordinateFactory.createCoordinate(x,y);
		}
		if(b.getClass().getName() == "model.aircraft.Board3D")
		{
			x = genRandomInt(0-offset, b.getSize());
			y = genRandomInt(0-offset, b.getSize()); 
			z = genRandomInt(0-offset, b.getSize());
			c = CoordinateFactory.createCoordinate(x,y,z);
		}
		
		return c;
	}
	
}