//package Controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.*;
public class secondScene implements Initializable {
    Stage window;
    Scene scene;
    
    @FXML
    private TableColumn<Sinhvien, String> hovatencol;

    @FXML
    private TableColumn<Sinhvien, String> kieucol;

    @FXML
    private TableColumn<Sinhvien, Integer> mssvcol;

    @FXML
    private TableView<Sinhvien> table2;

    private ObservableList<Sinhvien> tinchiList;
    private ObservableList<Sinhvien> tList;
    
    @FXML
    void back(ActionEvent event) throws IOException{
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        tinchiList = FXCollections.observableArrayList();
        tList = FXCollections.observableArrayList();
        hovatencol.setCellValueFactory(new PropertyValueFactory<Sinhvien, String>("tensv"));
        mssvcol.setCellValueFactory(new PropertyValueFactory<Sinhvien, Integer>("mssv"));
        kieucol.setCellValueFactory(new PropertyValueFactory<Sinhvien, String>("loaict"));
        table2.setItems(tinchiList);
    }

    public void getInfo(ObservableList<Sinhvien> svList){
        int i = 0;
        int m = 1;
        Sinhvien person1 = new Sinhvien();
        Sinhvien person2 = new Sinhvien();
        Sinhvien person3 = new Sinhvien();
        while (m>0){
            for(int a=0; a<svList.size();a++){
                person1 = svList.get(a);
                if(person1.getLoaict() == "tín chỉ"){
                    tList.add(person1);
                }
            }
            //System.out.println(person1.getKhoa());
            m--;
        }
        int z=tList.size();
        while(z>0){
            person1 = tList.get(i);
            for(int a= i+1; a<tList.size();a++){
                person2 = tList.get(a);
                if(person2.getMssv() == person1.getMssv()){
                    person1 = tList.get(a);
                }
                
            }
            if(tinchiList.size()==0){
                tinchiList.add(person1);
            }
            else if(tinchiList.size()!=0){
                tinchiList.add(person1);
                for(int b=0; b<tinchiList.size()-1;b++){
                    person3 = tinchiList.get(b);
                    if(person1.getMssv()==person3.getMssv()){
                        tinchiList.remove(person1);
                    }
                }
            }
            i=i+1;
            z--;
        }
        tinchiList.sorted();
    }
}
