package model.ship;

import model.Coordinate;
import model.Orientation;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class Cruiser.
 */
public class Cruiser extends Ship
{

	/**
	 * Instantiates a new cruiser.
	 *
	 * @param o the o
	 */
	public Cruiser(Orientation o) {
		super(o, 'Ø', "Cruiser");

		shape = new int[][] {
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0,	
			0, 1, 1, 1, 0,	
			0, 0, 0, 0, 0,
			0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 1, 0, 0,	
			0, 0, 1, 0, 0,	
			0, 0, 1, 0, 0,
			0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0,	
			0, 1, 1, 1, 0,	
			0, 0, 0, 0, 0,
			0, 0, 0, 0, 0}}; 
	}
	
}