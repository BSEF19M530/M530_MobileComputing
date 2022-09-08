package haqnawaz.org.navigationdrawer;

import androidx.annotation.NonNull;

public class UrduATModel {
    private String Ar;
    private String Ur;

    @NonNull
    @Override
    public String toString() {
        return "UrATModel{" +
                "Ar='" + Ar + '\'' +
                ", Ur=" + Ur +
                '}';
    }

    public UrduATModel(String ar, String Ur) {
        this.Ar = ar;
        this.Ur = Ur;
    }

    public String getAr() {
        return Ar;
    }

    public void setAr(String name) {
        this.Ar = name;
    }

    public String getUr() {
        return Ur;
    }

    public void setUr(String Ur) {
        this.Ur = Ur;
    }


}
