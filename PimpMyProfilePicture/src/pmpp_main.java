
public class pmpp_main 
{

	/**
	 * Pimp my Profile Picture
	 * 
	 * @author Jean-Fabian Wenisch
	 * @version 1.0 25.10.2010
	 */
	public static void main(String[] args) 
	{
		 Thread Splashscreen = new Thread(new pmpp_Splashscreen());
	        Splashscreen.start();
	}
}
