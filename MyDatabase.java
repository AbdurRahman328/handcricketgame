import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import javax.swing.border.*;

class MyFrame extends JFrame{
	Connection con;
	Statement st;
	ResultSet rs;
	JLabel l,l1,l2;
	JTextField t1;
	JPanel p ;
	JButton b1,b2;
	JPasswordField t2;
	
	MyFrame(){
		setTitle("My Game");
		setSize(830,600);
		setVisible(true);
		setLocationRelativeTo(null);
		constructUI();
		designUI();
		makeConnection();
		handleEvent();
	}
	public void constructUI()
	{
		l1 = new JLabel("User Name : ");
		l2 = new JLabel("Password  :  ");
		t1 = new JTextField(20);
		t2 = new JPasswordField(20);
		p  =  new JPanel();
		b1 = new JButton("Sign Up");
		l1.setForeground(Color.WHITE);
		b2 = new JButton("Register");
		l2.setForeground(Color.WHITE);
		l1.setFont(new Font("Serif",Font.BOLD,20));
		l2.setFont(new Font("Serif",Font.BOLD,20));
	}
	
	
	public void designUI(){
	
		//p.add(l);
		ImageIcon img = new ImageIcon("ball.jpg");
		Image newimag = img.getImage().getScaledInstance(830,600,Image.SCALE_DEFAULT);
		l= new JLabel(new ImageIcon(newimag));
		p.add(l);
		l.setLayout(new FlowLayout());
	
		p.add(l1);
		getContentPane().add(l1,BorderLayout.CENTER);
		l1.setBounds(480,200,200,30);
		
		p.add(t1);
		getContentPane().add(t1,BorderLayout.CENTER);
		t1.setBounds(650,200,150,30);
		
		p.add(l2);
		getContentPane().add(l2,BorderLayout.CENTER);
		l2.setBounds(480,250,200,30);
		
		p.add(t2);
		getContentPane().add(t2,BorderLayout.CENTER);
		t2.setBounds(650,250,150,30);
		
		p.add(b1);
		getContentPane().add(b1,BorderLayout.CENTER);
		b1.setBounds(650,300,90,30);
		
		p.add(b2);
		getContentPane().add(b2,BorderLayout.CENTER);
		b2.setBounds(650,350,100,30);
		
		add(p);
	}
	
	public void handleEvent()
	{
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
					
    
        try
        {
       //   Connection c1=new Connection();
            String u=t1.getText();
            String v=t2.getText();
            
            String q="select * from playerdetails where PlayerName='"+u+"' and Password='"+v+"'";
            
            rs=st.executeQuery(q); 
            if(rs.next())
            {
                new MyFrame1().setVisible(true);
                setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid login");
                //setVisible(false);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    
			}
		});
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
					MyFrame3 f3 = new MyFrame3();
					f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
			
	}
	public void makeConnection()
	{
		//Connection con;
		//Statement st;
		//ResultSet rs;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hand","root","root");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


}
class MyFrame1 extends JFrame{
	
	JLabel l1,l2,l;
	JPanel p1,p11,p12,p13,p2,p3,p31,p32;
	JRadioButton r1,r2,r3,r4;
	JButton b1,b2;
	JTextField t1;
	public static int t,choice;
	
	public MyFrame1(){
		setTitle("Mini Number Cricket Game");
		setSize(830,600);
		setVisible(true);
		setResizable(false);
		Image icon = Toolkit.getDefaultToolkit().getImage("cricket.png");
		setIconImage(icon);
		setLocationRelativeTo(null);
		//setResizable(false);
		constructUI();
		setColoring();
		setFonting();
		setBordering();
		designUI();
		handleEvent();
	}
	
