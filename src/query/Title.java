package query;


public class Title {
    private int titleid;
    private String title;
    private int price;
    private Subject subject;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTitleid() {
        return titleid;
    }

    public void setTitleid(int titleid) {
        this.titleid = titleid;
    }

    public String toString() {
        return  titleid + ":" + title + ":" + price;  // + subject.getSubname();
    }

}
