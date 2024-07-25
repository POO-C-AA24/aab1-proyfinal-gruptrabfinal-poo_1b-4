package Model;
import Controller.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
public class LecturaCarcel {
    
    public Carcel carcel;
    
    public void leerArchivo(String nombreArchivo){
        try {
            ObjectInputStream flap = new ObjectInputStream(new FileInputStream(nombreArchivo));
            this.carcel = (Carcel)flap.readObject();
            flap.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }   
    public Carcel getCarcel() {
        return carcel;
    }
}
