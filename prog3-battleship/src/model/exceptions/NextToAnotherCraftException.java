package model.exceptions;

import model.Coordinate;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

@SuppressWarnings("serial")
public class NextToAnotherCraftException extends BattleshipException
{
	
	public NextToAnotherCraftException(Coordinate c) {
		super(c);
	}

	public String getMessage() {
		return "Error with the coordinate, the coordinate to be occupied is next to another one occupied by another craft"+'\n';
	}
	
}