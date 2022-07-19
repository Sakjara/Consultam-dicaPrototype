/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Administrador
 */
public abstract class Persona {
    protected String rut;
    protected String nombre;
    protected String apellido;
    protected Date fechaNacimiento;
    protected String correo;

    public Persona() {
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) throws Exception {
        if (rut.trim().length() >= 9 && rut.trim().length() <= 10) {
            this.rut = rut;
        } else {
            throw new Exception("Debe ingresar un RUT con un largo correcto");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if (nombre.trim().length() > 0) {
            this.nombre = nombre;
        } else {
            throw new Exception("Debe ingresar un nombre");
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws Exception {
        if(apellido.trim().length() > 0) {
            this.apellido = apellido;
        } else {
            throw new Exception("Debe ingresar un apellido");
        }
        
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) throws Exception {
        if(fechaNacimiento != null) {
            this.fechaNacimiento = fechaNacimiento;
        } else {
            throw new Exception("Debe ingresar una fecha");
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) throws Exception {
        if(validarCorreo(correo) == true) {
            this.correo = correo;
        } else {
            throw new Exception("Debe ingresar un correo valido");
        }
    }
    
    
    // metodos
    
    public boolean validarCorreo(String correo) {
        boolean validar;
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        if (mather.find() == true) {
            validar = true;
        } else {
            validar = false;
        }
        return validar;
    }
}
