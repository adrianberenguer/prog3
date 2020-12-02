package model.io;

import java.awt.Color;
import java.io.File;
import java.util.Objects;

import model.Board;
import model.Game;
import model.exceptions.io.BattleshipIOException;
import model.io.gif.AnimatedGIF;
import model.io.gif.FrameGIF;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class VisualiserGIF.
 */
public class VisualiserGIF implements IVisualiser
{
	
	/** The agif. */
	private AnimatedGIF agif;
	
	/** The game. */
	private Game game;
	
	/**
	 * Instantiates a new visualiser GIF.
	 *
	 * @param g the g
	 */
	public VisualiserGIF(Game g)
	{
		Objects.requireNonNull(g);
		this.game = g;
		this.agif = new AnimatedGIF();
	}
	
	/**
	 * Show.
	 */
	public void show()  
	{
		Board b1 = null,b2 = null;
		String sB1,sB2;
		
		b1 = game.getBoard1();
		b2 = game.getBoard2();
		sB1 = b1.show(false);
		sB2 = b2.show(false);
		
		String sB11[] = sB1.split("");
		String sB22[] = sB2.split("");
		int i = 0;
		int j = 0;
		
		try
		{
			FrameGIF frame = null;
			
			if(b1.getClass().getName() == "model.aircraft.Board3D") //board3d	
			{	
				int w = b1.getSize() * b1.getSize() + b1.getSize() -1;
				int h = b1.getSize() *2 +1;
				frame = new FrameGIF(w, h);
				int column=0,row=0;
				
				for(int x=0;x<w;x++) //for the black line in the mid
				{
					frame.printSquare(x, b1.getSize(), Color.DARK_GRAY);
				}
				
				for(i=0; i<sB11.length;i++) //for the board1
				{	
					if(sB11[i].charAt(0) == Board.NOTSEEN_SYMBOL)
					{
						frame.printSquare(column, row, Color.LIGHT_GRAY);
						column++;
					}
					else if(sB11[i].charAt(0) == Board.WATER_SYMBOL)
					{
						frame.printSquare(column, row, Color.BLUE);
						column++;
					}
					else if(sB11[i].charAt(0) == '|')
					{
						frame.printSquare(column, row, Color.ORANGE);
						column++;
					}
					else if(sB11[i].charAt(0) == '\n')
					{
						row++;
						column=0;
					}
					else {
						frame.printSquare(column, row, Color.RED);
						column++;
					}
					
				}
				
				column = 0;
				row = b1.getSize()+1;
				
				for(j=0;j<sB22.length;j++) //for the board2
				{
					if(sB22[j].charAt(0) == Board.NOTSEEN_SYMBOL)
					{
						frame.printSquare(column, row, Color.LIGHT_GRAY);
						column++;
					}
					else if(sB22[j].charAt(0) == Board.WATER_SYMBOL)
					{
						frame.printSquare(column, row, Color.BLUE);
						column++;
					}
					else if(sB22[j].charAt(0) == '|')
					{
						frame.printSquare(column, row, Color.ORANGE);
						column++;
					}
					else if(sB22[j].charAt(0) == '\n')
					{
						row++;
						column=0;
					}
					else {
						frame.printSquare(column, row, Color.RED);
						column++;
					}
					
				}
			}	
			else  //board 2d
			{
				int w = b1.getSize();
				int h = b1.getSize() *2 +1;
				frame = new FrameGIF(w, h);
				int column=0,row =0;
				
				for(int x=0;x<w;x++) //for the black line in the mid
				{
					frame.printSquare(x, b1.getSize(), Color.DARK_GRAY);
				}
				
				for(i=0;i<sB11.length;i++) //for the board1
				{
					if(sB11[i].charAt(0) == Board.NOTSEEN_SYMBOL)
					{
						frame.printSquare(column, row, Color.LIGHT_GRAY);
						column++;
					}
					else if(sB11[i].charAt(0) == Board.WATER_SYMBOL)
					{
						frame.printSquare(column, row, Color.BLUE);
						column++;
					}
					else if(sB11[i].charAt(0) == '|')
					{
						frame.printSquare(column, row, Color.ORANGE);
						column++;
					}
					else if(sB11[i].charAt(0) == '\n')
					{
						row++;
						column=0;
					}
					else {
						frame.printSquare(column, row, Color.RED);
						column++;
					}
					
				}
				
				column = 0;
				row = b1.getSize()+1;
				
				for(j=0;j<sB22.length;j++) // for the board2
				{
					if(sB22[j].charAt(0) == Board.NOTSEEN_SYMBOL)
					{
						frame.printSquare(column, row, Color.LIGHT_GRAY);
						column++;
					}
					else if(sB22[j].charAt(0) == Board.WATER_SYMBOL)
					{
						frame.printSquare(column, row, Color.BLUE);
						column++;
					}
					else if(sB22[j].charAt(0) == '|')
					{
						frame.printSquare(column, row, Color.ORANGE);
						column++;
					}
					else if(sB22[j].charAt(0) == '\n')
					{
						row++;
						column=0;
					}
					else {
						frame.printSquare(column, row, Color.RED);
						column++;
					}
				}
			}
				
			agif.addFrame(frame);
			
		}
		catch(BattleshipIOException e)
		{
			throw new RuntimeException();
		}
		
	}

	/**
	 * Close.
	 */
	public void close()  
	{	
		try
		{
			agif.saveFile(new File("files/output.gif"));
		}
		catch(BattleshipIOException e)
		{
			throw new RuntimeException();
		}
		
	}
	
}