//Mckelvie Smith
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TicTacToeGUI extends JFrame {
    private Container pane;
    private String currentPlayer;
    private JButton[][] tttboard;
    private boolean winner;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit;
    private JMenuItem directions;
    private JMenuItem newGame;
    private int turn;
    
    public TicTacToeGUI() {
        super(); // JFrame 
        pane=getContentPane();
        pane.setLayout(new GridLayout (3,3)); // creates 3x3 layout pane
        setTitle("Tic Tac Toe");
        setSize(810, 810);
        setLocationRelativeTo(null);
        setResizable(false); // user can't resize window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); // displays GUI
        currentPlayer="x";
        tttboard= new JButton[3][3];
        winner=false; // there is no winner to start with
        turn=1;
        newBoard();
        newMenuBar(); 
    }
    
    
    private void newMenuBar()
    {
        menuBar=new JMenuBar();
        menu=new JMenu("Menu");
        
        directions= new JMenuItem("Directions");
        directions.addActionListener(new ActionListener() // Button for the game directions
        {
            public void actionPerformed(ActionEvent e)
            {
                getDirections(); // see the directions
            }
        });
        
        newGame= new JMenuItem ("New Game");
        newGame.addActionListener(new ActionListener() // Button for new game
        {
            public void actionPerformed(ActionEvent e)
            {
                resetBoard(); // new blank board
            }
        });
        
        quit= new JMenuItem("Quit");
        quit.addActionListener(new ActionListener() // Button to quit game
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0); //ends game
            }
        });

        menu.add(directions);
        menu.add(newGame);
        menu.add(quit);
        menuBar.add(menu);
        setJMenuBar(menuBar); //Creates Menu Bar
    }
    
    
    private void getDirections()
    {
        ImageIcon dImage= new ImageIcon("ttt.gif");
        JLabel dMessage= new JLabel("Get 3 in a row! Player 1=x  Player 2=o", dImage, JLabel.LEFT);
        dMessage.setFont(new Font("SANS_SERIF", Font.BOLD, 18));
        dMessage.setForeground(Color.black);
        JOptionPane.showMessageDialog(null, dMessage, "DIRECTIONS", JOptionPane.PLAIN_MESSAGE);

    }
    
    private void resetBoard()
    {
        currentPlayer="x";
        winner=false;
        turn=1;
        for (int r=0; r<3; r++)
        {
            for (int c=0; c<3; c++)
            {
                tttboard[r][c].setText(""); // blank board
            }
        }
    }
    
    private void newBoard()
    {
        turn=1;
        for (int r=0; r<3; r++)
        {
            for (int c=0; c<3; c++)
            {
                final JButton BTN=new JButton();
                BTN.setFont(new Font (Font.SANS_SERIF, Font.BOLD, 120));
                BTN.setOpaque(true); // colored border between squares
                BTN.setBackground(Color.blue);
                
                tttboard[r][c]=BTN;
                BTN.addActionListener(new ActionListener() // Button to quit game
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        if (((JButton)e.getSource()).getText().equals("") && winner==false)
                        {
                            BTN.setText(currentPlayer);
                            if (currentPlayer.equals("x")) // x=pink, o=blue
                                BTN.setForeground(Color.black);
                            else if (currentPlayer.equals("o"))
                                BTN.setForeground(Color.pink);
                            winner();
                            changePlayer();
                        }
                        // checks for valid move
                    }
                });
                pane.add(BTN);
            }
        }
    }
    
    private void changePlayer()
    {
        if (currentPlayer.equals("x")) // alternates turn
        {
            currentPlayer="o";
        }
        else 
            currentPlayer="x";
        turn++;
    }
    private void winner()
    {
        ImageIcon logo= new ImageIcon("smiley1.gif"); // icon for winner? message
        boolean fullBoard; // checks for empty spots
        for (int r=0; r<3; r++)
        {
            for (int c=0; c<3; c++)
            {
                if (tttboard[r][c].getText().equals(""))
                    fullBoard=false; 
                else 
                    fullBoard=true;
            }
        }
        // 3 in a row or tie
        if (tttboard[0][0].getText().equals(currentPlayer) && tttboard[1][0].getText().equals(currentPlayer) 
        && tttboard[2][0].getText().equals(currentPlayer))
        {
            winner=true;
            JLabel winnerMessage= new JLabel("The winner is..... Player " + currentPlayer, logo, JLabel.LEFT);
            winnerMessage.setFont(new Font("SANS_SERIF", Font.BOLD, 36));
            winnerMessage.setForeground(Color.red);
            JOptionPane.showMessageDialog(null, winnerMessage, 
            "WINNER", JOptionPane.PLAIN_MESSAGE);
        }
        
        else if (tttboard[0][1].getText().equals(currentPlayer) && tttboard[1][1].getText().equals(currentPlayer) 
        && tttboard[2][1].getText().equals(currentPlayer))
        {
            winner=true;
            JLabel winnerMessage= new JLabel("The winner is..... Player " + currentPlayer, logo, JLabel.LEFT);
            winnerMessage.setFont(new Font("SANS_SERIF", Font.BOLD, 36));
            winnerMessage.setForeground(Color.red);
            JOptionPane.showMessageDialog(null, winnerMessage, 
            "WINNER", JOptionPane.PLAIN_MESSAGE);
        } 
        else if (tttboard[2][0].getText().equals(currentPlayer) && tttboard[2][1].getText().equals(currentPlayer) 
        && tttboard[2][2].getText().equals(currentPlayer))
        {
            winner=true;
            JLabel winnerMessage= new JLabel("The winner is..... Player " + currentPlayer, logo, JLabel.LEFT);
            winnerMessage.setFont(new Font("SANS_SERIF", Font.BOLD, 36));
            winnerMessage.setForeground(Color.red);
            JOptionPane.showMessageDialog(null, winnerMessage, 
            "WINNER", JOptionPane.PLAIN_MESSAGE);
        }
        else if (tttboard[0][0].getText().equals(currentPlayer) && tttboard[0][1].getText().equals(currentPlayer) 
        && tttboard[0][2].getText().equals(currentPlayer))
        {
            winner=true;
            JLabel winnerMessage= new JLabel("The winner is..... Player " + currentPlayer, logo, JLabel.LEFT);
            winnerMessage.setFont(new Font("SANS_SERIF", Font.BOLD, 36));
            winnerMessage.setForeground(Color.red);
            JOptionPane.showMessageDialog(null, winnerMessage, 
            "WINNER", JOptionPane.PLAIN_MESSAGE);
        } 
        else if (tttboard[1][0].getText().equals(currentPlayer) && tttboard[1][1].getText().equals(currentPlayer) 
        && tttboard[1][2].getText().equals(currentPlayer))
        {
            winner=true;
            JLabel winnerMessage= new JLabel("The winner is..... Player " + currentPlayer, logo, JLabel.LEFT);
            winnerMessage.setFont(new Font("SANS_SERIF", Font.BOLD, 36));
            winnerMessage.setForeground(Color.red);
            JOptionPane.showMessageDialog(null, winnerMessage, 
            "WINNER", JOptionPane.PLAIN_MESSAGE);
        } 
        else if (tttboard[0][2].getText().equals(currentPlayer) && tttboard[1][2].getText().equals(currentPlayer) 
        && tttboard[2][2].getText().equals(currentPlayer))
        {
            winner=true;
            JLabel winnerMessage= new JLabel("The winner is..... Player " + currentPlayer, logo, JLabel.LEFT);
            winnerMessage.setFont(new Font("SANS_SERIF", Font.BOLD, 36));
            winnerMessage.setForeground(Color.red);
            JOptionPane.showMessageDialog(null, winnerMessage, 
            "WINNER", JOptionPane.PLAIN_MESSAGE);
        } 
        else if (tttboard[0][0].getText().equals(currentPlayer) && tttboard[1][1].getText().equals(currentPlayer) 
        && tttboard[2][2].getText().equals(currentPlayer))
        {
            winner=true;
            JLabel winnerMessage= new JLabel("The winner is..... Player " + currentPlayer, logo, JLabel.LEFT);
            winnerMessage.setFont(new Font("SANS_SERIF", Font.BOLD, 36));
            winnerMessage.setForeground(Color.red);
            JOptionPane.showMessageDialog(null, winnerMessage, 
            "WINNER", JOptionPane.PLAIN_MESSAGE);
        } 
        else if (tttboard[2][0].getText().equals(currentPlayer) && tttboard[1][1].getText().equals(currentPlayer) 
        && tttboard[0][2].getText().equals(currentPlayer))
        {
            winner=true;
            JLabel winnerMessage= new JLabel("The winner is..... Player " + currentPlayer, logo, JLabel.LEFT);
            winnerMessage.setFont(new Font("SANS_SERIF", Font.BOLD, 36));
            winnerMessage.setForeground(Color.red);
            JOptionPane.showMessageDialog(null, winnerMessage, 
            "WINNER", JOptionPane.PLAIN_MESSAGE);
        } 
        else if ((turn==9) && (fullBoard=true)) 
        {
            winner=true;
            JLabel tieMessage= new JLabel("TIE" , logo, JLabel.LEFT);
            tieMessage.setFont(new Font("SANS_SERIF", Font.BOLD, 36));
            tieMessage.setForeground(Color.pink);
            JOptionPane.showMessageDialog(null, tieMessage, 
            "TIE", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
