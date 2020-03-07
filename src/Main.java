import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        File file = new File("train.csv");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        final int totalExample = 42000;

        final int amountOfAttr = 784;
        String[][] trainingData = new String[totalExample][amountOfAttr];
        scanner = new Scanner(file);
        scanner.nextLine();
        int i = 0;
        while (scanner.hasNext()) {

            String[] splitLine = scanner.nextLine().split(",");
            for(int j = 0; j < amountOfAttr; j++){

                    trainingData[i][j] = splitLine[j];
            }
            i++;
        }

//        print2D(trainingData);


        NaiveBayesian_Implementation naiveBayesian_implementation = new NaiveBayesian_Implementation(trainingData);



        int test = 1;
        double test2 = 40.0;
        System.out.println(test/test2);

        file = new File("test.csv");
        scanner = new Scanner(file);
        scanner.nextLine();

        //Create an output file
        File writeFileName = new File("submission.csv");


        try {
            FileWriter fileWriter = new FileWriter(writeFileName);
            fileWriter.write("ImageId,Label\n");
            int line = 1;


            scanner = new Scanner(file);
            scanner.nextLine();
            while(scanner.hasNext()){
                String[] splitLine = scanner.nextLine().split(",");
//                System.out.println(line + ": " + naiveBayesian_implementation.recognizer(splitLine));

                fileWriter.write(line + "," + naiveBayesian_implementation.recognizer(splitLine)  + "\n");

                line++;
            }



//            for(i =0; i < geneID.length;i++){
//                fileWriter.write(geneID[i] + "," + localization[i] + "\n");
//            }


            fileWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }




    public static void print2D(String mat[][])
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++) {
            System.out.println();
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }
    }



//    private static void addLocalizationToHashtable(Hashtable<String, Integer> localizationTable, String[] splitLine) {
//        int rightValue = splitLine.length-1;
//
//
//        if (localizationTable.containsKey(splitLine[rightValue])) {
//            localizationTable.put(splitLine[rightValue], localizationTable.get(splitLine[rightValue])+1);
//        } else {
//            localizationTable.put(splitLine[rightValue], 1);
//        }
//    }





}
