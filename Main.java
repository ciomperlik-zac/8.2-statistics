import java.io.File; // Import the File class
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner; // Import this class to handle errors


class Main {
    public static void main(String[] args) {
        // create an ArrayList to store the integers from the file
        ArrayList<Integer> nums = new ArrayList<>();

        // read the integers from the file and store them in the ArrayList
            // create a File object and a Scanner object to read the file

            // use a while loop to read each integer from the file and add it to the ArrayList

            // handle the FileNotFoundException if the file is not found
        File file = new File("numbers.txt");

        try {
            Scanner scan = new Scanner(file); 

            while (scan.hasNextInt()) {
                nums.add(scan.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println(String.format("The selected file [%s] cannot be found!", file.getAbsolutePath()));
            return;
        }

        // call the average, standardDeviation, and mode methods and print their results
        System.out.println("Average: " + average(nums));
        System.out.println("Standard Deviation: " + standardDeviation(nums));
        System.out.println("Mode: " + mode(nums));
    }

    // implement the average method to calculate the average of the integers in the ArrayList
    public static double average(ArrayList<Integer> arr) {
        double sum = 0;

        for (int num : arr) sum += num;

        return sum / arr.size();
    }

    // implement the standardDeviation method to calculate the standard deviation of the integers in the ArrayList
    public static double standardDeviation(ArrayList<Integer> arr) {
        double average = average(arr);

        double sumDiff = 0.0;

        for (int num : arr) {
            double diff = num - average;
            sumDiff += diff * diff;
        }

        double avgDiff = sumDiff / (arr.size() - 1);

        return Math.sqrt(avgDiff);
    }

    // implement the mode method to calculate the mode of the integers in the ArrayList
    public static int mode(ArrayList<Integer> arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int num : arr) {
            if (counts.containsKey(num)) {
                counts.merge(num, 1, Integer::sum);
            } else {
                counts.put(num, 1);
            }
        }

        int mode = 0;
        int maxCount = 0;

        for (int num : counts.keySet()) {
            int count = counts.get(num);

            if (count > maxCount) {
                mode = num;
                maxCount = count;
            }
        }

        return mode;
    }
}
