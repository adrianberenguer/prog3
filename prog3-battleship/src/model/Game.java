package model;

import java.io.IOException;
import java.util.Objects;

import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
import model.exceptions.io.BattleshipIOException;
import model.io.IPlayer;
import model.io.IVisualiser;
import model.score.CraftScore;
import model.score.HitScore;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Class Game.
 */
public class Game
{
	
	/** The hit score 1. */
	private HitScore hitScore1;
	
	/** The hit score 2. */
	private HitScore hitScore2;
	
	/** The craft score 1. */
	private CraftScore craftScore1;
	
	/** The craft score 2. */
	private CraftScore craftScore2;
	
	/** The game started. */
	private boolean gameStarted;
	
	/** The next to shoot. */
	private int nextToShoot;
	
	/** The shoot counter. */
	private int shootCounter;
	
	/** The player 2. */
	private IPlayer player1, player2;
	
	/** The board 2. */
	private Board board1, board2;
	
	/**
	 * Instantiates a new game.
	 *
	 * @param b1 the b 1
	 * @param b2 the b 2
	 * @param p1 the p 1
	 * @param p2 the p 2
	 */
	public Game(Board b1, Board b2, IPlayer p1, IPlayer p2)
	{
		Objects.requireNonNull(p1);
		Objects.requireNonNull(p2);
		Objects.requireNonNull(b1);
		Objects.requireNonNull(b2);
		player1 = p1;
		player2 = p2;
		board1 = b1;
		board2 = b2;
		gameStarted = false;
		
		hitScore1 = new HitScore(p1);
		hitScore2 = new HitScore(p2);
		craftScore1 = new CraftScore(p1);
		craftScore2 = new CraftScore(p2);
	}
	
	/**
	 * Gets the score info.
	 *
	 * @return the score info
	 */
	@SuppressWarnings("null")
	public String getScoreInfo()
	{
		StringBuilder info = new StringBuilder();
		
		info.append("Player 1\n" + "HitScore: " /*+ player1.getName() + ": "*/ + hitScore1 + '\n');
		info.append("CraftScore: " /*+ player1.getName() + ": "*/ + craftScore1 + '\n');
		info.append("--------------\n");
		info.append("Player 2\n" + "HitScore: " /*+ player2.getName() + ": "*/ + hitScore2 + '\n');
		info.append("CraftScore: " /*+ player2.getName() + ": "*/ + craftScore2 );
		
		return info.toString();
	}
	
	/**
	 * Gets the hit score player 1.
	 *
	 * @return the hit score player 1
	 */
	public HitScore getHitScorePlayer1()
	{
		return hitScore1;
	}
	
	/**
	 * Gets the hit score player 2.
	 *
	 * @return the hit score player 2
	 */
	public HitScore getHitScorePlayer2()
	{
		return hitScore2;
	}
	
	/**
	 * Gets the craft score player 1.
	 *
	 * @return the craft score player 1
	 */
	public CraftScore getCraftScorePlayer1()
	{
		return craftScore1;
	}
	
	/**
	 * Gets the craft score player 2.
	 *
	 * @return the craft score player 2
	 */
	public CraftScore getCraftScorePlayer2()
	{
		return craftScore2;
	}
	
	/**
	 * Gets the player 1.
	 *
	 * @return the player 1
	 */
	public IPlayer getPlayer1()
	{
		return player1;
	}
	
	/**
	 * Gets the player 2.
	 *
	 * @return the player 2
	 */
	public IPlayer getPlayer2()
	{
		return player2;
	}
	
	/**
	 * Gets the player last shoot.
	 *
	 * @return the player last shoot
	 */
	public IPlayer getPlayerLastShoot()
	{
		if(shootCounter >0)
		{
			if(nextToShoot == 1)
			{
				return player2;
			}
			if(nextToShoot == 2)
			{
				return player1;
			}
		}
		else
		{
			return null;
		}
		
		return null;
	}
	
