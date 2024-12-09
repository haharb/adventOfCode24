import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day3 {

    public static void main(String args[]) {
        try {
            Scanner scan = new Scanner(new File("./day 3/test.txt"));

            ArrayList<Integer> list = new ArrayList<Integer>();

            int res = 0;

            while (scan.hasNextLine()) {

                String line = scan.nextLine();
                Scanner lineScanner = new Scanner(line);

                while (lineScanner.hasNextInt()) {
                    list.add(lineScanner.nextInt());
                }

                if (checkList(list)) {
                    res += 1;
                }
                list.clear();
                lineScanner.close();
            }

            scan.close();

            System.out.println("Res " + res);

        } catch (

        FileNotFoundException e) {
            System.err.println("File not found " + e.getMessage());
        }
    }

    private static boolean checkList(ArrayList<Integer> toCheck) {
        int difference = toCheck.get(1) - toCheck.get(0);

        if (toCheck.size() == 1) {
            return true;
        }

        if (toCheck.size() > 1) {
            boolean inc = false;

            if (difference == 0) {
                return false;
            }

            if (difference < 0) {
                inc = true;
            }

            for (int i = 2; i < toCheck.size(); i++) {
                difference = (toCheck.get(i) - toCheck.get(i - 1));

                if ((difference == 0) ||
                        (inc && (difference < 0) ||
                                (!inc && (difference > 0) ||
                                        (1 > Math.abs(difference)) ||
                                        (Math.abs(difference) > 3)))) {
                    return false;
                }
            }
        }
        return true;
    }
}