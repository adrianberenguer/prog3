package model.io;

import java.io.BufferedReader;
import java.util.Objects;
import java.util.Random;

import model.Board;
import model.Coordinate;
import model.CoordinateFactory;
import model.Craft;
import model.Orientation;
import model.aircraft.Bomber;
import model.aircraft.Fighter;
import model.aircraft.Transport;
import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
import model.ship.Battleship;
import model.ship.Carrier;
import model.ship.Cruiser;
import model.ship.Destroyer;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

public class PlayerRandom implements IPlayer
{
	private Random random;
	private String name;
	
	public PlayerRandom(String name, long seed)
	{
		this.name = name;
		Random rand = new Random(seed);
		this.random = rand;
		//int r = random.nextInt(100);
	}
	
	public String getName()
	{
		return name + " (" + /*"PlayerFile"*/ getClass().getSimpleName() + ")";
	}
	
	public void putCrafts(Board b) 
	{
		Coordinate c = null;
		Craft craft = null;
		boolean comprobar = false; //para comprobar que crea una coordenada correcta antes de 100 intentos
		
		if(b.getClass().getName() == "model.ship.Board2D")
		{
			for(int x=0; x<4; x++) //for de 4 porque hay 4 ships 
			{
				int r = genRandomInt(0,4);
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
					case 0: craft = new Battleship(o);break;
					case 1: craft = new Carrier(o);break;
					case 2: craft = new Cruiser(o);break;
					case 3: craft = new Destroyer(o);break;
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
			
			for(int x=0;x<6;x++) //for de 6 porque hay 4 crafts y tres aircrafts
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
					case 0: craft = new Battleship(o);break;
					case 1: craft = new Carrier(o);break;
					case 2: craft = new Cruiser(o);break;
					case 3: craft = new Destroyer(o);break;//crafts
					case 4: craft = new Bomber(o);break;
					case 5: craft = new Fighter(o);break;
					case 6: craft = new Transport(o);break;//aircrafts
					
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
	
	public Coordinate nextShoot(Board b) throws InvalidCoordinateException, CoordinateAlreadyHitException
	{
		Objects.requireNonNull(b);	
		Coordinate c = null;
		
		c = genRandomCoordinate(b,0);
		b.hit(c);
		
		return c;
	}
	
	private int genRandomInt(int min, int max)
	{
		return random.nextInt(max-min)+min;
	}
	
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