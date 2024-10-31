import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class MainWin extends JFrame implements ActionListener {
        JButton cButton, equalButton, plusButton, minusButton, multButton, divButton, decimalButton;
        JButton[] operButtons;
        JTextField textField;
        ArrayList<Character> operationList = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));
        // Float oper1, oper2;
        MainWin()
        {
                JPanel mainPanel = new JPanel();
                JPanel numJPanel = new JPanel();
                JPanel operPanel = new JPanel();
                JPanel keyPanel = new JPanel();
                this.textField = new JTextField();
                this.textField.setSize(500, 100);
                this.textField.setFont(new Font("MV Boli", Font.BOLD, 20));
                mainPanel.setLayout(new BorderLayout(10, 10));
                numJPanel.setLayout(new GridLayout(4, 3, 10, 10));
                operPanel.setLayout(new GridLayout(4, 2, 10, 10));
                keyPanel.setLayout(new GridLayout(1, 2, 10, 10));
                // operPanel.setSize(200, 500);
                for (Integer i = 0; i <= 9; i++)
                {
                        JButton numButton = new JButton();
                        numButton.setText(i.toString());
                        // this.numButton.setSize(40, 40);
                       numButton.setPreferredSize(new Dimension(40, 40));
                       numButton.setForeground(Color.WHITE);
                       numButton.setBackground(new Color(23, 23, 23, 255));
                       numJPanel.add(numButton);
                       numButton.addActionListener(e -> this.textField.setText(this.textField.getText() + numButton.getText()));
                }
                cButton = new JButton("C");
                equalButton = new JButton("=");
                plusButton = new JButton("+");
                minusButton = new JButton("-");
                multButton = new JButton("*");
                divButton = new JButton("/");
                decimalButton = new JButton(".");

                cButton.addActionListener(this);
                equalButton.addActionListener(this);
                plusButton.addActionListener(this);
                minusButton.addActionListener(this);
                multButton.addActionListener(this);
                divButton.addActionListener(this);
                decimalButton.addActionListener(this);

                cButton.setBackground(new Color(23, 23, 23, 255));
                equalButton.setBackground(Color.GREEN);
                plusButton.setBackground(new Color(23, 23, 23, 255));
                minusButton.setBackground(new Color(23, 23, 23, 255));
                multButton.setBackground(new Color(23, 23, 23, 255));
                divButton.setBackground(new Color(23, 23, 23, 255));
                decimalButton.setBackground(new Color(23, 23, 23, 255));

                cButton.setForeground(Color.RED);
                equalButton.setForeground(Color.WHITE);
                plusButton.setForeground(Color.WHITE);
                minusButton.setForeground(Color.WHITE);
                multButton.setForeground(Color.WHITE);
                divButton.setForeground(Color.WHITE);
                decimalButton.setForeground(Color.WHITE);

                operButtons = new JButton[] {this.plusButton, this.minusButton, this.multButton, this.divButton};
                
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setSize(400, 400);
                this.setResizable(true);
                this.setVisible(true);
                operPanel.add(cButton);
                operPanel.add(equalButton);
                operPanel.add(plusButton);
                operPanel.add(minusButton);
                operPanel.add(multButton);
                operPanel.add(divButton);
                operPanel.add(decimalButton);
                mainPanel.add(textField, BorderLayout.NORTH);
                keyPanel.add(numJPanel);
                keyPanel.add(operPanel);
                mainPanel.add(keyPanel);
                operPanel.setBackground(Color.BLACK);
                numJPanel.setBackground(Color.BLACK);
                keyPanel.setBackground(Color.BLACK);
                mainPanel.setBackground(Color.BLACK);
                this.add(mainPanel);
        }
        @Override
        public void actionPerformed(ActionEvent e)
        {
                if (e.getSource() == this.cButton)
                        this.textField.setText("");
                else if (e.getSource() == this.decimalButton && this.textField.getText().length() != 0)
                        this.textField.setText(this.textField.getText() + ".");
                else if (e.getSource() == this.equalButton)
                        eval();
                else
                {
                        for (JButton button: this.operButtons)
                        {
                                if (e.getSource() == button)
                                {
                                        boolean EVAL_SUCCESS = true;
                                        if (this.textField.getText().contains("+") || this.textField.getText().contains("-") || this.textField.getText().contains("*") || this.textField.getText().contains("/"))
                                                EVAL_SUCCESS = eval();
                                        if (EVAL_SUCCESS)
                                                this.textField.setText(this.textField.getText() + button.getText());
                                }
                        }
                }
        }
        public boolean eval()
        {
                Float res;
                for (int i = 0; i < this.textField.getText().length(); i++)
                {
                        if (this.textField.getText().charAt(i) == '+')
                        {
                                try
                                {
                                        res = Float.parseFloat(this.textField.getText().substring(0, i)) + Float.parseFloat(this.textField.getText().substring(i+1, this.textField.getText().length()));
                                        this.textField.setText(res.toString());
                                }
                                catch (Exception e)
                                {
                                        System.out.println("Exception occured");
                                        JOptionPane.showMessageDialog(this, "Enter valid expression", "Invalid Expression", JOptionPane.INFORMATION_MESSAGE);
                                        return false;
                                }
                        }
                        else if (this.textField.getText().charAt(i) == '-')
                        {
                                try
                                {
                                        res = Float.parseFloat(this.textField.getText().substring(0, i)) - Float.parseFloat(this.textField.getText().substring(i+1, this.textField.getText().length()));
                                        this.textField.setText(res.toString());
                                }
                                catch (Exception e)
                                {
                                        System.out.println("Exception occured");
                                        JOptionPane.showMessageDialog(this, "Enter valid expression", "Invalid Expression", JOptionPane.INFORMATION_MESSAGE);
                                        return false;
                                }
                        }
                        else if (this.textField.getText().charAt(i) == '*')
                        {
                                try
                                {
                                        res = Float.parseFloat(this.textField.getText().substring(0, i)) * Float.parseFloat(this.textField.getText().substring(i+1, this.textField.getText().length()));
                                        this.textField.setText(res.toString());
                                }
                                catch (Exception e)
                                {
                                        System.out.println("Exception occured");
                                        JOptionPane.showMessageDialog(this, "Enter valid expression", "Invalid Expression", JOptionPane.INFORMATION_MESSAGE);
                                        return false;
                                }
                        }
                        else if (this.textField.getText().charAt(i) == '/')
                        {
                                try
                                {
                                        res = Float.parseFloat(this.textField.getText().substring(0, i)) / Float.parseFloat(this.textField.getText().substring(i+1, this.textField.getText().length()));
                                        this.textField.setText(res.toString());
                                }
                                catch (Exception e)
                                {
                                        System.out.println("Exception occured");
                                        JOptionPane.showMessageDialog(this, "Enter valid expression", "Invalid Expression", JOptionPane.INFORMATION_MESSAGE);
                                        return false;
                                }
                        }
                        // if (operationList.contains(this.textField.getText().charAt(i)))
                        // {
                        //         String o1 = this.textField.getText().substring(0, i);
                        //         String o2 = this.textField.getText().substring(i+1, this.textField.getText().length());
                        //         res = Float.parseFloat(o1);
                        // }
                }
                return true;
        }
}
