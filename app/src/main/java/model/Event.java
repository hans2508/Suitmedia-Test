package model;

import java.util.Date;

/**
 * Created by Hans CK on 21-Mar-15.
 */
public class Event {

    private int image;
    private String nama;
    private String tanggal;

    public Event(int image, String nama, String tanggal) {
        this.image = image;
        this.nama = nama;
        this.tanggal = tanggal;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
