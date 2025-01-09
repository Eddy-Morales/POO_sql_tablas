import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class form2 {
    public JPanel tabla_panel;
    private JTable table1;
    private JLabel bienvenida_lbl;

    private String usuario;
    private String contrasena;

    // Constructor que recibe usuario y contraseña
    public form2(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;

        cargarDatosTabla(); // Llamar a la función para cargar los datos de la tabla
    }

    private void cargarDatosTabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cliente ID");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Email");
        model.addColumn("Teléfono");
        model.addColumn("Fecha de Registro");

        table1.setModel(model);

        String url = "jdbc:mysql://localhost:3306/tienda_online";
        try {
            Connection con = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión exitosa a la base de datos.");

            String query = "SELECT * FROM clientes";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("cliente_id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getDate("fecha_registro")
                });
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
