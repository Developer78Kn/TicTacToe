/* Tic Tac Toe - Zsolt Ollé */
/* Játékos adatainak táblája */
package tictactoexo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Zsolt Ollé
 */
// public class PlayerTable extends GameValues {
public class PlayerTable {
    
    private JPanel jpMenu, jpInfo, jpButtons;
    protected static JLabel jlPlayerText, jlbName1 = new JLabel("", JLabel.LEFT), jlbName2 = new JLabel("", JLabel.LEFT), jlLepText = new JLabel("", JLabel.CENTER),
            jlbLevel = new JLabel("", JLabel.CENTER), jlbPlaye1Score = new JLabel("", JLabel.CENTER), jlbPlaye2Score = new JLabel("", JLabel.CENTER);
    protected static JButton btnStart = new JButton("START"), btnNext = new JButton("Következő szint");
    
    public PlayerTable() {
    }
    
    public PlayerTable(JFrame mainJf, int resX, int resY, Player p1, Player p2, Player aktPlayer) {
        
        int jpMenuSizeX = resX - ScreenResolution.getTableX();

// JPanel settings
        jpMenu = new JPanel();
// jpMenu méreteinek arányos kiszámítása a játék tér méreteiből
        jpMenu.setBounds(ScreenResolution.getTableX() + 20, 10, jpMenuSizeX - 35, ScreenResolution.getTableX());
        jpMenu.setBackground(new Color(255, 229, 180));
        jpMenu.setLayout(null);

// Level kiiratása
//        jlbLevel = new JLabel("Level " + Level.getLevel(), JLabel.CENTER);
//        jlbLevel = new JLabel("Level " + Level.getLevel(), JLabel.CENTER);
        jlbLevel.setFont(new Font("Verdana", Font.BOLD, 26));
        jlbLevel.setBackground(new Color(55, 222, 173));
        jlbLevel.setBounds(10, 10, ((resX * 40) / 100) - 60, 40);
        jlbLevel.setOpaque(true);

// Info tábla adatai      
        jpInfo = new JPanel();
        jpInfo.setBackground(new Color(55, 222, 173));
        jpInfo.setBounds(10, 100, ((resX * 40) / 100) - 60, ((resX * 60) / 100) - 400);
        jpInfo.setOpaque(true);

// Infotáblába playerText        
        jlPlayerText = new JLabel("Players", JLabel.CENTER);
        jlPlayerText.setFont(new Font("Verdana", Font.BOLD, 26));
        jlPlayerText.setBackground(new Color(215, 189, 140));
        jlPlayerText.setPreferredSize(new Dimension(((resX * 40) / 100) - 60, 35));
        jlPlayerText.setOpaque(true);

// Print Players Name         
//        System.out.println("Értéek ami kell: " + (((resX * 40) / 100) - 70) / 2);
        jlbName1.setFont(new Font("Verdana", Font.BOLD, 18));
        jlbName1.setBackground(new Color(215, 189, 140));
        jlbName1.setPreferredSize(new Dimension((((resX * 40) / 100) - 70) / 2, 35));
        jlbName1.setBorder(new EmptyBorder(0, 10, 0, 0));
        jlbName1.setOpaque(true);
        
        jlbName2.setFont(new Font("Verdana", Font.BOLD, 18));
        jlbName2.setBackground(new Color(255, 229, 180));
        jlbName2.setPreferredSize(new Dimension((((resX * 40) / 100) - 70) / 2, 35));
        jlbName2.setBorder(new EmptyBorder(0, 10, 0, 0));
        jlbName2.setOpaque(true);

// Lépés felirata
// valahogy frissíteni kell a lépés után
        jlLepText.setFont(new Font("Verdana", Font.BOLD, 18));
        jlLepText.setBackground(new Color(235, 145, 0));
        jlLepText.setPreferredSize(new Dimension((((resX * 40) / 100) - 70), 35));
        jlLepText.setBorder(new EmptyBorder(0, 10, 0, 0));
        jlLepText.setOpaque(true);

// Játékos pontszámai hányszor nyert
      
        jlbPlaye1Score.setFont(new Font("Verdana", Font.BOLD, 18));
        jlbPlaye1Score.setBackground(new Color(255, 229, 180));
        jlbPlaye1Score.setPreferredSize(new Dimension((((resX * 40) / 100) - 70) / 2, 35));
        jlbPlaye1Score.setBorder(new EmptyBorder(0, 10, 0, 0));
        jlbPlaye1Score.setOpaque(true);
        
        jlbPlaye2Score.setFont(new Font("Verdana", Font.BOLD, 18));
        jlbPlaye2Score.setBackground(new Color(255, 229, 180));
        jlbPlaye2Score.setPreferredSize(new Dimension((((resX * 40) / 100) - 70) / 2, 35));
        jlbPlaye2Score.setBorder(new EmptyBorder(0, 10, 0, 0));
        jlbPlaye2Score.setOpaque(true);

// BUTTONS PANEL
//System.out.println( ((resX * 60) / 100)-100 +"btn tábla x mérete");
        jpButtons = new JPanel(new GridLayout(3, 0, 10, 10));
        jpButtons.setBounds(10, ((resX * 40) / 100) + 110, ((resX * 40) / 100) - 60, 200);
        jpButtons.setBackground(new Color(215, 148, 25));
        jpButtons.setOpaque(true);

// Button Start 
//        JButton btnStart = new JButton("START");
        btnStart.setLayout(null);
        btnStart.setVisible(true);
        btnStart.setBounds(10, 10, 150, 30);
        btnStart.setForeground(Color.white);
        btnStart.setBackground(new Color(51, 102, 153));
        btnStart.setFocusPainted(false);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FunctionsBtn.startGame();
            }
        });

// Button Reset        
        JButton btnReset = new JButton("RESET");
        btnReset.setLayout(null);
        btnReset.setVisible(true);
        btnReset.setBounds(10, 10, 150, 30);
        btnReset.setForeground(Color.white);
        btnReset.setBackground(new Color(51, 102, 153));
        btnReset.setFocusPainted(false);
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FunctionsBtn.reset();
            }
        });

// Button Next
//        JButton btnNext = new JButton("Következő szint");
        btnNext.setBounds(10, 10, 150, 30);
        btnNext.setVisible(true);
        btnNext.setForeground(Color.white);
        btnNext.setBackground(new Color(51, 102, 153));
        btnNext.setFocusPainted(false);
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FunctionsBtn.next();
            }
        });
        btnNext.setEnabled(false);
        
        jpMenu.add(jlbLevel);
        jpInfo.add(jlPlayerText);
        jpInfo.add(jlbName1);
        jpInfo.add(jlbName2);
        jpInfo.add(jlLepText);
        
        jpInfo.add(jlbPlaye1Score);
        jpInfo.add(jlbPlaye2Score);
        
        jpMenu.add(jpButtons);
        jpButtons.add(btnStart);
        jpButtons.add(btnNext);
        jpButtons.add(btnReset);
        
        jpMenu.add(jpInfo);
        
        mainJf.add(jpMenu);
    }
    
}
