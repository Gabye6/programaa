package Controlador;

import Modelo.GrupoDAO;
import Vista.VistaGrupo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Grupo;
import javax.swing.JOptionPane;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 *
 * @author Angie Ballesteros
 */
public class ControladorGrupo implements ActionListener {

    private VistaGrupo vistaG;
    private GrupoDAO modelDAOG;


    public ControladorGrupo(VistaGrupo vistaG) {
        this.vistaG = vistaG;
        this.vistaG.consultarG.addActionListener(this);
        this.vistaG.crearG.addActionListener(this);
        this.vistaG.eliminarG.addActionListener(this);
        this.vistaG.modificarG.addActionListener(this);
        this.modelDAOG = modelDAOG;
        this.vistaG.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Crear") {
            Grupo grupoI = new Grupo();
            modelDAOG = new GrupoDAO();
            grupoI.setid(Integer.valueOf(vistaG.textIdG.getText()));
            grupoI.setNombre(vistaG.textNombre.getText());
            if (modelDAOG.create(grupoI) == 0) {
                JOptionPane.showMessageDialog(null,"No se creo el grupo");
            } else {
                JOptionPane.showInputDialog("Se creo el grupo");

            }
            if (e.getActionCommand() == "Consultar") {
                Grupo grupo = new Grupo();
                grupo = this.modelDAOG.read(Integer.parseInt(vistaG.textIdG.getText()));
                if (grupo != null) {
                    vistaG.textNombre.setText(grupo.getNombre());
                } else {
                    JOptionPane.showInputDialog("El grupo no Existe");
                }
            }
            if (e.getActionCommand() == "Modificar") {
                Grupo grupo = new Grupo();
                grupo.setid(Integer.valueOf(this.vistaG.textIdG.getText()));
                if (modelDAOG.update(grupo) == 0) {
                    JOptionPane.showInputDialog("No se modifico el grupo");
                } else {
                    JOptionPane.showInputDialog("Grupo modificado");
                }
            }

            if (e.getActionCommand() == "Eliminar") {
                if (modelDAOG.delete(Integer.valueOf(this.vistaG.textIdG.getText())) == 0) {
                    JOptionPane.showInputDialog("Problemas al eliminar");
                } else {
                    JOptionPane.showInputDialog("Eliminado");
                }

            }
        }
    }
}