	public void constructUI(){
		l1 = new JLabel("CHOOSE");
		l1.setFont(new Font("Serif",Font.BOLD,25));
		r1 = new JRadioButton("Head");
		r2 = new JRadioButton("Tail");
		r3 = new JRadioButton("Bat");
		r3.setEnabled(false);
		r4 = new JRadioButton("Bowl");
		r4.setEnabled(false);
		p1 = new JPanel();
		p2 = new JPanel();
		p11 = new JPanel();
		p12 = new JPanel();
		p31 = new JPanel();
		p13 = new JPanel();
		p3 = new JPanel();
		b1 = new JButton("TOSS");
		b2 = new JButton("START");
		t1 = new JTextField(20);
		t1.setVisible(false);
		l = new JLabel();
		ImageIcon img = new ImageIcon("cricket.png");
		Image newimg = img.getImage().getScaledInstance(800,400,Image.SCALE_DEFAULT);
		l= new JLabel(new ImageIcon(newimg));
	}
	
	public void setColoring(){
		Color c1 = new Color(100,100,204);
		Color c2 = new Color(51,204,255);
		l1.setForeground(Color.WHITE);
		r1.setBackground(Color.WHITE);
		r2.setBackground(Color.WHITE);
		p1.setBackground(c2);
		p11.setBackground(Color.GRAY);
		p12.setBackground(c2);
		p13.setBackground(Color.GRAY);
		p2.setBackground(c2);
		b1.setBackground(c2);
		b1.setForeground(Color.RED);
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.RED);
	}

	public void setBordering(){
		Border border = new LineBorder(Color.BLACK,2,true);
		p1.setBorder(border);
		p11.setBorder(border);
		p13.setBorder(border);
		p2.setBorder(border);
	}	
	public  void setFonting(){
		Font font = new Font("Serif",Font.BOLD,20);
		r1.setFont(font);
		r2.setFont(font);
		r3.setFont(font);
		r4.setFont(font);
		b1.setFont(font);
		b2.setFont(new Font("Serif",Font.BOLD,20));	
	}
	
	public void designUI(){
		p1.setLayout(new BorderLayout(10,10));
		p11.add(l1);
		p12.add(r1);		
		p12.add(r2);
		p13.add(b1);
		p1.add(p11,BorderLayout.NORTH);
		p1.add(p12,BorderLayout.CENTER);
		p1.add(p13,BorderLayout.SOUTH);
		p2.add(b2);
		p3.setLayout(new BorderLayout());
		p31.add(r3);
		p31.add(r4);
		p31.setBackground(new Color(51,153,255));
	
		
		p3.add(t1);
		
		p3.add(p31,BorderLayout.NORTH);
		p3.add(l);
		
		//setLayout(new BorderLayout(5,5));
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.SOUTH);
		add(p3,BorderLayout.CENTER);	
		
	}
	
	public void handleEvent(){
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
					MyFrame2 f2 = new MyFrame2();
					f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					dispose();
			}
		});
		
		r1.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(r1.isSelected()){
					r2.setEnabled(false);
					t=0;
					
				}
				else{
					r2.setEnabled(true);
					t=1;
				}
			}
		});
		r2.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(r2.isSelected()){
					r1.setEnabled(false);
					t=1;
					
				}
				else{
					r1.setEnabled(true);
					t=0;
				}
				
			}
		});
		
		r3.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(r3.isSelected()){
					r4.setEnabled(false);
					choice  = 1;
				}
				else{
					r4.setEnabled(true);
					
				}
				
			}
		});
		r4.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(r4.isSelected()){
					r3.setEnabled(false);
					choice  = 2;
				}
				else{
					r3.setEnabled(true);
				}
				
			}
			});
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String[] toss = new String[2];
				toss[0]="head";
				toss[1]="tail";
				Random random = new Random();
				int a = random.nextInt(2);
				int b;
				if(r1.isSelected()){
				       b=0;
				}
				else{
					b=1;
				}
				if(a==b){
					
					
					r3.setEnabled(true);
					r4.setEnabled(true);
					Color c = new Color(255,255,100);
					t1.setForeground(Color.RED);
					p31.setBackground(c);
					t1.setHorizontalAlignment(JTextField.CENTER);
					
					JOptionPane d = new JOptionPane(null,JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,new ImageIcon("cricket.png"));
					d.createDialog("Toss");
					//d.setIcon(new ImageIcon("/home/linux/Downloads/cricket.png"));
				        d.showMessageDialog(null,"You Win and Now You can select Bat or Bowl");
				}
				else{
						
					Color c = new Color(255,102,102);
					t1.setForeground(Color.WHITE);
					p31.setBackground(c);
					t1.setFont(new Font("SansSerif",Font.BOLD,30));
					t1.setHorizontalAlignment(JTextField.CENTER);
					
					JOptionPane d = new JOptionPane();
					d.createDialog(null,"Toss");
					//d.setIcon(new ImageIcon("/home/linux/Downloads/cricket.png"));
					d.showMessageDialog(null,"You Lose and Now You can't select Bat or Bowl");
				}
				b1.setEnabled(false);
				t1.setEditable(false);
						
			}
		});	
	}
}
class MyFrame2 extends JFrame{
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	JPanel p1,p2,p3,p21,p211,p212,p22,p221,p4,p;
	JLabel l1,l2,l3,l4,l5,l;
	JTextField t1,t2,t3,t4,t5,t6;
	int a;
	int playerscore = 0;
	int count1 =0 , count2 =0;
	static int score1 = 0;
	static int score2 = 0;
	public MyFrame2(){
			setTitle("Mini Number Cricket Game");		
			setSize(800,600);
			setLocationRelativeTo(null);
			setVisible(true);
			setResizable(false);
			constructUI();
			bordering();
			designUI();
			coloring();
			buttonfixing();
			handleEvent();
			}
	
