import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

class gui {

    public gui() {
        // currentFamilyTree = new FamilyTree();
        currentFile = null;
        tree = new JTree();
        createGUI();
    }

    private static JTextField tfName;
    private static JTextField textField_1;
    private static JTextField tfSurname;
    private static JTextField tfDate;
    private static JLabel getYourName;
    private static JButton YourInfo;
    private static JButton ParentInfo;

    private JFrame frame;

    private JPanel controlPanel;
    private JPanel infoPanel;
    private final JLabel statusLabel = new JLabel("Program loaded");
    private File currentFile;
    private JTree tree;

    private Ft currentFamilyTree;

    private void createGUI() {
        frame = new JFrame("Team6 Family Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);
        frame.setLayout(new BorderLayout());

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
        frame.getContentPane().setLayout(null);

        MenuBar();
        HeaderPanel();
        ControlPanel();
        StatusBar();
        displayTree(currentFamilyTree);

        frame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent windowEvent) {
                if (checkUserWantContinue()) {
                    System.exit(0);
                }
            }

        });

        frame.setVisible(true);
    }

    private void HeaderPanel() {

        JLabel startLabel = new JLabel("Hoşgeldiniz", JLabel.LEFT);
        startLabel.setFont(new Font("Serif", Font.PLAIN, 14));

        JButton loadTree = new JButton("Soyağacı Yükle");
        loadTree.addActionListener(new openFileAction());

        JButton createButton = new JButton("Yeni Soyağaçı oluştur");
        createButton.addActionListener(new newTreeAction());

        String gender[] = { "Kadın", "Erkek" };

        YourInfo = new JButton("");
        YourInfo.setBounds(488, 199, 131, 50);
        YourInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        frame.getContentPane().add(YourInfo);

        JPanel panel = new JPanel();
        panel.setBounds(10, 40, 205, 620);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        panel.setOpaque(false);

        JCheckBox NewCheckBox = new JCheckBox("Vefat etti");
        NewCheckBox.setBounds(2, 161, 108, 21);
        panel.add(NewCheckBox);

        JButton btnParent = new JButton("Ebeveyn Ekle:");
        btnParent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ParentInfo = new JButton("");

                if (gender.equals("Kadın")) {

                    if (NewCheckBox.isSelected()) {

                        String textName = tfName.getText();
                        String textSurname = tfSurname.getText();
                        Image img = new ImageIcon(gui.class.getResource("rip2.png")).getImage();
                        ParentInfo.setIcon(new ImageIcon(img));
                        // riplabel.setBounds(485, 183, 45, 13);

                        ParentInfo.setText(textName + " " + textSurname);

                    } else {
                        String textName = tfName.getText();
                        String textSurname = tfSurname.getText();
                        ParentInfo.setText(textName + " " + textSurname);
                    }

                }
            }
        });
        btnParent.setBounds(10, 263, 161, 21);
        panel.add(btnParent);

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

        tfDate = new JTextField();
        tfDate.setBounds(90, 105, 100, 20);
        panel.add(tfDate);
        tfDate.setColumns(10);

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

        // lastOptionPanel save edit search butonu için
        JPanel lastOptionPanel = new JPanel();
        lastOptionPanel.setBounds(-11, 522, 216, 88);
        panel.add(lastOptionPanel);
        lastOptionPanel.setLayout(new GridBagLayout());
        lastOptionPanel.setOpaque(false);
        lastOptionPanel.setBorder(new EmptyBorder(0, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(startLabel, gbc);

        JButton EditBtn = new JButton("D\u00FCzenle");

        GridBagConstraints gbc_EditBtn = new GridBagConstraints();
        gbc_EditBtn.gridx = 0;
        lastOptionPanel.add(EditBtn, gbc_EditBtn);
        EditBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Düzenlendi.");
            }

        });

        JButton SearchBtn = new JButton("Ara");
        lastOptionPanel.add(SearchBtn);
        SearchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Sonuçlar.");
            }
        });

        JButton SaveBtn = new JButton("Kaydet");
        // SaveBtn.addActionListener(new saveAction()); add save action meethod
        GridBagConstraints gbc_SaveBtn = new GridBagConstraints();
        gbc_SaveBtn.gridx = 2;
        lastOptionPanel.add(SaveBtn, gbc_SaveBtn);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(225, 44, 661, 616);
        frame.getContentPane().add(scrollPane);
        SaveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(frame, "Kaydedildi.");
            }
        });

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

            }
        });

    }

    private void MenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 900, 30);
        menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        frame.getContentPane().add(menuBar);

        JMenu fileMenu = new JMenu("Dosya");
        fileMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        menuBar.add(fileMenu);

        JMenuItem openFileAction = new JMenuItem("Aç");
        fileMenu.add(openFileAction);
        openFileAction.addActionListener(new openFileAction());

        JMenuItem newFileAction = new JMenuItem("Yeni");
        fileMenu.add(newFileAction);
        newFileAction.addActionListener(new newTreeAction());

        JMenuItem mnıtmNewMenuItem_2 = new JMenuItem("Çıkış");
        mnıtmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(JFrame.EXIT_ON_CLOSE);
            }
        });
        fileMenu.add(mnıtmNewMenuItem_2);

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

    }

    private class openFileAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (checkUserWantContinue()) {
                JFileChooser JFileChooser = new JFileChooser();
                // set file filters ??????
                JFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Takım 6 Soyağaçı Dosyaları", "ft"));
                JFileChooser.setAcceptAllFileFilterUsed(true);

                int result = JFileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        openFile(JFileChooser.getSelectedFile());
                        displayTree(currentFamilyTree);
                        // editStatus("Dosya: "+(JFileChooser.getSelectedFile().getAbsolutePath()));
                    } catch (Exception j) {
                        // error
                        showErrorDialog(j);
                        // editStatus("Error: " + j.getMessage());
                    }
                }
            }
        }
    }

    private void openFile(File file) {
        FileInputStream isFile = null;
        ObjectInputStream in = null;
        Ft ft = null;

        try {
            // set input streams
            isFile = new FileInputStream(file);
            in = new ObjectInputStream(isFile);
            // assign the obj
            ft = (Ft) in.readObject();
            in.close();

            currentFamilyTree.setRoot(ft.getRoot());
            currentFile = file;
            tree = new JTree();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Okunamayan dosya");
        }

    }

    private class newTreeAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (checkUserWantContinue()) {
                // tree saved? or reset
                currentFamilyTree = new Ft();
                currentFile = null;
                displayTree(currentFamilyTree);
                // editStatus("Boş soyağaçı oluşturuldu");

            }
        }

    }

    private void showErrorDialog(Exception e) {
        JOptionPane.showMessageDialog(frame, "Hata: " + e.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
    }

    private void ControlPanel() {
        controlPanel = new JPanel();
        // used to show white background from mainFrame
        controlPanel.setOpaque(false);
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        frame.add(controlPanel, BorderLayout.CENTER);

    }

    private boolean checkUserWantContinue() {
        if (currentFamilyTree.hasRoot()) {
            int dialog = JOptionPane.showConfirmDialog(frame, "Kaydetmeden çıkmak istediğine emin misin?",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            return dialog == JOptionPane.YES_OPTION;
        }
        return true;
    }

    // show the creating tree
    private class newTreeAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (checkUserWantContinue()) {
                currentFamilyTree = new Ft();
                currentFile = null;
                // empty tree
                displayTree(currentFamilyTree);
                // editStatus("Boş soyagaçı");

            }
        }

    }

    private class addRelativeAction implements ActionListener {

        private familyMembers member;

        public addRelativeAction(familyMembers member) {
            this.member = member;
        }

        @Override

        public void actionPerformed(ActionEvent e) {
            displayAddRelativeInfo(member);
        }
    }

    private void displayTree(Ft familyTree) {

    }

    private void displayAddRelativeInfo(familyMembers member) {
        tree.setEnabled(false);
        // reset info panel

    }

    public static void main(String args[]) {
        /*
         * JFrame frame = new JFrame("Team6 Family Tree");
         * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         * frame.setSize(900, 700);
         * frame.setLayout(new BorderLayout());
         * 
         * 
         * JPopupMenu pm=new JPopupMenu("Menü");
         * 
         * JMenuItem cut =new JMenuItem("Kes");
         * JMenuItem copy =new JMenuItem("Kopyala");
         * JMenuItem paste =new JMenuItem("Yapıştır");
         * 
         * pm.add(cut);
         * pm.add(copy);
         * pm.add(paste);
         * 
         * frame.addMouseListener(new MouseAdapter() {
         * public void mouseClicked(MouseEvent e) {
         * pm.show(frame,e.getX(),e.getY());
         * }
         * 
         * });
         * frame.getContentPane().setLayout(null);
         */

        /*
         * JMenuBar menuBar = new JMenuBar();
         * menuBar.setBounds(0, 0, 900, 30);
         * menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
         * frame.getContentPane().add(menuBar);
         * 
         * JMenu mnNewMenu = new JMenu("Dosya");
         * mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
         * menuBar.add(mnNewMenu);
         * 
         * JMenuItem mnıtmNewMenuItem = new JMenuItem("Aç");
         * mnNewMenu.add(mnıtmNewMenuItem);
         * 
         * JMenuItem mnıtmNewMenuItem_1 = new JMenuItem("Yeni");
         * mnNewMenu.add(mnıtmNewMenuItem_1);
         * 
         * JMenuItem mnıtmNewMenuItem_2 = new JMenuItem("Çıkış");
         * mnıtmNewMenuItem_2.addActionListener(new ActionListener() {
         * public void actionPerformed(ActionEvent e) {
         * System.exit(JFrame.EXIT_ON_CLOSE);
         * }
         * });
         * mnNewMenu.add(mnıtmNewMenuItem_2);
         * 
         * JMenu mnNewMenu_1 = new JMenu("Yardım");
         * mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
         * menuBar.add(mnNewMenu_1);
         * 
         * JMenuItem mnıtmNewMenuItem_3 = new JMenuItem("Hakkında");
         * mnNewMenu_1.add(mnıtmNewMenuItem_3);
         * 
         * JMenuItem mnıtmNewMenuItem_4 = new JMenuItem("Yardım");
         * mnNewMenu_1.add(mnıtmNewMenuItem_4);
         * textField_1 = new JTextField();
         * textField_1.addKeyListener(new KeyAdapter() {
         * 
         * @Override
         * public void keyTyped(KeyEvent e) {
         * char c = e.getKeyChar();
         * if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c ==
         * KeyEvent.VK_DELETE)) {
         * e.consume(); // ignore the event if it's not an alphabet
         * }
         * }
         * });
         * 
         * 
         * String gender[] = { "Kadın", "Erkek" };
         * 
         * YourInfo = new JButton("");
         * YourInfo.setBounds(488, 199, 131, 50);
         * YourInfo.addActionListener(new ActionListener() {
         * public void actionPerformed(ActionEvent e) {
         * 
         * }
         * });
         * frame.getContentPane().add(YourInfo);
         * 
         * JPanel panel = new JPanel();
         * panel.setBounds(10, 40, 205, 620);
         * frame.getContentPane().add(panel);
         * panel.setLayout(null);
         * 
         * JCheckBox NewCheckBox = new JCheckBox("Vefat etti");
         * NewCheckBox.setBounds(2, 161, 108, 21);
         * panel.add(NewCheckBox);
         * 
         * JButton btnParent = new JButton("Ebeveyn Ekle:");
         * btnParent.addActionListener(new ActionListener() {
         * public void actionPerformed(ActionEvent e) {
         * ParentInfo = new JButton("");
         * 
         * if (gender.equals("Kadın")) {
         * 
         * if (NewCheckBox.isSelected()) {
         * 
         * String textName = tfName.getText();
         * String textSurname = tfSurname.getText();
         * Image img = new ImageIcon(gui.class.getResource("rip2.png")).getImage();
         * ParentInfo.setIcon(new ImageIcon(img));
         * // riplabel.setBounds(485, 183, 45, 13);
         * 
         * ParentInfo.setText(textName + " " + textSurname);
         * 
         * } else {
         * String textName = tfName.getText();
         * String textSurname = tfSurname.getText();
         * ParentInfo.setText(textName + " " + textSurname);
         * }
         * 
         * }
         * }
         * });
         * btnParent.setBounds(10, 263, 161, 21);
         * panel.add(btnParent);
         * 
         * JButton btnAddButton = new JButton("Soy A\u011Fac\u0131na Ekle");
         * btnAddButton.setBounds(10, 205, 180, 25);
         * panel.add(btnAddButton);
         * 
         * JLabel lblNewLabel_4 = new JLabel("Cinsiyet:");
         * lblNewLabel_4.setBounds(10, 135, 70, 20);
         * panel.add(lblNewLabel_4);
         * JComboBox comboBox = new JComboBox(gender);
         * comboBox.setBounds(90, 135, 100, 20);
         * panel.add(comboBox);
         * 
         * JLabel lblNewLabel_3 = new JLabel("Do\u011Fum tarihi:");
         * lblNewLabel_3.setBounds(10, 105, 70, 20);
         * panel.add(lblNewLabel_3);
         * 
         * tfDate = new JTextField();
         * tfDate.setBounds(90, 105, 100, 20);
         * panel.add(tfDate);
         * tfDate.setColumns(10);
         * 
         * JLabel lblNewLabel_2 = new JLabel("Soyisim:");
         * lblNewLabel_2.setBounds(10, 75, 70, 20);
         * panel.add(lblNewLabel_2);
         * 
         * tfSurname = new JTextField();
         * tfSurname.setBounds(90, 75, 100, 20);
         * panel.add(tfSurname);
         * tfSurname.addKeyListener(new KeyAdapter() {
         * 
         * @Override
         * public void keyTyped(KeyEvent e) {
         * char c = e.getKeyChar();
         * if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c ==
         * KeyEvent.VK_DELETE)) {
         * e.consume(); // ignore the event if it's not an alphabet
         * }
         * }
         * });
         * tfSurname.setColumns(10);
         * 
         * tfName = new JTextField();
         * tfName.setBounds(90, 45, 100, 20);
         * panel.add(tfName);
         * tfName.addKeyListener(new KeyAdapter() {
         * 
         * @Override
         * public void keyTyped(KeyEvent e) {
         * char c = e.getKeyChar();
         * if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_BACK_SPACE) || c ==
         * KeyEvent.VK_DELETE)) {
         * e.consume(); // ignore the event if it's not an alphabet
         * }
         * }
         * });
         * tfName.setColumns(10);
         * 
         * JLabel lblNewLabel_1 = new JLabel("\u0130sim:");
         * lblNewLabel_1.setBounds(10, 45, 70, 20);
         * panel.add(lblNewLabel_1);
         * 
         * JLabel lblNewLabel = new JLabel("Bilgiler:");
         * lblNewLabel.setBounds(60, 10, 80, 15);
         * panel.add(lblNewLabel);
         * lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
         * 
         * JLabel lblNewLabel_5 = new JLabel("Aile \u0130li\u015Fkileri:");
         * lblNewLabel_5.setBounds(79, 240, 80, 13);
         * panel.add(lblNewLabel_5);
         * 
         * JButton btnNewButton_1 = new JButton("Partner Ekle:");
         * btnNewButton_1.setBounds(10, 291, 161, 21);
         * panel.add(btnNewButton_1);
         * 
         * JButton btnNewButton_2 = new JButton("\u00C7ocuk Ekle:");
         * btnNewButton_2.addActionListener(new ActionListener() {
         * public void actionPerformed(ActionEvent e) {
         * }
         * });
         * btnNewButton_2.setBounds(10, 317, 161, 21);
         * panel.add(btnNewButton_2);
         * 
         * JButton btnNewButton_3 = new JButton("K\u0131z/Erkek Karde\u015F Ekle:");
         * btnNewButton_3.setBounds(10, 348, 161, 21);
         * panel.add(btnNewButton_3);
         * 
         * JPanel headPanel = new JPanel();
         * headPanel.setBounds(-11, 522, 216, 88);
         * panel.add(headPanel);
         * headPanel.setLayout(new GridBagLayout());
         * headPanel.setOpaque(false);
         * headPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
         * 
         * GridBagConstraints gbc = new GridBagConstraints();
         * gbc.gridx = 0;
         * gbc.gridy = 0;
         * gbc.fill = GridBagConstraints.BOTH;
         * gbc.weightx = 1.0;
         * gbc.weighty = 1.0;
         * 
         * JButton EditBtn = new JButton("D\u00FCzenle");
         * GridBagConstraints gbc_EditBtn = new GridBagConstraints();
         * gbc_EditBtn.gridx = 0;
         * headPanel.add(EditBtn, gbc_EditBtn);
         * EditBtn.addActionListener(new ActionListener() {
         * public void actionPerformed(ActionEvent e) {
         * JOptionPane.showMessageDialog(frame, "Düzenlendi.");
         * }
         * 
         * });
         * 
         * JButton SearchBtn = new JButton("Ara");
         * headPanel.add(SearchBtn);
         * SearchBtn.addActionListener(new ActionListener() {
         * public void actionPerformed(ActionEvent e) {
         * JOptionPane.showMessageDialog(frame, "Sonuçlar.");
         * }
         * });
         * 
         * JButton SaveBtn = new JButton("Kaydet");
         * GridBagConstraints gbc_SaveBtn = new GridBagConstraints();
         * gbc_SaveBtn.gridx = 2;
         * headPanel.add(SaveBtn, gbc_SaveBtn);
         * 
         * JScrollPane scrollPane = new JScrollPane();
         * scrollPane.setBounds(225, 44, 661, 616);
         * frame.getContentPane().add(scrollPane);
         * SaveBtn.addActionListener(new ActionListener() {
         * public void actionPerformed(ActionEvent e) {
         * 
         * JOptionPane.showMessageDialog(frame, "Kaydedildi.");
         * }
         * });
         * 
         * btnAddButton.addActionListener(new ActionListener() {
         * public void actionPerformed(ActionEvent e) {
         * 
         * if (NewCheckBox.isSelected()) {
         * 
         * String textName = tfName.getText();
         * String textSurname = tfSurname.getText();
         * Image img = new ImageIcon(gui.class.getResource("rip2.png")).getImage();
         * YourInfo.setIcon(new ImageIcon(img));
         * // riplabel.setBounds(485, 183, 45, 13);
         * 
         * YourInfo.setText(textName + " " + textSurname);
         * 
         * } else {
         * String textName = tfName.getText();
         * String textSurname = tfSurname.getText();
         * YourInfo.setText(textName + " " + textSurname);
         * }
         * 
         * }
         * });
         * 
         * frame.setVisible(true);
         */
    }
}