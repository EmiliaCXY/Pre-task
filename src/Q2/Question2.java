package src.Q2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Question2 extends JPanel {

    JLabel prompt1;
    JLabel prompt2;
    JTextArea DNA1;
    JTextArea DNA2;
    JLabel k;
    JTextField kinput;
    JButton submit;
    JLabel resultLabel;
    JTextArea resultContent;
    ArrayList<Point> results;

    // A constructor for src.Q2 -- finding shared k mer
    public Question2(){
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        setSize(500,400);
        setVisible(true);
        setUpmain(gc);
    }

    // main method for finding shared k-mer
    // The basic idea is to chop dna1 and dna2 into fragments of k bases,
    // and compare to see whether there are the same fragments or complementary fragments in
    // dna2.
    // The method for comparing two fragments can be found in Fragment class
    private ArrayList<Point> findSharedKmer(String input1, String input2, int k) {
        results = new ArrayList<>();
        ArrayList<Fragment> f1 = slice(input1,k);
        ArrayList<Fragment> f2 = slice(input2,k);
        for(int x = 0; x < f1.size(); x++){
            for (int y = 0; y < f2.size(); y++){
                Fragment frag1 = f1.get(x);
                Fragment frag2 = f2.get(y);
                if(frag1.compare(frag2)){
                    Point match = new Point(frag1.getIndex(),frag2.getIndex());
                    results.add(match);
                }
            }
        }
        return results;
    }

    // EFFECT: chop the dna sequence into fragments of length k
    private ArrayList<Fragment> slice(String input, int k) {
        ArrayList<Fragment> fragments = new ArrayList<>();
        for(int x = 0; x+k<=input.length();x++){
            String frag = input.substring(x,x+k);
            Fragment f = new Fragment(frag,x);
            fragments.add(f);
        }
        return fragments;
    }







    //-----------------------------------------------------------------------------------
    // the following is about setting up GUI

    private void setUpmain(GridBagConstraints gc){

        prompt1 = new JLabel("DNA sequence 1: ");
        DNA1 = new JTextArea("AAACTCATC",3,12);
        prompt2 = new JLabel("DNA sequence 2: ");
        DNA2 = new JTextArea("TTTCAAATC",3,12);
        k = new JLabel("k: ");
        kinput = new JTextField("3",12);
        submit = new JButton("submit");
        resultLabel = new JLabel("result:");
        resultContent = new JTextArea(3,12);

        gc.weightx = 2;
        gc.weighty = 2;
        gc.ipadx = 10;
        gc.ipady = 10;

        gc.gridx = 0;
        gc.gridy = 0;
        add(prompt1,gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(DNA1,gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(prompt2,gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(DNA2,gc);

        gc.gridx = 0;
        gc.gridy = 4;
        add(k,gc);

        gc.gridx = 0;
        gc.gridy = 5;
        add(kinput,gc);

        gc.gridx = 0;
        gc.gridy = 6;
        add(submit,gc);

        gc.gridx = 1;
        gc.gridy = 0;
        add(resultLabel,gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(resultContent,gc);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dna1 = DNA1.getText();
                String dna2 = DNA2.getText();
                int k = Integer.parseInt(kinput.getText());
                findSharedKmer(dna1,dna2,k);
                render(results);
            }
        });
    }

    private void render(ArrayList<Point> results){

        if(!resultContent.getText().equals("")){
            resultContent.setText("");
        }
        for(int i=0; i<results.size(); i++){
            if(resultContent.getText().equals("")){
                resultContent.setText(print(results.get(i)));
            }else{
                resultContent.setText(resultContent.getText()+"\n" + print(results.get(i)));
            }

        }
    }

    private String print(Point p){
        return "("+(int)p.getX() + "," + (int)p.getY()+ ")";
    }

}
