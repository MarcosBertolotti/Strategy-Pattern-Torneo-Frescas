package utn;

import utn.Razas.Humano;

import java.sql.*;

public class Conexion {

    public void almacenarGanador(Humano ganador){
        verificarConexion();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/torneoFrescas","root","");

            String query = "insert into ganadores (nombre,tolerancia,bebido_total,orina_retenida) values (?,?,?,?);";

            PreparedStatement st = connection.prepareStatement(query);

            st.setString(1,ganador.getNombre());
            st.setInt(2,ganador.getTolerancia());
            st.setInt(3,ganador.getTotalBebido());
            st.setDouble(4,ganador.getOrinaRetenida());
            st.execute();

            System.out.println("\nGanador almacenado en la Base de Datos correctamente");

            connection.close();

        } catch (SQLException e) {
            System.out.println("No se puede conectar a la Base de Datos");
            e.printStackTrace();
        }

    }

    public void mostrarTodosGanadores(){
        verificarConexion();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/torneoFrescas","root","");

            Statement st = connection.createStatement();

            String query = "select * from ganadores";

            ResultSet resultSet = st.executeQuery(query);

            while(resultSet.next()){
                System.out.println("Nombre: " + resultSet.getString("nombre") + " " +
                        "Tolerancia: " + resultSet.getInt("tolerancia") + " " +
                        "BebidoTotal: " + resultSet.getInt("bebido_total") + " " +
                        "OrinaRetenida: " + resultSet.getDouble("orina_retenida"));
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void verificarConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

