/*
 * Arshiya Sen
 * 5/21/2022
 * Week Code Submission #5
 * FINAL SUBMISSION
 * GameProj.java
*/
//FOR THE FONT: DOWNLOAD "RETRO GAMING" FROM THIS WEBSITE: https://www.dafont.com/bitmap.php
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*; 
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.*; 
import javax.swing.event.*; 
import java.util.ArrayList;

public class GameProj 
{
	//contains all the panels, the entire game itself
	//all the classess are withing this large public class
	JPanel panel1;
	JPanel all;
	CardLayout cardLayout;
	JLabel label1;
	JPanel first;
	JButton play, back, back1, back2, back3;
	JButton bkgInfo, next1, next2, next3;
	Font font1, font2, font3, retro;
	Image[] bkgRandom;
	Image finalBkg;
	int deathCount, kill, sedateTime, finalSedate, timeVirus;
	double lives;
	boolean firstMiniEnter, p1Trans, secondEnter, hoardWon, heartWon, shooterWon;
	
	public GameProj()
	{
		//setting the frame
		//declaring field buttons and fonts
		cardLayout = new CardLayout();
		all = new JPanel();
		secondEnter = false;
		hoardWon = false;
		all.setLayout(cardLayout);
		all.setPreferredSize(new Dimension(600,600));
		all.setLayout(cardLayout);
		sedateTime = 100;
		finalSedate = 100;
		timeVirus = 0;
		lives = 3.0;
		kill = 0;
		firstMiniEnter = false;
		heartWon = false;
		shooterWon = false;
		deathCount = 0;
		JFrame frame = new JFrame("Arshiya Sen Game Project");
		play = new JButton("Play");
		back = new JButton("X");
		
		bkgInfo = new JButton("How to Play");
		next1 = new JButton("☞");
		next2 = new JButton("☞");
		next3 = new JButton("☞");
		
		font1 = new Font("Dialog", Font.BOLD, 36);
		font2 = new Font("Dialog", Font.BOLD, 20);
		font3 = new Font("Dialog", Font.BOLD, 18);
		retro = new Font("Retro Gaming", Font.BOLD, 18);
		//play.setPreferredSize(new Dimension(10,100));
		label1 = new JLabel("Content of Card 1 is visible now!");
		panel1 = new JPanel();
		first = new JPanel();
		
		frame.setSize(600, 600);
		mainRunner pc = new mainRunner(); 
		frame.setContentPane(pc);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		bkgRandom = new Image[4];
		bkgRandom[0] = new ImageIcon("background1.jpg").getImage();
		bkgRandom[1] = new ImageIcon("bkg2.jpg").getImage();
		bkgRandom[2] = new ImageIcon("bkg3.jpg").getImage();
		bkgRandom[3] = new ImageIcon("bkg4.jpg").getImage();
		finalBkg = bkgRandom[(int)(Math.random()*4)];
		
	}
	
	public static void main(String[] args)
	{
		//calling the constructor
		GameProj msp = new GameProj();
	}

	class mainRunner extends JPanel
	{
		//puts together the differnt panels using cardLayout
		public mainRunner()
		{
			//running method that adds to the panel
			runIt();
			
		}
		
		public void paintComponent(Graphics g)
		{
			//calling paintComponent so drawing on panels is possible
			super.paintComponent(g);
		}
		
		public void runIt()
		{
			//main area where the card layout is handle
			//calling other classess to switch through with card layout

			TransP1 t1 = new TransP1();
			TransP2 t2 = new TransP2();
			TransP3 t3 = new TransP3();
			//Transition1 p1 = new Transition1();
			
			
			all.add(new firstPage(), "link1");
			//all.add(new GameOver(), "link1");
			//all.add(new ZombieH(), "link2");
			all.add(new MinigameHub(), "link2");
			all.add(new infoPage(), "link3");
			all.add(new TransP1(), "link4");
			all.add(new TransP2(), "link5");
			all.add(new TransP3(), "link6");

			play.addActionListener(e -> cardLayout.show(all, "link4"));
			play.addActionListener(e -> p1Trans = true);
			
			next1.addActionListener(e -> cardLayout.show(all, "link5"));
			next2.addActionListener(e -> cardLayout.show(all, "link6"));
			
			next3.addActionListener(e -> cardLayout.show(all, "link2"));
			
			back.addActionListener(e -> cardLayout.show(all, "link1"));
			bkgInfo.addActionListener(e -> cardLayout.show(all, "link3"));
			//next1.addActionListener(e -> cardLayout.show(all, "link5"));
			
			add(all);
		}
		
	}
	
	class infoPage extends JPanel
	{
		//explains to the user the backstory and how to play
		private Timer runTimer;
		private int zombX;
		public infoPage()
		{
			//set background color and running method
			setBackground(Color.BLACK);
			runIt();
		}
		public void runIt()
		{
			//adding all the text areas and label for the info page
			//how to play and background story
			
			setLayout(new BorderLayout());
			//Image zomb = new ImageIcon("zombie1.gif").getImage();
			//zomb.setBounds(zomb, zombX, 300, 120, 145, null);
			CardLayout cardLayout = new CardLayout();
			JPanel total = new JPanel(cardLayout);
			//using cardlayout to switch between background story and how to play
			JPanel panel2 = new JPanel();
			JPanel prevNextPanel = new JPanel(null);
			prevNextPanel.setBackground(Color.black);
		
			JButton prev = new JButton("Previous");
			prev.setFont(retro);
			prev.setBackground(Color.BLACK);
			prev.setForeground(Color.RED);
			
			JButton next = new JButton("Next");
			next.setFont(retro);
			next.setBackground(Color.BLACK);
			next.setForeground(Color.RED);
			
			back.setFont(font3);
			
			back.setBounds(10,10, 30, 30);
			next.setBounds(500,10,95,30);
			prev.setBounds(370,10,130, 30);
			
			prevNextPanel.add(prev);
			prevNextPanel.add(next);
			prevNextPanel.add(back);
			
			//PANEL 1
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(Color.BLACK);
			
			JLabel title = new JLabel();
			JLabel title2 = new JLabel();
					
			title.setBounds(150,0,600,100);
			title.setFont(font1);
			title.setForeground(Color.WHITE);
			
			title2.setBounds(25,35,600,100);
			title2.setFont(font1);
			title2.setForeground(Color.WHITE);
			
			title.setText("WELCOME TO YOUR");
			title2.setForeground(Color.RED);
			title2.setText("WORST NIGHTMARE");
			
			title.setPreferredSize(new Dimension(600,100));
			title2.setPreferredSize(new Dimension(600,100));
			
			panel.add(title);
			panel.add(title2);
			
			JTextArea t1;
			String s = "   A mutated strain of Covid19 brought reckoning to levels\nnever seen before. " 
			+"Those who were infected by this \ndangerous mutation were left in a vegetable state where\nthey yearned for the blood of a human";
			t1 = new JTextArea(s);
			t1.setEditable(false);
			t1.setOpaque(true);
			t1.setFont(font3);
			t1.setBackground(Color.BLACK);
			t1.setForeground(Color.WHITE);
			t1.setLineWrap(true);
			t1.setWrapStyleWord(true);
			t1.setBounds(10,150,600,100);
			panel.add(t1);
			
			JTextArea t2;
			String s1 = "    You are one of the last surviving members of society.\n"
			+ "Previously a doctor, you’ve kept your oath of helping those in need." 
			+ " On an expedition to find food, you find someone lying\noutside a gun store, blood flowing on the cracked pavement near them."
			+ "  You put them on special sedation and embark on a race against time to transport them to the hospital and treat\nthem.\n";
			t2 = new JTextArea(s1);
			t2.setEditable(true);
			t2.setOpaque(true);
			t2.setFont(font3);
			t2.setBackground(Color.BLACK);
			t2.setForeground(Color.WHITE);
			t2.setLineWrap(true);
			t2.setWrapStyleWord(true);
			t2.setBounds(10,250,600,150);
			panel.add(t2);
	
			//PANEL 2
			panel2.setLayout(null);
			panel2.setBackground(Color.BLACK);
			
			JLabel title2A = new JLabel();
			
			title2A.setBounds(25,35,600,100);
			title2A.setFont(font1);
			title2A.setForeground(Color.WHITE);
			
			title2A.setForeground(Color.RED);
			title2A.setText("OBJECTIVE/HOW TO");
			
			title2A.setPreferredSize(new Dimension(600,100));
			//https://www.dafont.com/bitmap.php
			panel2.add(title2A);
			
			JTextArea t3;
			String s3 = "  The player must pass a hoard of zombies, reach the hospital, and play a series of mini games to successfully operate on\nthe person and keep them human."
			+ "If sedation runs out at any\ntime, the person turns into a zombie and kills you."
			+ " The player\nonly has three lives."
			+ " When playing the final mini games, if the player is unable to successfully complete the task in the given amount of time, they automatically lose all lives and must start the game from the beginning.";
			t3 = new JTextArea(s3);
			t3.setEditable(false);
			t3.setOpaque(true);
			t3.setFont(font3);
			t3.setBackground(Color.BLACK);
			t3.setForeground(Color.WHITE);
			t3.setLineWrap(true);
			t3.setWrapStyleWord(true);
			t3.setBounds(10,150,600,200);
			panel2.add(t3);

			JTextArea t4;
			String s4 = " To move forward, click the up arrow.\n To move backward, click the down arrow.\n To move left or right, click the corresponding arrow button(ie  left button for left) "
			+ "Insturctions will appear on the top when mini games begin" ;
			t4 = new JTextArea(s4);
			t4.setEditable(false);
			t4.setOpaque(true);
			t4.setFont(font3);
			t4.setBackground(Color.BLACK);
			t4.setForeground(Color.WHITE);
			t4.setLineWrap(true);
			t4.setWrapStyleWord(true);
			t4.setBounds(10,380,600,600);
			panel2.add(t4);
			
			 
			
			
			total.add(panel, "link1");
			total.add(panel2, "link2");
			
			next.addActionListener(e -> cardLayout.next(total));
			prev.addActionListener(e -> cardLayout.previous(total));
			
			prevNextPanel.setPreferredSize(new Dimension(600,45));
			total.setPreferredSize(new Dimension(600,550));
			
			add(prevNextPanel, BorderLayout.NORTH);
			add(total, BorderLayout.CENTER);
			
		}
	
	}
	
	
	class firstPage extends JPanel implements MouseListener, MouseMotionListener
	{
		//displays the title and buttons, main homepage
		private int width, height;
		private int xMove = 570;
		private int flashCount;
		private int zombX, manX, x, y;
		private Timer zomb;
		private Timer titleTimer, runTimer, manTimer;
		public firstPage()
		{
			//initalizes timers for flashing image and making zombie across screen
			//make the image flash
			setLayout(null);
			x = 0;
			y = 0;
			ImageFlasher imgFlash = new ImageFlasher();
			titleTimer = new Timer(1000, imgFlash);
			titleTimer.start();
			flashCount = 1;
			
			//make the zombie walk
			zombX = 5;
			Runner run = new Runner();
			runTimer = new Timer(100, run);
			runTimer.start();
			addMouseListener(this);
			addMouseMotionListener(this);
		}
		
