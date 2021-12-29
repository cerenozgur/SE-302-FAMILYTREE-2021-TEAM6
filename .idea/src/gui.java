import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class gui {
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
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
        
        JLabel lblNewLabel = new JLabel("ME");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(50, 50, 50, 15);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("\u0130sim:");
        lblNewLabel_1.setBounds(10, 85, 50, 15);
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Soyisim:");
        lblNewLabel_2.setBounds(10, 110, 50, 15);
        frame.getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Do\u011Fum tarihi:");
        lblNewLabel_3.setBounds(10, 135, 68, 15);
        frame.getContentPane().add(lblNewLabel_3);
        
        textField = new JTextField();
        textField.setBounds(90, 85, 96, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(90, 110, 96, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(90, 135, 96, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Cinsiyet:");
        lblNewLabel_4.setBounds(10, 160, 49, 14);
        frame.getContentPane().add(lblNewLabel_4);
        
        String gender[] = {"Kadın", "Erkek"};
        JComboBox comboBox = new JComboBox(gender);
        comboBox.setBounds(90, 160, 96, 22);
        frame.getContentPane().add(comboBox);
        
        JButton btnNewButton = new JButton("Soy A\u011Fac\u0131na Ekle");
        btnNewButton.setBounds(36, 205, 150, 23);
        btnNewButton.setBounds(10, 200, 176, 25);
        frame.getContentPane().add(btnNewButton);

        frame.setVisible(true);
    }
}