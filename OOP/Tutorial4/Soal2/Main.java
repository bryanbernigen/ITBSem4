public class Main {
    public static void main(String[] args){
        ListMap m = new ListMap();
        m.set("Bryan", "1");
        m.set("Rani", "2");
        m.set("Kyle", "3");
        System.out.println(m.get("Bryan"));
    }
}