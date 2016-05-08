package testspackage;

import math.Vektor2D;
import org.junit.Test;
import static org.junit.Assert.*;

public class Vektor2DTests {
	@Test
	public void testSetPositionVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( );
		Vektor2D erg = new Vektor2D( 1.0, 1.0 );

		// Methods.
		vec1.setPosition( 1.0, 1.0 );

		// Tests.
		assertArrayEquals( erg.getArray( ), vec1.getArray( ), 0.001 );
	}

	@Test
	public void testAddVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 1.0, 2.0 );
		Vektor2D vec2 = new Vektor2D( -2.0, 2.0 );
		Vektor2D erg = new Vektor2D( -1.0, 4.0 );

		// Methods.
		vec1.add( vec2 );

		// Tests.
		assertArrayEquals( erg.getArray( ), vec1.getArray( ), 0.001 );
	}
	
	@Test
	public void testAddVektorenOverflow( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( Double.MAX_VALUE, 2.0 );
		Vektor2D vec2 = new Vektor2D( 10, 2.0 );
		Vektor2D erg = new Vektor2D( Double.MAX_VALUE, 4.0 );

		// Methods.
		vec1.add( vec2 );

		// Tests.
		assertArrayEquals( erg.getArray( ), vec1.getArray( ), 0.001 );
	}
	
	@Test
	public void testAddVektorenUnderflow( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( (-Double.MAX_VALUE), 2.0 );
		Vektor2D vec2 = new Vektor2D( 10, 2.0 );
		Vektor2D erg = new Vektor2D( (-Double.MAX_VALUE), 4.0 );

		// Methods.
		vec1.add( vec2 );

		// Tests.
		assertArrayEquals( erg.getArray( ), vec1.getArray( ), 0.001 );
	}

	@Test
	public void testAddVektorenOverflow( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( Double.MAX_VALUE, 2.0 );
		Vektor2D vec2 = new Vektor2D( 10, 2.0 );
		Vektor2D erg = new Vektor2D( Double.MAX_VALUE, 4.0 );

		// Methods.
		vec1.add( vec2 );

		// Tests.
		assertArrayEquals( erg.getArray( ), vec1.getArray( ), 0.001 );
	}

	@Test
	public void testAddVektorenUnderflow( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( ( -Double.MAX_VALUE ), 2.0 );
		Vektor2D vec2 = new Vektor2D( 10, 2.0 );
		Vektor2D erg = new Vektor2D( ( -Double.MAX_VALUE ), 4.0 );

		// Methods.
		vec1.add( vec2 );

		// Tests.
		assertArrayEquals( erg.getArray( ), vec1.getArray( ), 0.001 );
	}

	@Test
	public void testSubVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 3.0, 4.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 2.0 );
		Vektor2D erg = new Vektor2D( 2.0, 2.0 );

		// Methods.
		vec1.sub( vec2 );

		// Tests.
		assertArrayEquals( erg.getArray( ), vec1.getArray( ), 0.001 );
	}

	@Test
	public void testMultVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 1.0, 2.0 );
		double val1 = 5.0;
		Vektor2D erg = new Vektor2D( 5.0, 10.0 );

		// Methods.
		vec1.mult( val1 );

		// Tests.
		assertArrayEquals( erg.getArray( ), vec1.getArray( ), 0.001 );
	}

	@Test
	public void testDivVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 2.0, 2.0 );
		double val1 = 2.0;
		Vektor2D erg = new Vektor2D( 1.0, 1.0 );

		// Methods.
		vec1.div( val1 );

		// Tests.
		assertArrayEquals( erg.getArray( ), vec1.getArray( ), 0.001 );
	}

	@Test
	public void testIsNullVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 0.0, 0.0 );
		Vektor2D vec2 = new Vektor2D( 2.0, 2.0 );

		// Tests.
		assertTrue( vec1.isNullVector( ) );
		assertFalse( vec2.isNullVector( ) );
	}

	@Test
	public void testIsEqualVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 1.0, 1.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 1.0 );
		Vektor2D vec3 = new Vektor2D( 2.0, 2.0 );

		// Tests.
		assertTrue( vec1.isEqual( vec2 ) );
		assertFalse( vec1.isEqual( vec3 ) );
	}

	@Test
	public void testIsNotEqualVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 1.0, 1.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 1.0 );
		Vektor2D vec3 = new Vektor2D( 2.0, 2.0 );

		// Tests.
		assertFalse( vec1.isNotEqual( vec2 ) );
		assertTrue( vec1.isNotEqual( vec3 ) );
	}

	@Test
	public void testLengthVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 2.0, 0.0 );
		double erg = 2.0;

		// Tests.
		assertEquals( erg, vec1.length( ), 0.001 );
	}

	@Test
	public void testNormalizeVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 4.0, 0.0 );
		Vektor2D erg = new Vektor2D( 1.0, 0.0 );

		// Methods.
		vec1.normalize( );

		// Tests.
		assertArrayEquals( erg.getArray( ), vec1.getArray( ), 0.001 );
	}
<<<<<<< HEAD

=======
	
>>>>>>> origin/master
	@Test
	public void testEuklDistance( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 1.0, 2.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 4.0 );
		double erg = 2.0;
<<<<<<< HEAD

		// Methods.
		double terg = vec1.euklDistance( vec2 );

		// Tests.
		assertEquals( erg, terg, 0.001 );
	}

=======
		
		// Methods.
		double terg = vec1.euklDistance(vec2 ); 
		
		
		// Tests.
		assertEquals( erg, terg, 0.001 );
	}
	
>>>>>>> origin/master
	@Test
	public void testcoseq( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 4.0, 2.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 8.0 );
		double erg = 0.982793723247329;
<<<<<<< HEAD

		// Methods.
		double terg = vec1.cosEquation( vec2 );
		System.out.println( terg );

=======
		
		// Methods.
		double terg = vec1.cosEquation( vec2 ); 
		System.out.println( terg );
		
>>>>>>> origin/master
		// Tests.
		assertEquals( erg, terg, 0.001 );
	}
}