package Soal1;

import java.lang.reflect.Method;
import java.io.File;
import java.lang.reflect.Field;

public class LaptopTest {
    // Anda boleh menambahkan atribut yang diperlukan
    public Class laptop;

    public LaptopTest(String className) {
        /**
         * Memeriksa apakah ada kelas dengan nama className.
         * Jika tidak, tuliskan "Tidak ada kelas dengan nama yang diberikan" (tanpa petik) ke layar
         */
        try {
            laptop = Class.forName(className);
        } catch (Exception e) {
            System.out.println("Tidak ada kelas dengan nama yang diberikan");
        }
        
    }

    public boolean testMethods() {
        boolean result = true;
        Method[] methods = laptop.getDeclaredMethods();
        if (methods.length == 1/* hanya ada 1 method di kelas yang diberikan */) {
            // Jika nama method bukan getRamSize, tuliskan "Nama method harus getRamSize" (tanpa petik) ke layar
            // Jika tipe return bukan Integer, tuliskan "Tipe return method harus Integer" (tanpa petik) ke layar
            if(methods[0].getName() != "getRamSize"){
                System.out.println("Nama method harus getRamSize");
                result = false;
            }
            if(methods[0].getReturnType() != Integer.class){
                System.out.println("Tipe return method harus Integer");
                result = false;
            }
        } else {
            // Menuliskan "Banyaknya method hanya boleh 1" (tanpa petik) ke layar
            System.out.println("Banyaknya method hanya boleh 1");
            result = false;
        }
        return result;
        // Return true jika semua tes berhasil
        // Jika ada 1 yang salah, return false
    }

    public boolean testFields() {
        boolean result = true;
        Field[] fields = laptop.getDeclaredFields();

        if (fields.length==1/* hanya ada 1 field di kelas yang diberikan */) {
            // Jika nama field bukan serialNumber, tuliskan "Nama field harus serialNumber" (tanpa petik) ke layar
            // Jika tipe return bukan String, tuliskan "Tipe field harus String" (tanpa petik) ke layar
            if(fields[0].getName() != "serialNumber"){
                System.out.println("Nama field harus serialNumber");
                result = false;
            }
            if(fields[0].getType() != String.class){
                System.out.println("Tipe field harus String");
                result = false;
            }
        } else {
            // Menuliskan "Banyaknya field hanya boleh 1" (tanpa petik) ke layar
            System.out.println("Banyaknya field hanya boleh 1");
            result = false;
        }
        // Return true jika semua tes berhasil
        // Jika ada 1 yang salah, return false
        return result;
    }
}