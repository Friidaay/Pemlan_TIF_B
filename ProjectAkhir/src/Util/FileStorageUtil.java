/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

/**
 *
 * @author ACER
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import Model.User;

public class FileStorageUtil {

    private static final String DATA_FILE_NAME = "kalori_data.ser";

    public static List<User> loadAllUsers() {
        List<User> users = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE_NAME))) {
            users = (List<User>) ois.readObject();
            System.out.println("Data pengguna berhasil dimuat dari file.");
        } catch (FileNotFoundException e) {
            System.out.println("File data '" + DATA_FILE_NAME + "' belum ada. Membuat yang baru saat penyimpanan pertama.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error memuat data pengguna: " + e.getMessage());
            e.printStackTrace();
        }
        return users;
    }

    public static void saveAllUsers(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE_NAME))) {
            oos.writeObject(users);
            System.out.println("Data pengguna berhasil disimpan ke file.");
        } catch (IOException e) {
            System.err.println("Error menyimpan data pengguna: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
