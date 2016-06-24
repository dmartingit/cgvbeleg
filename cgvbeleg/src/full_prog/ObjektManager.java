package full_prog;

import java.util.HashMap;

public class ObjektManager {
   private HashMap<Integer, Dreiecke> flummies;

   // ****************************************************
   // ObjektManager als Singleton realisieren
   private static ObjektManager exemplar = new ObjektManager();

   private ObjektManager() {
      flummies = new HashMap<Integer, Dreiecke>();
   }

   public static ObjektManager getExemplar() {
      return exemplar;
   }

   public Object clone() throws CloneNotSupportedException {
      throw new CloneNotSupportedException("Clonen ist nicht erlaubt");
   }
   // ***************************************************
   
   public void registriereFlummi(Dreiecke obj) {
      flummies.put(new Integer(obj.id), obj);
   }

   public void entferneFlummi(Dreiecke obj) {
      flummies.remove(obj);
   }
   
   public Dreiecke getFlummi(int objID) {
      return flummies.get(new Integer(objID));
   }
   
   public HashMap<Integer, Dreiecke> getFlummiMap() {
      return flummies;
   }
   
   public int getFlummiSize() {
      return flummies.size();
   }
}
