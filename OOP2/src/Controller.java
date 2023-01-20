//package Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class Controller implements Initializable {
    Sinhvien sinhvien = new Sinhvien();
    SinhvienList sinhvien1List = new SinhvienList();
    int index = -1;

    @FXML
    private TableView<Sinhvien> table1;

    @FXML
    private TableColumn<Sinhvien, Double> diemthi1Column;

    @FXML
    private TableColumn<Sinhvien, String> k1Column;

    @FXML
    private TableColumn<Sinhvien, String> loai1Column;

    @FXML
    private TableColumn<Sinhvien, String> monhoc1Column;

    @FXML
    private TableColumn<Sinhvien, Integer> mssv1Column;

    @FXML
    private TableColumn<Sinhvien, String> name1Column;

    @FXML
    private TableColumn<Sinhvien, Integer> tin1Column;

    @FXML
    private TextField diemthiText;

    @FXML
    private TextField khoahocText;

    @FXML
    private TextField monhocText;

    @FXML
    private TextField mssvText;

    @FXML
    private CheckBox rememberKH;

    @FXML
    private CheckBox rememberMH;

    @FXML
    private CheckBox rememberTC;

    @FXML
    private TextField searchAll;

    @FXML
    private ChoiceBox<String> svCate;

    @FXML
    private TextField tensvText;

    @FXML
    private TextField tinchiText;

    @FXML
    void add(ActionEvent event) {
        
        Sinhvien sinhvien = new Sinhvien();
        sinhvien.setLoaict(svCate.getValue());
        
        if(sinhvien.getLoaict() == "mẫu"){
            Sinhvientheomau sinhvientheomau = new Sinhvientheomau();
            sinhvientheomau.setTensv(tensvText.getText());
            sinhvientheomau.setKhoa(khoahocText.getText());
            sinhvientheomau.setDiem(Double.parseDouble(diemthiText.getText()));
            sinhvientheomau.setMssv(Integer.parseInt(mssvText.getText()));
            sinhvientheomau.setSotin(Integer.parseInt(tinchiText.getText()));
            sinhvientheomau.setMonhoc(monhocText.getText());
            sinhvientheomau.setLoaict(svCate.getValue());
            if (sinhvientheomau.getDiem()<=10)
               svList.add(sinhvientheomau);
               sinhvien1List.addSinhvien(sinhvientheomau);  
        }
        else if(sinhvien.getLoaict() == "tín chỉ"){
            Sinhvientheotin sinhvientheotin = new Sinhvientheotin();
            sinhvientheotin.setTensv(tensvText.getText());
            sinhvientheotin.setKhoa(khoahocText.getText());
            sinhvientheotin.setDiem(Double.parseDouble(diemthiText.getText()));
            sinhvientheotin.setMssv(Integer.parseInt(mssvText.getText()));
            sinhvientheotin.setSotin(Integer.parseInt(tinchiText.getText()));
            sinhvientheotin.setMonhoc(monhocText.getText());
            sinhvientheotin.setLoaict(svCate.getValue());
            if (sinhvientheotin.getDiem()<=10)
               svList.add(sinhvientheotin);
               sinhvien1List.addSinhvien(sinhvientheotin);    
        }
        // from the value in the TextField, use set method to modify the object

        //clear the TextField
        tensvText.clear();
        if(rememberKH.isSelected() == false){
            khoahocText.clear();
        }
        if(rememberTC.isSelected() == false){
            tinchiText.clear();
        }
        if(rememberMH.isSelected() == false){
            monhocText.clear();
        }
        diemthiText.clear();
        mssvText.clear();
    }

    @FXML
    void clearSelection(KeyEvent event){
        if(event.getCode().toString() =="R")
        {
            table1.getSelectionModel().clearSelection();
            tensvText.clear();
            khoahocText.clear();
            diemthiText.clear();
            mssvText.clear();
            tinchiText.clear();
            monhocText.clear();
        }
    }

    @FXML
    void clearSelection2(ActionEvent event) {
        table1.getSelectionModel().clearSelection();
        tensvText.clear();
        khoahocText.clear();
        diemthiText.clear();
        mssvText.clear();
        tinchiText.clear();
        monhocText.clear();
    }

    @FXML
    void delete(ActionEvent event) {
        svList.removeAll(table1.getSelectionModel().getSelectedItems());
        table1.getSelectionModel().clearSelection();
        tensvText.clear();
        khoahocText.clear();
        diemthiText.clear();
        mssvText.clear();
        tinchiText.clear();
        monhocText.clear();
    }

    @FXML
    void fix(ActionEvent event) {
        Sinhvien selected1 = table1.getSelectionModel().getSelectedItem();
        if(selected1.getLoaict() == "mẫu"){
            Sinhvientheomau sinhvientheomau = new Sinhvientheomau();
            svList.remove(selected1);
            table1.getSelectionModel().clearSelection();
            sinhvientheomau.setTensv(tensvText.getText());
            sinhvientheomau.setKhoa(khoahocText.getText());
            sinhvientheomau.setDiem(Double.parseDouble(diemthiText.getText()));
            sinhvientheomau.setMssv(Integer.parseInt(mssvText.getText()));
            sinhvientheomau.setSotin(Integer.parseInt(tinchiText.getText()));
            sinhvientheomau.setMonhoc(monhocText.getText());
            sinhvientheomau.setLoaict(svCate.getValue());
            svList.add(sinhvientheomau);  
        }
        else if(selected1.getLoaict() == "tín chỉ"){
            Sinhvientheotin sinhvientheotin = new Sinhvientheotin();
            svList.remove(selected1);
            table1.getSelectionModel().clearSelection();
            sinhvientheotin.setTensv(tensvText.getText());
            sinhvientheotin.setKhoa(khoahocText.getText());
            sinhvientheotin.setDiem(Double.parseDouble(diemthiText.getText()));
            sinhvientheotin.setMssv(Integer.parseInt(mssvText.getText()));
            sinhvientheotin.setSotin(Integer.parseInt(tinchiText.getText()));
            sinhvientheotin.setMonhoc(monhocText.getText());
            sinhvientheotin.setLoaict(svCate.getValue());
            svList.add(sinhvientheotin);  
        }
            //clear the TextField
            tensvText.clear();
            diemthiText.clear();
            mssvText.clear();
            if(rememberKH.isSelected() == false){
                khoahocText.clear();
            }
            if(rememberTC.isSelected() == false){
                tinchiText.clear();
            }
            if(rememberMH.isSelected() == false){
                monhocText.clear();
            }
        }

    @FXML
    void getSelected1(MouseEvent event) {
        index= table1.getSelectionModel().getSelectedIndex();
        if(index<=-1){
            return;
        }
        tensvText.setText(name1Column.getCellData(index).toString());
        mssvText.setText(mssv1Column.getCellData(index).toString());
        diemthiText.setText(diemthi1Column.getCellData(index).toString());
        khoahocText.setText(k1Column.getCellData(index).toString());
        tinchiText.setText(tin1Column.getCellData(index).toString());
        monhocText.setText(monhoc1Column.getCellData(index).toString());

        // dong nay toi them vao 
        svCate.setValue(loai1Column.getCellData(index));
    }

    @FXML
    void mauSV(ActionEvent event) throws IOException {
        int i=0;
        Stage window = new Stage();
        FXMLLoader loading = new FXMLLoader();
        loading.setLocation(getClass().getResource("FXML/thirdScene.fxml"));
        Parent root = loading.load();
        Scene scene = new Scene(root);
        
        //this scene will use SecondScene file as controller
        thirdScene controlScene = loading.getController();
        controlScene.getInfo(svList);

        //this window won't be close until the user asked to 
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("List of sinh viên mẫu");
        window.setScene(scene);
        window.showAndWait();
        sinhvien = svList.get(i);
    }

    @FXML
    void tinchiSV(ActionEvent event) throws IOException {
        //Sinhvien sv = new Sinhvien();
        int i=0;
        Stage window = new Stage();
        FXMLLoader loading = new FXMLLoader();
        loading.setLocation(getClass().getResource("FXML/secondScene.fxml"));
        Parent root = loading.load();
        Scene scene = new Scene(root);
        
        //this scene will use SecondScene file as controller
        secondScene controlScene = loading.getController();
        controlScene.getInfo(svList);

        //this window won't be close until the user asked to 
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("List of sinh viên tín chỉ");
        window.setScene(scene);
        window.showAndWait();
        sinhvien = svList.get(i);
    }

    @FXML
    void totnghiepSV(ActionEvent event) throws IOException {
        int i=0;
        Stage window = new Stage();
        FXMLLoader loading = new FXMLLoader();
        loading.setLocation(getClass().getResource("FXML/forthScene.fxml"));
        Parent root = loading.load();
        Scene scene = new Scene(root);
        
        //this scene will use SecondScene file as controller
        forthScene controlScene = loading.getController();
        controlScene.getInfo(svList);

        //this window won't be close until the user asked to 
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("List of sinh viên mẫu");
        window.setScene(scene);
        window.showAndWait();
        sinhvien = svList.get(i);
    }

    private ObservableList<Sinhvien> svList;
    //private ObservableList<Sinhvien> testList;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        table1.setEditable(true);
        svList = FXCollections.observableArrayList();
        Sinhvientheotin sinhvien1 = new Sinhvientheotin("Nguyễn Minh Đức",20207664,"K65","OOP",10,10.0,"tín chỉ");
        Sinhvientheomau sinhvien2 = new Sinhvientheomau("Nguyễn Văn A",20202020,"K65","OS",10,8.0,"mẫu");
        Sinhvientheomau sinhvien3 = new Sinhvientheomau("Nguyễn Văn B",20212022,"K66","Mạng máy tính",10,1.0,"mẫu");
        svList.add(sinhvien1);
        svList.add(sinhvien2);
        svList.add(sinhvien3);

        sinhvien1List.addSinhvien(sinhvien1);
        sinhvien1List.addSinhvien(sinhvien2);
        sinhvien1List.addSinhvien(sinhvien3);
        //testList = FXCollections.observableArrayList();
        name1Column.setCellValueFactory(new PropertyValueFactory<Sinhvien, String>("tensv"));
        mssv1Column.setCellValueFactory(new PropertyValueFactory<Sinhvien, Integer>("mssv"));
        monhoc1Column.setCellValueFactory(new PropertyValueFactory<Sinhvien, String>("monhoc"));
        diemthi1Column.setCellValueFactory(new PropertyValueFactory<Sinhvien, Double>("diem"));
        k1Column.setCellValueFactory(new PropertyValueFactory<Sinhvien, String>("khoa"));
        tin1Column.setCellValueFactory(new PropertyValueFactory<Sinhvien, Integer>("sotin"));
        loai1Column.setCellValueFactory(new PropertyValueFactory<Sinhvien, String>("loaict"));

        //set the item: the ObservableList of Staff, for display
        table1.setItems(svList);
        //set the item for choice box
        svCate.getItems().addAll("tín chỉ", "mẫu");
        //set the first categorize box as blank
        svCate.getSelectionModel().select(0);
      
        table1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        FilteredList<Sinhvien> filteredData = new FilteredList<>(svList);

        searchAll.textProperty().addListener((observ, oldValue, newValue) -> {
            filteredData.setPredicate(sinhvien ->{
                //if the TextField is empty, display all data
                if(newValue == null|| newValue.isEmpty()){
                    return true;
                }
                //lower case the value for easier searching, this will be temporary
                String lowerCaseFilter = newValue.toLowerCase();

                //compare the lowercase version of both value (the staff'name and the newValue)
                if (sinhvien.getTensv().toLowerCase().indexOf(lowerCaseFilter) != -1 ||
                 sinhvien.getKhoa().toLowerCase().indexOf(lowerCaseFilter) != -1 ||
                 String.valueOf(sinhvien.getMssv()).indexOf(lowerCaseFilter) != -1 ||
                 sinhvien.getMonhoc().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true; // if the values are alike, return the data
                }
                else
                    // if not, don't return the data
                    return false;
                
            });
        });

        //wrap the FilteredList in SortedList, this will sort out all the value that are not alike
        SortedList<Sinhvien> sortedData = new SortedList<>(filteredData);

        //bind to the table use the comperator, otherwise, this won't have any effect
        sortedData.comparatorProperty().bind(table1.comparatorProperty());
        //set item of the table
        table1.setItems(sortedData);
    }

}