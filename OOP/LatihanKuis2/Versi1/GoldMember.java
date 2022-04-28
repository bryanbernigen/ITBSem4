public class GoldMember extends Member {
    GoldMember(String nama){
        super(nama);
    }

    @Override
    public String toString(){
        return (this.nama + "-Gold");
    }
}