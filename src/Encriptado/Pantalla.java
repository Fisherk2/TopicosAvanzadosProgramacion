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

    private JLabel lTitulo, lEntrada, lEncriptado;
    private JButton bSaveTxt, bSaveVge, bEncrypt, bDescifrar, bLeerTXT, bLeerVGE;
    private JTextArea aEntrada, aEncrypt;
    private JPanel panel;
    private final Fichero ARCHIVO_TXT, ARCHIVO_VGE;

    public Pantalla() {
        //Ventana
        super("Algoritmo de Cifrado");
        setSize(800, 800);
        setLocationRelativeTo(null); //El "null" sirve para centrar la posicion inicial de la ventana 
        setResizable(false); //Establecemos que la ventana no pueda cambiar de tamaño con el argumento FALSE
        //Archivos
        ARCHIVO_TXT = new Fichero("TextoPlano", ".txt");
        ARCHIVO_VGE = new Fichero("TextoEncryptado", ".vge");
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

        iniciarAreaTxt();
        iniciarAreaVge();

    }

    private void iniciarAreaTxt() {
        //ETIQUETA
        lTitulo = new JLabel("CIFRADO", JLabel.CENTER);
        lTitulo.setFont(new Font("Times new roman", Font.BOLD, 30));
        lTitulo.setForeground(Color.WHITE);
        lTitulo.setBounds(0, 5, 800, 30);
        lEntrada = new JLabel("Entrada:", JLabel.LEFT);
        lEntrada.setFont(new Font("Times new roman", Font.BOLD, 15));
        lEntrada.setForeground(Color.cyan);
        lEntrada.setBounds(10, 50, 780, 15);
        //AREA DE TEXTO
        aEntrada = new JTextArea();
        aEntrada.setFont(new Font("Arial", Font.BOLD, 15));
        aEntrada.setBounds(10, 80, 760, 250);
        aEntrada.setText(ARCHIVO_TXT.leerFichero());
        //DESLIZADORES
        JScrollPane deslizador1 = new JScrollPane(aEntrada, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); //El componente Text Area va estar dentro del deslizador, por lo tanto este se va adaptar a la clase JScrollPane
        deslizador1.setBounds(10, 80, 760, 250); //Posicion y Dimension del deslizador (Los mismos que los del area del componente)
        //BOTON
        bSaveTxt = new JButton("Guardar");
        bSaveTxt.setFont(new Font("Calibri", Font.BOLD, 18));
        bSaveTxt.setBackground(Color.CYAN);
        bSaveTxt.setBounds(10, 350, 130, 30);
        //EVENTO AL PRESIONAR GUARDAR ENTRADA
        bSaveTxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ARCHIVO_TXT.escribirFichero(aEntrada.getText());
                JOptionPane.showMessageDialog(null, "Su entrada ha sido guardada exitosamente en esta direccion:"
                        + "\n" + ARCHIVO_TXT.getPath());
            }
        });
        bEncrypt = new JButton("Encriptar");
        bEncrypt.setFont(new Font("Calibri", Font.BOLD, 18));
        bEncrypt.setBackground(Color.PINK);
        bEncrypt.setBounds(150, 350, 130, 30);
        //EVENTO AL PRESIONAR ENCRYPTAR ENTRADA
        bEncrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aEncrypt.setText(new Cifrado(aEntrada.getText()).getSalidaCifrada());
                JOptionPane.showMessageDialog(null, "Su entrada ha sido encryptada exitosamente");
            }
        });
        bLeerTXT = new JButton("Leer fichero .txt");
        bLeerTXT.setFont(new Font("Calibri", Font.BOLD, 18));
        bLeerTXT.setBackground(Color.GREEN);
        bLeerTXT.setBounds(580, 350, 190, 30);
        //EVENTO AL PRESIONAR LEER ENTRADA
        bLeerTXT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aEntrada.setText(ARCHIVO_TXT.leerFichero());
                JOptionPane.showMessageDialog(null, "El fichero de texto puede leerse");
            }
        });

        panel.add(lTitulo);
        panel.add(lEntrada);
        panel.add(deslizador1);
        panel.add(bSaveTxt);
        panel.add(bEncrypt);
        panel.add(bLeerTXT);
    }

    private void iniciarAreaVge() {
        //ETIQUETA
        lEncriptado = new JLabel("Encriptado: ", JLabel.LEFT);
        lEncriptado.setFont(new Font("Times new roman", Font.BOLD, 15));
        lEncriptado.setForeground(Color.RED);
        lEncriptado.setBounds(10, 400, 780, 15);
        //AREA DE TEXTO
        aEncrypt = new JTextArea();
        aEncrypt.setFont(new Font("Tahoma", Font.BOLD, 15));
        aEncrypt.setEditable(true);
        aEncrypt.setBounds(10, 420, 760, 250);
        aEncrypt.setText(ARCHIVO_VGE.leerFichero());
        //DESLIZADORES
        JScrollPane deslizador2 = new JScrollPane(aEncrypt, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); //El componente Text Area va estar dentro del deslizador, por lo tanto este se va adaptar a la clase JScrollPane
        deslizador2.setBounds(10, 420, 760, 250); //Posicion y Dimension del deslizador (Los mismos que los del area del componente)
        //BOTON
        bSaveVge = new JButton("Guardar");
        bSaveVge.setFont(new Font("Calibri", Font.BOLD, 18));
        bSaveVge.setBackground(Color.CYAN);
        bSaveVge.setBounds(10, 690, 130, 30);
        //EVENTO AL PRESIONAR GUARDAR ENCRIPTADO
        bSaveVge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ARCHIVO_VGE.escribirFichero(aEncrypt.getText());
                JOptionPane.showMessageDialog(null, "Su encriptado ha sido guardada exitosamente en esta direccion:"
                        + "\n" + ARCHIVO_VGE.getPath());
            }

        });
        bDescifrar = new JButton("Descifrar");
        bDescifrar.setFont(new Font("Calibri", Font.BOLD, 18));
        bDescifrar.setForeground(Color.WHITE);
        bDescifrar.setBackground(Color.BLACK);
        bDescifrar.setBounds(150, 690, 130, 30);
        //EVENTO AL PRESIONAR DESCIFRAR LA ENTRADA ENCRIPTADA
        bDescifrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aEntrada.setText(new Cifrado(aEncrypt.getText()).getSalidaDescifrada());
                JOptionPane.showMessageDialog(null, "Su encryptado ha sido decifrado exitosamente");
            }
        });
        bLeerVGE = new JButton("Leer fichero .vge");
        bLeerVGE.setFont(new Font("Calibri", Font.BOLD, 18));
        bLeerVGE.setBackground(Color.GREEN);
        bLeerVGE.setBounds(580, 690, 190, 30);
        //EVENTO AL PRESIONAR LEER VGE
        bLeerVGE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aEncrypt.setText(ARCHIVO_VGE.leerFichero());
                JOptionPane.showMessageDialog(null, "El fichero VGE puede leerse");
            }
        });

        panel.add(lEncriptado);
        panel.add(deslizador2);
        panel.add(bSaveVge);
        panel.add(bDescifrar);
        panel.add(bLeerVGE);

    }

}
