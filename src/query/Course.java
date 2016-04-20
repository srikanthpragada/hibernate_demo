package query;

import java.util.ArrayList;
import java.util.Collection;

public class Course {
    private int courseid;
    private String name;
    private Collection subjects = new ArrayList();

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection getSubjects() {
        return subjects;
    }

    public void setSubjects(Collection subjects) {
        this.subjects = subjects;
    }

  
}
