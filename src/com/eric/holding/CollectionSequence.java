package com.eric.holding;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/17/2018 5:04 PM
 */
public class CollectionSequence implements Collection<Pet> {
    private Pet[] pets = Pets.createArray(8);

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            int index;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return pets;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Pet pet) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends Pet> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        if (this.size() != 0)
            for (Pet p : pets)
                p = null;
    }

    @Override
    public int size() {
        return pets.length;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0 ;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    public static void main(String[] args) {
        CollectionSequence cs = new CollectionSequence();
        InterfaceVsIterator.display(cs);
        InterfaceVsIterator.display(cs.iterator());
    }
}
