package lab5.zad1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Matrix {
    int size_horizontal;
    int size_vertical;
    int[][] matrix = new int[size_horizontal][size_vertical];

    Matrix(int[][] _matrix) {
        this.matrix = _matrix;
        this.size_horizontal = _matrix.length;
        this.size_vertical = _matrix[0].length;
    }

    Matrix(String path) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            LinkedList<String> inputList = new LinkedList<>();
            String line;
            int[][] outputMatrix = null;
                int size = 0;
                while ((line = bf.readLine()) != null) {
                    inputList.add(line);
                    size = line.trim().split(",").length;
                }
                bf.close();
                outputMatrix = new int[inputList.size()][size];
                for (int i = 0; i < inputList.size(); i++) {
                    String[] vals = inputList.get(i).trim().split(",");
                    for (int j = 0; j < vals.length; j++) {
                        outputMatrix[i][j] = Integer.parseInt(vals[j]);
                    }
                }

            this.matrix = outputMatrix;
            this.size_horizontal = outputMatrix.length;
            this.size_vertical = outputMatrix[0].length;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Matrix Add(Matrix matrix_1) throws MatrixDimensionsException {
        int[][] output_matrix = new int[size_horizontal][size_vertical];
        if (size_horizontal != matrix_1.size_horizontal || size_vertical != matrix_1.size_vertical)
            throw new MatrixDimensionsException();

        for (int i = 0; i < this.size_horizontal; i++) {
            for (int j = 0; j < this.size_vertical; j++) {
                output_matrix[i][j] = this.matrix[i][j] + matrix_1.matrix[i][j];
            }
        }

        return new Matrix(output_matrix);
    }

    public Matrix Sub(Matrix matrix_1) throws MatrixDimensionsException {
        int[][] output_matrix = new int[size_horizontal][size_vertical];
        if (size_horizontal != matrix_1.size_horizontal || size_vertical != matrix_1.size_vertical)
            throw new MatrixDimensionsException();

        for (int i = 0; i < this.size_horizontal; i++) {
            for (int j = 0; j < this.size_vertical; j++) {
                output_matrix[i][j] = this.matrix[i][j] - matrix_1.matrix[i][j];
            }
        }
        return new Matrix(output_matrix);
    }

    public Matrix Mul(Matrix matrix_1) throws MatrixDimensionsException {
        if (this.size_horizontal != matrix_1.size_vertical)
            throw new MatrixDimensionsException();
        int[][] output_matrix = new int[size_horizontal][size_vertical];
        for (int current_row = 0; current_row < size_horizontal; current_row++) {
            for (int current_col = 0; current_col < size_vertical; current_col++) {
                int current_element = 0;
                for (int k = 0; k < size_vertical; k++) {
                    current_element += this.matrix[current_row][k] * matrix_1.matrix[k][current_col];
                }
                output_matrix[current_row][current_col] = current_element;
            }
        }
        return new Matrix(output_matrix);
    }

    public void Print() {
        for (int i = 0; i < this.size_horizontal; i++) {
            for (int j = 0; j < this.size_vertical; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}