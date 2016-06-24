
package full_prog;
import math.*;
public abstract class BewegendesObjekt extends BasisObjekt {
   public Vektor2D speed;
   public double masse;
   public Verhalten verhalten = null;
   
   public BewegendesObjekt(Vektor2D src, float ySpeed, float xSpeed) {
      super(src);
      this.speed.x = xSpeed;
      this.speed.y = ySpeed;
   }
   public void setVerhalten(Verhalten verhalten) {
	      this.verhalten = verhalten;
	   }

   //public abstract void update();
}
