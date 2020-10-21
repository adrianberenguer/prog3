package model.ship;

import java.util.HashSet;
import java.util.Set;
import model.Coordinate;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

public class Coordinate2D extends Coordinate
{
	public Coordinate2D(int x, int y)
	{
		super(2);
		
		super.set(0, x);
		super.set(1, y);
	}
	
	public Coordinate2D(Coordinate2D c)
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
					adjCoor.add(this.add(new Coordinate2D(i,j)));
				}
			}
		}
		
		return adjCoor;
	}
	
	public Coordinate2D copy()
	{
		return new Coordinate2D(this);
	}
	
	public String toString()
	{
        StringBuilder concatenation = new StringBuilder("(");
        
        for (int i=0;i<2;i++)
        {
           concatenation.append(this.get(i));
           if (i<2-1) // no es la última
              concatenation.append(", ");
        }
        concatenation.append(")");
        return concatenation.toString();
	}
	
}
