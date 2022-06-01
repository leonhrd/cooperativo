package sample.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.OrdenDAO;

import javax.swing.*;
import java.util.ArrayList;




public class categorias extends Stage implements EventHandler {

    private OrdenDAO ObjC;
    private HBox hbox1,hbox2,hbox3;
    private VBox vbox1;

    Scene escena;
    private Button tacos;
    private Double total = 0.0;
    private Button paquetes;
    private Button refrescos,ticket,mostrarT,finord;
    public ArrayList<String> taco = new ArrayList<String>();
    public ArrayList<String> product = new ArrayList<String>();
    public ArrayList<Integer> productp = new ArrayList<Integer>();
    public ArrayList<Integer> tacuan = new ArrayList<Integer>();

    private String nombreproduct[] = {"Chorizo", "Asada", "Pastor","cocacola", "seven up", "sangría","familiar", "en pareja", "tacoman"};
    public ArrayList<Integer> tacop = new ArrayList<Integer>();




    public categorias(ArrayList<String> taco, ArrayList<Integer> tacop,ArrayList<Integer> tacuan){
        crearUI();
        this.setTitle("Categorías");
        this.setScene(escena);
        this.show();
        this.taco = taco;
        this.tacop = tacop;
        this.tacuan = tacuan;
    }
    private void crearUI(){
       hbox1=new HBox();
        hbox1.setSpacing(30);
        hbox1.setPadding(new Insets(60));
        vbox1=new VBox();
        vbox1.setSpacing(30);
        vbox1.setPadding(new Insets(60));



        Image img=new Image("sample/images/lostacosbonitos.jpg");
        ImageView imv=new ImageView(img);
        tacos=new Button();
        imv.setFitHeight(150);
        imv.setFitWidth(200);
        tacos.setGraphic(imv);





        paquetes=new Button();
        Image img1=new Image("sample/images/refresco.png");
        ImageView imv1=new ImageView(img1);
        imv1.setFitHeight(150);
        imv1.setFitWidth(200);
        paquetes.setGraphic(imv1);

        refrescos=new Button();
        Image img2=new Image("sample/images/promo.jpg");
        ImageView imv2=new ImageView(img2);
        imv2.setFitHeight(150);
        imv2.setFitWidth(200);
        refrescos.setGraphic(imv2);

        ticket = new Button("ver ticket");

        mostrarT = new Button("revisar tabla");
        finord = new Button("Finalizar orden");

        vbox1.getChildren().addAll(ticket,mostrarT,finord);



        tacos.setPrefWidth(80);
        tacos.setPrefHeight(60);
        paquetes.setPrefWidth(80);
        paquetes.setPrefHeight(60);
        refrescos.setPrefWidth(80);
        refrescos.setPrefHeight(60);
        ticket.setPrefWidth(80);
        ticket.setPrefHeight(60);
        mostrarT.setPrefHeight(60);
        mostrarT.setPrefWidth(80);
        finord.setPrefHeight(60);
        finord.setPrefWidth(80);

        hbox1.getChildren().addAll(tacos,paquetes,refrescos,vbox1);



        //tacos.setOnAction(event1 -> new tacos());
        tacos.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                new tacos(taco,tacop,tacuan);
                Stage stage = (Stage) tacos.getScene().getWindow();
                stage.close();
            }
        });
        //paquetes.setOnAction(event -> new refrescos());
        paquetes.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                new refrescos(taco,tacop,tacuan);
                Stage stage = (Stage) tacos.getScene().getWindow();
                stage.close();
            }
        });
        //refrescos.setOnAction(event -> new promos());
        refrescos.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                new promos(taco,tacop,tacuan);
                Stage stage = (Stage) tacos.getScene().getWindow();
                stage.close();
            }
        });
        ticket.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String a="",b,c;

                if(taco.isEmpty()){
                    JOptionPane.showMessageDialog(null,"No hay items en el menu");
                }else{
                    for(int i = 0; i<=taco.size()-1;i++){

                        // a += taco.get(i)+" "+tacop.get(i)+"\n";
                        if (tacop.get(i) != 0){
                            a+= taco.get(i)+" "+tacuan.get(i)+" "+tacop.get(i)+"\n";
                        }
                    }
                    for (int i = 0; i<=taco.size()-1;i++){
                        total += tacop.get(i);
                    }
                    a += "Total:---------"+total;
                    JOptionPane.showMessageDialog(null,"Orden*****Cantidad******Monto\n"+a);
                }
            }
        });
        mostrarT.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                new OrdenBD();
                Stage stage = (Stage) tacos.getScene().getWindow();
                stage.close();
            }
        });
        finord.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(taco.isEmpty()){
                    JOptionPane.showMessageDialog(null,"No hay items en el menu");
                }else{
                    ObjC = new OrdenDAO();
                    ObjC.setCveemp(1);
                    ObjC.setFechaorden("2022-05-30");
                    ObjC.setMontoorden(total);
                    ObjC.setCvecte(1);
                    ObjC.INSERTAR();
                    System.out.println("success");
                    Stage stage = (Stage) tacos.getScene().getWindow();
                    stage.close();
                }
            }
        });
        escena=new Scene(hbox1,1200,600);
    }

    @Override
    public void handle(Event event) {


    }
}