		public void paintComponent(Graphics g)
		{
			//adding images to the actual panel
			//the background and title
			super.paintComponent(g);
			width = getWidth();
			height = getHeight();
			Image zomb = new ImageIcon("zombie1.gif").getImage();
			
			g.drawImage(finalBkg, 0,0, width, height, null);
			
			ImageIcon img2 = new ImageIcon("army.jpg");
			Image image2 = img2.getImage();
			Image newimg2 = image2.getScaledInstance(140, 60, java.awt.Image.SCALE_SMOOTH);
			img2 = new ImageIcon(newimg2);
			
			play.setIcon(img2);
			play.setForeground(Color.WHITE);
			play.setHorizontalTextPosition(JButton.CENTER);
			play.setVerticalTextPosition(JButton.CENTER);
			
			bkgInfo.setIcon(new ImageIcon(image2.getScaledInstance(230, 60, java.awt.Image.SCALE_SMOOTH)));
			bkgInfo.setForeground(Color.WHITE);
			bkgInfo.setHorizontalTextPosition(JButton.CENTER);
			bkgInfo.setVerticalTextPosition(JButton.CENTER);
			
			//bloodStn.jpg
			play.setBounds(230,290,140,60);
			play.setFont(retro);
			bkgInfo.setFont(retro);
			bkgInfo.setBounds(190,18*20, 230,60);
			add(play);
			add(bkgInfo);
			
			//g.drawImage(new ImageIcon("bloodStn.jpg").getImage(), x-30, y-25, 75, 50, null);
			g.drawImage(zomb, zombX, 435, 120, 150, null);
			Image title = new ImageIcon("title.png").getImage();
			if(flashCount%2!=0)	g.drawImage(title,60,0,500,300, null);
			
		}
		
		
		class ImageFlasher implements ActionListener{
			//makes the title flash
			public void actionPerformed(ActionEvent e)
			{
				//increases counter so i know when to display the image and when not to
				flashCount++;
				repaint();
				grabFocus();
			}
		}
		class Runner implements ActionListener{
			//dealing with zombie x coord
			public void actionPerformed(ActionEvent e)
			{
				//makes the zombie gif actually move
				zombX++;
				if(zombX>550) zombX = 5;
				//manX+=2;
				//if(manX>550) manX = 5;
				repaint();
				grabFocus();
			}
		}
		
		//check if mouse is pressed
		public void mousePressed (MouseEvent e) {}
		//check if mouse is released
		public void mouseReleased (MouseEvent e) {}
		//check if mouse is clicked
		public void mouseClicked (MouseEvent e) {}
		//check if mouse is entered
		public void mouseEntered (MouseEvent e) {}
		//check if mouse is exited
		public void mouseExited (MouseEvent e) {}
		//check if mouse is moved
		public void mouseMoved (MouseEvent e){
			x = e.getX();
			y = e.getY();
			repaint();
			grabFocus();
		}
		//check if mouse is dragged
		public void mouseDragged (MouseEvent e) {}
		
 
	}
	
	//the first "mini game": trying to reach the hospital
	class ZombieH extends JPanel implements KeyListener, MouseListener, MouseMotionListener
	{
		//running away from the zombies, main character movement, and ax
		JButton pause, powerup, info;
		int mcX, mcY, zY, zX, pauseCount, trainX, train2X, trainC1;
		int arrCount;
		boolean mcMoveIt, end;
		Timer mcTimer, zcTimer, ztTimer, times, axTimer, deadT, trainTime, bTime, exTimer, diss, exTime;
		Rectangle mc, spike1;
		Image[] zomb;
		Image[] axe;
		Image[] blood;
		Image[] explode;
		Image spike;
		int[] numX;
		int[] numY, zombCount;
		int obsDeath;
		boolean[] dead, axKill, zombDead; 
		int show;
		int x, xMouse, xA, trainC;
		int time, explosion, explosion2, explosion3, explosion4;
		int axeShow, clickCount, bCount;
		int y, yMouse, yA;
		int range;
		boolean mcDead, mcWin, clicked, move, space, noAX, zombMove, trainStart, trainPower;
		boolean spikeDeath1, spikeDeath2, spikeDeath3, spikeDeath4;
		int axCount;
		Rectangle mcRect, train;
		public ZombieH()
		{
			//declares field variables and timers
			//required for the movement of user 
			//arrays - each position of the zombie is different, have to mantian difference
			bCount = 0;
			blood = new Image[4];
			pause = new JButton("Pause");
			info = new JButton("Info");
			powerup = new JButton("Use!");
			pauseCount = 1;
			trainX = 550;
			train2X = 550;
			obsDeath =0;
			range = 0;
			explosion = 0;
			explosion2 = 0;
			explosion3 = 0;
			spike = new ImageIcon("landmine.png").getImage();
			noAX = false;
			clickCount = 0;
			axCount = 0;
			xMouse = 0;
			trainC1 = 0;
			spikeDeath3 = false;
			trainPower = false;
			zombMove = false;
			kill = 0;
			explode = new Image[9];
			for(int i=0; i<explode.length; i++)
			{
				String s = "explod" + (i+1) + ".png";
				explode[i] = new ImageIcon(s).getImage();
			}
			trainC = 0;
			yMouse = 0;
			clicked = false;
			move = true;
			trainStart = true;
			space = false;
			xA = 500;
			yA = 500;
			axeShow = 0;
			mcDead = false;
			mcWin = false;
			show = 1;
			zomb = new Image[30];
			axe = new Image[8];
			end = false;
			spikeDeath1 = false;
			spikeDeath2 = false;
			numX = new int[zomb.length];
			numY = new int[zomb.length];
			dead = new boolean[zomb.length];
			axKill = new boolean[zomb.length];
			zombDead = new boolean[zomb.length];
			zombCount = new int[zomb.length];
			for(int  j=0; j<zomb.length; j++) zomb[j] = new ImageIcon("zombieFace.png").getImage();
			for(int  i=0; i<zomb.length; i++) 
			{
				zombCount[i] = 0;
				dead[i] = false;
				axKill[i] = false;
				zombDead[i] = false;
			}

			for(int i =0; i<numX.length; i++) 
			{
				numX[i] = (int)(Math.random()*599 + 1);
				if (i!=0) 
				while(Math.abs(numX[i-1]-numX[i])<=100 || (numX[i]>=500 || numX[i]<=10)) numX[i] = (int)(Math.random()*599 + 1);
			}
			for(int s =0; s<numY.length; s++) numY[s] = 0;
			for(int i = 0; i<8; i++) 
			{
				String img = "axe" + (i+1) + ".png";
				axe[i] = new ImageIcon(img).getImage();
			}
			arrCount =-2;
			zY = 0;
			zX = 0;
			mcX = 300;
			mcY = 500;
			mcMoveIt = true;
			addKeyListener(this);
			addMouseListener(this);
			time = 0;
			//when the zombies will appear
			zombTimerMover ztmove = new zombTimerMover();
			ztTimer = new Timer(1250, ztmove);
			
			Train tT = new Train();
			trainTime = new Timer(100, tT);
			//speed of the zombies
			
			zombMover zmove = new zombMover();
			zcTimer = new Timer(93, zmove);
		
			//movement of the main character
			McMover mcmove = new McMover();
			mcTimer = new Timer(150, mcmove);
			
			Dead dead = new Dead();
			deadT = new Timer(2000, dead);
			
			Dissapear dt = new Dissapear();
			diss = new Timer(100, dt);
			
			//axe mover
			AxeMover axT = new AxeMover();
			axTimer = new Timer(60, axT);
			
			//how much time has passed
			keepingTime timeUp = new keepingTime();
			times = new Timer(1000, timeUp);		
			//required for the movement of zombies
		}
		
