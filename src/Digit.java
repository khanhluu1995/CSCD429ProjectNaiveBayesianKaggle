import java.util.HashMap;

public class Digit {
    HashMap<String,Integer> digitOne;
    HashMap<String,Integer> digitTwo;
    HashMap<String,Integer> digitThree;
    HashMap<String,Integer> digitFour;
    HashMap<String,Integer> digitFive;
    HashMap<String,Integer> digitSix;
    HashMap<String,Integer> digitSeven;
    HashMap<String,Integer> digitEight;
    HashMap<String,Integer> digitNine;
    HashMap<String,Integer> digitZero;

    public Digit() {
        this.digitOne = new HashMap<>();
        this.digitTwo = new HashMap<>();
        this.digitThree = new HashMap<>();
        this.digitFour = new HashMap<>();
        this.digitFive = new HashMap<>();
        this.digitSix = new HashMap<>();
        this.digitSeven = new HashMap<>();
        this.digitEight = new HashMap<>();
        this.digitNine = new HashMap<>();
        this.digitZero = new HashMap<>();
    }

    public void setDigit(String digitName, String pixelNumber){
        switch (digitName){
            case "0":
                countPixels(pixelNumber,digitZero);
                break;
            case "1":
                countPixels(pixelNumber,digitOne);
                break;
            case "2":
                countPixels(pixelNumber,digitTwo);
                break;
            case "3":
                countPixels(pixelNumber,digitThree);
                break;
            case "4":
                countPixels(pixelNumber,digitFour);
                break;
            case "5":
                countPixels(pixelNumber,digitFive);
                break;
            case "6":
                countPixels(pixelNumber,digitSix);
                break;
            case "7":
                countPixels(pixelNumber,digitSeven);
                break;
            case "8":
                countPixels(pixelNumber,digitEight);
                break;
            case "9":
                countPixels(pixelNumber,digitNine);
                break;

        }
    }

    private void countPixels(String pixelNumber, HashMap<String,Integer> updateThisPixel) {
        if(!updateThisPixel.containsKey(pixelNumber)){
            updateThisPixel.put(pixelNumber,1);
        }
        else {
            updateThisPixel.put(pixelNumber,updateThisPixel.get(pixelNumber)+1);
        }
    }


}
