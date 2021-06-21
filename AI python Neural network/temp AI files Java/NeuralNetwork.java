package com.rutgerspaans.rts;

import java.util.List;
import java.util.Random;

public class NeuralNetwork {
  Matrix weightsMatrixInputAndHidden;
  Matrix weightsMatrixHiddenAndOutput;
  Matrix biasMatrixHidden;
  Matrix biasMatrixOutput;
  double learningRate = 0.01;

  public NeuralNetwork(int inputCells, int hiddenCells, int outputCells) {
    weightsMatrixInputAndHidden = new Matrix(hiddenCells, inputCells);
    weightsMatrixHiddenAndOutput = new Matrix(outputCells, hiddenCells);
    biasMatrixHidden = new Matrix(hiddenCells, 1);
    biasMatrixOutput = new Matrix(outputCells, 1);
  }

  public List<Double> predict(double[] data) throws ShapeMismatchException {
    Matrix input = Matrix.fromArray(data);
    Matrix hidden = Matrix.multiply(weightsMatrixInputAndHidden, input);
    hidden.add(biasMatrixHidden);
    hidden.sigmoid();
    Matrix output = Matrix.multiply(weightsMatrixHiddenAndOutput, hidden);
    output.add(biasMatrixOutput);
    output.sigmoid();
    return output.toArray();
  }

  public void train(double[] xSampleN, double[] ySampleN) throws ShapeMismatchException {
    Matrix input = Matrix.fromArray(xSampleN);
    Matrix hidden = Matrix.multiply(weightsMatrixInputAndHidden, input);
    hidden.add(biasMatrixHidden);
    hidden.sigmoid();
    Matrix output = Matrix.multiply(weightsMatrixHiddenAndOutput, hidden);
    output.add(biasMatrixOutput);
    output.sigmoid();
    Matrix target = Matrix.fromArray(ySampleN);
    Matrix error = Matrix.subtract(target, output);
    Matrix gradient = output.dsigmoid();
    gradient.multiply(error);
    gradient.multiply(learningRate);
    Matrix hiddenMatrixTransposed = Matrix.transpose(hidden);
    Matrix weightsMatrixHiddenAndOutputDelta = Matrix.multiply(gradient, hiddenMatrixTransposed);
    weightsMatrixHiddenAndOutput.add(weightsMatrixHiddenAndOutputDelta);
    biasMatrixOutput.add(gradient);
    Matrix weightsMatrixHiddenAndOutputDeltaTransposed = Matrix.transpose(weightsMatrixHiddenAndOutput);
    Matrix hiddenErrors = Matrix.multiply(weightsMatrixHiddenAndOutputDeltaTransposed, error);
    Matrix hiddenGradient = hidden.dsigmoid();
    hiddenGradient.multiply(hiddenErrors);
    hiddenGradient.multiply(learningRate);
    Matrix inputTranspose = Matrix.transpose(input);
    Matrix weightsMatrixInputAndHiddenDelta = Matrix.multiply(hiddenGradient, inputTranspose);
    weightsMatrixInputAndHidden.add(weightsMatrixInputAndHiddenDelta);
    biasMatrixHidden.add(hiddenGradient);
  }

  public void fit(double[][] inputA, double[][] targetB, int epochs) throws ShapeMismatchException {
    for (var i = 0; i < epochs; i++) {
      var random=new Random();
      int sampleN = random.nextInt() * inputA.length;
      this.train(inputA[sampleN], targetB[sampleN]);
    }
  }
}


