package model.exceptions;

import model.Coordinate;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

@SuppressWarnings("serial")
public class CoordinateAlreadyHitException extends BattleshipException
{
	
	public CoordinateAlreadyHitException(Coordinate c)
	{
		super(c);
	}
	
	public String getMessage()
	{
		return "Error with te coordinate, the coordinate has already been hit"+'\n';
	}
	
}