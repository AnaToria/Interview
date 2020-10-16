package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	    MyDataStructure myStruct = new MyDataStructure();
	    myStruct.Add(1);
        myStruct.Add(4);
        myStruct.Add(8);
        myStruct.Add(1);
        System.out.println("After adding elements : " + myStruct.toString());
        myStruct.Remove(9);
        System.out.println("After removing 9 : " + myStruct.toString());
        myStruct.Remove(4);
        System.out.println("After removing 4 : " + myStruct.toString());
    }

    static class MyDataStructure {
        ArrayList<Integer> array;
        // keys are array elements and values are indexes
        HashMap<Integer, Integer> hash;

        // constructor
        public MyDataStructure() {
            array = new ArrayList<Integer>();
            hash = new HashMap<Integer, Integer>();
        }

        // adding elements
        void Add(int x) {
            // if the element is already in the structure, do nothing
            if (hash.get(x)!=null) {
                return;
            }

            // else add the element in the array and hash
            array.add(x);
            hash.put(x, array.size()-1);
        }

        // removing elements
        void Remove(int x) {
            Integer index = hash.get(x);
            // if the element is not in the array
            if(index==null){
                return;
            }

            // if the element is in the array, remove from hash
            hash.remove(x);

            // swap element with the last element
            Integer lastIndex=array.get(array.size()-1);
            Collections.swap(array,index, array.size()-1);
            // then remove procedure will be done in O(1)
            array.remove(array.size()-1);

            // update index of the last element
            hash.put(lastIndex, index);
        }

        // overload toString method
        public String toString() {
            return Arrays.toString(array.toArray());
        }
    }
}
