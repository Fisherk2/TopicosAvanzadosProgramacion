/*
 * NOMBRE: Fisher
 * FECHA: 6/09/22
 * PROYECTO: TOPICOS AVANZADOS DE PROGRAMACION
 */
package Encriptado;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * Clase que generara una ventana grafica donde estaran una entrada y dos areas
 * de texto.
 *
 * @author Fisherk2
 */
public class Pantalla extends JFrame {

    private JLabel lTitulo, lTxtPath, lVgePath, lEntrada, lEncriptado;
    private JButton bTxt, bVge;
    private JTextArea aEntrada, aEncrypt;
    private JPanel panel;
    private String contenidoTXT, contenidoVGE;
    private FileTXT txt;
    private FileVGE vge;

    public Pantalla() {
        //Ventana
        super("Algoritmo de Cifrado");
        setSize(800, 1000);
        setLocationRelativeTo(null); //El "null" sirve para centrar la posicion inicial de la ventana 
        setResizable(false); //Establecemos que la ventana no pueda cambiar de tamaño con el argumento FALSE

        //COMPONENTES (CAPAS o LAYOUTS)
        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);//Cuando se cierre la ventana, esta terminara la ejecucion del programa  

    }

    private void iniciarComponentes() {
        //Panel
        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);//Desactivamos el diseño del panel (LAYOUTS)
        this.add(panel); //Agregamos el panel a la ventana
        //Ficheros
        txt = new FileTXT();
        contenidoTXT = txt.leerFichero();
        vge = new FileVGE();
        contenidoVGE = vge.leerFichero();

        iniciarEtiquetas();
        iniciarAreasText();
        iniciarBotones();
        iniciarEventos();

    }

    private void iniciarEtiquetas() {
        lTitulo = new JLabel("CIFRADO", JLabel.CENTER);
        lTitulo.setFont(new Font("Times new roman", Font.BOLD, 30));
        lTitulo.setForeground(Color.WHITE);
        lTitulo.setBounds(0, 5, 800, 30);

        lEntrada = new JLabel("Entrada:", JLabel.LEFT);
        lEntrada.setFont(new Font("Times new roman", Font.BOLD, 15));
        lEntrada.setForeground(Color.cyan);
        lEntrada.setBounds(10, 50, 780, 15);

        lTxtPath = new JLabel("Texto path: " + txt.getPath(), JLabel.RIGHT);
        lTxtPath.setFont(new Font("Monserrat", Font.PLAIN, 10));
        lTxtPath.setForeground(Color.BLUE);
        lTxtPath.setBounds(140, 450, 600, 10);

        lEncriptado = new JLabel("Encriptado: ", JLabel.LEFT);
        lEncriptado.setFont(new Font("Times new roman", Font.BOLD, 15));
        lEncriptado.setForeground(Color.RED);
        lEncriptado.setBounds(10, 500, 780, 15);

        lVgePath = new JLabel("Encrypt path: " + vge.getPath(), JLabel.RIGHT);
        lVgePath.setFont(new Font("Monserrat", Font.PLAIN, 10));
        lVgePath.setForeground(Color.RED);
        lVgePath.setBounds(140, 900, 600, 10);

        panel.add(lTitulo);
        panel.add(lEntrada);
        panel.add(lEncriptado);
        panel.add(lTxtPath);
        panel.add(lVgePath);

    }

    private void iniciarAreasText() {
        aEntrada = new JTextArea();
        aEntrada.setFont(new Font("Arial", Font.BOLD, 15));
        aEntrada.setBounds(10, 80, 760, 350);
        aEntrada.setText(contenidoTXT);

        aEncrypt = new JTextArea();
        aEncrypt.setFont(new Font("Tahoma", Font.BOLD, 15));
        aEncrypt.setEditable(false);
        aEncrypt.setBounds(10, 520, 760, 350);
        aEncrypt.setText(contenidoVGE);

        //DESLIZADORES
        JScrollPane deslizador1 = new JScrollPane(aEntrada, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); //El componente Text Area va estar dentro del deslizador, por lo tanto este se va adaptar a la clase JScrollPane
        deslizador1.setBounds(10, 80, 760, 350); //Posicion y Dimension del deslizador (Los mismos que los del area del componente)
        JScrollPane deslizador2 = new JScrollPane(aEncrypt, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); //El componente Text Area va estar dentro del deslizador, por lo tanto este se va adaptar a la clase JScrollPane
        deslizador2.setBounds(10, 520, 760, 350); //Posicion y Dimension del deslizador (Los mismos que los del area del componente)

        panel.add(deslizador1);
        panel.add(deslizador2);

    }

    private void iniciarBotones() {
        bTxt = new JButton("Guardar");
        bTxt.setFont(new Font("Calibri", Font.BOLD, 18));
        bTxt.setBackground(Color.CYAN);

        bVge = new JButton("Guardar");
        bVge.setFont(new Font("Calibri", Font.BOLD, 18));
        bVge.setBackground(Color.RED);

        bTxt.setBounds(10, 450, 130, 30);
        bVge.setBounds(10, 900, 130, 30);

        panel.add(bTxt);
        panel.add(bVge);

    }

    private void iniciarEventos() {
        //SE EFECTUA UN EVENTO AL PRESIONAR GUARDAR ENTRADA
        bTxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt.escribirFichero(aEntrada.getText());
                contenidoTXT = txt.leerFichero();
                aEncrypt.setText(new Cifrado(contenidoTXT).getSalida());
                lTxtPath.setText("Texto path: " + txt.getPath());
                JOptionPane.showMessageDialog(null, "Su entrada ha sido guardada exitosamente");
            }
        });

        //SE EFECTUA UN EVENTO AL PRESIONAR GUARDAR ENCRIPTADO
        bVge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Mandamos lo que tengamos de contenido en el TXT y lo encriptamos, este nos lo devolvera cifrado y lo guardaremos en nuestro fichero VGE
                vge.escribirFichero(new Cifrado(aEntrada.getText()).getSalida());
                contenidoVGE = vge.leerFichero();
                aEncrypt.setText(contenidoVGE);
                lVgePath.setText("Encrypt path: " + vge.getPath());
                JOptionPane.showMessageDialog(null, "Su encriptado ha sido guardada exitosamente");
            }

        });

    }

}
