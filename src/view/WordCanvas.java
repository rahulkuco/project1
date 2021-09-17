package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JPanel;

class WordCanvas extends JPanel {
    private WordGuess guessWord;

    public WordCanvas(WordGuess guessWord){
        this.guessWord = guessWord;
    }
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        if (!guessWord.isGameOver()) {
            graphics2D.setColor(Color.blue);
            graphics2D.setFont(new Font("Courier New", 1, 40));
            graphics2D.drawString("Health Level", 50, 50);
            for (byte by = 0; by < guessWord.getLifeCount(); by++)
                graphics2D.fill(new Rectangle2D.Double((50 + by * 50), 70.0D, 45.0D, 50.0D));
        } else {
            graphics2D.setColor(Color.blue);
            graphics2D.setFont(new Font("Courier New", 1, 30));
            graphics2D.drawString("Press <New> to Start", 50, 150);
        }
        switch (guessWord.getStatus()) {
            case 1:
                graphics2D.setColor(Color.red);
                graphics2D.drawString("Its a Win", 50, 100);
                for (JButton jBtn : guessWord.getKeys())
                    jBtn.setEnabled(false);
                break;
            case 2:
                graphics2D.setColor(Color.red);
                graphics2D.drawString("Its loss !", 50, 100);
                for (JButton jBtn : guessWord.getKeys())
                    jBtn.setEnabled(false);
                break;
        }
    }
}
