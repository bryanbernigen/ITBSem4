import java.lang.reflect.*;

public class MobilDecoder {
    Mobil mobil;

    MobilDecoder(Mobil mobil) {
        this.mobil = mobil;
    }

    public void tambahMobilToMirip(String name) throws Exception {
        Class ClassMobil = mobil.getClass();
        Method method = ClassMobil.getDeclaredMethod("tambahMobilToMirip", String.class);
        method.setAccessible(true);
        method.invoke(mobil, name);        
    }

    public int getHarga() throws Exception {
        Class ClassMobil = mobil.getClass();
        Field field = ClassMobil.getDeclaredField("harga");
        field.setAccessible(true);
        return field.getInt(mobil);
    }
}