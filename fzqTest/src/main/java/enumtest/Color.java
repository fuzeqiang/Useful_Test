package enumtest;

/**
 * Created by fuzeqiang(100918) on 2016/7/15 0015.
 */
public enum  Color {
    RED("", 0),
    WHITE("", 1),
    BLACK("", 2),
    BLUE("", 3),
    BROUWN("", 4),
    YELLOW("", 5);

    private String color;
    private int index;

    private Color(String color, int index) {
        this.color = color;
        this.index = index;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
