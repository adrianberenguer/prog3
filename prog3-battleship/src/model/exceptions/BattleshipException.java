package model.exceptions;

import model.Coordinate;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class BattleshipException.
 */
@SuppressWarnings("serial") 
public abstract class BattleshipException extends Exception
{
	
	/** The c. */
	Coordinate c;
	
	/**
	 * Instantiates a new battleship exception.
	 *
	 * @param c the c
	 */
	public BattleshipException(Coordinate c)
	{
		this.c = c;
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public abstract String getMessage();
}