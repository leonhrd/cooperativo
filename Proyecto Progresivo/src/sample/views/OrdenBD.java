package sample.views;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.CustomButtonCell1;
import sample.models.OrdenDAO;

public class OrdenBD extends Stage{
    private Scene escena;
    private TableView<OrdenDAO> tbvClientes;
    private Button btnAgregar;
    private VBox vBox;
    private OrdenDAO ordDAO;

    public OrdenBD(){
        ordDAO = new OrdenDAO();
        CrearUI();
        this.setTitle("Clientes Taqueria :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        tbvClientes = new TableView<>();
        btnAgregar = new Button("Agregar Cliente");
        btnAgregar.setOnAction(event -> {
            new OrdenFRM(tbvClientes,null);
        });
        vBox = new VBox();
        vBox.getChildren().addAll(tbvClientes,btnAgregar);
        escena = new Scene(vBox,700,250);

        CrearTabla();
    }

    private void CrearTabla() {
        TableColumn<OrdenDAO,Integer> tbcIdOrden = new TableColumn<>("ID");
        tbcIdOrden.setCellValueFactory(new PropertyValueFactory<>("cveorden"));

        TableColumn<OrdenDAO,String> tbcFecha = new TableColumn<>("FECHA");
        tbcFecha.setCellValueFactory(new PropertyValueFactory<>("fechaorden"));

        TableColumn<OrdenDAO,Double> tbcMonto = new TableColumn<>("MONTO");
        tbcMonto.setCellValueFactory(new PropertyValueFactory<>("montoorden"));

        TableColumn<OrdenDAO,Integer> tbcEmpleado = new TableColumn<>("EMPLEADO");
        tbcEmpleado.setCellValueFactory(new PropertyValueFactory<>("cveemp"));

        TableColumn<OrdenDAO,Integer> tbcDirCliente = new TableColumn<>("CLIENTE");
        tbcDirCliente.setCellValueFactory(new PropertyValueFactory<>("cvecte"));

        TableColumn<OrdenDAO,String> tbcEditar = new TableColumn<>("EDITAR");
        tbcEditar.setCellFactory(new Callback<TableColumn<OrdenDAO, String>, TableCell<OrdenDAO, String>>() {
            @Override
            public TableCell<OrdenDAO, String> call(TableColumn<OrdenDAO, String> param) {
                return new CustomButtonCell1(1);
            }
        });

        TableColumn<OrdenDAO,String> tbcBorrar = new TableColumn<>("Borrar");
        tbcBorrar.setCellFactory(new Callback<TableColumn<OrdenDAO, String>, TableCell<OrdenDAO, String>>() {
            @Override
            public TableCell<OrdenDAO, String> call(TableColumn<OrdenDAO, String> param) {
                return new CustomButtonCell1(2);
            }
        });

        tbvClientes.getColumns().addAll(tbcIdOrden,tbcFecha,tbcMonto,tbcDirCliente,tbcEditar,tbcBorrar);
        tbvClientes.setItems(ordDAO.SELECCIONAR());

    }
}
