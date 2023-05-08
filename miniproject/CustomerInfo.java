/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniproject;


import java.awt.BorderLayout;
import java.awt.*;
import static java.awt.Color.LIGHT_GRAY;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.sql.*;	
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerInfo extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JLabel lblId;
	private JLabel lblNewLabel;
	private JLabel lblGender;
	private JTable table;
	private JLabel lblCountry;
	private JLabel lblRoom;
	private JLabel lblStatus;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerInfo frame = new CustomerInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CustomerInfo() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(450, 510, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
                                    Conn c  = new Conn();

				String displayCustomersql = "select * from Customer";
                                //String displayBooksql = "select room,checkintime,deposit from Book";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
                               // ResultSet rs1 = c.s.executeQuery(displayBooksql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
                                //table1.setModel(DbUtils.resultSetToTableModel(rs1));
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}


		});
		btnLoadData.setBounds(300, 510, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);

//		lblId = new JLabel("ID");
//		lblId.setBounds(31, 11, 46, 14);
//		contentPane.add(lblId);

                JLabel l1 = new JLabel(" Aadhar Number");
		l1.setBounds(31, 11, 100, 14);
		contentPane.add(l1);

		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(270, 11, 65, 14);
		contentPane.add(lblNewLabel);

		lblGender = new JLabel("Gender");
		lblGender.setBounds(520, 11, 46, 14);
		contentPane.add(lblGender);

		table = new JTable();
		table.setBounds(0, 40, 900, 450);
                table.setBackground(LIGHT_GRAY);
		contentPane.add(table);
//                
//                table1 = new JTable();
//		table1.setBounds(600, 40, 900, 450);
//		contentPane.add(table1);

		lblCountry = new JLabel("City");
		lblCountry.setBounds(700, 11, 46, 14);
		contentPane.add(lblCountry);

//		lblRoom = new JLabel("Room");
//		lblRoom.setBounds(600, 11, 46, 14);
//		contentPane.add(lblRoom);
//
//		lblStatus = new JLabel("Check-in Status");
//		lblStatus.setBounds(680, 11, 100, 14);
//		contentPane.add(lblStatus);
//
//		lblNewLabel_1 = new JLabel("Deposit");
//		lblNewLabel_1.setBounds(800, 11, 100, 14);
//		contentPane.add(lblNewLabel_1);

                getContentPane().setBackground(Color.LIGHT_GRAY);
               
	}
}
