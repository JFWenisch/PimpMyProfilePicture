import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class pmpp_OverlayPanel2 extends JPanel
{
	protected ImageIcon imgPictureSave   = new ImageIcon(getClass().getResource("images//Untitled-32.gif"));	
	protected ImageIcon imgHome   = new ImageIcon(getClass().getResource("images//Untitled-31.gif"));	

	public pmpp_OverlayPanel2()
	{
		setSize(1280, 120);
		setBackground(Color.BLACK);	
		setOpaque(true);
		GridLayout oLayout = new GridLayout(1,10);
		oLayout.setVgap(20);
		setLayout(oLayout);
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		JButton bPictureSave = new JButton(imgPictureSave);
		bPictureSave.setBackground(null);
		bPictureSave.setBorder(null);
		bPictureSave.setForeground(null);
		add(bPictureSave);
		bPictureSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					pmpp_Data.createPMPPKreation();
				} 
				catch (Exception e1) 
				{
					try
					{
						throw new Exception("Bitte positionieren Sie das Bild so, dass keine freien Pixel mehr unter der Maske sind.");
					} 
					catch (Exception e2) 
					{
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
				pmpp_Data.getFinish();

			}
		});
		JButton bHome = new JButton(imgHome);
		bHome.setBackground(null);
		bHome.setBorder(null);
		bHome.setForeground(null);
		add(bHome);
		bHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				pmpp_Data.getHome();
			}
		});



	}
	public Component add(Component c) {
		super.add(c);
		validate();
		return c;
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(1280, 120);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); 
		Font myFont=new Font("Arial", Font.PLAIN, 12);
		g.setFont( myFont );
		g.setColor(Color.WHITE);
		g.drawString("Ihr Ausschnitt wurde erstellt !", 30, 50);
		g.drawString("--------------------------------------------------------------", 30, 55);
		g.drawString("Wenn Sie mit dem  Profilbild zufrieden sind,", 30, 65);
		g.drawString("klicken Sie auf Bild speichern und ihr Profilbild wird unter", 30, 80);
		g.drawString(pmpp_Data.strHomeDir+" gespeichert.", 30, 95);
	}
}
