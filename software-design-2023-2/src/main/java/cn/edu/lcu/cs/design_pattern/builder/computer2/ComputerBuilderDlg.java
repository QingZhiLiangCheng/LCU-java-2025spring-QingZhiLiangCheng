package cn.edu.lcu.cs.design_pattern.builder.computer2;

import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class ComputerBuilderDlg extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBrand;
    private JComboBox comboCpu;
    private JComboBox comboMemory;
    private JComboBox comboDisk;
    private JComboBox comboVideoCard;
    private JComboBox comboDisplay;
    private JComboBox comboOs;

    public ComputerBuilderDlg() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String brand = (String) comboBrand.getSelectedItem();
                if ("戴尔".equals(brand)) {
                    Director director = new Director(new DellBuilder());

                    Map<String, String> config = new HashMap<>();
                    config.put("cpu", (String) comboCpu.getSelectedItem());
                    config.put("memory", (String) comboMemory.getSelectedItem());
                    config.put("disk", (String) comboDisk.getSelectedItem());
                    config.put("videoCard", (String) comboVideoCard.getSelectedItem());
                    config.put("display", (String) comboDisplay.getSelectedItem());
                    config.put("os", (String) comboOs.getSelectedItem());

                    director.construct(config);
                    Computer computer = director.getComputer();
                    JOptionPane.showMessageDialog(null, computer.toString());
                }
                // 其它品牌的分支略去
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ComputerBuilderDlg dialog = new ComputerBuilderDlg();
        dialog.setTitle("电脑组装");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
