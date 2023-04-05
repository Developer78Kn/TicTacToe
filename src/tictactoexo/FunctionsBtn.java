/* Tic Tac Toe - Zsolt Ollé */
package tictactoexo;
import static tictactoexo.GamePlace.draw;

/**
 *
 * @author Zsolt Ollé
 */
public class FunctionsBtn {

    private static GamePlace gmp;

    public static void startGame() {

        GamePlace.panGame.removeAll(); // Ki volt kommentezve ez a sor is
//        Level.playGame();
        // WinWatcher.nullazMindent();
        new ButtonPlacement(ButtonPlacement.getBtn());
        WinWatcher.enableAllBtn(true);
        draw.setBounds(0, 0, ScreenResolution.getTableX(), ScreenResolution.getTableX());
        draw.setVisible(true);

        GamePlace.panGame.add(draw);
        MainFrame.jfMain.add(GamePlace.panGame);
        PlayerTable.btnStart.setEnabled(false);

    }

    public static void next() {

        Level.changeLevel();
       /* Level.changeLevel();
        Level.changeLevel();
        Level.changeLevel();
        Level.changeLevel();
        Level.changeLevel();
        Level.changeLevel();
        Level.changeLevel();
        Level.changeLevel();
        Level.changeLevel();
        Level.changeLevel();
        Level.changeLevel();*/
        WinWatcher.nullazMindent();
        reset();        

    }

    public static void reset() {
        PlayerTable.btnStart.setEnabled(false);
        PlayerTable.btnNext.setEnabled(false);
        
        GamePlace.panGame.removeAll();
        WinWatcher.enableAllBtn(true);
        WinWatcher.nullazMindent(); /// 2023.04.05
       
        new GamePlace();
        
        new ButtonPlacement(ButtonPlacement.getBtn());
        draw.setBounds(0, 0, ScreenResolution.getTableX(), ScreenResolution.getTableX());
        draw.setVisible(true);
        GamePlace.panGame.add(draw);
        MainFrame.jfMain.add(gmp.panGame);
    }

}
