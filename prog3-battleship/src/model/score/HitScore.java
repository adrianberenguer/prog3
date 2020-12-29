package model.score;

import model.CellStatus;
import model.io.IPlayer;


//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class HitScore.
 */
public class HitScore extends Score<CellStatus>
{
	
	/**
	 * Instantiates a new hit score.
	 *
	 * @param player the player
	 */
	public HitScore(IPlayer player)
	{
		super(player);
	}
	
	/**
	 * Score.
	 *
	 * @param sc the sc
	 */
	public void score(CellStatus sc)
	{
		if(sc == CellStatus.HIT)
		{
			score++;
		}
		if(sc == CellStatus.DESTROYED)
		{
			score++;
		}
		
	}
	
}