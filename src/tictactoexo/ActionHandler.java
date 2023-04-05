/* Tic Tac Toe - Zsolt Ollé */
package tictactoexo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Zsolt Ollé
 */
public class ActionHandler implements ActionListener {

    protected static int lepesSzama, playerSzama;

    public ActionHandler() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* EZT SZEDTEM KI */
        if (!JatekosSorsol.aktPlayer.getName().equalsIgnoreCase("Computer") ){
            for (int i = 0; i < ButtonPlacement.getBtn().length; i++) {
                for (int j = 0; j < ButtonPlacement.getBtn()[i].length; j++) {
                    if (e.getSource() == ButtonPlacement.getBtn()[i][j] && ButtonPlacement.getState()[i][j] == 0) {
                        if (JatekosSorsol.aktPlayer.getMark().equalsIgnoreCase("X")) {
                            playerSzama = 1;
                            ButtonPlacement.getBtn()[i][j].setEnabled(false);
                            ButtonPlacement.getState()[i][j] = playerSzama;
                            lepesSzama++;
                        } else if (JatekosSorsol.aktPlayer.getMark().equalsIgnoreCase("O")) {
                            playerSzama = 2;
                            ButtonPlacement.getBtn()[i][j].setEnabled(false);
                            ButtonPlacement.getState()[i][j] = playerSzama;
                            lepesSzama++;
                        }
                    }
                }
            }


        } // IF vége
       /*  Ki volt kommentezve*/
        lepes(e);

    }

    public void lepes(ActionEvent e) {
        if (JatekosSorsol.aktPlayer.getMark().equalsIgnoreCase("X")) {
            playerSzama = 1;
        } else if (JatekosSorsol.aktPlayer.getMark().equalsIgnoreCase("O")) {
            playerSzama = 2;
        }

        if (!JatekosSorsol.aktPlayer.getName().equalsIgnoreCase("Computer")) {
            for (int i = 0; i < ButtonPlacement.getBtn().length; i++) {
                for (int j = 0; j < ButtonPlacement.getBtn()[i].length; j++) {
                    if (e.getSource() == ButtonPlacement.getBtn()[i][j] && ButtonPlacement.getState()[i][j] == 0) {
                        // if (JatekosSorsol.aktPlayer.getMark().equalsIgnoreCase("X")) {
                        //   playerSzama = 1;
                        System.out.println("Player száma: "+playerSzama);
                        ButtonPlacement.getBtn()[i][j].setEnabled(false);
//                            System.out.println("Button placement cord: "+ButtonPlacement.getBtn()[i][j]);
                        System.out.println("I1=> " + i + " J1=> " + j);
                        ButtonPlacement.getState()[i][j] = playerSzama;
                        lepesSzama++;
                        // } else if (JatekosSorsol.aktPlayer.getMark().equalsIgnoreCase("O")) {
                        // playerSzama = 2;
                        System.out.println("Player száma: "+playerSzama);
                        ButtonPlacement.getBtn()[i][j].setEnabled(false);
                        // System.out.println("Button placement cord: "+ButtonPlacement.getBtn()[i][j]);
                        System.out.println("I2=> " + i + " J2=> " + j);
                        ButtonPlacement.getState()[i][j] = playerSzama;
                        lepesSzama++;
                        //}
                    }
                }
            }
        } // IF vége

        if (JatekosSorsol.aktPlayer.getName().equalsIgnoreCase("Computer")) {
            System.out.println("Most lép a computer");
            System.out.println("Száma: " + playerSzama);
            System.out.println("Aktualis játékos jele: " + JatekosSorsol.players[playerSzama - 1].getMark());
            computerLep();
        }

        changePlayer();
    }

    public void computerLep() {
        if (JatekosSorsol.aktPlayer.getName().equalsIgnoreCase("Computer")) {

            System.out.println("Számítógép fog következni itt kell meghívni a random számokat");
            AI aiNum = new AI();
            System.out.println(aiNum.num());
            ButtonPlacement.getState()[1][2] = playerSzama;

        }
    }

    public void changePlayer() {
        if (!WinWatcher.WinsWatcher()) {
            // átállítom az aktuális játékost
            if (JatekosSorsol.aktPlayer.getName().equalsIgnoreCase(JatekosSorsol.players[0].getName())) {
                JatekosSorsol.aktPlayer = JatekosSorsol.players[1];
                PlayerTable.jlLepText.setText("Lép " + JatekosSorsol.aktPlayer.getName() + " jele: " + JatekosSorsol.aktPlayer.getMark());
            } else if (JatekosSorsol.aktPlayer.getName().equalsIgnoreCase(JatekosSorsol.players[1].getName())) {
                JatekosSorsol.aktPlayer = JatekosSorsol.players[0];
                PlayerTable.jlLepText.setText("Lép " + JatekosSorsol.aktPlayer.getName() + " jele: " + JatekosSorsol.aktPlayer.getMark());
            }
        }

    }
}
