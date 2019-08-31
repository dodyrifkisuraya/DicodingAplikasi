package com.dorizu.dicoding;

import android.os.Parcel;
import android.os.Parcelable;

//buat ADT
public class KelasDicoding implements Parcelable {
    //deklarasi variabel
    private String nama;
    private String penyusun;
    private String thumnailDiskripsi;
    private String Diskripsi;
    private String thumnail;
    private String photodiskripsi;
    private String biaya;

    //deklarasi variabel di parcel
    protected KelasDicoding(Parcel in) {
        nama = in.readString();
        penyusun = in.readString();
        thumnailDiskripsi = in.readString();
        Diskripsi = in.readString();
        thumnail = in.readString();
        photodiskripsi = in.readString();
        biaya = in.readString();
    }

    //buat Parcel
    public static final Creator<KelasDicoding> CREATOR = new Creator<KelasDicoding>() {
        @Override
        public KelasDicoding createFromParcel(Parcel in) {
            return new KelasDicoding(in);
        }

        @Override
        public KelasDicoding[] newArray(int size) {
            return new KelasDicoding[size];
        }
    };
    //construktor
    public KelasDicoding(){

    }

    //method setter getter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPenyusun() {
        return penyusun;
    }

    public void setPenyusun(String penyusun) {
        this.penyusun = penyusun;
    }

    public String getDiskripsi() {
        return Diskripsi;
    }

    public void setDiskripsi(String diskripsi) {
        Diskripsi = diskripsi;
    }

    public String getThumnail() {
        return thumnail;
    }

    public void setThumnail(String thumnail) {
        this.thumnail = thumnail;
    }

    public String getPhotodiskripsi() {
        return photodiskripsi;
    }

    public void setPhotodiskripsi(String photodiskripsi) {
        this.photodiskripsi = photodiskripsi;
    }

    public String getBiaya() {
        return biaya;
    }

    public void setBiaya(String biaya) {
        this.biaya = biaya;
    }

    public String getThumnailDiskripsi() {
        return thumnailDiskripsi;
    }

    public void setThumnailDiskripsi(String thumnailDiskripsi) {
        this.thumnailDiskripsi = thumnailDiskripsi;
    }

    //objek di parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    //masukan data ke parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.penyusun);
        dest.writeString(this.thumnailDiskripsi);
        dest.writeString(this.Diskripsi);
        dest.writeString(this.thumnail);
        dest.writeString(this.photodiskripsi);
        dest.writeString(this.biaya);
    }
}
