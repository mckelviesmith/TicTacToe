// Mckelvie Smith
import javax.swing.*;
public class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() // play the game
        {
            public void run()
            {
                TicTacToeGUI game= new TicTacToeGUI();
            }
            
        });
 
    }
}
