public class Sinhvientheomau extends Sinhvien{
    int i=0;
    public Sinhvientheomau(){

    }
    public Sinhvientheomau(String tensv,int mssv,String khoa,String monhoc,int sotin,Double diem, String loaict){
        super(tensv,mssv,khoa,monhoc,sotin,diem,loaict);
    }
    @Override
    public double tinhdiem(){
        i++;
       return getDiem();
    }
}
