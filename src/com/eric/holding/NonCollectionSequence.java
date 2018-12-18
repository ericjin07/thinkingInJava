package com.eric.holding;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/17/2018 5:15 PM
 */
public class NonCollectionSequence extends PetSequence implements Iterable<Pet>{

    public Iterator<Pet> iterator(){
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

    public Iterable<Pet> reverse() {
        return new Iterable<Pet>() {

            @Override
            public Iterator<Pet> iterator() {
                return new Iterator<Pet>() {
                    int idx = pets.length - 1;
                    @Override
                    public boolean hasNext() {
                        return idx > -1;
                    }

                    @Override
                    public Pet next() {
                        return pets[idx--];
                    }
                };
            }
        };
    }

    public Iterable<Pet> randomized() {
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                List<Pet> shuffle = new ArrayList<>(Arrays.asList(pets));   //这个会把数组复制一遍,不会对原有数组进行操作
//                List<Pet> shuffle = Arrays.asList(pets);          这个方法直接把底层数据当成数据,会操作原有数组
                Collections.shuffle(shuffle,new Random(2));
                return shuffle.iterator();
            }
        };
    }


    public static void main(String[] args) {
        NonCollectionSequence ncs = new NonCollectionSequence();
        InterfaceVsIterator.display(ncs.iterator());
        for (Pet p : ncs.reverse()){
            System.out.print(p.id() + " : " + p  + " ");
        }
        System.out.println();
        for (Pet p : ncs.randomized()){
            System.out.print(p.id() + " : " + p  + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(ncs.pets));
    }
}


class PetSequence {
    Pet[] pets = Pets.createArray(9);
}