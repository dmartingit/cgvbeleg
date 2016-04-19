package testspackage;

import org.junit.Test;
import math.Vektor2D;
import static org.junit.Assert.*;

public class Vektor2DTests {
	@Test
	public void testAddVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 1.0, 2.0 );
		Vektor2D vec2 = new Vektor2D( 2.0, 2.0 );
		Vektor2D erg1 = new Vektor2D( 3.0, 4.0 );

		// Methods.
		vec1.add( vec2 );

		// Tests.
		assertArrayEquals( erg1.getArray( ), vec1.getArray( ), 0.001 );
	}

	@Test
	public void testSubVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 3.0, 4.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 2.0 );
		Vektor2D erg1 = new Vektor2D( 2.0, 2.0 );

		// Methods.
		vec1.sub( vec2 );

		// Tests.
		assertArrayEquals( erg1.getArray( ), vec1.getArray( ), 0.001 );
	}

	@Test
	public void testMultVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 1.0, 2.0 );
		Vektor2D vec2 = new Vektor2D( 2.0, 2.0 );
		Vektor2D erg1 = new Vektor2D( 2.0, 4.0 );

		// Methods.
		vec1.mult( vec2 );

		// Tests.
		assertArrayEquals( erg1.getArray( ), vec1.getArray( ), 0.001 );
	}
	
	@Test
	public void testDivVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 2.0, 2.0 );
		Vektor2D vec2 = new Vektor2D( 2.0, 2.0 );
		Vektor2D erg1 = new Vektor2D( 1.0, 1.0 );

		// Methods.
		vec1.div( vec2 );

		// Tests.
		assertArrayEquals( erg1.getArray( ), vec1.getArray( ), 0.001 );
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
		double erg1 = 2.0;

		// Tests.
		assertEquals( erg1, vec1.length( ), 0.001 );
	}
	
	@Test
	public void testNormalizeVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 2.0, 0.0 );
		Vektor2D erg1 = new Vektor2D( 1.0, 0.0 );

		// Methods.
		vec1.normalize( );
		
		// Tests.
		assertArrayEquals( erg1.getArray( ), vec1.getArray( ), 0.001 );
	}
}