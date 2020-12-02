package model.io;

import model.Game;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * A factory for creating Visualiser objects.
 */
public class VisualiserFactory
{
	
	/**
	 * Creates a new Visualiser object.
	 *
	 * @param n the n
	 * @param g the g
	 * @return the i visualiser
	 */
	public static IVisualiser createVisualiser(String n, Game g)
	{
		
		if(n == "Console")
		{
			VisualiserConsole visualiser = new VisualiserConsole(g);
			return visualiser;
		}
		else if(n == "GIF")
		{
			VisualiserGIF gif = new VisualiserGIF(g);
			return gif;
		}
		
		return null;
	}
	
}