package model;

/**
 * Created by Hans CK on 22-Mar-15.
 */
public class Guest {

    private int id;
    private int image;
    private String nama;
    private String birthdate;

    public Guest(int id, int image, String nama, String birthdate) {
        this.id = id;
        this.image = image;
        this.nama = nama;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
