package sample;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.models.ClientesDAO;
import sample.models.OrdenDAO;
import sample.views.OrdenFRM;
public class CustomButtonCell1 extends TableCell<OrdenDAO,String> {
    int opc;
    private Button btnCelda;
    private OrdenDAO objC;

    public CustomButtonCell1(int opc) {
        this.opc = opc;
        if (opc == 1)
            btnCelda = new Button("Editar");
        else
            btnCelda = new Button("Borrar");
        btnCelda.setOnAction(event -> eventoBoton(opc));
    }

    private void eventoBoton(int opc) {
        objC = CustomButtonCell1.this.getTableView().getItems().get(CustomButtonCell1.this.getIndex());
        switch (opc) {
            case 1:
                new OrdenFRM(CustomButtonCell1.this.getTableView(), objC);
                break;
            case 2:
                objC.ELIMINAR();
                CustomButtonCell1.this.getTableView().setItems(objC.SELECCIONAR());
                CustomButtonCell1.this.getTableView().refresh();

        }
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            this.setGraphic(btnCelda);
        }
    }
}
