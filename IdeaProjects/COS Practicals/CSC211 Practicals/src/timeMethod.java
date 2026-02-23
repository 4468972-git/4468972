import java.lang.Math; import java.io.FileReader; import java.util.Scanner; import java.text.DecimalFormat;

public class timeMethod {
    public static int[] NodeKeys = new int[30];
    public static void filereading(String filename)throws Exception {
        Scanner sc = new Scanner(new FileReader(filename));
        int i = 0;
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                NodeKeys[i] = number;
                i++;
            } else {
                sc.next();
            }
        }
    }

    public static int linearsearch(int[] X, int target){
        int i = 0;
        while (i < X.length){
            if (X[i] == target)
                return i;
            i++;
        }
        return -1;
    }

    //Recursive binary search
    public static int binarysearch(int[] X, int target, int low, int high){ //low and high represent index of the very first and last element in the current search range
        if (low > high)
            return -1;
        int mid = Math.floorDiv((low + high), 2);
        if (X[mid] == target)
            return mid;
        else if (target < X[mid]){
            return binarysearch(X, target, low, mid - 1);}
        return binarysearch(X, target,mid+1, high);
    }


    public static int N = 30;
    public static void main(String[] args){

        DecimalFormat twoD = new DecimalFormat("0.00");
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        long start, finish;
        double runTime = 0, runTime2 = 0, time;
        double totalTime = 0.0;
        int n = N;
        int repetition, repetitions = 30;

        runTime = 0;
        for(repetition = 0; repetition < repetitions; repetition++) {
            start = System.currentTimeMillis();

            // call the procedures to time here:
            for (int i = 0; i < 30; i++)
                linearsearch (NodeKeys, (int)(Math.random() * 32654 + 1));

            for (int i = 0; i < 30; i++)
                binarysearch (NodeKeys, (int)(Math.random() * 32654 + 1),0, NodeKeys.length -1);
            // Figure out how to alter this guideline here,

            finish = System.currentTimeMillis();

            time = (double)(finish - start);
            runTime += time;
            runTime2 += (time*time); }

        double aveRuntime = runTime/repetitions;
        double stdDeviation =
                Math.sqrt(runTime2 - repetitions*aveRuntime*aveRuntime)/(repetitions-1);

        System.out.printf("\n\n\fStatistics\n");
        System.out.println("________________________________________________");
        System.out.println("Total time   =           " + runTime/1000 + "s.");
        System.out.println("Total time\u00b2  =           " + runTime2);
        System.out.println("Average time =           " + fiveD.format(aveRuntime/1000)
                + "s. " + '\u00B1' + " " + fourD.format(stdDeviation) + "ms.");
        System.out.println("Standard deviation =     " + fourD.format(stdDeviation));
        System.out.println("n            =           " + n);
        System.out.println("Average time / run =     " + fiveD.format(aveRuntime/n*1000)
                + '\u00B5' + "s. ");

        System.out.println("Repetitions  =             " + repetitions);
        System.out.println("________________________________________________");
        System.out.println();
        System.out.println();
    }
}