	public void constructUI(){
		b1 = new JButton("Previous");
		b2 = new JButton("Exit");
		p  = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p21 = new JPanel();
		p211 = new JPanel();
		p212 = new JPanel();
		l1 = new JLabel("                     All The Best                           ");
		l1.setFont(new Font("Serif",Font.BOLD,30));
		t1  = new JTextField(10);
		t1.setText(0+"");
		t2  = new JTextField(10);
		getContentPane().add(t2,BorderLayout.CENTER);
		t2.setBounds(650,250,150,30);
		t3  = new JTextField(10);
		t4  = new JTextField(10);
		t5 = new JTextField(70);
		t5.setVisible(false);
		t6 = new JTextField(150);
		t6.setVisible(false);
		l2  = new JLabel("Player");
		l2.setFont(new Font("Serif",Font.BOLD,15));
		l3  = new JLabel("    Computer");
		l3.setFont(new Font("Serif",Font.BOLD,15));
		l4 = new JLabel("Score : ");
		l5 = new JLabel("Score : ");
		p22 = new JPanel();
		p221 = new JPanel();
		ImageIcon img = new ImageIcon("stadium3.jpg");
		Image newimg = img.getImage().getScaledInstance(800,400,Image.SCALE_DEFAULT);
		l= new JLabel(new ImageIcon(newimg));
		
	}
		
		public void designUI(){
	
	
		p3.add(b1);
		p3.add(b2);
		add(p3,BorderLayout.SOUTH);
		
		p1.add(l1);
		add(p1,BorderLayout.NORTH);
		p1.setBackground(new Color(51,204,255));
		
		p2.setLayout(new BorderLayout());
		p21.setLayout(new BorderLayout());
		p211.add(l2);
		p211.add(t1);
		p211.add(l3);
		p211.add(t2);
		p212.add(l4);
		p212.add(t3);
		p212.add(l5);
		p212.add(t4);
		
		
		p4.add(t5);
		getContentPane().add(t5,BorderLayout.CENTER);
		p4.add(t6);
		getContentPane().add(t6,BorderLayout.CENTER);
		t5.setBounds(300,200,200,30);
		t6.setBounds(250,350,380,40);
		p2.add(p4,BorderLayout.SOUTH);
		t5.setEditable(false);
		t6.setEditable(false);
		
		
		p21.add(p211,BorderLayout.NORTH);
		p21.add(p212,BorderLayout.SOUTH);
		p2.add(p21,BorderLayout.NORTH);
		
		
		
		p2.add(p22);
		getContentPane().add(p22,BorderLayout.CENTER);
		p22.setBounds(340,120,130,60);
		
		p2.add(l);
		
		add(p2,BorderLayout.CENTER);
	}
	
