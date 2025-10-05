import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGameView extends JFrame {

    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel centerPanel;

    private JLabel labelMessage;

    private TicTacToeTile buttons[][];

    private TicTacToeController ticTacToeController;

    private class TicTacToeTile extends JButton {
        private int boxNumber;

        public TicTacToeTile(int boxNumber){
            this.boxNumber = boxNumber;
        }
        public void setMarker(char marker){
            setText("" + marker);
            setEnabled(false);
        }
        public int getBoxNumber(){
            return boxNumber;
        }
        
    }

    private void setup(){

        topPanel = new JPanel(new FlowLayout());
        labelMessage = new JLabel("Spelare X lägger först");
        topPanel.add(labelMessage);

        centerPanel = new JPanel(new GridLayout(Board.size, Board.size));

        buttons = new TicTacToeTile[Board.size][Board.size];
        int boxNumber = 0;
        for(int i = 0; i < Board.size; i++){
            for(int j = 0; j < Board.size; j++){
                buttons[i][j] = new TicTacToeTile(boxNumber++);
                final int ii = i;
                final int jj = j;

                buttons[i][j].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e){
                        ticTacToeController.handleInputFromUser(buttons[ii][jj].getBoxNumber());
                    }
                });
            }
        }
        // lägger till knappar
        for(int i = 0; i < Board.size; i++){
            for(int j = 0; j < Board.size; j++){
                centerPanel.add(buttons[i][j]);
            }
        }       

        mainPanel = new JPanel(new BorderLayout());

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
    }

    public void setMarker(int boxNumber, char marker){
        int i = boxNumber/Board.size;
        int j = boxNumber%Board.size;
        buttons[i][j].setMarker(marker);
    }
    public void showGameResult(String result){
        JOptionPane.showMessageDialog(this, result, "Game Over", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public void showMessage(String message){
        labelMessage.setText(message);
    }

    public TicTacToeGameView(TicTacToeController ticTacToeController) {

        setup();

        this.ticTacToeController = ticTacToeController;

        setSize(400, 300);

        setTitle("Tic Tac Toe");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }
    
}
