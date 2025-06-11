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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DailyEntry implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalDate tanggal;
    private int kaloriAwal;
    private int totalKaloriSaatIni;
    private boolean statusSelesai;
    private List<Food> foodLogs;
    private List<Activity> activityLogs;

    public DailyEntry(LocalDate tanggal, int kaloriAwal) {
        this.tanggal = tanggal;
        this.kaloriAwal = kaloriAwal;
        this.totalKaloriSaatIni = kaloriAwal;
        this.statusSelesai = false;
        this.foodLogs = new ArrayList<>();
        this.activityLogs = new ArrayList<>();
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public int getKaloriAwal() {
        return kaloriAwal;
    }

    public int getTotalKaloriSaatIni() {
        return totalKaloriSaatIni;
    }

    public boolean isStatusSelesai() {
        return statusSelesai;
    }

    public List<Food> getFoodLogs() {
        return foodLogs;
    }

    public List<Activity> getActivityLogs() {
        return activityLogs;
    }
    
    
    public void setKaloriAwal(int kaloriAwal) {
        this.kaloriAwal = kaloriAwal;
    }

    public void setTotalKaloriSaatIni(int totalKaloriSaatIni) {
        this.totalKaloriSaatIni = totalKaloriSaatIni;
    }

    public void setStatusSelesai(boolean statusSelesai) {
        this.statusSelesai = statusSelesai;
    }

    public void addFoodLog(Food food) {
        this.foodLogs.add(food);
    }

    public void addActivityLog(Activity activity) {
        this.activityLogs.add(activity);
    }
}
