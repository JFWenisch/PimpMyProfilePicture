import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 
 * @author Jean-Fabian Wenisch
 * @version 1.0 31.12.2010
 */
public class pmpp_PicturePanel extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3542762664237896171L;
	protected static String PicturePath = "";
	private static int PictureX = 0;
	private static int PictureY = 0;
	protected static int PictureW = 0;
	protected static int PictureH = 0;

	protected static int iCount = 0;
	protected static int BGCCount = 0;
	protected static Image img;
	protected static Image pmpp01;	
	protected static Image pmpp02;	
	protected static Image pmpp03;
	protected static Image pmpp04;
	protected static Image pmpp05;
	protected static Image pmpp06;

	public pmpp_PicturePanel() 
	{

		setSize(800, 740);

		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				movePicture(e.getX(),e.getY());
			}});
		addMouseMotionListener(new MouseAdapter() 
		{
			public void mouseDragged(MouseEvent e) 
			{
				movePicture(e.getX(),e.getY());
			}
		});
	}

	protected void movePicture(int x, int y) 
	{
		if ((PictureX!=x) || (PictureY!=y))
		{
			PictureX=x;
			PictureY=y;
			repaint();
		} 
	}
	/**
	 * @author Jean-Fabian Wenisch
	 * @version 1.0 31.12.2010
	 */
	protected static void cutImage()
	{
		int pmpp01x , pmpp02x ,pmpp01y,pmpp02y;
		BufferedImage src  = new BufferedImage(PictureW, PictureH, BufferedImage.TYPE_INT_RGB);
		src.getGraphics().drawImage(img, 0, 0, null); 

		pmpp01x = (PictureX+(140-PictureX))-(PictureX-(PictureW/2));
		pmpp01y = (PictureY+(178-PictureY))-(PictureY-(PictureH/2)+90);
		pmpp02x=pmpp01x+198;
		pmpp02y=pmpp01y+85;

		pmpp01	= src.getSubimage(pmpp01x, pmpp01y, 185,400); 
		pmpp02	= src.getSubimage(pmpp02x, pmpp02y, 100, 70);
		pmpp03	= src.getSubimage(pmpp02x+100, pmpp02y,100, 70);
		pmpp04	= src.getSubimage(pmpp02x+200, pmpp02y, 100, 70);
		pmpp05	= src.getSubimage(pmpp02x+300, pmpp02y,100, 70);
		pmpp06	= src.getSubimage(pmpp02x+400, pmpp02y, 100, 70);
		pmpp_Visual.setOverlayPanel2();
		pmpp_PicturePanel.iCount = 2;
	}
	/**
	 * 
	 * @param <degrees> die Übergebene Gradzahl
	 * @return
	 * @throws IOException
	 * @version 1.0 20.12.2010
	 */
	protected static BufferedImage rotateImage( double degrees) throws IOException 
	{ 	   
		BufferedImage src  = new BufferedImage(PictureW, PictureH, BufferedImage.TYPE_INT_RGB);
		src.getGraphics().drawImage(img, 0, 0, null); 
		AffineTransform affineTransform = AffineTransform.getRotateInstance(
				Math.toRadians(degrees),PictureW/2,	PictureH/2);
		if (degrees == 90)	
		{

			BufferedImage rotatedImage = new BufferedImage(PictureW, PictureH, src.getType());
			Graphics2D g = (Graphics2D) rotatedImage.getGraphics();
			g.setTransform(affineTransform);
			g.drawImage(src,0,0, null);
			img = rotatedImage;
		}
		if (degrees == 270)	
		{
			BufferedImage rotatedImage = new BufferedImage(PictureH, PictureW, src.getType());
			Graphics2D g = (Graphics2D) rotatedImage.getGraphics();
			g.setTransform(affineTransform);
			g.drawImage(src,0,0, null);
			img = rotatedImage;
		}
		else
		{
			BufferedImage rotatedImage = new BufferedImage(PictureW, PictureH, src.getType());
			Graphics2D g = (Graphics2D) rotatedImage.getGraphics();
			g.setTransform(affineTransform);
			g.drawImage(src,0,0, null);
			img = rotatedImage;
		}
		return src;
	} 
	protected static BufferedImage getBufferedImage(Image PMPP)
	{
		BufferedImage src  = new BufferedImage(PMPP.getWidth(null), PMPP.getHeight(null), BufferedImage.TYPE_INT_RGB);
		src.getGraphics().drawImage(PMPP, 0, 0, null); 
		return src;
	}
	public Dimension getPreferredSize()
	{
		return new Dimension(1280, 600);
	}
	public void paintComponent(Graphics g)
	{
	}
	public void paint(Graphics g){
		super.paintComponent(g);   

		if ( iCount <2)
		{
			if ( BGCCount == 0)
			{
				Image ImgMuster = getToolkit().getImage(getClass().getResource("images//23768hjkda56rfjhkkdlsai9654ertjk.jpg"));
				g.drawImage(ImgMuster, 0,-60, this);
			}
			if ( BGCCount == 1)
			{
				setBackground(Color.BLACK);
			}
			if ( BGCCount == 2)
			{
				setBackground(Color.WHITE);
			}

			if ( iCount == 1)
			{
				g.drawImage(img, PictureX-(img.getWidth(this)/2), PictureY-(img.getHeight(this)/2), this);
			}
			Image ImgSchablone = getToolkit().getImage(getClass().getResource("images//1qay4rfv6zhn8iklmzhbdnhjnkasdjhadhaiui.gif"));
			g.drawImage(ImgSchablone, 0,-90, this);
			Font myFont=new Font("Arial", Font.BOLD, 23);
			g.setFont( myFont );
			g.setColor(Color.black);
			g.drawString(System.getProperty("user.name"), 340, 112);
		}
		if ( iCount ==2)
		{
			g.drawImage(pmpp01,200,10,this);
			g.drawImage(pmpp02,408,98,this);
			g.drawImage(pmpp03,518,98,this);
			g.drawImage(pmpp04,628,98,this);
			g.drawImage(pmpp05,738,98,this);
			g.drawImage(pmpp06,848,98,this);
		}
		if ( iCount ==3)
		{
			Image ImgUpload = getToolkit().getImage(getClass().getResource("images//import.gif"));
			g.drawImage(ImgUpload, 0,-90, this);
			
		}
		
		repaint();
	}
	
}
