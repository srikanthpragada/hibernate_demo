package inh;
public class Bowler extends Cricketer {
    private int nowickets;
    public Bowler() {
    }

    public int getNowickets() {
        return nowickets;
    }

    public void setNowickets(int nowickets) {
        this.nowickets = nowickets;
    }
   
    @Override
	public String toString() {
		return "Bowler [cid=" + cid + ", name=" + name + ", country=" + country + " nowickets = " + nowickets + "]";
	}
}