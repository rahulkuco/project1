import view.WordGuess;
import javax.swing.*;
public class Main {
    public static void main(String[] paramArrayOfString) {
        JFrame window = new WordGuess();
      window.setTitle("Project1: Word Guess Game");
      window.setLocation(100, 100);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.pack();
      window.setVisible(true);
    }
  }
  