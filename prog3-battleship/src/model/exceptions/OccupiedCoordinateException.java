package model.exceptions;

import model.Coordinate;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

@SuppressWarnings("serial")
public class OccupiedCoordinateException extends BattleshipException
{

	public OccupiedCoordinateException(Coordinate c) {
		super(c);
	}

	public String getMessage() {
		return "Error with the coordinate, the coordinate is already occupied by another craft"+ '\n';
	}
	
}