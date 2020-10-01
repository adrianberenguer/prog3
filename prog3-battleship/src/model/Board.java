package model;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

public class Board
{
	
	private static int MAX_BOARD_SIZE=20;
	private static int MIN_BOARD_SIZE=5;
	private int size;
	private int numCrafts;
	private int destroyedCrafts;
	private Set<Coordinate> seen;
	
	public static char HIT_SYMBOL='•';
	public static char WATER_SYMBOL=' ';
	public static char NOTSEEN_SYMBOL='?';
	private Map<Coordinate, Board> board;
	
	public Board(int size) 
	{
		board = new HashMap<Coordinate, Board>();
		seen = new HashSet<Coordinate>();
		numCrafts=0;
		destroyedCrafts=0;
		
		if(MIN_BOARD_SIZE<size && MAX_BOARD_SIZE>size)
		{
			this.size=size;
		}
		else 
		{
			size=MIN_BOARD_SIZE;
			System.err.println();
		}
	}
	
	public int getSize() 
	{
		return size;
	}
	
	public boolean checkCoordinate(Coordinate c) 
	{
		if(c.get(0)<=size-1 && c.get(0)>=0 && c.get(1)<=size-1 && c.get(1)>=0) {
			return true;
		}
		else 
			return false;
	}
	
	public boolean addShip(Ship ship, Coordinate position) 
	{
		
	}
	
	public Ship getShip(Coordinate c) 
	{
		
		
	}
	
	public boolean isSeen(Coordinate c) 
	{
			if(seen.contains(c)) 
				return true;
			else
				return false;
	}
	
	public CellStatus hit(Coordinate c) 
	{
		
	}
	
	public boolean areAllCraftsDestroyed() 
	{
		if(destroyedCrafts==numCrafts)
			return true;
		else
			return false;
	}
	
	public Set<Coordinate> getNeighborhood(Ship ship, Coordinate position) 
	{
		
	}
	
	public Set<Coordinate> getNeighborhood(Ship ship)
	{
		
	}
	
	public String show(boolean unveil) 
	{
		
	}
	
	public String toString() {
		return "Board" + size + ";" + "crafts: " + numCrafts + ";" + "destroyed: " + destroyedCrafts;
	}
	
}