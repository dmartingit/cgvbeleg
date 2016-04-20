package math;

public class Vektor2D {
	private double x, y;

	// ********************************************//
	public Vektor2D( ) {
		this( 0.0, 0.0 );
	}

	// ********************************************//
	public Vektor2D( double x, double y ) {
		this.x = x;
		this.y = y;
	}

	// ********************************************//
	public Vektor2D( Vektor2D src ) {
		this.x = src.x;
		this.y = src.y;
	}

	// ********************************************//
	public String toString( ) {
		return "x: " + this.x + " y: " + this.y;
	}

	// ********************************************//
	public double[ ] getArray( ) {
		double[ ] arr = { this.x, this.y };
		return arr;
	}

	// ********************************************//
	public void setX( double x ) {
		this.x = x;
	}

	// ********************************************//
	public double getX( ) {
		return this.x;
	}

	// ********************************************//
	public void setY( double y ) {
		this.y = y;
	}

	// ********************************************//
	public double getY( ) {
		return this.y;
	}

	// ********************************************//
	public void setPosition( double x, double y ) {
		this.x = x;
		this.y = y;
	}

	// ********************************************//
	public void add( Vektor2D src ) {
		this.x += src.x;
		this.y += src.y;
	}

	// ********************************************//
	public void add( double src ) {
		this.x += src;
		this.y += src;
	}

	// ********************************************//
	public void sub( Vektor2D src ) {
		this.x -= src.x;
		this.y -= src.y;
	}

	// ********************************************//
	public void sub( double src ) {
		this.x -= src;
		this.y -= src;
	}

	// ********************************************//
	public void mult( Vektor2D src ) {
		this.x *= src.x;
		this.y *= src.y;
	}

	// ********************************************//
	public void mult( double src ) {
		this.x *= src;
		this.y *= src;
	}

	// ********************************************//
	public void div( Vektor2D src ) {
		this.x /= src.x;
		this.y /= src.y;
	}

	// ********************************************//
	public void div( double src ) {
		this.x /= src;
		this.y /= src;
	}

	// ********************************************//
	public boolean isNullVector( ) {
		return ( this.x == 0 && this.y == 0 );
	}

	// ********************************************//
	public boolean isEqual( Vektor2D src ) {
		return ( this.x == src.x && this.y == src.y );
	}

	// ********************************************//
	public boolean isNotEqual( Vektor2D src ) {
		return ( this.x != src.x || this.y != src.y );
	}

	// ********************************************//
	public double length( ) {
		return Math.sqrt( ( this.x * this.x ) + ( this.y * this.y ) );
	}

	// ********************************************//
	public void normalize( ) {
		mult( 1 / length( ) );
	}

	// ********************************************//
	public double euklDistance( Vektor2D src ) {
		double dist = 0, diff = 0;
		diff = this.x - src.x;
		dist += diff * diff;
		diff = this.y - src.y;
		dist += diff * diff;
		return Math.sqrt( dist );
	}

	// ********************************************//
	public double manhattanDistance( Vektor2D src ) {
		return ( Math.abs( this.x - src.x ) + Math.abs( this.y - src.y ) );
	}

	// ********************************************//
	public double dotProduct( Vektor2D src ) {
		return ( this.x * src.x + this.y * src.y );
	}
}
