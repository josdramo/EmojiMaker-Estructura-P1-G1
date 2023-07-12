/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparators;

import Modelos.Profile;
import Modelos.Usuario;
import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author CltControl
 */
public class ProfileByNameComparator implements Comparator<Profile>, Serializable {

    @Override
    public int compare(Profile p1, Profile p2) {
        Usuario o1 = p1.getUsuario();
        Usuario o2 = p2.getUsuario();
        
        return o1.getUsername().equalsIgnoreCase(o2.getUsername()) && o1.getPassword().equals(o2.getPassword()) ? 0 : 1;

    }
    
}
