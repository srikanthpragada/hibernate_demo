package query;

public class ETitle extends Title {
    private String weburl;

    public String getWeburl() {
        return weburl;
    }

    public void setWeburl(String weburl) {
        this.weburl = weburl;
    }

    public String toString() {
        return  super.toString() + ":" + weburl;
    }

}
