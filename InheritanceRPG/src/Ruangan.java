import java.util.ArrayList;
import java.util.Scanner;

// import static java.lang.String.format;

public class Ruangan {

    private NPC objNPC; 
    private Item  objRoti;
    private ArrayList<Item> arrItem = new ArrayList<>();
    private String deskripsi;
    private GameInfo objGameInfo;
    private Scanner sc = new Scanner(System.in);
    //add
    private PintuKeluar objKeluar;
    private PintuRahasia objRahasia;
    private Player objPlayer;

    //Contruct
    public Ruangan() {
        // init ruangan
        objKeluar = new PintuKeluar("Keluar");
        objRahasia = new PintuRahasia("Rahasia");
        objPlayer = new Player();
        objNPC = new NPC();

        // init pintu, kunci dan roti.
        objRoti  = new Item("Roti");
        objRoti.setDeskripsi("Roti rasa coklat dalam bungkusan plastik");
        objRoti.setObjRuangan(this);

        //tambah item ke array
        arrItem.add(objRoti);
    }

    //Setter n Getter
    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    //=========== Method ==============
    //objgame juga diset pada pintu dan item2
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objKeluar.setObjGameInfo(objGameInfo);
        objRahasia.setObjGameInfo(objGameInfo);
        objNPC.setObjGameInfo(objGameInfo);
        for (Item objItem:arrItem) {
            objItem.setObjGameInfo(objGameInfo);
        }
    }

    //aksi yang dapat dilakukan di ruangan
    //agak kompleks tapi jadi fleksibel, logic aksi ada di masing2 item (bukan di game engine)
    //hardcode menu dikurangi
    
    //Opsi di Ruangan
    public void pilihanAksi() {
        //Deklar var
        int urutPil = 0;  //item, pintu
        int subPil;   //aksinya

        System.out.println("==== Pilihan Aksi pada Ruangan ===");
        //Aksi item (Player/Ruangan)
        System.out.println("Item di ruangan");
        urutPil++; //opsi 1
        for (Item objItem:arrItem) {
            subPil = 0;   //sistem penomorannya 11  12  13 dst
            System.out.println(objItem.getNama());

            //Ambil Pilihan (berdasarkan letak Item)(generic)
            ArrayList <String> arrPil = objItem.getAksi();
            //print pilihan
            for (String strPil:arrPil) {
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }


        //Aksi PINTU KELUAR
        //belum menggunakan inheritance, jadi masih perlu penanganan terpisah untuk item spesifik seperti pintu
        urutPil++;//opsi 2
        subPil = 0;
        int pilKeluar  = urutPil; //catat untuk pintu
        System.out.println("Pintu "+objKeluar.getName());
        for (String strPil:objKeluar.getAksi()) {
            subPil++;
            System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
        }

        //Aksi PINTU RAHASIA
        //belum menggunakan inheritance, jadi masih perlu penanganan terpisah untuk item spesifik seperti pintu
        urutPil++;//opsi 2
        subPil = 0;
        int pilRahasia  = urutPil; //catat untuk pintu
        System.out.println("Pintu "+objRahasia.getName());
        for (String strPil:objRahasia.getAksi()) {
            subPil++;
            System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
        }

        //Aksi NPC
        urutPil++;//opsi 3
        subPil = 0;
        int pilNPC  = urutPil; //catat untuk pintu
        System.out.println("NPC");
        for (String strPil:objNPC.getAksi()) {
            subPil++;
            System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
        }

        System.out.print("Pilihan anda? ");
        String strPil = sc.next();
        System.out.println("--");

        //split pilihan dan subpilihan

        int pil    =  Integer.parseInt(strPil.substring(0,1)); //ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil     =  Integer.parseInt(strPil.substring(1,2)); //ambil digit kedua, asumsikan jumlah tidak lebih dari 10

        //tdk perlu if spt ini kalau sudah menggunakan inheritance
        if (pil==pilKeluar) {
            objKeluar.prosesAksi(subPil,objGameInfo.getObjPlayer());  //aksi pintu
        } else if (pil==pilRahasia) {
            objRahasia.prosesAksi(subPil,objGameInfo.getObjPlayer());
        }else if (pil==pilNPC) {
            objNPC.prosesAksi(subPil);
        } else {
            //item
            Item objItemPilih = arrItem.get(pil-1);
            objItemPilih.prosesAksi(subPil); //aksi item
        }
    }

    // hapus item di ruangan berdasarkan namanya
    // digunakan saat suatu item diambil oleh player misalnya
    public void hapusItem(Item objItem) {
        arrItem.remove(objItem);  //buang item
    }

    public void addItem(Item objItem) {
        arrItem.add(objItem);
    }

    
    //setter getter

    public NPC getObjNPC() {
        return this.objNPC;
    }

    public void setObjNPC(NPC objNPC) {
        this.objNPC = objNPC;
    }

    public Item getObjRoti() {
        return this.objRoti;
    }

    public void setObjRoti(Item objRoti) {
        this.objRoti = objRoti;
    }

    public ArrayList<Item> getArrItem() {
        return this.arrItem;
    }

    public void setArrItem(ArrayList<Item> arrItem) {
        this.arrItem = arrItem;
    }

    public GameInfo getObjGameInfo() {
        return this.objGameInfo;
    }


    public Scanner getSc() {
        return this.sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public PintuKeluar getObjKeluar() {
        return this.objKeluar;
    }

    public void setObjKeluar(PintuKeluar objKeluar) {
        this.objKeluar = objKeluar;
    }

    public PintuRahasia getObjRahasia() {
        return this.objRahasia;
    }

    public void setObjRahasia(PintuRahasia objRahasia) {
        this.objRahasia = objRahasia;
    }

    public Player getObjPlayer() {
        return this.objPlayer;
    }

    public void setObjPlayer(Player objPlayer) {
        this.objPlayer = objPlayer;
    }

}
