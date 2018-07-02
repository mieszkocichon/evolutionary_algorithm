package EA;

import Functional.CollectionUtilities;
import Levenstein.LevensteinDistance;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Creature {
    private String rangeCharacter;
    private List<List<String>> microbDetails;
    private List<String> genes;
    private String finalInscription;
    private int levensteinDistance;

    private Creature(String rangeCharacter, String finalInscription) {
        this.rangeCharacter     = rangeCharacter;
        this.finalInscription   = finalInscription;
        this.genes              = this.fillGenesArray();
    }

    public List<List<String>> getMicrobDetails() {
        return this.microbDetails;
    }

    public List<String> getGenes() {
        return this.genes;
    }

    public int getLevensteinDistance() {
        return this.levensteinDistance;
    }

    private List<String> fillGenesArray() {
        List<String> ge = CollectionUtilities.list();

        for (int i = 0; i < finalInscription.length(); i++) {
            ge = CollectionUtilities.append(ge, this.finalInscription.charAt(new Random().nextInt(this.finalInscription.length())) + "");
        }

        return ge;
    }

    static Creature initialize(String rangeCharacter, String finalInscription) {
        return new Creature(rangeCharacter, finalInscription);
    }

    void createGenes() {
        Genes genes = Genes.initialize(new LinkedList<>(), finalInscription.length(), rangeCharacter);
        genes.build();
        microbDetails = genes.getGen();
    }

    void calculateLevensteinDistance() {
        CharSequence finalInscriptionSequence = finalInscription;
        String genesInscriptionString = String.join("", genes);
        CharSequence genesInscriptionSequence = genesInscriptionString;
        LevensteinDistance levensteinDistance = new LevensteinDistance(finalInscriptionSequence, genesInscriptionSequence);
        this.levensteinDistance = levensteinDistance.initialize();
    }
}
