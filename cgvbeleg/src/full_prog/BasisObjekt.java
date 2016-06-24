package full_prog;

import math.Vektor2D;

public abstract class BasisObjekt {
   public int id;
   public Vektor2D pos;

   
   public BasisObjekt() {
      this(new Vektor2D(0,0));
   }
   
   public BasisObjekt(Vektor2D src) {
      this.pos = new Vektor2D(src);
   }
  
   public abstract void render();
}
