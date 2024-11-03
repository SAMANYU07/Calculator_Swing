import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ScientificMode extends BasicModeWin {
        public static void ScientificMode_Init(MainWin win)
        {
                win.sinButton = new JButton("sin(x)");
                win.cosButton = new JButton("cos(x)");
                win.tanButton = new JButton("tan(x)");
                win.asinButton = new JButton("asin(x)");
                win.acosButton = new JButton("acos(x)");
                win.atanButton = new JButton("atan(x)");
                win.scientJPanel = new JPanel();
                win.scientJPanel.setLayout(new GridLayout(2, 3, 10, 10));
                win.scientJPanel.add(win.sinButton);
                win.scientJPanel.add(win.cosButton);
                win.scientJPanel.add(win.tanButton);
                win.scientJPanel.add(win.asinButton);
                win.scientJPanel.add(win.acosButton);
                win.scientJPanel.add(win.atanButton);
                win.mainPanel.add(win.scientJPanel, BorderLayout.EAST);
                win.mainPanel.revalidate();
                win.mainPanel.repaint();
        }
        ScientificMode(MainWin parentWin)
        {
        }
}
