import com.jayway.stensaxpase.Game;
import com.jayway.stensaxpase.Player;
import com.jayway.stensaxpase.Round;

class GameTest{
               public static  void main(String[] args){
                   Player p1 = new Player("kalle");
                   Player p2 = new Player("pelle");

                   Game game = new Game(p1,1, 0);

                   game.setOpponent(p2);

                   game.makeChoice(p1, Round.Choice.SCISSORS);
                   game.makeChoice(p2, Round.Choice.STONE);

                   System.out.println(game.getResult());


               }
        }