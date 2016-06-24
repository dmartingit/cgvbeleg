package full_prog;

import math.*;
import org.lwjgl.input.Mouse;

public class Schwarmverhalten implements Verhalten {
	
	public Dreiecke dreieck;
	
	
	public Schwarmverhalten(Dreiecke dreieck){
		this.dreieck = dreieck;		
	}
	
	public Vektor2D seek(Vektor2D target) {
		Vektor2D help;
		help = LineareAlgebra.sub(target, dreieck.pos);
		System.out.println(help);
		help.normalize();
		System.out.println(help);
		//help.mult(dreieck.maxVelocity);
		//System.out.println(help);
		help = LineareAlgebra.sub(help, dreieck.velocity);
//		System.out.println("HELP: "+ help);
//		System.out.println("****************");
		return help;
		}
	
	@Override
	public void update(){
		Vektor2D target = new Vektor2D(Mouse.getX(), 480 - Mouse.getY());

		Vektor2D tmp = seek(target);
		if(tmp.x >= 0.9 || tmp.y >= 0.9){
			tmp.x = 0.9;
			tmp.y = 0.9;
		}
		
		dreieck.pos.add(tmp);

		if(dreieck.pos.y > 480 )
			dreieck.pos.y = 0;
		if(dreieck.pos.x > 640 )
			dreieck.pos.x = 0;
				
	}

}
