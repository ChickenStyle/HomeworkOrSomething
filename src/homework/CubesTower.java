package homework;

import java.util.Arrays;

public class CubesTower {

    private Cube[] cubes;
    private int cubesAmount;

    public CubesTower(int size) {
        this.cubes = new Cube[size];
        cubesAmount = 0;
    }

    public void addCube(Cube cube) {
        if (cubesAmount < cubes.length) {
            this.cubes[cubesAmount] = cube;
            cubesAmount++;
        }
    }

    public void removeTopCube() {
        if (cubesAmount > 0) {
            cubesAmount--;
            this.cubes[cubesAmount] = null;
        }
    }

    public boolean hasColor(String color) {
        for (int i = 0; i < cubesAmount;i++) {
            if (this.cubes[i].getColor().equalsIgnoreCase(color)) {
                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        return cubesAmount == 0;
    }


    public boolean isFull() {
        return cubesAmount == this.cubes.length;
    }

    public Cube[] getCubes() {
        return cubes;
    }

    public int getCubesAmount() {
        return cubesAmount;
    }

    @Override
    public String toString() {
        return "CubesTower{" + "cubes=" + Arrays.toString(cubes) + ", cubesAmount=" + cubesAmount + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CubesTower)) return false;
        CubesTower tower = (CubesTower) object;
        if (tower.getCubesAmount() != cubesAmount) return false;

        for (int i = 0; i < this.cubesAmount;i++) {
            if (!tower.getCubes()[i].equals(cubes[i])) return false;
        }

        return true;

    }

    public CubesTower buildNewTower() {
        CubesTower tower = new CubesTower(cubes.length);

        for (int i = 0; i < this.cubesAmount;i++) {
            if (!tower.hasColor(cubes[i].getColor())) {
                tower.addCube(cubes[i]);
            }
        }

        for (int i = 0; i < this.cubesAmount;i++) {
            removeTopCube();
        }


        return tower;
    }
}
