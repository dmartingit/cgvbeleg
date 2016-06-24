package full_prog;

import static org.lwjgl.opengl.GL11.GL_TRIANGLE_FAN;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Flummi extends BewegendesObjekt {
   private static int objCounter = 0; 
   private float r, g, b;

   public Flummi() {
      this(0, 0, 0.2f, 0.1f, 1, 1, 0);
   }
   
   public Flummi(float xPos, float yPos, float ySpeed, float xSpeed) {
      this(xPos, yPos, ySpeed, xSpeed, 1, 1, 0);
   }
   
   public Flummi(float xPos, float yPos, float ySpeed, float xSpeed, float r, float g, float b) {
      super(xPos, yPos, ySpeed, xSpeed);
      this.r=r;
      this.g=g;
      this.b=b;
      this.id = ++objCounter;
   }

   @Override
   public void update() {
      yPos=yPos+ySpeed;
      xPos+= xSpeed;

      if (yPos>480 || yPos<0)
         ySpeed = ySpeed * -1;
      if(xPos > 640 || xPos < 0)
    	 xSpeed *= -1;
      
   }

   @Override
   public void render() {
      glColor3d(r, g, b);
      glBegin(GL_TRIANGLE_FAN);
      glVertex2f(xPos, yPos);
      /*
      for (int angle=0; angle<360; angle+=60) {
         glVertex2f(xPos + (float)Math.sin(angle) * radius, yPos + (float)Math.cos(angle) * radius);
      }
      */
      glVertex2f(xPos + 10, yPos + 20);
      glVertex2f(xPos - 10, yPos + 20);
      //glVertex2f(xPos + 7, yPos + 30);
      //glVertex2f(xPos - 7, yPos + 30);
      
      glEnd(); 
   }
}