		public void paintComponent(Graphics g)
		{
			//checks to see if the main character and zombie hit:
			//problems; only seeing when left corner hits, have to make a buffer so it
			//hits the actual character and not just the image
			super.paintComponent(g);
			if(firstMiniEnter) 
			{
				zcTimer.start();
				//times.start();	
				axTimer.start();	
				diss.start();
				ztTimer.start();
				trainTime.start();
				mcTimer.start();
			}
			Image bkg2 = new ImageIcon("zombHoardBKG.jpg").getImage();
			pause.setBounds(500, 500, 100, 50);
			g.drawImage(bkg2,0,0,getWidth(), getHeight(), null);
			g.drawImage(new ImageIcon("track.jpg").getImage(), 0, 150, 600, 30, null);
			
			Pause pr = new Pause();
			pause.addActionListener(pr);
			pause.setFont(retro);
			add(pause);
			
			info.setBounds(525, 450, 75, 50);
			info.setFont(retro);
			all.add(new InfoPageGame1(), "infoStuff");
			info.addActionListener(e -> cardLayout.show(all, "infoStuff"));
			add(info);
			
			
			mcRect = new Rectangle(mcX+5, mcY+10, 45, 40);
			
			g.drawImage(blood[bCount], mcX, mcY, 50, 50, null);
			g.drawImage(new ImageIcon("smoke.gif").getImage(),trainX-12, 285, 100, 100, null);
			//trainRect = new Rectangle(trainX, 350, 145, 75);
			
			if(!spikeDeath1)
			{
				g.drawImage(spike, 25, 300, 35, 35, null);
				spike1 = new Rectangle(40, 315, 20, 20);
				if(spike1.intersects(mcRect)) 
				{
					spikeDeath1 = true;
					obsDeath++;
					for(int i =0; i<arrCount; i++) 
					{
						if(Math.abs(numX[i]-40)<=135 && Math.abs(numY[i]-315)<=135) 
						{
							zomb[i] = new ImageIcon("deadZomb.png").getImage();
							zombDead[i] = true;
						}
					}
					mcX= 300;
					mcY = 500;
				}
			}
			if(spikeDeath1) 
			{
				g.setColor(Color.GREEN);
				g.drawImage(explode[explosion], -10, 260, 135, 135, null);
			}
			
			if(!spikeDeath2)
			{
				g.drawImage(spike, 500, 100, 35, 35, null);
				spike1 = new Rectangle(500, 100, 35, 35);
				if(spike1.intersects(mcRect)) 
				{
					spikeDeath2 = true;
					obsDeath++;
					for(int i =0; i<arrCount; i++) 
					{
						if(Math.abs(numX[i]-515)<=135 && Math.abs(numY[i]-115)<=135) 
						{
							zomb[i] = new ImageIcon("deadZomb.png").getImage();
							zombDead[i] = true;
						}
					}
					mcX = 300;
					mcY = 500;
				}
			}
			if(spikeDeath2) g.drawImage(explode[explosion2], 465, 45, 135, 135, null);
			
			if(!spikeDeath3)
			{
				g.drawImage(spike, 300, 250, 35, 35, null);
				spike1 = new Rectangle(300, 250, 35, 35);
				if(spike1.intersects(mcRect)) 
				{
					spikeDeath3 = true;
					obsDeath++;
					for(int i =0; i<arrCount; i++) 
					{
						if(Math.abs(numX[i]-315)<=135 && Math.abs(numY[i]-315)<=135) 
						{
							zomb[i] = new ImageIcon("deadZomb.png").getImage();
							zombDead[i] = true;
						}
					}
					mcX = 300;
					mcY = 500;
				}
			}
			if(spikeDeath3) g.drawImage(explode[explosion3], 265, 215, 135, 135, null);
			
			if(!spikeDeath4)
			{
				g.drawImage(spike, 500, 320, 35, 35, null);
				spike1 = new Rectangle(500, 320, 35, 35);
				if(spike1.intersects(mcRect)) 
				{
					spikeDeath4 = true;
					obsDeath++;
					for(int i =0; i<arrCount; i++) 
					{
						if(Math.abs(numX[i]-315)<=135 && Math.abs(numY[i]-315)<=135) 
						{
							zomb[i] = new ImageIcon("deadZomb.png").getImage();
							zombDead[i] = true;
						}
					}
					mcX = 300;
					mcY = 500;
				}
			}
			if(spikeDeath4) g.drawImage(explode[explosion4], 430, 250, 135, 135, null);
			
			g.drawImage(new ImageIcon("train.png").getImage(),train2X, 95, 145, 75, null);
			
			
			Image mc1 = new ImageIcon("mc.png").getImage();
			g.drawImage(mc1, mcX, mcY, 50, 50, null);

			Rectangle trainRect = new Rectangle(trainX, 370, 145, 45);
			g.drawImage(new ImageIcon("train.png").getImage(),trainX, 340, 145, 75, null);
			if(mcRect.intersects(trainRect))
			{
				obsDeath+=2;
				mcX= 300;
				mcY = 500;
			}
			
			for(int i =0; i<=arrCount;i++)
			{
				Rectangle train2 = new Rectangle(train2X, 130, 145, 45);
				Rectangle zombRect = new Rectangle(numX[i], numY[i], 50, 50);
				if(train2.intersects(zombRect)) 
				{
					zombDead[i] = true;
					zomb[i] = new ImageIcon("deadZomb.png").getImage();
				}
			}
			
			for(int i =0; i<=arrCount; i++)
			{
				zY = numY[i];
				zX = numX[i];
				if(zombCount[i]<10)g.drawImage(zomb[i], zX, zY, 50, 50, null);
			}
			
			
			if(axCount!=0 && range<120) 
			{
				g.drawImage(axe[axeShow], xA, yA, 50, 50, null);
			}
			powerup.setBounds(500, 425, 100, 30);
			PW pw = new PW();
			powerup.addActionListener(pw);
			powerup.setFont(retro);
			add(powerup);
			
			//else noAX = true;
			boolean inY  = false;
			boolean inX = false;
			boolean inYa  = false;
			boolean inXa = false;
			//for(int i = 0; i<zomb.length; i++)
			for(int i=0; i<arrCount; i++)
			{
				Rectangle zombr1 = new Rectangle(numX[i]+5, numY[i]+10,40, 40);
				if(!dead[i] || !zombDead[i])
				{
					if(mcRect.intersects(zombr1))
					{
						dead[i] = true;
						zomb[i] = new ImageIcon("deadZomb.png").getImage();
					}
				}
			}
			
			for(int i = 0; i<arrCount; i++)
			{
				x = (int)mcRect.getX();
				y = (int)mcRect.getY();

				inYa = false;
				inXa = false;
				for(int s = numX[i]+10; s<=numX[i]+43; s++) if(!noAX) for(int k = xA+15; k<=xA+45; k++) if(k==s) inXa = true;

				for(int s = numY[i]+10; s<=numY[i]+43; s++)if(!noAX) for(int k = yA+15; k<=yA+50; k++) if(k==s) inYa = true;
				if(inXa && inYa) 
				{
					axKill[i] = true;
					zomb[i] = new ImageIcon("deadZomb.png").getImage();
				}
			}
	
			//for the heart - make it bobbing
			if(!mcWin && sedateTime>0) for(int i =0; i<dead.length; i++) if(dead[i]) deathCount++;
			deathCount = deathCount + obsDeath;
			Image[] imgs = new Image[2];
			imgs[1] = new ImageIcon("halfHeart.png").getImage();
			imgs[0] = new ImageIcon("fullHeart.png").getImage();
			for(int i = 0; i<=deathCount; i++)
			{
				if(deathCount==0)
				{
					g.drawImage( imgs[0],0,0,35, 35, null);
					g.drawImage( imgs[0],35,0,35, 35, null);
					g.drawImage( imgs[0],75,0,35, 35, null);
				}
				if(deathCount==1) 
				{
					g.drawImage( imgs[0],0,0,35, 35, null);
					g.drawImage( imgs[0],35,0,35, 35, null);
					g.drawImage( imgs[1],75,0,35, 35, null);
				}
				if(deathCount==2) 
				{
					g.drawImage( imgs[0],0,0,35, 35, null);
					g.drawImage( imgs[0],35,0,35, 35, null);
				}
				if(deathCount==3) 
				{
					g.drawImage( imgs[0],0,0,35, 35, null);
					g.drawImage( imgs[1],35,0,35, 35, null);
					
				}
				if(deathCount==4) 
				{
					g.drawImage( imgs[0],0,0,35, 35, null);
					
				}
				if(deathCount==5) 
				{
					g.drawImage( imgs[1],0,0,35, 35, null);
				}
				if(deathCount>=6) mcDead = true;
				
				//if(deathCount%2!=0) g.drawImage( new ImageIcon("halfHeart.png").getImage(),0,0,20, 20, null);
			}
			g.setColor(Color.WHITE);
			g.drawRoundRect(450, 20, 100, 10, 10, 10);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Retro Gaming", Font.BOLD, 15));
			g.drawString("Sedation", 457, 15);
			sedateTime = 100-2*time;
			if(sedateTime<=100 && sedateTime>=80) g.setColor(Color.GREEN);
			else if(sedateTime<80 && sedateTime>=45) g.setColor(Color.YELLOW);
			else if(sedateTime<45 && sedateTime>=0) g.setColor(Color.RED);
			g.fillRoundRect(450, 20, 100-2*time, 10, 10, 10);
			if(((mcDead || sedateTime<=0))&&!mcWin) 
			{
				mcDead = true;
				times.stop();
				zcTimer.stop();
				ztTimer.stop();
				mcTimer.stop();
				g.setColor(Color.RED);
				g.setFont(new Font("Retro Gaming", Font.BOLD, 36));
				g.drawString("Game Over",200, 200);
				//GameOver mps = new GameOver(); 
				//end = true;
				deathCount = 0;
				finalSedate = sedateTime;
				for(int i =0; i<dead.length; i++) if(dead[i]) deathCount++;
				lives = (6.0-(double)(deathCount+obsDeath))/2.0;
				kill = 0;
				for(int i =0; i<axKill.length; i++) if(axKill[i]) kill+=1;
				for(int i =0; i<zombDead.length; i++) if(zombDead[i]) kill+=1;
				deadT.start();
			}
			else if(mcY<=0 || mcWin) 
			{
				mcWin = true;
				hoardWon = true;
				zcTimer.stop();
				ztTimer.stop();
				times.stop();
				finalSedate = sedateTime;
				deathCount = 0;
				for(int i =0; i<dead.length; i++) if(dead[i]) deathCount++;
				lives = (6.0-(double)deathCount)/2.0;
				kill = 0;
				for(int i =0; i<axKill.length; i++) if(axKill[i]) kill+=1;
				for(int i =0; i<zombDead.length; i++) if(zombDead[i]) kill+=1;
				deadT.start();
				g.setColor(Color.GREEN);
				g.setFont(new Font("Retro Gaming", Font.BOLD, 36));
				g.drawString("YOU WON",200, 200);
			}
			if(!mcWin && !end) deathCount = 0;
			
			//time left
		}
		
		public void reset()
		{
			//resets the entire thing so when you play from the beinging all stats are reset
			range = 0;
			noAX = false;
			clickCount = 0;
			axCount = 0;
			xMouse = 0;
			yMouse = 0;
			zombMove = false;
			clicked = false;
			move = true;
			space = false;
			xA = 500;
			yA = 500;
			axeShow = 0;
			mcDead = false;
			mcWin = false;
			show = 1;
			deathCount = 0;
			zomb = new Image[30];
			axe = new Image[8];
			numX = new int[zomb.length];
			numY = new int[zomb.length];
			dead = new boolean[zomb.length];
			axKill = new boolean[zomb.length];
			//deathCount = 0;
			for(int  j=0; j<zomb.length; j++) zomb[j] = new ImageIcon("zombieFace.png").getImage();
			for(int  i=0; i<zomb.length; i++) 
			{
				dead[i] = false;
				axKill[i] = false;
			}

			for(int i =0; i<numX.length; i++) 
			{
				numX[i] = (int)(Math.random()*599 + 1);
				if (i!=0) 
				while(Math.abs(numX[i-1]-numX[i])<=100 || (numX[i]>=500 || numX[i]<=10)) numX[i] = (int)(Math.random()*599 + 1);
			}
			for(int s =0; s<numY.length; s++) numY[s] = 0;
			for(int i = 0; i<8; i++) 
			{
				String img = "axe" + (i+1) + ".png";
				axe[i] = new ImageIcon(img).getImage();
			}
			arrCount =-2;
			zY = 0;
			zX = 0;
			mcX = 300;
			mcY = 500;
			mcMoveIt = true;
			addKeyListener(this);
			addMouseListener(this);
			sedateTime = 100;
			time = 0;
			//when the zombies will appear
			zombTimerMover ztmove = new zombTimerMover();
			ztTimer = new Timer(1250, ztmove);
			
			//speed of the zombies
			zombMover zmove = new zombMover();
			zcTimer = new Timer(93, zmove);
		
			//movement of the main character
			McMover mcmove = new McMover();
			mcTimer = new Timer(150, mcmove);

			//axe mover
			AxeMover axT = new AxeMover();
			axTimer = new Timer(60, axT);
			
			Dead dead = new Dead();
			deadT = new Timer(2000, dead);
			
			//how much time has passed
			keepingTime timeUp = new keepingTime();
			times = new Timer(1000, timeUp);	
		}
		
		class keepingTime implements ActionListener
		{
			//so i know how much time has passed for since user began playing
			public void actionPerformed(ActionEvent e)
			{
				//increase time var
				time++;
				repaint();
				grabFocus();
			}
		}
		
		class Pause implements ActionListener
		{
			//pause timer
			public void actionPerformed(ActionEvent e)
			{
					//increase time var
				pauseCount++;
				if(pauseCount%2==0)
				{
					pause.setForeground(Color.RED);
					pause.setText("Resume");
					times.stop();
					zcTimer.stop();
					ztTimer.stop();
					firstMiniEnter = false;
				}
				if(pauseCount%2!=0)
				{
					pause.setForeground(Color.GREEN);
					pause.setText("Pause");
					firstMiniEnter = true;

				}
				repaint();
				grabFocus();
			}
		}
		
