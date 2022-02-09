public class ShuffleCipher extends Cipher implements MessageEncoder,MessageDecoder {

    private int n; //holds shift value

    public ShuffleCipher(int n) {  //constructor to set the shift amount
        this.n = n;
    }

    @Override
    public String cipherType() {
        return "ShuffleCipher"; //returns which type of cipher it is (extended from abstract cipher class)
    }

    @Override
    public String encode(String plainText){
        String encoded = plainText;//string to hold final encoded text
        for(int i=0; i < n; i++){ //shuffle message given the number of shuffles
            encoded = shuffle(encoded); //call on shuffle function
        }
        return encoded;
    }

    @Override
    public String decode(String cipherText){
        String decoded = cipherText; //string to hold final decoded text
        for(int i=0; i < n ;i++){ //shuffle message given the number of shuffles
            decoded = unShuffle(decoded); //call on unshuffle function
        }

        return decoded;
    }



    private String shuffle(String str){
        String shuffled = "";
        int strLenHalf = (str.length() + 1)/2; //gets total length of string and splits it into half
        String s1 = str.substring(0, strLenHalf); //gets first half of string
        String s2 = str.substring(strLenHalf); //gets second half of string
        /*System.out.println(s1);
        System.out.println(s2);*/
        if(s2.length() <= s1.length()) //checks if the second half is smaller than first half
        {
            int i = 0;
            while (i < s2.length()) {
                shuffled += s1.substring(i, i+1) +s2.substring(i, i+1); //gets first character from first string and second string and combines
                                                                        //and etc
                i++;
            }
        }
        //checks to see if s2 is not out of bounds
        //for odd string
        if (strLenHalf > s2.length()){
            shuffled += s1.substring(strLenHalf-1);
            System.out.println(shuffled);

        }
        return shuffled;

    }

    private String unShuffle(String text) {
        String firstSplit = "";
        String secondSplit = "";
        // splits into two by taking the alternative chars of the string
        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 0) { //checks if index i is even
                firstSplit += text.charAt(i); //if even adds it to the first set
            }
            else {
                secondSplit += text.charAt(i); // all odd index gets added to second set
            }
        }
        return firstSplit + secondSplit;
    }
}

