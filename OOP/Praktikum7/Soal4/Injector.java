package Soal4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Injector {
    ArrayList<Object> classes = new ArrayList<>();
    // Menerima sebuah definisi dependencies
    // yang berupa sebuah instansiasi kelas
    // Catatan: Injector bisa menampung lebih dari 1 dependency,
    // jadi injector bisa menginject banyak sekaligus.
    // Jika ada 2 objek dengan kelas yang sama,
    // inject dengan object terakhir yang di add ke daftar dependency
    void addDependencies(Object object) {
        classes.add(object);
    };

    /*
     * Menginjeksi dependencies yang telah dibuat ke dalam objek
     * Injeksi dilakukan dengan mengacu pada dependencies yang ditambah
     * pada method addDependencies.
     * 
     * Setiap field di object yang diinject, bila kelasnya
     * sudah ditambahkan sebagai dependency, maka akan diset sebagai
     * object yang sudah di add didependency.
     */
    void inject(Object object) throws Exception {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            for (Object clazz : classes) {
                if (field.getType().equals(clazz.getClass())) {
                    field.setAccessible(true);
                    field.set(object, clazz);
                }
            }
        }
    }
}
