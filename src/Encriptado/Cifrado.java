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

    private final String ENTRADA;
    private String salida;
    private final int LLAVE = 3; //Posiciones de desplazado
    private final char[] NUMBERS = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public Cifrado(String entry) {
        ENTRADA = entry;
        salida = "";
        desplazar();
        invertir();
        moverIzq();

    }

    public String getSalida() {
        return salida;
    }

    /**
     * Se desplaza en N posiciones hacia la DERECHA, de acuerdo con la tabla
     * ASCII.
     */
    private void desplazar() {
        char salidaNew[] = new char[ENTRADA.length()];
        String salidaNueva = "";
        String caracter;

        for (int i = 0; i < ENTRADA.length(); i++) {
            caracter = String.valueOf(ENTRADA.charAt(i));
            if (caracter.hashCode() >= 48 && caracter.hashCode() <= 57) {
                salidaNew[i] = (char) (ENTRADA.charAt(i)); //Sumamos los valores ASCII y lo almacenamos en la nueva entrada.

            } else {
                salidaNew[i] = (char) (ENTRADA.charAt(i) + LLAVE); //Sumamos los valores ASCII y lo almacenamos en la nueva entrada.
            }
            salidaNueva += salidaNew[i]; //La salida sera con los caracteres ya cambiados por la llave.
        }
        salida = salidaNueva;
    }

    /**
     * Se invierte el orden de escritura inicial de caracteres ya desplazado
     * (ABC -> CBA).
     */
    private void invertir() {
        char salidaNew[] = new char[salida.length()];
        String salidaNueva = "";
        for (int i = salida.length() - 1; i > -1; i--) {
            salidaNew[i] = salida.charAt(i); //Invertimos los valores ASCII y lo almacenamos en la nueva entrada.
            salidaNueva += salidaNew[i]; //La salida sera con los caracteres ya cambiados por la llave.
        }
        salida = salidaNueva;

    }

    /**
     * A la mitad en adelante de caracteres, se desplaza en 1 posicion hacia la
     * IZQUIERDA de acuerdo con la tabla ASCII.
     */
    private void moverIzq() {
        char salidaNew[] = new char[salida.length()];
        String salidaNueva = "";
        for (int i = 0; i < salida.length(); i++) {
            if (i >= (salida.length() / 2)) {
                salidaNew[i] += (char) (salida.charAt(i) - 1); //Se desplaza -1
            } else {
                salidaNew[i] = salida.charAt(i);
            }
            salidaNueva += salidaNew[i]; //Se va almacenar la primer mitad de caracteres
        }
        salida = salidaNueva;

    }

}
