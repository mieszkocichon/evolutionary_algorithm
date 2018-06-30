package Levenstein;

import Mmath.Mmath;
import Mmath.Tuple;

public class LevensteinDistance {
    private CharSequence destinationInscription;
    private CharSequence primitiveInscription;

    private LevensteinDistance(CharSequence destinationInscription, CharSequence primitiveInscription) {
        this.destinationInscription = destinationInscription;
        this.primitiveInscription = primitiveInscription;
    }

    public static LevensteinDistance build(CharSequence destinationInscription, CharSequence primitiveInscription) {
        return new LevensteinDistance(destinationInscription, primitiveInscription);
    }

    public int initialize() {
        int[][] distance = new int[this.destinationInscription.length() + 1][this.primitiveInscription.length() + 1];

        for (int i = 0; i <= this.destinationInscription.length(); i++) {
            distance[i][0] = i;
        }
        for (int j = 1; j <= this.primitiveInscription.length(); j++) {
            distance[0][j] = j;
        }

        for (int i = 1; i <= this.destinationInscription.length(); i++) {
            for (int j = 1; j <= this.primitiveInscription.length(); j++) {
                distance[i][j] = Mmath.min.apply(
                        new Tuple<>(
                                distance[i - 1][j] + 1,
                                Mmath.min.apply(
                                        new Tuple<>(
                                                distance[i][j - 1] + 1,
                                                distance[i - 1][j - 1]
                                                        + (this.destinationInscription.charAt(i - 1) == this.primitiveInscription.charAt(j - 1) ? 0 : 1)))));


            }
        }

        return distance[destinationInscription.length()][primitiveInscription.length()];
    }
}

