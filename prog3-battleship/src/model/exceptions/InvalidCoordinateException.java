package model.exceptions;

import model.Coordinate;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class InvalidCoordinateException.
 */
@SuppressWarnings("serial")
public class InvalidCoordinateException extends BattleshipException
{
	
	/**
	 * Instantiates a new invalid coordinate exception.
	 *
	 * @param c the c
	 */
	public InvalidCoordinateException(Coordinate c) {
		super(c);
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() 
	{
		return "Error with the coordinate, the coordinate is out of the board size"+'\n';
	}
	
}