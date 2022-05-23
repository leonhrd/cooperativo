package sample.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.componentes.Corredor;

public class pista extends Stage {
    private String[] arNombres = {"Leo", "Batman", "Arthur", "Joel", "Dracula", "Potterhead", "Samus", "Jefazo", "Clairo", "Cortana"};
    private Scene escena;
    private VBox vBox;
    private Button btnIniciar;
    private ProgressBar[] pgbCarriles = new ProgressBar[10];  //un progress bar por cada corredor
    private Corredor[] thrCorredores = new Corredor[arNombres.length]; //un hilo por cada progress bar


    public pista() {
        CrearUI();//Crea la interfaz //USER INTERFACE
        this.setTitle("Pista de atletismo");
        this.setScene(escena);
        this.show();

    }

    private void CrearUI() {
        vBox = new VBox();
        //arnombres.length determina el número de corredores basandose en el arreglo <ArNombres>
        for (int i = 0; i < arNombres.length; i++) {
            pgbCarriles[i] = new ProgressBar(0);
            thrCorredores[i] = new Corredor(arNombres[i], pgbCarriles[i]);
            vBox.getChildren().add(pgbCarriles[i]);

        }
        escena = new Scene(vBox, 300, 300);
        btnIniciar = new Button("iniciar");
        btnIniciar.setOnAction(event -> {
            for (int i = 0; i < arNombres.length; i++) {
                thrCorredores[i].start();
            }
        });

        vBox.getChildren().add(btnIniciar);
    }
}
