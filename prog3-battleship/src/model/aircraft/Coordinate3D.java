package model.aircraft;

import java.util.HashSet;
import java.util.Set;
import model.Coordinate;
import model.ship.Coordinate2D;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

public class Coordinate3D extends Coordinate
{
	
	public Coordinate3D(int x, int y)
	{
		
	}
	public Coordinate3D(Coordinate3D c)
	{
		
	}
	
	public Set<Coordinate> adjacentCoordinates()
	{
		Set<Coordinate> adjCoor= new HashSet<Coordinate>();
		
		for(int i=-1;i<2;i++)
		{
			for(int j=-1;j<2;j++)
			{
				if((i==0 && j==0) == false)
				{
					adjCoor.add(this.add(new Coordinate3D(i,j)));
				}
			}
		}
		
		return adjCoor;
	}
	
	public Coordinate3D copy()
	{
		return new Coordinate3D(this);
	}
	
	public String toString()
	{
        StringBuilder coordinates = new StringBuilder("(");
        
        for(int i=0;i<;i++)
        {
        	coordinates.append();
        }
        coordinates.append(")");
        
        return coordinates.toString();
	}
	
}