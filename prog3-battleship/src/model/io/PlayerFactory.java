package model.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

import model.exceptions.io.BattleshipIOException;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

public class PlayerFactory
{
	private static boolean isLong(String s)
	{
		try
		{
			long l = Long.parseLong(s);
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	public static IPlayer createPlayer(String name, String s) throws BattleshipIOException
	{
		Objects.requireNonNull(s);
		IPlayer player = null;
		BufferedReader br=null;
		
		try
		{
			if(s.contains(".") || s.contains("/") || s.contains("\\") )
			{
				br = new BufferedReader(new FileReader(s));
				player = new PlayerFile(name, br);
			}
			else if(isLong(s))
			{
				player = new PlayerRandom(name, Long.parseLong(s));
			}
		}
		catch(Exception e)
		{
			throw new BattleshipIOException("The file " + s + " doesn't exist "+"\n");
		}
		
		return player;
	}
	
}