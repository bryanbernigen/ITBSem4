import java.util.ArrayList;

public class PemberiBerita {
    protected ArrayList<Pengendara> listpengendara;
    Jalur firstjalur;

    PemberiBerita(Jalur jalur){
        this.listpengendara = new ArrayList<Pengendara>();
        firstjalur = jalur;
    }

    public void addpengendara(Pengendara p){
        this.listpengendara.add(p);
    }

    public void beriBerita(){
        boolean kosong;
        Jalur pointerjalur = firstjalur;
        while(pointerjalur.nextjalur() != null){
            if(!pointerjalur.isFull()){
                break;
            }
            else{
                pointerjalur = pointerjalur.getNextJalur();
            }
        }
        if(!pointerjalur.isFull()){
            kosong = true;
        }
        else{
            kosong = false;
        }
        for (Pengendara pengendara : listpengendara) {
            pengendara.getBerita(kosong);
        }
    }
}
