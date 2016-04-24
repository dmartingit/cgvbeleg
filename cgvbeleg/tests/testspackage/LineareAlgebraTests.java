package testspackage;

import math.Vektor2D;
import math.Vektor3D;
import math.LineareAlgebra;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LineareAlgebraTests extends LineareAlgebra {
	@Test
	public void testVektor2DAdd( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 3.0, 2.0  );
		Vektor2D vec2 = new Vektor2D( 4.0, 10.0 );
		Vektor2D terg = new Vektor2D( 7.0, 12.0 ); 
		Vektor2D erg  = new Vektor2D( );
		// Methods.
		erg = add( vec1, vec2 ); 
		// Tests.
		assertArrayEquals( terg.getArray( ), erg.getArray( ), 0.001 );
	}
	
	@Test
	public void testVektor3DAdd( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 3.0, 2.0,  50.0 );
		Vektor3D vec2 = new Vektor3D( 4.0, 10.0, 1.0  );
		Vektor3D terg = new Vektor3D( 7.0, 12.0, 51.0 ); 
		Vektor3D erg  = new Vektor3D( );
		// Methods.
		erg = add( vec1, vec2 ); 
		// Tests.
		assertArrayEquals( terg.getArray( ), erg.getArray( ), 0.001 );
	}
	
	@Test
	public void testVektor2DSub( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 3.0, 2.0  );
		Vektor2D vec2 = new Vektor2D( 4.0, 10.0 );
		Vektor2D terg = new Vektor2D( 1.0, 8.0  ); 
		Vektor2D erg  = new Vektor2D( );
		// Methods.
		erg = sub( vec2, vec1 ); 
		// Tests.
		assertArrayEquals( terg.getArray( ), erg.getArray( ), 0.001 );
	}
	
	@Test
	public void testVektor3DSub( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 3.0, 2.0,  50.0 );
		Vektor3D vec2 = new Vektor3D( 4.0, 10.0, 1.0  );
		Vektor3D terg = new Vektor3D( 1.0, 8.0, -49.0 ); 
		Vektor3D erg  = new Vektor3D( );
		// Methods.
		erg = sub( vec2, vec1 ); 
		// Tests.
		assertArrayEquals( terg.getArray( ), erg.getArray( ), 0.001 );
	}
	
	@Test
	public void testVektor2DMult( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 3.0, 2.0   );
		Vektor2D vec2 = new Vektor2D( 4.0, 10.0  );
		Vektor2D terg = new Vektor2D( 12.0, 20.0 ); 
		Vektor2D erg  = new Vektor2D( );
		// Methods.
		erg = mult( vec1, vec2 ); 
		// Tests.
		assertArrayEquals( terg.getArray( ), erg.getArray( ), 0.001 );
	}
	
	@Test
	public void testVektor3DMult( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 3.0,  2.0,  50.0 );
		Vektor3D vec2 = new Vektor3D( 4.0,  10.0, 1.0  );
		Vektor3D terg = new Vektor3D( 12.0, 20.0, 50.0 ); 
		Vektor3D erg  = new Vektor3D( );
		// Methods.
		erg = mult( vec1, vec2 ); 
		// Tests.
		assertArrayEquals( terg.getArray( ), erg.getArray( ), 0.001 );
	}
	
	@Test
	public void testVektor2DDiv( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 12.0, 20.0 );
		Vektor2D vec2 = new Vektor2D( 4.0,  10.0 );
		Vektor2D terg = new Vektor2D( 3.0,  2.0  ); 
		Vektor2D erg  = new Vektor2D( );
		// Methods.
		erg = div( vec1, vec2 ); 
		// Tests.
		assertArrayEquals( terg.getArray( ), erg.getArray( ), 0.001 );
	}
	
	@Test
	public void testVektor3DDiv( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 12.0, 20.0, 50.0 );
		Vektor3D vec2 = new Vektor3D( 4.0,  10.0, 1.0  );
		Vektor3D terg = new Vektor3D( 3.0,  2.0,  50.0 ); 
		Vektor3D erg  = new Vektor3D( );
		// Methods.
		erg = div( vec1, vec2 ); 
		// Tests.
		assertArrayEquals( terg.getArray( ), erg.getArray( ), 0.001 );
	}
	
	@Test
	public void testIsEqual2DVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 1.0, 1.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 1.0 );
		Vektor2D vec3 = new Vektor2D( 2.0, 2.0 );

		// Tests.
		assertTrue( isEqual  ( vec1, vec2 )  );
		assertFalse( isEqual ( vec1, vec3 )  );
	}
	
	@Test
	public void testIsEqual3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 1.0, 1.0, 1.0 );
		Vektor3D vec2 = new Vektor3D( 1.0, 1.0, 1.0 );
		Vektor3D vec3 = new Vektor3D( 2.0, 2.0, 2.0 );

		// Tests.
		assertTrue( isEqual  ( vec1, vec2 ) );
		assertFalse( isEqual ( vec1, vec3 ) );
	}
	
	@Test
	public void testIsNotEqual2DVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 1.0, 1.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 1.0 );
		Vektor2D vec3 = new Vektor2D( 2.0, 2.0 );

		// Tests.
		assertTrue(  isNotEqual ( vec1, vec3 ) );
		assertFalse( isNotEqual ( vec1, vec2 ) );
	}
	
	@Test
	public void testIsNotEqual3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 1.0, 1.0, 1.0 );
		Vektor3D vec2 = new Vektor3D( 1.0, 1.0, 1.0 );
		Vektor3D vec3 = new Vektor3D( 2.0, 2.0, 1.0 );

		// Tests.
		assertTrue(  isNotEqual ( vec1, vec3 ) );
		assertFalse( isNotEqual ( vec1, vec2 ) );
	}
	
	@Test
	public void testLength2DVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 2.0, 0.0 );
		double erg = 2.0;

		// Tests.
		assertEquals( erg, length( vec1 ), 0.001 );
	}
	
	@Test
	public void testLength3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 1.0, 2.0, 2.0 );
		double erg = 3.0;

		// Tests.
		assertEquals( erg, length( vec1 ), 0.001 );
	}
	
	@Test
	public void testNormalize2DVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 2.0, 0.0 );
		Vektor2D erg  = new Vektor2D( 1.0, 0.0 );
		Vektor2D terg = new Vektor2D( );
		// Methods.
		terg = normalize( vec1 );

		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}
	
	@Test
	public void testNormalize3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 2.0, 0.0, 0.0 );
		Vektor3D erg  = new Vektor3D( 1.0, 0.0, 0.0 );
		Vektor3D terg = new Vektor3D( );
		// Methods.
		terg = normalize( vec1 );

		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}
	
	@Test
	public void testEuklDistance2DVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 2.0, 3.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 5.0 );
		Vektor2D erg  = new Vektor2D( 2.0, 3.0 );
		Vektor2D terg = new Vektor2D( );
		// Methods.
		terg = euklDistance( vec1, vec2 ); //falsches ergebnis
		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}
	
	@Test
	public void testEuklDistance3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 2.0, 3.0, 4.0);
		Vektor3D vec2 = new Vektor3D( 1.0, 5.0, 8.0);
		Vektor3D erg  = new Vektor3D( 2.0, 3.0, 4.0);
		Vektor3D terg = new Vektor3D( );
		// Methods.
		terg = euklDistance( vec1, vec2 ); //falsches ergebnis
		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}
	
	@Test
	public void testManhattanDistance2DVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 2.0, 3.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 5.0 );
		Vektor2D erg  = new Vektor2D( 2.0, 3.0 );
		Vektor2D terg = new Vektor2D( );
		// Methods.
		terg = manhattanDistance( vec1, vec2 ); //falsches ergebnis
		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}
	
	@Test
	public void testManhattanDistance3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 2.0, 3.0, 4.0);
		Vektor3D vec2 = new Vektor3D( 1.0, 5.0, 8.0);
		Vektor3D erg  = new Vektor3D( 2.0, 3.0, 4.0);
		Vektor3D terg = new Vektor3D( );
		// Methods.
		terg = manhattanDistance( vec1, vec2 ); //falsches ergebnis
		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}
	
	@Test
	public void testCrossProduct3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 2.0, 3.0, 4.0);
		Vektor3D vec2 = new Vektor3D( 1.0, 5.0, 8.0);
		Vektor3D erg  = new Vektor3D( 4.0,-12.0, 7.0);
		Vektor3D terg = new Vektor3D( );
		// Methods.
		terg = crossProduct( vec1, vec2 );
		// Tests.
		assertArrayEquals( erg.getArray( ), terg.getArray( ), 0.001 );
	}
	
	@Test
	public void testDotProduct2DVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 2.0, 3.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 5.0 );
		double erg  = 17.0;
		double terg;
		// Methods.
		terg = dotProduct( vec1, vec2 );
		// Tests.
		assertEquals( erg, terg, 0.001 );
	}
	
	@Test
	public void testDotProduct3DVektoren( ) {
		// Initializations.
		Vektor3D vec1 = new Vektor3D( 2.0, 3.0, 4.0 );
		Vektor3D vec2 = new Vektor3D( 1.0, 5.0, 8.0 );
		double erg  = 49.0;
		double terg;
		// Methods.
		terg = dotProduct( vec1, vec2 );
		// Tests.
		assertEquals( erg, terg, 0.001 );
	}
}

