/*
 * Created by: Phoebe Vermithrax
 * Created on: 07-Feb-2018
 * Created for: ICS4U
 * Daily Assignment – Day #4
 * This program calculates Einstein's equation using the speed of light and the user's input of the 
 * mass to get the amount of energy. Then, it outputs this back to the user.
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Equation {

	protected Shell shell;
	private Text txtUserMass;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Equation window = new Equation();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Einstein's Equation");
		
		txtUserMass = new Text(shell, SWT.BORDER);
		txtUserMass.setBounds(20, 110, 197, 21);
		
		Label lblEnterInA = new Label(shell, SWT.NONE);
		lblEnterInA.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblEnterInA.setBounds(20, 50, 404, 36);
		lblEnterInA.setText("Enter in a number for mass in order to calculate Energy, in Joules, \r\nusing Einstein's Equation: ");
		
		Label lblAnswer = new Label(shell, SWT.NONE);
		lblAnswer.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblAnswer.setBounds(210, 201, 181, 21);

		Button btnCalculate = new Button(shell, SWT.NONE);
		btnCalculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Create double variables to hold the mass of the object, the speed of light, and the 
				//amount of energy.
				double numberMass, energyAmount;
				double lightSpeed = 2.998 * Math.pow(10, 8);
				
				try {
					//Parse the number from the textbox inputed by the user.
					numberMass = Integer.parseInt(txtUserMass.getText());
				}
				//This is to catch any input that isn't a number.
				catch (Exception exc)
				{
					//This will tell the user that they inputed an invalid error.
					MessageDialog.openError(shell, "Error", "Invalid Mass");
					return;
				}
				
				//Calculate the amount of energy by multiplying the mass by the light speed squared.
				energyAmount = numberMass * Math.pow(lightSpeed, 2);
				
				//Output the amount of energy to the user by inserting it into a label.
				lblAnswer.setText(" " + energyAmount + " J");
			}
		});
		btnCalculate.setBounds(20, 157, 75, 25);
		btnCalculate.setText("Calculate");
		
		Label lblTheAmountOf = new Label(shell, SWT.NONE);
		lblTheAmountOf.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD));
		lblTheAmountOf.setBounds(20, 199, 197, 25);
		lblTheAmountOf.setText("The amount of Energy is: ");
		

	}
}
