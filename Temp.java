import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Temperature extends Thread {
    JFrame f1 = new JFrame();

    // f1.setVisible(true);
    Temperature() {
        f1.setResizable(false);
        f1.setSize(500, 500);
        f1.setLocation(350, 30);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pn = new JPanel();
        pn.setLayout(null);
        f1.add(pn);
        pn.setBackground(Color.BLACK);

        JLabel title = new JLabel();
        pn.add(title);
        title.setText("Temperature Converter");
        title.setFont(new Font("ITALIC", Font.BOLD, 40));
        title.setForeground(Color.RED);
        title.setBounds(30, 20, 500, 100);

        JLabel from = new JLabel();
        pn.add(from);
        from.setFont(new Font("ITALIC", Font.BOLD, 20));
        from.setText("From");
        from.setBounds(113, 145, 100, 30);
        from.setForeground(Color.RED);

        String[] options = { "Celcius", "Fahrenheit", "Kelvin" };
        JComboBox b1 = new JComboBox(options);
        pn.add(b1);

        b1.setBackground(Color.GREEN);

        JLabel to = new JLabel();
        pn.add(to);
        to.setFont(new Font("ITALIC", Font.BOLD, 20));
        to.setText("To");
        to.setBounds(383, 145, 100, 30);
        to.setForeground(Color.RED);

        options[0] = "Fahrenheit";
        options[1] = "Celcius";

        JComboBox b2 = new JComboBox(options);
        pn.add(b2);

        b2.setBackground(Color.GREEN);

        b1.setBounds(90, 180, 100, 30);
        b2.setBounds(320, 180, 155, 30);

        JTextField t1 = new JTextField();
        pn.add(t1);
        t1.setBounds(90, 215, 99, 30);
        t1.setFont(new Font("ITALIC", Font.BOLD, 30));

        JTextField t2 = new JTextField();
        pn.add(t2);
        t2.setBounds(320, 215, 155, 30);
        t2.setEditable(false);

        t2.setFont(new Font("ITALIC", Font.BOLD, 30));

        JButton bt1 = new JButton(
                "Convert");
        pn.add(bt1);
        bt1.setBounds(195, 280, 120, 40);
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.RED);
        bt1.setFont(new Font("ITALIC", Font.BOLD, 20));

        bt1.addActionListener(new ActionListener()

        {

            public void actionPerformed(ActionEvent e)

            {

                String ch1 = b1.getSelectedItem().toString();
                String ch2 = b2.getSelectedItem().toString();

                String str = t1.getText();
                int k = 0;
                t2.setText(t1.getText());
                if (t1.getText().isEmpty()) {
                    str = "0";
                    k = 1;

                }

                t2.setFont(new Font("ITALIC", Font.BOLD, 30));

                if (ch1 == ch2) {
                    t2.setText(str);
                }

                float input = Float.parseFloat(str);

                if (ch1 == "Celcius" && ch2 == "Fahrenheit") {
                    float r1 = (9 * input + 160) / 5;
                    String s1 = Float.toString(r1);
                    t2.setText(s1);

                }

                if (ch1 == "Fahrenheit" && ch2 == "Celcius") {
                    float r2 = (5 * input - 160) / 9;
                    String s2 = Float.toString(r2);
                    t2.setText(s2);

                }

                if (ch1 == "Celcius" && ch2 == "Kelvin") {
                    float r3 = input + 273;
                    String s3 = Float.toString(r3);
                    t2.setText(s3);

                }

                if (ch1 == "Kelvin" && ch2 == "Celcius") {
                    float r4 = input - 273;
                    String s4 = Float.toString(r4);
                    t2.setText(s4);
                }

                if (ch1 == "Kelvin" && ch2 == "Fahrenheit") {
                    float r5 = ((input - 273) * 9 + 160) / 5;
                    String s5 = Float.toString(r5);
                    t2.setText(s5);
                }

                if (ch1 == "Fahrenheit" && ch2 == "Kelvin") {
                    float r6 = (5 * input - 160) / 9 + 273;
                    String s6 = Float.toString(r6);
                    t2.setText(s6);
                }

                if (k == 1) {
                    t2.setFont(new Font("ITALIC", Font.BOLD, 15));
                    t2.setText("Invalid input");
                }

            }

        }

        );
    }

    public void run() {
        f1.setVisible(true);
    }
}

public class Temp {
    public static void main(String[] args) {
        Temperature t1 = new Temperature();
        t1.start();

    }
}