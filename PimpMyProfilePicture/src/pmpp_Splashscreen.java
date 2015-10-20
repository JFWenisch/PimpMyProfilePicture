import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.swing.JFrame;

public class pmpp_Splashscreen extends JFrame implements Runnable

{







	/**
	 * @author Jean-Fabian Wenisch
	 * @version 1.0 	25.12.2010
	 */




	public void run()
	{

		setSize(550, 200);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);



		try 
		{
			Thread.sleep(10000);
			pmpp_Visual.initComponents();
		}
		catch (InterruptedException e)
		{
			dispose();
		}
		finally	
		{
			dispose();
		}




		Thread MAIN = new Thread(new pmpp_Visual());
		MAIN.start();
		dispose();

	}

	public void paint(Graphics g)
	{
		
		Font myFont=new Font("Arial", Font.PLAIN, 10);
		g.setFont( myFont );
		g.setColor(Color.black);
		g.drawRect(getWidth()/2, getHeight()/2, 600, 400);
		g.fillRect(0,0, 600, 400);
		g.setColor(Color.WHITE);
		Image sImage = getToolkit().getImage(getClass().getResource("images//logo.gif")); 
		g.drawImage(sImage, 380,90, this);
		g.drawString("Willkommen "+System.getProperty("user.name")+ " !", getWidth()/2-150, getHeight()/2);
		Font myFont1=new Font("Arial", Font.PLAIN, 23);
		g.setFont( myFont1 );
		g.setColor(Color.WHITE);
		g.drawString("PimpMyProfilePicture", getWidth()/2-150, getHeight()/2-50);
	}
}

