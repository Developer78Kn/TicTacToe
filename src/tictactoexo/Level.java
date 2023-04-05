/* Tic Tac Toe - Zsolt Ollé */
package tictactoexo;


/**
 *
 * @author Zsolt Ollé
 */
public class Level {

    private static int level , szorzo;

    public static void setLevel(int aLevel) {
        level = aLevel;
    }

    public static void setSzorzo(int aSzorzo) {
        szorzo = aSzorzo;
    }

    public Level() {
    }

    public static int playGame() {
        level = 1;
        szorzo = 3;
        PlayerTable.jlbLevel.setText("Level " + getLevel());
        return level;
    }

    public static int changeLevel() {
        if (level < 13) {
            level += 1;
            szorzo +=1;
            PlayerTable.jlbLevel.setText("Level " + getLevel());
        }
        if(level == 13){
            PlayerTable.btnNext.setEnabled(false);
        }
        return level;
    }

    public static int getLevel() {
        return level;
    }

    public static int getSzorzo() {
        return szorzo;
    }
    
    

}
