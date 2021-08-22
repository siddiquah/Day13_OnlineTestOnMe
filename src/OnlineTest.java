
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    JLabel label;
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton btnNext, btnBookmark;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    OnlineTest(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        btnNext = new JButton("Next");
        btnBookmark = new JButton("Bookmark");
        btnNext.addActionListener(this);
        btnBookmark.addActionListener(this);
        add(btnNext);
        add(btnBookmark);
        set();
        label.setBounds(30, 40, 450, 20);
        radioButton[0].setBounds(50, 80, 450, 20);
        radioButton[1].setBounds(50, 110, 200, 20);
        radioButton[2].setBounds(50, 140, 200, 20);
        radioButton[3].setBounds(50, 170, 200, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnBookmark.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                btnNext.setEnabled(false);
                btnBookmark.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                btnBookmark.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "correct answers = " + count);
            System.exit(0);
        }
    }

    void set() {
        radioButton[4].setSelected(true);
        if (current == 0) {
            label.setText("Que1:  What is my full name? ");
            radioButton[0].setText("Siddiqui Anjum");
            radioButton[1].setText("Sidiqui Anjjum");
            radioButton[2].setText("Sidddiquah Anjum");
            radioButton[3].setText("Siddiquah Anjum");
        }
        if (current == 1) {
            label.setText("Que2:  What do i do the most?");
            radioButton[0].setText("Eating");
            radioButton[1].setText("Lazying");
            radioButton[2].setText("Reading...");
            radioButton[3].setText("All of the above");
        }
        if (current == 2) {
            label.setText("Que3:  What food do i love?");
            radioButton[0].setText("Healthy");
            radioButton[1].setText("Expensive");
            radioButton[2].setText("fast food");
            radioButton[3].setText("don't know...");
        }
        if (current == 3) {
            label.setText("Que4:  What is my nick name?");
            radioButton[0].setText("Munni");
            radioButton[1].setText("Appi");
            radioButton[2].setText("Bhens");
            radioButton[3].setText("All of the above");
        }
        if (current == 4) {
            label.setText("Que5:  What do i hate the most?");
            radioButton[0].setText("Studying");
            radioButton[1].setText("doing work");
            radioButton[2].setText("going out");
            radioButton[3].setText("getting up");
        }
        if (current == 5) {
            label.setText("Que6:  What do i like the most");
            radioButton[0].setText("binging anime/movie all night with bubu and bilu");
            radioButton[1].setText("ordering food");
            radioButton[2].setText("Reading mangas");
            radioButton[3].setText("sleeping and doing nothing");
        }

        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            radioButton[j].setBounds(50, 80 + i, 200, 20);
    }

    boolean check() {
        if (current == 0)
            return (radioButton[3].isSelected());
        if (current == 1)
            return (radioButton[3].isSelected());
        if (current == 2)
            return (radioButton[2].isSelected());
        if (current == 3)
            return (radioButton[3].isSelected());
        if (current == 4)
            return (radioButton[3].isSelected());
        if (current == 5)
            return (radioButton[0].isSelected());
        return false;
    }

    public static void main(String s[]) {
        new OnlineTest("Online Test Application on ME....");
    }

}