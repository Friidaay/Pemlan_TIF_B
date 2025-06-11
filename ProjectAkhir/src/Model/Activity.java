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
import java.time.LocalDateTime;

public class Activity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String namaAktivitas;
    private int kaloriTerbakar;
    private LocalDateTime waktuInput;

    public Activity(String namaAktivitas, int kaloriTerbakar) {
        this.namaAktivitas = namaAktivitas;
        this.kaloriTerbakar = kaloriTerbakar;
        this.waktuInput = LocalDateTime.now();
    }

    public String getNamaAktivitas() {
        return namaAktivitas;
    }

    public int getKaloriTerbakar() {
        return kaloriTerbakar;
    }

    public LocalDateTime getWaktuInput() {
        return waktuInput;
    }
}
