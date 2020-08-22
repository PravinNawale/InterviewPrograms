package SampleTestPrograms;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LRUCacheTest {

    public static void main(String args[]) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.accessCache(1);
        lruCache.accessCache(2);
        lruCache.accessCache(3);
        lruCache.accessCache(1);
        lruCache.accessCache(4);
        lruCache.accessCache(5);
        lruCache.display();
    }
}

class LRUCache {

    Set<Integer> cacheMemory;
    int cacheMemorySize;

    public LRUCache(int cacheMemorySize) {
        this.cacheMemory = new LinkedHashSet<>(cacheMemorySize);
        this.cacheMemorySize = cacheMemorySize;
    }

    public int get(int info) {
        if (!cacheMemory.contains(info)) {
            return -1;
        }
        cacheMemory.remove(info);
        cacheMemory.add(info);
        return info;
    }

    public void accessCache(int info) {
        if(get(info) == -1) {
            set(info);
        }
    }

    public void set(int info) {
        if (cacheMemory.contains(info)) {
            cacheMemory.remove(info);
            cacheMemory.add(info);
        } else if (cacheMemory.size() == cacheMemorySize) {
            int lastInfo = cacheMemory.iterator().next();
            cacheMemory.remove(lastInfo);
        }
        cacheMemory.add(info);
    }

    public void display()
    {
        Iterator<Integer> itr = cacheMemory.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
}
