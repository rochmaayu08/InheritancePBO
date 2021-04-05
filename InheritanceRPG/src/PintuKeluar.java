public class PintuKeluar extends Pintu{
    private GameInfo objGameInfo;

    public PintuKeluar(String name){
        super(name);
    }

    //Method
    public void prosesAksi(int subPil, Player objPlayer) {
        //1: deskripsikan
        //2: buka pintu
        if (subPil==1) {
            System.out.println("Pintu berwarna merah dengan tulisan 'EXIT' di atas ");
        } else if (subPil==2) {
            //cek apakah mempunyai kunci
            if (objPlayer.cariItem("Kunci")) {
                //kunci ada, pintu terbuka
                System.out.println("Player menggunakan kunci untuk membuka pintu dan pintu terbuka!");
                objGameInfo.setGameOver(true); //game over
            } else {
                //kunci tidak ada
                System.out.println("Player mencboa membuka pintu. TERKUNCI!");
            }
        }
    }
}
