package org.lanqiao.puzzle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;


public class puzzle extends JFrame{
	public JFrame ff = this;
	 public JPanel pane1 = new JPanel();
	    public JButton butStart = new JButton("游戏开始");
	    public JButton butEnd = new JButton("游戏结束");
	
	    public puzzle(int t,int ii)
	    {
	        super("彭梁的拼图游戏");


	        Container con = this.getContentPane();
	        con.add(pane1,BorderLayout.NORTH);
	        GamePanel gamepane = new GamePanel(t,ii);
	        con.add(gamepane,BorderLayout.CENTER);
	        butStart.setBounds(631, 410, 245, 76);
	        gamepane.add(butStart);
	        butEnd.setBounds(631, 534, 245, 69);
	        gamepane.add(butEnd);
	        
	        JButton btnx33 = new JButton("3x");
	        btnx33.setBounds(631, 320, 61, 43);
	        gamepane.add(btnx33);
	        btnx33.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(final ActionEvent e)
	            {	
	            	new puzzle(3,ii);
	            	ff.dispose();
	            }
	        });
	        
	        JButton btnx66 = new JButton("6x");
	        btnx66.setBounds(723, 320, 61, 43);
	        gamepane.add(btnx66);
	        btnx66.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(final ActionEvent e)
	            {	
	            	new puzzle(6,ii);
	            	ff.dispose();
	            }
	        });
	        
	        JButton btnx1010 = new JButton("10x");
	        btnx1010.setBounds(815, 320, 61, 43);
	        gamepane.add(btnx1010);
	        btnx1010.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(final ActionEvent e)
	            {	
	            	new puzzle(10,ii);
	            	ff.dispose();
	            	
	            }
	        });
	        
	        JButton ht = new JButton("蒙多");
	        ht.setBounds(631,245, 61, 43);
	        gamepane.add(ht);
	        ht.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(final ActionEvent e)
	            {	
	            	new puzzle(3,1);
	            	ff.dispose();
	            }
	        });
	        
	        JButton ht1 = new JButton("炸弹");
	        ht1.setBounds(723,245, 61, 43);
	        gamepane.add(ht1);
	        ht1.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(final ActionEvent e)
	            {	
	            	
	            	new puzzle(3,2);
	            	ff.dispose();
	            }
	        });
	        
	        JButton ht2 = new JButton("露露");
	        ht2.setBounds(815,245, 61, 43);
	        gamepane.add(ht2);
	        ht2.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(final ActionEvent e)
	            {	
	            	new puzzle(3,3);
	            	ff.dispose();
	            }
	        });
	        
	       
	        
	       
	        
	        butEnd.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(final ActionEvent e)
	            {
	                System.exit(1);
	            }
	        });
	        butStart.addActionListener(new ActionListener()
	        {
	            public void actionPerformed(final ActionEvent e)
	            {
	                gamepane.OutOfOrder();
	            }
	        });
	        this.setSize(900, 645);
			this.setLocationRelativeTo(null);//窗体居中显示 
			this.setResizable(false);
			//this.setAlwaysOnTop(true);
	        this.setVisible(true);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }      
	
	 
	public static void main(String[] args) {
		new puzzle(6,2);
		
	}
}
