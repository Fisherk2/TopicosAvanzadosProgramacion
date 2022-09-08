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
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Clase que aplica radiobotones a una ventana.
 *
 * @author Fisherk2
 */
public class Ventana4 extends JFrame {

    private JPanel panel;
    private JRadioButton plainRB, boldRB, italicRB, boldItalicRB, arialRB, tnrRB, tahomaRB;
    private ButtonGroup grupoRB, grupoFont;
    private JTextField cajaText;
    private String fuente;

    public Ventana4() {
        super("Ventana sencilla 4"); //Establecemos el nombre de la ventana desde el super
        setSize(300, 150);
        setLocationRelativeTo(null); //El "null" sirve para centrar la posicion inicial de la ventana 
        setResizable(false);

        //Iniciamos panel, componentes y layouts
        panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setLayout(new FlowLayout());//Agregamos el diseño del panel (LAYOUTS)
        this.add(panel); //Agregamos el panel a la ventana
        iniciarComponentes();
        aplicarEventos();

        setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando se cierre la ventana, esta terminara la ejecucion del programa  
    }

    private void iniciarComponentes() {
        plainRB = new JRadioButton("Plain", true);
        boldRB = new JRadioButton("Bold", false);
        italicRB = new JRadioButton("Italic", false);
        boldItalicRB = new JRadioButton("Bold Italic", false);
        arialRB = new JRadioButton("Arial", true);
        tnrRB = new JRadioButton("Times new Roman", false);
        tahomaRB = new JRadioButton("Tahoma", false);

        grupoRB = new ButtonGroup();
        grupoFont = new ButtonGroup();
        grupoFont.add(arialRB);
        grupoFont.add(tahomaRB);
        grupoFont.add(tnrRB);
        grupoRB.add(boldRB);
        grupoRB.add(plainRB);
        grupoRB.add(italicRB);
        grupoRB.add(boldItalicRB);

        cajaText = new JTextField("Texto con fuente", 18);
        cajaText.setEditable(true);
        cajaText.setFont(new Font("arial", Font.PLAIN, 18)); //Aplicacion de fuente por default

        panel.add(cajaText);
        panel.add(plainRB);
        panel.add(boldRB);
        panel.add(italicRB);
        panel.add(boldItalicRB);
        panel.add(arialRB);
        panel.add(tahomaRB);
        panel.add(tnrRB);

    }

    private void aplicarEventos() {
        EvtTypeFont eventoTexto = new EvtTypeFont();

        plainRB.addItemListener(eventoTexto);
        boldRB.addItemListener(eventoTexto);
        italicRB.addItemListener(eventoTexto);
        boldItalicRB.addItemListener(eventoTexto); //BOLD+ITALLIC
        arialRB.addItemListener(eventoTexto);
        tnrRB.addItemListener(eventoTexto);
        tahomaRB.addItemListener(eventoTexto);
    }

    /**
     * Clase que maneja eventos que cambian estados del tipo de Fuente, en este
     * ejemplo, radio botones.
     */
    private class EvtTypeFont implements ItemListener {

        private int estiloFont;
        private String tipoFont;
        private Font fuentes;

        public EvtTypeFont() {

        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (arialRB.isSelected()) {
                tipoFont = "arial"; //ARIAL
            }
            else if (tnrRB.isSelected()) {
                tipoFont = "Times new Roman"; //TIMES NEW ROMAN
            }
            else if (tahomaRB.isSelected()) {
                tipoFont = "Tahoma"; //TAHOMA
            }
            if (plainRB.isSelected()) {
                estiloFont = Font.PLAIN;
            }
            else if (boldRB.isSelected()) {
                estiloFont = Font.BOLD;
            }
            else if (italicRB.isSelected()) {
                estiloFont = Font.ITALIC;
            }else if (boldItalicRB.isSelected()) {
                estiloFont = 3; //BOLD+ITALLIC
            }
            fuentes = new Font(tipoFont, estiloFont, 18);
            cajaText.setFont(fuentes);
        }

    }//CLASE EVENTOS TIPO FUENTE

}
