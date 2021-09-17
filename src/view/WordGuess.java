package view;
import controller.WordEventListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WordGuess extends JFrame {

  private  JButton[] keys;

  private  JButton newBtn;

  private  JTextField gameKey;

  private  JTextField progressStatus;

  private int lCount;

  private int status;

  private final WordCanvas canvas;


  private boolean gameOver = true;

  public WordGuess() {
    Container container = getContentPane();
    
    JPanel sPanel = new JPanel();
    sPanel.setLayout(new GridLayout(4, 7));
    this.keys = new JButton[26];
    WordEventListener observer = new WordEventListener(this);
    byte by = 0;
    for (char ch = 'a'; ch <= 'z'; ch = (char)(ch + 1)) {
      this.keys[by] = new JButton("" + ch);
      this.keys[by].addActionListener(observer);
      this.keys[by].setEnabled(false);
      sPanel.add(this.keys[by]);
      by++;
    }
    this.newBtn = new JButton("New");
    this.newBtn.addActionListener(observer);
    sPanel.add(this.newBtn);

    Font font = new Font("Courier New", 1, 20);
    this.gameKey = new JTextField();
    this.gameKey.setFont(font);
    this.gameKey.setForeground(Color.red);
    this.gameKey.setEditable(false);
    this.progressStatus = new JTextField();
    this.progressStatus.setFont(font);
    this.progressStatus.setEditable(false);

    JPanel nPanel = new JPanel();
    nPanel.setLayout(new GridLayout(2, 1));
    nPanel.add(this.gameKey);
    nPanel.add(this.progressStatus);

    this.canvas = new WordCanvas(this);

    this.canvas.setPreferredSize(new Dimension(500, 500));
    container.add(nPanel, "North");
    container.add(sPanel, "South");
    container.add(this.canvas, "Center");
  }

  public JButton[] getKeys() {
    return keys;
  }

  public void setKeys(JButton[] keys) {
    this.keys = keys;
  }

  public JButton getnewButton() {
    return newBtn;
  }

  public void setnewButton(JButton newBtn) {
    this.newBtn = newBtn;
  }

  public JTextField getGameKey() {
    return gameKey;
  }

  public void setGameKey(JTextField gameKey) {
    this.gameKey = gameKey;
  }

  public JTextField getProgressStatus() {
    return progressStatus;
  }

  public void setProgressStatus(JTextField progressStatus) {
    this.progressStatus = progressStatus;
  }

  public WordCanvas getCanvas() {
    return canvas;
  }

  public int getLifeCount() {
    return lCount;
  }

  public void setLifeCount(int lCount) {
    this.lCount = lCount;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }


  public boolean isGameOver() {
    return gameOver;
  }

  public void setGameOver(boolean gameOver) {
    this.gameOver = gameOver;
  }
}
