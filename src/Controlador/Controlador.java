package Controlador;

import Modelo.Contacto;
import Modelo.ContactoDAO;
import Vista.VistaContac;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Angie Ballesteros
 */
public class Controlador implements ActionListener {

    private VistaContac vistaA;
    private ContactoDAO modelDAO;
    Contacto contac;

    public Controlador(VistaContac vistaA) {
        this.vistaA = vistaA;
        this.modelDAO = new ContactoDAO();
        this.vistaA.eliminar.addActionListener(this);
        this.vistaA.insertar.addActionListener(this);
        this.vistaA.consultar.addActionListener(this);
        this.vistaA.modifiar.addActionListener(this);
        this.vistaA.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Insertar") {
            Contacto contacI = new Contacto();
            contacI.setId(Integer.valueOf(vistaA.Id.getText()));
            contacI.setNombre(vistaA.nombre.getText());
            contacI.setTelefono(vistaA.telefono.getText());
            if (modelDAO.create(contacI) == 0) {
                JOptionPane.showInputDialog("No se creo el contacto");
            } else {
                JOptionPane.showInputDialog("Se creo el contacto");
            }
        }
        if (e.getActionCommand() == "Consultar") {
            contac = new Contacto();
            contac = this.modelDAO.read(Integer.parseInt(vistaA.Id.getText()));
            if (contac != null) {
                vistaA.nombre.setText(contac.getNombre());
                vistaA.telefono.setText(contac.getTelefono());
            } else {
                JOptionPane.showInputDialog("El Contacto no Existe");
            }
        }
        if (e.getActionCommand() == "Modificar") {
            contac = new Contacto();
            contac = this.modelDAO.read(Integer.parseInt(vistaA.Id.getText()));

            contac.setId(Integer.valueOf(this.vistaA.Id.getText()));
            modelDAO.update(contac);
            //  if (modelDAO.update(contac) == 0) {
           // JOptionPane.showInputDialog("No se modifico el contacto");
            //  } else {
            //JOptionPane.showInputDialog("Contacto modificado");
            //  }
        }

        if (e.getActionCommand() == "Eliminar") {
            if (modelDAO.delete(Integer.valueOf(this.vistaA.Id.getText())) == 0) {
                JOptionPane.showInputDialog("Problemas al eliminar");
            } else {
                JOptionPane.showInputDialog("Eliminado");
            }

        }

    }
}
