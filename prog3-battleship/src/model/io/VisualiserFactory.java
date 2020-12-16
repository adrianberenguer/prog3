package model.io;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
		Object[] arg2 = new Object[]{g};
		Class<?> pack = null;
		Constructor<?> cons = null;
		
		try
		{
			pack = Class.forName("model.io." + n);
			cons = pack.getConstructor(new Class<?> [] {Game.class});
			return (IVisualiser)cons.newInstance(arg2);
		}
		catch(ClassNotFoundException | SecurityException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoClassDefFoundError | InstantiationException | IllegalArgumentException e)
		{
			return null;
		}
		
	}
	
}

/*
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
*/