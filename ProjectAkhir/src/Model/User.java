/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ACER
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nama;
    private List<DailyEntry> dailyEntries; 

    public User(String nama) {
        this.nama = nama;
        this.dailyEntries = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public List<DailyEntry> getDailyEntries() {
        return dailyEntries;
    }


    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setDailyEntries(List<DailyEntry> dailyEntries) {
        this.dailyEntries = dailyEntries;
    }

    @Override
    public String toString() {
        return nama;
    }
}
