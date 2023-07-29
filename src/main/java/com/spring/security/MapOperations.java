package com.spring.security;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapOperations {

    private static void mapOperations() {
        Map<String, String> stateMap = new HashMap<>();
        stateMap.put("MH", "Maharashtra");
        stateMap.put("AR", "Arunachal Pradesh");
        stateMap.put("AS", "Assam");
        stateMap.put("BH", "Bihar");
        stateMap.put("CH", "Chattisgarh");
        stateMap.put("DL", "Delhi");
        stateMap.put("GA", "Goa");
        stateMap.put("GJ", "Gujrat");
        stateMap.put("HR", "Haryana");
        stateMap.put("HP", "Himachal Pradesh");
        stateMap.put("JK", "Jammu and Kashmir");
        stateMap.put("JH", "Jharkhand");
        stateMap.put("PB", "Punjab");
        stateMap.put("RJ", "Rajasthan");
        stateMap.put("SK", "Sikkim");
        stateMap.put("LA", "Ladakh");

        // Iterate using Map.EntrySet
        for (Map.Entry<String, String> entry : stateMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("State Code = " + key + " State = " + value);
        }

        //Iterate using keySet() & values() methods.
        for (String stateCode : stateMap.keySet()){
            System.out.println("State code"+stateCode);
        }

        // Iterating using Iterator
        Iterator<Map.Entry<String, String>> itr = stateMap.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<String, String> entry = itr.next();
            System.out.println("Using  Iterator<Map<String, String>> : "+entry.getKey()+" "+ entry.getValue());
        }

        stateMap.forEach((k, v)-> System.out.println("key: "+ k+" Value: "+v));

        for(var entry : stateMap.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to map all operations..!!");
        mapOperations();
    }
}
