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
public class thirdScene implements Initializable {
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

    private ObservableList<Sinhvien> mauList;
    private ObservableList<Sinhvien> mList;
    
    @FXML
    void back(ActionEvent event) throws IOException{
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        mauList = FXCollections.observableArrayList();
        mList = FXCollections.observableArrayList();
        hovatencol.setCellValueFactory(new PropertyValueFactory<Sinhvien, String>("tensv"));
        mssvcol.setCellValueFactory(new PropertyValueFactory<Sinhvien, Integer>("mssv"));
        kieucol.setCellValueFactory(new PropertyValueFactory<Sinhvien, String>("loaict"));
        table2.setItems(mauList);
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
                if(person1.getLoaict() == "mẫu"){
                    mList.add(person1);
                }
            }
            m--;
        }
        int z=mList.size();
        while(z>0){
            person1 = mList.get(i);
            for(int a= i+1; a<mList.size();a++){
                person2 = mList.get(a);
                if(person2.getMssv() == person1.getMssv()){
                    person1 = mList.get(a);
                }
                
            }
            if(mauList.size()==0){
                mauList.add(person1);
            }
            else if(mauList.size()!=0){
                mauList.add(person1);
                for(int b=0; b<mauList.size()-1;b++){
                    person3 = mauList.get(b);
                    if(person1.getMssv()==person3.getMssv()){
                        mauList.remove(person1);
                    }
                }
            }
            i=i+1;
            z--;
        }
    }
}
