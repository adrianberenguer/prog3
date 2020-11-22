package model.exceptions.io;

import model.Coordinate;
import model.exceptions.BattleshipException;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

@SuppressWarnings("serial")
public class BattleshipIOException extends BattleshipException
{
	private String message;
		
	public BattleshipIOException(String m) {
		this.message=m;
	}
	
	public String getMessage() 
	{
		return message;
	}
	
	
}