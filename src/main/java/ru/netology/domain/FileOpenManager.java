package ru.netology.domain;

import java.util.*;

public class FileOpenManager {
    private final Map<String, String> map = new HashMap<>();

    public void register(String extension, String application){
        map.put(extension.toLowerCase(), application);
    }

    public String getApplicationByExtension(String extension){
        return map.get(extension.toLowerCase());
    }

    public void removeExtension(String extension){
        map.remove(extension.toLowerCase());
    }

    public List<String> getAllExtensions(){
        List<String> result = new ArrayList<>(map.keySet());
        Collections.sort(result);
        return result;
    }

    public List<String> getAllApplications(){
        List<String> result = new ArrayList<>(new HashSet<>(map.values()));
        Collections.sort(result);
        return result;
    }
}
