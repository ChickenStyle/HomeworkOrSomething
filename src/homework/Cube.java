package homework;

public class Cube {

    private int edgeLength;
    private String color;

    public Cube(int edgeLength, String color) {
        this.edgeLength = edgeLength;
        this.color = color;
    }

    public int getEdgeLength() {
        return edgeLength;
    }

    public void setEdgeLength(int edgeLength) {
        this.edgeLength = edgeLength;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cube{" + "edgeLength=" + edgeLength + ", color='" + color + '\'' + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cube)) return false;
        Cube cube = (Cube) object;
        return cube.getColor().equalsIgnoreCase(color) && cube.getEdgeLength() == edgeLength;
    }
}
