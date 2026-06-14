public class Restaurant {
    private String name;
    private String causine;
    private int rank;

    public Restaurant (int rank, String name, String causine) {
        this.rank = rank;
        this.name = name;
        this.causine = causine;
    }

    public String getName() {
        return name;
    }

    public String getCausine() {
        return causine;
    }

    public int getRank() {
        return rank;
    }

    public String toString(){
        return rank + ". " + name + " (" + causine + ")";
    }
}

