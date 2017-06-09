package com.jcsoluciones.appvalle.models;

/**
 * Created by root on 1/06/17.
 */

public class Servicios {
    private String direccion;
    private String sitioweb;
    private String correo;
    private String telefono;
    private String celular;

    public Servicios() {
    }

    public Servicios(String direccion, String sitioweb, String correo, String telefono, String celular) {
        this.direccion = direccion;
        this.sitioweb = sitioweb;
        this.correo = correo;
        this.telefono = telefono;
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSitioweb() {
        return sitioweb;
    }

    public void setSitioweb(String sitioweb) {
        this.sitioweb = sitioweb;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
