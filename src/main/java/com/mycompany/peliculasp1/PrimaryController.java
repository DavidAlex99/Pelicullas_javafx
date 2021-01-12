package com.mycompany.peliculasp1;

import com.mycompany.modelo.Pelicula;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PrimaryController {
    public static HashMap<String, ArrayList<Pelicula>> peliculasGenero = new HashMap<>();
    //4. ANADIMOS LOS ATRIBUTOS QUE SE HIZO EN EL SCENEBUILDER
    //  NO OLVIDAR ETIQUETS FXML PARA QUE RECONOZCA EL SCENEUILDER
    @FXML
    private HBox hboxPeliculas;
    @FXML
    private ImageView imgPelicula;
    @FXML
    private Label lblPelicula;
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    
    public PrimaryController(){
        leerArchivospeliculas();
    }
    
    @FXML
    private void initialize(){
        //6 
        new PanePeliculasGenero(hboxPeliculas).crearPanelesGenero();
}
    public static void leerArchivospeliculas(){
        
        try {
            List<String> lineas = Files.readAllLines(Paths.get(App.pathpeliculas));
            lineas.remove(0);
            for(String l:lineas){
                String[] separado = l.split(";");
                Pelicula p = new Pelicula(separado[1], separado[4], separado[3]);
                //3. AHORA HAEMMOS EL PUT IF ABSENT
                //TAL COMO SEHA DICHO, UEREMS QUE EL KEY SEA EL TIPO DE GENERO Y EL VALUE SEA UN ARRAYLIST CON LAS PELICULAS
                //PERTENCEIENTES 
                peliculasGenero.putIfAbsent(separado[0], new ArrayList<Pelicula>());
                //3.1 GET ARASEPARADO QUE ENCEUNTRA EN LA  POSICON 0 Y CON ESA CLAVE SE ANADE LA PELICUA
                peliculasGenero.get(separado[0]).add(p); 
            
            /*FileReader entrada  = new FileReader(App.pathpeliculas);
            //C:\Users\alexx\Documents\NetBeansProjects JavaFX\PeliculasP1\src\main\resources\com\mycompany\files\peliculas.csv
            BufferedReader mibuffer = new BufferedReader(entrada);
            String linea = ""; 
            while(linea != null){
                linea = mibuffer.readLine();
                if(linea!=null){
                    String[] temporal = linea.split(";");
                    System.out.println(temporal[1]);
                    //2.1 HACEMOS EL READLINE Y LO GUARDAMOS A LA LISTA TEMPORAL Y LLAMAMOS AL COSTRRUCTOR
                    Pelicula p = new Pelicula(temporal[1], temporal[4], temporal[3]);
                    peliculasGenero.putIfAbsent(temporal[0], new ArrayList<Pelicula>());
                    peliculasGenero.get(temporal[0]).add(p);*/                
            }
            System.out.println(peliculasGenero);
        } catch (IOException ex) {
            System.out.println(ex + "no se encuentra");
        }
}
}