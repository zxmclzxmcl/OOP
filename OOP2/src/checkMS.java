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

public class checkMS implements Initializable{

    @FXML
    private Label totalM;

    @FXML
    void btnback(ActionEvent event) throws IOException{
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
            if(person.getLoaict() == "mẫu"){
                n++;
            }
            totalM.setText(n + " Sinh viên");
        }
    }

}