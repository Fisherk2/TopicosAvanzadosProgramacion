/*
 * NOMBRE: Fisher
 * FECHA: 6/09/22
 * PROYECTO: TOPICOS AVANZADOS DE PROGRAMACION
 */
package guiJava;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Clase que maneja areas de texto y scrolls.
 *
 * @author Fisherk2
 */
public class Ventana8 extends JFrame {

    private JTextArea textArea1, textArea2;
    private JButton copyJButton;
    private JPanel panel;

    public Ventana8() {
        super("Ventana sencilla 8"); //Establecemos el nombre de la ventana desde el super
        setSize(600, 300);
        setLocationRelativeTo(null); //El "null" sirve para centrar la posicion inicial de la ventana 
        setResizable(true);

        panel = new JPanel();
        panel.setBackground(Color.RED);
        this.add(panel); //Agregamos el panel a la ventana
        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando se cierre la ventana, esta terminara la ejecucion del programa  
    }

    private void iniciarComponentes() {
        Box box = Box.createHorizontalBox(); //Crea un layout de caja

        String demo = "Texto a copiar";
        textArea1 = new JTextArea(demo, 10, 15);
        box.add(new JScrollPane(textArea1)); //Agregamos el area de texto con scroll

        copyJButton = new JButton("COPY>>>>>");
        box.add(copyJButton);
        copyJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea2.setText(textArea1.getSelectedText()); //Solo copia lo seleccionado
            }
        });

        textArea2 = new JTextArea(10, 15);
        textArea2.setEditable(false);
        box.add(new JScrollPane(textArea2)); //Agregamos el area de texto con scroll

        panel.add(box);

    }

}
