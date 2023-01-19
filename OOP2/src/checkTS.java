//package Controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class checkTS implements Initializable {

    @FXML
    private Label totalT;

    @FXML
    void btnback(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }

    public void getInfo(ObservableList<Sinhvien> tongList){
        Sinhvien person = new Sinhvien();
        int n=0;
        for(int i=0; i<tongList.size(); i++){
            person = tongList.get(i);
            if(person.getLoaict() == "tín chỉ"){
                n++;
            }
            totalT.setText(n + " Sinh viên");
        }
    }

}