	public void coloring(){
		b1.setForeground(Color.WHITE);
		b1.setBackground(new Color(100,100,204));
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.RED);
		p211.setBackground(new Color(51,204,255));
		p212.setBackground(new Color(51,204,255));
		p2.setBackground(Color.GRAY);
		p3.setBackground(Color.GRAY);
		t5.setBackground(new Color(0,153,0));
		t6.setBackground(Color.WHITE);
		t5.setForeground(Color.WHITE);
		t6.setForeground(Color.RED);
	}
	
	public void bordering(){
		Border border = new LineBorder(Color.BLACK,2,true);
		p1.setBorder(border);
		p2.setBorder(border);
		p3.setBorder(border);
		p221.setBorder(border);
		
	
	}
	
	public void buttonfixing(){
			b3 = new JButton("1");
			b4 = new JButton("2");
			b5 = new JButton("3");
			b6 = new JButton("4");
			b7 = new JButton("5");
			b8 = new JButton("6");
			p221.add(b3);
			p221.add(b4);
			p221.add(b5);
			p221.add(b6);
			p221.add(b7);
			p221.add(b8);
			p221.setLayout(new GridLayout(2,3));
			p22.add(p221);
			p22.setBackground(Color.GRAY);
			
			
			
	
	}
	
	public void handleEvent(){
		b1.addActionListener(new ActionListener(){
			 		public void actionPerformed(ActionEvent ae){
						MyFrame1 f12 = new MyFrame1();
						score1 = 0;
						score2 = 0;
						f12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						dispose();	 			
			 		}
			 });
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				dispose();
			}
		
		});
		
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Random r= new Random();
				 a =r.nextInt(7)+1;
				t2.setText(a+"");
				t1.setText(1+"");
				playerscore=1;
				addScoring();
			}
		});
		b4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Random r= new Random();
				 a =r.nextInt(7)+1;
				t2.setText(a+"");
				t1.setText(2+"");
				playerscore=2;
				addScoring();
				}
				});
		b5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Random r= new Random();
				 a =r.nextInt(7)+1;
				t2.setText(a+"");
				t1.setText(3+"");
				playerscore=3;
				addScoring();
			}
		});
		b6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Random r= new Random();
				 a =r.nextInt(7)+1;
				t2.setText(a+"");
				t1.setText(4+"");
				playerscore=4;
				addScoring();
				}
				});
		
		b7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Random r= new Random();
				 a =r.nextInt(7)+1;
				t2.setText(a+"");
				t1.setText(5+"");
				playerscore=5;
				addScoring();
			}
		});
		b8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				Random r= new Random();
				 a =r.nextInt(7)+1;
				t2.setText(a+"");
				t1.setText(6+"");
				playerscore=6;
				addScoring();
				}
				});
		

	}
	
	public void addScoring(){
	
	if(count1==0 || count2==0){
			if(MyFrame1.choice == 1){
				// score = Integer.parseInt(t1.getText());
				 int c = checkscore();
				 
				 if(c!=1){
				 	score1 += playerscore;
				 	t3.setText(score1+"");
				 	}
				else{
					t5.setVisible(true);
					t5.setText("You Out");
					t5.setHorizontalAlignment(JTextField.CENTER);
					t5.setFont(new Font("Serif",Font.BOLD,20));
					MyFrame1.choice = 0;
					count1=1;
					} 			
			}
			else{  
				
				int c = checkscore();
				
				if(c!=1){
				 score2 += a;
				 t4.setText(score2+""); 
				}
				else{
					t5.setVisible(true);
					t5.setText("Computer Out");
					t5.setHorizontalAlignment(JTextField.CENTER);
					t5.setFont(new Font("Serif",Font.BOLD,20));
					MyFrame1.choice = 1;
					count2=1;
				}
				
				
			}
	}
	else{
		if(score1>score2){
			t6.setVisible(true);
			t6.setText("Congrats , You Win");
			t6.setFont(new Font("Serif",Font.BOLD,30));	
		}
		else{
			t6.setVisible(true);
			t6.setText("Sorry ! You Lost ");
			t6.setFont(new Font("Serif",Font.BOLD,30));	
		}
	
	}
	}
	
	public int checkscore(){
		if(a==playerscore){
			return 1;
		}
		return 0;
	}
	
}







