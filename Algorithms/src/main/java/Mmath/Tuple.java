package Mmath;

import java.util.Objects;

public class Tuple<T, U> {

    final T _1;
    final U _2;

    public Tuple(T t, U u) {
        this._1 = Objects.requireNonNull(t);
        this._2 = Objects.requireNonNull(u);
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", _1,  _2);
    }
}