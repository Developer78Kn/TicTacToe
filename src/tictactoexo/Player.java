/* Tic Tac Toe - Zsolt Ollé */
package tictactoexo;

/**
 *
 * @author Zsolt Ollé
 */
public class Player {

    private String name;
    protected String[] marks = {"X", "O"};
    private String mark;
    private int nyert;

    public Player() {
    }

//    public Player(String name, String mark) {
    public Player(String name, String mark, int nyert) {
        this.name = name;
        this.mark = mark;
        this.nyert = nyert;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getMarks() {
        return marks;
    }

    public String getMark() {
        return mark;
    }

    public int getNyert() {
        return nyert;
    }

    public void setNyert() {
//        this.nyert += 1;
        this.nyert++;
    }

    
    
}
