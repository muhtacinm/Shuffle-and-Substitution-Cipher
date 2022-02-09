public class SubstitutionCipher extends Cipher implements MessageEncoder, MessageDecoder
{
    private int shift; //holds shift value

    public SubstitutionCipher(int shift)  //constructor to set the shift amount
    {
        this.shift= shift;
    }

    @Override
    public String cipherType(){
        return "SubstitutionCipher"; //returns which type of cipher it is (extended from abstract cipher class)
    }


    @Override
    public String encode(String plainText)
    {
        String encoded = ""; //string to hold final encoded text
        for(int i = 0; i < plainText.length(); i++) //for loop to iterate through the plaintext
        {
            char encodeLetter = plainText.charAt(i); // gets each letter in the text
            encoded = encoded + (char)(encodeLetter + shift);
        }
        return encoded;
    }

    @Override
    public String decode(String cipherText){
        String decoded = ""; //string to hold final decoded text
        for(int i=0; i< cipherText.length(); i++){ //for loop to iterate through each character of cipherText
            char decodeLetter = cipherText.charAt(i);
            decoded = decoded + (char)(decodeLetter - shift);
        }
        return decoded;
    }

}