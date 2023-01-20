public class SinhvienList {
    Sinhvien[] sinhviens = new Sinhvien[100];
    Sinhvien[] sinhviens2 = new Sinhvien[100];
    Sinhvien[] sinhviens3 = new Sinhvien[100];

    public SinhvienList() {
        for(int i = 0; i < 100; i ++) {
            sinhviens[i] = null;
        }
    }

    public void addSinhvien(Sinhvientheotin newSinhvien) {
        for(int i = 0; i < 100; i++) {
            if (sinhviens[i] == null) {
                sinhviens[i] = newSinhvien;
                break;
            }
        }
    }

    public void addSinhvien(Sinhvientheomau newSinhvien) {
        for(int i = 0; i < 100; i++) {
            if (sinhviens2[i] == null) {
                sinhviens2[i] = newSinhvien;
                break;
            }
        }
    }

}

