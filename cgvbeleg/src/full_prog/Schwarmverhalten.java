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
		help = LineareAlgebra.sub( dreieck.getPosition( ), target );
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
				if ( ( LineareAlgebra.euklDistance( dreieck.getPosition( ),
						bObjF.getPosition( ) ) ) < separationDist ) {
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

	public Vektor2D cohesion( double abstand ) {
		Vektor2D steeringForce = new Vektor2D( 0, 0 );
		int count = 0;
		for ( int i = 0; i < om.getDreieckSize( ); i++ ) {
			if ( dreieck.getId( ) == i )
				continue;
			BasisObjekt bObj = om.getDreieck( i );
			if ( bObj instanceof BewegendesObjekt ) {
				BewegendesObjekt bObjF = ( BewegendesObjekt ) bObj;
				if ( ( LineareAlgebra.euklDistance( bObjF.getPosition( ), dreieck.getPosition( ) ) ) < abstand ) {
					steeringForce.add( bObjF.getPosition( ) );
					count++;
				}
			}
		}
		if ( count > 0 ) {
			steeringForce.mult( ( 1.f / count ) );
		}
		steeringForce.sub( dreieck.getPosition( ) );
		return steeringForce;
	}

	@Override
	public void update( ) {
		boolean leftButtonDown = Mouse.isButtonDown( 0 );
		if ( leftButtonDown ) {
			Vektor2D target = new Vektor2D( Mouse.getX( ), 480 - Mouse.getY( ) );
			Vektor2D follow = arrive(target);
			dreieck.getGeschwindigkeit( ).add(follow);
			Vektor2D ali = alignment(300.f);
			ali.mult(1500);
			dreieck.getGeschwindigkeit( ).add(ali);
			Vektor2D sep = separation(25.f);
			sep.mult(1500);
			dreieck.getGeschwindigkeit( ).add(sep);
			Vektor2D coh = cohesion(300);
			dreieck.getGeschwindigkeit( ).add(coh);
			
			if (dreieck.getGeschwindigkeit( ).length( ) > 0.1) {
				dreieck.getGeschwindigkeit( ).normalize( );
				dreieck.getGeschwindigkeit( ).mult( 0.1 );
			}
			dreieck.getPosition( ).add( dreieck.getGeschwindigkeit( ) );
			
			dreieck.getPosition( ).setX( dreieck.getPosition( ).getX() + 640 );
			dreieck.getPosition( ).setY( dreieck.getPosition( ).getY() + 480 );
			dreieck.getPosition( ).setX( dreieck.getPosition( ).getX() % 640 );
			dreieck.getPosition( ).setY( dreieck.getPosition( ).getY() % 480 );
		}
	}
}
