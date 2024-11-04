import javax.swing.*;

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

 class Constants {
         public static final int SIN = 0;
         public static final int COS = 1;
         public static final int TAN = 2;
         public static final int ASIN = 3;
         public static final int ACOS = 4;
         public static final int ATAN = 5;
         public static final int SQRT = 6;
         public static final int LOG = 7;
         public static final int LOG10 = 8;
}

public class MainWin extends JFrame implements ActionListener {
//         ImageIcon ic
        JPanel mainPanel, numJPanel, operPanel, keyPanel, scientJPanel, inputPanel;
        JButton cButton, equalButton, plusButton, minusButton, multButton, divButton, decimalButton;
        JButton sinButton, cosButton, tanButton, asinButton, acosButton, atanButton, sqrtButton, logButton, log10Button;
        JButton[] operButtons, keypadButtons, scientButtons;
        JTextField textField, subField;
        JMenuBar menuBar;
        JMenu optionMenu;
        JMenuItem programmingItem, exitItem;
        boolean subMode = false;
        int MODE = -1;
        ArrayList<Character> operationList = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));
        private boolean evalSuccess;
        // Float oper1, oper2;
        // MainWin()
        // {
        //         menuBar = new JMenuBar();
        //         optionMenu = new JMenu("Options");
        //         programmingItem = new JMenuItem("Scientific Mode");
        //         exitItem = new JMenuItem("Exit");

        //         menuBar.add(optionMenu);
        //         optionMenu.add(programmingItem);
        //         optionMenu.add(exitItem);
        //         programmingItem.addActionListener(this);
        //         exitItem.addActionListener(this);

        //         mainPanel = new JPanel();
        //         numJPanel = new JPanel();
        //         operPanel = new JPanel();
        //         keyPanel = new JPanel();
        //         this.textField = new JTextField();
        //         this.textField.setSize(500, 100);
        //         this.textField.setFont(new Font("MV Boli", Font.BOLD, 20));
        //         mainPanel.setLayout(new BorderLayout(10, 10));
        //         numJPanel.setLayout(new GridLayout(4, 3, 10, 10));
        //         operPanel.setLayout(new GridLayout(4, 2, 10, 10));
        //         keyPanel.setLayout(new GridLayout(1, 3, 10, 10));
        //         // operPanel.setSize(200, 500);
        //         for (Integer i = 0; i <= 9; i++)
        //         {
        //                 JButton numButton = new JButton();
        //                 numButton.setText(i.toString());
        //                 // this.numButton.setSize(40, 40);
        //                numButton.setPreferredSize(new Dimension(40, 40));
        //                numButton.setForeground(Color.WHITE);
        //                numButton.setBackground(new Color(23, 23, 23, 255));
        //                numJPanel.add(numButton);
        //                numButton.addActionListener(e -> this.textField.setText(this.textField.getText() + numButton.getText()));
        //         }

        //         cButton = new JButton("C");
        //         equalButton = new JButton("=");
        //         plusButton = new JButton("+");
        //         minusButton = new JButton("-");
        //         multButton = new JButton("*");
        //         divButton = new JButton("/");
        //         decimalButton = new JButton(".");

        //         keypadButtons = new JButton[] {this.cButton, this.equalButton, this.plusButton, this.minusButton, this.multButton, this.divButton, this.decimalButton};
        //         trignoButtons = new JButton[] {this.sinButton, this.cosButton, this.tanButton, this.asinButton, this.acosButton, this.atanButton};
        //         buttonsInit();

        //         operButtons = new JButton[] {this.plusButton, this.minusButton, this.multButton, this.divButton};
                
        //         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //         this.setSize(400, 400);
        //         this.setResizable(true);
        //         this.setVisible(true);
        //         for (JButton button: keypadButtons)
        //                 operPanel.add(button);
        //         mainPanel.add(textField, BorderLayout.NORTH);
        //         keyPanel.add(numJPanel);
        //         keyPanel.add(operPanel);
        //         mainPanel.add(keyPanel);
        //         operPanel.setBackground(Color.BLACK);
        //         numJPanel.setBackground(Color.BLACK);
        //         keyPanel.setBackground(Color.BLACK);
        //         mainPanel.setBackground(Color.BLACK);
        //         this.add(mainPanel);
        //         this.setJMenuBar(menuBar);
        // }
        public void buttonsInit()
        {
                for (JButton button: keypadButtons)
                {
                        button.addActionListener(this);
                        button.setBackground(new Color(23, 23, 23, 255));
                        button.setForeground(Color.WHITE);
                }
                equalButton.setBackground(Color.GREEN);
                cButton.setForeground(Color.RED);
        }
        @Override
        public void actionPerformed(ActionEvent e)
        {
                if (e.getSource() == this.exitItem)
                        System.exit(ABORT);
                else if (e.getSource() == this.sinButton)
                        System.out.println("sin");
                else if (e.getSource() == this.programmingItem)
                {
                        ScientificMode.ScientificMode_Init(this);
//                         new ScientificMode(this);
//                        System.out.println("sin added");
//                        sinButton = new JButton("sin(X)");
//                        scientJPanel = new JPanel();
//                        scientJPanel.setLayout(new GridLayout(1, 1, 10, 10));
//                        scientJPanel.add(sinButton);
//                        mainPanel.add(scientJPanel, BorderLayout.EAST);
//                        mainPanel.revalidate();
//                        mainPanel.repaint();
                }
                        // JOptionPane.showMessageDialog(this, "Option is in developmet", "Hold on", JOptionPane.DEFAULT_OPTION);
                else if (e.getSource() == this.cButton)
                {
                        this.textField.setText("");
                        this.subField.setText("");
                }
                else if (e.getSource() == this.decimalButton && this.textField.getText().length() != 0)
                        this.textField.setText(this.textField.getText() + ".");
                else if (e.getSource() == this.equalButton)
                {
                        if (this.MODE == -1)
                                eval();
                        else
                        {
                                this.textField.setText(this.textField.getText() + Double.toString(ScientificMode.evalMath(this)));
                                subMode = false;
                                MODE = -1;
                        }
                        this.subField.setText("");
                }
                else
                {
                        for (JButton button: this.operButtons)
                        {
                                if (e.getSource() == button)
                                {
                                        boolean evalSuccess = true;
                                        if (this.textField.getText().contains("+") || this.textField.getText().contains("*") || this.textField.getText().contains("-") || this.textField.getText().contains("/"))
                                                evalSuccess = eval();
                                        if (evalSuccess)
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
                        if (this.textField.getText().charAt(i) == '+' && i != 0)
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
                        else if (this.textField.getText().charAt(i) == '-' && i != 0)
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
                }
                return true;
        }
}
