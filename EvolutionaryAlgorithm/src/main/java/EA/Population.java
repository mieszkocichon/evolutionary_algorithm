package EA;

import java.util.Collection;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Population {
    private String rangeCharacter;
    private String finalInscription;
    private Multimap<Integer, Creature> creature;

    private Population(String rangeCharacter, String finalInscription) {
        this.rangeCharacter = rangeCharacter;
        this.finalInscription = finalInscription;
        this.creature = ArrayListMultimap.create();
    }

    public static Population initialize(String rangeCharacter, String finalInscription) {
        return new Population(rangeCharacter, finalInscription);
    }

    public void initialize() {
        this.firstGenerate();

        Collection<Creature> values = this.creature.get(0);
        while (values.size() == 0) {
            System.out.print("");
        }
    }

    private void firstGenerate() {
        for (int i = 0; i < 400; i++) {
            Creature creature = Creature.initialize(rangeCharacter, finalInscription);
            creature.createGenes();
            creature.calculateLevensteinDistance();

            this.creature.put(creature.getLevensteinDistance(), creature);
        }
    }
}
