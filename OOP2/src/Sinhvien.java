//package Controller;
import java.io.Serializable;

public class Sinhvien implements Serializable {
    protected String tensv;
    protected int mssv;
    protected String khoa;
    protected String monhoc;
    protected int sotin;
    protected Double diem;
    protected String loaict;

    public double tinhdiem() {
        return 0;
    }
    public int tinhtinchi(){
        return 0;
    }

    public Sinhvien(){

    }

    public Sinhvien(String tensv,int mssv,String khoa,String monhoc,int sotin,Double diem,String loaict){
        this.tensv = tensv;
        this.mssv = mssv;
        this.khoa = khoa;
        this.monhoc = monhoc;
        this.sotin = sotin;
        this.diem = diem;
        this.loaict = loaict;
    }

    public String getTensv(){
        return tensv;
    }
    public void setTensv(String tensv) {
        this.tensv = tensv;
    }
    public String getKhoa(){
        return khoa;
    }
    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
    public String getMonhoc(){
        return monhoc;
    }
    public void setMonhoc(String monhoc) {
        this.monhoc = monhoc;
    }
    public String getLoaict(){
        return loaict;
    }
    public void setLoaict(String loaict) {
        this.loaict = loaict;
    }
    public int getMssv(){
        return mssv;
    }
    public void setMssv(int mssv){
        this.mssv = mssv;
    }
    public Double getDiem(){
        return diem;
    }
    public void setDiem(Double diem){
        this.diem = diem;
    }
    public int getSotin(){
        return sotin;
    }
    public void setSotin(int sotin){
        this.sotin = sotin;
    }
}
