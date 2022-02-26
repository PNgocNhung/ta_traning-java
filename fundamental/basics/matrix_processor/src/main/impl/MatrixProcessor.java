package com.epam.trainning.ngocnhung.fundamental.basics.matrix_processor.src.main.impl;

import com.epam.trainning.ngocnhung.fundamental.basics.matrix_processor.src.main.exception.MatrixProcessorException;
import com.epam.trainning.ngocnhung.fundamental.basics.matrix_processor.src.main.IMatrixProcessor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;


public class MatrixProcessor implements IMatrixProcessor {

    public static void gaussian(double[][] matrix, int[] index) {
        int n = index.length;
        double[] c = new double[n];

        // Initialize the index
        for (int i = 0; i < n; ++i)
            index[i] = i;

        // Find the rescaling factors, one from each row
        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(matrix[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {
                double pi0 = Math.abs(matrix[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                double pj = matrix[index[i]][j] / matrix[index[j]][j];

                // Record pivoting ratios below the diagonal
                matrix[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l = j + 1; l < n; ++l)
                    matrix[index[i]][l] -= pj * matrix[index[j]][l];
            }
        }
    }

    private double[][] round(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = BigDecimal.valueOf(matrix[i][j]).setScale(3, RoundingMode.HALF_UP).doubleValue();
            }
        }
        return matrix;
    }

    public double roundForNumber(double result) {
        result = BigDecimal.valueOf(result).setScale(3, RoundingMode.HALF_UP).doubleValue();
        return result;
    }

    /**
     * Matrix transpose is an operation on a matrix where its rows become columns with the same numbers.
     * Ex.:
     * |1 2|			|1 3 5|
     * |3 4|   ====>	|2 4 6|
     * |5 6|
     *
     * @param matrix - matrix for transposition
     * @return the transposed matrix
     */

    @Override
    public double[][] transpose(double[][] matrix) {

        if (matrix == null) {
            throw new MatrixProcessorException("Matrix shouldn't be null!");
        } else {
            if (matrix.length == 0 || matrix[0].length == 0) {
                throw new MatrixProcessorException("Matrix shouldn't be empty!");
            }
        }
        double[][] transposedMatrix = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return round(transposedMatrix);
    }

    /**
     * The method flips the matrix clockwise.
     * Ex.:
     * * |1 2|			|5 3 1|
     * * |3 4|   ====>	|6 4 2|
     * * |5 6|
     *
     * @param matrix - rotation matrix
     * @return rotated matrix
     */

    @Override
    public double[][] turnClockwise(double[][] matrix) {
        if (matrix == null) {
            throw new MatrixProcessorException("Matrix shouldn't be null!");
        } else {
            if (matrix.length == 0 || matrix[0].length == 0)
                throw new MatrixProcessorException("Matrix shouldn't be empty!");
        }
        transpose(matrix);
        double[][] rotatedMatrix = transpose(matrix);
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                double temp = rotatedMatrix[i][j];
                rotatedMatrix[i][j] = rotatedMatrix[i][matrix.length - j - 1];
                rotatedMatrix[i][matrix.length - j - 1] = temp;
            }
        }
        return round(rotatedMatrix);

    }

    /**
     * This method multiplies matrix firstMatrix by matrix secondMatrix
     * <p>
     * See {https://en.wikipedia.org/wiki/Matrix_multiplication}
     *
     * @param firstMatrix  - first matrix to multiply
     * @param secondMatrix - second matrix to multiply
     * @return result matrix
     */


    @Override
    public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
        if (firstMatrix == null) {
            throw new MatrixProcessorException("First matrix shouldn't be null!");
        } else {
            if (firstMatrix.length == 0 || firstMatrix[0].length == 0) {
                throw new MatrixProcessorException("First matrix shouldn't be empty!");
            }
        }

        if (secondMatrix == null) {
            throw new MatrixProcessorException("Second matrix shouldn't be null!");
        } else {
            if (secondMatrix.length == 0 || secondMatrix[0].length == 0) {
                throw new MatrixProcessorException("Second matrix shouldn't be empty!");
            }
        }

        if (firstMatrix[0].length != secondMatrix.length) {
            throw new MatrixProcessorException("Column of the first matrix should match row of the second matrix !");
        }


        double[][] multiplyMatrix = new double[firstMatrix.length][secondMatrix[0].length];
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < secondMatrix[0].length; col++) {
                for (int i = 0; i < firstMatrix[0].length; i++) {
                    multiplyMatrix[row][col] += firstMatrix[row][i] * secondMatrix[i][col];

                }
            }
        }
        return round(multiplyMatrix);
    }

    /**
     * This method returns the inverse of the matrix
     * <p>
     * See {https://en.wikipedia.org/wiki/Invertible_matrix}
     *
     * @param matrix - input matrix
     * @return inverse matrix for input matrix
     */

    @Override
    public double[][] getInverseMatrix(double[][] matrix) {

        if (matrix == null) {
            throw new MatrixProcessorException("Matrix shouldn't be null!");
        } else {
            if (matrix.length == 0 || matrix[0].length == 0) {
                throw new MatrixProcessorException("Matrix shouldn't be empty!");
            }
        }
        if (matrix.length != matrix[0].length) {
            throw new MatrixProcessorException("This is not a square matrix");
        }
        if (getMatrixDeterminant(matrix) == 0) {
            throw new MatrixProcessorException("Matrix should have positive determinant ");
        }
        int n = matrix.length;
        double[][] x = new double[n][n];
        double[][] b = new double[n][n];
        int[] index = new int[n];
        for (int i = 0; i < n; ++i)
            b[i][i] = 1;

        // Transform the matrix into an upper triangle
        gaussian(matrix, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i = 0; i < n - 1; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = 0; k < n; ++k)
                    b[index[j]][k] -= matrix[index[j]][i] * b[index[i]][k];
        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[index[n - 1]][i] / matrix[index[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= matrix[index[j]][k] * x[k][i];
                }
                x[j][i] /= matrix[index[j]][j];
            }
        }
        return round(x);
    }

    /**
     * This method returns the determinant of the matrix
     * <p>
     * See {https://en.wikipedia.org/wiki/Determinant}
     *
     * @param matrix - input matrix
     * @return determinant of input matrix
     */

    @Override
    public double getMatrixDeterminant(double[][] matrix) {

        if (matrix == null) {
            throw new MatrixProcessorException("Matrix shouldn't be null!");
        } else {
            if (matrix.length == 0 || matrix[0].length == 0) {
                throw new MatrixProcessorException("Matrix shouldn't be empty!");
            }
        }

        if (matrix.length != matrix[0].length) {
            throw new MatrixProcessorException("This is not a square matrix !");
        }

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(3);
        if (matrix.length == 1) {
            return roundForNumber(matrix[0][0]);
        }
        if (matrix.length == 2) {
            return roundForNumber(matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]);
        }
        double d = 0, sign = -1;
        for (int skipCol = 0; skipCol < matrix.length; ++skipCol) {
            double[][] newMatrix = new double[matrix.length - 1][matrix.length - 1];
            for (int row = 0; row < matrix.length - 1; ++row) {
                int matrixCol = 0;
                for (int col = 0; col < matrix.length; ++col)
                    if (col != skipCol) newMatrix[row][matrixCol++] = matrix[row + 1][col];
            }
            d += (sign *= -1) * matrix[0][skipCol] * getMatrixDeterminant(newMatrix);
        }
        return roundForNumber(d);
    }
}



