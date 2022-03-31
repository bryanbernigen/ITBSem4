public class Main {
    // Make Output of program same like ans.txt
    public static void main(String[] args) {
        int i;
        System.out.println("--- Section 1 ---");
        GhostPokemon gp1 = new GhostPokemon();
        FightingPokemon fp1 = new FightingPokemon();
        NormalPokemon np1 = new NormalPokemon();
        Pokemon pk1 = new Pokemon();
        System.out.println(gp1.getName());
        System.out.println(fp1.getName());
        System.out.println(np1.getName());
        System.out.println(pk1.getName());
        GhostPokemon gp2 = new GhostPokemon("Gastly");
        FightingPokemon fp2 = new FightingPokemon("Machop");
        NormalPokemon np2 = new NormalPokemon("Rattata");
        Pokemon pk2 = new Pokemon("Big Boss");
        System.out.println(gp2.getName());
        System.out.println(fp2.getName());
        System.out.println(np2.getName());
        System.out.println(pk2.getName());
        gp1.displayClass();
        fp1.displayClass();
        np1.displayClass();
        pk1.displayClass();
        gp1.setUniqueID("G1");
        System.out.println(gp1.getUniqueID());
        fp1.setUniqueID(12);
        System.out.println(fp1.getUniqueID());

        System.out.println("--- Section 2 ---");
        gp2.checkElement();
        fp2.checkElement();
        np2.checkElement();
        gp2.specialSkill();
        fp2.displayAura();
        gp2.displayAura();
        fp2.specialSkill();

        System.out.println("--- Section 3 ---");
        gp2.displayClass();
        np2.displayClass();
        System.out.println(gp2.getName() + " vs " + np2.getName());
        PokemonAction act1 = new PokemonAction(gp2);
        PokemonAction act2 = new PokemonAction(np2);
        for (i = 0; i < 7; i++) {
            act1.attack();
            act2.defense();
        }
        for (i = 0; i < 3; i++) {
            act2.attack();
            act1.defense();
        }
        act2.useSkill();
        act1.useSkill();
        act2.run();
    

        System.out.println("--- Section 4 ---");
        System.out.println("New Battle Found");
        fp2.displayClass();
        pk2.displayClass();
        System.out.println(pk2.getName() + " vs " + fp2.getName());
        PokemonAction act3 = new PokemonAction(fp2);
        PokemonAction act4 = new PokemonAction(pk2);
        for (i = 0; i < 4; i++) {
            act3.attack();
            act4.defense();
        }
        for (i = 0; i < 8; i++) {
            act4.attack();
            act3.defense();
        }
        act3.useSkill();
        act4.useSkill();
        act3.run();
        System.out.println("All Battle Finished");
    }
}
