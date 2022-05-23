package sample.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class categorias extends Stage implements EventHandler {


    private VBox vbox1;
    Scene escena;
    private Button tacos;
    private Button paquetes;
    private Button refrescos;

    public categorias(){
        crearUI();
        this.setTitle("Categorías");
        this.setScene(escena);
        this.show();
    }
    private void crearUI(){

        vbox1=new VBox();
        vbox1.setSpacing(30);
        vbox1.setPadding(new Insets(60));
        tacos=new Button("tacos");
        paquetes=new Button("refrescos");
        refrescos=new Button("promos");

        tacos.setPrefWidth(80);
        tacos.setPrefHeight(60);
        paquetes.setPrefWidth(80);
        paquetes.setPrefHeight(60);
        refrescos.setPrefWidth(80);
        refrescos.setPrefHeight(60);


        vbox1.getChildren().addAll(tacos,paquetes,refrescos);
        tacos.setOnAction(event1 -> new tacos());
        paquetes.setOnAction(event -> new refrescos());
        refrescos.setOnAction(event -> new promos());
        escena=new Scene(vbox1,400,600);
    }

    @Override
    public void handle(Event event) {


    }
}
