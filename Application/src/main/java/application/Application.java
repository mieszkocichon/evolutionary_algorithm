package application;

import EA.Population;

public class Application {
    public static void main(String[] args) {
        String rangeCharacter = "AĄBCĆDEĘFGHIJKLŁMNŃOÓPRSŚTUWYZŹŻ" + "aąbcćdeęfghijklłmnńoóprsśtuwyzźż" + " ";
        String finalInscription = "Hello World";

        Population population = Population.initialize(rangeCharacter, finalInscription);
        population.initialize();
    }
}
