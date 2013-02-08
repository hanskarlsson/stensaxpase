package com.jayway.stensaxpase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hanskarlsson
 * Date: 8/2/2013
 * Time: 16:04
 * To change this template use File | Settings | File Templates.
 */
public class GameCentral {
    private static List<Game> games = new ArrayList<Game>();

    public static synchronized void createGame(Player player, int nbrOfRounds){
        games.add(new Game(player, nbrOfRounds, games.size()));
    }

    public static List<Game> getPlayerGamesInProgress(Player player){
        List<Game> result = new ArrayList<Game>();
        for(Game game:games){
            if((game.getPlayer1() == player || game.getPlayer2() == player) && game.isStarted() && !game.isFinished()){
                result.add(game);
            }
        }
        return result;
    }

    public static List<Game> getAvailableGames(Player player){
        List<Game> result = new ArrayList<Game>();
        for(Game game:games){
            if(game.getPlayer1() != player && game.getPlayer2() != player && !game.isStarted() && !game.isFinished()){
                result.add(game);
            }
        }
        return result;
    }

    public static List<Game> getAllGames(){
        return games;
    }
}
