
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Mostrar el Form1
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Login");
            frame.setContentPane(new form1().mainPanel); // Agrega el panel principal de Form1
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 480); // Establece el tamaño del frame
            frame.setPreferredSize(new Dimension(600, 480)); // Tamaño preferido
            frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
            frame.pack(); // Ajusta el tamaño del frame al contenido
            frame.setVisible(true); // Muestra la ventana
        });
    }
}