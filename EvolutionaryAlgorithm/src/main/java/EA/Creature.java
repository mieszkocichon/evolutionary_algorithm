package EA;

import Functional.CollectionUtilities;

import java.util.LinkedList;
import java.util.List;

public class Creature {
    private String rangeCharacter;
    private List<Genes> genesList;
    private String finalInscription;

    private Creature(String rangeCharacter, String finalInscription) {
        this.rangeCharacter = rangeCharacter;
        this.finalInscription = finalInscription;
    }

    public static Creature initialize(String rangeCharacter, String finalInscription) {
        return new Creature(rangeCharacter, finalInscription);
    }

    public void createGenesList() {
        Genes genes = Genes.initialize(new LinkedList<>(), finalInscription.length(), rangeCharacter);
        genes.build();
        System.out.print("");
    }
}
