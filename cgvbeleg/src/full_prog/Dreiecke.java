package full_prog;

import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import math.Vektor2D;

public class Dreiecke extends BewegendesObjekt {
	private static int objCounter = 0;
	private float r, g, b;

	public Dreiecke( ) {
		this( new Vektor2D( 0, 0 ), new Vektor2D( 0.2f, 0.1f ), 1, 1, 0 );
	}

	public Dreiecke( Vektor2D src, Vektor2D velocity ) {
		this( src, velocity, 1, 1, 0 );
	}

	public Dreiecke( Vektor2D src, Vektor2D velocity, float r, float g, float b ) {
		super( src, velocity, 0.8f );
		this.r = r;
		this.g = g;
		this.b = b;
		setId( ++objCounter );
	}

	@Override
	public void render( ) {
		glColor3d( r, g, b );
		glBegin( GL_TRIANGLE_FAN );
		glVertex2f( ( float ) getPosition( ).x, ( float ) getPosition( ).y );
		glVertex2f( ( float ) getPosition( ).x - 10, ( float ) getPosition( ).y );
		glVertex2f( ( float ) getPosition( ).x + 10, ( float ) getPosition( ).y );
		glVertex2f( ( float ) getPosition( ).x, ( float ) getPosition( ).y - 10 );

		glEnd( );
	}
}
