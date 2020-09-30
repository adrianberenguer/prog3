package model;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

public class Board
{
	
	private int MAX_BOARD_SIZE;
	private int MIN_BOARD_SIZE;
	private int size;
	private int numCrafts;
	private int destroyedCrafts;
	private ArrayList<Coordinate> seen;
	
	public char HIT_SYMBOL;
	public char WATER_SYMBOL;
	public char NOTSEEN_SYMBOL;
	
	public Board(int size) 
	{
		
	}
	
	public int getSize() 
	{
		
	}
	
	public boolean checkCoordinate(Coordinate c) 
	{
		
	}
	
	public boolean add(Ship ship, Coordinate position) 
	{
		
	}
	
	public Ship getShip(Coordinate c) 
	{
		
	}
	
	public boolean isSeen(Coordinate c) 
	{
		
	}
	
	public CellStatus hit(Coordinate c) 
	{
		
	}
	
	public boolean areAllCraftsDestroyed() 
	{
		
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
	
	public String toString() 
	{
		
	}
	
}