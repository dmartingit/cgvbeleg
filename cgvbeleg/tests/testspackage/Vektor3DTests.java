package testspackage;

import org.junit.Test;
import math.Vektor3D;
import static org.junit.Assert.*;

public class Vektor3DTests {
	@Test
	public void testAddVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 1.0, 2.0, 3.0 );
		Vektor3D vec2 = new Vektor3D( 1.0, 1.0, 1.0 );
		Vektor3D erg1 = new Vektor3D( 2.0, 3.0, 4.0 );

		// Methods.
		vec1.add( vec2 );

		// Tests.
		assertArrayEquals( erg1.getArray( ), vec1.getArray( ), 0.001 );
	}

	@Test
	public void testSubVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 2.0, 4.0, 6.0 );
		Vektor3D vec2 = new Vektor3D( 1.0, 2.0, 3.0 );
		Vektor3D erg1 = new Vektor3D( 1.0, 2.0, 3.0 );

		// Methods.
		vec1.sub( vec2 );

		// Tests.
		assertArrayEquals( erg1.getArray( ), vec1.getArray( ), 0.001 );
	}

	@Test
	public void testMultVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 1.0, 2.0, 3.0 );
		Vektor3D vec2 = new Vektor3D( 2.0, 2.0, 2.0 );
		Vektor3D erg1 = new Vektor3D( 2.0, 4.0, 6.0 );

		// Methods.
		vec1.mult( vec2 );

		// Tests.
		assertArrayEquals( erg1.getArray( ), vec1.getArray( ), 0.001 );
	}

	@Test
	public void testDivVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 2.0, 2.0, 2.0 );
		Vektor3D vec2 = new Vektor3D( 2.0, 2.0, 2.0 );
		Vektor3D erg1 = new Vektor3D( 1.0, 1.0, 1.0 );

		// Methods.
		vec1.div( vec2 );

		// Tests.
		assertArrayEquals( erg1.getArray( ), vec1.getArray( ), 0.001 );
	}

	@Test
	public void testIsNullVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 0.0, 0.0, 0.0 );
		Vektor3D vec2 = new Vektor3D( 1.0, 1.0, 1.0 );

		// Tests.
		assertTrue( vec1.isNullVector( ) );
		assertFalse( vec2.isNullVector( ) );
	}

	@Test
	public void testIsEqualVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 1.0, 1.0, 1.0 );
		Vektor3D vec2 = new Vektor3D( 1.0, 1.0, 1.0 );
		Vektor3D vec3 = new Vektor3D( 2.0, 2.0, 2.0 );

		// Tests.
		assertTrue( vec1.isEqual( vec2 ) );
		assertFalse( vec1.isEqual( vec3 ) );
	}

	@Test
	public void testIsNotEqualVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 1.0, 1.0, 1.0 );
		Vektor3D vec2 = new Vektor3D( 1.0, 1.0, 1.0 );
		Vektor3D vec3 = new Vektor3D( 2.0, 2.0, 2.0 );

		// Tests.
		assertFalse( vec1.isNotEqual( vec2 ) );
		assertTrue( vec1.isNotEqual( vec3 ) );
	}

	@Test
	public void testLengthVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 1.0, 2.0, 2.0 );
		double erg1 = 3.0;

		// Tests.
		assertEquals( erg1, vec1.length( ), 0.001 );
	}

	@Test
	public void testNormalizeVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 2.0, 0.0, 0.0 );
		Vektor3D erg1 = new Vektor3D( 1.0, 0.0, 0.0 );

		// Methods.
		vec1.normalize( );

		// Tests.
		assertArrayEquals( erg1.getArray( ), vec1.getArray( ), 0.001 );
	}
}