package Controlador;

import Vista.Tabla;
import Vista.VistaAñadir;
import Vista.VistaContac;
import Vista.VistaGrupo;
import Vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Angie Ballesteros
 */
public class ControladorPrincipal implements ActionListener {
    private VistaPrincipal vistaP; 
    private Controlador control;
    private VistaContac vistaContacto;
    private VistaGrupo vistaGrupo;
    private ControladorGrupo controlGrupo;
    private VistaAñadir vistaAñadir;
    private ControladorAñadir controlAñadir;

    public ControladorPrincipal(VistaPrincipal vistaP) {
        this.vistaP = vistaP;
        this.vistaP.contacto.addActionListener(this);
        this.vistaP.salir.addActionListener(this);
        this.vistaP.grupo.addActionListener(this);
        this.vistaP.añadir.addActionListener(this);
        this.vistaP.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand()=="Contacto"){
            vistaContacto =new VistaContac();
            control = new Controlador(vistaContacto);
           
        }
        
        if (e.getActionCommand()=="Grupo") {
           vistaGrupo = new VistaGrupo();
           controlGrupo = new ControladorGrupo(vistaGrupo);
        }
        
        if (e.getActionCommand()=="Añadir Contacto"){
           vistaAñadir = new VistaAñadir();
           controlAñadir = new ControladorAñadir(vistaAñadir);
        }        
        
    }
}
