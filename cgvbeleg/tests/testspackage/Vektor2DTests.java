package testspackage;

import org.junit.Test;
import math.Vektor2D;
import static org.junit.Assert.*;

public class Vektor2DTests {
	@Test
	public void testAddVektoren( ) {
		// Initializations.
		Vektor2D vec1 = new Vektor2D( 1.0, 2.0 );
		Vektor2D vec2 = new Vektor2D( 1.0, 2.0 );
		Vektor2D erg = new Vektor2D( 2.0, 4.0 );

		// Methods.
		vec1.add( vec2 );

		// Tests.
		assertArrayEquals( vec1.getArray( ), erg.getArray( ), 0.001 );
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
		assertArrayEquals( vec1.getArray( ), erg.getArray( ), 0.001 );
	}
}