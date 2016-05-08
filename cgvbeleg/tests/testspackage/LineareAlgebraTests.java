package testspackage;

import math.Vektor2D;
import math.Vektor3D;
import math.LineareAlgebra;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LineareAlgebraTests  {
	@Test
	public void testVektor2DAdd( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 3.0, 2.0 );
		Vektor2D vec2 = new Vektor2D( 4.0, 10.0 );
		Vektor2D erg = new Vektor2D( 7.0, 12.0 );
		Vektor2D terg = new Vektor2D( );
		
		// Methods.
		terg = LineareAlgebra.add( vec1, vec2 );
		
		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}

	@Test
	public void testVektor3DAdd( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 3.0, 2.0, 50.0 );
		Vektor3D vec2 = new Vektor3D( 4.0, 10.0, 1.0 );
		Vektor3D erg = new Vektor3D( 7.0, 12.0, 51.0 );
		Vektor3D terg = new Vektor3D( );
		
		// Methods.
		terg = LineareAlgebra.add( vec1, vec2 );
		
		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}

	@Test
	public void testVektor2DSub( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 3.0, 2.0 );
		Vektor2D vec2 = new Vektor2D( 4.0, 10.0 );
		Vektor2D erg = new Vektor2D( 1.0, 8.0 );
		Vektor2D terg = new Vektor2D( );
		
		// Methods.
		terg = LineareAlgebra.sub( vec2, vec1 );
		
		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}

	@Test
	public void testVektor3DSub( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 3.0, 2.0, 50.0 );
		Vektor3D vec2 = new Vektor3D( 1.0, 1.0, 1.0 );
		Vektor3D erg = new Vektor3D( 2.0, 1.0, 49.0 );
		Vektor3D terg = new Vektor3D( );
		
		// Methods.
		terg = LineareAlgebra.sub( vec1, vec2 );
		
		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}


	@Test
	public void testIsEqual2DVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 1.0, 1.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 1.0 );
		Vektor2D vec3 = new Vektor2D( 2.0, 2.0 );

		// Tests.
		assertTrue( LineareAlgebra.isEqual( vec1, vec2 ) );
		assertFalse( LineareAlgebra.isEqual( vec1, vec3 ) );
	}

	@Test
	public void testIsEqual3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 1.0, 1.0, 1.0 );
		Vektor3D vec2 = new Vektor3D( 1.0, 1.0, 1.0 );
		Vektor3D vec3 = new Vektor3D( 2.0, 2.0, 2.0 );

		// Tests.
		assertTrue( LineareAlgebra.isEqual( vec1, vec2 ) );
		assertFalse( LineareAlgebra.isEqual( vec1, vec3 ) );
	}

	@Test
	public void testIsNotEqual2DVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 1.0, 1.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 1.0 );
		Vektor2D vec3 = new Vektor2D( 2.0, 2.0 );

		// Tests.
		assertTrue( LineareAlgebra.isNotEqual( vec1, vec3 ) );
		assertFalse( LineareAlgebra.isNotEqual( vec1, vec2 ) );
	}

	@Test
	public void testIsNotEqual3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 1.0, 1.0, 1.0 );
		Vektor3D vec2 = new Vektor3D( 1.0, 1.0, 1.0 );
		Vektor3D vec3 = new Vektor3D( 2.0, 2.0, 1.0 );

		// Tests.
		assertTrue( LineareAlgebra.isNotEqual( vec1, vec3 ) );
		assertFalse( LineareAlgebra.isNotEqual( vec1, vec2 ) );
	}

	@Test
	public void testLength2DVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 2.0, 0.0 );
		double erg = 2.0;

		// Tests.
		assertEquals( erg, LineareAlgebra.length( vec1 ), 0.001 );
	}

	@Test
	public void testLength3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 1.0, 2.0, 2.0 );
		double erg = 3.0;

		// Tests.
		assertEquals( erg, LineareAlgebra.length( vec1 ), 0.001 );
	}

	@Test
	public void testNormalize2DVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 2.0, 0.0 );
		Vektor2D erg = new Vektor2D( 1.0, 0.0 );
		Vektor2D terg = new Vektor2D( );
		
		// Methods.
		terg = LineareAlgebra.normalize( vec1 );

		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}

	@Test
	public void testNormalize3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 2.0, 0.0, 0.0 );
		Vektor3D erg = new Vektor3D( 1.0, 0.0, 0.0 );
		Vektor3D terg = new Vektor3D( );
		
		// Methods.
		terg = LineareAlgebra.normalize( vec1 );

		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}

	@Test 	
	public void testEuklDistance2DVektoren( ) { 		
		// Initializations. 		
		Vektor2D vec1 = new Vektor2D( 1.0, 2.0 ); 		
		Vektor2D vec2 = new Vektor2D( 1.0, 4.0 ); 	
		double erg = 2.0;	
	 	
		// Methods. 		
		double terg = LineareAlgebra.euklDistance( vec1, vec2 ); 
		System.out.println( terg );
		// Tests. 		
		assertEquals( erg, terg, 0.001 ); 	
	}

	@Test
	public void testEuklDistance3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 1.0, 4.0, 8.0 );
		Vektor3D vec2 = new Vektor3D( 1.0, 10.0, 8.0 );
		double erg =6.0;
		
		
		// Methods.
		double terg = LineareAlgebra.euklDistance( vec1, vec2 ); 
		System.out.println( terg );
		// Tests.
		assertEquals( erg, terg, 0.001 );
	}

	@Test
	public void testManhattanDistance2DVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 2.0, 3.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 5.0 );
		Vektor2D erg = new Vektor2D( 2.0, 3.0 );
		Vektor2D terg = new Vektor2D( );
		
		// Methods.
		terg = LineareAlgebra.manhattanDistance( vec1, vec2 ); // falsches ergebnis
		
		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}

	@Test
	public void testManhattanDistance3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 2.0, 3.0, 4.0 );
		Vektor3D vec2 = new Vektor3D( 1.0, 5.0, 8.0 );
		Vektor3D erg = new Vektor3D( 2.0, 3.0, 4.0 );
		Vektor3D terg = new Vektor3D( );
		
		// Methods.
		terg = LineareAlgebra.manhattanDistance( vec1, vec2 ); // falsches ergebnis
		
		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}

	@Test
	public void testCrossProduct3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 1.0, -5.0, 2.0 );
		Vektor3D vec2 = new Vektor3D( 2.0, 0.0, 3.0 );
		Vektor3D erg = new Vektor3D( -15.0, 1.0, 10.0 );
		Vektor3D terg = new Vektor3D( );
		
		// Methods.
		terg = LineareAlgebra.crossProduct( vec1, vec2 );
		
		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}

	@Test
	public void testDotProduct2DVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 2.0, 3.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 5.0 );
		double erg = 17.0;
		double terg;
		
		// Methods.
		terg = LineareAlgebra.dotProduct( vec1, vec2 );
		
		// Tests.
		assertEquals( erg, terg, 0.001 );
	}

	@Test
	public void testDotProduct3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 2.0, 3.0, 4.0 );
		Vektor3D vec2 = new Vektor3D( 1.0, 5.0, 8.0 );
		double erg = 49.0;
		double terg;
		
		// Methods.
		terg = LineareAlgebra.dotProduct( vec1, vec2 );
		
		// Tests.
		assertEquals( erg, terg, 0.001 );
	}
}