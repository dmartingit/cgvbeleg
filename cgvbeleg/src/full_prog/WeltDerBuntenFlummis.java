package full_prog;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.lwjgl.opengl.Display;

import frame.BasisFenster;
import math.Vektor2D;

public class WeltDerBuntenFlummis extends BasisFenster {
   private ObjektManager dreiecke;
   
   public WeltDerBuntenFlummis() {
      super("CG_Beleg", 640, 480);
      dreiecke = ObjektManager.getExemplar();
      erzeugeFlummies(100);
      }
   
   private void erzeugeFlummies(int anz) {
      Random rand = ThreadLocalRandom.current();
      for (int i=0; i<anz; i++) {
        Dreiecke dreieck = new Dreiecke(new Vektor2D(rand.nextInt(640), 
               rand.nextInt(480)),new Vektor2D(0.1,0.1), 0.1f, 0.1f, 0.1f);
        dreieck.setVerhalten(new Schwarmverhalten(dreieck, dreiecke) );
        dreiecke.registriereDreiecke( dreieck );
      } 
   }

   @Override
   public void renderLoop() {
      while (!Display.isCloseRequested()) {
         glClearColor(0.6f, 0.8f, 0.1f, 1);
         glClear(GL_COLOR_BUFFER_BIT);
         
         // ist ja 2d
         glMatrixMode (GL_PROJECTION);
         glLoadIdentity ();
         glOrtho (0, 640, 480, 0, 0, 1);
         glMatrixMode (GL_MODELVIEW);
         glDisable(GL_DEPTH_TEST);
        
         for (int i=1; i<=dreiecke.getDreieckSize(); i++) {
            Dreiecke aktFlummi = dreiecke.getDreieck(i);
            aktFlummi.render();
            aktFlummi.update();
         }

         Display.update();
      }
   }
   
   public static void main(String[] args) {
      new WeltDerBuntenFlummis().start();
   }
}