class MyFrame3 extends JFrame
{
	Connection con;
	Statement st;
	ResultSet rs;
	JPanel p11,p12,p13,p1,p2,p14;
	JTextField t1,t2,t3;
	JPasswordField p3;
	
	JLabel l1,l2,l3;
	//JRadioButton b1,b2;
	JButton b3,b2;
	
	MyFrame3()
	{
		try{
		setVisible(true);
		setSize(830,600);
		setLocationRelativeTo(null);
		setTitle("LET'S PLAY");
		makeConnection();
		
		//constructUI();
		//designUI();
		//handleevent();
	//}
	//public void constructUI()
	//{
		t1=new JTextField(10);
		t2=new JTextField(10);
		l1=new JLabel("Player Name");
		l2=new JLabel("Age");
		l3=new JLabel("Password");
		//b1=new JRadioButton("Male");
		b2=new JButton("Sign-in");
		b3=new JButton("Addaccount");
		p3=new JPasswordField(10);
		p1=new JPanel();
		p2=new JPanel();
		p11=new JPanel();
		p12=new JPanel();
		p13=new JPanel();
		p14=new JPanel();
		
//	public void designUI()
//	{
		p1.setLayout(new BorderLayout());
		p11.add(l1);
		p11.add(t1);
		p12.add(l2);
		p12.add(t2);
		p13.add(l3);
		p13.add(p3);
		p1.add(p11,BorderLayout.NORTH);
		p1.add(p12,BorderLayout.CENTER);
		p1.add(p13,BorderLayout.SOUTH);
		p2.add(p1);
		add(p2);
		p14.add(b3);
		p14.add(b2,BorderLayout.SOUTH);
		add(p14,BorderLayout.SOUTH);
		p1.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//rs=st.executeQuery("select * from playerdetails");
	//	rs.first();
	//	t1.setText(rs.getString(1));
	//	t2.setText(rs.getString(2));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		b2.addActionListener(new ActionListener(){
			 		public void actionPerformed(ActionEvent ae){
						new MyFrame().setVisible(true);
						setVisible(false);	 			
			 		}
				 });
		
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				try
				{	
					String a = t1.getText();
					String b = t2.getText();
					String c = p3.getText();
					st.executeUpdate("insert into playerdetails values('"+a+"','"+b+"','"+c+"')");
					rs=st.executeQuery("select * from playerdetails");
					JOptionPane.showMessageDialog(null,"Inserted");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
	}
	public void makeConnection()
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hand","root","root");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
	

		

public class MyDatabase
{
	public static void main(String[] arg)
	{
	SwingUtilities.invokeLater(new Runnable() {

            public void run() {
			MyFrame f = new MyFrame();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
	}
	public void makeConnection()
	{
		Connection con;
		Statement st;
		ResultSet rs;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hand","root","root");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
