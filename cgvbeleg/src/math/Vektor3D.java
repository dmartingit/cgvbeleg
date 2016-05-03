package math;

public class Vektor3D {
	private double x, y, z;

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
	public void add( Vektor3D src ) {
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
		switch ( checkAdd( this.z, src.z ) ) {
		case 0:
			// Default
			this.z += src.z;
			break;
		case 1:
			// Overflow
			this.z = Double.MAX_VALUE;
			break;
		case 2:
			// Underflow
			this.z = -Double.MAX_VALUE;
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
	public void sub( Vektor3D src ) {
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
		switch ( checkSub( this.z, src.z ) ) {
		case 0:
			// Default
			this.z -= src.z;
			break;
		case 1:
			// Overflow
			this.z = Double.MAX_VALUE;
			break;
		case 2:
			// Underflow
			this.z = -Double.MAX_VALUE;
			break;
		}
	}

	// ********************************************//
	public int checkMult( double x, double y ) {
		if ( y > 0.0 ) {
			// Overflow
			if ( ( ( Double.MAX_VALUE / y ) < x ) || ( ( -Double.MAX_VALUE / y ) > x ) )
				return 1;
		} else if ( y < -1.0 ) {
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
	public void mult( Vektor3D src ) {
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
		switch ( checkMult( this.z, src.z ) ) {
		case 0:
			// Default
			this.z *= src.z;
			break;
		case 1:
			// Overflow
			this.z = Double.MAX_VALUE;
			break;
		case 2:
			// Underflow
			this.z = -Double.MAX_VALUE;
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
		switch ( checkMult( this.z, src ) ) {
		case 0:
			// Default
			this.z *= src;
			break;
		case 1:
			// Overflow
			this.z = Double.MAX_VALUE;
			break;
		case 2:
			// Underflow
			this.z = -Double.MAX_VALUE;
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
	public void div( Vektor3D src ) {
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
		switch ( checkDiv( this.z, src.z ) ) {
		case 0:
			// Default
			this.z /= src.z;
			break;
		case 1:
			// Overflow
			this.z = Double.MAX_VALUE;
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
		switch ( checkDiv( this.z, src ) ) {
		case 0:
			// Default
			this.z /= src;
			break;
		case 1:
			// Overflow
			this.z = Double.MAX_VALUE;
			break;
		}
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

	// ********************************************//
	public void crossProduct( Vektor3D src ) {
		Vektor3D erg = new Vektor3D( ( ( this.y * src.z ) - ( this.z * src.y ) ),
				( ( this.z * src.x ) - ( this.x * src.z ) ), ( ( this.x * src.y ) - ( this.y * src.x ) ) );
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
}