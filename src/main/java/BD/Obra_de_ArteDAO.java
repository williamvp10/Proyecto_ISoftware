package BD;

import MOdelo.Artista;
import MOdelo.Obra_de_Arte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * CREATE TABLE Depto( id_depto integer, nom_depto varchar(40), PRIMARY
 * KEY(id_depto) );
 */
public class Obra_de_ArteDAO implements IBaseDatos<Obra_de_Arte> {

    public boolean agregar_Obra(Obra_de_Arte a) {
        boolean r = false;
        String query = " insert into Obra_de_arte (nombre,descripcion,estilo,valor,user)"
                + " values (?,?,?,?,?)";
        PreparedStatement preparedStmt = null;
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Obra_de_ArteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // create the mysql insert preparedstatement
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, a.getNombre());
            preparedStmt.setString(2, a.getDiscripcion());
            preparedStmt.setString(3, a.getEstilo());
            preparedStmt.setDouble(4, a.getValor());
            preparedStmt.setString(5, a.getArtista().getUser());
            // execute the preparedstatement
            r = preparedStmt.execute();
              System.out.println("You made it, the insertion is ok!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    public Artista buscar_artista(String user) {
        Artista a = null;
        // if you only need a few columns, specify them by name instead of using "*"
        String query = "select * from Artista where user = '" + user + "'";
        PreparedStatement preparedStmt = null;
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Obra_de_ArteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // create the java statement
            Statement st = connection.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                String user2 = rs.getString("user");
                String nom = rs.getString("nombre");
                String cur = rs.getString("curriculum");
                String dis = rs.getString("distinciones");
                a = new Artista(user2, nom, cur, dis);
            }
            st.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }
        return a;
    }

//    public List recursosProyecto() {
//        String nombreProyecto = "";
//        int total = 0;
//        try {
//            String query = "select nom_proy, count(*) as total from Proyecto left join Recurso "
//                    + "     using (id_proyecto) group by nom_proy";
//            Connection connection = null;
//            try {
//                connection = Conexion.getConnection();
//            } catch (URISyntaxException ex) {
//                ex.printStackTrace();
//            }
//
//            Statement st = connection.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            while (rs.next()) {
//                nombreProyecto = rs.getString("nom_proy");
//                total = rs.getInt("total");
//
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Obra_de_ArteDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    /**
//     * Funcion que permite obtener una lista de los departamentos existentes en
//     * la base de datos
//     *
//     * @return List<Departamento> Retorna la lista de Departamentos existentes
//     * en la base de datos
//     */
//    public List<Obra_de_Arte> findAll() {
//        List<Obra_de_Arte> departamentos = null;
//        String query = "SELECT * FROM Depto";
//        Connection connection = null;
//        try {
//            connection = Conexion.getConnection();
//        } catch (URISyntaxException ex) {
//            Logger.getLogger(Obra_de_ArteDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            Statement st = connection.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            int id = 0;
//            String nombre = null;
//
//            while (rs.next()) {
//                if (departamentos == null) {
//                    departamentos = new ArrayList<Obra_de_Arte>();
//                }
//
//                Obra_de_Arte registro = new Obra_de_Arte();
//                id = rs.getInt("id_depto");
//                registro.setId_departamento(id);
//
//                nombre = rs.getString("nom_depto");
//                registro.setNom_departamento(nombre);
//
//                departamentos.add(registro);
//            }
//            st.close();
//
//        } catch (SQLException e) {
//            System.out.println("Problemas al obtener la lista de Departamentos");
//            e.printStackTrace();
//        }
//
//        return departamentos;
//    }
//
//    /**
//     * Funcion que permite realizar la insercion de un nuevo registro en la
//     * tabla Obra_de_Arte
//     *
//     * @param Departamento recibe un objeto de tipo Obra_de_Arte
//     * @return boolean retorna true si la operacion de insercion es exitosa.
//     */
//    public boolean insert(Obra_de_Arte t) {
//        boolean result = false;
//        Connection connection = null;
//        try {
//            connection = Conexion.getConnection();
//        } catch (URISyntaxException ex) {
//            Logger.getLogger(Obra_de_ArteDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String query = " insert into Depto (id_depto,nom_depto)" + " values (?,?)";
//        PreparedStatement preparedStmt = null;
//        try {
//            preparedStmt = connection.prepareStatement(query);
//            preparedStmt.setInt(1, t.getId_departamento());
//            preparedStmt.setString(2, t.getNom_departamento());
//            result = preparedStmt.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    /**
//     * Funcion que permite realizar la actualizacion de un nuevo registro en la
//     * tabla Obra_de_Arte
//     *
//     * @param Departamento recibe un objeto de tipo Obra_de_Arte
//     * @return boolean retorna true si la operacion de actualizacion es exitosa.
//     */
//    public boolean update(Obra_de_Arte t) {
//        boolean result = false;
//        Connection connection = null;
//        try {
//            connection = Conexion.getConnection();
//        } catch (URISyntaxException ex) {
//            Logger.getLogger(Obra_de_ArteDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String query = "update Depto set nom_depto = ? where id_depto = ?";
//        PreparedStatement preparedStmt = null;
//        try {
//            preparedStmt = connection.prepareStatement(query);
//            preparedStmt.setString(1, t.getNom_departamento());
//            preparedStmt.setInt(2, t.getId_departamento());
//            if (preparedStmt.executeUpdate() > 0) {
//                result = true;
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
//
//    /**
//     * Funcion que permite realizar la eliminario de registro en la tabla
//     * Obra_de_Arte
//     *
//     * @param Departamento recibe un objeto de tipo Obra_de_Arte
//     * @return boolean retorna true si la operacion de borrado es exitosa.
//     */
//    public boolean delete(Obra_de_Arte t) {
//        boolean result = false;
//        Connection connection = null;
//        try {
//            connection = Conexion.getConnection();
//        } catch (URISyntaxException ex) {
//            Logger.getLogger(Obra_de_ArteDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String query = "delete from Depto where id_depto = ?";
//        PreparedStatement preparedStmt = null;
//        try {
//            preparedStmt = connection.prepareStatement(query);
//            preparedStmt.setInt(1, t.getId_departamento());
//            result = preparedStmt.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }

    @Override
    public List<Obra_de_Arte> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Obra_de_Arte t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Obra_de_Arte t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Obra_de_Arte t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
