package full_prog;

import java.util.HashMap;

public class ObjektManager {
	private HashMap < Integer, Dreiecke > dreiecke;

	// ****************************************************
	// ObjektManager als Singleton realisieren
	private static ObjektManager exemplar = new ObjektManager( );

	private ObjektManager( ) {
		dreiecke = new HashMap < Integer, Dreiecke >( );
	}

	public static ObjektManager getExemplar( ) {
		return exemplar;
	}

	public Object clone( ) throws CloneNotSupportedException {
		throw new CloneNotSupportedException( "Clonen ist nicht erlaubt" );
	}
	// ***************************************************

	public void registriereDreiecke( Dreiecke obj ) {
		dreiecke.put( new Integer( obj.getId( ) ), obj );
	}

	public void entferneDreiecke( Dreiecke obj ) {
		dreiecke.remove( obj );
	}

	public Dreiecke getDreieck( int objID ) {
		return dreiecke.get( new Integer( objID ) );
	}

	public HashMap < Integer, Dreiecke > getDreieckeMap( ) {
		return dreiecke;
	}

	public int getDreieckSize( ) {
		return dreiecke.size( );
	}
}
