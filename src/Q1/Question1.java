package Q1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Question1 extends JPanel{

    JLabel prompt;
    JTextArea DNA;
    JLabel k;
    JTextField kinput;
    JButton submit;
    JLabel resultLabel;
    JTextArea resultContent;
    ArrayList<String> results;


   // A constructor for Q1-- finding k mer

    public Question1(){
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        setSize(500,400);
        setVisible(true);
        setUpmain(gc);
    }

    // The main method for finding k mer
    // The basic idea is to first chop the dna sequence into fragments containing k bases,
    // and then count how many duplicates are there in the set.
    // Save the fragments that have the maximum occurence
    private void findKmer(String input, int k) {
        results = new ArrayList<>();
        ArrayList<String> fragments = slice(input,k);
        int max = 0;
        for(int x = 0; x<fragments.size()-1;x++){
            int num = 0;
            for(int y = x+1; y<fragments.size();y++){
                if(fragments.get(x).equalsIgnoreCase(fragments.get(y))){
                    num++;
                }
            }
            if(num>max){
                max = num;
                results = new ArrayList<>();
                results.add(fragments.get(x));
            }
            if(num==max){
                results.add(fragments.get(x));
            }

        }
        reduceDuplicate();
    }

    // EFFECT: chop the input into fragments of k bases
    private ArrayList<String> slice(String input, int k) {
        ArrayList<String> fragments = new ArrayList<>();
        for(int x = 0; x+k<=input.length();x++){

            String frag = input.substring(x,x+k);
            fragments.add(frag);

        }
        return fragments;
    }

    // EFFECT: remove the duplicate in the result
    private void reduceDuplicate(){
        ArrayList<String> resultNoDuplicate = new ArrayList<>();
        resultNoDuplicate.addAll(results);
        for(int x = 0; x<results.size()-1; x++){
            for (int y = x+1; y<results.size(); y++){
                if (results.get(x).equals(results.get(y))){
                    resultNoDuplicate.remove(x);
                }
            }
        }
        results = resultNoDuplicate;
        //results.clear();
        //results.addAll(resultNoDuplicate);

    }









    // --------------------------------------------------------------------------
    // the following is about setting up GUI
    private void setUpmain(GridBagConstraints gc){

        prompt = new JLabel("DNA sequence: ");
        DNA = new JTextArea("ACGTTGCATGTCGCATGATGCATGAGAGCT",3,12);
        k = new JLabel("k: ");
        kinput = new JTextField("4",12);
        submit = new JButton("submit");
        resultLabel = new JLabel("result:");
        resultContent = new JTextArea(3,12);

        gc.weightx = 2;
        gc.weighty = 2;
        gc.ipadx = 10;
        gc.ipady = 10;

        gc.gridx = 0;
        gc.gridy = 0;
        add(prompt,gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(DNA,gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(k,gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(kinput,gc);

        gc.gridx = 0;
        gc.gridy = 4;
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
                String dna = DNA.getText();
                int k = Integer.parseInt(kinput.getText());
                findKmer(dna,k);
                render(results);
            }
        });
    }

    // EFFECT: add the result after submit button is hit
    private void render(ArrayList<String> results){
        if(!resultContent.getText().equals("")){
            resultContent.setText("");
        }
        for(int i=0; i<results.size(); i++){
            if(resultContent.getText().equals("")){
                resultContent.setText(results.get(i));
            }else{
                resultContent.setText(resultContent.getText()+"\n" + results.get(i));
            }

        }
    }


}
