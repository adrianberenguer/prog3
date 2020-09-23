//ADRIÁN BERENGUER AGULLÓ 74445262N

class Coordinate
{
	private int[] components;
    
    protected 	void set(int component, int value){
        if (component>=0 && component<2) {
            components[component] = value;
        }
         else
            System.err.println("Error in Coordinate.set, component " + component + " is out of range");
    }

	public Coordinate(int x, int y){
        components = new int[2];
        components[0]=x;
        components[1]=y;
    }
	public Coordinate(Coordinate c){
        components = new int[2];
         
        for (int i=0;i<components.length;i++)
           this.set(i, c.get(i));
    }

	public int get(int component){
        if (component>=0 && component<2) {
            return components[component];
         }
         else
            System.err.println("Error in Coordinate.get, component " + component + " is out of range");
      
         return -1;
    }
	public final boolean equals(final Object obj){

        Coordinate c = (Coordinate)obj;
        
        for (int i=0;i<2;i++)
            if (this.get(i) != c.get(i)) 
                return false;
        return true;
    }
	public final String toString(){
        StringBuilder concatenation = new StringBuilder("(");
        
        for (int i=0;i<2;i++)
        {
           concatenation.append(this.get(i));
           if (i<2-1) // no es la última
              concatenation.append(",");
        }
        concatenation.append(")");
        return concatenation.toString();
    }
	public final Coordinate add(Coordinate c){
        Coordinate new_c = new Coordinate(this);
        
        for (int i=0; i<2; i++)
           new_c.set(i, new_c.get(i) + c.get(i));
                     
        return new_c;
    }
	public final Coordinate substract(Coordinate c){
        Coordinate new_c = new Coordinate(this);
        
        for (int i=0; i<2; i++)
           new_c.set(i, new_c.get(i) - c.get(i));
                     
        return new_c; 
    }

    
}