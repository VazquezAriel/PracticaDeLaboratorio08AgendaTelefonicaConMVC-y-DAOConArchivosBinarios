/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import java.util.Collection;

/**
 *
 * @author ariel
 */
public class ControladorTelefono {
    
    //Objeto Telefono
    private Telefono telefono;
    //Objetos DAO
    private ITelefonoDAO telefonosDAO ;

    //Constructor sin parametros
    public ControladorTelefono() {
        
    }

    //Constructor con parametros
    public ControladorTelefono(ITelefonoDAO telefonosDAO) {
        this.telefonosDAO = telefonosDAO;
    }

    //Crea un Telefono atraves de la vista y lo agrega al diccionario creado en el DAO
    public Telefono crear(Telefono telefono) {
        telefonosDAO.create(telefono);
        return telefono;
    }
    
    //Llama al DAO para obtener Telefono y lo muestra en pantalla atraves de la vista
    public void verTelefono(String codigo) {
        telefono = telefonosDAO.read(codigo);
    }
    
    //Llama al DAO para actualizar un Telefono
    public void actualizar(Telefono telefono) {
        telefonosDAO.update(telefono);
    }
    
    //Llama al DAO para eliminar un Telefono
    public void eliminar(Telefono telefono) {
        telefonosDAO.delete(telefono);
    }
    
    //Muestra todos los Telefonos existentes en el DAO
    public Collection<Telefono>  verTelefonos() {
        Collection<Telefono> telefonos;
        telefonos = telefonosDAO.findAll();
        if (!telefonos.isEmpty()) {
            return telefonos;
        } else {
            return null;
        }
    }
    
    public String obtenerSiguienteCodigo() {
        int codigo = telefonosDAO.obtenerUltimoCodigo();
        return ++codigo + "";
    }
}
