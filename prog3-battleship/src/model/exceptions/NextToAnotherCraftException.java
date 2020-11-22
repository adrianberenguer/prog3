package model.exceptions;

import model.Coordinate;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class NextToAnotherCraftException.
 */
@SuppressWarnings("serial")
public class NextToAnotherCraftException extends CoordinateException
{
	
	/**
	 * Instantiates a new next to another craft exception.
	 *
	 * @param c the c
	 */
	public NextToAnotherCraftException(Coordinate c) {
		super(c);
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return "Error with the coordinate, the coordinate " + this.c + " to be occupied is next to another one occupied by another craft"+'\n';
	}
	
}