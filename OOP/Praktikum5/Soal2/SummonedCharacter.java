import java.util.ArrayList;
import java.util.List;

public class SummonedCharacter implements ISummoned {
    /*
     * Untuk tidak merusak Single Responsibility Principle, Anda ingin membuat kelas
     * adapter yang menyambungkan interface Summoned ke karakter. Buatlah kelas
     * SummonedCharacter yang:
     * 
     * Memiliki konstruktor yang menerima argumen berturut-turut:
     * Sebuah objek karakter yang disummon
     * integer yang merupakan level dari karakter saat ini
     * integer yang merupakan exp dari karakter saat ini
     * Mencatat level dan exp karakter di arena sekarang
     * Meningkatkan level
     * Mencatat spell yang sedang aktif
     * Menambahkan spell ke karakter
     * Mengimplemen interface ISummoned
     * Method render akan menuliskan pesan ke layar, diikuti baris baru.
     * Nama: {{nama}}
     * Level: {{level}}
     * Exp: {{exp}}
     * Atk: {{baseAtk}}
     * Hp: {{baseHp}}
     * Memiliki {{jumlah spell aktif}} spell aktif:
     * - {{nama spell 1}}
     * - {{nama spell 2}}
     * - ...
     * - {{nama spell n}}
     */

    private Character character;
    private int level;
    private int exp;
    private int baseAtk;
    private int baseHp;
    private List<Spell> activeSpells;

    SummonedCharacter(Character character, int level, int exp) {
        this.character = character;
        this.level = level;
        this.exp = exp;
        this.baseAtk = character.getAttackValue();
        this.baseHp = character.getHpValue();
        this.activeSpells = new ArrayList<Spell>();
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public void addSpell(Spell s) {
        activeSpells.add(s);
    }

    public List<Spell> getActiveSpells() {
        return activeSpells;
    }

    public void levelUp() {
        level++;
        exp = 0;
        this.baseAtk +=  character.getAttackUpValue();
        this.baseHp += character.getHealthUpValue();
    }

    public void render() {
        System.out.println("Nama: " + character.getName());
        System.out.println("Level: " + level);
        System.out.println("Exp: " + exp);
        System.out.println("Atk: " + this.baseAtk);
        System.out.println("Hp: " + this.baseHp);
        System.out.println("Memiliki " + activeSpells.size() + " spell aktif:");
        for (int i = 0; i < activeSpells.size(); i++) {
            System.out.println("- " + activeSpells.get(i).getName());
        }
        System.out.println();
    }
}
