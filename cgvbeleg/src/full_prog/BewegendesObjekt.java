package full_prog;

public abstract class BewegendesObjekt extends BasisObjekt {
   public float ySpeed;
   public float xSpeed;
   
   public BewegendesObjekt(float xPos, float yPos, float ySpeed, float xSpeed) {
      super(xPos, yPos);
      this.ySpeed = ySpeed;
      this.xSpeed = xSpeed;
   }

   public abstract void update();
}
