package model.aircraft;

import java.util.HashSet;
import java.util.Set;
import model.Coordinate;
import model.CoordinateFactory;
import model.ship.Coordinate2D;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class Coordinate3D.
 */
public class Coordinate3D extends Coordinate
{
	
	/**
	 * Instantiates a new coordinate 3 D.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public Coordinate3D(int x, int y, int z)
	{
		super(3);
		
		super.set(0, x);
		super.set(1, y);
		super.set(2, z);
	}
	
	/**
	 * Instantiates a new coordinate 3 D.
	 *
	 * @param c the c
	 */
	public Coordinate3D(Coordinate3D c)
	{
		super(c);
	}
	
	/**
	 * Adjacent coordinates.
	 *
	 * @return the sets the
	 */
	public Set<Coordinate> adjacentCoordinates()
	{
		Set<Coordinate> adjCoor= new HashSet<Coordinate>();
		
		for(int i=-1;i<2;i++)
		{
			for(int j=-1;j<2;j++)
			{
				for(int k=-1;k<2;k++)
				{
					if((i==0 && j==0 && k==0) == false)
					{
						//int[] cords = new int[] {i,j};
						//Coordinate c = CoordinateFactory.createCoordinate(cords);
						//adjCoor.add(this.add(c));
						//adjCoor.add(this.add(new Coordinate3D(i,j,k)));
						adjCoor.add(this.add(CoordinateFactory.createCoordinate(i,j,k)));
					}
				}
			}
		}
		
		return adjCoor;
	}
	
	/**
	 * Copy.
	 *
	 * @return the coordinate 3 D
	 */
	public Coordinate3D copy()
	{
		return new Coordinate3D(this.get(0),this.get(1),this.get(2));
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString()
	{
        StringBuilder concatenation = new StringBuilder("(");
        
        for (int i=0;i<3;i++)
        {
           concatenation.append(this.get(i));
           if (i<3-1) // no es la última
              concatenation.append(", ");
        }
        concatenation.append(")");
        return concatenation.toString();
	}
	
}