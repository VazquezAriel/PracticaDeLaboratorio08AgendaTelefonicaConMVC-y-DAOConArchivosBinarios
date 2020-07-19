/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Telefono;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ariel
 */
public class TelefonoDAO implements ITelefonoDAO {

    /**
     * Tamaño del archivo:
     *
     * codigo -> 4 bytes 
     * numero -> 25 caracteres 
     * tipo -> 25 caracteres 
     * operadora -> 25 caracteres usuario 
     * cedula -> 10 caracteres
     *
     * Total -> 89 bytes + 8 bytes extras = 97 bytes por registro
     *
     */
    private RandomAccessFile archivo;
    private int codigo;
    private IUsuarioDAO usuarioDAO;

    //Constructor
    public TelefonoDAO(IUsuarioDAO usuarioDAO) {

        try {
            archivo = new RandomAccessFile("Datos/Telefonos.dat", "rw");
            codigo = (int) (archivo.length()/97);
            this.usuarioDAO = usuarioDAO;

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
        try {
            int salto = 0;

            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoArchivo = archivo.readInt();

                if (telefono.getCodigo() == codigoArchivo) {
                    archivo.writeUTF(telefono.getNumero());
                    archivo.writeUTF(telefono.getTipo());
                    archivo.writeUTF(telefono.getOperadora());
                    archivo.writeUTF(telefono.getUsuario().getCedula());
                    break;

                }
                salto += 97;

            }

        } catch (IOException e) {
            System.out.println("Error de lectura (update: TelefonoDAO)");
            e.printStackTrace();

        }
    }

    @Override
    public void delete(Telefono telefono) {
        try {
            int salto = 0;

            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoArchivo = archivo.readInt();

                if (telefono.getCodigo() == codigoArchivo) {
                    archivo.seek(salto);
                    archivo.writeInt(0);
                    archivo.writeUTF(telefono.getNumero());
                    archivo.writeUTF(telefono.getTipo());
                    archivo.writeUTF(telefono.getOperadora());
                    archivo.writeUTF(telefono.validarEspacios("", 10));
                    break;

                }
                salto += 97;

            }

        } catch (IOException e) {
            System.out.println("Error de lectura (delete: TelefonoDAO)");
            e.printStackTrace();

        }
    }

    @Override
    public List<Telefono> findAll() {
        List<Telefono> telefonos = new ArrayList<Telefono>();
        try {
            int salto = 0;

            while (salto < archivo.length()) {
                archivo.seek(salto);
                Telefono telefono = new Telefono(archivo.readInt(), archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim(), false);
                telefono.setUsuario(usuarioDAO.read(archivo.readUTF()));
                if (telefono.getCodigo() != 0) {
                   telefonos.add(telefono);
                   
                }
                salto += 97;

            }
            return telefonos;

        } catch (IOException e) {
            System.out.println("Error de lectura (findAll: TelefonoDAO)");
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public Telefono read(int codigo) {
        try {
            int salto = 0;

            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoArchivo = archivo.readInt();

                if (codigoArchivo == codigo) {
                    Telefono telefono = new Telefono(codigo, archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), false);
                    telefono.setUsuario(usuarioDAO.read(archivo.readUTF()));
                    return telefono;

                }
                salto += 97;

            }

        } catch (IOException e) {
            System.out.println("Error de lectura (read: TelefonoDAO)");
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public int obtenerUltimoCodigo() {
        return codigo;
    }

}
