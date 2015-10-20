import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 * 
 * @author Jean-Fabian Wenisch
 *
 */
public class pmpp_Data 
{
	protected static String strHomeDir = System.getProperty("user.home");
	private static File PMPPDir=new File(strHomeDir+"\\"+"PMPP");


	private static String getDateStamp()
	{
		Date dt = new Date();
		DateFormat fmt = new SimpleDateFormat("yyyyhhmmssz" );
		return fmt.format(dt).toString();
	}
	protected static boolean checkPMPPDir()
	{
		if(PMPPDir.isDirectory())
			return true;
		else 
			return false;
	}
	protected static void createPMPPDir()
	{
		File PMPPDir = 	new File(strHomeDir+"\\"+"PMPP");
		PMPPDir.mkdir();
	}
	protected static void createPMPPKreation() throws Exception
	{

		if(checkPMPPDir())
		{
			File PMPPKReationFolder = new File(strHomeDir+"\\PMPP\\"+"PMPP"+getDateStamp());
			PMPPKReationFolder.mkdir();	
			   try 
			   {
		            BufferedImage image  = pmpp_PicturePanel.getBufferedImage(pmpp_PicturePanel.pmpp01);
		            ImageIO.write( image, "jpg", new File( strHomeDir+"\\PMPP\\"+"PMPP"+getDateStamp()+"\\"+"PimpMyProfilePicture06.jpg"));
		 
		         image  = pmpp_PicturePanel.getBufferedImage(pmpp_PicturePanel.pmpp02);
		            ImageIO.write( image, "jpg", new File( strHomeDir+"\\PMPP\\"+"PMPP"+getDateStamp()+"\\"+"PimpMyProfilePicture05.jpg"));
		 
		         image  = pmpp_PicturePanel.getBufferedImage(pmpp_PicturePanel.pmpp03);
		            ImageIO.write( image, "jpg", new File( strHomeDir+"\\PMPP\\"+"PMPP"+getDateStamp()+"\\"+"PimpMyProfilePicture04.jpg"));
		 
		            image  = pmpp_PicturePanel.getBufferedImage(pmpp_PicturePanel.pmpp04);
		            ImageIO.write( image, "jpg", new File( strHomeDir+"\\PMPP\\"+"PMPP"+getDateStamp()+"\\"+"PimpMyProfilePicture03.jpg"));
		 
		            image  = pmpp_PicturePanel.getBufferedImage(pmpp_PicturePanel.pmpp05);
		            ImageIO.write( image, "jpg", new File( strHomeDir+"\\PMPP\\"+"PMPP"+getDateStamp()+"\\"+"PimpMyProfilePicture02.jpg"));
		 
		            image  = pmpp_PicturePanel.getBufferedImage(pmpp_PicturePanel.pmpp06);
		            ImageIO.write( image, "jpg", new File( strHomeDir+"\\PMPP\\"+"PMPP"+getDateStamp()+"\\"+"PimpMyProfilePicture01.jpg"));
		 
		        }
			   catch( IOException ex)
			   {
		            throw new Exception("Es ist ein Fehler beim speichern der Bilder aufgetretetn.");
		        }       

		}
		else
		{
			createPMPPDir();
			createPMPPKreation();

		}
	}
	
		protected static void importPicture()
		{
			JFileChooser pmppFileChooser = new JFileChooser();
			int state = pmppFileChooser.showOpenDialog( null );
			if ( state == JFileChooser.APPROVE_OPTION )
			{
				File file = pmppFileChooser.getSelectedFile();
				try 
				{
					pmpp_PicturePanel.img=ImageIO.read(new File(file.getPath()));
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				pmpp_PicturePanel.PicturePath=file.getPath();
				pmpp_PicturePanel.iCount = 1;
				pmpp_PicturePanel.PictureW   = pmpp_PicturePanel.img.getWidth(null);
				pmpp_PicturePanel.PictureH   = pmpp_PicturePanel.img.getHeight(null);
				pmpp_Visual.setOverlayPanel1();
				
			}
			else
				System.out.println( "Auswahl abgebrochen" );
	}
		protected static void openHelp()
		{
			final String url = "www.nirako.de" ;;		
			try
			{
				Runtime.getRuntime().exec( "rundll32 url.dll,FileProtocolHandler " + url );
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		
		}
		
		protected static void getHome()
		{
			pmpp_PicturePanel.iCount=0;
			pmpp_Visual.setOverlayPanel();
		}
		protected static void getFinish()
		{
			pmpp_PicturePanel.iCount=3;
			pmpp_Visual.setOverlayPanel3();
		}
}
