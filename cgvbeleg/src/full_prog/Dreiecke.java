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

   public Dreiecke() {
      this(new Vektor2D(0,0), 0.2f, 0.1f, 1, 1, 0);
   }
   
   public Dreiecke(Vektor2D src, float ySpeed, float xSpeed) {
      this(src, ySpeed, xSpeed, 1, 1, 0);
   }
   
   public Dreiecke(Vektor2D src, float ySpeed, float xSpeed, float r, float g, float b) {
      super(src , ySpeed, xSpeed);
      this.r=r;
      this.g=g;
      this.b=b;
      this.id = ++objCounter;
   }

   /*@Override
   public void update() {
	   
      yPos=yPos+ySpeed;
      xPos+= xSpeed;

      if (yPos>480 || yPos<0)
         ySpeed = ySpeed * -1;
      if(xPos > 640 || xPos < 0)
    	 xSpeed *= -1;
    	
      
   }*/

   @Override
   public void render() {
      glColor3d(r, g, b);
      glBegin(GL_TRIANGLE_FAN);
      glVertex2f((float)pos.x, (float)pos.y);
      glVertex2f((float)pos.x - 10, (float)pos.y);
      glVertex2f((float)pos.x + 10, (float)pos.y);
      glVertex2f((float)pos.x, (float)pos.y - 10);
      

      glEnd(); 
   }
}
