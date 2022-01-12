import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.EventQueue;
import com.toedter.calendar.JDateChooser;

class gui {
    private static JTextField tfName;
    private static JTextField textField_1;
    private static JTextField tfSurname;
    //private static JTextField tfDate;
    private static JLabel getYourName;
    private static JButton YourInfo;

    public static void main(String args[]) {

        Person focus = new Person();
        
        JFrame frame = new JFrame("Team6 Family Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.getContentPane().setLayout(null);

        JPopupMenu pm = new JPopupMenu("Menü");

        JMenuItem cut = new JMenuItem("Kes");
        JMenuItem copy = new JMenuItem("Kopyala");
        JMenuItem paste = new JMenuItem("Yapıştır");

        pm.add(cut);
        pm.add(copy);
        pm.add(paste);

        frame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                pm.show(frame, e.getX(), e.getY());
            }

        });

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

        YourInfo = new JButton("");
        YourInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        YourInfo.setBounds(493, 175, 131, 50);
        frame.getContentPane().add(YourInfo);

        JPanel panel = new JPanel();
        panel.setBounds(10, 40, 205, 620);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("Ebeveyn Ekle:");
        btnNewButton.setBounds(10, 263, 161, 21);
        panel.add(btnNewButton);

        JButton btnAddButton = new JButton("Soy A\u011Fac\u0131na Ekle");
        btnAddButton.setBounds(10, 205, 180, 25);
        panel.add(btnAddButton);

        JLabel lblNewLabel_4 = new JLabel("Cinsiyet:");
        lblNewLabel_4.setBounds(10, 135, 70, 20);
        panel.add(lblNewLabel_4);
        JComboBox comboBox = new JComboBox(gender);
        comboBox.setBounds(90, 135, 100, 20);
        panel.add(comboBox);

        JLabel lblNewLabel_3 = new JLabel("Do\u011Fum tarihi:");
        lblNewLabel_3.setBounds(10, 105, 70, 20);
        panel.add(lblNewLabel_3);

        /*tfDate = new JTextField();
        tfDate.setBounds(90, 105, 100, 20);
        panel.add(tfDate);
        tfDate.setColumns(10);
*/
        JLabel lblNewLabel_2 = new JLabel("Soyisim:");
        lblNewLabel_2.setBounds(10, 75, 70, 20);
        panel.add(lblNewLabel_2);

        tfSurname = new JTextField();
        tfSurname.setBounds(90, 75, 100, 20);
        panel.add(tfSurname);
        tfSurname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
                    e.consume(); // ignore the event if it's not an alphabet
                }
            }
        });
        tfSurname.setColumns(10);

        tfName = new JTextField();
        tfName.setBounds(90, 45, 100, 20);
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
        lblNewLabel_1.setBounds(10, 45, 70, 20);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("Bilgiler:");
        lblNewLabel.setBounds(60, 10, 80, 15);
        panel.add(lblNewLabel);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblNewLabel_5 = new JLabel("Aile \u0130li\u015Fkileri:");
        lblNewLabel_5.setBounds(79, 240, 80, 13);
        panel.add(lblNewLabel_5);

        JButton btnNewButton_1 = new JButton("Partner Ekle:");
        btnNewButton_1.setBounds(10, 291, 161, 21);
        panel.add(btnNewButton_1);

        btnNewButton_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                focus.setIsim(tfName.getText());
                //focus = focus.getAnne().anne;

            }
        });

        JButton btnNewButton_2 = new JButton("\u00C7ocuk Ekle:");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_2.setBounds(10, 317, 161, 21);
        panel.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("K\u0131z/Erkek Karde\u015F Ekle:");
        btnNewButton_3.setBounds(10, 348, 161, 21);
        panel.add(btnNewButton_3);

        JButton SaveBtn = new JButton("Kaydet");
        SaveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Kaydedildi.");
            }
        });
        SaveBtn.setBounds(10, 516, 85, 21);
        panel.add(SaveBtn);

        JButton EditBtn = new JButton("D\u00FCzenle");
        EditBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Düzenlendi.");
            }

        });
        EditBtn.setBounds(10, 537, 85, 21);
        panel.add(EditBtn);

        JButton SearchBtn = new JButton("Ara");
        SearchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Sonuçlar.");
            }
        });
        SearchBtn.setBounds(10, 559, 85, 21);
        panel.add(SearchBtn);

        JCheckBox NewCheckBox = new JCheckBox("Vefat etti");
        NewCheckBox.setBounds(2, 161, 108, 21);
        panel.add(NewCheckBox);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.getCalendarButton().addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        dateChooser.setBounds(90, 104, 100, 20);
        panel.add(dateChooser);

        // button  for "Soy ağacına ekle" :
        btnAddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (NewCheckBox.isSelected()) {

                    String textName = tfName.getText();
                    String textSurname = tfSurname.getText();
                    Image img = new ImageIcon(gui.class.getResource("rip2.png")).getImage();
                    YourInfo.setIcon(new ImageIcon(img));
                    // riplabel.setBounds(485, 183, 45, 13);

                    YourInfo.setText(textName + " " + textSurname);

                } else {
                    String textName = tfName.getText();
                    String textSurname = tfSurname.getText();
                    YourInfo.setText(textName + " " + textSurname);
                }

                focus.setIsim(tfName.getText());
                focus.setSoyisim(tfSurname.getText());
                focus.setDogumYili(dateChooser.getDateFormatString());
                focus.setGender(comboBox.getSelectedItem().toString());
                focus.setHayattaMi(NewCheckBox.getText());

            }
        });

        frame.setVisible(true);
    }
}