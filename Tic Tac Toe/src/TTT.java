import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class TTT implements ActionListener  {
	private int flag;
    Random random= new Random();
    JFrame frame = new JFrame();
    JPanel title_panel=new JPanel();
    JPanel button_panel=new JPanel();
    JLabel l=new JLabel();
    JTextField t= new JTextField();
    JButton[] B =new JButton[9];
    boolean p1_turn;
	TTT()
	{   flag=0;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(350,70,600,600);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		t.setBackground(Color.DARK_GRAY);
		t.setForeground(Color.WHITE);
		t.setFont(new Font("Ink Free",Font.BOLD,75));
		t.setHorizontalAlignment(JLabel.CENTER);
		t.setText("Tic-Tac-Toe");
		t.setOpaque(true);

		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,600,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		
		for(int i=0;i<9;i++)
		{
			B[i]=new JButton();
			button_panel.add(B[i]);
			B[i].setFont(new Font("MV Boli",Font.BOLD,120));
			B[i].addActionListener(this);
		}
		
		title_panel.add(t);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
		
	}
	public void actionPerformed(ActionEvent ae)
	{   int i;
		for(i=0;i<9;i++)
		{
			if(ae.getSource()==B[i])
			{
				if(p1_turn)
				{
					if(B[i].getText()=="")
						{
						B[i].setForeground(Color.BLUE);
					    B[i].setText("X");
					    p1_turn=false;
					    t.setText("O turn");
					    check();
					    }
					else
				    	t.setText("Match Draw");
				}
				else
				{
					if(B[i].getText()=="")
					{
					B[i].setForeground(Color.RED);
				    B[i].setText("O");
				    p1_turn=true;
				    t.setText("X turn");
				    check();}
					else
				    	t.setText("Match Draw");
				     
				    	
				    
				}
			}
		 
		}
		
		
			
	} 
	 public void firstTurn()
	 {
	
	try {
		Thread.sleep(2000);
	}
	catch(InterruptedException e)
	{
		e.printStackTrace();
	}
	  if(random.nextInt(2)==0)
	  {
	  p1_turn=true;
	  t.setText("X turn");
	  }
	  else
	  {
		  p1_turn=false;
		  t.setText("O turn");
	  }
		 
	 }
	 public void check()
	 {
		 if(
				 (B[0].getText()=="X" && B[1].getText()=="X" && B[2].getText()=="X" )
				 
				 ) { xWins(0,1,2); }
		 if(
				 (B[3].getText()=="X" && B[4].getText()=="X" && B[5].getText()=="X" )
				 
				 ) { xWins(3,4,5); }
		 if(
				 (B[6].getText()=="X" && B[7].getText()=="X" && B[8].getText()=="X" )
				 
				 ) { xWins(0,1,2); }
		 if(
				 (B[0].getText()=="X" && B[4].getText()=="X" && B[8].getText()=="X" )
				 
				 ) { xWins(0,4,8); }
		 if(
				 (B[2].getText()=="X" && B[4].getText()=="X" && B[6].getText()=="X" )
				 
				 ) { xWins(2,4,6); }
		 if(
				 (B[0].getText()=="X" && B[3].getText()=="X" && B[6].getText()=="X" )
				 
				 ) { xWins(0,3,6); }
		 if(
				 (B[1].getText()=="X" && B[4].getText()=="X" && B[7].getText()=="X" )
				 
				 ) { xWins(1,4,7); }
		 if(
				 (B[2].getText()=="X" && B[5].getText()=="X" && B[8].getText()=="X" )
				 
				 ) { xWins(2,5,8);}
		 if(
				 (B[0].getText()=="O" && B[1].getText()=="O" && B[2].getText()=="O" )
				 
				 ) { oWins(0,1,2); }
		 if(
				 (B[3].getText()=="O" && B[4].getText()=="O" && B[5].getText()=="O" )
				 
				 ) { oWins(3,4,5); }
		 if(
				 (B[6].getText()=="O" && B[7].getText()=="O" && B[8].getText()=="O" )
				 
				 ) { oWins(0,1,2); }
		 if(
				 (B[0].getText()=="O" && B[4].getText()=="O" && B[8].getText()=="O" )
				 
				 ) { oWins(0,4,8); }
		 if(
				 (B[2].getText()=="O" && B[4].getText()=="O" && B[6].getText()=="O" )
				 
				 ) { oWins(2,4,6); }
		 if(
				 (B[0].getText()=="O" && B[3].getText()=="O" && B[6].getText()=="O" )
				 
				 ) { oWins(0,3,6); }
		 if(
				 (B[1].getText()=="O" && B[4].getText()=="O" && B[7].getText()=="O" )
				 
				 ) { oWins(1,4,7); }
		 if(
				 (B[2].getText()=="O" && B[5].getText()=="O" && B[8].getText()=="O" )
				 
				 ) { oWins(2,5,8);}

	 }
	 public void xWins(int a, int b, int c)
	 { flag++;
	  B[b].setBackground(Color.GREEN);
	  B[a].setBackground(Color.GREEN);
	  B[c].setBackground(Color.GREEN);
	  for(int i=0;i<9;i++)
	  {
		  B[i].setEnabled(false);
	  }
	  t.setText("X wins");
	
	 }
	 public void oWins(int a, int b, int c)
	 {     flag++;
		  B[a].setBackground(Color.GREEN);
		  B[b].setBackground(Color.GREEN);
		  B[c].setBackground(Color.GREEN);
		  for(int i=0;i<9;i++)
		  {
			  B[i].setEnabled(false);
		  }
		 t.setText("O wins");
	
	 }
	 
	 
	 	 
}
