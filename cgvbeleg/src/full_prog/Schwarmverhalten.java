package full_prog;

import math.*;

import org.lwjgl.input.Mouse;

public class Schwarmverhalten implements Verhalten {

	public Dreiecke m_Dreieck;
	public ObjektManager m_ObjektManager = ObjektManager.getExemplar1( );

	public Schwarmverhalten( Dreiecke dreieck, ObjektManager src_om ) {
		this.m_Dreieck = dreieck;
		this.m_ObjektManager = src_om;
	}

	public Vektor2D arrive( Vektor2D target ) {
		Vektor2D help;
		help = LineareAlgebra.sub( m_Dreieck.getPosition( ), target );
		double dist = help.length( );
		double speed = m_Dreieck.getMaxGeschwindigkeit( ) * ( dist / 1000 );
		speed = Math.min( speed, m_Dreieck.getMaxGeschwindigkeit( ) );
		help.mult( speed / dist );
		return help;
	}

	public Vektor2D separation( float separationDist ) {
		Vektor2D help = new Vektor2D( 0, 0 );
		Vektor2D steeringForce = new Vektor2D( 0, 0 );
		for ( int i = 0; i < m_ObjektManager.getDreieckSize( ); i++ ) {
			if ( m_Dreieck.getId( ) == i )
				continue;
			BasisObjekt bObj = m_ObjektManager.getDreieck( i );
			if ( bObj instanceof BewegendesObjekt ) {
				BewegendesObjekt bObjF = ( BewegendesObjekt ) bObj;
				if ( ( LineareAlgebra.euklDistance( m_Dreieck.getPosition( ),
						bObjF.getPosition( ) ) ) < separationDist ) {
					help = LineareAlgebra.sub( m_Dreieck.getPosition( ), bObjF.getPosition( ) );
					double length = help.length( );
					help.normalize( );
					help.div( length );
					steeringForce.add( help );
				}
			}
		}
		return steeringForce;
	}

	public Vektor2D alignment( float separationDist ) {
		Vektor2D steeringForce = new Vektor2D( 0, 0 );
		int count = 0;
		for ( int i = 0; i < m_ObjektManager.getDreieckSize( ); i++ ) {
			if ( m_Dreieck.getId( ) == i )
				continue;
			BasisObjekt bObj = m_ObjektManager.getDreieck( i );
			if ( bObj instanceof BewegendesObjekt ) {
				BewegendesObjekt bObjF = ( BewegendesObjekt ) bObj;
				if ( LineareAlgebra.euklDistance( m_Dreieck.getPosition( ), bObjF.getPosition( ) ) < separationDist ) {
					steeringForce.add( bObjF.getGeschwindigkeit( ) );
					count++;
				}
			}
		}
		if ( count > 0 ) {
			steeringForce.mult( 1. / count );
			steeringForce.sub( m_Dreieck.getGeschwindigkeit( ) );
		}
		return steeringForce;
	}

	public Vektor2D cohesion( double abstand ) {
		Vektor2D steeringForce = new Vektor2D( 0, 0 );
		int count = 0;
		for ( int i = 0; i < m_ObjektManager.getDreieckSize( ); i++ ) {
			if ( m_Dreieck.getId( ) == i )
				continue;
			BasisObjekt bObj = m_ObjektManager.getDreieck( i );
			if ( bObj instanceof BewegendesObjekt ) {
				BewegendesObjekt bObjF = ( BewegendesObjekt ) bObj;
				if ( ( LineareAlgebra.euklDistance( bObjF.getPosition( ), m_Dreieck.getPosition( ) ) ) < abstand ) {
					steeringForce.add( bObjF.getPosition( ) );
					count++;
				}
			}
		}
		if ( count > 0 ) {
			steeringForce.mult( ( 1.f / count ) );
		}
		steeringForce.sub( m_Dreieck.getPosition( ) );
		return steeringForce;
	}

	@Override
	public void update( ) {
		boolean leftButtonDown = Mouse.isButtonDown( 0 );
		if ( true ) {
			int tmpID = m_Dreieck.getId( ) % 3 + 1;
			Vektor2D target = new Vektor2D( m_ObjektManager.getExemplar2( ).getLeader( tmpID ).getPosition( ) );
			Vektor2D follow = arrive( target );
			m_Dreieck.getGeschwindigkeit( ).add( follow );
			Vektor2D ali = alignment( 100.8f );
			ali.mult( 1000 );
			m_Dreieck.getGeschwindigkeit( ).add( ali );
			Vektor2D sep = separation( 25.f );
			sep.mult( 1500 );
			m_Dreieck.getGeschwindigkeit( ).add( sep );
			Vektor2D coh = cohesion( 100 );
			m_Dreieck.getGeschwindigkeit( ).add( coh );

			if ( m_Dreieck.getGeschwindigkeit( ).length( ) > 0.1 ) {
				m_Dreieck.getGeschwindigkeit( ).normalize( );
				m_Dreieck.getGeschwindigkeit( ).mult( 0.1 );
			}
			m_Dreieck.getPosition( ).add( m_Dreieck.getGeschwindigkeit( ) );

			m_Dreieck.getPosition( ).setX( m_Dreieck.getPosition( ).getX( ) + 640 );
			m_Dreieck.getPosition( ).setY( m_Dreieck.getPosition( ).getY( ) + 480 );
			m_Dreieck.getPosition( ).setX( m_Dreieck.getPosition( ).getX( ) % 640 );
			m_Dreieck.getPosition( ).setY( m_Dreieck.getPosition( ).getY( ) % 480 );
		}
	}
}
