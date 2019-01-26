package src.Q2;

public class Fragment {
    private String frag;  // the sequence of the fragment
    private int index;    // the position of the fragment in its original dna sequence


    public Fragment(String frag, int index) {
        this.frag = frag;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getFrag() {

        return frag;
    }


    // EFFECT: returns true if the input fragment is the same or complementary to this fragment
    public boolean compare(Fragment sub) {
        boolean identical = this.getFrag().equals(sub.getFrag());
        boolean complementary = this.getFrag().equals(complement(sub));
        return identical||complementary;
    }

    // EFFECT: translate a fragment into its complementary fragment
    private String complement(Fragment s){
        String translation="";
        String sequence = s.getFrag();
        for(int i=0;i<sequence.length();i++){
            String a = sequence.substring(i,i+1);
            switch (a){
                case "A":
                    translation = translation+"T";
                    break;
                case "T":
                    translation = translation+"A";
                    break;
                case "C":
                    translation = translation+"G";
                    break;
                default:
                    translation = translation+"C";
            }
        }
        return translation;
    }


}

