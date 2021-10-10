package homework;

import java.util.Scanner;

public class CubesMain {

    private static Scanner scanner = new Scanner(System.in);
    // 1 - add, 2 - remove 0 - quit
    public static void main(String[] args) {
        System.out.println("Enter Max Cuber Tower Size:");
        int cubesTowerSize = scanner.nextInt();
        CubesTower tower = new CubesTower(cubesTowerSize);

        while (true) {
            System.out.println("Enter Function Number:");
            System.out.println("1 - add cube, 2 - remove top cube, 0 - quit the program");
            int function = scanner.nextInt();

            if (function == 0) break;

            if (function == 1) {
                System.out.println("Enter Cube Color");
                String color = scanner.next();

                System.out.println("Enter Cube Edge Length");
                int edgeLength = scanner.nextInt();

                tower.addCube(new Cube(edgeLength,color));


            }

            if (function == 2) {
                tower.removeTopCube();
            }


        }

        System.out.println(tower.buildNewTower());

    }

    private static CubesTower buildNewTower(CubesTower tower) {
        CubesTower cubesTower = new CubesTower(tower.getCubes().length);

        for (int i = 0; i < tower.getCubesAmount();i++) {
            if (!cubesTower.hasColor(tower.getCubes()[i].getColor())) {
                cubesTower.addCube(tower.getCubes()[i]);
            }
        }

        for (int i = 0; i < tower.getCubesAmount();i++) {
            tower.removeTopCube();
        }

        return cubesTower;

    }

}
