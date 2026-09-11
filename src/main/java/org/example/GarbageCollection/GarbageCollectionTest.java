package org.example.GarbageCollection;

public class GarbageCollectionTest {
    public void finalize(){
        System.out.println("Garbage is collected"); // called before unreferenced object is removed
    }

    public static void main(String[] args) {
        GarbageCollectionTest garbageCollectionTest=new GarbageCollectionTest();
        GarbageCollectionTest garbageCollectionTest1=new GarbageCollectionTest();
        garbageCollectionTest=null;
        garbageCollectionTest=null;
        System.gc();// Call garbage collector
    }
}
