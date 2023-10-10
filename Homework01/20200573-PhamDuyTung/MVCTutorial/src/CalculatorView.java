// This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it.

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorView extends JFrame{

	private JTextField firstNumber  = new JTextField(10);
	private JTextField secondNumber = new JTextField(10);
	private JTextField calcSolution = new JTextField(10);
	private JLabel firstNumberTextArea = new JLabel("First Number");
	private JLabel secondNumberTextArea = new JLabel("Second Number");
	private JLabel resultTextArea = new JLabel("Result");
	private JButton minusButton = new JButton("-");
	private JButton CLEARButton = new JButton("CLEAR");
	private JButton divButton = new JButton("/");
	private JButton addButton = new JButton("+");
	private JButton mulButton = new JButton("*");
	private JButton modButton = new JButton("%");

	CalculatorView() {
		JPanel calcPanel = new JPanel();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 600);
		calcPanel.setLayout(new GridLayout(6, 2, 10, 10));

		calcPanel.add(firstNumberTextArea);
		calcPanel.add(firstNumber);
		calcPanel.add(secondNumberTextArea);
		calcPanel.add(secondNumber);
		calcPanel.add(resultTextArea);
		calcPanel.add(calcSolution);
		calcPanel.add(addButton);
		calcPanel.add(minusButton);
		calcPanel.add(mulButton);
		calcPanel.add(divButton);
		calcPanel.add(modButton);
		calcPanel.add(CLEARButton);

		this.add(calcPanel);
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

	public void setFirstNumber(String a){
		firstNumber.setText(a);
	}

	public void setSecondNumber(String a){
		secondNumber.setText(a);
	}

	public void setCalcSolution(int solution){
		calcSolution.setText(Integer.toString(solution));
	}

	public void setCalcSolution(String x){calcSolution.setText(x);}

	// If the calculateButton is clicked execute a method
	// in the Controller named actionPerformed

	void addAddButtonListener(ActionListener listenForCalcButton){
		addButton.addActionListener(listenForCalcButton);
	}

	void addMinusButtonListener(ActionListener listenForCalcButton){
		minusButton.addActionListener(listenForCalcButton);
	}

	void addMulButtonListener(ActionListener listenForCalcButton){
		mulButton.addActionListener(listenForCalcButton);
	}

	void addDivButtonListener(ActionListener listenForCalcButton){
		divButton.addActionListener(listenForCalcButton);
	}

	void addModButtonListener(ActionListener listenForCalcButton){
		modButton.addActionListener(listenForCalcButton);
	}

	void addCLEARButtonListener(ActionListener listenForCalcButton){
		CLEARButton.addActionListener(listenForCalcButton);
	}

	// Open a popup that contains the error message passed
	void displayErrorMessage(String errorMessage){

		JOptionPane.showMessageDialog(this, errorMessage);

	}

}