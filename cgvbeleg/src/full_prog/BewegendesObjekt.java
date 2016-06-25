
package full_prog;
import math.*;
public abstract class BewegendesObjekt extends BasisObjekt {
   public Vektor2D velocity;
   public double maxVelocity = 0.8;
   public Verhalten verhalten = null;
   
   public BewegendesObjekt(Vektor2D pos, Vektor2D speed) {
      super(pos);
      this.velocity = new Vektor2D(speed);
   }
   public void setVerhalten(Verhalten verhalten) {
	      this.verhalten = verhalten;
	   }
 
   public void update(){
	   if(verhalten != null)
		   verhalten.update();
   }
}
