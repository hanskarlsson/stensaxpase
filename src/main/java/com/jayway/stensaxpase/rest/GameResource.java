package com.jayway.stensaxpase.rest;

import com.jayway.stensaxpase.Game;
import com.jayway.stensaxpase.GameCentral;
import com.jayway.stensaxpase.Player;
import com.jayway.stensaxpase.Round;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hanskarlsson
 * Date: 8/2/2013
 * Time: 16:22
 * To change this template use File | Settings | File Templates.
 */

@Path("/games")
@Component
public class GameResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Game> getAllGames(){
        System.out.println("getAllGames");
        return GameCentral.getAllGames();
    }

    @GET
    @Path("player")
    @Produces(MediaType.APPLICATION_JSON)
    public Player getPlayer(){
        return new Player("foo");
    }

    @POST
    @Path("{gameId}/join")
    @Produces(MediaType.APPLICATION_JSON)
    public void joinGame(@PathParam("gameId") int gameId, @FormParam("email") String email){
          GameCentral.getAllGames().get(gameId).setOpponent(new Player(email));
    }

    @POST
    @Path("{gameId}/play")
    @Produces(MediaType.APPLICATION_JSON)
    public void makeChoice(@PathParam("gameId") int gameId,  @FormParam("email") String email,  @FormParam("choice") Round.Choice choice){
        System.out.println("choice: " + choice.name());
        GameCentral.getAllGames().get(gameId).makeChoice(new Player(email), choice);
    }

    @GET
    @Path("{gameId}/winner")
    @Produces(MediaType.APPLICATION_JSON)
    public Player getWinner(@PathParam("gameId") int gameId){
        Game game = GameCentral.getAllGames().get(gameId);
        if(game.isFinished()){
            Game.Result result = game.getResult();
            if(result == Game.Result.WON){
                return game.getPlayer1();
            } else if(result == Game.Result.LOST){
                return game.getPlayer2();
            }  else return null;

        } else {
            throw new RuntimeException();
        }

    }


    @POST
    @Path("game")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_XML)
    public String createGame(@FormParam("email") String email, @FormParam("nbrOfRounds") int nbrOfRounds){
        System.out.println("email: " + email);
        GameCentral.createGame(new Player(email), nbrOfRounds);
        return "hej";
    }
}
