package com.company;

import javax.swing.*;
import java.awt.*;

public class TODOlist
{

    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame    F    =    new    JFrame();
            F.setTitle("TODO list");
            F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            F.getContentPane().setLayout(new BorderLayout());

            final DefaultListModel<String>    M    = new DefaultListModel<>();
            final JList<String>               L    = new JList<>(M);
            final JTextField                  T    =    new    JTextField();
            JButton                           B    =    new    JButton("Remove selected line");

            F.getContentPane().add(new JScrollPane(L));
            F.getContentPane().add(T,BorderLayout.NORTH);
            F.getContentPane().add(B,BorderLayout.SOUTH);
            // ADD LISTENER TO TEXTFIELD T
            //adds a simple action listener because the return is the default action
            T.addActionListener(e -> {
                M.add(M.getSize(),"- " + T.getText());
                T.setText("");
            });

            // ADD LISTENER TO BUTTON B
            B.addActionListener(e -> {
                for(int i = L.getSelectedIndices().length - 1; i >= 0; i--){
                    M.remove(L.getSelectedIndices()[i]);
                }
            });

            F.setSize(400,400);
            F.setVisible(true);

        });
    }
}