import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.WrappedPlainView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.EventQueue;
import com.toedter.calendar.JDateChooser;
import com.google.gson.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

class gui {

    
    private static JTextField tfName;
    private static JTextField textField_1;
    private static JTextField tfSurname;
    private static JLabel getYourName;
    private static JButton YourInfo;

    public static void main(String args[]) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        Person focus = new Person();
        Gson gson1 = new Gson();
        String ourdtfName = "C:/" + dtf.format(now) +".json";
        File JSONfile1 = new File(ourdtfName);
        try {
            JSONfile1.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
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
        mnıtmNewMenuItem_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
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

        String gender[] = { "KADIN", "ERKEK" };

        YourInfo = new JButton("");
        YourInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        YourInfo.setBounds(564, 235, 172, 66);
        frame.getContentPane().add(YourInfo);

        JPanel panel = new JPanel();
        panel.setBounds(21, 31, 205, 629);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JButton btnAddButton = new JButton("Soy A\u011Fac\u0131na Ekle");
        btnAddButton.setBounds(10, 205, 180, 25);
        panel.add(btnAddButton);

        JLabel lblNewLabel_4 = new JLabel("Cinsiyet:");
        lblNewLabel_4.setBounds(10, 135, 70, 20);
        panel.add(lblNewLabel_4);
        JComboBox comboBox = new JComboBox(gender);
        comboBox.setSelectedIndex(-1);
        comboBox.setBounds(90, 135, 100, 20);
        panel.add(comboBox);

        JLabel lblNewLabel_3 = new JLabel("Do\u011Fum tarihi:");
        lblNewLabel_3.setBounds(10, 105, 70, 20);
        panel.add(lblNewLabel_3);

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
                if (Character.isLowerCase(c)) {
                    e.setKeyChar(Character.toUpperCase(c));
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
                if (Character.isLowerCase(c)) {
                    e.setKeyChar(Character.toUpperCase(c));
                }
            }
        });
        tfName.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u0130sim:");
        lblNewLabel_1.setBounds(10, 45, 70, 20);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("Bilgiler:");
        lblNewLabel.setBounds(60, 10, 80, 20);
        panel.add(lblNewLabel);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JTree jTree1 = new JTree();

        jTree1.setModel(new DefaultTreeModel(
                new DefaultMutableTreeNode("Soy A\u011Fac\u0131") {
                    {
                        add(new DefaultMutableTreeNode("Ebevyn\t"));
                        add(new DefaultMutableTreeNode("Partner\t"));
                        add(new DefaultMutableTreeNode("\u00C7ocuk"));
                        add(new DefaultMutableTreeNode("Karde\u015F"));
                    }
                }));
        TreeSelectionModel smd = jTree1.getSelectionModel();

        JButton SaveBtn = new JButton("Soy A\u011Fac\u0131n\u0131 Kaydet");
        SaveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Kaydedildi.");
            }
        });
        SaveBtn.setBounds(10, 345, 180, 25);
        panel.add(SaveBtn);

        JButton EditBtn = new JButton("Soy A\u011Fac\u0131n\u0131 D\u00FCzenle");
        EditBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getSelectionPath()
                        .getLastPathComponent();

                String nameTree = tfName.getText();
                String snameTree = tfSurname.getText();
                String info = nameTree.concat(" " + snameTree);

                selectedNode.setUserObject(info);

                DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();

                model.reload();

                JOptionPane.showMessageDialog(frame, "Düzenlendi.");
            }

        });
        EditBtn.setBounds(10, 240, 180, 25);
        panel.add(EditBtn);

        JButton SearchBtn = new JButton("Soy A\u011Fac\u0131nda Ara");
        SearchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Sonuçlar.");
            }
        });
        SearchBtn.setBounds(10, 310, 180, 25);
        panel.add(SearchBtn);

        JCheckBox NewCheckBox = new JCheckBox("Vefat etti");
        NewCheckBox.setBounds(10, 165, 108, 21);
        panel.add(NewCheckBox);

        JDateChooser dateChooser = new JDateChooser();

        dateChooser.getCalendarButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        dateChooser.setBounds(90, 104, 100, 20);
        panel.add(dateChooser);

        JButton btnDelete = new JButton("Soy A\u011Fac\u0131ndan Kald\u0131r");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getSelectionPath()
                        .getLastPathComponent();
                DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
                model.removeNodeFromParent(selectedNode);

                model.reload();

            }
        });
        btnDelete.setBounds(10, 275, 180, 25);
        panel.add(btnDelete);

        JLabel nameInfo = new JLabel("\u0130sim ve soyisim:");
        nameInfo.setBounds(10, 413, 95, 13);
        panel.add(nameInfo);

        JLabel dateInfo = new JLabel("Do\u011Fum tarihi:");
        dateInfo.setBounds(10, 454, 95, 13);
        panel.add(dateInfo);

        JLabel genderInfo = new JLabel("Cinsiyet:");
        genderInfo.setBounds(10, 477, 70, 13);
        panel.add(genderInfo);

        JLabel deadInfo = new JLabel("Durum:");
        deadInfo.setBounds(10, 500, 70, 13);
        panel.add(deadInfo);

        JLabel membersInfo = new JLabel("Aile Bireyi Bilgileri:");
        membersInfo.setBounds(61, 391, 94, 13);
        panel.add(membersInfo);

        JLabel getNameInfo = new JLabel("");
        getNameInfo.setBounds(10, 431, 162, 13);
        panel.add(getNameInfo);

        JLabel getDateInfo = new JLabel("");
        getDateInfo.setBounds(110, 448, 95, 25);
        panel.add(getDateInfo);

        JLabel getGenderInfo = new JLabel("");
        getGenderInfo.setBounds(110, 477, 62, 13);
        panel.add(getGenderInfo);

        JLabel getDeadInfo = new JLabel("");
        getDeadInfo.setBounds(110, 500, 62, 13);
        panel.add(getDeadInfo);

        // button for "Soy ağacına ekle" :
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
                SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
                String date = dcn.format(dateChooser.getDate() );
                focus.setDogumYili(date);
                focus.setGender((String)comboBox.getSelectedItem());
                focus.setHayattaMi(NewCheckBox.getText());

                try (FileWriter writer1 = new FileWriter(ourdtfName)) {
                    gson1.toJson(focus, writer1);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                // creating tree structure and 
                //adding person to under the root which selected in tree.

                if (smd.getSelectionCount() > 0) {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getSelectionPath()
                            .getLastPathComponent();

                    String nameTree = tfName.getText();
                    String snameTree = tfSurname.getText();
                    String info = nameTree.concat(" " + snameTree);

                    DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(info);

                    selectedNode.add(newNode);

                    DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();

                    jTree1.addMouseListener(new MouseAdapter() {

                        @Override
                        public void mouseClicked(MouseEvent e) {
                            TreePath[] paths = jTree1.getSelectionPaths();
                            for (TreePath path : paths != null ? paths : new TreePath[0]) {
                                // System.out.println("You've selected: " + path.getLastPathComponent());
                                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path
                                        .getLastPathComponent();
                                getNameInfo.setText(nameTree + " " + snameTree + " " + path.getLastPathComponent());
                                Date dateTree = dateChooser.getDate();
                                SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yy");

                                getDateInfo.setText(sf.format(dateTree) + " " + path.getLastPathComponent());

                                getGenderInfo.setText(
                                        comboBox.getSelectedItem().toString() + " " + path.getLastPathComponent());
                                if (NewCheckBox.isSelected()) {
                                    getDeadInfo.setText(
                                            NewCheckBox.getActionCommand() + " " + path.getLastPathComponent());
                                }

                            }

                            /*
                             * DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)
                             * jTree1.getSelectionPath().getLastPathComponent();
                             * getNameInfo.setText(nameTree + " " +
                             * snameTree+jTree1.getSelectionPath().getLastPathComponent());
                             * 
                             * Date dateTree=dateChooser.getDate();
                             * SimpleDateFormat sf=new
                             * SimpleDateFormat("dd-MM-yy"+jTree1.getSelectionPath().getLastPathComponent())
                             * ;
                             * 
                             * getDateInfo.setText(sf.format(dateTree)+jTree1.getSelectionPath().
                             * getLastPathComponent());
                             * 
                             * getGenderInfo.setText(comboBox.getSelectedItem().toString()+jTree1.
                             * getSelectionPath().getLastPathComponent());
                             * 
                             * if(NewCheckBox.isSelected()) {
                             * getDeadInfo.setText(NewCheckBox.getActionCommand()+jTree1.getSelectionPath().
                             * getLastPathComponent());
                             * }
                             */

                        }
                    });

                    model.reload();
                }
            }
        });

        jTree1.setBounds(231, 31, 154, 629);
        frame.getContentPane().add(jTree1);

        frame.setVisible(true);
    }
}