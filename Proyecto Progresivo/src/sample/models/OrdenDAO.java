package sample.models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdenDAO {
    private int cveorden;
    private int cveemp;
    private int cvecte;
    private double montoorden;
    private String fechaorden;

    public int getCveorden() {
        return cveorden;
    }

    public void setCveorden(int cveorden) {
        this.cveorden = cveorden;
    }

    public int getCveemp() {
        return cveemp;
    }

    public void setCveemp(int cveemp) {
        this.cveemp = cveemp;
    }

    public int getCvecte() {
        return cvecte;
    }

    public void setCvecte(int cvecte) {
        this.cvecte = cvecte;
    }

    public double getMontoorden() {
        return montoorden;
    }

    public void setMontoorden(double montoorden) {
        this.montoorden = montoorden;
    }

    public String getFechaorden() {
        return fechaorden;
    }

    public void setFechaorden(String fechaorden) {
        this.fechaorden = fechaorden;
    }

    public void INSERTAR(){
        String query = "INSERT INTO tblordenes (fechaorden, montoorden, cveemp, cvecte) VALUES('"+this.fechaorden+"',"+this.montoorden+","+this.cveemp+","+this.cvecte+")";
        try {
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ACTUALIZAR(){
        String query = "UPDATE tblordenes SET fechaorden='"+this.fechaorden+"',montoorden="+this.montoorden+"," +
                "cveemp="+this.cveemp+" ,cvecte= "+this.cvecte+" WHERE cveorden = "+this.cveorden;
        try {
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ELIMINAR(){
        String query = "DELETE FROM tblordenes WHERE cveorden = "+this.cveorden;
        try {
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ObservableList<OrdenDAO> SELECCIONAR(){

        ObservableList<OrdenDAO> listaC = FXCollections.observableArrayList();
        OrdenDAO objC;
        String query = "SELECT * FROM tblordenes ORDER BY cveorden";
        try {
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while( res.next() ){
                objC = new OrdenDAO();
                /*objC.setCvecte(res.getInt("cvecte"));
                objC.setNomcte(res.getString("nomcte"));
                objC.setTelcte(res.getString("telcte"));
                objC.setDircte(res.getString("dircte"));*/
                objC.setCvecte(res.getInt("cvecte"));
                objC.setCveemp(res.getInt("cveemp"));
                objC.setCveorden(res.getInt("cveorden"));
                objC.setMontoorden(res.getDouble("montoorden"));
                objC.setFechaorden(res.getString("fechaorden"));
                listaC.add(objC);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaC;

    } // RECUPERAR TODOS LOS REGISTROS

    public void SELECCIONARBYID(){}
}
