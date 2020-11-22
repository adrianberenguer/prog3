package model.io;

import model.Game;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

public class VisualiserFactory
{
	
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