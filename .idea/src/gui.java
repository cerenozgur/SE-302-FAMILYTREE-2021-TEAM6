import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class gui {
    private static JTextField tfName;
    private static JTextField textField_1;
    private static JTextField tfSurname;
    private static JTextField tfDate;
    private static JLabel getYourName;
    private static JButton YourInfo;

    public static void main(String args[]) {
        JFrame frame = new JFrame("Team6 Family Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.getContentPane().setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menuBar.setBounds(0, 0, 900, 30);
        frame.getContentPane().add(menuBar);

        JMenu mnNewMenu = new JMenu("Dosya");
        mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menuBar.add(mnNewMenu);

        JMenuItem mnıtmNewMenuItem = new JMenuItem("Aç");
        mnNewMenu.add(mnıtmNewMenuItem);

        JMenuItem mnıtmNewMenuItem_1 = new JMenuItem("Yeni");
        mnNewMenu.add(mnıtmNewMenuItem_1);

        JMenuItem mnıtmNewMenuItem_2 = new JMenuItem("Çıkış");
        mnNewMenu.add(mnıtmNewMenuItem_2);

        JMenu mnNewMenu_1 = new JMenu("Yardım");
        mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menuBar.add(mnNewMenu_1);

        JMenuItem mnıtmNewMenuItem_3 = new JMenuItem("Hakkında");
        mnNewMenu_1.add(mnıtmNewMenuItem_3);

        JMenuItem mnıtmNewMenuItem_4 = new JMenuItem("Yardım");
        mnNewMenu_1.add(mnıtmNewMenuItem_4);
        textField_1 = new JTextField();
        textField_1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
                    e.consume(); // ignore the event if it's not an alphabet
                }
            }
        });

        String gender[] = { "Kadın", "Erkek" };

        // getYourName = new JLabel("");
        // getYourName.setBounds(485, 221, 74, 30);
        // frame.getContentPane().add(getYourName);

        YourInfo = new JButton("");
        YourInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        YourInfo.setBounds(445, 192, 131, 49);
        frame.getContentPane().add(YourInfo);

        JPanel panel = new JPanel();
        panel.setBounds(0, 40, 217, 613);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(10, 282, 85, 21);
        panel.add(btnNewButton);

        JButton btnAddButton = new JButton("Soy A\u011Fac\u0131na Ekle");
        btnAddButton.setBounds(10, 179, 176, 25);
        panel.add(btnAddButton);

        JLabel lblNewLabel_4 = new JLabel("Cinsiyet:");
        lblNewLabel_4.setBounds(10, 124, 49, 14);
        panel.add(lblNewLabel_4);
        JComboBox comboBox = new JComboBox(gender);
        comboBox.setBounds(90, 120, 96, 22);
        panel.add(comboBox);

        JLabel lblNewLabel_3 = new JLabel("Do\u011Fum tarihi:");
        lblNewLabel_3.setBounds(10, 99, 68, 15);
        panel.add(lblNewLabel_3);

        tfDate = new JTextField();
        tfDate.setBounds(90, 97, 96, 20);
        panel.add(tfDate);
        tfDate.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Soyisim:");
        lblNewLabel_2.setBounds(10, 74, 50, 15);
        panel.add(lblNewLabel_2);

        tfSurname = new JTextField();
        tfSurname.setBounds(90, 72, 96, 20);
        panel.add(tfSurname);
        tfSurname.setColumns(10);

        tfName = new JTextField();
        tfName.setBounds(90, 42, 96, 20);
        panel.add(tfName);
        tfName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
                    e.consume(); // ignore the event if it's not an alphabet
                }
            }
        });
        tfName.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u0130sim:");
        lblNewLabel_1.setBounds(9, 44, 50, 15);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("Giri\u015F");
        lblNewLabel.setBounds(59, 10, 50, 15);
        panel.add(lblNewLabel);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        btnAddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textName = tfName.getText();
                String textSurname = tfSurname.getText();
                YourInfo.setText(textName + " " + textSurname);

            }
        });

        frame.setVisible(true);
    }
}