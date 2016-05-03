package math;

public class LineareAlgebra {
	// ********************************************//
	public LineareAlgebra( ) {
	}

	// ********************************************//
	public static Vektor2D add( Vektor2D vec1, Vektor2D vec2 ) {
		Vektor2D erg = new Vektor2D( vec1 );
		erg.add( vec2 );
		return erg;
	}

	// ********************************************//
	public static Vektor3D add( Vektor3D vec1, Vektor3D vec2 ) {
		Vektor3D erg = new Vektor3D( vec1 );
		erg.add( vec2 );
		return erg;
	}

	// ********************************************//
	public static Vektor2D sub( Vektor2D vec1, Vektor2D vec2 ) {
		Vektor2D erg = new Vektor2D( vec1 );
		erg.sub( vec2 );
		return erg;
	}

	// ********************************************//
	public static Vektor3D sub( Vektor3D vec1, Vektor3D vec2 ) {
		Vektor3D erg = new Vektor3D( vec1 );
		erg.sub( vec2 );
		return erg;
	}

	// ********************************************//
	public static Vektor2D mult( Vektor2D vec1, Vektor2D vec2 ) {
		Vektor2D erg = new Vektor2D( vec1 );
		erg.mult( vec2 );
		return erg;
	}

	// ********************************************//
	public static Vektor2D mult( Vektor2D vec1, double val1 ) {
		Vektor2D erg = new Vektor2D( vec1 );
		erg.mult( val1 );
		return erg;
	}

	// ********************************************//
	public static Vektor2D mult( double val1, Vektor2D vec1 ) {
		Vektor2D erg = new Vektor2D( vec1 );
		erg.mult( val1 );
		return erg;
	}

	// ********************************************//
	public static Vektor3D mult( Vektor3D vec1, Vektor3D vec2 ) {
		Vektor3D erg = new Vektor3D( vec1 );
		erg.mult( vec2 );
		return erg;
	}

	// ********************************************//
	public static Vektor3D mult( Vektor3D vec1, double val1 ) {
		Vektor3D erg = new Vektor3D( vec1 );
		erg.mult( val1 );
		return erg;
	}

	// ********************************************//
	public static Vektor3D mult( double val1, Vektor3D vec1 ) {
		Vektor3D erg = new Vektor3D( vec1 );
		erg.mult( val1 );
		return erg;
	}

	// ********************************************//
	public static Vektor2D div( Vektor2D vec1, Vektor2D vec2 ) {
		Vektor2D erg = new Vektor2D( vec1 );
		erg.div( vec2 );
		return erg;
	}

	// ********************************************//
	public static Vektor2D div( Vektor2D vec1, double val1 ) {
		Vektor2D erg = new Vektor2D( vec1 );
		erg.div( val1 );
		return erg;
	}

	// ********************************************//
	public static Vektor2D div( double val1, Vektor2D vec1 ) {
		Vektor2D erg = new Vektor2D( vec1 );
		erg.div( val1 );
		return erg;
	}

	// ********************************************//
	public static Vektor3D div( Vektor3D vec1, Vektor3D vec2 ) {
		Vektor3D erg = new Vektor3D( vec1 );
		erg.div( vec2 );
		return erg;
	}

	// ********************************************//
	public static Vektor3D div( Vektor3D vec1, double val1 ) {
		Vektor3D erg = new Vektor3D( vec1 );
		erg.div( val1 );
		return erg;
	}

	// ********************************************//
	public static Vektor3D div( double val1, Vektor3D vec1 ) {
		Vektor3D erg = new Vektor3D( vec1 );
		erg.div( val1 );
		return erg;
	}

	// ********************************************//
	public static boolean isEqual( Vektor2D vec1, Vektor2D vec2 ) {
		return ( vec1.isEqual( vec2 ) );
	}

	// ********************************************//
	public static boolean isEqual( Vektor3D vec1, Vektor3D vec2 ) {
		return ( vec1.isEqual( vec2 ) );
	}

	// ********************************************//
	public static boolean isNotEqual( Vektor2D vec1, Vektor2D vec2 ) {
		return ( vec1.isNotEqual( vec2 ) );
	}

	// ********************************************//
	public static boolean isNotEqual( Vektor3D vec1, Vektor3D vec2 ) {
		return ( vec1.isNotEqual( vec2 ) );
	}

	// ********************************************//
	public static double length( Vektor2D vec1 ) {
		return ( vec1.length( ) );
	}

	// ********************************************//
	public static double length( Vektor3D vec1 ) {
		return ( vec1.length( ) );
	}

	// ********************************************//
	public static Vektor2D normalize( Vektor2D vec1 ) {
		Vektor2D erg = new Vektor2D( vec1 );
		erg.normalize( );
		return erg;
	}

	// ********************************************//
	public static Vektor3D normalize( Vektor3D vec1 ) {
		Vektor3D erg = new Vektor3D( vec1 );
		erg.normalize( );
		return erg;
	}

	// ********************************************//
	public static Vektor2D euklDistance( Vektor2D vec1, Vektor2D vec2 ) {
		Vektor2D erg = new Vektor2D( vec1 );
		erg.euklDistance( vec2 );
		return erg;
	}

	// ********************************************//
	public static Vektor3D euklDistance( Vektor3D vec1, Vektor3D vec2 ) {
		Vektor3D erg = new Vektor3D( vec1 );
		erg.euklDistance( vec2 );
		return erg;
	}

	// ********************************************//
	public static Vektor2D manhattanDistance( Vektor2D vec1, Vektor2D vec2 ) {
		Vektor2D erg = new Vektor2D( vec1 );
		erg.manhattanDistance( vec2 );
		return erg;
	}

	// ********************************************//
	public static Vektor3D manhattanDistance( Vektor3D vec1, Vektor3D vec2 ) {
		Vektor3D erg = new Vektor3D( vec1 );
		erg.manhattanDistance( vec2 );
		return erg;
	}

	// ********************************************//
	public static Vektor3D crossProduct( Vektor3D vec1, Vektor3D vec2 ) {
		Vektor3D erg = new Vektor3D( vec1 );
		erg.crossProduct( vec2 );
		return erg;
	}

	// ********************************************//
	public static double dotProduct( Vektor2D vec1, Vektor2D vec2 ) {
		return vec1.dotProduct( vec2 );
	}

	// ********************************************//
	public static double dotProduct( Vektor3D vec1, Vektor3D vec2 ) {
		return vec1.dotProduct( vec2 );
	}

	// ********************************************//
	public static double abs( Vektor2D vec1, Vektor2D vec2 ) {
		return vec1.abs( vec2 );
	}

	// ********************************************//
	public static double abs( Vektor3D vec1, Vektor3D vec2 ) {
		return vec1.abs( vec2 );
	}

	public static double determinante( Vektor2D vec1, Vektor2D vec2 ) {
		return vec1.determinante( vec2 );
	}

	// ********************************************//
	public static double cosEquation( Vektor2D vec1, Vektor2D vec2 ) {
		return vec1.cosEquation( vec2 );
	}

	// ********************************************//
	public static double sinEquation( Vektor2D vec1, Vektor2D vec2 ) {
		return vec1.sinEquation( vec2 );
	}

	// ********************************************//
	public static double angleRad( double deg ) {
		return ( ( ( 2 * Math.PI ) / 360 ) * deg );
	}

	// ********************************************//
	public static double angleDegree( double rad ) {
		return ( ( 360 / ( 2 * Math.PI ) ) * rad );
	}
}