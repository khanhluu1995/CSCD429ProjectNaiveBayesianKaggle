import java.util.Hashtable;
import java.util.Scanner;

public class NaiveBayesian_Implementation {
    //the numbers were generated from rapidMiner
    private final double p_one =  4684/42000;
    private final double p_two =4177/42000;
    private final double p_three = 4351/42000;
    private final double p_four = 4072/42000;
    private final double p_five = 3795/42000;
    private final double p_six = 4137/42000;
    private final double p_seven = 4401/42000;
    private final double p_eight = 4063/42000;
    private final double p_nice = 4188/42000 ;
    private final double p_zero = 4132/42000;

    private final int numberOfAttribute = 783;
    private final int numberOfPossibleDigit = 10;


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
    Hashtable<String, String> uniqueLocalization = new Hashtable<>();
    Scanner scanner;



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



    public String predictLocalization(String[] oneLineTestData){




        int chosen = calculateFinalProb(probabilityResult);


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




//    private void findProbGeneID(String[][] testData) {
//
//
//        for (int i = 0; i < testData.length; i++) {
//            String name = "";
//            if (!uniqueLocalization.contains(testData[i][0])) {
//
//                for (int j = 0; j < testData.length; j++) {
//
//                    if (testData[i][0].equals(testData[j][0]) && testData[j][1].equals("nucleus")) {
//                        countGeneID[0]++;
//                    } else if (testData[i][0].equals(testData[j][0]) && testData[j][1].equals("cytoplasm")) {
//                        countGeneID[1]++;
//                    } else if (testData[i][0].equals(testData[j][0]) && testData[j][1].equals("cytoskeleton")) {
//                        countGeneID[2]++;
//                    } else if (testData[i][0].equals(testData[j][0]) && testData[j][1].equals("mitochondria")) {
//                        countGeneID[3]++;
//                    } else if (testData[i][0].equals(testData[j][0]) && testData[j][1].equals("plasma membrane")) {
//                        countGeneID[4]++;
//                    } else if (testData[i][0].equals(testData[j][0]) && testData[j][1].equals("ER")) {
//                        countGeneID[5]++;
//                    } else if (testData[i][0].equals(testData[j][0]) && testData[j][1].equals("golgi")) {
//                        countGeneID[6]++;
//                    } else if (testData[i][0].equals(testData[j][0]) && testData[j][1].equals("vacuole")) {
//                        countGeneID[7]++;
//                    } else if (testData[i][0].equals(testData[j][0]) && testData[j][1].equals("peroxisome")) {
//                        countGeneID[8]++;
//                    } else if (testData[i][0].equals(testData[j][0]) && testData[j][1].equals("endosome")) {
//                        countGeneID[9]++;
//                    }
//                    name = setLocalName();
//                    setupFunction(countGeneID);
//                }
//                uniqueLocalization.put(testData[i][0], name);
//            }
//        }
//    }
//
//    private String setLocalName() {
//
//        //setupFunction(probabilityResult);
//
////        probabilityResult[0] = (this.countGeneID[0]/nucleus) * p_nucleus;
////        probabilityResult[1] = (this.countGeneID[1]/cytoplasm) * p_cytoplasm;
////        probabilityResult[2] = (this.countGeneID[2]/cytoskeleton)* p_cytoskeleton;
////        probabilityResult[3] = (this.countGeneID[3]/mitochondria)* p_mitochondria;
////        probabilityResult[4] = (this.countGeneID[4]/plasma_membrane) * p_plasma_membrane;
////        probabilityResult[5] = (this.countGeneID[5]/ER) * p_ER;
////        probabilityResult[6] = (this.countGeneID[6]/golgi)*  p_golgi;
////        probabilityResult[7] = (this.countGeneID[7]/vacuole)* p_vacuole;
////        probabilityResult[8] = (this.countGeneID[8]/peroxisome) * p_peroxisome;
////        probabilityResult[9] = (this.countGeneID[9]/endosome) * p_endosome;
//
//
////        String name;
////        double largest = 0;
////        int num = 0;
////        for(int k = 0; k < countGeneID.length;k++){
////            if(countGeneID[k] > largest){
////                largest = countGeneID[k];
////                num = k;
////            }
////        }
//
//        switch (num){
//            case 0: name = "0"; break;
//            case 1:  name = "1"; break;
//            case 2: name =  "2";break;
//            case 3: name =  "3";break;
//            case 4: name =  "4";break;
//            case 5: name = "5";break;
//            case 6: name = "6";break;
//            case 7: name = "7";break;
//            case 8: name = "8";break;
//            case 9: name = "9";break;
//
//
//            default: name = "Error";break;
//        }
//        return name;
//    }


//    public Hashtable<String,String> findTheFinalLocalization(String[][] testData){
//            findProbGeneID(testData);
//         return uniqueLocalization;
//    }



    private int calculateFinalProb(double[] probabilityResult){
        int chosen = 0;
        setupFunction(probabilityResult);




        double number2compare = 0;
        for (int i = 0; i < probabilityResult.length; i++){
            if(probabilityResult[i] > number2compare){
                number2compare = probabilityResult[i];
                chosen = i;
            }
        }
        return chosen;
    }

    private void countAttributeProb(){
        for(int i = 0; i < 42000;i++){
            for(int j = 1; j < numberOfAttribute;j++){
                if(myDataSet[i][j] != "0"){
                    myDigitInfo.setDigit(myDataSet[i][0],myDataSet[i][j+1]);

                }
            }
        }

    }

}
