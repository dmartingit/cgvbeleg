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
	public int checkAdd( double x, double y ) {
		if ( y > 0.0 ) {
			// Overflow
			if ( ( Double.MAX_VALUE - y ) < x ) {
				return 1;
			}
		} else {
			// Underflow
			if ( ( -Double.MAX_VALUE - y ) > x ) {
				return 2;
			}
		}
		return 0;
	}

	// ********************************************//
	public void add( Vektor2D src ) {
		switch ( checkAdd( this.x, src.x ) ) {
		case 0:
			// Default
			this.x += src.x;
			break;
		case 1:
			// Overflow
			this.x = Double.MAX_VALUE;
			break;
		case 2:
			// Underflow
			this.x = -Double.MAX_VALUE;
			break;
		}
		switch ( checkAdd( this.y, src.y ) ) {
		case 0:
			// Default
			this.y += src.y;
			break;
		case 1:
			// Overflow
			this.y = Double.MAX_VALUE;
			break;
		case 2:
			// Underflow
			this.y = -Double.MAX_VALUE;
			break;
		}
	}

	// ********************************************//
	public int checkSub( double x, double y ) {
		if ( y > 0.0 ) {
			// Overflow
			if ( ( -Double.MAX_VALUE + y ) > x ) {
				return 1;
			}
		} else {
			// Underflow
			if ( ( Double.MAX_VALUE + y ) < x ) {
				return 2;
			}
		}
		return 0;
	}

	// ********************************************//
	public void sub( Vektor2D src ) {
		switch ( checkSub( this.x, src.x ) ) {
		case 0:
			// Default
			this.x -= src.x;
			break;
		case 1:
			// Overflow
			this.x = Double.MAX_VALUE;
			break;
		case 2:
			// Underflow
			this.x = -Double.MAX_VALUE;
			break;
		}
		switch ( checkSub( this.y, src.y ) ) {
		case 0:
			// Default
			this.y -= src.y;
			break;
		case 1:
			// Overflow
			this.y = Double.MAX_VALUE;
			break;
		case 2:
			// Underflow
			this.y = -Double.MAX_VALUE;
			break;
		}
	}

	// ********************************************//
	public int checkMult( double x, double y ) {
		if ( y > 0.0 ) {
			// Overflow
			if ( ( ( Double.MAX_VALUE / y ) < x ) || ( ( -Double.MAX_VALUE / y ) > x ) )
				return 1;
		} else if ( y < -1 ) {
			// Underflow
			if ( ( ( -Double.MAX_VALUE / y ) < x ) || ( ( Double.MAX_VALUE / y ) > x ) )
				return 2;
		} else if ( ( y == -1.0 ) && ( x == Double.MIN_VALUE ) ) {
			// MIN_VALUE - Error (handle like Overflow)
			return 1;
		}
		// Default
		return 0;
	}

	// ********************************************//
	public void mult( Vektor2D src ) {
		switch ( checkMult( this.x, src.x ) ) {
		case 0:
			// Default
			this.x *= src.x;
			break;
		case 1:
			// Overflow
			this.x = Double.MAX_VALUE;
			break;
		case 2:
			// Underflow
			this.x = -Double.MAX_VALUE;
			break;
		}
		switch ( checkMult( this.y, src.y ) ) {
		case 0:
			// Default
			this.y *= src.y;
			break;
		case 1:
			// Overflow
			this.y = Double.MAX_VALUE;
			break;
		case 2:
			// Underflow
			this.y = -Double.MAX_VALUE;
			break;
		}
	}

	// ********************************************//
	public void mult( double src ) {
		switch ( checkMult( this.x, src ) ) {
		case 0:
			// Default
			this.x *= src;
			break;
		case 1:
			// Overflow
			this.x = Double.MAX_VALUE;
			break;
		case 2:
			// Underflow
			this.x = -Double.MAX_VALUE;
			break;
		}
		switch ( checkMult( this.y, src ) ) {
		case 0:
			// Default
			this.y *= src;
			break;
		case 1:
			// Overflow
			this.y = Double.MAX_VALUE;
			break;
		case 2:
			// Underflow
			this.y = -Double.MAX_VALUE;
			break;
		}
	}

	// ********************************************//
	public int checkDiv( double x, double y ) {
		if ( ( x == Double.MIN_VALUE ) && ( y == -1.0 ) ) {
			// MIN_VALUE - Error (handle like Overflow)
			return 1;
		}
		if ( y == 0.0 ) {
			// Invalid Operation (handle like Overflow)
			return 1;
		}
		return 0;
	}

	// ********************************************//
	public void div( Vektor2D src ) {
		switch ( checkDiv( this.x, src.x ) ) {
		case 0:
			// Default
			this.x /= src.x;
			break;
		case 1:
			// Overflow
			this.x = Double.MAX_VALUE;
			break;
		}
		switch ( checkDiv( this.y, src.y ) ) {
		case 0:
			// Default
			this.y /= src.y;
			break;
		case 1:
			// Overflow
			this.y = Double.MAX_VALUE;
			break;
		}
	}

	// ********************************************//
	public void div( double src ) {
		switch ( checkDiv( this.x, src ) ) {
		case 0:
			// Default
			this.x /= src;
			break;
		case 1:
			// Overflow
			this.x = Double.MAX_VALUE;
			break;
		}
		switch ( checkDiv( this.y, src ) ) {
		case 0:
			// Default
			this.y /= src;
			break;
		case 1:
			// Overflow
			this.y = Double.MAX_VALUE;
			break;
		}
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
		if ( this.length( ) == 0.0 ) {
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
		return ( Math.acos( dotProduct( src ) / src.length( ) * this.length( ) ) );
	}

	// ********************************************//
	public double sinEquation( Vektor2D src ) {
		return ( Math.asin( determinante( src ) / src.length( ) * this.length( ) ) );
	}

	// ********************************************//
	public double abs( Vektor2D src ) {
		return ( Math.abs( src.x ) + Math.abs( src.y ) );
	}
}