package model;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

public class Ship
{
	
	private final static int BOUNDING_SQUARE_SIZE=5;
	private final static int HIT_VALUE=-1;
	private final static int CRAFT_VALUE=1;
	private char symbol;
	private String name;
	private int[][] shape = new int[][] {
        { 0, 0, 0, 0, 0,               // NORTH    ·····
            0, 0, 1, 0, 0,               //          ··#··
            0, 0, 1, 0, 0,               //          ··#··
            0, 0, 1, 0, 0,               //          ..#..
            0, 0, 0, 0, 0},              //          ·····

          { 0, 0, 0, 0, 0,               // EAST     ·····
            0, 0, 0, 0, 0,               //          ·····
            0, 1, 1, 1, 0,               //          ·###·
            0, 0, 0, 0, 0,               //          ·····
            0, 0, 0, 0, 0},              //          ·····

          { 0, 0, 0, 0, 0,               // SOUTH    ·····
            0, 0, 1, 0, 0,               //          ··#··
            0, 0, 1, 0, 0,               //          ··#··
            0, 0, 1, 0, 0,               //          ..#..
            0, 0, 0, 0, 0},              //          ·····

          { 0, 0, 0, 0, 0,               // WEST     ·····
            0, 0, 0, 0, 0,               //          ·····
            0, 1, 1, 1, 0,               //          ·###·
            0, 0, 0, 0, 0,               //          ·····
            0, 0, 0, 0, 0}};             //          ·····	
	
	
	private Coordinate position;
	private Orientation orientation;
	
	public Ship(Orientation o, char s, String n)
	{
		orientation = o;
		symbol = s;
		name = n;
		position = null;
	}
	
	public Coordinate getPosition(Coordinate position)
	{
		if(position!=null)
			return position.copy();
		else
			return null;
	}
	
	public void setPosition(Coordinate position)
	{
		this.position=position.copy();
	}
	
	public String getName()
	{
		return name;
	}
	
	public Orientation getOrientation()
	{
		return orientation;
	}
	
	public char getSymbol() 
	{
		return symbol;
	}
	
	public int[][] getShape()
	{
		int shapeCopy[][] = new int[4][this.BOUNDING_SQUARE_SIZE*this.BOUNDING_SQUARE_SIZE];
		
		for(int i=0; i<this.shape.length; i++)
		{
			for(int j=0; j<this.BOUNDING_SQUARE_SIZE*this.BOUNDING_SQUARE_SIZE; j++)
			{
				shapeCopy[i][j]=this.shape[i][j];
			}
		}
		
		return shapeCopy;
	}
	
	public int getShapeIndex(Coordinate c)
	{
		int shapePos,corX,corY;
		
		corX=c.get(0);
		corY=c.get(1);
		shapePos=corY*BOUNDING_SQUARE_SIZE+corX;
		
		return shapePos;
	}
	
	public Set<Coordinate> getAbsolutePositions(Coordinate position)
	{
		int absCor;
		absCor=getShapeIndex(position);
		Set<Coordinate> absolutePos = new HashSet<Coordinate>();
		Coordinate pos = new Coordinate(0,0);
		
		for(int i=0; i<BOUNDING_SQUARE_SIZE; i++)
		{	
			for(int j=0; j<BOUNDING_SQUARE_SIZE; j++)
			{
				if(shape[orientation.ordinal()][i*this.BOUNDING_SQUARE_SIZE+j] == CRAFT_VALUE)
				{
					pos.set(0, i);
					pos.set(1, j);
					absolutePos.add(pos);
				}
			}
		}
		
		return absolutePos;
	}
	
	public Set<Coordinate> getAbsolutePositions()
	{
		Set<Coordinate> absPos = new HashSet<Coordinate>();
		
		absPos=getAbsolutePositions(position);
		
		return absPos;
	}
	
	public boolean hit(Coordinate c)
	{
		int absCor;
		absCor=getShapeIndex(c);
		
		for(int j=0; j<BOUNDING_SQUARE_SIZE-1; j++)
		{
			if(shape[orientation.ordinal()][j]==CRAFT_VALUE && j==absCor)
			{
				shape[orientation.ordinal()][j]=HIT_VALUE;
				return true;
			}
		}
		
		
		return false;
	}
	
	public boolean isShotDown()
	{
		int counter = 0;
		
		for(int j=0; j<BOUNDING_SQUARE_SIZE-1; j++)
		{
			if(shape[orientation.ordinal()][j]==HIT_VALUE)
			{
				counter++;
			}
		}	
		
		if(counter==3)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean isHit(Coordinate c)
	{
		int absCor;
		absCor=getShapeIndex(c);
		
		if(shape[orientation.ordinal()][absCor] == HIT_VALUE)
		{
			return true;
		}
		
		return false;
 	}
	
	public String toString() 
	{
		StringBuilder representation = new StringBuilder( name + "(" + orientation + ")" + '\n');
		representation.append("-----" + '\n');
		for(int i=0; i<BOUNDING_SQUARE_SIZE; i++)
		{	
			for(int x=0; x<BOUNDING_SQUARE_SIZE; x++)
			{	
				representation.append("|");
				for(int j=0; j<BOUNDING_SQUARE_SIZE-1; j++)
				{
					if(shape[orientation.ordinal()][j] == 0)
					{
						
					}
				}
			}
			representation.append("|");
		}
		representation.append("-----" + '\n');
			
		return representation.toString();
	}
	
}
