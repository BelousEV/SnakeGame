import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow (){
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // при нажатии на крестик - прекращение работы
        setSize(320,345); //размер окна
        setLocation(400, 400);
        add (new GameField());
        setVisible(true);

    }

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();

    }
}
