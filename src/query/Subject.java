package query;

import java.util.HashSet;
import java.util.Set;

public class Subject {
    private String subcode;
    private String subname;
    private Set<Title> titles = new HashSet<Title>();

    public Set<Title> getTitles() {
        return titles;
    }

    public void setTitles(Set<Title> titles) {
        this.titles = titles;
    }

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String toString(){
        return  subcode + ":" + subname;
    }



}
