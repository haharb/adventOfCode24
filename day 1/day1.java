import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class day1 {
    public static void main(String args[]) {
        try (Scanner scan = new Scanner(new File("./test.txt"))) {

            ArrayList<Integer> aList = new ArrayList<Integer>();
            ArrayList<Integer> bList = new ArrayList<Integer>();

            while (scan.hasNextLine()) {
                aList.add(scan.nextInt());
                bList.add(scan.nextInt());
            }

            Collections.sort(aList);
            Collections.sort(bList);

            long res = 0;

            for (int i = 0; i < aList.size(); i++) {
                res += Math.abs(aList.get(i) - bList.get(i));
            }

            System.out.printf("%d", res);

            scan.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found" + e.getMessage());
        }
    }
}