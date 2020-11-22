package model.aircraft;

import java.util.Set;

import model.Board;
import model.Coordinate;
import model.CoordinateFactory;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class Board3D.
 */
public class Board3D extends Board
{

	/**
	 * Instantiates a new board 3 D.
	 *
	 * @param size the size
	 */
	public Board3D(int size) {
		super(size);
		
	}
	
	/**
	 * Check coordinate.
	 *
	 * @param c the c
	 * @return true, if successful
	 */
	@Override
	public boolean checkCoordinate(Coordinate c) 
	{
		if(c.get(0)<=size-1 && c.get(0)>=0 && c.get(1)<=size-1 && c.get(1)>=0 && c.get(2)<=size-1 && c.get(2)>=0 && c.getClass().getName()=="model.aircraft.Coordinate3D") {
			return true;
		}
		else if(c.getClass().getName()!="model.aircraft.Coordinate3D")
			throw new IllegalArgumentException();
	
		return false;
	}

	/**
	 * Show.
	 *
	 * @param unveil the unveil
	 * @return the string
	 */
	@Override
	public String show(boolean unveil) 
	{
		Set<Coordinate> coordinates = board.keySet();
		StringBuilder tablero = new StringBuilder();
		
		if(unveil == true)
		{
			
			for(int j=0; j< size; j++)
			{
				for(int k=0;k<size;k++)
				{
					for(int i=0; i<size; i++)
					{
						if(coordinates.contains(CoordinateFactory.createCoordinate(i,j,k)))
						{
							if(this.getCraft(CoordinateFactory.createCoordinate(i,j,k)).isHit(CoordinateFactory.createCoordinate(i,j,k)) == true) 
							{
								tablero.append(HIT_SYMBOL);
							}
							else
							{
								tablero.append(this.getCraft(CoordinateFactory.createCoordinate(i,j,k)).getSymbol());
							}
						}
						else
						{	
							tablero.append(WATER_SYMBOL);
						}
					}
					if(k!=size-1)
					{
						tablero.append("|");
					}
				}
				if(j != size-1)
				{
					tablero.append("\n");
				}
			}
			
		}
		else
		{
			for(int j=0; j<size; j++)
			{
				for(int k = 0; k < size; k++)
				{
					for(int i=0; i<size; i++)
					{
						if(isSeen(CoordinateFactory.createCoordinate(i,j,k)) == true)
						{
							if(coordinates.contains(CoordinateFactory.createCoordinate(i,j,k)))
							{
								if(this.getCraft(CoordinateFactory.createCoordinate(i,j,k)).isShotDown())
								{
									tablero.append(this.getCraft(CoordinateFactory.createCoordinate(i,j,k)).getSymbol());
								}
								else
								{
									tablero.append(HIT_SYMBOL);
								}
							}
							else
							{
								tablero.append(WATER_SYMBOL);
							}
						}
						else
						{
							tablero.append(NOTSEEN_SYMBOL);
						}
					}
					if(k!=size-1)
					{
						tablero.append("|");
					}
				}
				if(j != size-1)
				{
					tablero.append("\n");
				}
			}
		}
		
		return tablero.toString();
	}
	
}
