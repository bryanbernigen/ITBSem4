import java.io.*;

// Buat kelas FightingPokemon yang merupakan turunan dari kelas Pokemon dan mengimplementasi interface ElementalType<Integer>
class FightingPokemon extends Pokemon implements ElementalType<Integer>{

    // Atribut tolong dilihat sendiri pada diagram kelas
    protected Integer id;
    protected String elementalName;

    // Buat constructor tanpa parameter, meng-assign "Fighting" ke atribut elementalName dan mencetak "ctor1 FightingPokemon" ke layar
    public FightingPokemon() {
        super();
        this.elementalName = "Fighting";
        System.out.println("ctor1 FightingPokemon");
    }

    // Buat constructor dengan parameter String name, meng-assign "Fighting" ke atribut elementalName dan mencetak "ctor2 FightingPokemon" ke layar
    public FightingPokemon(String name) {
        super(name);
        this.elementalName = "Fighting";
        System.out.println("ctor2 FightingPokemon");
    }

    // Buat prosedur checkElement yang mencetak "[name] have [elementName] type" ke layar
    public void checkElement() {
        System.out.println(this.name + " have " + this.elementalName + " type");
    }

    // Override prosedur displayClass yang mencetak "Sub Class FightingPokemon"
    public void displayClass() {
        System.out.println("Sub Class FightingPokemon");
    }

    // Realisasi prosedur displayAura, mencetak "There is fighting spirit around"
    public void displayAura() {
        System.out.println("There is fighting spirit around");
    }

    // Realisasi prosedur specialSkill, mencetak "Special skill berserk"
    public void specialSkill() {
        System.out.println("Special skill berserk");
    }

    // Realisasi setUniqueID dan getUniqueID
    public void setUniqueID(Integer id) {
        this.id = id;
    }

    public Integer getUniqueID() {
        return this.id;
    }
}