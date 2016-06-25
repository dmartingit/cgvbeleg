
package full_prog;

import math.*;

public abstract class BewegendesObjekt extends BasisObjekt {
	private Vektor2D m_Geschwindigkeit;
	private double m_maxGeschwindigkeit;
	private Verhalten m_Verhalten = null;

	public BewegendesObjekt( Vektor2D pos, Vektor2D geschwindigkeit, double maxGeschwindigkeit, double masse ) {
		super( pos );
		setGeschwindigkeit( geschwindigkeit );
		setMaxGeschwindigkeit( maxGeschwindigkeit);
	}

	public void setGeschwindigkeit( Vektor2D velocity ) {
		this.m_Geschwindigkeit = velocity;
	}
	
	public Vektor2D getGeschwindigkeit(  ) {
		return this.m_Geschwindigkeit;
	}
	
	public void setMaxGeschwindigkeit( double maxVelocity ) {
		this.m_maxGeschwindigkeit = maxVelocity;
	}
	
	public double getMaxGeschwindigkeit(  ) {
		return this.m_maxGeschwindigkeit;
	}
	
	public void setVerhalten( Verhalten verhalten ) {
		this.m_Verhalten = verhalten;
	}
	
	public Verhalten getVerhalten( ) {
		return this.m_Verhalten;
	}

	public void update( ) {
		if ( m_Verhalten != null )
			m_Verhalten.update( );
	}
}