		class PW implements ActionListener
		{
			//the power for poving the train
			public void actionPerformed(ActionEvent e)
			{
					//increase time var
				String cmnd = e.getActionCommand();
				if(cmnd.equals("Use!"))trainPower = true;
				repaint();
				grabFocus();
			}
		}
		
		class Dead implements ActionListener
		{
			//what happens if user dies
			public void actionPerformed(ActionEvent e)
			{
				//increase time var
				all.add(new GameOver(), "gameScreen");
				all.add(new GameWon(), "gameWon");
				if(mcWin) cardLayout.show(all, "gameWon");
				if(mcDead) cardLayout.show(all, "gameScreen");

				deadT.stop();
				reset();
			}
		}
		
		class Dissapear implements ActionListener
		{
			//makes the zombies dissapear
			public void actionPerformed(ActionEvent e)
			{
					//increase time var
				for(int i =0; i<zomb.length; i++)
				{
					if(zombDead[i] || dead[i]) zombCount[i]++;
				}
			}
		}
		
		class AxeMover implements ActionListener
		{
			//determines the entire animation of the ax
			public void actionPerformed(ActionEvent e)
			{
				//includes when the different sprites show and how the ax moves
				axeShow++;
				if(axCount==0) 
				{
					noAX = true;
					xA = mcX-15;
					yA = mcY;
				}
				if(axeShow>7) axeShow=0;
				if(clicked && !space)
				{
					noAX = false;
					if(xA-xMouse+10>0) xA-=3;
					if(xA-xMouse+10<0) xA+=3;
					if(yA-yMouse+10>0) yA-=3;
					if(yA-yMouse+10<0) yA+=3;
					
					range++;
				}
				if(space)
				{
					range=0;
					if(xA-mcX>0) xA-=10;
					if(xA-mcX<0) xA+=10;
					if(yA-mcY>0) yA-=10;
					if(yA-mcY<0) yA+=10;
					if(Math.abs(xA-mcX)<10 && Math.abs(yA-mcY)<10) 
					{
						noAX = true;
						space = false;
						clickCount = 0;
						clicked = false;
						axCount = 0;
					}
				}
				if(range>120) 
				{
					range = 0;
					space = false;
					clickCount = 0;
					clicked = false;
					axCount = 0;
					xA = mcX-15;
					yA = mcY;
					noAX = true;
				}
				repaint();
				grabFocus();
			}
		}
		
		class McMover implements ActionListener
		{
			//restricts user from going past bounds
			public void actionPerformed(ActionEvent e) 
			{
				//cheat code of going around the entire hoard
				if (mcX > 560) mcX = 0;
				if (mcY>600) mcY=20;
				if (mcY<0) mcY = 0;
				//if(mcX+50>=380 && mcX+50<=520 && mcY+50>=455 && mcX+50<=515) mcX =330;
				if(mcX < 0) mcX = 560;

				
				else if(mcX<0) mcX = 0;
				//23, 19
				//7 by 3

				repaint();
				grabFocus();
			}
		}
		
		class Train implements ActionListener
		{
			//moves a train that kills the mc if they get hit
			public void actionPerformed(ActionEvent e) 
			{
				//explosions are attached to this timer as well
				trainC++;
				trainC1++;
				if(spikeDeath1) if(explosion<explode.length-1) explosion++;
				if(!spikeDeath1) explosion=0;
				if(spikeDeath2) if(explosion2<explode.length-1) explosion2++;
				if(!spikeDeath2) explosion2=0;
				if(spikeDeath3) if(explosion3<explode.length-1) explosion3++;
				if(!spikeDeath3) explosion3=0;
				if(spikeDeath4) if(explosion4<explode.length-1) explosion4++;
				if(!spikeDeath4) explosion4=0;

				if(trainPower) 
				{
					powerup.setText("Not yet");
					if(train2X+300<0) 
					{
						train2X = 550;
						if(trainC1>35) trainC1 = 35;
						if(trainC1%35==0) 
						{
							trainC1 = 0;
							trainPower = false;
							powerup.setText("Use!");
						}
					}
					else train2X-=15;
				}
				if(trainX+300<0) if(trainC%27!=0) trainX = 550;
				trainX-=15;
				repaint();
				grabFocus();
			}
		}
		
		
		class zombMover implements ActionListener
		{
			//determine movement of zombies
			public void actionPerformed(ActionEvent e) 
			{
				//actually animates the zombies
				mcRect = new Rectangle(mcX, mcY, 50, 50);
				if(firstMiniEnter)
				{
					for(int i =0; i<=arrCount; i++) 
					{
						
						x = (int)mcRect.getX();
						y = (int)mcRect.getY();
						if(axKill[i]|| dead[i] || zombDead[i]) numY[i] = numY[i];
						else
						{
							if(Math.abs(numX[i]-x)<=200 && Math.abs(numY[i]-y)<=200)
							{
								if(x-numX[i]>0) numX[i]+=2;
								if(x-numX[i]<0) numX[i]-=2;
								if(y-numY[i]>0) numY[i]+=2;
								if(y-numY[i]<0) numY[i]-=2;
							}
							else numY[i]+=2;
						}
					}
					show++;
				}
				repaint();
				grabFocus();
			}
		}
		
		class zombTimerMover implements ActionListener
		{
			//makes sure zombies appear at differnt times
			public void actionPerformed(ActionEvent e) 
			{
				//allows for zombies to show up at different times
				if(firstMiniEnter)arrCount++;
				if(arrCount>zomb.length-1) arrCount = zomb.length-1;
				if(arrCount==4) zombMove = true;
				repaint();
				grabFocus();
			}
		}
		
		
		public void keyReleased(KeyEvent e){
			//stops main character movement if any key is released
			if (mcMoveIt) mcTimer.stop();
            else mcTimer.start();
			//mcMoveIt = !mcMoveIt;
			mcMoveIt = false;
			repaint();
		}
		
		//handler for if key is typed
		public void keyTyped(KeyEvent e) {}
		
		public void keyPressed(KeyEvent e) {
			//handler for if key is pressed
				int special = e.getKeyCode();
				if(!mcDead && firstMiniEnter)// && zombMove)
				{
					times.start();
					switch(special)
					{
						//up moves up, down moves player down, etc
						case  KeyEvent.VK_UP:
							mcY-=10;
							break;
						 case  KeyEvent.VK_DOWN:
							mcY+=10;
							break;
						 case KeyEvent.VK_RIGHT:
							mcX+=10;
							break;
						 case KeyEvent.VK_LEFT:
							mcX-=10;
							break;
						case KeyEvent.VK_SHIFT:
							space = true;
							break;
							
						case KeyEvent.VK_W: 
							yA-=10;
							break;
						case  KeyEvent.VK_S:
							yA+=10;
							break;
						case KeyEvent.VK_D:
							xA+=10;
							break;
						case KeyEvent.VK_A:
							xA-=10;
							break;
					}
					
				}		
		}
		
		//checks if mouse was pressed
		public void mousePressed (MouseEvent e) {}
		
		//checks if mouse was released
		public void mouseReleased (MouseEvent e) {}
		 
		public void mouseClicked (MouseEvent e){
		//takes the ax to the point where mouse is clicked
				if(firstMiniEnter) 
				{
					axCount++;
					clickCount++;
				}
				if(clickCount==0 || clickCount==1)
				{
					xMouse = e.getX();
					yMouse = e.getY();
					clicked = true;	
				}
				repaint();
				grabFocus();			
				//check if they hit
		
		} 
		//checks if mouse entered frame
		public void mouseEntered (MouseEvent e) {}
		
		//checks if mouse exited frame
		public void mouseExited (MouseEvent e){}
		
		//checks if mouse was moved
		public void mouseMoved (MouseEvent e){}
		
		//checks if mouse was dragged
		public void mouseDragged (MouseEvent e){}
  
	
	}
	
	class TransP1 extends JPanel
	{
		//first panel that explains background
		int charNum;
		Timer readTime;
		JTextArea ta;
		boolean done;
		public TransP1()
		{
			//defining all the variables and starting timers
			setBackground(Color.WHITE);
			setLayout(null);
			done = false;
			ta = new JTextArea("");
			ta.setEditable(false);
			charNum = 0;
			SlowRead read = new SlowRead();
			readTime = new Timer(100, read);
		}
		
		public void paintComponent(Graphics g)
		{
			//drawing background, text labels, and buttons
			super.paintComponent(g);
			if(p1Trans) readTime.start();
			Image apocBKG = new ImageIcon("apocBKG.jpg").getImage();
			g.drawImage(apocBKG, 0,0, 600, 450, null);
			String txt = textRead("It was the year 2026. As COVID20 cases seemed to\nfall, a new mutated strain wreacked havoc upon the\nworld.");
			ta.setFont(retro);
			ta.setText(txt);
			ta.setBounds(0, 450, 600, 75);
			add(ta);
			runIt();
		}
		
		public String textRead(String str)
		{
			//makes text go slowly
			String newStr = "";
			if(charNum>str.length()-1)
			{
				charNum = str.length()-1;
				done = true;
			}
			for(int i =0; i<=charNum; i++)
			{
				newStr += "" + str.charAt(i);
			}
			return newStr;
		}
		
		class SlowRead implements ActionListener
		{
			//timer to see how slow text moves
			public void actionPerformed(ActionEvent e)
			{
				//increase char num
				charNum++;
				repaint();
				grabFocus();
			}
		}
		
		public void runIt()
		{
			//prints button so that it shows at all times
			next1.setFont(font2);
			next1.setOpaque(true);
			next1.setBounds(500, 525, 100, 40);
			add(next1);
		}
				
	}
	
	
	class TransP4 extends JPanel
	{
		//fourth panel that explains background
		int charNum;
		Timer readTime;
		JTextArea ta;
		JButton next4;
		boolean done;
		public TransP4()
		{
			//defining all the variables and starting timers
			setBackground(Color.WHITE);
			setLayout(null);
			next4 = new JButton("next");
			done = false;
			ta = new JTextArea("");
			ta.setEditable(false);
			charNum = 0;
			SlowRead read = new SlowRead();
			readTime = new Timer(100, read);
		}
		
		public void paintComponent(Graphics g)
		{
			//drawing background, text labels, and buttons
			super.paintComponent(g);
			if(p1Trans) readTime.start();
			Image apocBKG = new ImageIcon("hospital.jpg").getImage();
			g.drawImage(apocBKG, 0,0, 600, 450, null);
			String txt = textRead("You've successfully crossed the hoard of blood\n thirsty zombies. Look, I think I see the hospital!");
			ta.setFont(retro);
			ta.setText(txt);
			ta.setBounds(0, 450, 600, 75);
			add(ta);
			runIt();
		}
		
		public String textRead(String str)
		{
			//makes text go slowly
			String newStr = "";
			if(charNum>str.length()-1)
			{
				charNum = str.length()-1;
				done = true;
			}
			for(int i =0; i<=charNum; i++)
			{
				newStr += "" + str.charAt(i);
			}
			return newStr;
		}
		
