/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;

/**
 *
 * @author ariel
 */
public class UsuarioDAO implements IUsuarioDAO{
    
    /**
     * Tamaño del archivo:
     * 
     * cedula -> 10 caracteres
     * nombre -> 25 caracteres
     * apellido -> 25 de caracteres
     * correo -> 50 caracteres      
     * contraseña -> 8 caracteres
     * 
     * Total -> 118 bytes + 10 bytes extras = 128 bytes por registro
     * 
     */
    
    //archivo binario
    private RandomAccessFile archivo;


    //Constructor
    public UsuarioDAO() {
        try{
        archivo = new RandomAccessFile("Datos/Usuarios.dat", "rw");
        
        }catch(IOException e){
            System.out.println("Error de  lectura y escritura");
            e.printStackTrace();
            
        }
    }

    //Metodos de la Interface IUsuario
    @Override
    public void create(Usuario usuario) {
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(usuario.getCedula());
            archivo.writeUTF(usuario.getNombre());
            archivo.writeUTF(usuario.getApellido());
            archivo.writeUTF(usuario.getCorreo());
            archivo.writeUTF(usuario.getContraseña());
            
        } catch (IOException e) {
            System.out.println("Error de  lectura y escritura(create:UsuarioDao)");
            e.printStackTrace();
            
        }
        
    }

    @Override
    public Usuario read(String cedula) {
        return null;
    }

    @Override
    public void update(Usuario usuario) {
    }

    @Override
    public void delete(Usuario usuario) {
    }

    @Override
    public Collection<Usuario> findAll() {
        return null;
    }

    @Override
    public Usuario login(String correo, String contraseña) {
        return null;
    }
    
}
