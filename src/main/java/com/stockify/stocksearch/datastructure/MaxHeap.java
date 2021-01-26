package com.stockify.stocksearch.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxHeap<T extends Comparable & HeapNode> {

    private int arraySize = 50;
    T[] heap;


    private int heapSize = 0;

    private Map<String, Integer> keyMap = new HashMap<>();

    public MaxHeap(T[] heap) {
        this.heap = heap;
        arraySize = heap.length;
    }

    public int getHeapSize() {
        return heapSize;
    }
    public void fixHeap(int currentIndx) {
        while (heap[currentIndx].compareTo(heap[parent(currentIndx)]) > 0) {
            swap(currentIndx, parent(currentIndx));
            currentIndx = parent(currentIndx);
        }
    }

    public void heapify(int max) {
        int indx =0;
        while (!isLeaf(indx,max) && !isValidParent(indx,max)){
            int child = positionToSwap(indx,max);
            swap(indx, child);
            indx=child;
        }
    }

    private void resize(int  newSize){
        heap = Arrays.copyOf(heap, newSize);
        arraySize = newSize;
    }

    public void insert(T newNode) {
        if(heapSize+1 == arraySize){
            resize(arraySize*2);
        }
        heap[heapSize++] = newNode;
        fixHeap(heapSize-1);
    }

    // Returns position of parent
    private int parent(int pos) {
        return pos / 2;
    }

    // right children.
    private int leftChild(int pos) {
        return (2 * pos)+1;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    public boolean isLeaf(int pos, int size){
        return leftChild(pos)>size && rightChild(pos)>size;
    }

    public boolean isValidParent(int pos,int size){
        if(rightChild(pos) > size){
            return (heap[pos].compareTo(heap[leftChild(pos)]) > 0);
        }
        return((heap[pos].compareTo(heap[leftChild(pos)]) > 0) && (heap[pos].compareTo(heap[rightChild(pos)]) > 0));
    }

    public int positionToSwap(int pos, int size){
        if(rightChild(pos) > size){
            return leftChild(pos);
        }
        return (heap[leftChild(pos)].compareTo(heap[rightChild(pos)]) > 0)?leftChild(pos):rightChild(pos);
    }

    private void swap(int fpos, int spos) {
        T tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    public T[] sort(){
        for (int i=heapSize-1;i>0;i--){
            swap(0,i);
            keyMap.put(heap[i].getKey(),i);
            heapify(i-1);
        }
        keyMap.put(heap[0].getKey(),0);
        return  heap;
    }

    public Map<String, Integer> getKeyMap() {
        return keyMap;
    }


}
