package com.sber.lesson4.generics1;

import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.function.Consumer;

public interface CountMap<T> {

    // добавляет элемент в этот контейнер.
    void add(T o);

    //Возвращает количество добавлений данного элемента
    int getCount(T o);

    //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
    int remove(Object o);

    //количество разных элементов
    int size();

    //Добавить все элементы из source в текущий контейнер,
    // при совпадении ключей,     суммировать значения
    void addAll(CountMap<T> source);

    //Вернуть java.util.Map. ключ - добавленный элемент,
    // значение - количество его добавлений
    Map<T, Integer> toMap();

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    void toMap(Map<T, Integer> destination);

    //реализация перебора
    default void forEach(Consumer<? super T> consumer) {
        for (Map.Entry<T, Integer> entry: toMap().entrySet()) {
            T t;
            try {
                t = entry.getKey();
            } catch (IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }
            consumer.accept(t);
        }
    }
}
