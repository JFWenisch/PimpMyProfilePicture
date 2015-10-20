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

public class pmpp_OverlayPanel extends JPanel
{
	protected ImageIcon imgPictureImport   = new ImageIcon(getClass().getResource("images/Untitled-3.gif"));	
	protected ImageIcon imgHome   = new ImageIcon(getClass().getResource("images//Untitled-31.gif"));	

	public pmpp_OverlayPanel()
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
		
		JButton bPictureImport = new JButton(imgPictureImport);
		bPictureImport.setBackground(null);
		bPictureImport.setBorder(null);
		bPictureImport.setForeground(null);
		add(bPictureImport);
		bPictureImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				pmpp_Data.importPicture();
				
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
		//Image ImgPanel = getToolkit().getImage(getClass().getResource("images//panel_unten.gif"));
		//g.drawImage(ImgPanel, 0,10, this);
		Font myFont=new Font("Arial", Font.PLAIN, 12);
		g.setFont( myFont );
		g.setColor(Color.WHITE);
		g.drawString("Willkommen zu Pimp my ProfilePicture !", 30, 50);
		g.drawString("--------------------------------------------------------------", 30, 55);
		g.drawString("Um ein neues Profilbild zu Erstellen,", 30, 65);
		g.drawString("klicken Sie bitte auf Bild einfügen und wählen Sie ein Bild zum Bearbeiten aus.", 30, 80);
		
	}
}
