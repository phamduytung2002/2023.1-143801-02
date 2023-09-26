import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The Controller coordinates interactions
// between the View and Model

public class CalculatorController {

	private CalculatorView theView;
	private CalculatorModel theModel;

	public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
		this.theView = theView;
		this.theModel = theModel;

		// Tell the View that when ever the calculate button
		// is clicked to execute the actionPerformed method
		// in the CalculateListener inner class

		this.theView.addCalculateListener(new CalculateListener());
		this.theView.subCalculateListener(new SubtractListener());
		this.theView.mulCalculateListener(new MultiplyListener());
		this.theView.divCalculateListener(new DivideListener());
		this.theView.perCalculateListener(new PercentageListener());
		this.theView.clrCalculateListener(new ClearListener());
	}

	class CalculateListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			int firstNumber, secondNumber = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered

			try{

				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();

				theModel.addTwoNumbers(firstNumber, secondNumber);

				theView.setCalcSolution(theModel.getCalculationValue());

			}

			catch(NumberFormatException ex){

				System.out.println(ex);

				theView.displayErrorMessage("You Need to Enter 2 Integers");

			}

		}

	}

	class SubtractListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			int firstNumber, secondNumber = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered

			try{

				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();

				theModel.subTwoNumbers(firstNumber, secondNumber);

				theView.setCalcSolution(theModel.getCalculationValue());

			}

			catch(NumberFormatException ex){

				System.out.println(ex);

				theView.displayErrorMessage("You Need to Enter 2 Integers");

			}

		}

	}

	class MultiplyListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			int firstNumber, secondNumber = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered

			try{

				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();

				theModel.mulTwoNumbers(firstNumber, secondNumber);

				theView.setCalcSolution(theModel.getCalculationValue());

			}

			catch(NumberFormatException ex){

				System.out.println(ex);

				theView.displayErrorMessage("You Need to Enter 2 Integers");

			}

		}

	}

	class DivideListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			int firstNumber, secondNumber = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered

			try{

				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();

				theModel.divTwoNumbers(firstNumber, secondNumber);

				theView.setCalcSolution(theModel.getCalculationValue());

			}

			catch(NumberFormatException ex){

				System.out.println(ex);

				theView.displayErrorMessage("You Need to Enter 2 Integers");

			}

		}

	}

	class PercentageListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			int firstNumber, secondNumber = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered

			try{

				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();

				theModel.perTwoNumbers(firstNumber, secondNumber);

				theView.setCalcSolution(theModel.getCalculationValue());

			}

			catch(NumberFormatException ex){

				System.out.println(ex);

				theView.displayErrorMessage("You Need to Enter 2 Integers");

			}

		}

	}

	class ClearListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			theView.clearFields();
		}

	}

}