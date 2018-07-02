package EA;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Mutation {
    public static List<String> build(Creature parent1, Creature parent2, String finalInscription) {

        List<String> child = new LinkedList<>();

        for (int i = 0; i < finalInscription.length(); i++) {
            final int random = new Random().nextInt(101);
            if (random < 5) {

            }

        }

        return child;
    }
}
