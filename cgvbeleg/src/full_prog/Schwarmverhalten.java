package full_prog;

import math.*;

import org.lwjgl.input.Mouse;

public class Schwarmverhalten implements Verhalten {

	public Dreiecke dreieck;
	public ObjektManager om = ObjektManager.getExemplar( );

	public Schwarmverhalten( Dreiecke dreieck, ObjektManager src_om ) {
		this.dreieck = dreieck;
		this.om = src_om;
	}

	public Vektor2D arrive( Vektor2D target ) {
		Vektor2D help;
		help = LineareAlgebra.sub( target, dreieck.getPosition( ) );
		double dist = help.length( );
		double speed = dreieck.getMaxGeschwindigkeit( ) * ( dist / 1000 );
		speed = Math.min( speed, dreieck.getMaxGeschwindigkeit( ) );
		help.mult( speed / dist );
		return help;
	}

	public Vektor2D separation( float separationDist ) {
		Vektor2D help = new Vektor2D( 0, 0 );
		Vektor2D steeringForce = new Vektor2D( 0, 0 );
		for ( int i = 0; i < om.getDreieckSize( ); i++ ) {
			if ( dreieck.getId( ) == i )
				continue;
			BasisObjekt bObj = om.getDreieck( i );
			if ( bObj instanceof BewegendesObjekt ) {
				BewegendesObjekt bObjF = ( BewegendesObjekt ) bObj;
				if ( ( LineareAlgebra.euklDistance( dreieck.getPosition( ), bObjF.getPosition( ) ) ) < separationDist ) {
					help = LineareAlgebra.sub( dreieck.getPosition( ), bObjF.getPosition( ) );
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
		for ( int i = 0; i < om.getDreieckSize( ); i++ ) {
			if ( dreieck.getId( ) == i )
				continue;
			BasisObjekt bObj = om.getDreieck( i );
			if ( bObj instanceof BewegendesObjekt ) {
				BewegendesObjekt bObjF = ( BewegendesObjekt ) bObj;
				if ( LineareAlgebra.euklDistance( dreieck.getPosition( ), bObjF.getPosition( ) ) < separationDist ) {
					steeringForce.add( bObjF.getGeschwindigkeit( ) );
					count++;
				}
			}
		}
		if ( count > 0 ) {
			steeringForce.mult( 1. / count );
			steeringForce.sub( dreieck.getGeschwindigkeit( ) );
		}
		return steeringForce;
	}

	public Vektor2D cohesion( ) {
		Vektor2D steeringForce = new Vektor2D( 0, 0 );
		int count = 0;
		for ( int i = 0; i < om.getDreieckSize( ); i++ ) {
			if ( dreieck.getId( ) == i )
				continue;
			BasisObjekt bObj = om.getDreieck( i );
			if ( bObj instanceof BewegendesObjekt ) {
				BewegendesObjekt bObjF = ( BewegendesObjekt ) bObj;
				steeringForce.add( bObjF.getPosition( ) );
				count++;
			}
		}

		steeringForce.mult( ( 1.f / count ) );
		steeringForce.sub( dreieck.getPosition( ) );
		return steeringForce;
	}

	@Override
	public void update( ) {
		boolean leftButtonDown = Mouse.isButtonDown( 0 );
		if ( leftButtonDown ) {
			Vektor2D target = new Vektor2D( Mouse.getX( ), 480 - Mouse.getY( ) );
			Vektor2D follow = arrive( target );
			Vektor2D ali = alignment( 225.5f );
			Vektor2D coh = cohesion( );
			Vektor2D sep = separation( 30 );
			Vektor2D force_1 = LineareAlgebra.add( follow, ali );
			Vektor2D force_2 = LineareAlgebra.add( force_1, sep );
			Vektor2D force_3 = LineareAlgebra.add( force_2, coh );
			dreieck.getPosition( ).add( force_2 );
		}

	}
}
