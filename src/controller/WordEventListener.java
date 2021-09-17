package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.Words;
import view.WordGuess;



public class WordEventListener implements ActionListener {
    private WordGuess guessWord;
    public WordEventListener(WordGuess guessWord){
        this.guessWord = guessWord;
    }
    public void actionPerformed(ActionEvent paramActionEvent) {
        JButton jBtn = (JButton)paramActionEvent.getSource();
        if (jBtn == guessWord.getnewButton()) {

            for (JButton jBtn1 : guessWord.getKeys())
                jBtn1.setEnabled(true);

            Words.setWords();
            String string1 = Words.getWords();
            guessWord.getGameKey().setText(string1);

            String string2 = "";
            for (byte by = 0; by < string1.length(); by++)
                string2 = string2 + ".";

            guessWord.getProgressStatus().setText(string2);
            guessWord.setLifeCount(5);
            guessWord.setStatus(0);
            guessWord.setGameOver(false);

        } else {

            jBtn.setEnabled(false);

            char ch = jBtn.getText().charAt(0); // Get the button value
            char[] arrayOfChar = guessWord.getProgressStatus().getText().toCharArray();
            String str = guessWord.getGameKey().getText();
            boolean bool = false;
            for (byte by = 0; by < str.length(); by++) {
                if (ch == str.charAt(by)) {
                    arrayOfChar[by] = ch;
                    bool = true;
                }
            }
            if (bool) {
                guessWord.getProgressStatus().setText(new String(arrayOfChar));
                if (!guessWord.getProgressStatus().getText().contains(".")) {
                    guessWord.setStatus(1);
                    guessWord.setGameOver(true);
                }
            } else {
                guessWord.setLifeCount(guessWord.getLifeCount() -1);
                if (guessWord.getLifeCount() == 0) {
                    guessWord.setStatus(2);
                    guessWord.setGameOver(true);
                }
            }
        }
        guessWord.repaint();
    }
}
