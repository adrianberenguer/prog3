package model;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;


//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class Board.
 */
public class Board
{
	
	/** The Constant MAX_BOARD_SIZE. */
	private final static int MAX_BOARD_SIZE=20;
	
	/** The Constant MIN_BOARD_SIZE. */
	private final static int MIN_BOARD_SIZE=5;
	
	/** The size. */
	private int size;
	
	/** The num crafts. */
	private int numCrafts;
	
	/** The destroyed crafts. */
	private int destroyedCrafts;
	
	/** The seen. */
	private Set<Coordinate> seen;
	
	/** The Constant HIT_SYMBOL. */
	public final static char HIT_SYMBOL='•';
	
	/** The Constant WATER_SYMBOL. */
	public final static char WATER_SYMBOL=' ';
	
	/** The Constant NOTSEEN_SYMBOL. */
	public final static char NOTSEEN_SYMBOL='?';
	
	/** The board. */
	private Map<Coordinate, Ship> board;
	
	/**
	 * Instantiates a new board.
	 *
	 * @param size the size
	 */
	public Board(int size) 
	{
		board = new HashMap<Coordinate, Ship>();
		seen = new HashSet<Coordinate>();
		numCrafts=0;
		destroyedCrafts=0;
		
		if(MIN_BOARD_SIZE<=size && MAX_BOARD_SIZE>=size)
		{
			this.size=size;
		}
		else 
		{
			this.size=MIN_BOARD_SIZE;
			System.err.println();
		}
	}
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() 
	{
		return size;
	}
	
	/**
	 * Check coordinate.
	 *
	 * @param c the c
	 * @return true, if successful
	 */
	public boolean checkCoordinate(Coordinate c) 
	{
		if(c.get(0)<=size-1 && c.get(0)>=0 && c.get(1)<=size-1 && c.get(1)>=0) {
			return true;
		}
		else 
			return false;
	}
	
	/**
	 * Adds the ship.
	 *
	 * @param ship the ship
	 * @param position the position
	 * @return true, if successful
	 */
	public boolean addShip(Ship ship, Coordinate position) 
	{
		Set<Coordinate> coor = ship.getAbsolutePositions(position);
		Set<Coordinate> coordinates = board.keySet();
		
		ship.setPosition(position);
		
		for(Coordinate c: coor)
		{
			if(checkCoordinate(c) == false)
			{
				System.err.println();
				return false;
			}
		}

		for(Coordinate c: coor)
		{
			if(board.containsKey(c))
			{
				System.err.println();
				return false;
			}
		}

		Set<Coordinate> neighbors = this.getNeighborhood(ship);

		for(Coordinate c: coordinates)
		{
			if(neighbors.contains(c))
			{
				System.err.println();
				return false;
			}
		}

		for(Coordinate c2 : coor)
		{
			board.put(c2, ship);
		}
		
		numCrafts++;
		return true;
	}
	
	/**
	 * Gets the ship.
	 *
	 * @param c the c
	 * @return the ship
	 */
	public Ship getShip(Coordinate c) 
	{
		Set<Coordinate> coordi = board.keySet();
		
		for(Coordinate c1 : coordi)
		{
			if(c.equals(c1))
			{
				return board.get(c1);
			}
		}
		
		return null;
	}
	
	/**
	 * Checks if is seen.
	 *
	 * @param c the c
	 * @return true, if is seen
	 */
	public boolean isSeen(Coordinate c) 
	{
			if(seen.contains(c)) 
			{
				return true;
			}	
			
			return false;
	}
	
	/**
	 * Hit.
	 *
	 * @param c the c
	 * @return the cell status
	 */
	public CellStatus hit(Coordinate c) 
	{
		Set<Coordinate> coordinates = board.keySet();
		
		if(this.checkCoordinate(c) == false)
		{
			System.err.println();
			return CellStatus.WATER;
		}
		seen.add(c);
		for(Coordinate c1 : coordinates)
		{
			
			if(c1.equals(c) == true)
			{
				if(this.getShip(c).isHit(c) == true)
				{
					return CellStatus.WATER;
				}
				else
				{
					this.getShip(c).hit(c);
					if(this.getShip(c).isShotDown() == true)
					{
						for(Coordinate c4 : this.getNeighborhood(this.getShip(c)))
						{
							seen.add(c4);
						}
							
						destroyedCrafts++;
						return CellStatus.DESTROYED;
					}
				}
				return CellStatus.HIT;
 			}	
			
		}
		
		return CellStatus.WATER;		
	}
	
	/**
	 * Are all crafts destroyed.
	 *
	 * @return true, if successful
	 */
	public boolean areAllCraftsDestroyed() 
	{
		if(destroyedCrafts==numCrafts)
			return true;
		else
			return false;
	}
	
	/**
	 * Gets the neighborhood.
	 *
	 * @param ship the ship
	 * @param position the position
	 * @return the neighborhood
	 */
	public Set<Coordinate> getNeighborhood(Ship ship, Coordinate position) 
	{
		Set<Coordinate> neighbors = new HashSet<Coordinate>();

		if(position == null)
		{
			return neighbors;
		}
		
		Set<Coordinate> absPositions = ship.getAbsolutePositions(position);
		Set<Coordinate> adjCoord = null;
		
		if(position != null)
		{
			for(Coordinate c : absPositions)
			{
				adjCoord = c.adjacentCoordinates();
				for(Coordinate c1 : adjCoord)
				{
					if(this.checkCoordinate(c1) == true)
					{
						if(absPositions.contains(c1) == false)
						{
							neighbors.add(c1);
						}
					}
				}
				
			}
		}
		
		return neighbors;
	}
	
	/**
	 * Gets the neighborhood.
	 *
	 * @param ship the ship
	 * @return the neighborhood
	 */
	public Set<Coordinate> getNeighborhood(Ship ship)
	{
		Set<Coordinate> neighbors = getNeighborhood(ship, ship.getPosition());
		
		return neighbors;
	}
	
	/**
	 * Show.
	 *
	 * @param unveil the unveil
	 * @return the string
	 */
	public String show(boolean unveil) 
	{
		Set<Coordinate> coordinates = board.keySet();
		StringBuilder tablero = new StringBuilder();
		
		if(unveil == true)
		{
			for(int i=0; i< size; i++)
			{
				for(int j=0; j<size; j++)
				{
					if(coordinates.contains(new Coordinate(j,i)))
					{
						if(this.getShip(new Coordinate(j,i)).isHit(new Coordinate(j,i)) == true) 
						{
							tablero.append(HIT_SYMBOL);
						}
						else
						{
							tablero.append(this.getShip(new Coordinate(j,i)).getSymbol());
						}
					}
					else
					{	
						tablero.append(WATER_SYMBOL);
					}
				}
				if(i != size-1)
				{
					tablero.append("\n");
				}
			}
		}
		else
		{
			for(int i=0; i<size; i++)
			{
				for(int j=0; j<size; j++)
				{
					if(seen.contains(new Coordinate(j,i)) == true)
					{
						if(coordinates.contains(new Coordinate(j,i)))
						{
							if(this.getShip(new Coordinate(j,i)).isShotDown())
							{
								tablero.append(this.getShip(new Coordinate(j,i)).getSymbol());
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
				if(i != size-1)
				{
					tablero.append("\n");
				}
			}
		}
		
		return tablero.toString();
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Board " + size + ";" + " crafts: " + numCrafts + ";" + " destroyed: " + destroyedCrafts;
	}
	
}