/*
 * NOMBRE: Fisher
 * FECHA: 1/09/22
 * PROYECTO: TOPICOS AVANZADOS DE PROGRAMACION
 */
package guiJava;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 * Clase que muestra botones con el GridLayout
 * @author Fisherk2
 */
public class Ventana7 extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton[] botones;
    private String[] nombres = {"uno", "dos", "tres", "cuatro", "cinco", "seis"};
    private boolean cambio = true; //Cambio entre dos layouts
    private GridLayout malla1, malla2;

    public Ventana7() {
        super("Ventana sencilla 7"); //Establecemos el nombre de la ventana desde el super
        setSize(600, 200);
        setLocationRelativeTo(null); //El "null" sirve para centrar la posicion inicial de la ventana 
        setResizable(true);

        //Iniciamos panel, componentes y layouts
        malla1 = new GridLayout(2, 3, 5, 5); //Malla de 2x3; separacion de 5x5
        malla2 = new GridLayout(3, 2); //Malla de 3x2
        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(malla1);//Agregamos el diseño del panel (LAYOUTS)
        this.add(panel); //Agregamos el panel a la ventana
        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando se cierre la ventana, esta terminara la ejecucion del programa  

    }

    private void iniciarComponentes() {
        //Declaracion y agregado de botones
        botones = new JButton[nombres.length];
        for (int i = 0; i < nombres.length; i++) {
            botones[i] = new JButton(nombres[i]);
            botones[i].addActionListener(this);
            panel.add(botones[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (cambio) {
            panel.setLayout(malla2);
        } else {
            panel.setLayout(malla1);
        }
        cambio = !cambio; //Se invierte el boolean
        panel.validate(); //Recarga el layout nuevo
    }
}
