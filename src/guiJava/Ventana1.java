/*
 * NOMBRE: Fisher
 * FECHA: 24/08/22
 * PROYECTO: TOPICOS AVANZADOS DE PROGRAMACION
 */
package guiJava;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Clase que muestra una ventana sencilla con titulo, layout y etiquetas varias.
 *
 * @author Fisherk2
 */
public class Ventana1 extends JFrame {

    //TODOS LOS COMPONENTES QUE NECESITAMOS EN ESTA VENTANA
    private JPanel panel;
    private JLabel etiqueta1, etiqueta2, etiqueta3;

    public Ventana1() {
        super("Ventana sencilla 1"); //Establecemos el nombre de la ventana desde el super
        setSize(400, 400);
        setLocationRelativeTo(null); //El "null" sirve para centrar la posicion inicial de la ventana 
        setResizable(true);

        //Iniciamos panel, componentes y layouts
        panel = new JPanel();
        panel.setBackground(Color.pink);
        panel.setLayout(new FlowLayout());//Agregamos el diseño del panel (LAYOUTS)
        this.add(panel); //Agregamos el panel a la ventana

        etiquetas();

        setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando se cierre la ventana, esta terminara la ejecucion del programa  

    }
    
    /**
     * Metodo que inicia los componentes de las etiquetas.
     */
    private void etiquetas() {
        //ETIQUETA CON TEXTO
        etiqueta1 = new JLabel("HELLO THERE");
        etiqueta1.setForeground(Color.blue);
        etiqueta1.setHorizontalAlignment(SwingConstants.CENTER); //Alineamos el texto
        etiqueta1.setFont(new Font("complex", 1, 10)); //Establecemos la fuente del texto (Tipo de texto, forma de texto, tamaño de texto)
        etiqueta1.setToolTipText("Esta es una etiqueta simple");

        //ETIQUETAS DE IMAGEN
        etiqueta2 = new JLabel(new ImageIcon("grievous2.jpg"));
        etiqueta2.setHorizontalAlignment(SwingConstants.LEFT); //Alineamos el texto
        etiqueta2.setToolTipText("Esta es una etiqueta con imagen");

        //ETIQUETA CON TEXTO E IMAGEN
        etiqueta3 = new JLabel("GENERAL KENOBI!");
        etiqueta3.setForeground(Color.BLACK);
        etiqueta3.setHorizontalAlignment(SwingConstants.RIGHT); //Alineamos el texto
        etiqueta3.setIcon(new ImageIcon("grievous.jpg"));
        etiqueta3.setToolTipText("Esta es una etiqueta con imagen y texto");

        //Agregamos los componentes al panel
        panel.add(etiqueta1);
        panel.add(etiqueta2);
        panel.add(etiqueta3);

    }

}

