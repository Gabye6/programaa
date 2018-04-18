package Controlador;

import Modelo.ContactoDAO;
import Vista.Tabla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Angie Ballesteros
 */
public class ControladorTabla implements ActionListener {
    private Tabla vistaT;
    private ContactoDAO modelDAO;

    public ControladorTabla(Tabla vistaT) {
        this.vistaT = vistaT;
        this.modelDAO = modelDAO;
        this.vistaT.Consultar.addActionListener(this);
        this.vistaT.Salir.addActionListener(this);
        this.vistaT.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="Consultar") {
            
        }
        if (e.getActionCommand()=="Salir") {
            
        }
    }
   
        
    }
    
    

