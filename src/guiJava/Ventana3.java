/*
 * NOMBRE: Fisher
 * FECHA: 30/08/22
 * PROYECTO: TOPICOS AVANZADOS DE PROGRAMACION
 */
package guiJava;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Clase que agrega componentes checkbox.
 *
 * @author Fisherk2
 */
public class Ventana3 extends JFrame {

    private JTextField cajaText;
    private JCheckBox boldCasilla, italicCasilla;
    private JPanel panel;

    public Ventana3() {
        super("Ventana sencilla 3"); //Establecemos el nombre de la ventana desde el super
        setSize(300, 150);
        setLocationRelativeTo(null); //El "null" sirve para centrar la posicion inicial de la ventana 
        setResizable(false);

        //Iniciamos panel, componentes y layouts
        panel = new JPanel();
        panel.setBackground(Color.GREEN);
        panel.setLayout(new FlowLayout());//Agregamos el diseño del panel (LAYOUTS)
        this.add(panel); //Agregamos el panel a la ventana
        iniciarComponentes();
        aplicarEventos();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando se cierre la ventana, esta terminara la ejecucion del programa  
    }

    private void iniciarComponentes() {
        cajaText = new JTextField("Texto con fuente", 20);
        cajaText.setEditable(true);
        cajaText.setFont(new Font("arial", Font.PLAIN, 18)); //Aplicacion de fuente por default

        boldCasilla = new JCheckBox("NEGRITAS");
        italicCasilla = new JCheckBox("CURSIVA");
        boldCasilla.setFont(new Font("serif", Font.BOLD, 12));
        italicCasilla.setFont(new Font("serif", Font.ITALIC, 12));

        //Agregar componentes al panel
        panel.add(cajaText);
        panel.add(boldCasilla);
        panel.add(italicCasilla);
    }

    private void aplicarEventos() {
        CheckEvento event = new CheckEvento();
        boldCasilla.addItemListener(event);
        italicCasilla.addItemListener(event);
    }

    /**
     * Clase que maneja los eventos de cambios de estado como lo son las
     * casillas CHECKBOX.
     */
    private class CheckEvento implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            Font fuente = null;

            if (italicCasilla.isSelected() && boldCasilla.isSelected()) { //CURSIVA Y NEGRITAS
                fuente = new Font("serif", Font.BOLD + Font.ITALIC, 18);
            } else if (boldCasilla.isSelected()) {                        //NEGRITAS
                fuente = new Font("serif", Font.BOLD, 18);
            } else if (italicCasilla.isSelected()) {                      //CURSIVA
                fuente = new Font("serif", Font.ITALIC, 18);
            } else {                                                      //POR DEFAULT
                fuente = new Font("arial", Font.PLAIN, 18);
            }
            cajaText.setFont(fuente); //Aplicacion de fuente
        }

    }//CLASE EVENTOS

}
