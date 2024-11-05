import java.awt.*;

import javax.swing.*;

public class ScientificMode extends BasicModeWin {

    public static double evalMath(MainWin win)
    {
        return switch (win.MODE)
        {
            case 0 -> Math.sin(Double.parseDouble(win.subField.getText()) * (Math.PI / 180));
            case 1 -> Math.cos(Double.parseDouble(win.subField.getText()) * (Math.PI / 180));
            case 2 -> Math.tan(Double.parseDouble(win.subField.getText()) * (Math.PI / 180));
            case 3 -> Math.asin(Double.parseDouble(win.subField.getText()) * (Math.PI / 180));
            case 4 -> Math.acos(Double.parseDouble(win.subField.getText()) * (Math.PI / 180));
            case 5 -> Math.atan(Double.parseDouble(win.subField.getText()) * (Math.PI / 180));
            case 6 -> Math.sqrt(Double.parseDouble(win.subField.getText()));
            case 7 -> Math.log(Double.parseDouble(win.subField.getText()));
            case 8 -> Math.log10(Double.parseDouble(win.subField.getText()));
            default -> 0.0;
        };
    }

    public static  void activateFuncMode(MainWin win)
    {
        win.subMode = true;
        win.equalButton.setText("↑");
        win.textField.setBackground(Color.GRAY);
        win.subField.setBackground(Color.WHITE);
    }

    public static void ScientificMode_Init(MainWin win)
    {
        win.sinButton = new JButton("sin(x)");
        win.cosButton = new JButton("cos(x)");
        win.tanButton = new JButton("tan(x)");
        win.asinButton = new JButton("asin(x)");
        win.acosButton = new JButton("acos(x)");
        win.atanButton = new JButton("atan(x)");
        win.sqrtButton = new JButton("sqrt(x)");
        win.logButton = new JButton("log(x)");
        win.log10Button = new JButton("log10(x)");
        win.scientButtons = new JButton[]{win.sinButton, win.cosButton, win.tanButton, win.asinButton, win.acosButton, win.atanButton, win.sqrtButton, win.logButton, win.log10Button};
        win.subField = new JTextField();
        win.subField.setBackground(Color.GRAY);
//        win.subField.addActionListener(e -> win.subField.setText(Double.toString(evalMath(win))));
        for (JButton button: win.scientButtons)
            button.setFont(new Font("Arial", Font.BOLD, 14));
        win.subField.addActionListener(e -> {
            if (win.MODE == -1)
                return;
            win.textField.setText(win.textField.getText() + Double.toString(evalMath(win)));
            win.subField.setText("");
            win.MODE = -1;
            win.subMode = false;
            win.equalButton.setText("=");
        });

        for (JButton button : win.scientButtons)
        {
            button.setSize(40, 40);
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(23, 23, 23, 255));
        }

        win.scientJPanel = new JPanel();
        win.scientJPanel.setLayout(new GridLayout(3, 3, 10, 10));
        win.scientJPanel.setBackground(Color.BLACK);

        win.sinButton.addActionListener(e -> {
            win.MODE = Constants.SIN;
            activateFuncMode(win);
        });
        win.cosButton.addActionListener(e -> {
            win.MODE = Constants.COS;
            activateFuncMode(win);
        });
        win.tanButton.addActionListener(e -> {
            win.MODE = Constants.TAN;
            activateFuncMode(win);
        });
        win.asinButton.addActionListener(e -> {
            win.MODE = Constants.ASIN;
            activateFuncMode(win);
        });
        win.acosButton.addActionListener(e -> {
            win.MODE = Constants.ACOS;
            activateFuncMode(win);
        });
        win.atanButton.addActionListener(e -> {
            win.MODE = Constants.ATAN;
            activateFuncMode(win);
        });
        win.sqrtButton.addActionListener(e -> {
            win.MODE = Constants.SQRT;
            activateFuncMode(win);
        });
        win.logButton.addActionListener(e -> {
            win.MODE = Constants.LOG;
            activateFuncMode(win);
        });
        win.log10Button.addActionListener(e -> {
            win.MODE = Constants.LOG10;
            activateFuncMode(win);
        });

        win.scientJPanel.add(win.sinButton);
        win.scientJPanel.add(win.cosButton);
        win.scientJPanel.add(win.tanButton);
        win.scientJPanel.add(win.asinButton);
        win.scientJPanel.add(win.acosButton);
        win.scientJPanel.add(win.atanButton);
        win.scientJPanel.add(win.sqrtButton);
        win.scientJPanel.add(win.logButton);
        win.scientJPanel.add(win.log10Button);
        win.mainPanel.add(win.scientJPanel, BorderLayout.EAST);
        win.inputPanel.add(win.subField);
        win.mainPanel.revalidate();
        win.mainPanel.repaint();
        win.setSize(800, 400);
    }

    ScientificMode(MainWin parentWin) {
    }
}
