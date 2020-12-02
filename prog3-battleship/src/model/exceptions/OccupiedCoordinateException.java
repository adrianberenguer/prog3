package model.exceptions;

import model.Coordinate;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class OccupiedCoordinateException.
 */
@SuppressWarnings("serial")
public class OccupiedCoordinateException extends CoordinateException
{

	/**
	 * Instantiates a new occupied coordinate exception.
	 *
	 * @param c the c
	 */
	public OccupiedCoordinateException(Coordinate c) {
		super(c);
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return "Error with the coordinate, the coordinate " +  this.c + " is already occupied by another craft"+ '\n';
	}
	
}