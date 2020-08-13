package leetcode.hash;

import java.util.HashMap;

/**
 *  https://leetcode.com/problems/insert-delete-getrandom-o1/
 *  380. Insert Delete GetRandom O(1)
 *  Medium
 *
 *  代码面试指南 P474
 *  insert,delete,gtRandom时间复杂度都是O(1) 利用HashMap
 */
public class RandomizedSet {
    public static void main(String[] args) {
//// Init an empty set.
//        RandomizedSet randomSet = new RandomizedSet();
//
//// Inserts 1 to the set. Returns true as 1 was inserted successfully.
//        System.out.println(randomSet.insert(1));
//
//// Returns false as 2 does not exist in the set.
//        System.out.println(randomSet.remove(2));
//
//// Inserts 2 to the set, returns true. Set now contains [1,2].
//        System.out.println(randomSet.insert(2));
//
//// getRandom should return either 1 or 2 randomly.
//        System.out.println(randomSet.getRandom());
//
//// Removes 1 from the set, returns true. Set now contains [2].
//        System.out.println(randomSet.remove(1));
//
//// 2 was already in the set, so return false.
//        System.out.println(randomSet.insert(2));
//
//// Since 2 is the only number in the set, getRandom always return 2.
//        System.out.println(randomSet.getRandom());

        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.insert(0));
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.remove(1));
        System.out.println("size:"+randomSet.size);
        System.out.println(randomSet.keyIndexMap);
        System.out.println(randomSet.indexKeyMap);
        System.out.println(randomSet.getRandom());//2

    }

    public int size; //index
    public HashMap<Integer,Integer> keyIndexMap;
    public HashMap<Integer,Integer> indexKeyMap;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.keyIndexMap = new HashMap<Integer, Integer>();
        this.indexKeyMap = new HashMap<Integer, Integer>();
        this.size = 0;

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!this.keyIndexMap.containsKey(val)){
            this.keyIndexMap.put(val, this.size);
            this.indexKeyMap.put(this.size,val);
            this.size++;
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(this.keyIndexMap.containsKey(val)){
            int deleteIndex = this.keyIndexMap.get(val);
            int lastIndex = this.size - 1;
            int lastKey = this.indexKeyMap.get(lastIndex);
            this.keyIndexMap.put(lastKey,deleteIndex);
            this.keyIndexMap.remove(val);
            this.indexKeyMap.put(deleteIndex,lastKey);
            this.indexKeyMap.remove(lastIndex);
            this.size--;
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(this.size == 0){
            return -1;
        }
        int randomIndex = (int)(Math.random() * this.size);
        return this.indexKeyMap.get(randomIndex);
    }
}
