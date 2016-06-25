package full_prog;

import math.*;

public final class Leaderverhalten implements Verhalten {
	
	public Leader m_Lead;
	public ObjektManager m_ObjektManager = ObjektManager.getExemplar2( );

	Leaderverhalten(Leader lead, ObjektManager om) {
		this.m_Lead = lead;
		m_ObjektManager = om;
	}
	
	public Vektor2D separation( float separationDist ) {
		Vektor2D help = new Vektor2D( 0, 0 );
		Vektor2D steeringForce = new Vektor2D( 0, 0 );
		for ( int i = 0; i < m_ObjektManager.getDreieckSize( ); i++ ) {
			if ( m_Lead.getId( ) == i )
				continue;
			BasisObjekt bObj = m_ObjektManager.getDreieck( i );
			if ( bObj instanceof BewegendesObjekt ) {
				BewegendesObjekt bObjF = ( BewegendesObjekt ) bObj;
				if ( ( LineareAlgebra.euklDistance( m_Lead.getPosition( ),
						bObjF.getPosition( ) ) ) < separationDist ) {
					help = LineareAlgebra.sub( m_Lead.getPosition( ), bObjF.getPosition( ) );
					double length = help.length( );
					help.normalize( );
					help.div( length );
					steeringForce.add( help );
				}
			}
		}
		return steeringForce;
	}

	@Override
	public void update() {
		Vektor2D sep = separation(25.f);
		sep.mult( 500.f );
		m_Lead.setGeschwindigkeit( sep );
		if (m_Lead.getGeschwindigkeit( ).length( ) > 0.1) {
			m_Lead.getGeschwindigkeit( ).normalize( );
			m_Lead.getGeschwindigkeit( ).mult( 0.1 );
		}
		m_Lead.getPosition( ).add( m_Lead.getGeschwindigkeit( ) );
		
		m_Lead.getPosition( ).setX( m_Lead.getPosition( ).getX() + 640 );
		m_Lead.getPosition( ).setY( m_Lead.getPosition( ).getY() + 480 );
		m_Lead.getPosition( ).setX( m_Lead.getPosition( ).getX() % 640 );
		m_Lead.getPosition( ).setY( m_Lead.getPosition( ).getY() % 480 );
	}
}
