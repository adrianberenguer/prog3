package model.io;

import java.io.IOException;

import model.Board;
import model.Coordinate;
import model.exceptions.CoordinateAlreadyHitException;
import model.exceptions.InvalidCoordinateException;
import model.exceptions.NextToAnotherCraftException;
import model.exceptions.OccupiedCoordinateException;
import model.exceptions.io.BattleshipIOException;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

public interface IPlayer
{
	
	public String getName();
	
	public void putCrafts(Board b) throws BattleshipIOException, InvalidCoordinateException, OccupiedCoordinateException, NextToAnotherCraftException;
	
	public Coordinate nextShoot(Board b) throws InvalidCoordinateException, CoordinateAlreadyHitException, BattleshipIOException;
	
}