import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankBalanceApp extends JFrame implements ActionListener {
    private JTextField balanceField;
    private JButton depositButton;
    private JButton withdrawButton;

    private double balance = 0.0;

    public BankBalanceApp() {
        setTitle("Bank Balance Application");
        setSize(340, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        balanceField = new JTextField("Balance: $" + balance);
        balanceField.setEditable(false);
        panel.add(balanceField);

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);
        panel.add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);
        panel.add(withdrawButton);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            String depositInput = JOptionPane.showInputDialog(this, "Enter how much you want to deposit:");
            try {
                double depositAmount = Double.parseDouble(depositInput);
                balance += depositAmount;
                updateBalance();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid! Please enter a valid number.");
            }
        } else if (e.getSource() == withdrawButton) {
            String withdrawInput = JOptionPane.showInputDialog(this, "Enter how much you want to withdraw:");
            try {
                double withdrawAmount = Double.parseDouble(withdrawInput);
                if (withdrawAmount > balance) {
                    JOptionPane.showMessageDialog(this, "Insufficient balance");
                } else {
                    balance -= withdrawAmount;
                    updateBalance();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid! Please enter a valid number.");
            }
        }
    }

    private void updateBalance() {
        balanceField.setText("Balance: $" + balance);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BankBalanceApp().setVisible(true);
            }
        });
    }
}
