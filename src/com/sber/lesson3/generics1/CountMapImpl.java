package com.sber.lesson3.generics1;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<E> implements CountMap<E> {

    private Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E e) {
        map.put(e, map.getOrDefault(e, 0) + 1);
    }

    @Override
    public int getCount(E e) {
        return map.getOrDefault(e, 0);
    }

    @Override
    public int remove(Object o) {
        return map.remove(o);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<E> source) {
        source.toMap().forEach((e, integer) -> map.put(e, map.getOrDefault(e, 0) + integer));
    }

    @Override
    public Map<E, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<E, Integer> destination) {
        map.forEach((key, value) -> {
            destination.put(key, destination.getOrDefault(key, 0) + value);
        });
    }

    @Override
    public String toString() {
        return map.toString();
    }

    public static void main(String[] args) {

        System.out.println("map: ");

        CountMap<Integer> map = new CountMapImpl<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        System.out.println(map.toString());

        System.out.println("source: ");
        CountMap<Integer> source = new CountMapImpl<>();
        source.add(7);
        source.add(7);
        source.add(7);
        source.add(2);
        source.add(2);
        System.out.println(source.toString());

        System.out.println("addAll: ");
        map.addAll(source);
        System.out.println(map.toString());

        System.out.println("remove:");
        map.remove(10);
        System.out.println(map.toString());

        System.out.println("size:");
        System.out.println(map.size());

        System.out.println("toMap: ");
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(7, 2);
        map1.put(9, 4);
        map.toMap(map1);
        System.out.println(map1.toString());

    }
}