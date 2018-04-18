/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaconexion;

import Controlador.ControladorPrincipal;
import Vista.VistaPrincipal;

/**
 *
 * @author Angie Ballesteros
 */
public class TareaConexion {

    public static void main(String[] args) {
       VistaPrincipal vistaP =new VistaPrincipal();
       ControladorPrincipal controladorP =new ControladorPrincipal(vistaP);
    }
    
}
