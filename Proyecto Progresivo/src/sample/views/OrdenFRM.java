package sample.views;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.OrdenDAO;

import java.time.LocalDate;

public class OrdenFRM extends Stage{
    private VBox vBox;
    private Spinner<Double> spin;
    //private TextField txtFecha, txtPrecio;
    public DatePicker datefecha;
    // private TextField txtPrecio;
    private Button btnGuardar;
    private Scene escena;
    private OrdenDAO objC;
    private TableView<OrdenDAO> tbvClientes;
    public double valor=0;

    public OrdenFRM(TableView<OrdenDAO> tbv,OrdenDAO objC){
        this.objC = ( objC == null ) ? new OrdenDAO() : objC;
        this.tbvClientes = tbv;
        CrearUI();
        this.setTitle("Agregar Cliente");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));
        /*txtFecha = new TextField();
        txtFecha.setText(this.objC.getFechaorden());
        txtFecha.setPromptText("Fecha");*/
        //txtPrecio = new TextField();
        datefecha = new DatePicker();
        datefecha.setValue(LocalDate.now());
        /*txtPrecio.setText(String.valueOf(this.objC.getMontoorden()));
        txtPrecio.setPromptText("Precio de la orden");*/
        spin = new Spinner<>();
        valor = this.objC.getMontoorden();

        SpinnerValueFactory<Double> valueF = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,99999);
        valueF.setValue(valor);
        spin.setValueFactory(valueF);
        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> {
            //objC.setFechaorden(txtFecha.getText());
            objC.setFechaorden(String.valueOf(datefecha.getValue()));
            //objC.setMontoorden(Double.valueOf(txtPrecio.getText()));
            valor = spin.getValue();
            objC.setMontoorden(valor);
            if(objC.getCvecte()>0)
                objC.ACTUALIZAR();
            else
                objC.INSERTAR();

            tbvClientes.setItems(objC.SELECCIONAR());
            tbvClientes.refresh();

            this.close();
        });
        vBox.getChildren().addAll(datefecha,spin,btnGuardar);
        escena = new Scene(vBox,205,200);
    }
}