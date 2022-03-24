public class Crewmate {

    public String name;
    public boolean isDead;
    private int stabCount;
    static int id = 1;

    public Crewmate() {
        this.name = "Crewmate " + id;
        this.stabCount = 0;
        id++;

    }

    public Crewmate(String name) {
        this.name = name;
        this.stabCount = 0;
    }

    public void stab(Crewmate victim) {
        if (this.isDead) {
            System.out.println(this.name + " is dead");
        } else {
            System.out.println(this.name + " stabs " + victim.name);
            victim.isDead = true;
            this.stabCount++;
        }
    }

    @Override
    public String toString() {
        if (isDead) {
            return name + " is dead";
        } else if (stabCount > 0) {
            return name + " is sus";
        } else {
            return name + " is cool";
        }
    }
}