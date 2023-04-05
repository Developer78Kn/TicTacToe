/* Tic Tac Toe - Zsolt Ollé */
package tictactoexo;

import java.util.Random;

/**
 *
 * @author Zsolt Ollé
 */
public class JatekosSorsol {

    private static int plIndex, jelNum;
    protected static Player[] players = new Player[2];
    private Player mark = new Player();
    protected static Player aktPlayer;

    protected static int sorsol() {
        Random rn = new Random();
        int num = rn.nextInt(2);
        return num;
    }

    public JatekosSorsol() {
        plIndex = sorsol();
        jelNum = sorsol();
        players[0] = new Player(PlayerSetting.playerName[0], mark.getMarks()[jelNum],0);
        if (jelNum == 0) {
            jelNum = 1;
        } else if (jelNum == 1) {
            jelNum = 0;
        }
        players[1] = new Player(PlayerSetting.playerName[1], mark.getMarks()[jelNum],0);
        jatekosBeallit(plIndex);
        
    }

    public static void jatekosBeallit(int num){
        aktPlayer = new Player(players[num].getName(), players[num].getMark(), players[num].getNyert());
        
        PlayerTable.jlbName1.setText(players[0].getName() + " jele: " + players[0].getMark());
        PlayerTable.jlbName2.setText(players[1].getName() + " jele: " + players[1].getMark());
        
        PlayerTable.jlLepText.setText("Lépés " + aktPlayer.getName() + " jele: " + aktPlayer.getMark());
        
        PlayerTable.jlbPlaye1Score.setText(players[0].getName()+" nyert: "+players[0].getNyert());
        PlayerTable.jlbPlaye2Score.setText(players[1].getName()+" nyert: "+players[1].getNyert());
    
    }
    
    public  Player[] getPlayers() {
        return players;
    }

    public static int getPlIndex() {
        return plIndex;
    }
    
    
    

}
