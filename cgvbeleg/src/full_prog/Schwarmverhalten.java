package full_prog;


public class Schwarmverhalten implements Verhalten {
	
	//public BewegendesObjekt obj;
	public Dreiecke dreieck;
	
	public Schwarmverhalten(Dreiecke dreieck){
		this.dreieck = dreieck;		
	}
	
	@Override
	public void update(){
		dreieck.pos.add( dreieck.speed );
		if(dreieck.pos.y > 480 || dreieck.pos.y < 0)
			dreieck.speed.y *= -1;
		if(dreieck.pos.x > 640 || dreieck.pos.x < 0)
			dreieck.speed.x *= -1;
		
				
	}

}
