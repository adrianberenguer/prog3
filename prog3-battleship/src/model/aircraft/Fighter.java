package model.aircraft;

import model.Craft;
import model.Orientation;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class Fighter.
 */
public class Fighter extends Aircraft
{

	/**
	 * Instantiates a new fighter.
	 *
	 * @param o the o
	 */
	public Fighter(Orientation o) {
		
		super(o, '⇄', "Fighter");

		shape = new int[][] {
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 1, 1, 1, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 1, 0, 0,	
			1, 1, 1, 1, 0,	
			0, 0, 1, 0, 0,
			0, 0, 0, 0, 0},
		      { 0, 0, 1, 0, 0,
			0, 0, 1, 0, 0,	
			0, 1, 1, 1, 0,	
			0, 0, 1, 0, 0,
			0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 1, 0, 0,	
			0, 1, 1, 1, 1,	
			0, 0, 1, 0, 0,
			0, 0, 0, 0, 0}};
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Override
	public int getValue() {
		return 10;
	}
	
}