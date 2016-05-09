package math;

public class Vektor3D {
	public double x, y, z;

	// ********************************************//
	public Vektor3D( ) {
		this( 0.0, 0.0, 0.0 );
	}

	// ********************************************//
	public Vektor3D( double x, double y, double z ) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// ********************************************//
	public Vektor3D( Vektor3D src ) {
		this.x = src.x;
		this.y = src.y;
		this.z = src.z;
	}

	// ********************************************//
	public String toString( ) {
		return "x: " + this.x + " y: " + this.y + " z: " + this.z;
	}

	// ********************************************//
	public double[ ] getArray( ) {
		double[ ] arr = { this.x, this.y, this.z };
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
	public void setZ( double z ) {
		this.z = z;
	}

	// ********************************************//
	public double getZ( ) {
		return this.z;
	}

	// ********************************************//
	public void setPosition( double x, double y, double z ) {
		this.x = x;
		this.y = y;
		this.z = z;
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
	public void add( Vektor3D src ) {
		this.x = checkAdd( this.x, src.x );
		this.y = checkAdd( this.y, src.y );
		this.z = checkAdd( this.z, src.z );
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
	public void sub( Vektor3D src ) {
		this.x = checkSub( this.x, src.x );
		this.y = checkSub( this.y, src.y );
		this.z = checkSub( this.z, src.z );
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
		this.z = checkMult( this.z, src );
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
		this.z = checkDiv( this.z, src );
	}

	// ********************************************//
	public boolean isNullVector( ) {
		return ( this.x == 0 && this.y == 0 && this.z == 0 );
	}

	// ********************************************//
	public boolean isEqual( Vektor3D src ) {
		return ( this.x == src.x && this.y == src.y && this.z == src.z );
	}

	// ********************************************//
	public boolean isNotEqual( Vektor3D src ) {
		return !this.isEqual( src );
	}

	// ********************************************//
	public double length( ) {
		return Math.sqrt( ( this.x * this.x ) + ( this.y * this.y ) + ( this.z * this.z ) );
	}

	// ********************************************//
	public void normalize( ) {
		if ( this.length( ) == 0.0 ) {
			this.x = 0;
			this.y = 0;
			this.z = 0;
		} else {
			mult( 1 / this.length( ) );
		}
	}

	// ********************************************//
	public double euklDistance( Vektor3D src ) {
		double dist = 0, diff = 0;
		diff = this.x - src.x;
		dist += diff * diff;
		diff = this.y - src.y;
		dist += diff * diff;
		diff = this.z - src.z;
		dist += diff * diff;
		return Math.sqrt( dist );
	}

	// ********************************************//
	public double manhattanDistance( Vektor3D src ) {
		return ( Math.abs( this.x - src.x ) + Math.abs( this.y - src.y ) + Math.abs( this.z - src.z ) );
	}

	public double cCrPr( double x, double y ) {
		if ( y > 0.0 ) {
			// Overflow
			if ( ( ( Double.MAX_VALUE / y ) < x ) || ( ( -Double.MAX_VALUE / y ) > x ) )
				return Double.MAX_VALUE;
		} else if ( y < -1.0 ) {
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
	public void crossProduct( Vektor3D src ) {
		Vektor3D erg = new Vektor3D( ( ( cCrPr( this.y, src.z ) ) - ( cCrPr( this.z, src.y ) ) ),
				( ( cCrPr( this.z, src.x ) ) - ( cCrPr( this.x, src.z ) ) ),
				( cCrPr( this.x, src.y ) ) - ( cCrPr( this.y, src.x ) ) );
		this.x = erg.x;
		this.y = erg.y;
		this.z = erg.z;
	}

	// ********************************************//
	public double dotProduct( Vektor3D src ) {
		return ( this.x * src.x + this.y * src.y + this.z * src.z );
	}

	// ********************************************//
	public double abs( Vektor3D src ) {
		return ( Math.abs( src.x ) + Math.abs( src.y ) + Math.abs( src.z ) );
	}

	// ********************************************//
	public double cosEquation( Vektor3D src ) {
		return ( Math.acos( this.dotProduct( src ) / ( src.length( ) * this.length( ) ) ) );
	}
}