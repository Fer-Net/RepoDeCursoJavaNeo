

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection conexion = null;
        Statement consulta = null;

        try {

            // Abrir la conexión
            System.out.println("conectando a la base de datos...");

            conexion = DriverManager.getConnection(ConectorSQL.DB_URL, ConectorSQL.USER, ConectorSQL.PASS);

            // Ejecutar una consulta
            System.out.println("Creating statement...");
            consulta = conexion.createStatement();
            String sql;
            sql = "SELECT * FROM mi_base_de_datos.persona";

            //En la variable resultado obtendremos las distintas filas que nos devolvió la base
            ResultSet resultado = consulta.executeQuery(sql);

            // Obtener las distintas filas de la consulta
            while (resultado.next()) {
                // Pbtener el valor de cada columna
            	String nombre = resultado.getString("nombre");
                int edad = resultado.getInt("edad");
                String direccion = resultado.getString("direccion");

                // Mostrar los valores obtenidos
                System.out.print("nombre" + nombre);
                System.out.print(", edad: " + edad);
                System.out.print(", direccion: " + direccion);
            
            }
            // Esto se utiliza par cerrar la conexión con la base de datos
            resultado.close();
            consulta.close();
            conexion.close();
        } catch (SQLException se) {
            // Execpción ante problemas de conexión
            se.printStackTrace();
        } finally {
            // Esta sentencia es para que ante un problema con la base igual se cierren las conexiones
            try {
                if (consulta != null)
                    consulta.close();
            } catch (SQLException se2) {
            }
            try {
                if (conexion != null)
                    conexion.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Fin de la ejecucción");
    }
}