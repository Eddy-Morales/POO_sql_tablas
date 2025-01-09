import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 {
    private JPasswordField passwordField1;
    private JTextField usuario_textField;
    private JButton ingresar_lbl;
    private JLabel titulo_lbl;
    private JLabel usuario_lbl;
    private JLabel contrasena_lbl;
    public JPanel mainPanel;

    public form1() {
        ingresar_lbl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuario_textField.getText();
                String contrasena = new String(passwordField1.getPassword());

                // Validar que los campos no estén vacíos
                if (usuario.isEmpty() || contrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese usuario y contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Abrir el formulario form2 y pasar las credenciales
                SwingUtilities.invokeLater(() -> {
                    JFrame frame = new JFrame("Clientes");
                    frame.setContentPane(new form2(usuario, contrasena).tabla_panel); // Pasar credenciales al constructor de Form2
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(600, 480); // Establece el tamaño del frame
                    frame.setPreferredSize(new Dimension(600, 480)); // Tamaño preferido
                    frame.pack();
                    frame.setVisible(true);
                });

                // Cerrar el formulario actual (opcional)
                ((JFrame) SwingUtilities.getWindowAncestor(mainPanel)).dispose();
            }
        });
    }

}
