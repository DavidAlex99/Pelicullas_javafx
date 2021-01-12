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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author alexx
 */
public class PanePeliculasGenero {
    //4. COMO SE DIJO, ESTA CLASE VA A ASER APARTE PARA NO SOBRECARGAR LA CLASE CONTROLADOR ONIENDO LOS ELENTOS EN EL HBX
    private HBox hboxPeliculas;
    private ImageView imgPelicula;
    private Label lblPelicula;

    public PanePeliculasGenero(HBox hboxPeliculas, ImageView imgPelicula, Label lblPelicula) {
        this.hboxPeliculas = hboxPeliculas;
        this.imgPelicula = imgPelicula;
        this.lblPelicula  = lblPelicula;
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
            ////////////////////////////////////////////////////////////////////////
            //9.1   EL OPERADOR LABDA ANTERIOR UE SOLO UNNA MUESTRA, LO QUE NOS INTERESA ES QUE NOS MUESTRE LA PELICULA Y NOS APOYAMOS 
            //DEL METODO QUE ACABMAOS DE CREAR ANTERIORMENTE PASANDOLE COMO PARAMETRO p QUE SURGE DEL FOR
            b.setOnAction((ActionEvent e) -> mostrarPelicula(p));
            //////////////////////////////////////
            paneGenero.getChildren().add(b);
            //////////////////////////////////////////////////////////////////////////////////////////////////
            //8.2 ENTONCES AUI MANEJAMOS LA ACCION, QUE HACE QUE SE COMPORTE LA ACCION CUANDO SE REVIBE UN CLICK, TAL MANERA QUE LLAME
            //A LA INSTANCIA MANEJAOR EVENTO
            //b.setOnAction(new ManejadorEvento());
            
            //////////////////////////////////////////////////////////////////////////////////////////////////
            // 8.3 en esta ocasion vamos a usar una expresio lambda elcual simplifica EL METODO EN VEZ DE ESTAR LLAMANDO
            // UN A  INSTANCIA  DELA  CLASE EVENTHANDLER, APROVECHANDONOS DE QUE ES UNA INTERFAZZ FUNCIONAL (CONTIENE METODOS ABSTRACTOS)
            //b.setOnAction(e -> System.out.println("Dio Click"));
            //////////////////////////////////////////////
            
            
        }
        
    }
    
    //8. ESTA CALSE ES A QUE SE UTILIZARA PAR PODER PONER EL METODO QUE SE HARA DE FORMA MANUAL. TIENE QUEIMPLEMENTAR DE 
    // EVENTHANDLER. EL METODO DE FORMA MANUA ES LO QUE HARA QUE APAREZA LAS IMAGENES RESPECTIV=AS DE ACUERDO A LOS BOTOES QUE
    //VAYAMOS PULSANDO
    /*class ManejadorEvento implements EventHandler<ActionEvent>{

        @Override
         public void handle(ActionEvent e) {
            System.out.println("Dio Click");
            //8.1 PERO LO QUE NOS INTERESA ES EL COMPORTAMIEND=TO DEL BOTON, QU CUANDO SE CLA=ICK TATAT, POR ELLOS VAMOS A HACER
            
        }
        
    }*/
    
    //9.  VMAOS A CREAR AL METODO QUE NOS PERMITA MOSTRAR LA IMAGEN DE LA ELICULA Y LA RESENA DE ESTA
    //CON ESTO VAMOS A MANEJAR EL IMAGEVIEW
    public void mostrarPelicula(Pelicula p){
        // 9.2 AHORA RELLENAMOS EL IMAGEVIEW HACIENDO EL METODO SETIMAGE Y ADJUNTANDO LA RUTA DE LA IMAGEN
        this.imgPelicula.setImage(new Image(App.pathimages + p.getUrlImagen()));
        // 9.3 AHORA RELLENAMOS EL REVIEW
        this.lblPelicula.setText(p.getReview());
        
    }
}
