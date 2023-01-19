//package Controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.*;

public class forthScene implements Initializable{
    public double dtb = 5.0;//dk de sv tot nghiep
    public Integer tinchi = 40;//dk de sinh vien tot nghiep
    Stage window;
    Scene scene;

    @FXML
    private TableColumn<Sinhvien, Double> diemcol;

    @FXML
    private TableColumn<Sinhvien, String> hovatencol;

    @FXML
    private TableColumn<Sinhvien, String> kieucol;

    @FXML
    private TableColumn<Sinhvien, Integer> mssvcol;

    @FXML
    private TableView<Sinhvien> table2;

    @FXML
    private TableColumn<Sinhvien, Integer> tccol;

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }

    @FXML
    void checkm(ActionEvent event) throws IOException {
        Stage window = new Stage();
        FXMLLoader loading = new FXMLLoader();
        loading.setLocation(getClass().getResource("FXML/FXML2/TotalviewM.fxml"));
        Parent root = loading.load();
        Scene scene = new Scene(root);

        checkMS controlscene = loading.getController();
        controlscene.getInfo(tongList);

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Tổng số sinh viên theo diện mẫu đạt tốt nghiệp");
        window.setScene(scene);
        window.showAndWait();
    }

    @FXML
    void checktc(ActionEvent event) throws IOException {
        Stage window = new Stage();
        FXMLLoader loading = new FXMLLoader();
        loading.setLocation(getClass().getResource("FXML/FXML2/TotalviewT.fxml"));
        Parent root = loading.load();
        Scene scene = new Scene(root);

        checkTS controlscene = loading.getController();
        controlscene.getInfo(tongList);

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Tổng số sinh viên theo diện tín chỉ đạt tốt nghiệp");
        window.setScene(scene);
        window.showAndWait();
    }

    private ObservableList<Sinhvien> tongList;
    private ObservableList<Sinhvien> tinchiList;
    private ObservableList<Sinhvien> mauList;
    private ObservableList<Sinhvien> tList2;
    private ObservableList<Sinhvien> tList;
    private ObservableList<Sinhvien> mList;
    private ObservableList<Sinhvien> mList2;


    public void initialize(URL arg0, ResourceBundle arg1) {
        tinchiList = FXCollections.observableArrayList();
        mauList = FXCollections.observableArrayList();
        tList2 = FXCollections.observableArrayList();
        tongList = FXCollections.observableArrayList();
        tList = FXCollections.observableArrayList();
        mList = FXCollections.observableArrayList();
        mList2 = FXCollections.observableArrayList();
        hovatencol.setCellValueFactory(new PropertyValueFactory<Sinhvien, String>("tensv"));
        mssvcol.setCellValueFactory(new PropertyValueFactory<Sinhvien, Integer>("mssv"));
        kieucol.setCellValueFactory(new PropertyValueFactory<Sinhvien, String>("loaict"));
        diemcol.setCellValueFactory(new PropertyValueFactory<Sinhvien, Double>("diem"));
        tccol.setCellValueFactory(new PropertyValueFactory<Sinhvien, Integer>("sotin"));
        table2.setItems(tongList);
    }
    public void Tc(ObservableList<Sinhvien> tList){
        int max=0;
        //int i=0;
        int tong=0;
        for(int i=0;i<tList.size();i++){
            Sinhvien person1 = new Sinhvien();
            person1 = tList.get(i);
            for(int j=i;j<tList.size();j++){
                Sinhvien person2 = new Sinhvien();
                person2 = tList.get(j);
                if(person1.getMssv() == person2.getMssv()){
                    tong+= person2.getSotin();
                }
            }
            if(max<tong){
                max=tong;
            }
            Sinhvien person3 = new Sinhvien();
            Sinhvien person4 = new Sinhvien();
            person4 = tList.get(i);
            person3.setSotin(max);
            person3.setTensv(person4.getTensv());
            person3.setMssv(person4.getMssv());
            person3.setLoaict(person4.getLoaict());
            person3.setDiem(null);
            if(person3.getSotin()>tinchi){
                tList2.add(person3);
            }  
            tong = 0;
            max=0;
        }
    }
    public void mau(ObservableList<Sinhvien> mList){
        int bodem = 0;
        double maxdiem = 0.0;
        double tongdiem=0.0;
        for(int i=0;i<mList.size();i++){
            Sinhvien person1 = new Sinhvien();
            person1 = mList.get(i);
            for(int j=i;j<mList.size();j++){
                Sinhvien person2 = new Sinhvien();
                person2 = mList.get(j);
                if(person1.getMssv() == person2.getMssv()){
                    //tong+= person2.getSotin();
                    tongdiem+=person2.getDiem();
                    bodem++;
                }
            }
            if(maxdiem<tongdiem){
                maxdiem=tongdiem/bodem;
            }
            Sinhvien person3 = new Sinhvien();
            Sinhvien person4 = new Sinhvien();
            person4 = mList.get(i);
            person3.setSotin(bodem);
            person3.setTensv(person4.getTensv());
            person3.setMssv(person4.getMssv());
            person3.setLoaict(person4.getLoaict());
            person3.setDiem(maxdiem);
            if(person3.getDiem()>dtb){
                mList2.add(person3);
            }  
            maxdiem=0;
            tongdiem=0;
            bodem=0;
        }
    }

    public void getInfo(ObservableList<Sinhvien> svList){
        int i = 0;
        int j= 0;
        int m = 1;
        int timer = 1;
        Sinhvien person1 = new Sinhvien();
        Sinhvien person2 = new Sinhvien();
        Sinhvien person3 = new Sinhvien();
        Sinhvien person4 = new Sinhvien();
        Sinhvien person5 = new Sinhvien();
        Sinhvien person6 = new Sinhvien();
        while (m>0){
            for(int a=0; a<svList.size();a++){
                person1 = svList.get(a);
                if(person1.getLoaict() == "tín chỉ" && person1.getDiem()>=3){
                    tList.add(person1);
                }
                if(person1.getLoaict() == "mẫu"){
                    mList.add(person1);
                }
            }
            Tc(tList);
            mau(mList);
            m--;
        }
        int z1=tList2.size();
        int z2=mList2.size();
        while(z1>0){
            person1 = tList2.get(i);
            for(int a= i+1; a<tList2.size();a++){
                person2 = tList2.get(a);
                if(person2.getMssv() == person1.getMssv()){
                    if(person2.getSotin()>person1.getSotin()){
                        person1 = tList2.get(a);
                    }
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
            z1--;
        }
        while(z2>0){
            person4 = mList2.get(j);
            for(int a= j+1; a<mList2.size();a++){
                person5 = mList2.get(a);
                if(person5.getMssv() == person4.getMssv()){
                    if(person5.getSotin()>person4.getSotin()){
                        person4 = mList2.get(a);
                    }
                }
                
            }
            if(mauList.size()==0){
                mauList.add(person4);
            }
            else if(mauList.size()!=0){
                mauList.add(person4);
                for(int b=0; b<mauList.size()-1;b++){
                    person6 = mauList.get(b);
                    if(person4.getMssv()==person6.getMssv()){
                        mauList.remove(person4);
                    }
                }
            }
            j=j+1;
            z2--;
        }
        while(timer>0){
            System.out.println(tinchiList.size());
            System.out.println(mauList.size());
            if(tinchiList.size()>0){
                for(int a=0; a<tinchiList.size();a++){
                    person1 = tinchiList.get(a);
                    tongList.add(person1);
                }
            }
            if(mauList.size()>0){
                for(int b=0; b<mauList.size();b++){
                    person2 = mauList.get(b);
                    tongList.add(person2);
                }
            }
            // else if(tinchiList.size()>0&&mauList.size()>0){
            //     int a=0;
            //     int b=0;
            //     while(a<tinchiList.size()-1){
            //         person1 = tinchiList.get(a);
            //         tongList.add(person1);
            //         a++;
            //     }
            //     while(b<mauList.size()){   
            //         person2 = tinchiList.get(b);
            //         tongList.add(person1);
            //         b++; 
            //     }
            //}
            timer--;
        }
    }
}
