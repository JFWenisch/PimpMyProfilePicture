


import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import java.awt.Color;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * @author Jean-Fabian Wenisch
 * @version 1.0 06.12.2010
 */
public class pmpp_Visual extends JMenuBar implements Runnable 
{

	JMenu System_Menü;
	JMenu Bearbeitungs_Menü;
	JMenu Eigenschaften_Menü ;
	JMenu Ansichten_Menü;
	JFileChooser pmppFileChooser;
	protected static int pmpp_w;
	protected static int pmpp_h;
	private static JFrame MainFrame;
	private static pmpp_PicturePanel Picture;
	private static pmpp_OverlayPanel OverlayPanel;
	private static pmpp_OverlayPanel1 OverlayPanel1;
	private static pmpp_OverlayPanel2 OverlayPanel2;
	private static Component OverlayPanel3;

	/**
	 * GUI Mainframe
	 * @author Jean-Fabian Wenisch
	 * @version 1.0 06.12.2010
	 */
	public pmpp_Visual() {
		setOpaque(false);
		System_Menü = new JMenu("Hauptmenü");
		Bearbeitungs_Menü = new JMenu("Bearbeiten");
		Ansichten_Menü = new JMenu ("Ansicht");
		Eigenschaften_Menü = new JMenu("Einstellungen");
		System_Menü.setForeground(Color.WHITE);
		Bearbeitungs_Menü.setForeground(Color.WHITE);
		Ansichten_Menü.setForeground(Color.WHITE);
		Eigenschaften_Menü.setForeground(Color.WHITE);
		pmpp_w =1280;
		pmpp_h=768;
		addComponentListener(new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e)
			{
				System.out.println("JFrame was resized");
				Picture.setSize(pmpp_Visual.getMainFrame().getWidth(),pmpp_Visual.getMainFrame().getHeight());

			}
		});
		ActionListener MenuAction = new ActionListener(  )
		{
			public void actionPerformed(ActionEvent event) 
			{

				if (event.getActionCommand().equals("Bild einfügen"))
				{
					pmpp_Data.importPicture();
				}
				if (event.getActionCommand().equals("Bild ausschneiden"))
				{
					pmpp_PicturePanel.cutImage();
				}
				if (event.getActionCommand().equals("Bild speichern"))
				{
					try 
					{
						pmpp_Data.createPMPPKreation();
					}
					catch (Exception e) 
					{
						try 
						{
							throw new Exception("Es ist ein Fehler beim speichern der Bilder aufgetreten.");
						} 
						catch (Exception e1)
						{	
							e.printStackTrace();
						}
					}
				}
				if (event.getActionCommand().equals("180% drehen"))
				{
					try 
					{
						pmpp_PicturePanel.PictureW        = pmpp_PicturePanel.img.getWidth(null);
						pmpp_PicturePanel.  PictureH            = pmpp_PicturePanel.img.getHeight(null);
						pmpp_PicturePanel.rotateImage(180);
					} 
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
				if (event.getActionCommand().equals("90% im UZS drehen"))
				{
					try 
					{
						pmpp_PicturePanel.PictureW        = pmpp_PicturePanel.img.getWidth(null);
						pmpp_PicturePanel.  PictureH            = pmpp_PicturePanel.img.getHeight(null);
						pmpp_PicturePanel.rotateImage(90);
					} 
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
				if (event.getActionCommand().equals("Hilfe öffnen"))
				{
					pmpp_Data.openHelp();
				}
				if (event.getActionCommand().equals("Panel ausblenden"))
				{
					if(pmpp_PicturePanel.iCount==0)
					{
					MainFrame.remove(OverlayPanel);
					resetPmppSize();
					Picture.setSize(pmpp_w, pmpp_h);
					MainFrame.repaint();
					}
					if(pmpp_PicturePanel.iCount==1)
					{
					MainFrame.remove(OverlayPanel1);
					resetPmppSize();
					Picture.setSize(pmpp_w, pmpp_h);
					MainFrame.repaint();
					}
				}
				if (event.getActionCommand().equals("Panel einblenden"))
				{
					if(pmpp_PicturePanel.iCount==0)
					{
						MainFrame.add(OverlayPanel, BorderLayout.SOUTH);
						OverlayPanel.setVisible(false);
						Picture.repaint();
						MainFrame.repaint();
						OverlayPanel.setVisible(true);
					}
					if(pmpp_PicturePanel.iCount==1)
					{
						MainFrame.add(OverlayPanel1, BorderLayout.SOUTH);
						OverlayPanel1.setVisible(false);
						Picture.repaint();
						MainFrame.repaint();
						OverlayPanel1.setVisible(true);
					}


				}
				if (event.getActionCommand().equals("Schwarzer Hintergrund"))
				{
					pmpp_PicturePanel.BGCCount = 1;
				}
				if (event.getActionCommand().equals("Weißer Hintergrund"))
				{
					pmpp_PicturePanel.BGCCount = 2;
				}
				if (event.getActionCommand().equals("Muster"))
				{
					pmpp_PicturePanel.BGCCount = 0;
				}
			}
		};
		JMenuItem item;

		System_Menü.add(item = new JMenuItem("Bild einfügen"));
		item.addActionListener(MenuAction);
		System_Menü.add(item = new JMenuItem("Bild ausschneiden"));
		item.addActionListener(MenuAction);
		System_Menü.add(item = new JMenuItem("Bild speichern"));
		item.addActionListener(MenuAction);		
		System_Menü.insertSeparator(3);
		System_Menü.add(item = new JMenuItem("Hilfe öffnen"));
		item.addActionListener(MenuAction);
		System_Menü.insertSeparator(5);
		System_Menü.add(item = new JMenuItem("Schließen"));
		item.addActionListener(MenuAction);

		Bearbeitungs_Menü.add(item = new JMenuItem("90% im UZS drehen"));
		item.addActionListener(MenuAction);
		Bearbeitungs_Menü.add(item = new JMenuItem("90% gegen den UZS drehen"));
		item.addActionListener(MenuAction);
		Bearbeitungs_Menü.add(item = new JMenuItem("180% drehen"));
		item.addActionListener(MenuAction);

		Ansichten_Menü.add(item = new JMenuItem("Schwarzer Hintergrund"));
		item.addActionListener(MenuAction);
		Ansichten_Menü.add(item = new JMenuItem("Weißer Hintergrund"));
		item.addActionListener(MenuAction);
		Ansichten_Menü.add(item = new JMenuItem("Muster"));
		item.addActionListener(MenuAction);
		Ansichten_Menü.insertSeparator(3);
		Ansichten_Menü.add(item = new JMenuItem("Panel ausblenden"));
		item.addActionListener(MenuAction);
		Ansichten_Menü.add(item = new JMenuItem("Panel einblenden"));
		item.addActionListener(MenuAction);

		Eigenschaften_Menü.add(item = new JMenuItem("Lizenz"));
		item.addActionListener(MenuAction);
		Eigenschaften_Menü.add(item = new JMenuItem("About"));
		item.addActionListener(MenuAction);
		Eigenschaften_Menü.add(item = new JMenuItem("Facebook Connect"));
		item.addActionListener(MenuAction);

		add(System_Menü);
		add(Bearbeitungs_Menü);
		add(Ansichten_Menü);
		add(Eigenschaften_Menü);
	}

	/**
	 * Inialisiert alle Grafiken
	 * @author Jean-Fabian Wenisch
	 * @version 06.12.2010
	 */
	public static void initComponents()
	{

		Picture= new pmpp_PicturePanel();
		OverlayPanel = new pmpp_OverlayPanel();
		OverlayPanel1 = new pmpp_OverlayPanel1();
		OverlayPanel2 = new pmpp_OverlayPanel2();
		OverlayPanel3 = new pmpp_OverlayPanel3();
		MainFrame = new JFrame("Pimp my ProfilePicture 0.8a     -Freeware-");	    
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.setJMenuBar(new pmpp_Visual(  ));
		MainFrame.setSize(1280, 768);
		MainFrame.setBackground(Color.BLACK);
		MainFrame.setForeground(Color.WHITE);
		MainFrame.add(Picture,BorderLayout.NORTH);
		MainFrame.add(OverlayPanel,BorderLayout.SOUTH);
	}
	public static JFrame getMainFrame()
	{
		return MainFrame;
	}
	public static void main() 
	{
		MainFrame.setVisible(true);
	}
	public static void resetPmppSize()
	{
		pmpp_w=1280;
		pmpp_h=768;
	}
	protected static void setOverlayPanel1()
	{
		MainFrame.remove(OverlayPanel);
		MainFrame.add(OverlayPanel1, BorderLayout.SOUTH);
		OverlayPanel1.setVisible(false);
		Picture.repaint();
		MainFrame.repaint();
		OverlayPanel1.setVisible(true);
	}
	protected static void setOverlayPanel2()
	{
		MainFrame.remove(OverlayPanel1);
		MainFrame.add(OverlayPanel2, BorderLayout.SOUTH);
		OverlayPanel2.setVisible(false);
		Picture.repaint();
		MainFrame.repaint();
		OverlayPanel2.setVisible(true);
	}
	protected static void setOverlayPanel3()
	{
		MainFrame.remove(OverlayPanel2);
		MainFrame.add(OverlayPanel3, BorderLayout.SOUTH);
		OverlayPanel3.setVisible(false);
		Picture.repaint();
		MainFrame.repaint();
		OverlayPanel3.setVisible(true);
	}
	protected static void setOverlayPanel()
	{
		MainFrame.remove(OverlayPanel1);
		MainFrame.remove(OverlayPanel2);
		MainFrame.remove(OverlayPanel3);
		MainFrame.add(OverlayPanel, BorderLayout.SOUTH);	
		OverlayPanel.setVisible(false);
		Picture.repaint();
		MainFrame.repaint();
		OverlayPanel.setVisible(true);
	}
	public void run() 
	{
		main();
	}
}