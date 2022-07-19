/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import implementacion.IOperable;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Consulta implements IOperable{
    
    private int idConsulta;
    private Date fechaConsulta;
    private String rutPaciente;
    private String rutDoctor;
    private int precioDoctor;

    public Consulta() {
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) throws Exception {
        if(fechaConsulta != null) { 
            this.fechaConsulta = fechaConsulta;
        } else {
            throw new Exception("Debe ingresar una fecha");
        }
    }

    public String getRutPaciente() {
        
        return rutPaciente;
    }

    public void setRutPaciente(String rutPaciente) throws Exception {
        if (rutPaciente.trim().length()>0) {
            this.rutPaciente = rutPaciente;
        } else {
           throw new Exception("Debe ingresar un RUT válido"); 
        }
        
    }

    public String getRutDoctor() {
        return rutDoctor;
    }

    public void setRutDoctor(String rutDoctor) throws Exception {
        if(rutDoctor.equalsIgnoreCase("seleccionar")) {
            throw new Exception("Debe ingresar un Doctor"); 
        } else {
            this.rutDoctor = rutDoctor;
        }
    }

    public int getPrecioDoctor() {
        return precioDoctor;
    }

    public void setPrecioDoctor(int precioDoctor) {
            this.precioDoctor = precioDoctor;
    }

    // metodos
    
    @Override
    public String toString() {
        return "***INFORMACIÓN CONSULTA***" + "\n" + 
                "ID CONSULTA: " + idConsulta + "\n" +
                "FECHA CONSULTA: " + fechaConsulta + "\n" +
                "RUT PACIENTE: " + rutPaciente + "\n" + 
                "RUT DOCTOR: " + rutDoctor + "\n" +
                "PRECIO: $" + precioDoctor + "\n" +
                "-------------------------------------" + "\n";
    }
    
    

  
    
    
    
}
