package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sample.componentes.Corredor;
import sample.models.Conexion;
import sample.views.*;

import java.util.ArrayList;

public class Main extends Application implements EventHandler{

    private MenuBar mnbPrincipal;
    private Menu menCompetencia1, menCompetencia2;
    private MenuItem mitLoteria, mitParseador, mitClientes,mitPista, mitCategorias;
    private VBox vBox;
    public ArrayList<String> taco = new ArrayList<String>();
    public ArrayList<Integer> tacop = new ArrayList<Integer>();
    public ArrayList<Integer> tacuan = new ArrayList<Integer>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        vBox = new VBox();
        mnbPrincipal = new MenuBar();
        menCompetencia1 = new Menu("Competencia 1");
        menCompetencia2 = new Menu("Competencia 2");
        mnbPrincipal.getMenus().addAll(menCompetencia1,menCompetencia2);

        mitLoteria = new MenuItem("Loteria");
        mitLoteria.setOnAction(event -> Eventos(1));
        mitParseador = new MenuItem("Código Morse");
        mitParseador.setOnAction(event -> Eventos(2));
        mitClientes = new MenuItem("Taqueria");
        mitClientes.setOnAction(event -> Eventos(3));
        mitCategorias=new MenuItem("Categorías");
        mitCategorias.setOnAction(event -> Eventos(5));
    menCompetencia1.getItems().addAll(mitLoteria,mitParseador,mitClientes, mitCategorias);

        mitPista=new MenuItem("Pista de carreras");
        mitPista.setOnAction(event -> Eventos(4));
        menCompetencia2.getItems().add(mitPista);
        vBox.getChildren().add(mnbPrincipal);

        primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWING,this);
        primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Bienvenidos :)");
                alerta.setHeaderText("Mensaje del Sistema :)");
                alerta.setContentText("Manejo de eventos de la ventana usando dialogos");
                alerta.showAndWait();
            }
        });

        Scene escena = new Scene(vBox,300,200);
        escena.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(escena);
        primaryStage.show();
        primaryStage.setMaximized(true);

        // Abrir la conexion a la base de datos de manera global
        Conexion.crearConexion();


    }

    private void Eventos(int i) {
        switch(i){
            case 1: new Loteria(); break;
            case 2: new Parseador(); break;
            case 3: new ClientesBD(); break;
            case 4: new pista(); break;
            //"Chorizo", "Asada", "Pastor","cocacola", "seven up", "sangría","familiar", "en pareja", "tacoman"
            case 5:
                taco.clear();
                taco.add("Chorizo");
                taco.add("Asada");
                taco.add("Pastor");
                taco.add("cocacola");
                taco.add("seven up");
                taco.add("sangría");
                taco.add("familiar");
                taco.add("en pareja");
                taco.add("tacoman");

                tacop.clear();
                tacop.add(0);
                tacop.add(0);
                tacop.add(0);
                tacop.add(0);
                tacop.add(0);
                tacop.add(0);
                tacop.add(0);
                tacop.add(0);
                tacop.add(0);

                tacuan.clear();
                tacuan.add(0);
                tacuan.add(0);
                tacuan.add(0);
                tacuan.add(0);
                tacuan.add(0);
                tacuan.add(0);
                tacuan.add(0);
                tacuan.add(0);
                tacuan.add(0);
                new categorias(taco,tacop,tacuan);
                break;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Bienvenidos :)");
        alerta.setHeaderText("Mensaje del Sistema :)");
        alerta.setContentText("Manejo de eventos de la ventana usando dialogos");
        alerta.showAndWait();
    }
}
