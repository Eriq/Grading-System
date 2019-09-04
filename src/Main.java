import ui.Welcome;

public class Main {
    public static void main(String[] args) {
        Welcome welcome = new Welcome();
        welcome.setVisible(true);
        welcome.pack();
        welcome.setLocationRelativeTo(null);
        welcome.setDefaultCloseOperation(welcome.EXIT_ON_CLOSE);
    }
}
