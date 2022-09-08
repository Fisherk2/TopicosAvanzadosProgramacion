/*
 * NOMBRE: Fisher
 * FECHA: 25/08/22
 * PROYECTO: Topicos avanzados de programacion
 */
package guiJava;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Clase que genera una ventana con 4 cajas de texto y estos generan un evento
 * con el teclado.
 *
 * @author Fisherk2
 */
public class Ventana2 extends JFrame {

    private JTextField caja1, caja2, caja3;
    private JPasswordField cajaP;
    private JPanel panel;

    public Ventana2() {
        super("Ventana sencilla 2"); //Establecemos el nombre de la ventana desde el super
        setSize(350, 150);
        setLocationRelativeTo(null); //El "null" sirve para centrar la posicion inicial de la ventana 
        setResizable(false);

        //Iniciamos panel, componentes y layouts
        panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setLayout(new FlowLayout());//Agregamos el diseño del panel (LAYOUTS)
        this.add(panel); //Agregamos el panel a la ventana
        iniciarComponentes();
        aplicarEventos();
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando se cierre la ventana, esta terminara la ejecucion del programa  
    }

    /**
     * Metodo que implementa los action listener de la clase CampoEvento.
     */
    private void aplicarEventos() {
        CajaEvento evento = new CajaEvento();
        caja1.addActionListener(evento);
        caja2.addActionListener(evento);
        caja3.addActionListener(evento);
        cajaP.addActionListener(evento);

    }

    /**
     * Metodo que coloca las cajas de texto en la ventana principal.
     */
    private void iniciarComponentes() {
        caja1 = new JTextField(10);
        caja2 = new JTextField("Texto Editable");
        caja3 = new JTextField("Texto no editable");
        caja3.setEditable(false);

        cajaP = new JPasswordField("Texto Oculto");

        caja1.setToolTipText("caja1");
        caja2.setToolTipText("caja2");
        caja3.setToolTipText("caja3");
        cajaP.setToolTipText("cajaP");

        panel.add(caja1);
        panel.add(caja2);
        panel.add(caja3);
        panel.add(cajaP);

    }

    /**
     * Clase anidada a ventana que se ocupa para los eventos de los campos de
     * texto.
     */
    private class CajaEvento implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String mensaje = "";
            if (e.getSource() == caja1) {
                mensaje = String.format("caja1: %s", e.getActionCommand()); //Cadena con formato
            } else if (e.getSource() == caja2) {
                mensaje = String.format("caja2: %s", e.getActionCommand()); //Cadena con formato
            } else if (e.getSource() == caja3) {
                mensaje = String.format("caja3: %s", e.getActionCommand()); //Cadena con formato
            } else if (e.getSource() == cajaP) {
                mensaje = String.format("cajaP: %s", e.getActionCommand()); //Cadena con formato
            }
            JOptionPane.showMessageDialog(null, mensaje);

        }

    }//CLASE EVENTOS

}//CLASE VENTANA
