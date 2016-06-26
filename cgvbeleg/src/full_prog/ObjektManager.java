package full_prog;

import java.util.HashMap;

public class ObjektManager {
	private HashMap < Integer, Dreiecke > m_Dreiecke;
	private HashMap < Integer, Leader > m_Leader;

	// ****************************************************
	// ObjektManager als Singleton realisieren
	private static ObjektManager exemplar1 = new ObjektManager( );
	private static ObjektManager exemplar2 = new ObjektManager( );

	private ObjektManager( ) {
		m_Dreiecke = new HashMap < Integer, Dreiecke >( );
		m_Leader = new HashMap < Integer, Leader >( );
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
		m_Dreiecke.put( new Integer( obj.getId( ) ), obj );
	}
	
	public void registriereLeader( Leader obj ) {
		m_Leader.put( new Integer( obj.getId( ) ), obj );
	}

	public void entferneDreiecke( Dreiecke obj ) {
		m_Dreiecke.remove( obj );
	}

	public void entferneLeader( Leader obj ) {
		m_Leader.remove( obj );
	}

	public Dreiecke getDreieck( int objID ) {
		return m_Dreiecke.get( new Integer( objID ) );
	}
	
	public Leader getLeader( int objID ) {
		return m_Leader.get( new Integer( objID ) );
	}

	public HashMap < Integer, Dreiecke > getDreieckeMap( ) {
		return m_Dreiecke;
	}
	
	public HashMap < Integer, Leader > getLeaderMap( ) {
		return m_Leader;
	}

	public int getDreieckSize( ) {
		return m_Dreiecke.size( );
	}
	
	public int getLeaderSize( ) {
		return m_Leader.size( );
	}
}
