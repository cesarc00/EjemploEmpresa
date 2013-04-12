package com.curso.clases;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

	public class MainFrame extends JFrame implements ActionListener {
		
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 4495442002145635310L;
		public MainFrame() {
			
			
			super("Hola. mundo");
			setLookAndFeel();
			setSize(400, 200);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			ClockPanel time = new ClockPanel();
			
			FlowLayout flo = new FlowLayout();
			setLayout(flo);
				
			JLabel empresaLabel = new JLabel("Buscar Empresa", JLabel.LEFT);
			add(empresaLabel);

			JTextField empresaField = new JTextField(20);
			add(empresaField);
			String empresaNueva = empresaField.getText();
			empresaField.setText("Escribe el nif a buscar");
			
			JLabel empresaAnade = new JLabel(empresaNueva, JLabel.LEFT);
			add(empresaAnade);
	
		//	JPanel topRow = new ClockPanel();;//new JPanel();
		//	FlowLayout flo2 = new FlowLayout();
		//	setLayout(flo2);
		//	add(topRow);
			add(time);
			
			
			JButton okButton = new JButton("Aceptar");
			JButton cancelButton = new JButton("Cancelar");
			add(okButton);
			add(cancelButton);
			okButton.addActionListener(this);
			cancelButton.addActionListener(this);
		//	ClockFrame clock = new ClockFrame();
			
			setVisible(true);
			

			}
			
		private void setLookAndFeel() {
			try {
				UIManager.setLookAndFeel(
						"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (Exception exc) {
			// ignore error
			}
		}
		public static void main(String[] arguments) {
			MainFrame sal = new MainFrame();
			}

		@Override
		public void actionPerformed(ActionEvent event) {
			String command = event.getActionCommand();
			if (command.equals("Aceptar")) {

				Empresa company = new Empresa("G-58963523", "Coca-Cola","Coca-Cola Company", 100000);
				Empleado e = new Empleado(501, "Luís", "Programador", 1500, 4, 5);
				Departamento d = new Departamento("Financiero");
				company.nuevoEmpleado(e, d);
				company.imprimirEmpleados(d);
			}
			if (command.equals("Cancelar")) {
				System.out.println("Cancelado");
			}
		}
	}