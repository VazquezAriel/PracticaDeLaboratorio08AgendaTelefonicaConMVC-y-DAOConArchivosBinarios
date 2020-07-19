/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author ariel
 */
public class ControladorUsuario {
    
    //Objetos modelo
    private Usuario usuario;
    private Telefono telefono;
    //Objetos DAO
    private IUsuarioDAO usuarioDAO;
    private ITelefonoDAO telefonoDAO;

    //Constructor sin parametros
    public ControladorUsuario() {

    }
    
    //Constructor con parametros
    public ControladorUsuario(IUsuarioDAO usuarioDAO, ITelefonoDAO telefonoDAO) {
        this.usuarioDAO = usuarioDAO;
        this.telefonoDAO = telefonoDAO;
    }

    //Crea un Usuario atraves de la vista y lo agrega al diccionario creado en el DAO
    public void registrar(String cedula, String nombre, String apellido, String correo, String contraseña) {
        usuario = new Usuario(cedula, nombre, apellido, correo, contraseña, true);
        usuarioDAO.create(usuario);
    }

    //Retorna el usuario logeado
    public Usuario verUsuario() {
        return usuario;
    }

    //Genera un Usuario con la clave ingresada atraves de la vista y lo remplaza atraves del DAO
    public void actualizar(String cedula, String nombre, String apellido, String correo, String contraseña) {
        usuario = new Usuario(cedula, nombre, apellido, correo, contraseña, true);
        usuarioDAO.update(usuario);
    }
    
    //Genera un Usuario con la clave ingresada atraves de la vista y lo elimina atraves del DAO
    public void eliminar(String cedula) {
        usuarioDAO.delete(usuario);
    }

    //Genera un Usuario atraves de la vista y compara con cada Usuario existente en el DAO
    public Usuario Autentificar(Usuario usuario) {
        Collection<Usuario> usuarios = usuarioDAO.findAll();
        for (Usuario usuario1 : usuarios) {
            if (usuario.equals(usuario1)) {
                return usuario1;
            }
        }
        return null;
    }

    //Muestra en pantalla todos los usuarios existentes en el DAO atraves de la vista
    public Collection<Usuario>  verUsuarios() {
        Collection<Usuario> usuarios;
        usuarios = usuarioDAO.findAll();
        if (!usuarios.isEmpty()) {
            return usuarios;
        } else {
            return null;
        }
    }
    
    //inicio de secion
    public boolean validarUsuario(String correo, String contraseña) {
        usuario = usuarioDAO.login(correo, contraseña);
        if (usuario != null) {
            return true;
        } else {
            return false;
        }
    }

    //Genera un Usuario con la clave ingresada y a este se le agrega el telefono ingresado
    public void agregarTelefono(int codigo, String numero, String tipo, String operadora) {
        telefono = new Telefono(codigo, numero, tipo, operadora);
        telefono.setUsuario(usuario);
        telefonoDAO.create(telefono);
    }

    //Obtiene un Usuario atraves del DAO con la clave ingresada, Obtiene un Telefono atraves de la vista y elimina dicho telefono del Usuario
    public void eliminarTelefono(int codigo) {
        
    }

    //Obtiene un Usuario atraves del DAO con la clave ingresada, Obtiene un Telefono atraves de la vista y actualiza dicho telefono del Usuario
    public void editarTelefono(int codigo, String numero, String tipo, String operadora) {
        
    }
    
    //Obtiene un Usuario atraves del DAO con la clave ingresada, Obtiene un Telefono atraves de la vista y compara si dicho telefono esta agregado en el Usuario
    public void buscarTelefono(String cedula) {
        
    }
    
    //Obtiene un Usuario atraves del DAO con la clave ingresada y muestra en pantalla todos los Telefonos agregados en el Usuario atraves de la vista
    public List<Telefono> listarTelefonos() {
        return null;
    }

    public Usuario buscarUsuario(String cedula) {
        return usuarioDAO.read(cedula);
    }

}
