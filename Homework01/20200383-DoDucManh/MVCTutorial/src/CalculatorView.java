// This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it. 

import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class CalculatorView extends JFrame{

	private JTextField firstNumber  = new JTextField(10);
	private JTextField secondNumber = new JTextField(10);
	private JTextField calcSolution = new JTextField(10);
	private JButton addButton = new JButton("+");
	private JButton subButton = new JButton("-");
	private JButton mulButton = new JButton("*");
	private JButton divButton = new JButton("/");
	private JButton perButton = new JButton("%");
	private JButton clrButton = new JButton("clear");
	
	CalculatorView(){
		
		// Sets up the view and adds the components
		
		JPanel calcPanel = new JPanel();
		calcPanel.setLayout(new GridLayout(6, 2));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 600);
		calcPanel.add(new JLabel("First Number:"));
		calcPanel.add(firstNumber);
		calcPanel.add(new JLabel("Second Number:"));
		calcPanel.add(secondNumber);
		calcPanel.add(new JLabel("Result:"));
		calcPanel.add(calcSolution);
		calcPanel.add(addButton);
		calcPanel.add(subButton);
		calcPanel.add(mulButton);
		calcPanel.add(divButton);
		calcPanel.add(perButton);
		calcPanel.add(clrButton);
		
		this.add(calcPanel);
		
		// End of setting up the components --------
		
	}
	
	public int getFirstNumber(){
		
		return Integer.parseInt(firstNumber.getText());
		
	}
	
	public int getSecondNumber(){
		
		return Integer.parseInt(secondNumber.getText());
		
	}
	
	public int getCalcSolution(){
		
		return Integer.parseInt(calcSolution.getText());
		
	}
	
	public void setCalcSolution(int solution){
		
		calcSolution.setText(Integer.toString(solution));
		
	}

	public void clearSolution(){
	}
	
	// If the calculateButton is clicked execute a method
	// in the Controller named actionPerformed
	
	void addCalculateListener(ActionListener listenForCalcButton){
		
		addButton.addActionListener(listenForCalcButton);
		
	}

	void subCalculateListener(ActionListener listenForCalcButton){

		subButton.addActionListener(listenForCalcButton);

	}

	void mulCalculateListener(ActionListener listenForCalcButton){

		mulButton.addActionListener(listenForCalcButton);

	}

	void divCalculateListener(ActionListener listenForCalcButton){

		divButton.addActionListener(listenForCalcButton);

	}

	void perCalculateListener(ActionListener listenForCalcButton){

		perButton.addActionListener(listenForCalcButton);

	}void clrCalculateListener(ActionListener listenForCalcButton){

		clrButton.addActionListener(listenForCalcButton);

	}

	public void clearFields() {
		firstNumber.setText("");
		secondNumber.setText("");
		calcSolution.setText("");
	}

	// Open a popup that contains the error message passed
	
	void displayErrorMessage(String errorMessage){
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}
	
}