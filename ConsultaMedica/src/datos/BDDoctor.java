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
import negocio.Doctor;

/**
 *
 * @author Administrador
 */
public class BDDoctor extends Conexion {
    // Insertar doctor
    public void insertarDoctor(Doctor doctor) {
        try {
            //Rescatamos fecha para convertir a formato MySql
            long mi_fecha = (doctor.getFechaNacimiento()).getTime();
            //importando java.sql.Date a formato de MySql
            java.sql.Date fecha = new java.sql.Date(mi_fecha);
            super.conectar();
            super.state.executeUpdate("INSERT INTO doctor VALUES('" + doctor.getRut()
                    + "', '" + doctor.getNombre() + "', '" 
                    + doctor.getApellido() + "', '" + fecha + "', '" + doctor.getCorreo() + "', '" + doctor.getEspecialidad()+ "', " + doctor.getPrecio() + ");");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
      
    // Buscar Doctor
    
    public Doctor buscarDoctor(String rutDoctor) throws SQLException, Exception {
        super.conectar();
        Doctor doctor = new Doctor();
        ResultSet result = state.executeQuery(
        "select * from doctor Where rut_doctor='"+ rutDoctor +"'  ;");

        while (result.next()) {
            doctor.setRut((String) result.getObject(1));
            doctor.setNombre((String) result.getObject(2));
            doctor.setApellido((String) result.getObject(3));
            doctor.setFechaNacimiento((Date) result.getObject(4));
            doctor.setCorreo((String) result.getObject(5));
            doctor.setEspecialidad((String) result.getObject(6));
            doctor.setPrecio((Integer) result.getObject(7));
        }
        return doctor;
    }
    
    
        public Doctor buscarDoctorNombre(String nombreDoctor) throws SQLException, Exception {
        super.conectar();
        Doctor doctor = new Doctor();
        ResultSet result = state.executeQuery(
        "select * from doctor Where nombre_doctor='"+ nombreDoctor +"'  ;");

        while (result.next()) {
            doctor.setRut((String) result.getObject(1));
            doctor.setNombre((String) result.getObject(2));
            doctor.setApellido((String) result.getObject(3));
            doctor.setFechaNacimiento((Date) result.getObject(4));
            doctor.setCorreo((String) result.getObject(5));
            doctor.setEspecialidad((String) result.getObject(6));
            doctor.setPrecio((Integer) result.getObject(7));
        }
        return doctor;
    }
    
    // Modificar
    
        public int modificarDoctor(Doctor doctor) {
        int entero = 0;
        try {
            long mi_fecha = (doctor.getFechaNacimiento()).getTime();
            //importando java.sql.Date a formato de MySql
            java.sql.Date fecha = new java.sql.Date(mi_fecha);
            super.conectar();
            entero = state.executeUpdate("update doctor set nombre_doctor='"
                    + doctor.getNombre()+ "', apellido_doctor='"
                    + doctor.getApellido()+ "', fecha_nacimiento='"
                    + fecha + ", correo='"
                    + doctor.getCorreo()+ "', especialidad='"
                    + doctor.getEspecialidad() + "', precio=" + doctor.getPrecio()
                    + " where rut_doctor='" + doctor.getRut()+ "';");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entero;
    }
        
    // Listar doctor
        
    public ArrayList<Doctor> listarDoctor() throws SQLException, Exception {
        super.conectar();

        ArrayList<Doctor> doctor = new ArrayList<Doctor>();
        ResultSet result = state.executeQuery("select * from doctor");
        while (result.next()) {
            Doctor doc = new Doctor();
            doc.setRut((String) result.getObject(1));
            doc.setNombre((String) result.getObject(2));
            doc.setApellido((String) result.getObject(3));
            doc.setFechaNacimiento((Date) result.getObject(4));
            doc.setCorreo((String) result.getObject(5));
            doc.setEspecialidad((String) result.getObject(6));
            doc.setPrecio((Integer) result.getObject(7));
            doctor.add(doc);
        }
        return doctor;
    }
    
    
    // Eliminar doctor
    
    public int eliminarDoctor(String rutDoctor) {
        int entero = 0;
        try {
            super.conectar();
            entero = state.executeUpdate("DELETE FROM doctor WHERE rut_doctor='" + rutDoctor + "';");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entero;
    }
    
}
