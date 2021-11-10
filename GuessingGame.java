import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
 
  JTextField userGuess;

  JButton guess;
  JButton playAgain;

  JLabel enterGuess;
  JLabel highLow;
  JLabel lastGuess;

  Random r = new Random();

  int randomNum; 

  GuessingGame(){
  
    randomNum = r.nextInt(100) + 1;

    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240, 120);

    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");

    guess = new JButton("Guess");
    playAgain = new JButton("Play Again"); 

    userGuess.addActionListener(this); 
    guess.addActionListener(this); 
    playAgain.addActionListener(this); 

    enterGuess = new JLabel("Enter your guess: ");
    highLow = new JLabel("");
    lastGuess = new JLabel("");

    frame.add(enterGuess);
    frame.add(userGuess);
    frame.add(guess);
    frame.add(highLow);
    frame.add(lastGuess);
    frame.add(playAgain);

    frame.setVisible(true);
  }

  
  public void actionPerformed(ActionEvent aev) {
    if(aev.getActionCommand().equals("Guess")){
      int guess = Integer.parseInt(userGuess.getText());

    if(randomNum > guess){
        highLow.setText("Too low!");
        lastGuess.setText("Last guess was " + guess);
          }
    else if(randomNum < guess){
        highLow.setText("Too high!");
        lastGuess.setText("Last guess was " + guess);
          }
    else{
         highLow.setText("You got it!");
         lastGuess.setText("Last guess was " + guess);
        }
    }
    
    if(aev.getActionCommand().equals("Play Again")){
            randomNum = r.nextInt(100) + 1;
            userGuess.setText("");
            highLow.setText("");
            lastGuess.setText("");
    }
  }

}





  
