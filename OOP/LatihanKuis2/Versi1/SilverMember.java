public class SilverMember extends Member {
    SilverMember(String nama){
        super(nama);
    }

    @Override
    public String toString(){
        return (this.nama+"-Silver");
    }
}