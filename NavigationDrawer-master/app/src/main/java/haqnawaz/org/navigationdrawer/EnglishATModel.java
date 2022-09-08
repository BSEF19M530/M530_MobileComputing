package haqnawaz.org.navigationdrawer;

import androidx.annotation.NonNull;

public class EnglishATModel {
    private String Ar;
    private String Eng;

    @NonNull
    @Override
    public String toString() {
        return "EnglishATModel{" +
                "Ar='" + Ar + '\'' +
                ", Eng=" + Eng +
                '}';
    }

    public EnglishATModel(String ar, String eng) {
        this.Ar = ar;
        this.Eng = eng;
    }

    public String getAr() {
        return Ar;
    }

    public void setAr(String name) {
        this.Ar = name;
    }

    public String getEng() {
        return Eng;
    }

    public void setEng(String eng) {
        this.Eng = eng;
    }


}
