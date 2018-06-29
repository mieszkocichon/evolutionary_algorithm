package Levenstein;

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
                try {
                    distance[i][j] = min(
                            distance[i - 1][j] + 1,
                            distance[i][j - 1] + 1,
                            distance[i - 1][j - 1] +
                                    (this.destinationInscription.charAt(i - 1)
                                            == this.primitiveInscription.charAt(j - 1) ? 0 : 1)
                    );
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return distance[destinationInscription.length()][primitiveInscription.length()];
    }

    private static int min(int a, int b, int c) throws IllegalAccessException {
        if (a != a || b != b)
            throw new IllegalAccessException("Not a Number");
        return (a < b) ? ((a < c) ? a  : c) : ((b < c)? b : c);
    }
}
