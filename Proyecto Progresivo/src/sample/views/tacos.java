package sample.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class tacos extends Stage implements EventHandler {


    private VBox vbox1;
    private HBox hbox1,hbox2;
    Scene escena;
    private GridPane gdpMenu;
    private Button btnChorizo, btnCabeza, btnPastor, btnSaveOrden;
    private Button[][] arBtnTacos = new Button[1][3];
    private String nombreTacos[] = {"Chorizo", "Asada", "Pastor"};
    private Integer precioTacos[] = {25, 30, 40};
    public ArrayList<String> taco = new ArrayList<String>();
    public ArrayList<Integer> tacop = new ArrayList<Integer>();
    public ArrayList<Integer> tacuan = new ArrayList<Integer>();
    public int cb=0;
    private Image imagenCabeza;
    private ImageView imvCabeza;

    public tacos(ArrayList<String> taco, ArrayList<Integer> tacop,ArrayList<Integer> tacuan) {
        crearUI();
        this.setTitle("tacos");
        this.setScene(escena);
        this.show();
        this.taco = taco;
        this.tacop = tacop;
        this.tacuan = tacuan;
    }

    private void crearUI() {


        gdpMenu = new GridPane();
        crearMenu();
        //  imagenCabeza=new Image("sample/images/cabeza.jpg");
        //   imvCabeza=new Image(imagenCabeza);
        hbox1 = new HBox();
        hbox1.setSpacing(6);
        hbox1.getChildren().add(gdpMenu);
        vbox1 = new VBox();
        vbox1.setPadding(new Insets(50));
        vbox1.setSpacing(300);

        hbox2=new HBox();
        btnSaveOrden=new Button();
        btnSaveOrden.setText("Registrar Orden");
        btnSaveOrden.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                new categorias(taco,tacop,tacuan);
                Stage stage = (Stage) btnSaveOrden.getScene().getWindow();
                stage.close();
            }
        });
        hbox2.getChildren().add(btnSaveOrden);

        vbox1.getChildren().addAll(hbox1,hbox2);



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
                arBtnTacos[j][i] = new Button();
                arBtnTacos[j][i].setText(nombreTacos[p]);
                arBtnTacos[j][i].setId(nombreTacos[p]);
                arBtnTacos[j][i].setPrefHeight(70);
                arBtnTacos[j][i].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                       // taco.add(nombreTacos[cb]);
                        for (int r = 0; r < 4; r++) {
                                if (event.getSource() == arBtnTacos[0][r]) {
                                    //System.out.println(nombreTacos[r]);
                                    //taco.add(nombreTacos[r]);
                                    //tacop.add(precioTacos[r]);
                                    for (int i = 0; i< taco.size();i++) {
                                        if(taco.get(i)==nombreTacos[r]){
                                            tacop.set(i,tacop.get(i)+precioTacos[r]);
                                            tacuan.set(i,tacuan.get(i)+1);
                                        }
                                    }
                                    break;
                                }
                        }
                    }
                });
                //arBtnTacos[j][i].setGraphic(imvCabeza);
                gdpMenu.add(arBtnTacos[j][i], i, j);
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
