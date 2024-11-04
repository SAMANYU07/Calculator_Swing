import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

public class BasicModeWin extends MainWin {
        BasicModeWin()
        {
                menuBar = new JMenuBar();
                optionMenu = new JMenu("Options");
                programmingItem = new JMenuItem("Scientific Mode");
                exitItem = new JMenuItem("Exit");

                menuBar.add(optionMenu);
                optionMenu.add(programmingItem);
                optionMenu.add(exitItem);
                programmingItem.addActionListener(this);
                exitItem.addActionListener(this);

                mainPanel = new JPanel();
                numJPanel = new JPanel();
                operPanel = new JPanel();
                keyPanel = new JPanel();
                inputPanel = new JPanel();textField = new JTextField();
                textField.setSize(500, 100);
                textField.setFont(new Font("MV Boli", Font.BOLD, 20));
                mainPanel.setLayout(new BorderLayout(10, 10));
                numJPanel.setLayout(new GridLayout(4, 3, 10, 10));
                operPanel.setLayout(new GridLayout(4, 2, 10, 10));
                keyPanel.setLayout(new GridLayout(1, 3, 10, 10));
                inputPanel.setLayout(new GridLayout(2, 1, 10, 10));
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
                       numButton.addActionListener(e -> {
                               if (this.subMode)
                                       this.subField.setText(this.subField.getText() + numButton.getText());
                               else this.textField.setText(this.textField.getText() + numButton.getText());
                       });
                }

                cButton = new JButton("C");
                equalButton = new JButton("=");
                plusButton = new JButton("+");
                minusButton = new JButton("-");
                multButton = new JButton("*");
                divButton = new JButton("/");
                decimalButton = new JButton(".");

                keypadButtons = new JButton[] {this.cButton, this.equalButton, this.plusButton, this.minusButton, this.multButton, this.divButton, this.decimalButton};
//                scientButtons = new JButton[] {this.sinButton, this.cosButton, this.tanButton, this.asinButton, this.acosButton, this.atanButton, this.sqrtButton, this.logButton, log10Button};
                buttonsInit();

                operButtons = new JButton[] {this.plusButton, this.minusButton, this.multButton, this.divButton};
                
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setSize(400, 400);
                this.setResizable(true);
                this.setVisible(true);
                for (JButton button: keypadButtons)
                        operPanel.add(button);
//                mainPanel.add(textField, BorderLayout.NORTH);
                inputPanel.add(textField);
                mainPanel.add(inputPanel, BorderLayout.NORTH);
                keyPanel.add(numJPanel);
                keyPanel.add(operPanel);
                mainPanel.add(keyPanel);
                operPanel.setBackground(Color.BLACK);
                numJPanel.setBackground(Color.BLACK);
                keyPanel.setBackground(Color.BLACK);
                inputPanel.setBackground(Color.BLACK);
                mainPanel.setBackground(Color.BLACK);
                this.add(mainPanel);
                this.setJMenuBar(menuBar);
        }
}
