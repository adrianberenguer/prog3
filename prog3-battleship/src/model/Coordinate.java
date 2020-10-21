
package model;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class Coordinate.
 */
public abstract class Coordinate
{
	

	/** The components. */
	private int[] components;
    

    /**
     * Sets the.
     *
     * @param component the component
     * @param value the value
     */
    protected void set(int component, int value)
    {
   
	        if (component>=0 && component<2) 
	        {
	            components[component] = value;
	        }
	         else
	            System.err.println("Error in Coordinate.set, component " + component + " is out of range");
    	
    
    }


	/**
	 * Instantiates a new coordinate.
	 *
	 * @param x the x
	 * @param y the y
	 */
	protected Coordinate(int dim)
	{
        components = new int[dim];
        	
    }
	

	/**
	 * Instantiates a new coordinate.
	 *
	 * @param c the c
	 */
	protected Coordinate(Coordinate c)
	{
        components = new int[2];
         
        for (int i=0;i<components.length;i++)
           this.set(i, c.get(i));
    }


	/**
	 * Gets the.
	 *
	 * @param component the component
	 * @return the int
	 */
	public int get(int component)
	{
        if (component>=0 && component<2) 
         {
            return components[component];
         }
         else
            System.err.println("Error in Coordinate.get, component " + component + " is out of range");
      
         return -1;
    }
	

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(components);
		return result;
	}


	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (!Arrays.equals(components, other.components))
			return false;
		return true;
	}
		
	/**
	 * Adds the.
	 *
	 * @param c the c
	 * @return the coordinate
	 */
	public final Coordinate add(Coordinate c)
	{
        Coordinate new_c = copy();
        
        for (int i=0; i<this.components.length; i++) 
        {
        	if(i<c.components.length)
        	{
                new_c.set(i, new_c.get(i) + c.get(i));
        	}
        }             
        
        return new_c;
    }
	

	/**
	 * Substract.
	 *
	 * @param c the c
	 * @return the coordinate
	 */
	public final Coordinate subtract(Coordinate c)
	{
        Coordinate new_c = copy();
        
        for (int i=0; i<2; i++)
           new_c.set(i, new_c.get(i) - c.get(i));
                     
        return new_c; 
    }
	
	/**
	 * Adjacent coordinates.
	 *
	 * @return the sets the
	 */
	public abstract Set<Coordinate> adjacentCoordinates();

	
	/**
	 * Copy.
	 *
	 * @return the coordinate
	 */
	public abstract Coordinate copy();
    
}