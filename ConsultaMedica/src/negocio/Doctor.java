/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Administrador
 */
public class Doctor extends Persona {
    
    private String especialidad;
    private int precio;

    public Doctor() {
        super();
    }

    public Doctor(String especialidad, int precio) {
        this.especialidad = especialidad;
        this.precio = precio;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) throws Exception {
        if (especialidad.trim().length()>0) {
            this.especialidad = especialidad;
        } else {
            throw new Exception("Debe ingresar una especialidad");
        }
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) throws Exception {
            this.precio = precio;
    }
    
    

    

    
    
    
    
    
    
    
}
