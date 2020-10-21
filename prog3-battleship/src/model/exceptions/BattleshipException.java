package model.exceptions;

import model.Coordinate;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

@SuppressWarnings("serial") 
public abstract class BattleshipException extends Exception
{
	Coordinate c;
	
	public BattleshipException(Coordinate c)
	{
		this.c = c;
	}
	
	public abstract String getMessage();
}