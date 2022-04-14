public class Main {
    public static void main(String[] args) {
        Character c = new Character("c", 1, 1, 1, 1);
        SummonedCharacter sc = new SummonedCharacter(c, 1, 1);
        Spell s = new Spell("s");
        Spell s2 = new Spell("s2");
        sc.levelUp();
        sc.addSpell(s);
        sc.addSpell(s2);
        sc.render();
    }
}
