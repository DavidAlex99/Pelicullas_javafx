/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.peliculasp1;

import com.mycompany.modelo.Pelicula;
import javafx.scene.layout.HBox;
import com.mycompany.peliculasp1.App;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author alexx
 */
public class PanePeliculasGenero {
    //4. COMO SE DIJO, ESTA CLASE VA A ASER APARTE PARA NO SOBRECARGAR LA CLASE CONTROLADOR ONIENDO LOS ELENTOS EN EL HBX
    private HBox hboxPeliculas;

    public PanePeliculasGenero(HBox hboxPeliculas) {
        this.hboxPeliculas = hboxPeliculas;
    }
    
    //5. ESTE METODO VA A CREAR LOS PANELES POR GENERO, QUE E ESTE CASO VAN A SER VBOV EN EL HBOX
    // ECORREMOS EL MAPA
    public void crearPanelesGenero(){
        //5.1 AL IGUAL QUE EN PYTHON, SE RECORRIA UN DICCIONARIO CON UN FAOR DEPENDEIDO DE UN LLAVE Y CO ELLO SACANDO EL VALOR
        //5.2 COMO EL TIPO DE VALOR ES UN STRING
        for(String genero: PrimaryController.peliculasGenero.keySet()){
            //AHORA PPOR CADA CLAVE SE VA A AHCER UN VBOX DE ORMA MANUAL
            VBox paneGenero = new VBox();
            //5.4 AHORA DENTRO DE ESE VBOX SE VAN A PONER LOS LABELS
            Label lblGenero = new Label(genero);
            paneGenero.setSpacing(10);
            paneGenero.getChildren().add(lblGenero);
            
            //5.5 AHORA DE LA MAISMA MANERA SE LE AGREGA AL ODO ROOT SDE ESTA OPERACION EL HBOX
            hboxPeliculas.getChildren().add(paneGenero);  
            
            //7.3 AHORA COMO SABEMOS QUE LOS BOTONES VA EN EL VBOX Y QUE SE LO ANADIO EN EL METODO CREARBOTONES, SE 
            // LO LLAMA EL METODO EN ESTE METODO YA QUE OBIVMANTE ESTE METODO CREAR E PANEL DE GENERO CON SUS PELICULAS
            // POR ENDE LLAMAMOS AL METODO CREARBOTONES CON PARAMETROS DE METER LA LLAVE PARA U =E NOS DEVUELVA EL VALOR DE
            //SUCONTENIDO QUE E ESTE CASO ES EL ARRAYLIST DE LAS PELICULAS QUE PERTENEEN A ESA GENERO JUNTO CON EL VBOX
            crearBotones(PrimaryController.peliculasGenero.get(genero), paneGenero);
            
        }
    }
    
    
    //7. AHORA VAMOS A CREAR LOS BOTONES
    public void crearBotones(ArrayList<Pelicula> peliculas, VBox paneGenero){
        for(Pelicula p:peliculas){
            //7.2 CREAMOS LOS BTONES LOS CUALES CONTENRAN LOS TITULOS DE LAS PELICULAS
            // NO OLVIDARSE QUE ESTOS VA COMO HIJO DEL PANEGENERO, PUES DEBAJO DE ADA LEBAEL QUE TIENE EL NOMBRE DEL GENERO
            // VAN LAS PELCULAS DE ESE GENERO
            Button b = new Button(p.getNombre());
            paneGenero.getChildren().add(b);
            
            
        }
        
    }
    
    
}
