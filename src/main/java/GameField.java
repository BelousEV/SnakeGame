import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {
    private final int SIZE = 320;
    private final int DOT_SIZE = 16; //размер ячейки в пикселях - 20 шт по 16 пикс
    private final int ALL_DOTS = 400; //для размещения 20 клеток или яблок (400 игровых единиц)
    private Image dot; // область игровой ячейки
    private Image apple;
    private int appleX;
    private int appleY;
    private int[] x = new int[ALL_DOTS]; // для хранения положений змейки (по максимуму)
    private int [] y = new int[ALL_DOTS]; // тоже самое для У
    private int dots; // размер змейки в данный момент времени
    private Timer timer; // стандартный таймер
    private boolean left = false;//текущее изменнение направления змейки
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true; //мы в игре или уже ушли


    public GameField(){
        setBackground(Color.black); //цвет игрового поля
        loadImages();
            }

    public void initGame(){
        dots = 3; //начальное кличество точек
        for (int i = 0; i < dots; i++) {
            x [i] = 48 - i*DOT_SIZE; //положение начальное
            y [i] = 48;
        }
        timer = new Timer(250, this);//250мс с какой частотой будет тикать, this именно GameField отвечает за запуск таймера
        timer.start(); // запускаем таймер
        createApple();
    }
    public void createApple(){
        appleX = new Random().nextInt(20) * DOT_SIZE;
        appleY = new Random().nextInt(20) * DOT_SIZE;//20 квадратов по 16 пкс
    }

    public void loadImages(){
        ImageIcon iia = new ImageIcon("apple.png"); //загружаем картинки
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("dot.png");
        dot = iid.getImage();
    }

    public void move (){
        for (int i = dots; i > 0 ; i--) {
            x[i] = x [i-1]; // сдвигем. 2 тчк на 3 поз, 3 на 4 поз и тд
            y[i] = y [i-1];
        }
        if (left){
            x[0] -= DOT_SIZE; //перемещение для головы- налево х уменьшается
        }
        if (right){
            x[0] += DOT_SIZE; //
        }
        if (up){
            y[0] -= DOT_SIZE; //
        }
        if (down){
            y[0] += DOT_SIZE; //
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) { //будет вызываться таймер каждые 250 млс
        if (inGame){
            move();
        }
        repaint(); //перерисовываем поле
    }
}
