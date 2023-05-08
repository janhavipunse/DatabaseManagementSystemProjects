/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miniproject;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniProject extends JFrame implements ActionListener{

        JLabel l1;
        JButton b1;
        
        public MiniProject() {
		
                setSize(1390,796);          // setContentPane(300,300,1366,390);   frame size
                setLayout(null);
                setLocation(0,0);

		l1 = new JLabel("");
                b1 = new JButton("Next");
                
                b1.setBackground(Color.WHITE);
                b1.setForeground(Color.BLUE);
				
                b1.setFont(new Font("serif",Font.PLAIN,25));
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/hotel1.jpg"));
                Image i3 = i1.getImage().getScaledInstance(1390, 796,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
                
                JLabel lid=new JLabel("HOTEL MANAGEMENT SYSTEM");
                lid.setBounds(30,100,1500,100);
                lid.setFont(new Font("serif",Font.PLAIN,70));
                lid.setForeground(Color.WHITE);
                l1.add(lid);
                
                b1.setBounds(1100,600,150,50);
		l1.setBounds(0, 0, 1390, 796);
                
                l1.add(b1);
		add(l1);
 
                b1.addActionListener(this);
                setVisible(true);
                
                while(true){
                        lid.setVisible(false); // lid =  j label
                    try{
                        Thread.sleep(500); //1000 = 1 second
                    }catch(Exception e){} 
                        lid.setVisible(true);
                    try{
                        Thread.sleep(500);
                    }catch(Exception e){}
                }
	}
        
        public void actionPerformed(ActionEvent ae){
                new Login().setVisible(true);
                //this.setVisible(false);
                
        }
        
        public static void main(String[] args) {
                MiniProject window = new MiniProject();
                window.setVisible(true);			
	}
}

