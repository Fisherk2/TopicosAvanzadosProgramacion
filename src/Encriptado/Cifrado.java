/*
 * NOMBRE: Fisher
 * FECHA: 7/09/22
 * PROYECTO: TOPICOS AVANZADOS DE PROGRAMACION
 */
package Encriptado;

/**
 * Clase que encripta un texto de la siguiente manera: Se divide en dos partes.
 * En primer lugar, cada letra mayúscula o minúscula debe desplazarse tres
 * posiciones hacia la derecha, de acuerdo con la tabla ASCII: la letra ’a’ debe
 * convertirse en la letra ’d’, la letra ’y’ debe convertirse en el carácter
 * ’|’, etc. En segundo lugar, cada línea debe invertirse. Después de invertir,
 * todos los caracteres de la mitad en adelante (truncado) deben moverse una
 * posición a la izquierda en ASCII. En este caso, ’b’ se convierte en ’a’ y ’a’
 * se convierte en ’‘’.
 *
 * @author Fisherk2
 */
public class Cifrado {

    private final String[] LINEAS;
    private String[] lineasCifradas;
    private String salida;
    private final int LLAVE = 3; //Posiciones de desplazado

    public Cifrado(String entrada) {
        salida = "";
        LINEAS = entrada.split("\n");

    }

    public String getSalidaCifrada() {
        for (String linea : encriptar()) {
            salida += linea + "\n";
        }

        return salida;
    }

    public String getSalidaDescifrada() {
        for (String linea : desEncriptar()) {
            salida += linea + "\n";
        }

        return salida;
    }

    private String[] encriptar() {
        lineasCifradas = new String[LINEAS.length];
        for (int i = 0; i < LINEAS.length; i++) { //Lineas = i, Caracteres = j
            //DESPLAZAR
            char lineaChar[] = new char[LINEAS[i].length()];
            String lineaNueva = ""; //Variable de apoyo

            for (int j = 0; j < LINEAS[i].length(); j++) {
                if (LINEAS[i].charAt(j) >= 48 && LINEAS[i].charAt(j) <= 57) { //Si es un valor numerico, este no se desplazara 
                    lineaChar[j] = (char) (LINEAS[i].charAt(j)); //Sumamos los valores ASCII y lo almacenamos en la nueva entrada.

                } else {
                    lineaChar[j] = (char) (LINEAS[i].charAt(j) + LLAVE); //Sumamos los valores ASCII y lo almacenamos en la nueva entrada.
                }
                lineaNueva += lineaChar[j]; //La salida sera con los caracteres ya cambiados por la llave.
            }
            lineasCifradas[i] = lineaNueva; //Agregamos las lineas desplazadas al nuevo arreglo

            //INVERTIR
            lineaNueva = ""; //Variable de apoyo
            for (int j = lineasCifradas[i].length() - 1; j > -1; j--) {
                lineaChar[j] = lineasCifradas[i].charAt(j); //Invertimos los valores ASCII y lo almacenamos en la nueva entrada.
                lineaNueva += lineaChar[j]; //La salida sera con los caracteres ya cambiados por la llave.
            }
            lineasCifradas[i] = lineaNueva;

            //MOVER IZQUIERDA
            lineaNueva = ""; //Variable de apoyo
            for (int j = 0; j < lineasCifradas[i].length(); j++) {
                boolean numeros = lineasCifradas[i].charAt(j) >= 48 && lineasCifradas[i].charAt(j) <= 57;
                if (j >= (lineasCifradas[i].length() / 2) && !numeros) {
                    lineaChar[j] = (char) (lineasCifradas[i].charAt(j) - 1); //Se desplaza -1
                } else {
                    lineaChar[j] = lineasCifradas[i].charAt(j);
                }
                lineaNueva += lineaChar[j]; //Se va almacenar la primer mitad de caracteres o si contiene un caracter numerico
            }
            lineasCifradas[i] = lineaNueva;
        }//CICLO DE LINEA POR LINEA
        return lineasCifradas;
    }

    private String[] desEncriptar() {
        lineasCifradas = new String[LINEAS.length];
        for (int i = 0; i < LINEAS.length; i++) { //Lineas = i, Caracteres = j
            //MOVER DERECHA
            char lineaChar[] = new char[LINEAS[i].length()];
            String lineaNueva = ""; //Variable de apoyo

            for (int j = 0; j < LINEAS[i].length(); j++) {
                boolean numeros = LINEAS[i].charAt(j) >= 48 && LINEAS[i].charAt(j) <= 57;
                if (j >= (LINEAS[i].length() / 2) && !numeros) {
                    lineaChar[j] = (char) (LINEAS[i].charAt(j) + 1); //Se desplaza +1
                } else {
                    lineaChar[j] = LINEAS[i].charAt(j);
                }
                lineaNueva += lineaChar[j]; //Se va almacenar la primer mitad de caracteres o si contiene un caracter numerico
            }
            lineasCifradas[i] = lineaNueva;

            //REINVERTIR
            lineaNueva = ""; //Variable de apoyo
            for (int j = lineasCifradas[i].length() - 1; j > -1; j--) {
                lineaChar[j] = lineasCifradas[i].charAt(j); //Invertimos los valores ASCII y lo almacenamos en la nueva entrada.
                lineaNueva += lineaChar[j]; //La salida sera con los caracteres ya cambiados por la llave.
            }
            lineasCifradas[i] = lineaNueva;

            //DESPLAZAR
            lineaNueva = ""; //Variable de apoyo
            for (int j = 0; j < lineasCifradas[i].length(); j++) {
                if (lineasCifradas[i].charAt(j) >= 48 && lineasCifradas[i].charAt(j) <= 57) { //Si es un valor numerico, este no se desplazara 
                    lineaChar[j] = (char) (lineasCifradas[i].charAt(j)); //Restamos los valores ASCII y lo almacenamos en la nueva entrada.

                } else {
                    lineaChar[j] = (char) (lineasCifradas[i].charAt(j) - LLAVE); //Restamos los valores ASCII y lo almacenamos en la nueva entrada.
                }
                lineaNueva += lineaChar[j]; //La salida sera con los caracteres ya cambiados por la llave.
            }
            lineasCifradas[i] = lineaNueva; //Agregamos las lineas desplazadas al nuevo arreglo
        }//CICLO DE LINEA POR LINEA

        return lineasCifradas;
    }
}
