package com.jayway.stensaxpase;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: hanskarlsson
 * Date: 8/2/2013
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class Round {
    public enum Choice {STONE, SCISSORS, PAPER}

    private Choice player1Choice;
    private Choice player2Choice;


    public Choice getPlayer1Choice() {
        return player1Choice;
    }

    public void setPlayer1Choice(Choice player1Choice) {
        this.player1Choice = player1Choice;
    }

    public Choice getPlayer2Choice() {
        return player2Choice;
    }

    public void setPlayer2Choice(Choice player2Choice) {
        this.player2Choice = player2Choice;
    }

    public boolean isRoundFinished() {
        System.out.println("p1:" + player1Choice);
        System.out.println("p2:" + player2Choice);
        return player1Choice != null && player2Choice != null;
    }

    public int getResult() {
        if (!isRoundFinished()) {
            throw new RuntimeException();
        }
        if (player1Choice == player2Choice) {
            return 0;
        }

        if (player1Choice == Choice.STONE) {
            if (player2Choice == Choice.SCISSORS)
                return 1;
            else
                return -1;
        } else if (player1Choice == Choice.SCISSORS) {
            if (player2Choice == Choice.PAPER)
                return 1;
            else
                return -1;
        } else if (player1Choice == Choice.PAPER) {
            if (player2Choice == Choice.STONE)
                return 1;
            else
                return -1;
        }
        return 0;
    }

}
