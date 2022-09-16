package com.project;

import java.io.Serializable;
import java.util.Objects;

public class Pair<K, V> implements Serializable  {

    /*
    * Key of this <code>Pair</code>.
    */
    private K key;

    /*
    * Value of this this <code>Pair</code>.
    */
    private V value;

    public Pair(K key, V value) {
        key = this.key;
        value = this.value;
    }

    public K getKey() { return key; }

    public V getValue() { return value; }

//    public Pair(@NamedArg("key") K key, @NamedArg("value") V value) {
//        this.key = key;
//        this.value = value;
//    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (key != null ? key.hashCode() : 0);
        hash = 31 * hash + (value != null ? value.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Pair) {
            Pair pair = (Pair) o;
                    if (!Objects.equals(key, pair.key)) return false;
                    if (!Objects.equals(value, pair.value)) return false;
                    return true;
                }
            return false;
        }
}
