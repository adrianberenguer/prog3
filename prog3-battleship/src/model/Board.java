package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
import model.ship.Ship;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class Board.
 */
public abstract class Board {

	/** The Constant MAX_BOARD_SIZE. */
	public static final int MAX_BOARD_SIZE = 20;
	/** The Constant MIN_BOARD_SIZE. */
	public static final int MIN_BOARD_SIZE = 5;
	/** The size. */
	protected int size;
	/** The num crafts. */
	protected int numCrafts;
	/** The destroyed crafts. */
	protected int destroyedCrafts;
	/** The seen. */
	protected Set<Coordinate> seen;
	/** The Constant HIT_SYMBOL. */
	public static final char HIT_SYMBOL = '•';
	/** The Constant WATER_SYMBOL. */
	public static final char WATER_SYMBOL = ' ';
	/** The Constant NOTSEEN_SYMBOL. */
	public static final char NOTSEEN_SYMBOL = '?';
	/** The board. */
	protected Map<Coordinate, Craft> board;
	
	/** The Constant Board_SEPARATOR. */
	public static final char Board_SEPARATOR = '|';

	/**
	 * Instantiates a new board.
	 *
	 * @param size the size
	 */
	public Board(int size) {
		board = new HashMap<Coordinate, Craft>();
		seen = new HashSet<Coordinate>();
		numCrafts=0;
		destroyedCrafts=0;
		
		if(MIN_BOARD_SIZE<=size && MAX_BOARD_SIZE>=size)
		{
			this.size=size;
		}
		else 
		{
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Check coordinate.
	 *
	 * @param c the c
	 * @return true, if successful
	 */
	abstract public boolean checkCoordinate(Coordinate c);
	
	/**
	 * Show.
	 *
	 * @param unveil the unveil
	 * @return the string
	 */
	public abstract String show(boolean unveil);
	
	/**
	 * Adds the ship.
	 *
	 * @param craft the craft
	 * @param position the position
	 * @return true, if successful
	 * @throws InvalidCoordinateException the invalid coordinate exception
	 * @throws OccupiedCoordinateException the occupied coordinate exception
	 * @throws NextToAnotherCraftException the next to another craft exception
	 */
	public boolean addCraft(Craft craft, Coordinate position) throws InvalidCoordinateException, OccupiedCoordinateException, NextToAnotherCraftException {
		Set<Coordinate> coor = craft.getAbsolutePositions(position);
		Set<Coordinate> coordinates = board.keySet();
		
		for(Coordinate c: coor)
		{
			if(checkCoordinate(c) == false)
			{
				
				throw new InvalidCoordinateException(position);
			}
		}
	
		for(Coordinate c: coor)
		{
			if(board.containsKey(c))
			{
				throw new OccupiedCoordinateException(position);
			}
		}
	
		Set<Coordinate> neighbors = this.getNeighborhood(craft, position);
	
		for(Coordinate c: coordinates)
		{
			if(neighbors.contains(c))
			{
				throw new NextToAnotherCraftException(c);
			}
		}
	
		for(Coordinate c2 : coor)
		{
			board.put(c2, craft);
		}
		
		craft.setPosition(position);
		
		numCrafts++;
		return true;
	}

	/**
	 * Gets the ship.
	 *
	 * @param c the c
	 * @return the ship
	 */
	public Craft getCraft(Coordinate c) {
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
	public boolean isSeen(Coordinate c) {
			
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
	 * @throws InvalidCoordinateException the invalid coordinate exception
	 * @throws CoordinateAlreadyHitException the coordinate already hit exception
	 */
	public CellStatus hit(Coordinate c) throws InvalidCoordinateException, CoordinateAlreadyHitException {
		Set<Coordinate> coordinates = board.keySet();
		
		if(this.checkCoordinate(c) == false)
		{
			throw new InvalidCoordinateException(c);
		}
		seen.add(c.copy());
		for(Coordinate c1 : coordinates)
		{
			
			if(c1.equals(c) == true)
			{
				
				this.getCraft(c).hit(c);
				if(this.getCraft(c).isShotDown() == true)
				{
					for(Coordinate c4 : this.getNeighborhood(this.getCraft(c)))
					{
						seen.add(c4);
					}
						
					destroyedCrafts++;
					return CellStatus.DESTROYED;
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
	public boolean areAllCraftsDestroyed() {
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
	public Set<Coordinate> getNeighborhood(Craft ship, Coordinate position) {
		Set<Coordinate> neighbors = new HashSet<Coordinate>();
	
		if(position == null && ship == null)
		{
			throw new NullPointerException();
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
	public Set<Coordinate> getNeighborhood(Craft ship) {
		Set<Coordinate> neighbors = getNeighborhood(ship, ship.getPosition());
		
		return neighbors;
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