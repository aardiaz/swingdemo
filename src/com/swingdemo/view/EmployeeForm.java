package com.swingdemo.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.swingdemo.model.Employee;
import com.swingdemo.service.EmployeeService;
import com.swingdemo.service.EmployeeServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblFirstname;
	private JTextField textField;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm frame = new EmployeeForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeForm() {
		setTitle("Employee Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblFirstname());
		contentPane.add(getTextField());
		contentPane.add(getBtnSave());
	}
	private JLabel getLblFirstname() {
		if (lblFirstname == null) {
			lblFirstname = new JLabel("FirstName");
			lblFirstname.setBounds(21, 30, 67, 21);
		}
		return lblFirstname;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(87, 30, 135, 30);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Save");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Employee  emp = new Employee();
					
					emp.setFname(fnameTxt.getText());
					
					if(maleRbt.isSelected()) {
						
						emp.setGender("male");
						
					}else {
						emp.setGender("female");
					}
					
					
					EmployeeService  es = new EmployeeServiceImpl();
					
					if(es.addEmp(emp)) {
						
						JOptionPane.showMessageDialog(null, "added success");
					}else {
						JOptionPane.showMessageDialog(null, "failed");
					}
					
					
					
					
					
				}
			});
			btnSave.setBounds(134, 338, 89, 23);
		}
		return btnSave;
	}
}
