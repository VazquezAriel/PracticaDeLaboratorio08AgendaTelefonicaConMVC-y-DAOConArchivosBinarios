/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;

/**
 *
 * @author ariel
 */
public class TelefonoDAO implements ITelefonoDAO{

    /**
     * Tamaño del archivo:
     *
     * codigo -> 4 bytes 
     * numero -> 25 caracteres 
     * tipo -> 25 caracteres 
     * operadora -> 25 caracteres 
     * usuario cedula -> 10 caracteres
     *
     * Total -> 89 bytes + 8 bytes extras = 97 bytes por registro
     *
     */
    
    private RandomAccessFile archivo;
    private int codigo;

    //Constructor
    public TelefonoDAO() {
        
        try {
            codigo = 0;
            archivo = new RandomAccessFile("Datos/Telefonos.dat", "rw");
            
        } catch (IOException e) {
            System.out.println("Error de lectura y escritura");
            e.printStackTrace();
        }
    }

    //Metodos de la Interface ITelefono
    @Override
    public void create(Telefono telefono) {
        telefono.setCodigo(++codigo);
        try {
            archivo.seek(archivo.length());
            archivo.writeInt(telefono.getCodigo());
            archivo.writeUTF(telefono.getNumero());
            archivo.writeUTF(telefono.getTipo());
            archivo.writeUTF(telefono.getOperadora());
            archivo.writeUTF(telefono.getUsuario().getCedula());

        } catch (IOException e) {
            System.out.println("Error de  lectura y escritura(create:UsuarioDao)");
            e.printStackTrace();

        }
        
    }

    @Override
    public void update(Telefono telefono) {
    }

    @Override
    public void delete(Telefono telefono) {
    }

    @Override
    public Collection<Telefono> findAll() {
        return null;
    }

    @Override
    public Telefono read(int codigo) {
        return null;
    }

    @Override
    public int obtenerUltimoCodigo() {
        return codigo;
    }
    
}
