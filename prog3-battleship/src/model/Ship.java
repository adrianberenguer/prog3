package model;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;


//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class Ship.
 */
public class Ship
{
	
	/** The Constant BOUNDING_SQUARE_SIZE. */
	private final static int BOUNDING_SQUARE_SIZE=5;
	
	/** The Constant HIT_VALUE. */
	private final static int HIT_VALUE=-1;
	
	/** The Constant CRAFT_VALUE. */
	private final static int CRAFT_VALUE=1;
	
	/** The symbol. */
	private char symbol;
	
	/** The name. */
	private String name;
	
	/** The shape. */
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
	
	
	/** The position. */
	private Coordinate position;
	
	/** The orientation. */
	private Orientation orientation;
	
	/**
	 * Instantiates a new ship.
	 *
	 * @param o the o
	 * @param s the s
	 * @param n the n
	 */
	public Ship(Orientation o, char s, String n)
	{
		orientation = o;
		symbol = s;
		name = n;
		position = null;
	}
	
	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public Coordinate getPosition()
	{
		if(position == null)
			return null;
		
			return position.copy();
	}
	
	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(Coordinate position)
	{
		this.position=position.copy();
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the orientation.
	 *
	 * @return the orientation
	 */
	public Orientation getOrientation()
	{
		return orientation;
	}
	
	/**
	 * Gets the symbol.
	 *
	 * @return the symbol
	 */
	public char getSymbol() 
	{
		return symbol;
	}
	
	/**
	 * Gets the shape.
	 *
	 * @return the shape
	 */
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
	
	/**
	 * Gets the shape index.
	 *
	 * @param c the c
	 * @return the shape index
	 */
	public int getShapeIndex(Coordinate c)
	{
		int shapePos,corX,corY;
		
		corX=c.get(0);
		corY=c.get(1);
		shapePos=corY*BOUNDING_SQUARE_SIZE+corX;
		
		return shapePos;
	}
	
	/**
	 * Gets the absolute positions.
	 *
	 * @param position the position
	 * @return the absolute positions
	 */
	public Set<Coordinate> getAbsolutePositions(Coordinate position)
	{
		Set<Coordinate> absolutePos = new HashSet<Coordinate>();
		Coordinate pos = null;
		int column,row;
		
		for(int j=0; j< 25; j++)
		{	
				if(shape[orientation.ordinal()][j] == CRAFT_VALUE || shape[orientation.ordinal()][j] == HIT_VALUE)
				{
					row = j/5;
					column = j - row *5;
					
					pos = new Coordinate(column,row);
					absolutePos.add(pos.add(position));
				}
		}
		
		return absolutePos;
	}
	
	/**
	 * Gets the absolute positions.
	 *
	 * @return the absolute positions
	 */
	public Set<Coordinate> getAbsolutePositions()
	{
		Set<Coordinate> absPos = new HashSet<Coordinate>();
		
		absPos=getAbsolutePositions(position);
		
		return absPos;
	}
	
	/**
	 * Hit.
	 *
	 * @param c the c
	 * @return true, if successful
	 */
	public boolean hit(Coordinate c)
	{
		if(position == null)
			return false;
		Coordinate position= null;
		Set<Coordinate> pos = this.getAbsolutePositions();
		
		
		for(Coordinate coor:pos)
		{
			if(c.equals(coor) == true)
			{
				position = coor.subtract(this.position);
				
				if(shape[orientation.ordinal()][getShapeIndex(position)] == CRAFT_VALUE)
				{
					shape[orientation.ordinal()][getShapeIndex(position)] = HIT_VALUE;
					return true;
				}
			}
		}
		
		
		return false;
	}
	
	/**
	 * Checks if is shot down.
	 *
	 * @return true, if is shot down
	 */
	public boolean isShotDown()
	{
		int counter = 0;
		
		for(int j=0; j < 25; j++)
		{
			if(shape[orientation.ordinal()][j]==CRAFT_VALUE)
			{
				counter++;
			}
		}	
		
		if(counter!=0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	/**
	 * Checks if is hit.
	 *
	 * @param c the c
	 * @return true, if is hit
	 */
	public boolean isHit(Coordinate c)
	{
		if(position == null)
			return false;
		Coordinate cordShip=c.subtract(this.position);
		
		
		if(shape[orientation.ordinal()][getShapeIndex(cordShip)] == HIT_VALUE)
		{
			return true;
		}
		
		return false;
 	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() 
	{
		StringBuilder representation = new StringBuilder( name + " (" + orientation + ")" + '\n');
		representation.append(" ");
		for(int i=0;i<BOUNDING_SQUARE_SIZE; i++)
		{
			representation.append("-");
		}
		representation.append('\n');
		

		for(int i=0; i<BOUNDING_SQUARE_SIZE; i++)
		{	
			for(int j=0; j<BOUNDING_SQUARE_SIZE+2; j++)
			{
				if(j==0 || j == BOUNDING_SQUARE_SIZE+1)
				{
					representation.append("|");
				}
				else 
				{
					if(shape[orientation.ordinal()][i*BOUNDING_SQUARE_SIZE+j-1] == 0)
					{
						representation.append(" ");
					}
					if(shape[orientation.ordinal()][i*BOUNDING_SQUARE_SIZE+j-1] == CRAFT_VALUE)
					{
						representation.append(symbol);
					}
					if(shape[orientation.ordinal()][i*BOUNDING_SQUARE_SIZE+j-1] == HIT_VALUE)
					{
						representation.append("•");
					}
				}
			}
			representation.append('\n');
		}
		representation.append(" ");

		for(int i=0;i<BOUNDING_SQUARE_SIZE; i++)
		{
			representation.append("-");
		}
			
		return representation.toString();
	}
	
}
