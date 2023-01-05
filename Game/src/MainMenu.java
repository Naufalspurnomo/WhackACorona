import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {
  private JPanel panel;
  private JButton btnStart;
  private JButton btnQuit;
  private ImageIcon background;
  private JLabel lblBackground;

  public MainMenu() {
    // Menyiapkan panel
    panel = new JPanel();
    panel.setLayout(null);

    // Menyiapkan background
    background = new ImageIcon("/img/bg.png");
    lblBackground = new JLabel(background);
    lblBackground.setBounds(0, 0, 300, 300);
    panel.add(lblBackground);

    // Menyiapkan tombol Start
    btnStart = new JButton("Start");
    btnStart.setBounds(100, 50, 100, 30);
    panel.add(btnStart);

    // Menyiapkan tombol Quit
    btnQuit = new JButton("Quit");
    btnQuit.setBounds(100, 100, 100, 30);
    panel.add(btnQuit);

    // Menambahkan event listener untuk tombol Quit
    btnQuit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    // Menambahkan event listener untuk tombol Start
    btnStart.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Membuat objek dari kelas Game
        Game game = new Game();
        // Menampilkan frame game
        game.setVisible(true);
        // Menyembunyikan frame menu utama
        setVisible(false);
      }
    });

    // Menambahkan panel ke frame
    add(panel);

    // Mengatur ukuran frame
    setSize(300, 300);
    setTitle("Main Menu");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
