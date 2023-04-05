/* Tic Tac Toe - Zsolt Ollé */
/* WIN check */
package tictactoexo;

import javax.swing.JOptionPane;
import static tictactoexo.JatekosSorsol.players;

/**
 *
 * @author Zsolt Ollé
 */
public class WinWatcher {

    protected static int lepesKell, talalat = 0, necessaryHit, szorzo = Level.getSzorzo(), winner;
    private static String message;
    
    private static String winnerText = "Congratulations, you are the winner ", 
            winnerMarkText = " is the sign.",
            theWinnerText = "The winner:",
            winText = " won against "
            
            ;

    public static boolean WinsWatcher() {

        if (Level.getLevel() <= 3) {
            lepesKell = 5;
            necessaryHit = 3;
//            System.out.println(lepesKell + " lépés kell " + necessaryHit + " találat kell");
        } else if (Level.getLevel() == 4) {
            lepesKell = 7;
            necessaryHit = 4;
//            System.out.println(lepesKell + " lépés kell " + necessaryHit + " találat kell");
        } else if (Level.getLevel() >= 5) {
            lepesKell = 9;
            necessaryHit = 5;
//            System.out.println(lepesKell + " lépés kell " + necessaryHit + " találat kell");
        }

        if (lepesKell <= ActionHandler.lepesSzama) {
            if (balrolJobbraHorizont(ActionHandler.playerSzama) == necessaryHit) {
                enableAllBtn(false);
                nyertes();
                return true;
            } else if (fentrolLe(ActionHandler.playerSzama) == necessaryHit) {
                enableAllBtn(false);
                nyertes();
                return true;
            } else if (balrolJobbraLe(ActionHandler.playerSzama) == necessaryHit) {
                enableAllBtn(false);
                nyertes();
                return true;
            } else if (jobbrolBalraLe(ActionHandler.playerSzama) == necessaryHit) {
                enableAllBtn(false);
                nyertes();
                return true;
            } else if (ActionHandler.lepesSzama == Level.getSzorzo() * Level.getSzorzo()) {
                PlayerTable.jlLepText.setText("Döntetlen !");
                PlayerTable.btnNext.setEnabled(true);
                return true;
            }
        }
        return false;
    }

    // ***** Vizsgálatok => 4 fajta ****************
    // Vertical  Balról |--> Jobbra
    public static int balrolJobbraHorizont(int num) {
        for (int i = 0; i < ButtonPlacement.getBtn().length && talalat < necessaryHit; i++) {
            talalat = 0;
            for (int j = 0; j < ButtonPlacement.getBtn()[i].length && talalat < necessaryHit; j++) {
                if (ButtonPlacement.getState()[i][j] != 0 && ButtonPlacement.getState()[i][j] == num) {
                    talalat++;
                } else {
                    talalat = 0;
                }
            }
        }
        return talalat;
    }

    // ellenőrzés fentről le
    public static int fentrolLe(int num) {
        for (int i = 0; i < ButtonPlacement.getBtn().length && talalat < necessaryHit; i++) {
            talalat = 0;
            for (int j = 0; j < ButtonPlacement.getBtn()[i].length && talalat < necessaryHit; j++) {
                if (ButtonPlacement.getState()[j][i] != 0 && ButtonPlacement.getState()[j][i] == num) {
                    talalat++;
                } else {
                    talalat = 0;
                }
            }
        }
        return talalat;
    }

    // ellenőrzés balról jobbra le |\>
    public static int balrolJobbraLe(int num) {
        for (int i = 0; i < ButtonPlacement.getBtn().length - 1 && talalat < necessaryHit; i++) {
            for (int j = 0; j < ButtonPlacement.getBtn()[i].length - 1 && talalat < necessaryHit; j++) {
                if (ButtonPlacement.getState()[i][j] != 0 && ButtonPlacement.getState()[i][j] == num) {
                    int n = 0, x = j, y = i;
                    talalat = 0;
                    while (talalat < necessaryHit && (y + n) <= ButtonPlacement.getBtn().length - 1 && (x + n) <= ButtonPlacement.getBtn()[i].length - 1) {
                        if (ButtonPlacement.getState()[y + n][x + n] == num && ButtonPlacement.getState()[y + n][x + n] != 0) {
                            talalat++;
                        } else {
                            talalat = 0;
                        }
                        n++;
                    }
                }
            }
        }
        return talalat;
    }

