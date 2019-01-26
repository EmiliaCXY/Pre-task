package src;

import Q1.Question1;
import src.Q2.Question2;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JTabbedPane sidebar;
    private JPanel question1;
    private JPanel question2;

    public MainFrame(String title){
        super(title);
        setLayout(new BorderLayout());


        setUpSidebar();

    }

    private void setUpSidebar(){
        sidebar = new JTabbedPane();
        sidebar.setSize(500,300);
        sidebar.setTabPlacement(JTabbedPane.TOP);
        loadTabs();
        add(sidebar,BorderLayout.CENTER);
    }

    private void loadTabs(){
        question1 = new Question1();
        question2 = new Question2();
        sidebar.add(question1,0);
        sidebar.add(question2,1);
        sidebar.setTitleAt(0,"question1");
        sidebar.setTitleAt(1,"question2");
    }
}
