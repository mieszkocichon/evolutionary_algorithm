package EA;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Genes {
    private String rangeCharacter;
    private int finalInscriptionLenght;
    private List<List<String>> gen;

    private Genes(String rangeCharacter, int finalInscriptionLenght, List<List<String>> gen) {
        this.rangeCharacter = rangeCharacter;
        this.finalInscriptionLenght = finalInscriptionLenght;
        this.gen = gen;
    }

    List<List<String>> getGen() {
        return gen;
    }

    static Genes initialize(List<List<String>> gen, int finalInscriptionLenght, String rangeCharacter) {
        return new Genes(rangeCharacter, finalInscriptionLenght, gen);
    }

    void build() {
        this.rangeCharacter.chars().forEach((microb) -> {
            List<String> micr = new LinkedList<>();
            micr.add(generateMicrob());
            micr.add(generateMicrob());
            micr.add(generateMicrob());
            micr.add(generateMicrob());
            micr.add(generateMicrob());
            micr.add(generateMicrob());

            gen.add(micr);
        });
    }

    private String generateMicrob() {
        return this.rangeCharacter.charAt(randomValue()) + "";
    }

    private int randomValue() {
        return new Random().nextInt(this.finalInscriptionLenght);
    }
}
