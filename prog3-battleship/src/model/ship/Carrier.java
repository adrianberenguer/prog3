package model.ship;

import model.Coordinate;
import model.Orientation;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class Carrier.
 */
public class Carrier extends Ship
{

	/**
	 * Instantiates a new carrier.
	 *
	 * @param o the o
	 */
	public Carrier(Orientation o) {
		super(o, '®', "Carrier");
		
		shape = new int[][] {
		      { 0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0},
		      { 0, 0, 0, 0, 0,
		        0, 0, 0, 0, 0,	
			1, 1, 1, 1, 1,	
			0, 0, 0, 0, 0,
			0, 0, 0, 0, 0},
		      { 0, 0, 1, 0, 0,
			0, 0, 1, 0, 0,	
			0, 0, 1, 0, 0,	
			0, 0, 1, 0, 0,
			0, 0, 1, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0,	
			1, 1, 1, 1, 1,	
			0, 0, 0, 0, 0,
			0, 0, 0, 0, 0}}; 
	}
	
}