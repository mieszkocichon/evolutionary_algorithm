package application;

import Levenstein.LevensteinDistance;

public class Application {
    public static void main(String[] args) {
        LevensteinDistance levensteinDistance = LevensteinDistance.build(new StringBuffer("sitting"), new StringBuffer("kitten"));
        System.out.print(levensteinDistance.initialize());
    }
}
