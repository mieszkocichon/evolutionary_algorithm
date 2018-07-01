package application;

import EA.Creature;

public class Application {
    public static void main(String[] args) {
        String rangeCharacter = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPRSŚTUWYZŹŻ" + "aąbcćdeęfghijklłmnńoóprsśtuwyzźż" + " ";
        String finalInscription = "Hello World";
        Creature creature = Creature.initialize(rangeCharacter, finalInscription);
        creature.createGenesList();
    }
}
