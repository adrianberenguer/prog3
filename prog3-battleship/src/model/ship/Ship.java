package model.ship;

import java.util.Arrays;

import model.Craft;
import model.Orientation;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class Ship.
 */
public abstract class Ship extends Craft
{
	
	/**
	 * Instantiates a new ship.
	 *
	 * @param o the o
	 * @param s the s
	 * @param n the n
	 */
	public Ship(Orientation o, char s, String n)
	{
		super(o,s,n);
	}
	
}
