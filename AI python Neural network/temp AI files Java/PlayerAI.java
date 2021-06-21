package com.rutgerspaans.rts;

import java.util.Random;

public class PlayerAI {
  private static final double RATE=1.0;
  private static final double PROB=0.05;

  int player;
  int nInputs;
  int nOutputs;
  int nHidden;
  int nHiddenSize;

  Matrix inputLayer;
  Matrix[] interLayers;
  Matrix outputLayer;

  Matrix inputBias;
  Matrix[] interBiases;
  Matrix outputBias;

  Matrix inputValues;
  Matrix outputValues;

  public PlayerAI(int player, int numberOfPlanets) {
    this.player = player;
    //  Inputs: attributes (# ships, player, level, planetnumber) of all planets
    nInputs = numberOfPlanets * 5;
    //  Outputs: moves (goto_planetnumber, aantalpercentage)
    nOutputs = 2;
    nHidden = 2;
    nHiddenSize = 15;

    inputLayer = new Matrix(nHiddenSize,nInputs,0);
    for (int i = 0; i < nHidden; i++) {
      interLayers[i] = new Matrix(nHiddenSize,nHiddenSize,0);
    }
    outputLayer = new Matrix(nOutputs,nHiddenSize,0);

    inputBias = new Matrix(nHiddenSize,1,0);
    for (int i = 0; i < nHidden; i++) {
      interBiases[i] = new Matrix(nHiddenSize,1,0);
    }
    outputBias = new Matrix(nOutputs,1,0);

    inputValues = new Matrix(nInputs,1,0);
    outputValues = new Matrix(nOutputs,1,0);
  }

  private double activation(double value) {
    //Activation function, i.e., when to action.
    return (value < 0) ? 0.0 : value;
  }

  private void evaluate() throws ShapeMismatchException {
    //Calculate the final output values by evaluating the parameters of the speciment. Pass output values through activation function.
    Matrix terms = Matrix.multiply(inputValues,inputLayer);
    terms.add(inputBias);
    for (int i = 0; i <nHidden ; i++) {
      terms=Matrix.multiply(terms,interLayers[i]);
    }
    terms.activation();
    for (int i = 0; i <nHidden ; i++) {
      terms.add(interBiases[i]);
    }
    outputValues = Matrix.multiply(terms,outputLayer);
    outputValues.add(outputBias);
  }

  private void mutate(){
    var random=new Random();
    for (var i = 0; i < nHiddenSize; i++) {
      for (var j = 0; j < nInputs; j++) {
        if(random.nextDouble()<PROB){
          inputLayer.data[i][j]+=random.nextGaussian()*RATE;
        }
      }
    }
    for (var i = 0; i < nHidden; i++) {
      for (var j = 0; j < nHiddenSize; j++) {
        for (var k = 0; k < nHiddenSize; k++) {
          if(random.nextDouble()<PROB){
            interLayers[i].data[j][k]+=random.nextGaussian()*RATE;
          }
        }
      }
    }
    for (var i = 0; i < nOutputs; i++) {
      for (int j = 0; j < nHiddenSize; j++) {
        if(random.nextDouble()<PROB){
          outputLayer.data[i][j]+=random.nextGaussian()*RATE;
        }
      }
    }
    for (int i = 0; i < nHiddenSize; i++) {
      if(random.nextDouble()<PROB){
        inputBias.data[i][0]+=random.nextGaussian()*RATE;
      }
    }
    for (var i = 0; i < nHidden; i++) {
      for (int j = 0; j < nHiddenSize; j++) {
        if(random.nextDouble()<PROB){
          interBiases[i].data[j][0]+=random.nextGaussian()*RATE;
        }
      }
    }
    for (int i = 0; i < nOutputs; i++) {
      if(random.nextDouble()<PROB){
        outputBias.data[i][0]+=random.nextGaussian()*RATE;
      }
    }
  }

  private void calc_fitness() {
  /*  This function calculates the fitness (i.e., the smartness) of the specimen
    by playing the game and returning the final score.  */
    //  return TrashBlaster().run(specimen=self, doRender=false)
  }

  private void applyInput(){
    //Fill inputValues with values

    //Compute the output: evaluate()

    //Do the reccommended actions, use outputValues as input to action

  }

  private double calcFitness(){
    //calculate the score of the game
    //return playTime*1 + planetsOwned * 1000 + shipsBuild - shipsLost*2;
    return 0.0;
  }

}
