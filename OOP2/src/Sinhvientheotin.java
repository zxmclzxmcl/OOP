public class Sinhvientheotin extends Sinhvien {
    int tin = 0;
    public Sinhvientheotin(){

    }
    public Sinhvientheotin(String tensv,int mssv,String khoa,String monhoc,int sotin,Double diem, String loaict){
        super(tensv,mssv,khoa,monhoc,sotin,diem,loaict);
    }
    @Override
    public int tinhtinchi(){
        // if(getDiem()>=3){
        //     tin = tin+getSotin();
        // }
        return tin;
    }
}
