package full_prog;

import math.*;

import org.lwjgl.input.Mouse;

public class Schwarmverhalten implements Verhalten {
	
	public Dreiecke dreieck;
	public ObjektManager om = ObjektManager.getExemplar();
	
	
	public Schwarmverhalten(Dreiecke dreieck, ObjektManager src_om){
		this.dreieck = dreieck;
		this.om = src_om;
	}
	
	public Vektor2D seek(Vektor2D target) {
		Vektor2D help;
		help = LineareAlgebra.sub(target, dreieck.pos);
		help.mult(dreieck.maxVelocity);
		help.normalize();
		help.sub(dreieck.velocity);
		return help;
	}
	 public Vektor2D arrive(Vektor2D target) {
			Vektor2D help;
			help = LineareAlgebra.sub(target, dreieck.pos);
			double dist = help.length();
			double speed = dreieck.maxVelocity * (dist / 1000);
			speed = Math.min(speed, dreieck.maxVelocity);
			help.mult(speed / dist);
			System.out.println(help);
			return help;
		}
	 public Vektor2D separation(float separationDist) {
			Vektor2D help;
			Vektor2D steeringForce = new Vektor2D(0, 0);
			for (int i = 0; i < om.getDreieckSize(); i++) {
				if (dreieck.id == i)
					continue;
				BasisObjekt bObj = om.getDreieck(i);
				if (bObj instanceof BewegendesObjekt) {
					BewegendesObjekt bObjF = (BewegendesObjekt) bObj;
					if (LineareAlgebra.euklDistance(dreieck.pos, bObjF.pos) < separationDist) {
						help = LineareAlgebra.sub(dreieck.pos, bObjF.pos);
						double length = help.length();
						help.normalize();
						help.div(length);
						steeringForce.add(help);
					}
				}
			}
			return steeringForce;
		}

		public Vektor2D alignment(float separationDist) {
			Vektor2D steeringForce = new Vektor2D(0, 0);
			int count = 0;
			for (int i = 0; i < om.getDreieckSize(); i++) {
				if (dreieck.id == i)
					continue;
				BasisObjekt bObj = om.getDreieck(i);
				if (bObj instanceof BewegendesObjekt) {
					BewegendesObjekt bObjF = (BewegendesObjekt) bObj;
					if (LineareAlgebra.euklDistance(dreieck.pos, bObjF.pos) < separationDist) {
						steeringForce.add(bObjF.velocity);
						count++;
					}
				}
			}
			if (count > 0) {
				steeringForce.mult(1. / count);
				steeringForce.sub(dreieck.velocity);
			}
			return steeringForce;
		}

		public Vektor2D cohesion() {
			Vektor2D steeringForce = new Vektor2D(0, 0);
			int count = 0;
			for (int i = 0; i < om.getDreieckSize(); i++) {
				if (dreieck.id == i)
					continue;
				BasisObjekt bObj = om.getDreieck(i);
				if (bObj instanceof BewegendesObjekt) {
					BewegendesObjekt bObjF = (BewegendesObjekt) bObj;
					steeringForce.add(bObjF.pos);
					count++;
				}
			}
			steeringForce.mult(1. / count);
			steeringForce.sub(dreieck.pos);
			return steeringForce;
		}
	 
	@Override
	public void update(){
		boolean leftButtonDown = Mouse.isButtonDown(0);
		if (leftButtonDown) {
			Vektor2D target = new Vektor2D(Mouse.getX(), 640 - Mouse.getY());
			Vektor2D temp = seek(target);
			Vektor2D follow = arrive(target);
			Vektor2D sep = separation(2000);
			Vektor2D ali = alignment(225.5f);
			Vektor2D coh = cohesion();
			Vektor2D force_1 = LineareAlgebra.add(sep, follow);
			Vektor2D force_2 = LineareAlgebra.add(force_1, ali);
			Vektor2D force_3 = LineareAlgebra.add(force_2, coh);
			dreieck.pos.add(force_3);
		}
				
	}

}
