package id.ac.amikom.a0060students.wahyudi.filemku;

import java.io.Serializable;

public class Filem implements Serializable {

    private String txtJudul;
    private String txtRingkasan;
    private String tayang;
    private String imgPoster;

    public Filem(String judul,String Ringkasan, String tayang, String imgPoster){
        this.txtJudul = judul;
        this.txtRingkasan = Ringkasan;
        this.tayang = tayang;
        this.imgPoster = imgPoster;
    }

    public String getImgPoster() {
        return imgPoster;
    }

    public void setImgPoster(String imgPoster) {
        this.imgPoster = imgPoster;
    }

    public String getTxtJudul() {
        return txtJudul;
    }

    public void setTxtJudul(String txtJudul) {
        this.txtJudul = txtJudul;
    }

    public String getTxtRingkasan() {
        return txtRingkasan;
    }

    public void setTxtRingkasan(String txtRingkasan) {
        this.txtRingkasan = txtRingkasan;
    }

    public String gettayang() {
        return tayang;
    }

    public void settayang(String tayang) {
        this.tayang = tayang;
    }


}
