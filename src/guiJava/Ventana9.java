/*
 * NOMBRE: Fisher
 * FECHA: 8/09/22
 * PROYECTO: TOPICOS AVANZADOS DE PROGRAMACION
 */
package guiJava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Ventana que muestra el componente Slider
 *
 * @author Fisherk2
 */
public class Ventana9 extends JFrame {

//    private JPanel panel;
    private JSlider deslizador;
    private OvalPanel panel;

    public Ventana9() {
        super("Ventana sencilla 9"); //Establecemos el nombre de la ventana desde el super
        setSize(500, 500);
        setLocationRelativeTo(null); //El "null" sirve para centrar la posicion inicial de la ventana 
        setResizable(true);

//        panel = new JPanel();
        panel = new OvalPanel();
        panel.setBackground(Color.YELLOW);
        this.add(panel); //Agregamos el panel a la ventana
        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando se cierre la ventana, esta terminara la ejecucion del programa  
    }

    private void iniciarComponentes() {

        deslizador = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10);
        deslizador.setMajorTickSpacing(10);
        deslizador.setPaintTicks(true);

        deslizador.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                panel.setDiameter(deslizador.getValue());

            }
        });

        add(deslizador, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);

    }

}

class OvalPanel extends JPanel {

    private int diameter = 10;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(10, 10, diameter, diameter);
    }

    public void setDiameter(int diameter) {
        this.diameter = (diameter >= 0 ? diameter : 10);
        repaint();

    }
    
    @Override
    public Dimension getMinimumSize(){
        return getPreferredSize();
    }

}
