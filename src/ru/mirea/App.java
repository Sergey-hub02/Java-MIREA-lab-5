package ru.mirea;

import java.awt.*;
import javax.swing.*;


public class App extends JFrame {
  private static final int WINDOW_WIDTH = 450;
  private static final int WINDOW_HEIGHT = 200;

  /**
   * Создаёт окно приложения
   */
  private App() {
    super("Application");

    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
  }

  public static void main(String[] args) {
    App win = new App();

    win.setVisible(true);
    win.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}
