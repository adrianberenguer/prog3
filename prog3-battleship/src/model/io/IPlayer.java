package model.io;

import java.io.IOException;

import model.Board;
import model.CellStatus;
import model.Coordinate;
import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
import model.exceptions.io.BattleshipIOException;

// TODO: Auto-generated Javadoc
//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

/**
 * The Interface IPlayer.
 */
public interface IPlayer
{
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName();
	
	/**
	 * Gets the last shot status.
	 *
	 * @return the last shot status
	 */
	public CellStatus getLastShotStatus();
	
	/**
	 * Put crafts.
	 *
	 * @param b the b
	 * @throws BattleshipIOException the battleship IO exception
	 * @throws InvalidCoordinateException the invalid coordinate exception
	 * @throws OccupiedCoordinateException the occupied coordinate exception
	 * @throws NextToAnotherCraftException the next to another craft exception
	 */
	public void putCrafts(Board b) throws BattleshipIOException, InvalidCoordinateException, OccupiedCoordinateException, NextToAnotherCraftException;
	
	/**
	 * Next shoot.
	 *
	 * @param b the b
	 * @return the coordinate
	 * @throws InvalidCoordinateException the invalid coordinate exception
	 * @throws CoordinateAlreadyHitException the coordinate already hit exception
	 * @throws BattleshipIOException the battleship IO exception
	 */
	public Coordinate nextShoot(Board b) throws InvalidCoordinateException, CoordinateAlreadyHitException, BattleshipIOException;
	
}