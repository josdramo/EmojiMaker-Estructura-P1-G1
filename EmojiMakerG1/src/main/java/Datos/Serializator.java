/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author infrative
 */
public class Serializator {
    public static <T extends Serializable> void serialize(T object, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream("data/" + filename);
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(object);
            }
        } catch (IOException e) {
            System.out.println("[ERROR] - Serialization");
        }
    }
    
    public static <T extends Serializable> T deserialize(String filename) {
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream("data/" + filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            T object = (T) in.readObject();
            in.close();
            return object;
        } catch (Exception e) {
            if (fileIn != null) {
                try {
                    fileIn.close();
                } catch (Exception e1) {
                    // do nothing
                }
            }
            return null;
        }
    }
}
