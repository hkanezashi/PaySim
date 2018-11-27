package paysim.utils;

import ec.util.MersenneTwisterFast;

import java.util.Collection;
import java.util.NavigableMap;
import java.util.TreeMap;

public class RandomCollection<E> {
    private final NavigableMap<Double, E> map = new TreeMap<>();
    private final MersenneTwisterFast random;
    private double total = 0;

    public RandomCollection(MersenneTwisterFast random) {
        this.random = random;
    }

    public RandomCollection<E> add(double weight, E result) {
        if (weight <= 0) return this;
        total += weight;
        map.put(total, result);
        return this;
    }

    public E next() {
        double value = random.nextDouble() * total;
        return map.higherEntry(value).getValue();
    }

    public Collection<E> getCollection(){
        return map.values();
    }
}