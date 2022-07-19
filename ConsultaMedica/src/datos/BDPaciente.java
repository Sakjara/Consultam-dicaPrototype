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
import negocio.Paciente;

/**
 *
 * @author Administrador
 */
public class BDPaciente extends Conexion {
    
    
    public BDPaciente() {
        super();
    }
    // Insertar paciente
    public void insertarPaciente(Paciente paciente) {
        try {
            //Rescatamos fecha para convertir a formato MySql
            long mi_fecha = (paciente.getFechaNacimiento()).getTime();
            //importando java.sql.Date a formato de MySql
            java.sql.Date fecha = new java.sql.Date(mi_fecha);
            super.conectar();
            super.state.executeUpdate("INSERT INTO paciente VALUES('" + paciente.getRut()
                    + "', '" + paciente.getNombre() + "', '" + paciente.getApellido()
                    + "', '" + fecha + "', '" + paciente.getCorreo() + "');");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    // Buscar paciente
    
    public Paciente buscarPaciente(String rutPaciente) throws SQLException, Exception {
        super.conectar();
        Paciente paciente = new Paciente();
        ResultSet result = state.executeQuery(
                "select * from paciente Where rut ='" + rutPaciente + "'  ;");

        while (result.next()) {
            paciente.setRut((String) result.getObject(1));
            paciente.setNombre((String) result.getObject(2));
            paciente.setApellido((String) result.getObject(3));
            paciente.setFechaNacimiento((Date) result.getObject(4));
            paciente.setCorreo((String) result.getObject(5));
        }
        return paciente;
    }
    
    // Modificar paciente 
    
    public int modificarPaciente(Paciente paciente) {
        int entero = 0;
        try {
            //Rescatamos fecha para convertir a formato MySql
            long mi_fecha = (paciente.getFechaNacimiento()).getTime();
            //importando java.sql.Date a formato de MySql
            java.sql.Date fecha = new java.sql.Date(mi_fecha);
            super.conectar();
            entero = super.state.executeUpdate("update paciente set nombre='"
                    + paciente.getNombre() + "', apellido='" + paciente.getApellido()
                    + "', fecha_nacimiento='" + fecha + "', correo='" + paciente.getCorreo() + "', where rut='" + paciente.getRut() + "'  ;");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entero;
    }
    
    // Listar paciente 
    public ArrayList<Paciente> listarPaciente() throws SQLException, Exception {
        super.conectar();

        ArrayList<Paciente> paciente = new ArrayList<Paciente>();
        ResultSet result = state.executeQuery("select * from paciente");
        while (result.next()) {
            Paciente pac = new Paciente();
            pac.setRut((String) result.getObject(1));
            pac.setNombre((String) result.getObject(2));
            pac.setApellido((String) result.getObject(3));
            pac.setFechaNacimiento((Date) result.getObject(4));
            pac.setCorreo((String) result.getObject(5));
            paciente.add(pac);
        }
        return paciente;
    }
    
    // Eliminar paciente
    
    public int eliminarPaciente(String rut) {
        super.conectar();
        int entero = 0;
        try {
            super.conectar();
            entero = state.executeUpdate("DELETE FROM paciente WHERE rut='" + rut + "';");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entero;
    }
    
    
}

