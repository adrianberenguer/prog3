package model.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

import model.Board;
import model.CellStatus;
import model.Coordinate;
import model.CoordinateFactory;
import model.Craft;
import model.CraftFactory;
import model.Orientation;
import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
import model.exceptions.io.BattleshipIOException;


//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class PlayerFile.
 */
public class PlayerFile implements IPlayer
{
	
	/** The last shot status. */
	private CellStatus lastShotStatus;
	
	/** The br. */
	private BufferedReader br; 
	
	/** The name. */
	private String name;
	
	/**
	 * Instantiates a new player file.
	 *
	 * @param name the name
	 * @param reader the reader
	 */
	public PlayerFile(String name, BufferedReader reader)
	{
		this.name=name;
		lastShotStatus = null;
		if(reader==null)
		{
			throw new NullPointerException();
		}
		else
		{
			this.br=reader;
		}
		
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
	 * @throws BattleshipIOException the battleship IO exception
	 * @throws InvalidCoordinateException the invalid coordinate exception
	 * @throws OccupiedCoordinateException the occupied coordinate exception
	 * @throws NextToAnotherCraftException the next to another craft exception
	 */
	public void putCrafts(Board b) throws BattleshipIOException, InvalidCoordinateException, OccupiedCoordinateException, NextToAnotherCraftException
	{
		Objects.requireNonNull(b);
		String line;
		
		try {
			while((line = br.readLine()) != null && !(line.contains("endput")) && !(line.contains("exit")))
			{
				Craft craft;
				
				
				String[] linesOut =line.split("\\s+");
				Coordinate c;
				boolean comp = false; //para comprobar si la orientacion es una de las que tenemos
				
						
				if(linesOut[0].equals("put"))
				{
					
					if(linesOut.length<5)
					{
						throw new BattleshipIOException("It is needed one more parameter"+ '\n');
					}
					else if(linesOut.length==5)
					{
						try
						{
							c = CoordinateFactory.createCoordinate(Integer.parseInt(linesOut[3]),Integer.parseInt(linesOut[4]));
						}
						catch(Exception e)
						{
							throw new BattleshipIOException("The coordinate couldnt be created with parseInt");
						}
								
						for(Orientation orientation: Orientation.values())
						{
							if(orientation.name().equals(linesOut[2]))
							{
								craft = CraftFactory.createCraft(linesOut[1],Orientation.valueOf(linesOut[2]));
								b.addCraft(craft, c);
								comp = true;
							}
						}
						if(!comp)
						{
							throw new BattleshipIOException("Error in the orientation " + linesOut[2] + ", that is not an option"+ '\n');
						}
					}
					else if(linesOut.length==6)
					{
						
						comp = false;
							
						try
						{
							c = CoordinateFactory.createCoordinate(Integer.parseInt(linesOut[3]),Integer.parseInt(linesOut[4]),Integer.parseInt(linesOut[5]));
						}
						catch(Exception e)
						{
							throw new BattleshipIOException("The coordinate couldnt be created with parseInt");
						}
							
						for(Orientation orientation: Orientation.values())
						{
							if(orientation.name().equals(linesOut[2]))
							{
								craft = CraftFactory.createCraft(linesOut[1],Orientation.valueOf(linesOut[2]));
								b.addCraft(craft, c);
								comp = true;
							}				
						}
						if(!comp)
						{
							throw new BattleshipIOException("Error in the orientation " + linesOut[2] + ", that is not an option"+ '\n');
						}	
								
					}
					else 
					{
						throw new BattleshipIOException("The parameters are not correct in the put command"+ '\n');
					}
				}
				else if(linesOut[0].equals("shoot"))
				{
					throw new BattleshipIOException("This should be a put command or an endput"+ '\n');
				}
				else
				{
					throw new BattleshipIOException("Error in the commands"+ '\n');
				}
											
			}
		} 
		catch (IOException e) {
			throw new BattleshipIOException("Error in the putCraft method\n");
		}
		
					
	}
	
	/**
	 * Next shoot.
	 *
	 * @param b the b
	 * @return the coordinate
	 * @throws InvalidCoordinateException the invalid coordinate exception
	 * @throws CoordinateAlreadyHitException the coordinate already hit exception
	 * @throws BattleshipIOException the battleship IO exception
	 */
	public Coordinate nextShoot(Board b) throws InvalidCoordinateException, CoordinateAlreadyHitException, BattleshipIOException
	{
		Objects.requireNonNull(b);
		String line;
		Coordinate c = null;
		lastShotStatus = null;
		
		try {
			while((line = br.readLine()) != null)
			{
				String[] linesOut =line.split("\\s+");
				
				
				if (line.contains("exit") || line == null) {
					lastShotStatus = null;
					return null;
				}
				
				if(linesOut[0].equals("shoot"))
				{
					if(linesOut.length < 3)
					{
						throw new BattleshipIOException("Error in the commands, there are not suficient parameters" + '\n');
					}
					else if(linesOut.length == 3)
					{
						c = CoordinateFactory.createCoordinate(Integer.parseInt(linesOut[1]),Integer.parseInt(linesOut[2]));
						
						//b.hit(c);
						lastShotStatus = b.hit(c);
						return c;
					}
					else if(linesOut.length == 4)
					{
						c = CoordinateFactory.createCoordinate(Integer.parseInt(linesOut[1]),Integer.parseInt(linesOut[2]), Integer.parseInt(linesOut[3]));
						//b.hit(c);
						lastShotStatus = b.hit(c);
						return c;
					}
					else
					{
						throw new BattleshipIOException("Error in the commands, there are too many parameters" +'\n');
					}
				}
				else
				{
					throw new BattleshipIOException("Error in the commands" + '\n');
				}
				
			}
		} catch (NumberFormatException |IOException e) {
			throw new BattleshipIOException("Error in the commands" + '\n');
		}
			
		return null;
	}
	
}