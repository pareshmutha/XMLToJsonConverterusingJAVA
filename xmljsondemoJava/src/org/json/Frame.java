package org.json;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Frame extends JFrame implements ActionListener
{
	JLabel label1;
	JTextField text1;
	JButton btn1,btn2;
	JPanel jp,jp1;
	 JFileChooser chooser;
	   String choosertitle;
	   
	public Frame() throws HeadlessException 
	{
		this.setBounds(500, 250, 500, 250);
		
		label1 = new JLabel("Enter the Path:");
		text1 = new JTextField(10);
		btn1 = new JButton("file selector");
		btn2 = new JButton("Directory Selector");
		
		jp= new JPanel();
		
		jp.setLayout(null);
		
		jp.add(btn1);
		jp.add(btn2);
		
		add(jp);
		
		jp.setLocation(50,50);
		
		btn1.setLocation(70,75);
		btn2.setLocation(270,75);
		
		btn1.setSize(150, 30);
		btn2.setSize(150, 30);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		this.add(jp);
	//	this.add(jp1);
		
		//this.add(chooser);
		this.setVisible(true);
		 
	}

	@Override
	public void actionPerformed(ActionEvent btn) 
	{
		JButton b=(JButton)btn.getSource();
		Main m = new Main();
		if(b.getText()=="file selector")
		{
			
			 JFrame f = new JFrame("Demo");
	    	 JFileChooser chooser = new JFileChooser();
	        // chooser.showOpenDialog(f);
	        
	      
	         if(chooser.showOpenDialog(f) == JFileChooser.APPROVE_OPTION)
	         {
	        	 String path= chooser.getSelectedFile().getAbsolutePath();
		         int a= path.indexOf(".xml");
	        	 
	        	 if(a>0)
		         {
		      
				   		try {
							int i=m.getPath(path);
							if(i!=0)
							{
								JOptionPane.showMessageDialog(null,"Json Created Successfully","Done",JOptionPane.INFORMATION_MESSAGE);
							}
							else
							{
								JOptionPane.showMessageDialog(null,"File Not Found, Please Check the Path","Error!!",JOptionPane.INFORMATION_MESSAGE);
							}
				   			} 
				   			catch (Exception e) 
				   			{
							
				   					e.printStackTrace();
				   			}
				      }
						else{
							JOptionPane.showMessageDialog(null,"Please select only xml file","Error!!",JOptionPane.INFORMATION_MESSAGE);
							
							}
	        	 
	         }
	         else
	         {
	        	 System.out.println("No Selection");
	        	 
	         }
	        
		}
		
		
					else
					{
						try
						{
			
						chooser = new JFileChooser(); 
					    chooser.setCurrentDirectory(new java.io.File("."));
					    chooser.setDialogTitle(choosertitle);
					    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					    //
					    // disable the "All files" option.
					    //
					    chooser.setAcceptAllFileFilterUsed(false);
					    //    
					    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
					    	
					    	try {
								int i=m.getPath(chooser.getSelectedFile().getAbsolutePath());
								if(i!=0)
								{
									JOptionPane.showMessageDialog(null,"Json Created Successfully","Done",JOptionPane.INFORMATION_MESSAGE);
								}
								else
								{
									JOptionPane.showMessageDialog(null,"File Not Found, Please Check the Path","Error!!",JOptionPane.INFORMATION_MESSAGE);
								}
							} catch (Exception e1) {
								
								JOptionPane.showMessageDialog(null,"File Not Found, Please Check the Path","Error!!",JOptionPane.INFORMATION_MESSAGE);
							}
					     /* System.out.println("getCurrentDirectory(): " 
					        +  chooser.getCurrentDirectory());
					      System.out.println("getSelectedFile() : " 
					         +  chooser.getSelectedFile());*/
					      }
						  else
						  {
						      System.out.println("No Selection ");
						  }
			
			
			
		
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"File Not Found, Please Check the Path","Error!!",JOptionPane.INFORMATION_MESSAGE);
					}
				}//else closed
				
		
			
	
	}//fun closesed
	
	
}
