package full_prog;

import math.*;

public class Schwarmverhalten implements Verhalten {
	
	public BewegendesObjekt obj;
	
	public Schwarmverhalten(BewegendesObjekt obj){
		this.obj = obj;		
	}
	
	@Override
	public void update(){
		Vektor2D val = new Vektor2D(0.9f, 0.3f);
		obj.speed.add( val );
		obj.pos.add( obj.speed );
		
				
	}

}
