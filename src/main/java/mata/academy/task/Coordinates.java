package mata.academy.task;

public class Coordinates {
    private Integer first;
    private Integer second;

    public Coordinates(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    public static Coordinates of(int first, int second) {
        return new Coordinates(first, second);
    }

    public Integer getX() {
        return first;
    }

    public void setX(Integer first) {
        this.first = first;
    }

    public Integer getY() {
        return second;
    }

    public void setY(Integer second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "[" + first
                + ", " + second
                + ']';
    }
}
