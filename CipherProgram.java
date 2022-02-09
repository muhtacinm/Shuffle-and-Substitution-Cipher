import java.io.File;
import java.util. * ;

public class CipherProgram {
    public static void main(String[] args) throws Exception {

    /*
        SubstitutionCipher c1= new SubstitutionCipher(3);
        System.out.println(c1.encode("To be Or Not To Be"));
        ShuffleCipher c2= new ShuffleCipher(2);
        System.out.println(c2.encode("To be Or Not To Be"));
    */

        Scanner scan = new Scanner(System.in);
        int choice;
        int shiftNum;
        char yOrn;
        String inputName, outputName;
        String text, finalText;
        char option;
        while (true) {
            System.out.println("Welcome to the Cipher program");
            System.out.println("Type 1 for Substitution Cipher.");
            System.out.println("Type 2 for Shuffle Cipher.");
            choice = scan.nextInt();

            //if valid type not chosen
            if (choice < 1 || choice > 2){
                System.out.println("Invalid option!");
                continue;
            }

            //Substitution Cipher
            if (choice == 1) {
                System.out.println("What is the key (shift amount) for your code?");
                shiftNum = scan.nextInt();
                SubstitutionCipher s1 = new SubstitutionCipher(shiftNum); //creates substituion cipher instance with shift amount
                System.out.println(s1.cipherType() + "-shift amount = " + shiftNum);


                //loop until valid input file is given
                while (true) {
                    System.out.println("Enter input file name: ");
                    inputName = scan.next();
                    if (checkIfValid(inputName)) { //uses checkIfValid to see if file exists
                        break;
                    } else {
                        System.out.println("Invalid input file name!");
                    }
                }

                //loop until valid output file is given
                while (true) {
                    System.out.println("Enter output file name: ");
                    outputName = scan.next();
                    if (checkIfValid(outputName)) { //uses checkIfValid to see if file exists
                        break;
                    } else {
                        System.out.println("Invalid output file name!");
                    }
                }

                System.out.println("Encode (E) or Decode (D):");
                option = scan.next().charAt(0);
                option = Character.toLowerCase(option);

                if (option == 'e') {
                    text = getContents(inputName); //uses getContents function to get input file content
                    finalText = s1.encode(text); //encodes text
                    putContents(outputName, finalText); //uses putcontents function to write text to output file
                    System.out.println("Encoded text is saved in file " + outputName);

                } else if (option == 'd') {
                    text = getContents(inputName); //uses getContents function to get input file content
                    finalText = s1.decode(text); //decodes text
                    putContents(outputName, finalText); //uses putcontents function to write text to output file
                    System.out.println("Decoded text is saved in file " + outputName);

                }

            }
            else if (choice == 2) {
                System.out.println("What is the key (shift amount) for your code?");
                shiftNum = scan.nextInt();
                ShuffleCipher s2 = new ShuffleCipher(shiftNum); //creates shuffle cipher instance with shift amount
                System.out.println(s2.cipherType() + "-shift amount = " + shiftNum);

                //loop until valid input file is given
                while (true) {
                    System.out.println("Enter input file name: ");
                    inputName = scan.next(); //user input for output file name
                    if (checkIfValid(inputName)) { //uses checkIfValid to see if file exists
                        break;
                    } else {
                        System.out.println("Invalid input file name! File does not exist!");
                    }
                }


                //loop until valid output file is given
                while (true) {
                    System.out.println("Enter output file name: ");
                    outputName = scan.next(); //user input for output file name
                    if (checkIfValid(outputName)) {  //uses checkIfValid to see if file exists
                        break;
                    } else {
                        System.out.println("Invalid output file name! File does not exist!");
                    }
                }

                System.out.println("Encode (E) or Decode (D):");
                option = scan.next().charAt(0);
                option = Character.toLowerCase(option);

                if (option == 'e') {
                    text = getContents(inputName);
                    finalText = s2.encode(text);
                    putContents(outputName, finalText);
                    System.out.println("Encoded text is saved in file " + outputName);

                } else if (option == 'd') {
                    text = getContents(inputName);
                    finalText = s2.decode(text);
                    putContents(outputName, finalText);
                    System.out.println("Decoded text is saved in file " + outputName);
                }


            }


            System.out.println("Do you want to do another message (Y)? ");
            yOrn = scan.next().charAt(0); //gets userinput if they want to want to continue or not
            yOrn = Character.toLowerCase(yOrn); //converts to lowercase for if statement

            if (yOrn == 'y') {
                continue;
            } else {
                return;
            }

        }

    }

    //checks if file is valid
    public static boolean checkIfValid(String filename) {
        java.io.File inputFile = new java.io.File(filename);
        return inputFile.exists();
    }

    //gets content from file
    public static String getContents(String fname) throws Exception {
        File inputFile = new File(fname);
        String text = "";
        Scanner fileScan = new Scanner(inputFile);
        while (fileScan.hasNextLine()) {
            text += fileScan.nextLine();
        }
        fileScan.close();
        return text;

    }

    //writes content to file
    public static void putContents(String oname, String contents) throws Exception {
        java.io.PrintWriter outputFile = new java.io.PrintWriter(oname);
        outputFile.print(contents);
        outputFile.close();
    }
}