/*
 * NOMBRE: Fisher
 * FECHA: 8/09/22
 * PROYECTO: TOPICOS AVANZADOS DE PROGRAMACION
 */

package guiJava;

import java.awt.Color;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 * Clase que muestra una ventana con MENUS. (CLASSROM EN EL ZIP)
 * @author Fisherk2
 */
public class Ventana10 extends JFrame {

    private JPanel panel;
    private Color[] colorValues = {Color.BLACK,Color.BLUE,Color.RED,Color.GREEN};
    
    
     public Ventana10() {
        super("Ventana sencilla 10"); //Establecemos el nombre de la ventana desde el super
        setSize(600, 300);
        setLocationRelativeTo(null); //El "null" sirve para centrar la posicion inicial de la ventana 
        setResizable(true);

        panel = new JPanel();
        panel.setBackground(Color.PINK);
        this.add(panel); //Agregamos el panel a la ventana
        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando se cierre la ventana, esta terminara la ejecucion del programa  
    }

    private void iniciarComponentes() {
        
        
    }
}
