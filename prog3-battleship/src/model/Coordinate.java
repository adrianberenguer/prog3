
package model;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

// TODO: Auto-generated Javadoc
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
   
	        if (component>=0 && component<3) 
	        {
	        	try 
	        	{
	        		components[component] = value;
	        	}
	        	catch(Exception e)
	        	{
	        		 throw new IllegalArgumentException();
	        	}
	        }
	         else
	            throw new IllegalArgumentException();
    	
    
    }


	/**
	 * Instantiates a new coordinate.
	 *
	 * @param dim the dim
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
        components = c.copy().components;
         
    }


	/**
	 * Gets the.
	 *
	 * @param component the component
	 * @return the int
	 */
	public int get(int component)
	{
        if (component>=0 && component<components.length) 
         {
            return components[component];
         }
         else
        	 throw new IllegalArgumentException();
      
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
        
        Objects.requireNonNull(c);
        
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
	 * Subtract.
	 *
	 * @param c the c
	 * @return the coordinate
	 */
	public final Coordinate subtract(Coordinate c)
	{
        Coordinate new_c = copy();
     
        Objects.requireNonNull(c);
        
        for (int i=0; i<this.components.length; i++)
        	if(i<c.components.length)
        	{
                new_c.set(i, new_c.get(i) - c.get(i));
        	}
   
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