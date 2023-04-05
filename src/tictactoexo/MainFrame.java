/* Tic Tac Toe - Zsolt Ollé */
package tictactoexo;

import java.awt.Color;
import javax.swing.JFrame;


/**
 *
 * @author Zsolt Ollé
 */
public class MainFrame extends javax.swing.JFrame {

    protected static JFrame jfMain;

    public MainFrame() {
        PlayerSetting plSettings = new PlayerSetting(this, true);
        plSettings.setVisible(true);
        
            // itt kell majd resetelni

            jfMain = new JFrame("Tic Tac Toe created by Zsolt Ollé");
            jfMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jfMain.setLayout(null);
            jfMain.setResizable(false);
            double jFrameY = (double) ScreenResolution.getResY() * 0.843;

            jfMain.setSize(ScreenResolution.getResX(), (int) jFrameY);
            jfMain.setLocationRelativeTo(null);
            jfMain.getContentPane().setBackground(new Color(239, 203, 158));
            jfMain.setVisible(true);

            
        if (plSettings.isInditas()) {
            Level.playGame();
            PlayerTable.btnStart.setEnabled(true);

            new JatekosSorsol();
            if (plSettings.getStartType() == 1) {
                new PlayerTable(jfMain, ScreenResolution.getResX(), ScreenResolution.getResY(), JatekosSorsol.players[0], JatekosSorsol.players[1], JatekosSorsol.aktPlayer);
            } else if (plSettings.getStartType() == 2) {
                new PlayerTable(jfMain, ScreenResolution.getResX(), ScreenResolution.getResY(), JatekosSorsol.players[0], JatekosSorsol.players[1], JatekosSorsol.aktPlayer);
            } else if (plSettings.getStartType() == 3) {
                System.out.println("Hálózati játék következik: ");
                
                
                
//                System.out.println(game.getPlayers()[0].getName() + " jele " + game.getPlayers()[0].getMark());
//                System.out.println(game.getPlayers()[1].getName() + " jele " + game.getPlayers()[1].getMark());
            }
        }
        new GamePlace(jfMain);

    }
}


