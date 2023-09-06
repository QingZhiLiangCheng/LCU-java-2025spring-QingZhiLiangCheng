package cn.edu.lcu.cs.architecture.mvc.car;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CarAuctionGUI extends JFrame {
    private JTextField bitInputText;
    private JLabel lblCarModel;
    private JPanel buttonPanel;
    private String[] carList;
    private JComboBox cmbCarList;

    private static CarModel carModel;
    private static CarGUIInfoView guiInfoView;
    private static CarBitInfoView bitInfoView;

    public static final String SEARCH = "Search";
    public static final String BIT = "Bit";
    public static final String EXIT = "Exit";

    public CarAuctionGUI() {
        super("MVC pattern - with observer, 3 GUIs");
        setUpGUI();
    }

    private void setUpGUI() {
        cmbCarList = new JComboBox();
        String[] cl = getCarList();
        setUpComboBox(cl);

        lblCarModel = new JLabel("Cars on auction:");

        JButton srchButton = new JButton(SEARCH);
        srchButton.setMnemonic(KeyEvent.VK_S);
        JButton exitButton = new JButton(EXIT);
        exitButton.setMnemonic(KeyEvent.VK_X);

        JButton bitButton = new JButton(BIT);
        bitButton.setMnemonic(KeyEvent.VK_X);
        bitInputText = new JTextField("Offer your bit price", 12);
        buttonPanel = new JPanel();

        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        buttonPanel.add(lblCarModel);
        buttonPanel.add(cmbCarList);
        buttonPanel.add(srchButton);
        buttonPanel.add(bitButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(bitInputText);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblCarModel, gbc);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(cmbCarList, gbc);

        gbc.anchor = GridBagConstraints.EAST;

        gbc.insets.left = 2;
        gbc.insets.right = 2;
        gbc.insets.top = 25;
        gbc.anchor = GridBagConstraints.EAST;

        gbc.gridx = 0;
        gbc.gridy = 3;
        gridbag.setConstraints(srchButton, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gridbag.setConstraints(exitButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gridbag.setConstraints(bitButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gridbag.setConstraints(bitInputText, gbc);

        Controller objButtonHandler = new Controller(this, carModel, guiInfoView, bitInfoView);
        srchButton.addActionListener(objButtonHandler);
        exitButton.addActionListener(objButtonHandler);
        bitButton.addActionListener(objButtonHandler);

        Container contentPane = getContentPane();
        contentPane.add(buttonPanel);

        setSize(new Dimension(500, 350));
        setVisible(true);
        pack();
    }

    public String getSelectedCar() {
        return (String) cmbCarList.getSelectedItem();
    }

    public String getBitPrice() {
        return bitInputText.getText();
    }

    // get the names of all the .html files in a directory
    public String[] getCarList() {
        String pathName = "/car/CarFiles";
        String[] fileNames = new File(getClass().getResource(pathName).getPath()).list();

        for (int i = 0; i < fileNames.length; i++) {
            int len = fileNames[i].length();
            fileNames[i] = fileNames[i].substring(0, len - 5);
        }
        return fileNames;
    }

    public void setUpComboBox(String[] carList) {
        for (int k = 0; k < carList.length; k++) {
            cmbCarList.addItem(carList[k]);
        }
    }

    static public void main(String argv[]) {
        SwingUtilities.invokeLater(() -> {
            carModel = new CarModel();
            guiInfoView = new CarGUIInfoView(carModel);
            bitInfoView = new CarBitInfoView(carModel);
            carModel.register(guiInfoView);
            carModel.register(bitInfoView);

            CarAuctionGUI frame = new CarAuctionGUI();
            JFrame.setDefaultLookAndFeelDecorated(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}

