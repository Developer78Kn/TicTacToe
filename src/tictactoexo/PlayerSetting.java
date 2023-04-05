/* Tic Tac Toe - Zsolt Ollé */
/* Játékos és a játék mód beállítása külön ablak */
package tictactoexo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author Zsolt Ollé
 */
public class PlayerSetting extends javax.swing.JDialog implements KeyListener {

    private JButton playerVsPlayer, playerVsPlayerNetwork, playerVsComputer, btnStart;
    private String activeButton, chosedText = "You chosed", 
            chosedText2 =" The first level will be 3x3. The starting player and symbol will be randomly selected by the computer.",
            yourName = "Your name: ",
            opName = "Opponent's name: ";
    private int startType;
    private JLabel lbName1, lbName2, lbInfo;
    private JTextField tfName1, tfName2;
    private boolean inditas = false;

    

    protected static String[] playerName = new String[2];

    public PlayerSetting(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setSize(800, 768);
        setLocationRelativeTo(parent);
        setResizable(false);
        setTitle("Beállítások");
        setLayout(null);

    }

    private void initComponents() {

//        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        playerVsPlayer = new JButton("Player Vs Player");
        playerVsPlayer.setBounds(30, 50, 200, 30);
        playerVsPlayer.setFocusPainted(false);
        playerVsPlayer.addActionListener((java.awt.event.ActionEvent evt) -> {
            playerVsPlayerActionPerformed(evt);
        });

        playerVsComputer = new JButton("Player Vs Computer");
        playerVsComputer.setBounds(30, 170, 200, 30);
        playerVsComputer.setFocusPainted(false);
        playerVsComputer.addActionListener((java.awt.event.ActionEvent evt) -> {
            playerVsComputerActionPerformed(evt);
        });
        
        
        
        playerVsPlayerNetwork = new JButton("Player Vs Player in network");
        playerVsPlayerNetwork.setBounds(30, 110, 200, 30);
        playerVsPlayerNetwork.setFocusPainted(false);
        playerVsPlayerNetwork.addActionListener((java.awt.event.ActionEvent evt) -> {
            playerVsPlayerNetworkActionPerformed(evt);
        });

        btnStart = new JButton("Start");
        btnStart.setBounds(600, 680, 100, 30);
        btnStart.setVisible(false);
        btnStart.setFocusable(false);
        btnStart.addActionListener((ActionEvent evt) -> {
            btnStartActionPerformed(evt);
        });

        lbInfo = new JLabel();
        lbInfo.setBounds(10, 10, 780, 20);
        lbInfo.setBackground(Color.green);
        lbInfo.setOpaque(true);
        lbInfo.setVisible(false);

        // TextFields
        lbName1 = new JLabel();
        tfName1 = new JTextField();

        lbName2 = new JLabel();
        tfName2 = new JTextField();

        tfName1.addKeyListener(this);
        tfName2.addKeyListener(this);

        lbName1.setBounds(300, 50, 100, 20);
        tfName1.setBounds(450, 50, 150, 20);
        lbName2.setBounds(300, 90, 100, 20);
        tfName2.setBounds(450, 90, 150, 20);
        lbName1.setVisible(false);
        lbName2.setVisible(false);
        tfName1.setVisible(false);
        tfName2.setVisible(false);
        
        
        // Amig nincs kész addig tiltom
         playerVsComputer.setEnabled(false);
         playerVsPlayerNetwork.setEnabled(false);

        add(lbInfo);
        add(lbName1);
        add(lbName2);
        add(tfName1);
        add(tfName2);

        add(playerVsPlayer);
        add(playerVsComputer);
        add(playerVsPlayerNetwork);
        add(btnStart);

    }

    private void playerVsPlayerActionPerformed(java.awt.event.ActionEvent evt) {
        activeButton = "playerVsPlayer";
        playerVsPlayer.setEnabled(false);
        playerVsComputer.setEnabled(true);
        playerVsPlayerNetwork.setEnabled(true);
        
        
        // Amig nincs kész addig tiltom majd törölni
         playerVsComputer.setEnabled(false);
         playerVsPlayerNetwork.setEnabled(false);
        /////////////////////
        startType = 1;
        lbInfo.setText(chosedText + evt.getActionCommand() + chosedText2);
        lbInfo.setVisible(true);

        lbName1.setText(yourName);
        lbName2.setText(opName);
        lbName1.setVisible(true);
        lbName2.setVisible(true);
        tfName1.setVisible(true);
        tfName2.setText("");
        tfName2.setVisible(true);
        btnStart.setVisible(true);
        btnStart.setEnabled(false);
        checkEmpty();
    }

    private void playerVsComputerActionPerformed(java.awt.event.ActionEvent evt) {
        activeButton = "PlayerVsComputer";
        playerVsPlayer.setEnabled(true);
        playerVsComputer.setEnabled(false);
        playerVsPlayerNetwork.setEnabled(true);
        
        // Amig nincs kész addig tiltom majd törölni
         playerVsComputer.setEnabled(false);
         playerVsPlayerNetwork.setEnabled(false);
        /////////////////////
        
        startType = 2;
        lbInfo.setText(chosedText + evt.getActionCommand() + chosedText2);
        lbInfo.setVisible(true);

        lbName1.setText(yourName);
        lbName1.setVisible(true);
        tfName1.setVisible(true);

        tfName2.setText("Computer");

        btnStart.setVisible(true);
        btnStart.setEnabled(false);

        checkEmpty();
    }

    private void playerVsPlayerNetworkActionPerformed(java.awt.event.ActionEvent evt) {
        activeButton = "playerVsPlayerNetwork";
        playerVsPlayer.setEnabled(true);
        playerVsComputer.setEnabled(true);
        playerVsPlayerNetwork.setEnabled(false);

        lbInfo.setText(chosedText + evt.getActionCommand() + chosedText2);
        lbInfo.setVisible(true);
        lbName1.setText(yourName);
        lbName1.setVisible(true);
        tfName1.setVisible(true);
        startType = 3;
        tfName2.setText("Hálózati játékos kell");

        btnStart.setVisible(true);
        btnStart.setEnabled(false);
        checkEmpty();
    }

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO itt hozom létre a játékosokat
        playerName[0] = tfName1.getText();
        playerName[1] = tfName2.getText();

        inditas = true;
        setVisible(false);
    }
////////////////////////////////////////////////////////////////////////////////

    @Override
    public void keyTyped(KeyEvent e) {
        // System.out.println(e+" keyTyped");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e+" key pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        checkEmpty();
    }

    
    
    private void checkEmpty() {

        if (activeButton.equalsIgnoreCase("playerVsPlayer")) {
            if (!tfName1.getText().isEmpty() && !tfName2.getText().isEmpty()) {
                btnStart.setEnabled(true);
            } else {
                btnStart.setEnabled(false);
            }
        } else if (activeButton.equalsIgnoreCase("playerVsPlayerNetwork") || activeButton.equalsIgnoreCase("playerVsComputer")) {
            tfName2.setVisible(false);
            lbName2.setVisible(false);
            if (!tfName1.getText().isEmpty()) {
                btnStart.setEnabled(true);
            } else {
                btnStart.setEnabled(false);
            }
        }

    }

    public boolean isInditas() {
        return inditas;
    }
    
    public int getStartType() {
        return startType;
    }

}
