package math;

public class Vektor3D {
	private double x, y, z;

	// ********************************************//
	public Vektor3D( ) {
		this.x = 0;
		this.y = 0;
		this.z = 0;
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
	public double getZ() {
			return this.z;
	}
	
	// ********************************************//
	public void setPosition( double x, double y, double z ) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// ********************************************//
	public void add( Vektor3D src ) {
		this.x += src.x;
		this.y += src.y;
		this.z += src.z;
	}
	
	// ********************************************//
	public void sub( Vektor3D src ) {
		this.x -= src.x;
		this.y -= src.y;
		this.z -= src.z;
	}
	
	// ********************************************//
	public void mult( Vektor3D src ) {
		this.x *= src.x;
		this.y *= src.y;
		this.z *= src.z;
	}
	
	// ********************************************//
	public void div( Vektor3D src ) {
		this.x /= src.x;
		this.y /= src.y;
		this.z /= src.z;
	}
	
	
	// ********************************************//
	public boolean isNullVector( ) {
		return ( this.x == 0 && this.y == 0 && this.z == 0);
	}
	
	// ********************************************//
	public boolean isEqual( Vektor3D src ) {
		return ( this.x == src.x && this.y == src.y && this.z == src.z );
	}

	// ********************************************//
	public boolean isNotEqual( Vektor3D src ) {
		return ( this.x != src.x || this.y != src.y || this.z != src.z );
	}
	
	// ********************************************//
	public double length( ) {
		return Math.sqrt( ( this.x * this.x ) + ( this.y * this.y ) + (this.z * this.z) );
	}
	
	// ********************************************//
	public void normalize(Vektor3D src ) {
		double leng = 1/src.length( );
		this.x = this.x/leng;
		this.y = this.y/leng;
		this.z = this.z/leng;
			
	}


}
