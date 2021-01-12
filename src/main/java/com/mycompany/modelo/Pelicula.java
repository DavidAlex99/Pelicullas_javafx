/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luci
 */
public class Pelicula {
    private String nombre;
    private String urlImagen;
    private String review;
    private List<String>actores;
    
    /*public Pelicula(String nombre,String review, String urlImagen, List<String> actores) {
        this.nombre = nombre;
        this.review=review;
        this.urlImagen = urlImagen;
        this.actores = actores;
    }*/

    public Pelicula(String nombre, String urlImagen, String review) {
        this.nombre = nombre;
        this.urlImagen = urlImagen;
        this.review = review;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public void setActores(ArrayList<String> actores) {
        this.actores = actores;
    }

    public String getReview() {
        return review;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "nombre=" + nombre + ", urlImagen=" + urlImagen + ", review=" + review + ", actores=" + actores + '}';
    }
    
     
    
    
    
}
