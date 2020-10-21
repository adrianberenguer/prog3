package model.exceptions;

import model.Coordinate;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

@SuppressWarnings("serial")
public class InvalidCoordinateException extends BattleshipException
{
	
	public InvalidCoordinateException(Coordinate c) {
		super(c);
	}

	public String getMessage() 
	{
		return "Error with the coordinate, the coordinate is out of the board size"+'\n';
	}
	
}