	/**
	 * Gets the board 1.
	 *
	 * @return the board 1
	 */
	public Board getBoard1()
	{
		return board1;
	}
	
	/**
	 * Gets the board 2.
	 *
	 * @return the board 2
	 */
	public Board getBoard2()
	{
		return board2;
	}
	
	/**
	 * Start.
	 */
	public void start() 
	{
		
		gameStarted = true;
		shootCounter = 0;
		nextToShoot = 1;
		try
		{
			player1.putCrafts(board1);
			player2.putCrafts(board2);
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
		
	}
	
	/**
	 * Game ended.
	 *
	 * @return true, if successful
	 */
	public boolean gameEnded()
	{
		
		if(gameStarted)
		{
			if(board1.areAllCraftsDestroyed())
			{
				return true;
			}
			if(board2.areAllCraftsDestroyed())
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Play next.
	 *
	 * @return true, if successful
	 */
	public boolean playNext() 
	{
		
	
			if(nextToShoot == 1)
			{
				try {
					Coordinate c = player1.nextShoot(board2);		
					if (c != null) 
					{
						hitScore1.score(player1.getLastShotStatus());
						if(player1.getLastShotStatus() == CellStatus.DESTROYED)
						{
							craftScore1.score(board2.getCraft(c));						
						}
						nextToShoot = 2;
						shootCounter++;
						return true;
					}
				} 
				catch (InvalidCoordinateException | BattleshipIOException e) 
				{
					throw new RuntimeException();
				} 
				catch (CoordinateAlreadyHitException e) 
				{
					nextToShoot = 2;
					shootCounter++;
					System.out.print("Action by "+ player1.getName() + e.getMessage() );
					return true;
				}
			}
			if(nextToShoot == 2)
			{
				try {
					Coordinate c1 = player2.nextShoot(board1);
					if (c1 != null) 
					{
						hitScore2.score(player2.getLastShotStatus());
						if(player2.getLastShotStatus() == CellStatus.DESTROYED)
						{
							craftScore2.score(board1.getCraft(c1));						
						}
						
						nextToShoot = 1;
						shootCounter++;
						return true;
					}
				} 
				catch (InvalidCoordinateException | BattleshipIOException e) 
				{
					throw new RuntimeException();
				} 
				catch (CoordinateAlreadyHitException e) 
				{
					nextToShoot = 1;
					shootCounter++;
					System.out.print("Action by "+ player2.getName() + e.getMessage() );
					return true;
				}
			}
			
		
		return false;
	}
	
	/**
	 * Play game.
	 *
	 * @param visualiser the visualiser
	 */
	public void playGame(IVisualiser visualiser)  
	{
		
		start();
		visualiser.show();
		
		while(!gameEnded())
		{
			if(playNext())
			{
				visualiser.show();
			}
			else
			{
				visualiser.close();
				return ;
			}
		}
		visualiser.close();
		
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString()
	{
		StringBuilder partida = new StringBuilder();
		
		if(gameEnded())
		{
			partida.append("=== GAME ENDED ===");
		}
		
		else if(gameStarted)
		{
			partida.append("=== ONGOING GAME ===");
		}

		else if(!gameStarted)
		{
			partida.append("=== GAME NOT STARTED ===");
		}
		partida.append("\n==================================\n");
		partida.append(player1.getName()  + '\n');
		partida.append("==================================" + '\n');
		
		partida.append(board1.show(false));
		
		partida.append("\n==================================\n");
		partida.append(player2.getName() + '\n');
		partida.append("==================================" + '\n');
		
		partida.append(board2.show(false));
		
		partida.append("\n"+"==================================" + '\n');
		
		partida.append("Number of shots: " + shootCounter);
		
		if(gameEnded())
		{
			if(board1.areAllCraftsDestroyed())
			{
				partida.append("\n"+player2.getName() + " wins");
			}
			else
			{
				partida.append("\n"+player1.getName() + " wins");
			}
			
		}
		
		return partida.toString();
	}
	
}