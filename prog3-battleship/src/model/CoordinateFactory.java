package model;

import java.util.*;
import java.util.HashSet;
import java.util.Set;
import model.Coordinate;
import model.ship.Coordinate2D;
import model.aircraft.Coordinate3D;
import model.exceptions.InvalidCoordinateException;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * A factory for creating Coordinate objects.
 */
public class CoordinateFactory
{
	
	/**
	 * Creates a new Coordinate object.
	 *
	 * @param coords the coords
	 * @return the coordinate
	 */
	public static Coordinate createCoordinate(int ... coords)
	{
		Coordinate c2=null;
		
		if(coords.length<2 || coords.length>3)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			if(coords.length==2)
			{
		
				c2 = new Coordinate2D(coords[0],coords[1]);			
				
			}
			if(coords.length==3)
			{
				Coordinate c3 = null;
				
				c3 = new Coordinate3D(coords[0], coords[1], coords[2]);
				
				return c3;
			}
		}
		
		return c2;
	}
	
}

