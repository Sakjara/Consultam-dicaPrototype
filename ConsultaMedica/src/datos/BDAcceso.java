/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Acceso;
import negocio.Paciente;

/**
 *
 * @author Administrador
 */
public class BDAcceso extends Conexion {
    
    public BDAcceso() {
        super();
    }
    
    public Acceso buscarUsuario(String usuario, String clave) throws SQLException, Exception {
        super.conectar();
        Acceso acceso = new Acceso();
        ResultSet result = state.executeQuery(
                "select * from acceso Where usuario ='" + usuario + "' && clave='" + clave + "'  ;");

        while (result.next()) {
            acceso.setUsuario((String) result.getObject(1));
            acceso.setClave((String) result.getObject(2));
        }
        return acceso;
    }
    
    public boolean validarAcceso(String usuario, String clave) throws SQLException, Exception {
        super.conectar();
        Acceso acceso = new Acceso();
        boolean validar;
        ResultSet result = state.executeQuery(
                "select * from acceso Where usuario ='" + usuario + "' && clave='" + clave + "'  ;");

        while (result.next()) {
            acceso.setUsuario((String) result.getObject(1));
            acceso.setClave((String) result.getObject(2));
        }
        
        if(acceso.getUsuario().equalsIgnoreCase(usuario) && acceso.getClave().equals(clave)) {
            validar = true;
        } else {
            validar = false;
        }
        return validar;
        
    }
    
    
    
}
