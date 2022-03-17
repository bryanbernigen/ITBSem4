public class ListMap implements Map {
    private ListMapEntry first;

    /**
     * Menambahkan (key, value) ke dalam map
     * Melakukan overwrite jika sudah terdapat elemen dengan key yang sama.
     */
    public void set(String key, String value) {
        ListMapEntry p = first;
        if (p == null) {
            first = new ListMapEntry(key, value);
        } else {
            while (!p.getKey().equals(key) && (p.getNext() != null)) {
                p = p.getNext();
            }
            if (p.getKey().equals(key)) {
                p.setValue(value);
            } else {
                p.setNext(new ListMapEntry(key, value));
            }
        }

    }

    /**
     * Mengembalikan value yang tersimpan untuk key tertentu pada map
     * Mengembalikan NULL apabila map tidak mengandung key masukan.
     */
    public String get(String key) {
        ListMapEntry p = first;
        if (p == null)
            return null;
        while (!p.getKey().equals(key) && !(p.getNext() == null)) {
            p = p.getNext();
        }
        if (p.getKey().equals(key)) {
            return (p.getValue());
        } else {
            return null;
        }
    }

    /**
     * Menghitung jumlah elemen yang ada pada map
     */
    public int size() {
        ListMapEntry p = first;
        int i = 0;
        while (p != null) {
            p = p.getNext();
            i++;
        }
        return i;
    }
}