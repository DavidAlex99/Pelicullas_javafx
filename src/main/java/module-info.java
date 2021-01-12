module com.mycompany.peliculasp1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.peliculasp1 to javafx.fxml;
    exports com.mycompany.peliculasp1;
}