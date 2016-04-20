package inh;
public class Batsman extends Cricketer {
    private int noruns;
    public Batsman() {
    }

    public int getNoruns() {
        return noruns;
    }

    public void setNoruns(int noruns) {
        this.noruns = noruns;
    }

	@Override
	public String toString() {
		return "Batsman [cid=" + cid + ", name=" + name + ", country=" + country + " noruns = " + noruns + "]";
	}

	 
}
