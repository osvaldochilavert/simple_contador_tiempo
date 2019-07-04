package simplecontadortiempo;

import java.io.InputStream;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SimpleContadorTiempo {

    int segundos = 0;
    int minutos = 0;
    int MINUTO_FINAL = 25;
    int CANTIDAD_SEGUNDOS = 60; // P pruebas bajamos tiempo
    Boolean segundoInicial = true;

    public SimpleContadorTiempo() {
        // No inicia nada.
    }

    private void desactivarBotonPausa() {

    }

    public void reiniciar(javax.swing.JLabel txtSegundos, javax.swing.JLabel txtMinutos) {
        minutos = 0;
        segundos = 0;

        txtMinutos.setText("00");
        txtSegundos.setText("00");

    }

    /*
    Incrementa decenas
    00, 01,02, 03, 04, 05, 06, 07, 08, 09
     */
    private void visorSegundos(int contarSegundos, javax.swing.JLabel txtSegundos) {

        if (contarSegundos < 10) {
            txtSegundos.setText("0" + String.valueOf(contarSegundos));
        } else {
            txtSegundos.setText(String.valueOf(contarSegundos));
        }
    }

    private void visorMinutos(int minutosContar, javax.swing.JLabel txtMinutos) {
        if (minutosContar < 10) {
            txtMinutos.setText("0" + String.valueOf(minutosContar));
        } else {
            txtMinutos.setText(String.valueOf(minutosContar));
        }
    }

    public void contarMinutos(javax.swing.JLabel txtMinutos) {

        /* ---------- */
        minutos++;
        /* ---------- */

        visorMinutos(minutos, txtMinutos);

    }

    public void contarSegundos(javax.swing.JLabel txtSegundos, javax.swing.JLabel txtMinutos) {

        // segundoInicial = true; Asi se definicio el campo al crearse
        if (segundos < CANTIDAD_SEGUNDOS) {

            visorSegundos(segundos, txtSegundos);
            segundoInicial = false;

        }

        // Cuando llega a 59, incrementamos minuto
        if (segundos == CANTIDAD_SEGUNDOS) {

            segundos = 0;

            visorSegundos(segundos, txtSegundos);

            if (!segundoInicial) {
                contarMinutos(txtMinutos);
                
            }

        }

        /* ---------- */
        segundos++;
        /* ---------- */

        if (minutos == MINUTO_FINAL) {
            playSound();

        }

    }

    /**
     * Reproducir sonido!
     */
    private void playSound() {
        try {

            InputStream inputStream = getClass().getResourceAsStream("final.wav");
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
            AudioPlayer.player.stop(audioStream);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    /**
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
