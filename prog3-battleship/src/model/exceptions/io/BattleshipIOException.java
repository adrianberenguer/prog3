package model.exceptions.io;

import model.Coordinate;
import model.exceptions.BattleshipException;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class BattleshipIOException.
 */
@SuppressWarnings("serial")
public class BattleshipIOException extends BattleshipException
{
	
	/** The message. */
	private String message;
		
	/**
	 * Instantiates a new battleship IO exception.
	 *
	 * @param m the m
	 */
	public BattleshipIOException(String m) {
		this.message=m;
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() 
	{
		return message;
	}
	
	
}