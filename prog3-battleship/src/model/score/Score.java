package model.score;

import model.io.IPlayer;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class Score.
 *
 * @param <T> the generic type
 */
public abstract class Score<T> implements Comparable<Score<T>>
{
	
	/** The player. */
	private IPlayer player;
	
	/** The score. */
	protected int score;
	
	/**
	 * Instantiates a new score.
	 *
	 * @param player the player
	 */
	public Score(IPlayer player)
	{
		this.player = player;
		score = 0;
	}
	
	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * Compare to.
	 *
	 * @param other the other
	 * @return the int
	 * @throws NullPointerException the null pointer exception
	 * @throws ClassCastException the class cast exception
	 */
	public int compareTo(Score<T> other) throws NullPointerException, ClassCastException
	{
		
		if(this.score > other.score)
		{
			return -1;
		}
		else if(this.score < other.score)
		{
			return 1;
		}

		return player.getName().compareTo(other.player.getName());
		
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString()
	{
		return player.getName() + ": " + score; 
	}
	
	/**
	 * Score.
	 *
	 * @param sc the sc
	 */
	public abstract void score(T sc);
	
}