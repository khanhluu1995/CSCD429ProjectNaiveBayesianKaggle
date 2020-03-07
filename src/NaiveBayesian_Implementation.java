import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class NaiveBayesian_Implementation {
    //the numbers were generated from rapidMiner
    private final double p_one =  (double)4684/42000;
    private final double p_two =(double)4177/42000;
    private final double p_three = (double)4351/42000;
    private final double p_four =(double) 4072/42000;
    private final double p_five = (double)3795/42000;
    private final double p_six = (double)4137/42000;
    private final double p_seven = (double)4401/42000;
    private final double p_eight = (double)4063/42000;
    private final double p_nine =(double) 4188/42000 ;
    private final double p_zero = (double)4132/42000;

    
    private  double one ;
    private  double two ;
    private  double three;
    private  double four;
    private  double five;
    private  double six;
    private  double seven;
    private  double eight;
    private  double nine;
    private  double zero;
    private Digit myDigitInfo;
    private double[] probabilityResult = new double[10];
    String[][] myDataSet;
    private final int numberOfAttribute = 783;
    private final int theCommitmentNumber = 80;



    public NaiveBayesian_Implementation(String[][] myDataSet) {
        this.one = 4684;
        this.two = 4177;
        this.three = 4351;
        this.four = 4072;
        this.five = 3795;
        this.six = 4137;
        this.seven = 4401;
        this.eight = 4063;
        this.nine = 4188;
        this.zero = 4132;

        this.myDigitInfo = new Digit();
        this.myDataSet = myDataSet;
        countAttributeProb();
        setupFunction(this.probabilityResult);
    }

    public Digit getMyDigitInfo() {
        return myDigitInfo;
    }

    private void setupFunction(double[] getSetup){
        for (int i = 0; i < getSetup.length; i++){
            getSetup[i] = 0;
        }
    }


    public String recognizer(String[] oneLineTestData){
        int chosen = returnTheChosen(probabilityResult, oneLineTestData);
        switch (chosen){
            case 0: return  "0";
            case 1:
                return  "1";

            case 2:
                return  "2";

            case 3:
                return  "3";

            case 4:
                return  "4";

            case 5:
                return "5";

            case 6:
                return "6";

            case 7:
                return "7";

            case 8:
                return "8";

            case 9:return "9";


            default: return "Error";
        }

    }



    private int returnTheChosen(double[] probabilityResult, String[] oneLineTestData){
        int chosen = 0;
        setupFunction(probabilityResult);
        
        probabilityResult[0] = calculateEachDigitProb(oneLineTestData,myDigitInfo.digitZero,zero,p_zero);
        probabilityResult[1] = calculateEachDigitProb(oneLineTestData,myDigitInfo.digitOne,one,p_one);
        probabilityResult[2] = calculateEachDigitProb(oneLineTestData,myDigitInfo.digitTwo,two,p_two);
        probabilityResult[3] = calculateEachDigitProb(oneLineTestData,myDigitInfo.digitThree,three,p_three);
        probabilityResult[4] = calculateEachDigitProb(oneLineTestData,myDigitInfo.digitFour,four,p_four);
        probabilityResult[5] = calculateEachDigitProb(oneLineTestData,myDigitInfo.digitFive,five,p_five);
        probabilityResult[6] = calculateEachDigitProb(oneLineTestData,myDigitInfo.digitSix,six,p_six);
        probabilityResult[7] = calculateEachDigitProb(oneLineTestData,myDigitInfo.digitSeven,seven,p_seven);
        probabilityResult[8] = calculateEachDigitProb(oneLineTestData,myDigitInfo.digitEight,eight,p_eight);
        probabilityResult[9] = calculateEachDigitProb(oneLineTestData,myDigitInfo.digitNine,nine,p_nine);

        double number2compare = 0;
        for (int i = 0; i < probabilityResult.length; i++){
//            System.out.println(probabilityResult[i]);
            if(probabilityResult[i] > number2compare){
                number2compare = probabilityResult[i];
                chosen = i;
            }
        }
        return chosen;
    }

    private double calculateEachDigitProb(String[] testData, HashMap<String,Integer>theDigit, double totalDigitCount, double totalDigitProb){
        double probability = 1;
        for(int i = 0; i < numberOfAttribute;i++ ){
            if(theDigit.containsKey(testData[i])){
                probability *= (double)theDigit.get(testData[i])/totalDigitCount;
            }
        }
        return probability*totalDigitProb;
    }

    private void countAttributeProb(){
        for(int i = 0; i < 42000;i++){
            for(int j = 1; j < numberOfAttribute;j++){
                if(Integer.parseInt(myDataSet[i][j]) > theCommitmentNumber){
                    myDigitInfo.setDigit(myDataSet[i][0],Integer.toString(j-1));
                }
            }
        }

    }

}
