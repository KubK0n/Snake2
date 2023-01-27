package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.spi.BreakIteratorProvider;

import static snake.MainFrame.score;
public class MainPanel extends JPanel {

    private Snake snake = new Snake();
    private Apple apple = new Apple();
    private boolean gameOver = false;


    public MainPanel()  {
        setPreferredSize(new Dimension(Board.MAX_X, Board.MAX_Y));
        MainTimer timer = new MainTimer();
        timer.start();

        score.setText("Score: " + snake.getSize());

        setFocusable(true);
        addKeyListener(new MyKeYAdapter());
    }


    @Override
    protected void paintComponent(Graphics g) {
        Board.draw(g);
        snake.draw(g);
        apple.draw(g);

    }

    private class MainTimer extends Timer {
        public static final int DELAY = 105;


        public MainTimer() {
            super(DELAY, e -> {
                if (!gameOver) {
                    snake.move();

                    if (snake.eatApple(apple)) {
                        apple = new Apple();
                    }

                    if (snake.isCollision()){
                        gameOver = true;
                        score.setText("GAME OVER - Score: " + snake.getSize());
                    }
                    repaint();
                }


            });
        }
    }

    private class MyKeYAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
/*            switch (e.getKeyCode()){
                case KeyEvent.VK_SPACE:
            }*/

            switch(e.getKeyCode()) {
                // działa, zamykanie poprzedniego okna do zrobienia
                /*case KeyEvent.VK_ENTER:
                case KeyEvent.VK_SPACE:
                    if(gameOver){
                        MainFrame mainFrame = new MainFrame();
                        mainFrame.setVisible(true);
                    }
                    break; */
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (snake.getDirection() != Direction.D){
                        snake.setDirection(Direction.U);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (snake.getDirection() != Direction.U){
                        snake.setDirection(Direction.D);
                    }
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if (snake.getDirection() != Direction.R){
                        snake.setDirection(Direction.L);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (snake.getDirection() != Direction.L){
                        snake.setDirection(Direction.R);
                    }
                    break;


            }
        }
    }

}
