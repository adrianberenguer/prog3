package model.io;

import java.util.Objects;

import model.Game;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

public class VisualiserConsole implements IVisualiser
{
	private Game game;
	
	public VisualiserConsole(Game g)
	{
		Objects.requireNonNull(g);
		this.game = g;
		
	}
	
	public void show() 
	{
		String cadena = game.toString();
		System.out.println(cadena);
	}

	public void close()
	{
		//no hace nada
	}
	
}