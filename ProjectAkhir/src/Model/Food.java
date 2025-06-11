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

public class Food implements Serializable {
    private static final long serialVersionUID = 1L;
    private String namaMakanan;
    private int kaloriTambahan;
    private LocalDateTime waktuInput;

    public Food(String namaMakanan, int kaloriTambahan) {
        this.namaMakanan = namaMakanan;
        this.kaloriTambahan = kaloriTambahan;
        this.waktuInput = LocalDateTime.now();
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public int getKaloriTambahan() {
        return kaloriTambahan;
    }

    public LocalDateTime getWaktuInput() {
        return waktuInput;
    }
}
