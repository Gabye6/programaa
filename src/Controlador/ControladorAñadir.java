package Controlador;

import Modelo.ContactoDAO;
import Vista.VistaAñadir;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Angie Ballesteros
 */
public class ControladorAñadir implements ActionListener {
    
    private VistaAñadir vistaAñadir;
    private ContactoDAO modelDAO;

    public ControladorAñadir(VistaAñadir vistaAñadir) {
        this.vistaAñadir= vistaAñadir;
        this.modelDAO=modelDAO;
        this.vistaAñadir.setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) {
       
    }
    
    
}
