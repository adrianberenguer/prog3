package model.score;

import model.Craft;
import model.io.IPlayer;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class CraftScore.
 */
public class CraftScore extends Score<Craft>
{
	
	/**
	 * Instantiates a new craft score.
	 *
	 * @param player the player
	 */
	public CraftScore(IPlayer player)
	{
		super(player);
	}
	
	/**
	 * Score.
	 *
	 * @param sc the sc
	 */
	@Override
	public void score(Craft sc)
	{
		score = score + sc.getValue();
	}
	
}