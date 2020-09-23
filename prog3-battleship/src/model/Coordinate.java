
package model;

import java.util.Arrays;


//@author ADRIÁN BERENGUER AGULLÓ, 74445262N
/**
 * The Class Coordinate.
 */
public class Coordinate
{
	
	/** The components. */
	private int[] components;
    
    /**
     * Sets the.
     *
     * component the the value
     * prints error exception if its out of range
     */
    protected 	void set(int component, int value){
        if (component>=0 && component<2) {
            components[component] = value;
        }
         else
            System.err.println("Error in Coordinate.set, component " + component + " is out of range");
    }

	/**
	 * Instantiates a new coordinate.
	 * It is the constructor
	 * parameter x the x
	 * parameter y the y
	 */
	public Coordinate(int x, int y){
        components = new int[2];
        components[0]=x;
        components[1]=y;
    }
	
	/**
	 * Instantiates a new coordinate.
	 * Copy constructor
	 * parameter c the c
	 */
	public Coordinate(Coordinate c){
        components = new int[2];
         
        for (int i=0;i<components.length;i++)
           this.set(i, c.get(i));
    }

	/**
	 * Gets the.
	 * prints an error when there is an exception
	 * parameter component the component
	 * returns the int
	 */
	public int get(int component){
        if (component>=0 && component<2) {
            return components[component];
         }
         else
            System.err.println("Error in Coordinate.get, component " + component + " is out of range");
      
         return -1;
    }
	
	/**
	 * Hash code.
	 *
	 * returns the result 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(components);
		return result;
	}

	/**
	 * Equals.
	 *
	 * parameter obj the obj
	 * returns true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
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
	 * To string.
	 *
	 * returns the string
	 */
	public final String toString(){
        StringBuilder concatenation = new StringBuilder("(");
        
        for (int i=0;i<2;i++)
        {
           concatenation.append(this.get(i));
           if (i<2-1) // no es la última
              concatenation.append(", ");
        }
        concatenation.append(")");
        return concatenation.toString();
    }
	
	/**
	 * Adds the.
	 *
	 * @param c the c
	 * @return the coordinate
	 */
	public final Coordinate add(Coordinate c){
        Coordinate new_c = new Coordinate(this);
        
        for (int i=0; i<2; i++)
           new_c.set(i, new_c.get(i) + c.get(i));
                     
        return new_c;
    }
	
	/**
	 * Substract.
	 *
	 * @param c the c
	 * @return the coordinate
	 */
	public final Coordinate substract(Coordinate c){
        Coordinate new_c = new Coordinate(this);
        
        for (int i=0; i<2; i++)
           new_c.set(i, new_c.get(i) - c.get(i));
                     
        return new_c; 
    }

    
}