    // ellenőrzés jobbról balra le |\>
    public static int jobbrolBalraLe(int num) {
        for (int i = 0; i < ButtonPlacement.getBtn().length - 1 && talalat < necessaryHit; i++) {
            for (int j = 0; j < ButtonPlacement.getBtn()[i].length && talalat < necessaryHit; j++) {
                if (ButtonPlacement.getState()[i][j] != 0 && ButtonPlacement.getState()[i][j] == num) {
                    int n = 0, x = j, y = i;
                    talalat = 0;
                    while (talalat < necessaryHit && y + n <= ButtonPlacement.getBtn().length - 1 && x - n >= 0) {
                        if (ButtonPlacement.getState()[y + n][x - n] == num && ButtonPlacement.getState()[y + n][x - n] != 0) {
                            talalat++;
                        } else {
                            talalat = 0;
                        }
                        n++;
                    }
                }
            }
        }
        return talalat;
    }

    public static void enableAllBtn(boolean tilt) {
        for (int i = 0; i < ButtonPlacement.getBtn().length; i++) {
            for (int j = 0; j < ButtonPlacement.getBtn()[i].length; j++) {
                ButtonPlacement.getBtn()[i][j].setEnabled(tilt);
            }
        }
    }

    public static void nyertes() {
        PlayerTable.jlLepText.setText(winnerText + JatekosSorsol.aktPlayer.getName() +  winnerMarkText  + JatekosSorsol.aktPlayer.getMark());
        // 2023.04.05
        // ActionHandler.lepesSzama = 0;
         
                 
                 
        PlayerTable.btnNext.setEnabled(true);
        if (JatekosSorsol.players[0].getName().equalsIgnoreCase(JatekosSorsol.aktPlayer.getName())) {
            players[0].setNyert();
            PlayerTable.jlbPlaye1Score.setText(players[0].getName() + " nyert: " + players[0].getNyert());
        } else if (JatekosSorsol.players[1].getName().equalsIgnoreCase(JatekosSorsol.aktPlayer.getName())) {
            players[1].setNyert();
            PlayerTable.jlbPlaye2Score.setText(players[1].getName() + " nyert: " + players[1].getNyert());
        }
        
         
        
        
        // Ide kell egy POPUP ablak ami véglegesít mindent kiirja ki nyert végleg
        if (Level.getLevel() == 13) {
            PlayerTable.btnNext.setEnabled(false);

            if (JatekosSorsol.players[0].getNyert() > JatekosSorsol.players[1].getNyert()) {
                message = theWinnerText + JatekosSorsol.players[0].getName() + " " + JatekosSorsol.players[0].getNyert() + " : " + JatekosSorsol.players[1].getNyert()
                        + winText + JatekosSorsol.players[1].getName() ;
            } else if (JatekosSorsol.players[0].getNyert() < JatekosSorsol.players[1].getNyert()) {
                message = theWinnerText + JatekosSorsol.players[1].getName() + " " + JatekosSorsol.players[1].getNyert() + " : " + JatekosSorsol.players[0].getNyert()
                        + winText + JatekosSorsol.players[0].getName() ;
            } else if (JatekosSorsol.players[0].getNyert() == JatekosSorsol.players[1].getNyert()) {
                message = "Nincs nyertes Ez most DÖNTETLEN ! "
                        + JatekosSorsol.players[1].getName() + " " + JatekosSorsol.players[1].getNyert()
                        + " : " + JatekosSorsol.players[0].getNyert() + JatekosSorsol.players[0].getName() + " ellen.";
            }
            message += "\n Yes = New Game, No = Choosing another opponent";
            int choice = JOptionPane.showConfirmDialog(MainFrame.jfMain, message, "Announcement of the final result", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            System.out.println("choice: " + choice);
            if (choice == 0) {
                System.out.println("You pressed YES for the new start from LEVEL 1.");
//                nullazMindent();
            } else if (choice == 1) {
                System.out.println("You pressed NO for the new opponent selection.");
                nullazMindent();
                MainFrame.jfMain.dispose();
                new MainFrame();
                
            }
        }
        
    }

    public static void nullazMindent() {
        GamePlace.panGame.removeAll();
        WinWatcher.talalat = 0;
        ActionHandler.lepesSzama = 0;
    }

}
