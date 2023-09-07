package cn.edu.lcu.cs.designpattern.composite.district;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.*;

public class GUIClient extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTree districtTree;

    public GUIClient() {
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
        GUIClient dialog = new GUIClient();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("资源管理器");
        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("我的公文包");
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("我的电脑");
        DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("收藏夹");
        DefaultMutableTreeNode node4 = new DefaultMutableTreeNode("Readme");

        DefaultTreeModel treeModel  = new DefaultTreeModel(root);
        treeModel.insertNodeInto(node1, root, root.getChildCount());
        treeModel.insertNodeInto(node2, root, root.getChildCount());
        treeModel.insertNodeInto(node3, root, root.getChildCount());
        treeModel.insertNodeInto(node4, root, root.getChildCount());

        District districts = DistrictTreeBuilder.build();



        districtTree = new JTree();
        districtTree.setModel(treeModel);
    }


}
