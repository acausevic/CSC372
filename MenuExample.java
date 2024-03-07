import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MenuExample extends JFrame {
    private JTextArea textBox;

    public MenuExample() {
        setTitle("Menu Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 350);

        textBox = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textBox);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Options");
        menuBar.add(menu);

        JMenuItem printDateTimeItem = new JMenuItem("Print Date and Time");
        printDateTimeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printDateTime();
            }
        });
        menu.add(printDateTimeItem);

        JMenuItem writeToLogFileItem = new JMenuItem("Write to log.txt");
        writeToLogFileItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                writeToLogFile();
            }
        });
        menu.add(writeToLogFileItem);

        JMenuItem changeBackgroundColorItem = new JMenuItem("Change Background Color");
        changeBackgroundColorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor();
            }
        });
        menu.add(changeBackgroundColorItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(exitItem);
    }

    private void printDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy 'at' hh:mm:ss a z");
        String dateTime = dateFormat.format(new Date());
        textBox.append(dateTime + "\n");
    }

    private void writeToLogFile() {
        String content = textBox.getText();
        try {
            FileWriter writer = new FileWriter("log.txt");
            writer.write(content);
            writer.close();
            JOptionPane.showMessageDialog(this, "Content written to log.txt successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to log.txt: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void changeBackgroundColor() {
        Random random = new Random();
        float hue = random.nextFloat();
        Color color = Color.getHSBColor(hue, 0.9f, 0.7f);
        getContentPane().setBackground(color);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MenuExample menuExample = new MenuExample();
                menuExample.setVisible(true);
            }
        });
    }
}
