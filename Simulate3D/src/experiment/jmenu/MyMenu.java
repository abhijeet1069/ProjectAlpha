package experiment.jmenu;

import javax.swing.*;
import java.awt.event.*;

public class MyMenu extends JFrame implements ActionListener {

    public MyMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        saveMenuItem.addActionListener(this); // Add event listener to Save menu item

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        setTitle("My Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Save")) { // Check which menu item was clicked
            // Handle Save action here
            JOptionPane.showMessageDialog(this, "File saved successfully!");
        }
    }

    public static void main(String[] args) {
        new MyMenu();
    }
}
