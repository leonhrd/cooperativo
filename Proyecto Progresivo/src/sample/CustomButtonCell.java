package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import sample.models.ClientesDAO;
import sample.views.ClienteFRM;

public class CustomButtonCell extends TableCell<ClientesDAO, String> {
    int opc;
    private Button btnCelda;
    private ClientesDAO objC;

    public CustomButtonCell(int opc) {
        this.opc = opc;
        if (opc == 1)
            btnCelda = new Button("Editar");
        else
            btnCelda = new Button("Borrar");
        btnCelda.setOnAction(event -> eventoBoton(opc));
    }

    private void eventoBoton(int opc) {
        objC = CustomButtonCell.this.getTableView().getItems().get(CustomButtonCell.this.getIndex());
        switch (opc) {
            case 1:
                new ClienteFRM(CustomButtonCell.this.getTableView(), objC);
                break;
            case 2:
                objC.ELIMINAR();
                CustomButtonCell.this.getTableView().setItems(objC.SELECCIONAR());
                CustomButtonCell.this.getTableView().refresh();

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
