import javax.swing.*;
import java.awt.*;

class gui {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Team6 Family Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Dosya");
        JMenu m2 = new JMenu("Yardım");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Yeni");
        JMenuItem m12 = new JMenuItem("Aç");
        JMenuItem m13 = new JMenuItem("Çıkış");
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);
        JMenuItem m21 = new JMenuItem("Yardım");
        JMenuItem m22 = new JMenuItem("Hakkında");
        m2.add(m21);
        m2.add(m22);

        frame.getContentPane().add(BorderLayout.PAGE_START, mb);

        frame.setVisible(true);
    }
}