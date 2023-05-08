/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniproject;


import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;


import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class CheckOut extends JFrame{
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1;
        String deposit;
        Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public CheckOut() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 800, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/CHOut.png"));
                Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(300,0,500,225);
                add(l1);

		JLabel lblCheckOut = new JLabel("Check Out ");
		lblCheckOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCheckOut.setBounds(70, 11, 140, 35);
		contentPane.add(lblCheckOut);

		JLabel lblName = new JLabel(" Aadhar Number :");
		lblName.setBounds(20, 85, 100, 14);
		contentPane.add(lblName);

                c1 = new Choice();
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("Aadharnumber"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(130, 82, 150, 20);
		contentPane.add(c1);

                ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
                Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
                ImageIcon i6 = new ImageIcon(i5);
                JButton l2 = new JButton(i6);
                l2.setBounds(290,82,20,20);
                add(l2);

                l2.addActionListener(new ActionListener(){

                    public void actionPerformed(ActionEvent ae){
                        System.out.println("Hi");
                        try{

                            Conn c = new Conn();
                            String number = c1.getSelectedItem();
                            ResultSet rs = c.s.executeQuery("select * from Book where custAadhar = "+number);

                            if(rs.next()){
                                System.out.println("clicked");
                                //deposit=rs.getString("deposit");
                                t1.setText(rs.getString("room"));    
                            }
                        }catch(Exception e){ }
//                        try{
//                                String total = "";
//                                Conn c  = new Conn();
//                                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = "+t1.getText());
//                                while(rs2.next()){
//                                    total = rs2.getString("price"); 
//                                    
//                                }
//                                String paid = deposit;
//                                
//                                int pending = Integer.parseInt(total)- Integer.parseInt(paid);
//                                if(pending!=0){
//                                    JOptionPane.showMessageDialog(null, "Payment not cleared!!1");
//                               UpdateCheck update = new UpdateCheck();
//				update.setVisible(true);
//                                setVisible(false);
//                                }
//                                
//	    			
//                            }catch(Exception ee){}
                    }
                });


		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(20, 132, 86, 20);
		contentPane.add(lblRoomNumber);

		t1 = new JTextField();
                t1.setBounds(130, 132, 150, 20);
		contentPane.add(t1);

		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                                String id = c1.getSelectedItem();
                                String s1 = t1.getText();
				

	    		try{

                                Conn c = new Conn();
                                String deleteSQL = "Delete from customer where Aadharnumber = "+id;
                                String q2 = "update room set availability = 'Available' where roomnumber = "+s1;
				
	    			c.s.executeUpdate(deleteSQL);
	    			c.s.executeUpdate(q2);
	    			JOptionPane.showMessageDialog(null, "Check Out Successful");
	    			new Reception().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
			}
		});
		btnCheckOut.setBounds(50, 200, 100, 25);
                btnCheckOut.setBackground(Color.BLACK);
                btnCheckOut.setForeground(Color.WHITE);
		contentPane.add(btnCheckOut);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(160, 200, 100, 25);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);


                getContentPane().setBackground(Color.LIGHT_GRAY);
	}

}