		class SlowRead implements ActionListener
		{
			//timer to see how slow text moves
			public void actionPerformed(ActionEvent e)
			{
				//increase char num
				charNum++;
				repaint();
				grabFocus();
			}
		}
		
		public void runIt()
		{
			//prints button so that it shows at all times
			next4.setFont(font2);
			next4.setOpaque(true);
			next4.setBounds(500, 525, 100, 40);
			add(next4);
			all.add(new TransP5(), "trans5");
			next4.addActionListener(e -> cardLayout.show(all, "trans5"));
		}
				
	}
	
	class TransP5 extends JPanel
	{
		//fifth panel that explains background
		int charNum;
		Timer readTime;
		JTextArea ta;
		JButton next5;
		boolean done;
		public TransP5()
		{
			//defining all the variables and starting timers
			setBackground(Color.WHITE);
			setLayout(null);
			next5 = new JButton("next");
			done = false;
			ta = new JTextArea("");
			ta.setEditable(false);
			charNum = 0;
			SlowRead read = new SlowRead();
			readTime = new Timer(100, read);
		}
		
		public void paintComponent(Graphics g)
		{
			//drawing background, text labels, and buttons
			super.paintComponent(g);
			if(p1Trans) readTime.start();
			Image apocBKG = new ImageIcon("hospital2.jpg").getImage();
			g.drawImage(apocBKG, 0,0, 600, 450, null);
			String txt = textRead("It seems as though the virus has completely\noverun the bodies immune system. Operate on your\npatient with the instructions given");
			ta.setFont(retro);
			ta.setText(txt);
			ta.setBounds(0, 450, 600, 75);
			add(ta);
			runIt();
		}
		
		public String textRead(String str)
		{
			//makes text go slowly
			String newStr = "";
			if(charNum>str.length()-1)
			{
				charNum = str.length()-1;
				done = true;
			}
			for(int i =0; i<=charNum; i++)
			{
				newStr += "" + str.charAt(i);
			}
			return newStr;
		}
		
		class SlowRead implements ActionListener
		{
			//timer to see how slow text moves
			public void actionPerformed(ActionEvent e)
			{
				//increase char num
				charNum++;
				repaint();
				grabFocus();
			}
		}
		
		public void runIt()
		{
			//prints button so that it shows at all times
			next5.setFont(font2);
			next5.setOpaque(true);
			next5.setBounds(500, 525, 100, 40);
			add(next5);
			all.add(new TransportHeart(), "heart");
			next5.addActionListener(e -> cardLayout.show(all, "heart"));
		}
				
	}

	class TransP6 extends JPanel
	{
		//sixth panel that explains background
		int charNum;
		Timer readTime;
		JTextArea ta;
		JButton next6, quit;
		boolean done;
		public TransP6()
		{
			//defining all the variables and starting timers
			setBackground(Color.WHITE);
			setLayout(null);
			next6 = new JButton("next");
			done = false;
			ta = new JTextArea("");
			ta.setEditable(false);
			charNum = 0;
			SlowRead read = new SlowRead();
			readTime = new Timer(100, read);
		}
		
		public void paintComponent(Graphics g)
		{
			//drawing background, text labels, and buttons
			super.paintComponent(g);
			if(p1Trans) readTime.start();
			Image apocBKG = new ImageIcon("virusBKG.jpg").getImage();
			g.drawImage(apocBKG, 0,0, 600, 450, null);
			String txt = textRead("Now that you've transferred the heart to a sanitary area, it's time to terminate the viruses. Click to shoot bullets. HINT:Every eigth bullet will destroy the spawn.");
			ta.setLineWrap(true);
			ta.setWrapStyleWord(true);
			ta.setEditable(false);
			ta.setFont(retro);
			ta.setText(txt);
			ta.setBounds(0, 450, 600, 75);
			next6.setBounds(500, 525, 100, 40);
			next6.setOpaque(true);
			all.add(new Shooters(), "shoot");
			next6.addActionListener(e -> cardLayout.show(all, "shoot"));
			next6.addActionListener(e -> secondEnter = true);
			add(next6);
			add(ta);
		}
		
		public String textRead(String str)
		{
			//makes text go slowly
			String newStr = "";
			if(charNum>str.length()-1)
			{
				charNum = str.length()-1;
				done = true;
			}
			for(int i =0; i<=charNum; i++)
			{
				newStr += "" + str.charAt(i);
			}
			return newStr;
		}
		
		class SlowRead implements ActionListener
		{
			//timer to see how slow text moves
			public void actionPerformed(ActionEvent e)
			{
				//increase char num
				charNum++;
				repaint();
				grabFocus();
			}
		}
		
	}
	class TransP2 extends JPanel
	{
		//panel 2, explains the background
		int charNum;
		Timer readTime;
		JTextArea ta;
		boolean done;
		public TransP2()
		{
			//defining all variables
			setBackground(Color.WHITE);
			setLayout(null);
			done = false;
			ta = new JTextArea("");
			ta.setEditable(false);
			charNum = 0;
			SlowRead read = new SlowRead();
			readTime = new Timer(100, read);

		}
		
		public void paintComponent(Graphics g)
		{
			//drawing background and text label
			super.paintComponent(g);
			if(p1Trans) readTime.start();
			Image apocBKG = new ImageIcon("rain.gif").getImage();
			g.drawImage(apocBKG, 0,90, 600, 490, null);
			String txt = textRead("The strain did not just kill. It kept those who died,\nalive. In a zombie like state.");
			ta.setFont(retro);
			ta.setText(txt);
			ta.setBounds(0, 0, 600, 50);
			add(ta);
			runIt();
		}
		
		public String textRead(String str)
		{
			//only shows button after entire text is read
			String newStr = "";
			if(charNum>str.length()-1)
			{
				charNum = str.length()-1;
				done = true;
				readTime.stop();
	
			}
			for(int i =0; i<=charNum; i++)
			{
				newStr += "" + str.charAt(i);
			}
			return newStr;
		}
		
		class SlowRead implements ActionListener
		{
			//how fast the text appears
			public void actionPerformed(ActionEvent e)
			{
				//increase char num, adding on new char for string
				charNum++;
				repaint();
				grabFocus();
			}
		}
		
		public void runIt()
		{
			//prints button so that it shows at all times
			next2.setFont(font3);
			next2.setOpaque(true);
			next2.setBounds(500, 50, 100, 40);
			add(next2);
		}
				
	}
	
	class TransP3 extends JPanel
	{
		//third panel that explains background
		int charNum;
		boolean sec;
		Timer readTime;
		JTextArea ta;
		boolean done;
		public TransP3()
		{
			//defining all the variables and starting timers
			sec = false;
			setBackground(Color.WHITE);
			setLayout(null);
			done = false;
			ta = new JTextArea("");
			ta.setEditable(false);
			charNum = 0;
			SlowRead read = new SlowRead();
			readTime = new Timer(100, read);
		}
		
		public void paintComponent(Graphics g)
		{
			//drawing background, text labels, and buttons
			super.paintComponent(g);
			if(p1Trans) readTime.start();
			Image apocBKG2 = new ImageIcon("apocBKG2.jpg").getImage();
			g.drawImage(apocBKG2, 0,0, 600, 450, null);
			String txt = textRead("Military forces were engaged. Humanity joined\ntogether to kill those infected to avoid the spread.\nBut how do you kill something that's already dead?");
			ta.setFont(retro);
			ta.setText(txt);
			ta.setBounds(0, 450, 600, 75);
			add(ta);
			runIt();
		}
		
		public String textRead(String str)
		{
			//makes text go slowly
			String newStr = "";
			if(charNum>str.length()-1)
			{
				charNum = str.length()-1;
				done = true;
			}
			for(int i =0; i<=charNum; i++)
			{
				newStr += "" + str.charAt(i);
			}
			return newStr;
		}
		
		class SlowRead implements ActionListener
		{
			//timer to see how slow text moves
			public void actionPerformed(ActionEvent e)
			{
				//increase the char num, adding onto the slow moving text
				charNum++;
				repaint();
				grabFocus();
			}
		}
	
		
		public void runIt()
		{
			//prints button so that it shows at all times
			next3.setFont(font2);
			next3.setOpaque(true);
			next3.setBounds(500, 525, 100, 40);
			add(next3);
		}
				
	}
	

	class InfoPageGame1 extends JPanel
	{
		//info for zombie hoard
		int charNum;
		boolean sec;
		Timer readTime;
		JTextArea ta, ta2, ta3;
		boolean done;
		public InfoPageGame1()
		{
			//defining all the variables, text areas
			sec = false;
			setBackground(Color.WHITE);
			setLayout(null);
			done = false;
			ta = new JTextArea("");
			ta2 = new JTextArea("");
			ta3 = new JTextArea("");
			charNum = 0;
		}
		
		public void paintComponent(Graphics g)
		{
			//drawing background, text labels, and buttons
			super.paintComponent(g);
			
			String s1 = "   Throwing your axe will kill zombies."
			+ " To throw your axe,click to the point you want it to go. "
			+ " To make it come back to you, press shift. "
			+ " Colliding with zombies will both harm your health by half a heart and one shot the zombies. "
			+ " Zombies within a 200 pixel radius will walk specifically to you.";

			String s2 = "   The train closest to the bottom of the screen is deployed by the zombies and will kill one whole heart and ersparen you to the bottom. "
			+ " You can control the train near the end, which one shots zombies in its path.";
			
			String s3 = "   If you step on a landmine, it will explode, disappear, kill half of your heart and" + 
			" kill any zombies within a 135 pixel radius of your explosion.";

			
			ta = textSettings(ta,s1);
			ta.setBounds(10,75,590,120);
			add(ta);
			
			ta2 = textSettings(ta2,s2);
			ta2.setBounds(10,250,590,100);
			add(ta2);
			
			ta3 = textSettings(ta3,s3);
			ta3.setBounds(10,425,590,75);
			add(ta3);
			
			g.drawImage(new ImageIcon("landmine.png").getImage(), 250, 375, 50, 50, null);
			g.drawImage(new ImageIcon("axe1.png").getImage(), 250, 10, 50, 50, null);
			g.drawImage(new ImageIcon("train.png").getImage(), 250, 200, 100, 50, null);
			
			JButton quit1 = new JButton("Back");
			quit1.setFont(font3);
			quit1.setBounds(0,500, 100, 50);
			all.add(new ZombieH(), "zombieH");
			quit1.addActionListener(e -> cardLayout.show(all, "zombieH"));
			add(quit1);
			
		}
		
		public JTextArea textSettings(JTextArea t1, String str)
		{
			//adding the text area
			t1 = new JTextArea(str);
			t1.setOpaque(true);
			t1.setFont(font3);
			t1.setLineWrap(true);
			t1.setWrapStyleWord(true);
			t1.setEditable(false);
			return t1;
		}
				
	}

