package sample.views;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.OrdenDAO;
public class OrdenFRM extends Stage{
    private VBox vBox;
    private TextField txtFecha, txtPrecio;
    private Button btnGuardar;
    private Scene escena;
    private OrdenDAO objC;
    private TableView<OrdenDAO> tbvClientes;

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
        txtFecha = new TextField();
        txtFecha.setText(this.objC.getFechaorden());
        txtFecha.setPromptText("Fecha");
        txtPrecio = new TextField();
        txtPrecio.setText(String.valueOf(this.objC.getMontoorden()));
        txtPrecio.setPromptText("Precio de la orden");
        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> {
            objC.setFechaorden(txtFecha.getText());
            objC.setMontoorden(Double.valueOf(txtPrecio.getText()));
            if(objC.getCvecte()>0)
                objC.ACTUALIZAR();
            else
                objC.INSERTAR();

            tbvClientes.setItems(objC.SELECCIONAR());
            tbvClientes.refresh();

            this.close();
        });
        vBox.getChildren().addAll(txtFecha,txtPrecio,btnGuardar);
        escena = new Scene(vBox,205,200);
    }
}
