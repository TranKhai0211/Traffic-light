import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.Timer;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class traffic_light extends JFrame {
	draw_light dlpn = new draw_light();
	JRadioButton rbtnSetYellow = new JRadioButton();
	JRadioButton rbtnSetRed = new JRadioButton();
	JRadioButton rbtnSetGreen = new JRadioButton();
	JRadioButton rbtnNormal = new JRadioButton();
	JLabel lblCountDown = new JLabel();
	drawCountDown cdpn = new drawCountDown();
	ButtonGroup group = new ButtonGroup();
	int countDown = 30;
	Timer count;
	 
	public traffic_light() {
		setTitle("Traffic light");
		setSize(275, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		//count down 
		Font fontLabel = new Font(lblCountDown.getFont().getName(), Font.PLAIN, 90);
		add(lblCountDown);
		lblCountDown.setBounds(80, 25, 110, 110);
		lblCountDown.setFont(fontLabel);
		lblCountDown.setText(""+countDown);
		lblCountDown.setForeground(Color.GREEN);
		
		//panel
		add(cdpn);
		cdpn.setBackground(Color.BLACK);
		cdpn.setBounds(10, 10, 240, 140);
		
		add(dlpn);
		dlpn.setBackground(Color.BLACK);
		dlpn.setBounds(10, 150, 240, 450);
		 
	/*BUTTONS*/
		group.add(rbtnNormal);
		group.add(rbtnSetGreen);
		group.add(rbtnSetRed);
		group.add(rbtnSetYellow);
		
		//default green
		add(rbtnSetGreen);
		rbtnSetGreen.setBounds(80, 620, 20, 20);
		rbtnSetGreen.setBackground(Color.GREEN);
		rbtnSetGreen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dlpn.redLight = Color.GRAY;
				dlpn.yellowLight = Color.GRAY;
				dlpn.greenLight = Color.GREEN;
				lblCountDown.setText("");
				count.stop();
				dlpn.repaint();
			}
		});
		//default red
		add(rbtnSetRed);
		rbtnSetRed.setBounds(110, 620, 20, 20);
		rbtnSetRed.setBackground(Color.RED);
		rbtnSetRed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dlpn.redLight = Color.RED;
				dlpn.yellowLight = Color.GRAY;
				dlpn.greenLight = Color.GRAY;
				lblCountDown.setText("");
				count.stop();
				dlpn.repaint();
			}
		});
		
		//default yellow
		add(rbtnSetYellow);
		rbtnSetYellow.setBounds(140, 620, 20, 20);
		rbtnSetYellow.setBackground(Color.YELLOW);
		rbtnSetYellow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dlpn.redLight = Color.GRAY;
				dlpn.greenLight = Color.GRAY;
				dlpn.yellowLight = Color.YELLOW;
				lblCountDown.setText("");
				count.stop();
				dlpn.repaint();
			}
		});
		
		//Normal button
		add(rbtnNormal);
		rbtnNormal.setBounds(170, 620, 20, 20);
		rbtnNormal.setBackground(Color.gray);
		rbtnNormal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				countDown = 30;
				dlpn.redLight = Color.GRAY;
				dlpn.yellowLight = Color.GRAY;
				dlpn.greenLight = Color.GREEN;
				dlpn.repaint();
				lblCountDown.setText(""+countDown);
				count = new Timer(1000, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						countDown --;
						
						//change color
						if(countDown == 0 && dlpn.trangthai.equals("green")) {
							dlpn.changeColor();
							countDown = 4;
							//lblCountDown.setForeground(Color.YELLOW);
						}
						else if(countDown == 0 && dlpn.trangthai.equals("yellow")) {
							dlpn.changeColor();
							countDown = 20;
							//lblCountDown.setForeground(Color.RED);
						}
						else if(countDown == 0 && dlpn.trangthai.equals("red")) {
							dlpn.changeColor();
							countDown = 30;
							//lblCountDown.setForeground(Color.GREEN);
						}
						

						String sCountDown = ""+countDown;
						if(sCountDown.length() == 1) {
							lblCountDown.setText("0"+sCountDown);
						}
						else {
							lblCountDown.setText(""+sCountDown);
						}
						
						if(dlpn.trangthai.equals("green")) {
							lblCountDown.setForeground(Color.GREEN);
						}
						else if(dlpn.trangthai.equals("yellow")) {
							lblCountDown.setForeground(Color.YELLOW);
						}
						else if(dlpn.trangthai.equals("red")) {
							lblCountDown.setForeground(Color.RED);
						}
					}
				});
				count.start();
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new traffic_light().setVisible(true);
	}


}
