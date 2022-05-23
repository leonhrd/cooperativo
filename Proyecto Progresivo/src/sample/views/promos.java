package sample.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class promos extends Stage implements EventHandler {


    private VBox vbox1;
    private HBox hbox1;
    Scene escena;
    private GridPane gdpMenu;
    private Button btnChorizo, btnCabeza, btnPastor;
    private Button[][] arBtnpromos = new Button[1][3];
    private String nombrePromos[] = {"familiar", "en pareja", "tacoman"};

    private Image imagenCabeza;
    private ImageView imvCabeza;

    public promos() {
        crearUI();
        this.setTitle("tacos");
        this.setScene(escena);
        this.show();
    }

    private void crearUI() {


        gdpMenu = new GridPane();
        crearMenu();
        //  imagenCabeza=new Image("sample/images/cabeza.jpg");
        //   imvCabeza=new Image(imagenCabeza);
        hbox1 = new HBox();
        hbox1.getChildren().add(gdpMenu);
        vbox1 = new VBox();
        vbox1.getChildren().add(hbox1);
        escena = new Scene(vbox1,400,600);
    }


    private void crearMenu() {
        int p = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {

            /*   Image imagenCabeza=new Image("sample/images/cabeza.jpg");
               ImageView imvCabeza=new ImageView(imagenCabeza);
                imvCabeza.setFitHeight(90);
                imvCabeza.setFitWidth(80);*/
                arBtnpromos[j][i] = new Button();
                arBtnpromos[j][i].setText(nombrePromos[p]);
                arBtnpromos[j][i].setId(nombrePromos[p]);
                //arBtnTacos[j][i].setGraphic(imvCabeza);
                gdpMenu.add( arBtnpromos[j][i], i, j);

                p++;

            }
        }




       /* imagenCabeza = new Image("sample/images/cabeza.jpg");
        imvCabeza = new ImageView(imagenCabeza);
        imvCabeza.setFitWidth(90);
     */
        //btnCabeza.setGraphic(imvCabeza);


        //  Image imgCartP = new Image("sample/images/"+arImagenes[2]);
        // ImageView imv = new ImageView(imgCartP);
        //imv.setFitHeight(60);
        //imv.setFitWidth(50);
        //arBtnPlantilla[j][i] = new Button();
        //arBtnPlantilla[j][i].setGraphic(imv);
        //gdpPlantilla.add(arBtnPlantilla[j][i],i,j);


    }


    @Override
    public void handle(Event event) {


    }
}
