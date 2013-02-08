package com.jayway.stensaxpase;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hanskarlsson
 * Date: 8/2/2013
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement
public class Game {
    @XmlElement
    private final int id;

    public enum Result {WON, LOST, TIED}

    private Player player1;
    private Player player2;
    private boolean isStarted = false;
    private boolean isFinished = false;

    private int currentRound = 0;

    List<Round> rounds;

    public Game(Player player1, int nbrOfRounds, int id) {
        this.player1 = player1;
        this.id = id;

        rounds = new ArrayList<Round>(3);
        for (int i = 0; i < nbrOfRounds; i++) {
            rounds.add(new Round());
        }
    }

    public void setOpponent(Player player2) {
        this.player2 = player2;
        isStarted = true;
    }

    public void makeChoice(Player player, Round.Choice choice) {
        if (isStarted && !isFinished) {
            Round round = rounds.get(currentRound);
            if (player.getEmail().equals(player1.getEmail()) && round.getPlayer1Choice() == null) {
                round.setPlayer1Choice(choice);
            } else if (player.getEmail().equals(player2.getEmail()) && round.getPlayer2Choice() == null) {
                round.setPlayer2Choice(choice);
            }
            if (round.isRoundFinished()) {
                if (++currentRound == rounds.size()) {
                    isFinished = true;
                }

            }
        }

    }

    @XmlTransient
    public Result getResult() {
        int score = 0;
        for (Round round : rounds) {
            score += round.getResult();
        }
        if (score > 0)
            return Result.WON;
        else if (score < 0)
            return Result.LOST;
        else
            return Result.TIED;
    }

    public Player getPlayer1(){
        return player1;
    }
    public Player getPlayer2(){
        return player2;


    }

    public boolean isStarted(){
        return isStarted;
    }
    public boolean isFinished(){
        return isFinished;
    }
}
