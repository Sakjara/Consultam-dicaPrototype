/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Consulta;

/**
 *
 * @author Administrador
 */
public class BDConsulta extends Conexion {
    
    // Insertar consulta
    
    public void insertarConsulta(Consulta consulta) {
        try {
            long mi_fecha = (consulta.getFechaConsulta()).getTime();
            //importando java.sql.Date a formato de MySql
            java.sql.Date fecha = new java.sql.Date(mi_fecha);
            super.conectar();
            state.executeUpdate("INSERT INTO consulta VALUES(" + consulta.getIdConsulta()
                    + ", '" + fecha + "', '"
                    + consulta.getRutPaciente()+ "', '"
                    + consulta.getRutDoctor()+ "', " + consulta.getPrecioDoctor() + ");");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    
    // Buscar Consulta
    
    public Consulta buscarConsulta(String rutPaciente) throws SQLException, Exception {
        super.conectar();
        Consulta consulta = new Consulta();
        ResultSet result = state.executeQuery(
        "select * from consulta Where paciente_rut ='"+ rutPaciente +"'  ;");

        while (result.next()) {
            consulta.setIdConsulta((Integer) result.getObject(1));
            consulta.setFechaConsulta((Date) result.getObject(2));
            consulta.setRutPaciente((String) result.getObject(3));
            consulta.setRutDoctor((String) result.getObject(4));
            consulta.setPrecioDoctor((Integer) result.getObject(5));
        }
        return consulta;
    }
        
    // Listar consultas
        
    public ArrayList<Consulta> listarConsulta() throws SQLException, Exception {
        super.conectar();

        ArrayList<Consulta> consulta = new ArrayList<Consulta>();
        ResultSet result = state.executeQuery("select * from consulta");
        while (result.next()) {
            Consulta consul = new Consulta();
            consul.setIdConsulta((Integer) result.getObject(1));
            consul.setFechaConsulta((Date) result.getObject(2));
            consul.setRutPaciente((String) result.getObject(3));
            consul.setRutDoctor((String) result.getObject(4));
            consul.setPrecioDoctor((Integer) result.getObject(5));
            consulta.add(consul);
        }
        return consulta;
    }
    
    // Consulta
    
    public int modificarConsulta(Consulta consulta) {
        int entero = 0;
        try {
            long mi_fecha = (consulta.getFechaConsulta()).getTime();
            //importando java.sql.Date a formato de MySql
            java.sql.Date fecha = new java.sql.Date(mi_fecha);
            super.conectar();
            entero = state.executeUpdate("update consulta set fecha_consulta="
                    + fecha + ", rut_doctor='" + consulta.getRutDoctor()
                    + "' where idConsulta='" + consulta.getIdConsulta() + "';");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entero;
    }
    
    // Eliminar consulta

    public int eliminarConsulta(String rutPaciente) {
        int entero = 0;
        try {
            super.conectar();
            entero = state.executeUpdate("DELETE FROM consulta WHERE paciente_rut='" + rutPaciente + "';");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entero;
    }
}
