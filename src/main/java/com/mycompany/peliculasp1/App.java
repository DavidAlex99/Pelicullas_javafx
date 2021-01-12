package com.mycompany.peliculasp1;

import com.mycompany.modelo.Pelicula;
import java.io.BufferedReader;
import java.io.FileReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static String pathpeliculas = "src/main/resources/com/mycompany/files/peliculas.csv";
    //9.4 NO OLVIDAR QUE EN EL APP SE PONE LOS DIRECTORIOS
    public static String pathimages = "src/main/resources/com/mycompany/files/";
    
    //1. 
    
    
    
    //2.s
    /*public static void leerArchivospeliculas(){
        try {
            FileReader entrada  = new FileReader("C:/Users/alexx/Documents/NetBeansProjects JavaFX/PeliculasP1/src/main/resources/com/mmycompany/files/peliculas.csv");
            //C:\Users\alexx\Documents\NetBeansProjects JavaFX\PeliculasP1\src\main\resources\com\mycompany\files\peliculas.csv
            BufferedReader mibuffer = new BufferedReader(entrada);
            String linea = ""; 
            while(linea != null){
                linea = mibuffer.readLine();
                if(linea!=null){
                    String[] temporal = linea.split(";");
                    //2.1 HACEMOS EL READLINE Y LO GUARDAMOS A LA LISTA TEMPORAL Y LLAMAMOS AL COSTRRUCTOR
                    Pelicula p = new Pelicula(temporal[1], temporal[4], temporal[3]);
                    peliculasGenero.putIfAbsent(temporal[0], new ArrayList<Pelicula>());
                    peliculasGenero.get(temporal[0]).add(p);    
                }
            }*/
                
            
            /*
            List<String> lineas = Files.readAllLines(Paths.get("C:/Users/alexx/Documents/NetBeansProjects JavaFX/PeliculasP1/src/main/resources/com/mycompany/files/peliculas.csv"));
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
            }*/
            
                
            
        /*} catch (IOException ex) {
            System.out.println(ex + "no se encuentra");
        }
}*/
    

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        //2.3 ua peque;a prueba de que corre lo hacmos antes dl launch
        
        
        launch();
        
    }

}