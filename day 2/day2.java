import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class day2 {
    public static void main(String args[]) {
        try (Scanner scan = new Scanner(new File("./day 2/test.txt"))) {

            ArrayList<Integer> aList = new ArrayList<Integer>();
            ArrayList<Integer> bList = new ArrayList<Integer>();

            HashMap<Integer, Integer> bFreq = new HashMap<Integer, Integer>();

            while (scan.hasNextLine()) {
                aList.add(scan.nextInt());
                bList.add(scan.nextInt());
            }

            long res = 0;

            for (int i = 0; i < aList.size(); i++) {
                bFreq.put(bList.get(i), bFreq.getOrDefault(bList.get(i), 0) + 1);
            }

            for (int i = 0; i < aList.size(); i++) {
                if (bFreq.containsKey(aList.get(i))) {
                    res += (bFreq.get(aList.get(i)) * aList.get(i));
                }
            }

            System.out.printf("%d", res);

            scan.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found" + e.getMessage());
        }
    }
}