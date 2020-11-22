package model.exceptions;

import model.Coordinate;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class CoordinateAlreadyHitException.
 */
@SuppressWarnings("serial")
public class CoordinateAlreadyHitException extends CoordinateException
{
	
	/**
	 * Instantiates a new coordinate already hit exception.
	 *
	 * @param c the c
	 */
	public CoordinateAlreadyHitException(Coordinate c)
	{
		super(c);
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage()
	{
		return "Error with te coordinate, the coordinate " + this.c + " has already been hit"+'\n';
	}
	
}