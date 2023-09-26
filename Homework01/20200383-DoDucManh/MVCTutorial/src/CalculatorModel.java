// The Model performs all the calculations needed
// and that is it. It doesn't know the View 
// exists

public class CalculatorModel {

	// Holds the value of the sum of the numbers
	// entered in the view
	
	private int calculationValue;
	
	public void addTwoNumbers(int firstNumber, int secondNumber){
		
		calculationValue = firstNumber + secondNumber;
		
	}

	public void subTwoNumbers(int firstNumber, int secondNumber){

		calculationValue = firstNumber - secondNumber;

	}

	public void mulTwoNumbers(int firstNumber, int secondNumber){

		calculationValue = firstNumber * secondNumber;

	}

	public void divTwoNumbers(int firstNumber, int secondNumber){

		calculationValue = firstNumber / secondNumber;

	}

	public void perTwoNumbers(int firstNumber, int secondNumber){

		calculationValue = ((firstNumber * secondNumber)/100);

	}
	
	public int getCalculationValue(){
		
		return calculationValue;
		
	}
	
}