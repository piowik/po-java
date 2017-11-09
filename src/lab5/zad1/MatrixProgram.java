package lab5.zad1;

public class MatrixProgram {
    public static void main(String[] args) {

        int[][] arr1 = new int[2][2];
        arr1[0][0] = 1;
        arr1[0][1] = 2;
        arr1[1][0] = 3;
        arr1[1][1] = 4;
        Matrix matrix1 = new Matrix(arr1);
        matrix1.Print();
        System.out.println("--");
        int[][] arr2 = new int[2][3];
        arr2[0][0] = 1;
        arr2[0][1] = 2;
        arr2[0][2] = 3;
        arr2[1][0] = 4;
        arr2[1][1] = 5;
        arr2[1][2] = 6;
        Matrix matrix2 = new Matrix(arr2);
        matrix2.Print();

        System.out.println("--");

        String path = "F:\\IntelliJ\\workspace\\java\\java-po\\src\\lab5\\zad1\\macierz.txt";
        Matrix matrix3 = new Matrix(path);
        matrix3.Print();


    }
}