	class  MinigameHub extends JPanel implements MouseListener, MouseMotionListener 
	{
		//puts together the different stages of the game
		private Image stgBkg;
		private JButton b1 = new JButton("Level 1");
		private JButton convert = new JButton("Cash In");
		private JButton b2 = new JButton("");
		private JButton b3 = new JButton("");
		private JButton b4 = new JButton("");
		private JButton clicker = new JButton("Salvation");
		public MinigameHub()
		{
			//sets layout, declares field variables, and calls method
			//setBackground(Color.WHITE); 
			setLayout(null);
			stgBkg = new ImageIcon("stgBkg.jpg").getImage();
			//runIt();
			//img.setScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		}
		public void paintComponent(Graphics g)
		{
			//calling paintComponent so drawing on panels is possible
			super.paintComponent(g);
			g.drawImage(stgBkg, 0, 0, 600, 600, null);
			JPanel lvls = new JPanel(new GridLayout(2, 3));
			JPanel stats = new JPanel(new GridLayout(1,3, 100, 10));
			stats.setBounds(0, 0, 600, 40);
			if(lives>6) lives =6;
			JLabel hearts = new JLabel("Lives: " + lives);
			if(finalSedate>100) finalSedate = 100;
			JLabel sedation = new JLabel("Percentage: " + finalSedate + "%");
			JLabel kills = new JLabel("Zombie Toes: " + kill);
			stats.add(hearts);
			stats.add(sedation);
			stats.add(kills);
			lvls.setBounds(0, 200, 600, 300);
			add(stats);
			lvls.setBackground(new Color(0, 0, 0, 0));
			//img1.setScaledInstance(100, 50);
			
			b1.setPreferredSize(new Dimension(100, 50));

			lvls.add(b1);
			lvls.add(b2);
			lvls.add(b3);
			lvls.add(b4);
			lvls.add(clicker);
			add(lvls);
			
			b1.setFont(retro);
			b2.setFont(retro);
			b3.setFont(retro);
			b4.setFont(retro);
			clicker.setFont(retro);
			
			ImageIcon img1 = new ImageIcon("lock.png");
			Image image = img1.getImage();
			Image newimg = image.getScaledInstance(170, 120, java.awt.Image.SCALE_SMOOTH);
			img1 = new ImageIcon(newimg);
			if(!hoardWon) b2.setIcon(img1);
			if(hoardWon) 
			{
				b2.setIcon(new ImageIcon("explod9.png"));
				b2.setText("Level 2");
				b2.setHorizontalTextPosition(JButton.CENTER);
				b2.setVerticalTextPosition(JButton.CENTER);
			}

			if(!heartWon) b3.setIcon(img1);
			if(heartWon) 
			{
				b3.setIcon(new ImageIcon("explod9.png"));
				b3.setText("Level 3");
				b3.setHorizontalTextPosition(JButton.CENTER);
				b3.setVerticalTextPosition(JButton.CENTER);
			}

			if(!shooterWon) b4.setIcon(img1);
			if(shooterWon) 
			{
				b4.setIcon(new ImageIcon("explod9.png"));
				b4.setText("Level 4");
				b4.setHorizontalTextPosition(JButton.CENTER);
				b4.setVerticalTextPosition(JButton.CENTER);
			}

			all.add(new ZombieH(), "crd1");
			all.add(new Sedation(), "clicker");
			all.add(new TransportHeart(), "heart1");
			all.add(new TransportBack(), "heart2");
			all.add(new Shooters(), "shooter");
			all.add(new TransP6(), "trans");
			b1.addActionListener(e -> cardLayout.show(all, "crd1"));
			b1.addActionListener(e -> firstMiniEnter = true);
			clicker.addActionListener(e -> cardLayout.show(all, "clicker"));
			//if(hoardWon) b2.addActionListener(e -> cardLayout.show(all, "heart1"));
			if(hoardWon) b2.addActionListener(e -> cardLayout.show(all, "heart1"));
			if(heartWon)
			{
				b3.addActionListener(e -> cardLayout.show(all, "shooter"));
				b3.addActionListener(e -> secondEnter = true);
			}
			if(shooterWon) b4.addActionListener(e -> cardLayout.show(all, "heart2"));
			if(deathCount==6) b1.addActionListener(e -> deathCount = 0);
		}
		
		//check if mouse is pressed
		public void mousePressed (MouseEvent e){}
		//check if mouse is released
		public void mouseReleased (MouseEvent e){}
		//check if mouse is clicked
		public void mouseClicked (MouseEvent e){}
		//check if mouse is entered
		public void mouseEntered (MouseEvent e){} 
		//check if mouse is exited
		public void mouseExited (MouseEvent e){}
		//check if mouse is moved
		public void mouseMoved (MouseEvent e){}
		//check if mouse is dragged
		public void mouseDragged (MouseEvent e){}
		
		
	}
	
	class GameOver extends JPanel
	{
		//the end display screen when defeated
		Image stgBkg;
		JButton home;
		public GameOver()
		{
			//sets layout and calls the method
			setLayout(null);
			stgBkg = new ImageIcon("blk.jpg").getImage();
			runIt();		
		}
		
		public void paintComponent(Graphics g)
		{
			//calling paintComponent so drawing on panels is possible
			super.paintComponent(g);
			g.drawImage(stgBkg, 0, 0, 600, 600, null);
			g.setColor(Color.RED);
			g.setFont(new Font("Retro Gaming", Font.BOLD, 72));
			g.drawString("Defeat", 150, 180);
			g.setFont(retro);
			g.drawString("The zombie entered a healthy and commited", 50, 420);
			g.drawString("relationship with your dismembered foot.", 47, 450);
			Image rip = new ImageIcon("rip.jpg").getImage();
			g.drawImage(rip, 100, 210, 300, 200, null);
			
		}
		
		public void runIt()
		{	
			//adds buttons for returning back to homepage
			home = new JButton("X Quit");
			home.setFont(retro);
			home.setBounds(25, 500, 90, 50);
			add(home);
			
			home.addActionListener(e -> cardLayout.show(all, "link2"));
			home.addActionListener(e -> firstMiniEnter = true);
			//retry.addActionListener(e -> cardLayout.show(all, "crd1"));
			//retry.addActionListener(e -> firstMiniEnter=true);
		}
		
	}
	

	class GameDone extends JPanel
	{
		//the end display screen when defeated
		Image stgBkg;
		JButton home;
		public GameDone()
		{
			//sets layout and calls the method
			//setBackground(Color.WHITE);
			setLayout(null);
			stgBkg = new ImageIcon("ending.jpg").getImage();
			runIt();		
		}
		
		public void paintComponent(Graphics g)
		{
			//calling paintComponent so drawing on panels is possible
			super.paintComponent(g);
			g.drawImage(stgBkg, 0, 0, 600, 600, null);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Retro Gaming", Font.BOLD, 40));
			g.drawString("You made it!", 40, 100);
			g.setFont(new Font("Retro Gaming", Font.BOLD, 20));
			g.drawString("No one should ever go through the apocalypse alone.",20, 250);
			
		}
		
		public void runIt()
		{	
			//adds buttons for returning back to homepage
			home = new JButton("X Quit");
			home.setFont(retro);
			home.setBounds(25, 500, 90, 50);
			add(home);
			
			
			home.addActionListener(e -> cardLayout.show(all, "link2"));
			//home.addActionListener(e -> firstMiniEnter = true);
			//retry.addActionListener(e -> cardLayout.show(all, "crd1"));
			//retry.addActionListener(e -> firstMiniEnter=true);
		}
		
	}

	class GameWon extends JPanel
	{
		//the end display screen when defeated
		Image stgBkg;
		JButton retry;
		private JButton continue1;
		JButton home;
		public GameWon()
		{
			//sets layout and calls the method
			//setBackground(Color.WHITE);
			setLayout(null);
			runIt();		
		}
		
		public void paintComponent(Graphics g)
		{
			//calling paintComponent so drawing on panels is possible
			super.paintComponent(g);
			setBackground(new Color(50, 168, 82));
			g.drawImage(stgBkg, 0, 0, 600, 600, null);
			g.setColor(Color.RED);
			g.setFont(new Font("Retro Gaming", Font.BOLD, 72));
			g.setColor(Color.WHITE);
			g.drawString("Victory", 150, 180);
			g.setFont(retro);
			g.setColor(Color.WHITE);
			g.drawString("Zombie orphans quake at the", 50, 420);
			g.drawString("utterance of your name. ", 60, 450);
			Image img = new ImageIcon("axe2.png").getImage();
			g.drawImage(img, 200, 210, 125, 150, null);
			
		}
		
		public void runIt()
		{	
			//adds buttons for returning back to homepage
			home = new JButton("X Quit");
			continue1 = new JButton("Continue");
			continue1.setFont(retro);
			home.setFont(retro);
			home.setBounds(25, 500, 90, 50);
			continue1.setBounds(350, 500, 125, 50);
			add(continue1);
			add(home);
			
			/*retry = new JButton("Ressurect Thineself!");
			retry.setFont(retro);
			retry.setBounds(450, 500, 150, 50);
			add(retry);
			*/
			
			home.addActionListener(e -> cardLayout.show(all, "link2"));
			home.addActionListener(e -> firstMiniEnter = true);
			
			all.add(new TransP4(), "transp4");
			continue1.addActionListener(e -> cardLayout.show(all, "transp4"));
			//retry.addActionListener(e -> cardLayout.show(all, "crd1"));
			//retry.addActionListener(e -> firstMiniEnter=true);
		}
		
		
		
	}
	
	class Sedation extends JPanel
	{
		//third panel that explains background
		private JButton sedate = new JButton("Sedation");
		private JButton quit = new JButton("Exit");
		private JLabel timeLeft = new JLabel("Time: 0");
		private JLabel sedation = new JLabel("");
		private int sedateCount, time, inter, flash;
		private Timer timer, fTimer;
		private Image hand = new ImageIcon("hand.png").getImage();
		private Image blood = new ImageIcon("blood.png").getImage();
		private boolean noTime = false;
		public Sedation()
		{
			//defining all the variables and starting timers
			runIt();
			setLayout(null);
			setBackground(new Color(102,51,0));
			sedateCount = 0;
			time = 1;
			inter = 0;
			flash = 1;
			ClickTime ct = new ClickTime();
			timer = new Timer(1000, ct);
			
			Flash flsh = new Flash();
			fTimer = new Timer(500, flsh);
		}
		
		public void paintComponent(Graphics g)
		{
			//drawing background, text labels, and buttons
			super.paintComponent(g);
			g.drawImage(hand, 100, 200, 400, 400, null);
			g.drawImage(blood, 250-inter, 380-inter, 100+inter, 100+inter, null);
		}
		
