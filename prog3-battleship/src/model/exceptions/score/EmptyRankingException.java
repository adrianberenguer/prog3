package model.exceptions.score;

import model.exceptions.BattleshipException;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class EmptyRankingException.
 */
public class EmptyRankingException extends BattleshipException
{
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage()
	{
		return "The ranking is wrong";
	}
}