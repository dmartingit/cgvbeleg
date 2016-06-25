package full_prog;

import java.util.HashMap;

public class ObjektManager {
	private HashMap < Integer, Dreiecke > dreiecke;
	private HashMap < Integer, Leader > leader;

	// ****************************************************
	// ObjektManager als Singleton realisieren
	private static ObjektManager exemplar1 = new ObjektManager( );
	private static ObjektManager exemplar2 = new ObjektManager( );

	private ObjektManager( ) {
		dreiecke = new HashMap < Integer, Dreiecke >( );
		leader = new HashMap < Integer, Leader >( );
	}

	public static ObjektManager getExemplar1( ) {
		return exemplar1;
	}
	
	public static ObjektManager getExemplar2( ) {
		return exemplar2;
	}

	public Object clone( ) throws CloneNotSupportedException {
		throw new CloneNotSupportedException( "Clonen ist nicht erlaubt" );
	}
	// ***************************************************

	public void registriereDreiecke( Dreiecke obj ) {
		dreiecke.put( new Integer( obj.getId( ) ), obj );
	}
	
	public void registriereLeader( Leader obj ) {
		leader.put( new Integer( obj.getId( ) ), obj );
	}

	public void entferneDreiecke( Dreiecke obj ) {
		dreiecke.remove( obj );
	}

	public void entferneLeader( Leader obj ) {
		leader.remove( obj );
	}

	public Dreiecke getDreieck( int objID ) {
		return dreiecke.get( new Integer( objID ) );
	}
	
	public Leader getLeader( int objID ) {
		return leader.get( new Integer( objID ) );
	}

	public HashMap < Integer, Dreiecke > getDreieckeMap( ) {
		return dreiecke;
	}
	
	public HashMap < Integer, Leader > getLeaderMap( ) {
		return leader;
	}

	public int getDreieckSize( ) {
		return dreiecke.size( );
	}
	
	public int getLeaderSize( ) {
		return leader.size( );
	}
}
