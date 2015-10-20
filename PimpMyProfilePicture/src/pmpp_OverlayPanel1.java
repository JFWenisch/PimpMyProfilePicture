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

public class pmpp_OverlayPanel1 extends JPanel
{
	protected ImageIcon imgPictureCut   = new ImageIcon(getClass().getResource("images//Untitled-33.gif"));	
	protected ImageIcon imgHome   = new ImageIcon(getClass().getResource("images//Untitled-31.gif"));	

	public pmpp_OverlayPanel1()
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
		JButton bPictureCut = new JButton(imgPictureCut);
		bPictureCut.setBackground(null);
		bPictureCut.setBorder(null);
		bPictureCut.setForeground(null);
		add(bPictureCut);
		bPictureCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				pmpp_PicturePanel.cutImage();
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
		g.drawString("Ihr Bild wurde eingefügt !", 30, 50);
		g.drawString("--------------------------------------------------------------", 30, 55);
		g.drawString("Bitte positionieren Sie ihr Bild unter der Schablone,", 30, 65);
		g.drawString("wie es ausgeschnitten werden soll und kicken Sie auf Bild ausschneiden.", 30, 80);

	}
}
