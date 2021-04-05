import java.util.ArrayList;
//belum menggunakan inheritance, idealnya turunan dari Item

public class Pintu {

    private ArrayList<String> arrAksi = new ArrayList<>();
    private GameInfo objGameInfo;
    private String name;

    //constrcutor
    public Pintu(String name) {
        //init pilihan
        this.name = name;
        arrAksi.add("Deskripsikan pintu");
        arrAksi.add("Coba buka pintu");
    }

    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
    }

    public ArrayList<String> getAksi() {
        return arrAksi;
    }


    public ArrayList<String> getArrAksi() {
        return this.arrAksi;
    }

    public void setArrAksi(ArrayList<String> arrAksi) {
        this.arrAksi = arrAksi;
    }

    public GameInfo getObjGameInfo() {
        return this.objGameInfo;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
