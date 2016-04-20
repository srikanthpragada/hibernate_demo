package manytomany;

import java.util.HashSet;
import java.util.Set;

public class Employee {
   private int id;
   private String name;
   private Set<Project> projects = new HashSet<Project>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
    
}
