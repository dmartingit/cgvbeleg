package math;

public class Vektor2D {
	public double x, y;

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
	public double checkAdd( double x, double y ) {
		if ( y > 0.0 ) {
			// Overflow
			if ( ( Double.MAX_VALUE - y ) < x ) {
				return Double.MAX_VALUE;
			}
		} else {
			// Underflow
			if ( ( -Double.MAX_VALUE - y ) > x ) {
				return -Double.MAX_VALUE;
			}
		}
		return x + y;
	}

	// ********************************************//
	public void add( Vektor2D src ) {
		this.x = checkAdd( this.x, src.x );
		this.y = checkAdd( this.y, src.y );
	}

	// ********************************************//
	public double checkSub( double x, double y ) {
		if ( y > 0.0 ) {
			// Overflow
			if ( ( -Double.MAX_VALUE + y ) > x ) {
				return Double.MAX_VALUE;
			}
		} else {
			// Underflow
			if ( ( Double.MAX_VALUE + y ) < x ) {
				return -Double.MAX_VALUE;
			}
		}
		return x - y;
	}

	// ********************************************//
	public void sub( Vektor2D src ) {
		this.x = checkSub( this.x, src.x );
		this.y = checkSub( this.y, src.y );
	}

	// ********************************************//
	public double checkMult( double x, double y ) {
		if ( y > 0.0 ) {
			// Overflow
			if ( ( ( Double.MAX_VALUE / y ) < x ) || ( ( -Double.MAX_VALUE / y ) > x ) )
				return Double.MAX_VALUE;
		} else if ( y < -1 ) {
			// Underflow
			if ( ( ( -Double.MAX_VALUE / y ) < x ) || ( ( Double.MAX_VALUE / y ) > x ) )
				return -Double.MAX_VALUE;
		} else if ( ( y == -1.0 ) && ( x == Double.MIN_VALUE ) ) {
			// MIN_VALUE - Error (handle like Overflow)
			return Double.MAX_VALUE;
		}
		// Default
		return x * y;
	}

	// ********************************************//
	public void mult( double src ) {
		this.x = checkMult( this.x, src );
		this.y = checkMult( this.y, src );
	}

	// ********************************************//
	public double checkDiv( double x, double y ) {
		if ( ( ( x == Double.MIN_VALUE ) && ( y == -1.0 ) ) || y == 0.0 ) {
			// MIN_VALUE - Error (handle like Overflow)
			return Double.MAX_VALUE;
		}
		return x / y;
	}

	// ********************************************//
	public void div( double src ) {
		this.x = checkDiv( this.x, src );
		this.y = checkDiv( this.y, src );
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
		return !this.isEqual( src );
	}

	// ********************************************//
	public double length( ) {
		return Math.sqrt( ( this.x * this.x ) + ( this.y * this.y ) );
	}

	// ********************************************//
	public void normalize( ) {
		if ( isNullVector( ) ) {
			this.x = 0;
			this.y = 0;
		} else {
			mult( 1 / this.length( ) );
		}
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

	// ********************************************//
	public double determinante( Vektor2D src ) {
		return ( ( this.x * src.y ) - ( src.x - this.y ) );
	}

	// ********************************************//
	public double cosEquation( Vektor2D src ) {
		if ( src.length( ) == 0 || this.length( ) == 0 ) {
			return 0.0;
		}
		return ( Math.acos( dotProduct( src ) / ( src.length( ) * this.length( ) ) ) );
	}

	// ********************************************//
	public double sinEquation( Vektor2D src ) {
		if ( src.length( ) == 0 || this.length( ) == 0 ) {
			return 0.0;
		}
		return ( Math.asin( determinante( src ) / src.length( ) * this.length( ) ) );
	}

	// ********************************************//
	public double abs( Vektor2D src ) {
		return ( Math.abs( src.x ) + Math.abs( src.y ) );
	}
}