package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.aircraft.Coordinate3D;
import model.ship.Coordinate2D;

// TODO: Auto-generated Javadoc
/**
 * The Class CoordinatePreTest.
 */
public class CoordinatePreTest {
	
	/** The cd 3. */
	Coordinate cd2, cd3;

	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		cd2 = new Coordinate2D(-10,7);
		cd3 = new Coordinate3D(15, 8, -2);
	}

	/* Comprueba set y get modificando algunas de las Coordinates creadas en setUp() 
	 */
	/**
	 * Test set get.
	 */
	//TODO
	@Test
	public void testSetGet() {
		
		assertEquals(cd2.get(0),-10);
		assertEquals(cd3.get(2),-2);
		cd2.set(0, 3);
		assertEquals(cd2.get(0),3);
		
		cd3.set(1, 6);
		assertEquals(cd3.get(1),6);
		//fail("Realiza la comprobación del correcto funcionamiento de set y get");
	}
	
	//TODO
	/**
	 * Test set illegal argument exception.
	 */
	/* Comprueba que set lanza IllegalArgumentException cuando el componente
	 * no es correcto
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testSetIllegalArgumentException() {
		
		cd2.set(4, 5);
				
		//fail("Realiza el test SetIllegalArgumentException");
	}
	
	//TODO
	/**
	 * Test get illegal argument exception.
	 */
	/* Comprueba que get lanza IllegalArgumentException cuando el componente
	 * no es correcto
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetIllegalArgumentException() {
		
		cd2.get(5);
		
		//fail("Realiza el test SetIllegalArgumentException");
	}
	
	/**
	 * Test add 2 dand 3 D.
	 */
	/* Comprobación de la sumas entre coordenadas de dimensiones distintas*/
	@Test
	public void testAdd2Dand3D() {
		Coordinate aux2d = new Coordinate2D (5,15);
		Coordinate aux3d = new Coordinate3D (5,15,-2);
		assertEquals ("c2+c3", aux2d, cd2.add(cd3));
		assertEquals ("c3+c2", aux3d, cd3.add(cd2));
		assertNotEquals ("aux2d!=cd2", aux2d, cd2);
		assertNotEquals ("aux3d!=cd3", aux2d, cd3);
	}
	
	/**
	 * Test add null pointer exception.
	 */
	//TODO
	@Test(expected=NullPointerException.class)
	public void testAddNullPointerException() {
		try {
		   cd2.add(null);
		   fail ("Error: No se lanzó la excepción NullPointerException");
		} catch (NullPointerException e) {
			cd3.add(null);
		}
	}
	
	//TODO
	/**
	 * Testsubtract 2 dand 3 D.
	 */
	/* Comprueba la correcta resta entre Coordinates de distinta dimensión */
	@Test
	public void testsubtract2Dand3D() {
				
		assertEquals(cd2.subtract(cd3).toString(), "(-25, -1)");
		assertEquals(cd3.subtract(cd2).toString(), "(25, 1, -2)");
		//fail("Realiza el test");
	}

	//TODO
	/**
	 * Test subtract null pointer exception.
	 */
	/* Comprueba que al intentar restar a una Coordinate el valor null, se lanza
	 * la excepción NullPointerException 
	 */
	@Test(expected=NullPointerException.class)
	public void testSubtractNullPointerException() {
		
		cd2.subtract(null);
		cd3.subtract(null);
		//fail("Realiza el test");
	}


}
