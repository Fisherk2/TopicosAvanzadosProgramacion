/*
 * NOMBRE: Fisher
 * FECHA: 1/09/22
 * PROYECTO: TOPICOS AVANZADOS DE PROGRAMACION
 */
package guiJava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *Clase que muestra una ventana con 3 botones con FlowLayout
 * @author Fisherk2
 */
public class Ventana6 extends JFrame {

    private JPanel panel;
    private FlowLayout layout;
    private JButton leftB, centerB, rightB;

    public Ventana6() {
        super("Ventana sencilla 6"); //Establecemos el nombre de la ventana desde el super
        setSize(600, 200);
        setLocationRelativeTo(null); //El "null" sirve para centrar la posicion inicial de la ventana 
        setResizable(true);

        //Iniciamos panel, componentes y layouts
        layout = new FlowLayout();
        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(layout);//Agregamos el diseño del panel (LAYOUTS)
        this.add(panel); //Agregamos el panel a la ventana
        iniciarComponentes();
        iniciarEventos();

        setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando se cierre la ventana, esta terminara la ejecucion del programa  

    }

    private void iniciarComponentes() {
        leftB = new JButton("Left");
        rightB = new JButton("Right");
        centerB = new JButton("Center");

        panel.add(leftB);
        panel.add(centerB);
        panel.add(rightB);

    }

    private void iniciarEventos() {
        leftB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.setAlignment(FlowLayout.LEFT);

                layout.layoutContainer(panel); //Actualizamos el panel
            }
        });

        rightB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.setAlignment(FlowLayout.RIGHT);

                layout.layoutContainer(panel); //Actualizamos el panel
            }
        });
        centerB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.setAlignment(FlowLayout.CENTER);

                layout.layoutContainer(panel); //Actualizamos el panel
            }
        });
    }

}
