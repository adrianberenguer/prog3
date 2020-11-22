package model.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

import model.Board;
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
import model.ship.Ship;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

public class PlayerFile implements IPlayer
{
	private BufferedReader br; 
	private String name;
	
	public PlayerFile(String name, BufferedReader reader)
	{
		this.name=name;
		
		if(reader==null)
		{
			throw new NullPointerException();
		}
		else
		{
			this.br=reader;
		}
		
	}
	
	public String getName()
	{
		return name + " (" + /*"PlayerFile"*/ getClass().getSimpleName() + ")";
	}
	
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
						c = CoordinateFactory.createCoordinate(Integer.parseInt(linesOut[3]),Integer.parseInt(linesOut[4]));
								
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
						c = CoordinateFactory.createCoordinate(Integer.parseInt(linesOut[3]),Integer.parseInt(linesOut[4]),Integer.parseInt(linesOut[5]));
							
						for(Orientation orientation: Orientation.values())
						{
							if(orientation.name().equals(linesOut[2]))
							{
								craft = CraftFactory.createCraft(linesOut[1],Orientation.valueOf(linesOut[2]));
								b.addCraft(craft, c);
								comp = true;
							}
							if(!comp)
							{
								throw new BattleshipIOException("Error in the orientation " + linesOut[2] + ", that is not an option"+ '\n');
							}					
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
	
	public Coordinate nextShoot(Board b) throws InvalidCoordinateException, CoordinateAlreadyHitException, BattleshipIOException
	{
		Objects.requireNonNull(b);
		String line;
		Coordinate c = null;
		
		try {
			while((line = br.readLine()) != null)
			{
				String[] linesOut =line.split("\\s+");
				System.out.println(line);
				
				if (line.contains("exit") || line == null) {
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
						b.hit(c);
						return c;
					}
					else if(linesOut.length == 4)
					{
						c = CoordinateFactory.createCoordinate(Integer.parseInt(linesOut[1]),Integer.parseInt(linesOut[2]), Integer.parseInt(linesOut[3]));
						b.hit(c);
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
		} catch (NumberFormatException | InvalidCoordinateException | CoordinateAlreadyHitException
				| BattleshipIOException | IOException e) {
			throw new BattleshipIOException("Error in the commands" + '\n');
		}
			
		return null;
	}
	
}