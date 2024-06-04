package org.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskData {

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }
    public Set<Task> getTask(String name) {

        if (name.equals("ann")) {
            return annsTasks;
        }
        if (name.equals("bob")) {
            return bobsTasks;
        }
        if (name.equals("carol")) {
            return carolsTasks;
        }
        if (name.equals("all")) {
            Set<Task> annsTasksCopy = new HashSet<>(annsTasks);
            annsTasksCopy.addAll(bobsTasks);
            annsTasksCopy.addAll(carolsTasks);
            return annsTasksCopy;

        }
        return new HashSet<>(); // Geçersiz bir isim verilmesi halinde boş küme döndür.

    }
    public static Set<Task> getUnion(List<Set<Task>> liste){
        Set<Task> union= new HashSet<>();

        for(Set<Task> set:liste){
            union.addAll(set);
        }
        return union;
    }

    public static Set<Task> getIntersect(Set<Task> set1,Set<Task> set2 ){
        Set<Task> set1Copy= new HashSet<>(set1);
        set1Copy.retainAll(set2);

        return set1Copy;

    }
    public static Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {

        Set<Task> difference = new HashSet<>(set1);

        difference.removeAll(set2);
        return difference;
    }


    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }
}
