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

		this.theView.addAddButtonListener(new AddListener());
		this.theView.addMinusButtonListener(new MinusListener());
		this.theView.addMulButtonListener(new MulListener());
		this.theView.addDivButtonListener(new DivListener());
		this.theView.addModButtonListener(new ModListener());
		this.theView.addCLEARButtonListener(new CLEARListener());
	}

	class AddListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			int firstNumber, secondNumber = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered

			try {

				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();

				theModel.addTwoNumbers(firstNumber, secondNumber);

				theView.setCalcSolution(theModel.getCalculationValue());

			} catch (NumberFormatException ex) {

				System.out.println(ex);

				theView.displayErrorMessage("You Need to Enter 2 Integers");

			}

		}

	}

	class MinusListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			int firstNumber, secondNumber = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered

			try {

				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();

				theModel.subtractTwoNumbers(firstNumber, secondNumber);

				theView.setCalcSolution(theModel.getCalculationValue());

			} catch (NumberFormatException ex) {

				System.out.println(ex);

				theView.displayErrorMessage("You Need to Enter 2 Integers");

			}

		}

	}

	class MulListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			int firstNumber, secondNumber = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered

			try {

				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();

				theModel.multiplyTwoNumbers(firstNumber, secondNumber);

				theView.setCalcSolution(theModel.getCalculationValue());

			} catch (NumberFormatException ex) {

				System.out.println(ex);

				theView.displayErrorMessage("You Need to Enter 2 Integers");

			}

		}

	}

	class DivListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			int firstNumber, secondNumber = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered

			try {

				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();

				theModel.divideTwoNumbers(firstNumber, secondNumber);

				theView.setCalcSolution(theModel.getCalculationValue());

			} catch (NumberFormatException ex) {

				System.out.println(ex);

				theView.displayErrorMessage("You Need to Enter 2 Integers");

			}

		}

	}

	class ModListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			int firstNumber, secondNumber = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered

			try {

				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();

				theModel.modTwoNumbers(firstNumber, secondNumber);

				theView.setCalcSolution(theModel.getCalculationValue());

			} catch (NumberFormatException ex) {

				System.out.println(ex);

				theView.displayErrorMessage("You Need to Enter 2 Integers");

			}

		}

	}

	class CLEARListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			int firstNumber, secondNumber = 0;

			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered

			try {

				theView.setFirstNumber("");
				theView.setSecondNumber("");
				theView.setCalcSolution(0);


			} catch (NumberFormatException ex) {

				System.out.println(ex);

				theView.displayErrorMessage("You Need to Enter 2 Integers");

			}

		}

	}

}
