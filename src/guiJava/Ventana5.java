/*
 * NOMBRE: Fisher
 * FECHA: 1/09/22
 * PROYECTO: TOPICOS AVANZADOS DE PROGRAMACIONS
 */
package guiJava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 * Clase que muestra una ventana con BorderLayout y botones
 * @author Fisherk2
 */
public class Ventana5 extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton[] botones;
    private String[] nombreB = {"Hide North", "Hide West", "Hide East", "Hide South", "Hide Center"};
    private BorderLayout layout;

    public Ventana5() {
        super("Ventana sencilla 5"); //Establecemos el nombre de la ventana desde el super
        setSize(400, 300);
        setLocationRelativeTo(null); //El "null" sirve para centrar la posicion inicial de la ventana 
        setResizable(false);

        //Iniciamos panel, componentes y layouts
        layout = new BorderLayout(5, 5);
        panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.setLayout(layout);//Agregamos el diseño del panel (LAYOUTS)
        this.add(panel); //Agregamos el panel a la ventana
        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando se cierre la ventana, esta terminara la ejecucion del programa  

    }

    private void iniciarComponentes() {
        //Declaracion y agregado de botones
        botones = new JButton[nombreB.length];
        for (int i = 0; i < nombreB.length; i++) {
            botones[i] = new JButton(nombreB[i]);
            botones[i].addActionListener(this);
        }
        //Acomodo de componentes en el layout
        panel.add(botones[0], BorderLayout.NORTH); //NORTH
        panel.add(botones[1], BorderLayout.WEST); //WEST
        panel.add(botones[2], BorderLayout.EAST); //EAST
        panel.add(botones[3], BorderLayout.SOUTH); //SOUTH
        panel.add(botones[4], BorderLayout.CENTER); //CENTER

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : botones) {
            if (e.getSource() == button) {
                button.setVisible(false); //Oculta el boton
            } else {
                button.setVisible(true); //Se muestran los demas botones
            }

        }
        layout.layoutContainer(getContentPane()); //Actualiza la ventana
    }
}
