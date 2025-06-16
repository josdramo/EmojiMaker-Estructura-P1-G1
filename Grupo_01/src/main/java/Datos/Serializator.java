package Datos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class Serializator {

    // Impide instanciar esta clase de utilidades
    private Serializator() {
        throw new AssertionError("Utility class – do not instantiate");
    }

    /**
     * Serializa cualquier objeto Serializable en un archivo dentro de "data/".
     */
    public static <T extends Serializable> void serialize(T object, String filename) {
        String path = "data/" + filename;
        try (FileOutputStream fileOut = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(object);
        } catch (IOException e) {
            System.out.println("[ERROR] Serializator.serialize: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Deserializa un objeto desde "data/filename". Devuelve null si falla.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T deserialize(String filename) {
        String path = "data/" + filename;
        try (FileInputStream fileIn = new FileInputStream(path);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (T) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("[ERROR] Serializator.deserialize: archivo no encontrado o inválido.");
            // e.printStackTrace(); // opcional
            return null;
        }
    }
}
