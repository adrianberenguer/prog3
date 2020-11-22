package model;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/* Para realizar los test se sugiere usar métodos de la librería de junit como:
 * assertEquals; assertSame; assertNotSame, assertTrue; assertFalse
 */
public class CoordinatePreTestP2 {
	
    int []vcoor= {0,0,-70,-2,20}; //Para crear coordenadas
    final int DIM = vcoor.length;
    List<Coordinate> lcoor;
    
	@Before
	public void setUp() throws Exception {
		lcoor = new ArrayList<Coordinate>();
		//Se crean las Coordinates (0,0),(0,-70), (-70,-2),(-2,20);
		for (int i=0; i<DIM-1; i++) {
			lcoor.add(new Coordinate(vcoor[i],vcoor[i+1]));
		}
	}

	
	//TODO testCopy
	/* Crea copias de las Coordinates creadas en el setUp() y comprueba que:
	 * 1 - La copia y el original no son la misma.
	 * 2 - La copia tiene los mismos valores, en las componentes respectivas, que el objeto copiado.
	 */
	@Test
	public void testCopy() {
	
		for (Coordinate c : lcoor) {
			assertEquals(c, c.copy());
		}
		
		// fail ("Realizar el test propuesto");
	}

	//TODO testAdjacentCoordinates
	/* Crea una Coordinate y a partir de ella obten las Coordinate adyacentes 
	 * con tu método adjacentCoordinates(). Guárdalas en un Set. 
	 * Para cada una de las posiciones adyacentes a la Coordinate inicial, crea una 
	 * Coordinate, y comprueba que están contenidas en el Set.
	 */
	@Test
	public void testAdjacentCoordinates() {
		
		Set<Coordinate> adjCoords = null;
		
		Coordinate checkC = null;
		
		for (Coordinate c : lcoor) {
			adjCoords = c.adjacentCoordinates();
			
			for (int i = -1; i < 2; i ++) {
	    		for (int j = -1; j < 2; j ++) {
	    			if (!(i == 0 && j == 0)) {
	    				checkC = c.add(new Coordinate(i, j));
	    				
	    				assertTrue(adjCoords.contains(checkC));
	    			}
	    		}
	    	}
		}
		
		// fail("Realiza el test de adjacentCoordiantes propuesto");
	}
	
	

}
