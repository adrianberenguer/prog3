package model.ship;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;

import model.Board;
import model.Coordinate;
import model.CoordinateFactory;

import java.util.HashSet;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class Board.
 */
public class Board2D extends Board
{
	
	/**
	 * Instantiates a new board.
	 *
	 * @param size the size
	 */
	public Board2D(int size) 
	{
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

		if(c.get(0)<=size-1 && c.get(0)>=0 && c.get(1)<=size-1 && c.get(1)>=0 && c.getClass().getName()=="model.ship.Coordinate2D")
		{
			return true;
		}
		else if(c.getClass().getName()!="model.ship.Coordinate2D") {
			throw new IllegalArgumentException();
		}
		
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
				for(int i=0; i<size; i++)
				{
					if(coordinates.contains(CoordinateFactory.createCoordinate(i,j)))
					{
						if(this.getCraft(CoordinateFactory.createCoordinate(i,j)).isHit(CoordinateFactory.createCoordinate(i,j)) == true) 
						{
							tablero.append(HIT_SYMBOL);
						}
						else
						{
							tablero.append(this.getCraft(CoordinateFactory.createCoordinate(i,j)).getSymbol());
						}
					}
					else
					{	
						tablero.append(WATER_SYMBOL);
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
				for(int i=0; i<size; i++)
				{
					if(seen.contains(CoordinateFactory.createCoordinate(i,j)) == true)
					{
						if(coordinates.contains(CoordinateFactory.createCoordinate(i,j)))
						{
							if(this.getCraft(CoordinateFactory.createCoordinate(i,j)).isShotDown())
							{
								tablero.append(this.getCraft(CoordinateFactory.createCoordinate(i,j)).getSymbol());
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
				if(j != size-1)
				{
					tablero.append("\n");
				}
			}
		}
		
		return tablero.toString();
	}
	
}