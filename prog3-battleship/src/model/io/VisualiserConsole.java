package model.io;

import java.util.Objects;

import model.Game;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class VisualiserConsole.
 */
public class VisualiserConsole implements IVisualiser
{
	
	/** The game. */
	private Game game;
	
	/**
	 * Instantiates a new visualiser console.
	 *
	 * @param g the g
	 */
	public VisualiserConsole(Game g)
	{
		Objects.requireNonNull(g);
		this.game = g;
		
	}
	
	/**
	 * Show.
	 */
	public void show() 
	{
		String cadena = game.toString();
		System.out.println(cadena);
	}

	/**
	 * Close.
	 */
	public void close()
	{
		//no hace nada
	}
	
}