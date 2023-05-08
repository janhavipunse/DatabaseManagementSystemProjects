/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miniproject;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class DashBoard extends JFrame{

    public static void main(String[] args) {
        new DashBoard().setVisible(true);
    }

    public DashBoard() {
        super("HOTEL MANAGEMENT SYSTEM");

        setForeground(Color.CYAN);
        setLayout(null); 
       

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1600, 1200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
	JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(0, 0, 1600, 1200); 
        add(NewLabel);

        JLabel hName = new JLabel("Welcome to Hotel Management System");
	hName.setForeground(Color.WHITE);
        hName.setFont(new Font("Times New roman", Font.PLAIN, 54));
	hName.setBounds(250, 200, 1080, 85);
	NewLabel.add(hName);

        JButton btnReception = new JButton("RECEPTION");
        btnReception.setBounds(580, 350, 150, 60);
                btnReception.setBackground(Color.LIGHT_GRAY);
                btnReception.setForeground(Color.WHITE);
                btnReception.setFont(new Font("serif",Font.PLAIN,20));
		NewLabel.add(btnReception);
		btnReception.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Reception();
            }
	});
              
          
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);

//        JMenu HotelManagement = new JMenu("HOTEL MANAGEMENT");
//        HotelManagement.setForeground(Color.BLUE);
//	menuBar.add(HotelManagement);

//        JMenuItem Reception = new JMenuItem("RECEPTION");
//	HotelManagement.add(Reception);

	JMenu menuBarAdmin = new JMenu("ADMIN");
        menuBarAdmin.setForeground(Color.GRAY);
        menuBarAdmin.setFont(new Font("serif",Font.PLAIN,15));
	menuBar.add(menuBarAdmin);

        JMenuItem adminEmp = new JMenuItem("ADD EMPLOYEE");
          adminEmp.setForeground(Color.GRAY);
          adminEmp.setFont(new Font("serif",Font.PLAIN,15));
	
	menuBarAdmin.add(adminEmp);
        

        adminEmp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddEmployee().setVisible(true);
                }catch(Exception e ){}
            }
	});


        JMenuItem adminRoom = new JMenuItem("ADD ROOMS");
         adminRoom.setForeground(Color.GRAY);
         adminRoom.setFont(new Font("serif",Font.PLAIN,15));
	
	menuBarAdmin.add(adminRoom);

        adminRoom.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new AddRoom().setVisible(true);
                }catch(Exception e ){}
            }
	});

//
//	Reception.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent ae){
//                new Reception();
//            }
//	});


        //JMenuItem AdminDriver = new JMenuItem("ADD DRIVERS");
	//menuBarAdmin.add(AdminDriver);

//	AdminDriver.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent ae){
//                try{
//                    new AddDrivers().setVisible(true);
//                }catch(Exception e ){}
//            }
//	});


        setSize(1600,1090);
	setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}
