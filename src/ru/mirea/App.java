package ru.mirea;

import java.io.File;
import java.io.IOException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import javax.imageio.ImageIO;


public class App extends JFrame {
  private static final int WINDOW_WIDTH = 1400;
  private static final int WINDOW_HEIGHT = 900;

  private static final String IMG = "/home/ezhik/Documents/Java-MIREA/labs/Java-MIREA-lab-5/imgs/sekiro.jpg";

  /**
   * Создаёт окно приложения
   */
  private App() throws IOException {
    super("Application");

    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setLayout(null);

    BufferedImage image = ImageIO.read(new File(IMG));
    JLabel imageLabel = new JLabel(new ImageIcon(image));

    int imageX = (WINDOW_WIDTH - image.getWidth()) / 2;
    int imageY = (WINDOW_HEIGHT - image.getHeight()) / 2;

    imageLabel.setLocation(imageX, imageY);                   // расположить картинку в центре окна
    imageLabel.setSize(image.getWidth(), image.getHeight());

    JButton moveLeft = new JButton("Сдвинуть влево");
    JButton moveRight = new JButton("Сдвинуть вправо");

    moveLeft.addActionListener(new ActionListener() {
      /**
       * Сдвигает картинку влево на 5 пикселей
       * @param e       событие
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        imageLabel.setLocation(imageLabel.getX() - 5, imageLabel.getY());
      }
    });

    moveRight.addActionListener(new ActionListener() {
      /**
       * Сдвигает картинку вправо на 5 пикселей
       * @param e       событие
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        imageLabel.setLocation(imageLabel.getX() + 5, imageLabel.getY());
      }
    });

    moveLeft.setSize(160, 25);
    moveRight.setSize(160, 25);

    moveLeft.setLocation(15, WINDOW_HEIGHT - 60);
    moveRight.setLocation(WINDOW_WIDTH - 15 - moveRight.getWidth(), WINDOW_HEIGHT - 60);

    add(imageLabel);
    add(moveLeft);
    add(moveRight);
  }

  public static void main(String[] args) throws IOException {
    App win = new App();

    win.setVisible(true);
    win.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}
