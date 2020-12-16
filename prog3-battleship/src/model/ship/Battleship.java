package model.ship;

import model.Coordinate;
import model.Orientation;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class Battleship.
 */
public class Battleship extends Ship
{

	/**
	 * Instantiates a new battleship.
	 *
	 * @param o the o
	 */
	public Battleship(Orientation o) {
		
		super(o,'O',"Battleship");
		
		shape = new int[][] {
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0,	
			0, 1, 1, 1, 1,	
			0, 0, 0, 0, 0,
			0, 0, 0, 0, 0},
		      { 0, 0, 0, 0, 0,
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,	
		    	0, 0, 1, 0, 0,
		    	0, 0, 1, 0, 0},
		      { 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0,	
			0, 1, 1, 1, 1,	
			0, 0, 0, 0, 0,
			0, 0, 0, 0, 0}}; 
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	@Override
	public int getValue() {
		return 6;
	}
	
}