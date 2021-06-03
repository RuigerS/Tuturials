package com.rutgerspaans.rts;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
  double[][] data;
  int rows;
  int cols;

  public Matrix(int rows, int cols) {
    data = new double[rows][cols];
    this.rows = rows;
    this.cols = cols;
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        data[i][j] = Math.random() * 2 - 1;
      }
    }
  }
  public Matrix(int rows, int cols,double value) {
    data = new double[rows][cols];
    this.rows = rows;
    this.cols = cols;
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        data[i][j] = value;
      }
    }
  }

  public void add(double scaler) {
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        this.data[i][j] += scaler;
      }
    }
  }

  public void add(Matrix m) throws ShapeMismatchException {
    if (cols != m.cols || rows != m.rows) {
      throw new ShapeMismatchException("Shape Mismatch in Matrices");
    }
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        this.data[i][j] += m.data[i][j];
      }
    }
  }

  public static Matrix subtract(Matrix a, Matrix b) {
    var temp = new Matrix(a.rows, a.cols);
    for (var i = 0; i < a.rows; i++) {
      for (var j = 0; j < a.cols; j++) {
        temp.data[i][j] = a.data[i][j] - b.data[i][j];
      }
    }
    return temp;
  }

  public static Matrix transpose(Matrix a) {
    var temp = new Matrix(a.cols, a.rows);
    for (var i = 0; i < a.rows; i++) {
      for (var j = 0; j < a.cols; j++) {
        temp.data[j][i] = a.data[i][j];
      }
    }
    return temp;
  }

  public static Matrix multiply(Matrix a, Matrix b) {
    var temp = new Matrix(a.rows, b.cols);
    for (var i = 0; i < temp.rows; i++) {
      for (var j = 0; j < temp.cols; j++) {
        double sum = 0;
        for (var k = 0; k < a.cols; k++) {
          sum += a.data[i][k] * b.data[k][j];
        }
        temp.data[i][j] = sum;
      }
    }
    return temp;
  }

  public void multiply(Matrix a) {
    for (var i = 0; i < a.rows; i++) {
      for (var j = 0; j < a.cols; j++) {
        this.data[i][j] *= a.data[i][j];
      }
    }
  }

  public void multiply(double a) {
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        this.data[i][j] *= a;
      }
    }
  }

  public void activation() {
    for (var i = 0; i < this.rows; i++) {
      for (var j = 0; j < this.cols; j++) {
        this.data[i][j] = this.data[i][j]<0?0:this.data[i][j];
      }
    }
  }

  public void sigmoid() {
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++)
        this.data[i][j] = 1 / (1 + Math.exp(-this.data[i][j]));
    }
  }

  public Matrix dsigmoid() {
    var temp = new Matrix(rows, cols);
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++)
        temp.data[i][j] = this.data[i][j] * (1 - this.data[i][j]);
    }
    return temp;
  }

  public static Matrix fromArray(double[] array) {
    var temp = new Matrix(array.length, 1);
    for (var i = 0; i < array.length; i++)
      temp.data[i][0] = array[i];
    return temp;
  }

  public List<Double> toArray() {
    List<Double> temp = new ArrayList<>();
    for (var i = 0; i < rows; i++) {
      for (var j = 0; j < cols; j++) {
        temp.add(data[i][j]);
      }
    }
    return temp;
  }
}

class ShapeMismatchException extends Exception {
  public ShapeMismatchException(String s) {
    super(s);
  }
}
