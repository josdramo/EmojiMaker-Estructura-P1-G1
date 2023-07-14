/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparators;

import Modelos.Usuario;
import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author infrative
 */
public class UserByNameComparator implements Comparator<Usuario>, Serializable {
    @Override
    public int compare(Usuario o1, Usuario o2) {
        return o1.getUsername().equalsIgnoreCase(o2.getUsername()) ? 0 : 1;
    }
}
