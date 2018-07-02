package EA;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Population {
    private String rangeCharacter;
    private String finalInscription;
    private Multimap<Integer, Creature> population;

    private Population(String rangeCharacter, String finalInscription) {
        this.rangeCharacter = rangeCharacter;
        this.finalInscription = finalInscription;
        this.population = ArrayListMultimap.create();
    }

    public static Population initialize(String rangeCharacter, String finalInscription) {
        return new Population(rangeCharacter, finalInscription);
    }

    public void initialize() {
        this.firstGenerate();

        Collection<Creature> values = this.population.get(0);
        while (values.size() == 0) {
            if (population.asMap().size() > 2) {
                Set keySet = this.population.keySet();
                Iterator keyIterator = keySet.iterator();
                Integer key = (Integer) keyIterator.next();

                List<Creature> val = (List<Creature>) population.get(key);

                keyIterator.next();
                key = (Integer) keyIterator.next();

                val.addAll(population.get(key));
            }
            else {
                List<Creature> val;
            }
        }
    }

    private void firstGenerate() {
        for (int i = 0; i < 400; i++) {
            Creature creature = Creature.initialize(rangeCharacter, finalInscription);
            creature.createGenes();
            creature.calculateLevensteinDistance();

            this.population.put(creature.getLevensteinDistance(), creature);
        }
    }
}