		public void runIt()
		{
			//JPanel pa = new JPanel();
			//pa.setBackground(Color.RED);
			timeLeft.setBackground(Color.YELLOW);
			timeLeft.setForeground(new Color(204, 0, 0));
			timeLeft.setFont(new Font("Retro Gaming" , Font.BOLD, 24));
			timeLeft.setBounds(400, 20, 175, 50);
			ButtonClicker bc = new ButtonClicker();
			sedate.addActionListener(bc);
			
			if(sedateCount == 0) sedate.setText("Click!");
			//if(sedateCount>=80 && time!=10) 
			sedate.setBounds(450, 500, 130, 50);
			sedate.setFont(retro);
			sedation.setFont(new Font("Pixel Gaming", Font.ITALIC, 30));
			sedation.setBounds(75, 150, 500, 50);
			quit.setBounds(10, 500, 100, 50);
			quit.setFont(retro);
			
			add(quit);
			quit.addActionListener(e -> cardLayout.show(all, "link2"));
			quit.addActionListener(e -> firstMiniEnter = true);
			if(time%2!=0) add(sedation);
			add(sedate);
			add(sedation);
			add(timeLeft);
		}
		class ButtonClicker implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if(sedateCount==0) timer.start();
				if(sedateCount<75 && !noTime) sedateCount++;
				sedate.setText("Clicker: " + sedateCount);
				if(sedateCount==75) 
				{
					timer.stop();
					sedateTime+=50;
					sedation.setText("50% more sedation achieved!");
					fTimer.start();
				}
				if(noTime) 
				{
					sedation.setText("No additional sedation");
					fTimer.start();
				}
				if(sedateCount%5==0 && !noTime) inter+=5;
				repaint();
			}
		}
		class ClickTime implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				timeLeft.setText("Time: " + time);
				time++;
				if(time==11)
				{
					if(sedateCount<80) noTime = true;
					timer.stop();
				}
				repaint();
				grabFocus();
			}
		}
		class Flash implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				flash++;
				repaint();
				grabFocus();
			}
		}
				
	}
	
	class TransportHeart extends JPanel implements MouseListener, MouseMotionListener 
	{
		//game where  you drag heart to body
		private int xloc, yloc; 
		private int width, height; 
		private boolean dragging;
		private int xMouse, yMouse; 
		private boolean entered;
		private JButton continue2 = new JButton("Next");
		private JButton quit = new JButton("Quit");
		private Rectangle rect, heart, box;

		public TransportHeart() 
		{
			//defining vars
			box = new Rectangle(20, 300, 170, 130);
			heart = new Rectangle(490, 300, 100, 100);
			xloc = 520;
			yloc = 190;
			dragging = false;
			xMouse = yMouse = 0;
			entered = false;
			heartWon = false;
			addMouseListener(this);
			addMouseMotionListener(this);
			
		}

		public void paintComponent(Graphics g) {
			//drawing on it, focusing on dragging
			super.paintComponent(g); // execute the superclass method first
			width = getWidth();   // width of JPanel
			height = getHeight();  // height of JPanel
			setBackground(Color.white);
			Image tiles = new ImageIcon("tiles.jpg").getImage();
			Image heart = new ImageIcon("heart.png").getImage(); 
			Image body = new ImageIcon("skeleton.png").getImage();
			Image organBox = new ImageIcon("organBox.png").getImage();
			g.drawImage(tiles, 0, 0, 600, 600, null);
			g.drawImage(organBox, 10, 200, 200, 250, null);
			g.drawImage(body, 400, 10, 300, 750, null);
			int yoffset = 0;
			//int yoffset = 24;
			rect = new Rectangle(xloc, yloc+yoffset, 75, 75);
			g.setColor(Color.RED);
			g.setColor(Color.BLUE);
			g.setColor(Color.BLACK);
			
			g.setFont(new Font("Pixel Gaming", Font.PLAIN, 28));
			g.setColor(Color.RED);
			if(!dragging && !heartWon) g.drawString("Drag the heart to the sanitary box", 10, 50);
			if(entered) g.setColor(Color.pink);
			if(!dragging && !(rect.intersects(box))) 
			{
				xloc = 520;
				yloc = 190;
			}
			else g.setColor(Color.black);
	
			if(rect.intersects(box)) 
			{
				g.setColor(Color.GREEN);
				g.drawString("Done!", 10, 50);
				heartWon = true;
				heart = new ImageIcon("flip.png").getImage();
				g.drawImage(heart, 85, 250, 75, 75, null);
				rect = new Rectangle(35, 300, 75, 75);
				continue2.setBounds(500, 500, 100, 50);
				add(continue2);
				all.add(new TransP6(), "p6");
				continue2.addActionListener(e -> cardLayout.show(all, "p6"));			}
			else g.drawImage(heart, xloc, yloc, 75, 75, null);

			quit.setBounds(10, 500, 100, 50);
			quit.addActionListener(e -> cardLayout.show(all, "link2"));
			add(quit);
		} // end paintComponent

		//if mouse is pressed
		public void mousePressed (MouseEvent e) {
			//see if tis getting dragged
			xMouse = e.getX();
			yMouse = e.getY();
			// determine if mouse is pressed inside drawn rectangle
			if (rect.contains(e.getX(), e.getY())) dragging = true;
			repaint();
		}
		//if mouse is released
		public void mouseReleased (MouseEvent e) {
			dragging = false;  // stop dragging
			repaint();
		}
		//if mouse is clicked
		public void mouseClicked (MouseEvent e) {
		}
		//if mouse is entered
		public void mouseEntered (MouseEvent e) { }
		//if mouse is exited
		public void mouseExited (MouseEvent e) {}
		//if mouse is moved
		public void mouseMoved (MouseEvent e)
		{
			repaint();
		}
		//if mouse is dragged
		public void mouseDragged (MouseEvent e) {
			//check if mouse is being dragged
			if(heartWon)
			{
				xloc = xloc;
				yloc = yloc;
			}
			else if (dragging) {
				xloc = xloc + (e.getX() - xMouse);
				yloc = yloc + (e.getY() - yMouse);
				xMouse = e.getX();  // reset mouse to new location
				yMouse = e.getY();
				repaint(); // repaint when dragging
			}
		}
	}

	class TransportBack extends JPanel implements MouseListener, MouseMotionListener 
	{
		//back in the body, coming in from the heart
		private int xloc, yloc; 
		private int width, height; 
		private boolean dragging;
		private int xMouse, yMouse; 
		private boolean entered;
		private JButton continue2 = new JButton("Next");
		private JButton quit = new JButton("Quit");
		private Rectangle rect, heart, box;
		private Image heart1 = new ImageIcon("flip.png").getImage();
		public TransportBack() 
		{
			//defining var
			box = new Rectangle(400, 10, 300, 750);
			heart = new Rectangle(490, 300, 100, 100);
			xloc = 85;
			yloc = 250;
			dragging = false;
			xMouse = yMouse = 0;
			entered = false;
			heartWon = false;
			addMouseListener(this);
			addMouseMotionListener(this);
			
		}

		public void paintComponent(Graphics g) {
			//drawing and showing the drag
			super.paintComponent(g); // execute the superclass method first
			width = getWidth();   // width of JPanel
			height = getHeight();  // height of JPanel
			setBackground(Color.white);
			Image tiles = new ImageIcon("tiles.jpg").getImage();
 
			Image body = new ImageIcon("skeleton.png").getImage();
			Image organBox = new ImageIcon("organBox.png").getImage();
			g.drawImage(tiles, 0, 0, 600, 600, null);
			g.drawImage(organBox, 10, 200, 200, 250, null);
			g.drawImage(body, 400, 10, 300, 750, null);
			int yoffset = 0;
			//int yoffset = 24;
			rect = new Rectangle(xloc, yloc+yoffset, 75, 75);
			g.setColor(Color.RED);
			g.setColor(Color.BLUE);
			g.setColor(Color.BLACK);
			
			g.setFont(new Font("SanSerif", Font.PLAIN, 34));
			g.setColor(Color.RED);
			if(!dragging && !heartWon) g.drawString("Drag the heart to the body", 10, 50);
			if(entered) g.setColor(Color.pink);
			if(!dragging && !(rect.intersects(box))) 
			{
				heart1 = new ImageIcon("flip.png").getImage();
				xloc = 85;
				yloc = 250;
			}
			else g.setColor(Color.black);
	
			if(rect.intersects(box)) 
			{
				g.setColor(Color.GREEN);
				g.drawString("Done!", 10, 50);
				heartWon = true;
				heart1 = new ImageIcon("heart.png").getImage();
				g.drawImage(heart1, 520, 190, 75, 75, null);
				//rect = new Rectangle(35, 300, 75, 75);
				continue2.setBounds(500, 500, 100, 50);
				add(continue2);
				all.add(new GameDone(), "gameDone");
				continue2.addActionListener(e -> cardLayout.show(all, "gameDone"));			}
			else g.drawImage(heart1, xloc, yloc, 75, 75, null);

			quit.setBounds(10, 500, 100, 50);
			quit.addActionListener(e -> cardLayout.show(all, "link2"));
			add(quit);
		} // end paintComponent

		//check if mouse is pressed
		public void mousePressed (MouseEvent e) {
			xMouse = e.getX();
			yMouse = e.getY();
			// determine if mouse is pressed inside drawn rectangle
			heart1 = new ImageIcon("heart.png").getImage();
			if (rect.contains(e.getX(), e.getY())) dragging = true;
			repaint();
		}
		//check if mouse is released
		public void mouseReleased (MouseEvent e) {
			dragging = false;  // stop dragging
			repaint();
		}
		//check if mouse is clicked
		public void mouseClicked (MouseEvent e) {
		}
		//check if mouse is entered
		public void mouseEntered (MouseEvent e) { }
		//check if mouse is exited
		public void mouseExited (MouseEvent e) {}
		//check if  mouse is moved
		public void mouseMoved (MouseEvent e)
		{
			repaint();
		}
		//check if mouse is being dragged
		public void mouseDragged (MouseEvent e) {
			if(heartWon)
			{
				xloc = xloc;
				yloc = yloc;
			}
			else if (dragging) {
				xloc = xloc + (e.getX() - xMouse);
				yloc = yloc + (e.getY() - yMouse);
				xMouse = e.getX();  // reset mouse to new location
				yMouse = e.getY();
				repaint(); // repaint when dragging
			}
		}
	}
	
	class Shooters extends JPanel implements MouseListener, MouseMotionListener
	{
		//the shooter game
		private ArrayList<VirusVar> virus;
		private Rectangle check, box;
		private Rectangle[] bullets;
		private boolean clicked, left, left1, done;
		private Timer vt, moveT, bllt, angleTimer, timerT, dead;
		private int virusCount,countTime, ang, xHoriz, clickCount, spawnHit, boxHealth, count, time;
		private int[] x, y, bX, bY, angle;
		private JButton ultra;
		// vx, vy, vX, vY;
		private Rectangle rect2 = new Rectangle(250, 525, 100, 25);
		private double[] c, slope;
		private Image[] image, bulletImg, virusImg;
		//vc, vslope;
		private int[] virusX, virusY;
		private boolean[] deadVirus, noAppear, bulletHit;
		private boolean gameOver, power;
		public Shooters() 
		{
			//defining the vars and timers
			power = false;
			gameOver = false;
			done = false;
			spawnHit = 0;
			ultra = new JButton("Ultra");
			bullets = new Rectangle[10];
			bulletImg = new Image[10];
			virusImg = new Image[4];
			count = 0;
			time = 0;
			xHoriz = 0;
			left = true;
			left1 = true;
			x = new int[10];
			y = new int[10];
			angle = new int[10];
			c = new double[10];
			slope = new double[10];
			//vx = new int[100];
			//vy = new int[100];
			//vc = new double[100];
			//vslope = new double[100];
			ang = 0;
			countTime = 0;
			clickCount = 0;
			bX = new int[10];
			bY = new int[10];
			image = new Image[10];
			for(int i =0; i<10; i++) image[i] = new ImageIcon("hand.png").getImage();			
			for(int i =0; i<bulletImg.length; i++) bulletImg[i] = new ImageIcon("canon.png").getImage();
			for(int i =0; i<virusImg.length; i++)
			{
				String s = "virus" + (i+1)+ ".png";
				virusImg[i] = new ImageIcon(s).getImage();
				
			}

			//vX = new int[100];
			//vY = new int[100];

			clicked = false;
			check = new Rectangle(0, 0, 0, 0);
			virus = new ArrayList<VirusVar>();
			virusCount = 0;
			deadVirus = new boolean[100];
			noAppear = new boolean[100];
			bulletHit = new boolean[2*bullets.length];
			for(int i =0; i<bulletHit.length; i++) bulletHit[i] = false;
			virusX = new int[100];
			virusY = new int[100];
			for(int i =0; i<100; i++)
			{
				virusX[i] = 0; 
				virusY[i] = 300;
				deadVirus[i] = false;
				//random thing i may need in the future!
				/*virusX[i] = (int)(Math.random()*200+101);
				if(virusX[i]==200 || virusX[i]==300) virusY[i] = (int)(Math.random()*300+51);
				else 
				{
					int choice = (int)(Math.random()*2 + 1);
					if(choice==1) virusY[i] = 300;
					else virusY[i] = 350;
				}
				*/
			}
			VirusAppear va = new VirusAppear();
			vt = new Timer(500,va);
			
			VirusMover vm = new VirusMover();
			moveT = new Timer(50,vm);
		
			MilliTimer tm = new MilliTimer();
			timerT = new Timer(1000,tm);
			
			Dead d1 = new Dead();
			dead = new Timer(1000,d1);
			
			AngleMover am = new AngleMover();
			angleTimer = new Timer(10,am);
			
			BulletMover bm = new BulletMover();
			bllt = new Timer(5,bm);
			
			addMouseListener(this);
			addMouseMotionListener(this);

			
		}

		public void paintComponent(Graphics g) {
			//executing the uper super classes
			super.paintComponent(g); 
			if(secondEnter)
			{
				timerT.start();
				angleTimer.start();
				moveT.start();
				vt.start();
			}

			g.drawImage(new ImageIcon("virusBKG.jpg").getImage(), 0, 0,getWidth(), getHeight(), null);
			Graphics2D g2d = (Graphics2D)g.create();
			g2d.setColor(Color.BLACK);
			ultra.setBounds(10, 500, 100, 100);

			g2d.rotate(Math.toRadians(ang), rect2.x+rect2.width, rect2.y+rect2.height);
			g2d.draw(rect2);
			g2d.fill(rect2);
			//g2d.fill(o1);

			g.setColor(Color.RED);
			g.drawImage(new ImageIcon("canonBottom.png").getImage(),250, 500, 200, 125, null);
			g.setFont(new Font("Pixel Gaming", Font.BOLD, 30));
			g.setColor(Color.WHITE);
			g.drawString("Time: " + timeVirus, 450, 125);
			box = new Rectangle(225, 250, 150, 100);
			if(!done)g.drawImage(new ImageIcon("spawnImg.png").getImage(), 225, 250, 150, 100, null);
			for(int j=0; j<virusCount; j++)
			{
				g.setColor(Color.BLUE);
				if(virus.get(j).alive)check = new Rectangle(virus.get(j).vX, virus.get(j).vY, virus.get(j).width, virus.get(j).height);
				else check = new Rectangle(0,0,0,0);
				if(virus.get(j).alive) g.drawImage(virus.get(j).img, virus.get(j).vX, virus.get(j).vY, virus.get(j).width, virus.get(j).height, null);
				for(int i =0; i<clickCount; i++) 
				{
						g.drawImage(bulletImg[i], bX[i], bY[i], 20, 20, null);
						bullets[i] = new Rectangle(bX[i], bY[i], 20, 20); 
						if(check.intersects(bullets[i])) 
						{
							virus.set(j,new VirusVar((int)(Math.random()*599+1), (int)(Math.random()*599+1), 0, 0, new ImageIcon("explod9.png").getImage(), false));
							bulletHit[i] = true;
							//virus.set(i, new VirusVar(0, 0, 0,0, virusImg[0]));
						}
						if(i==8) if(bullets[i].intersects(box)) done = true;
				}
				
			}
			count = 0;
			for(int i =0; i<bulletHit.length; i++) if(bulletHit[i]) count++;
			if(done)
			{
				//boolean[] lastCheck = new boolean[virusCount];
				int kill = 0;
				for(int i =0; i<virusCount; i++)
				{
					if(!virus.get(i).alive) kill++;
				}
				if(kill==virusCount) 
				{
					timerT.stop();
					gameOver = true;
					shooterWon = true;
				}
			}
			if(gameOver)
			{
				angleTimer.stop();
				moveT.stop();
				vt.stop();
				dead.start();
			}
				
				/*FOR THE SIN GRAPH!!! VERY IMPORTANT
				 * virus.add(i, new Rectangle(virusX[i], virusY[i], 50, 50));
				//else virus.set(i, new Rectangle(virusX[i], virusY[i], 50, 50));
				if(virus.get(i).intersects(r1)) System.out.print("dead");
				//if(i==0) System.out.println(virusY[i]);
				if(deadVirus[i]) g.setColor(Color.RED);
				else g.setColor(Color.BLACK);
				g.fillRect(virusX[i], virusY[i], 50, 50);
				virusY[i] = (int)(75 * Math.sin(Math.toDegrees((double)virusX[i]/1000))+300);
				//if(i==0) System.out.println(virusY[i]);
				*/

		} // end paintComponent
		
		class VirusAppear implements ActionListener
		{
			//making the virusees appear
			public void actionPerformed(ActionEvent e)
			{
				//if(virusCount>virus.size()-1) virusCount = virus.size()-1;
				VirusVar obj = new VirusVar((int)(Math.random()*599+1), (int)(Math.random()*599+1), 300, 300, virusImg[(int)(Math.random()*4)], true);
				virus.add(obj);
				if(!done)virusCount++;
				else virusCount = virusCount;
	
				repaint();
			}
		}

		class Dead implements ActionListener
		{
			//what happens when the user dies
			public void actionPerformed(ActionEvent e)
			{
				all.add(new TransportBack(), "theEnd");
				cardLayout.show(all, "theEnd");
				dead.stop();
				repaint();
			}
		}
		
		class VirusMover implements ActionListener
		{ 
			//moves the viruses
			public void actionPerformed(ActionEvent e)
			{
				for(int i =0; i<virusCount;i++)
				{	
					if(virus.get(i).alive)
					{
						if((virus.get(i).vx==virus.get(i).vX) && (virus.get(i).vy==virus.get(i).vY))
						{
							virus.set(i,new VirusVar((int)(Math.random()*599+1), (int)(Math.random()*599+1), virus.get(i).vX, virus.get(i).vY, virus.get(i).img, true)); 
						}
						
						if(virus.get(i).vx-virus.get(i).vX>0) virus.get(i).vX++;
						else if(virus.get(i).vx-virus.get(i).vX<0) virus.get(i).vX--;
						virus.get(i).vY = (int)((virus.get(i).vslope*virus.get(i).vX) + virus.get(i).vc);
					}
				}
				repaint();
			}
		}

		class MilliTimer implements ActionListener
		{ 
			//the timer
			public void actionPerformed(ActionEvent e)
			{
				timeVirus++;
				repaint();
			}
		}
		
		class VirusVar
		{
			//the class for the array list
			int vx, vy, vX, vY;
			int width, height;
			double vc, vslope;
			Image img;
			boolean alive;

			public VirusVar(int vx1, int vy1, int vX1, int vY1, Image img1, boolean a)
			{
				//diff constructors for diff situations
				width = 50;
				height = 50;
				img = img1;
				vx = vx1;
				vy = vy1;
				vX =vX1;
				vY = vY1;
				alive = a;
				vslope = (double)(vy-vY)/(double)(vx-vX);
				vc = vY- vX*vslope;
			}
			public VirusVar(int vx1, int vy1, int vX1, int vY1)
			{
				//diff construcotrs for diff situations
				vx = vx1;
				vy = vy1;
				vX =vX1;
				vY = vY1;
				vslope = (double)(vy-vY)/(double)(vx-vX);
				vc = vY- vX*vslope;
			}
		}

		class BulletMover implements ActionListener
		{
			//moves the bullet
			public void actionPerformed(ActionEvent e)
			{
					if(clicked)
					{		
						for(int i =0; i<clickCount;i++)
						{
							if(angle[i]<90) bX[i]--;
							if(angle[i]>90) bX[i]++;
							bY[i] = (int)((slope[i]*bX[i]) + c[i]);
						}
						//bX+=changex/4;
						//bY+=changey/4;
					}
					repaint();
			}
		}
		
		
		class AngleMover implements ActionListener
		{
			//this moves the turret
			public void actionPerformed(ActionEvent e)
			{
				//angles for the ball
					if(ang==0) left1 = true;
					if(ang==180) left1 = false;
					
					if(left1) ang++;
					if(!left1) ang--;
					
					repaint();
			}
		}
		
		//if mouse is pressed
		public void mousePressed (MouseEvent e) {}
		//if mouse is released
		public void mouseReleased (MouseEvent e) {}
		//if mouse is clicked
		public void mouseClicked (MouseEvent e) {
				clicked = true;
				noAppear[clickCount] = false;

				angle[clickCount] = ang;
				x[clickCount] = e.getX();
				y[clickCount] = e.getY();
				bX[clickCount] = 350-(int)(100*(Math.cos(Math.toRadians(ang))));
				bY[clickCount] = 550-(int)(100*(Math.sin(Math.toRadians(ang))));
				if(angle[clickCount]<75) bY[clickCount] = 525-(int)(100*(Math.sin(Math.toRadians(ang))));

				slope[clickCount] = Math.tan(Math.toRadians(angle[clickCount]));
				c[clickCount] = bY[clickCount]- bX[clickCount]*slope[clickCount];
				bllt.start();
				
				clickCount++;
	
			if(clickCount ==10) clickCount = 0;
		}
		//if mouse is entered
		public void mouseEntered (MouseEvent e) { }
		//if mouse is exited
		public void mouseExited (MouseEvent e) {}
		//if mouse is moved
		public void mouseMoved (MouseEvent e){}
		//if mouse is dragged
		public void mouseDragged (MouseEvent e){}

    }    
}
	
	