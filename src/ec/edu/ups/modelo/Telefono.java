/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Objects;

/**
 *
 * @author ariel
 */
public class Telefono {
    
    //Atributos
    private int codigo;
    private String numero;
    private String tipo;
    private String operadora;
    private Usuario usuario;

    //Constructor sin parametros
    public Telefono() {
        
    }

    //Constructor con parametros
    public Telefono(int codigo, String numero, String tipo, String operadora) {
        this.codigo = codigo;
        this.numero = validarEspacios(numero, 25);
        this.tipo = validarEspacios(tipo, 25);
        this.operadora = validarEspacios(operadora, 25);
    }

    //Metodos Get y Set
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String validarEspacios(String cadena, int longitud) {
        if (cadena.length() == longitud) {
            return cadena;
            
        } else {
            if (cadena.length() < longitud) {
                return llenarEspacios(cadena, longitud);
                
            } else {
                return cortarEspacios(cadena, longitud);
                
            }
        }
    }
    
    public String llenarEspacios(String cadena, int longitud) {
        return String.format("%-"+longitud+"s", cadena);
        
    }
    
    public String cortarEspacios(String cadena, int longitud) {
        return cadena.substring(0, longitud);
        
    }

    //Metodos de la clase Object
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefono other = (Telefono) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telefono{" + "codigo=" + codigo + ", numero=" + numero + ", tipo=" + tipo + ", operadora=" + operadora + '}';
    }
   
}