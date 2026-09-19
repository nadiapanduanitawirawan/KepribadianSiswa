package custom;

public class Pagination {
    private int halamanSaatIni;
    private int totalData;
    private int dataPerhalaman;
    
public Pagination() {
    this.dataPerhalaman = dataPerhalaman;
    this.halamanSaatIni = 1;
}

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public int getTotalHalaman() {
        return (int) Math.ceil((double) totalData / dataPerhalaman);
    }

    public int getPosisiAwal() {
        return (halamanSaatIni - 1) * dataPerhalaman;
    }

    public int getDataPerhalaman() {
        return dataPerhalaman;
    }

    public void halamanPertama() {
        halamanSaatIni = 1;
    }

    public void halamanBerikutnya() {
        if (halamanSaatIni < getTotalHalaman()) {
            halamanSaatIni++;
        }
    }

    public void halamanSebelumnya() {
        if(halamanSaatIni > 1) {
            halamanSaatIni--;
        }
    }

    public void halamanTerakhir() {
        halamanSaatIni = getTotalHalaman();
    }

    public int getHalamanSaatIni() {
        return halamanSaatIni;
    }
}
