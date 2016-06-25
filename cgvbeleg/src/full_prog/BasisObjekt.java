package full_prog;

import math.Vektor2D;

public abstract class BasisObjekt {
	private int m_iId;
	private Vektor2D m_Position;

	public BasisObjekt( ) {
		this( new Vektor2D( 0, 0 ) );
	}

	public BasisObjekt( Vektor2D src ) {
		setPosition( src );
	}

	public void setId( int id ) {
		this.m_iId = id;
	}

	public int getId( ) {
		return this.m_iId;
	}

	public void setPosition( Vektor2D position ) {
		this.m_Position = position;
	}

	public Vektor2D getPosition( ) {
		return this.m_Position;
	}

	public abstract void render( );
}
