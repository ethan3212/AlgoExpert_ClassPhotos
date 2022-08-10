import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // initialize our arrays of shirt color heights
        ArrayList<Integer> redShirtHeights = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4));  // 1, 3, 4, 5, 8
        ArrayList<Integer> blueShirtHeights = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5)); // 2, 4, 5, 6, 9
        // call our method & display the result
        System.out.println(classPhotos(redShirtHeights, blueShirtHeights));
    }

    // O(nLog(n) + mLog(m)) time | O(1) space
    public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // sort both input arrayLists
        Collections.sort(redShirtHeights);      // O(nLog(n) time
        Collections.sort(blueShirtHeights);     // O(mLog(m) time
        // determine which 'color' will be the front row
        String frontRowColor = (redShirtHeights.get(0) < blueShirtHeights.get(0)) ? "RED" : "BLUE";
        // iterate through the length of the arrays (they are the same size)
        for(int i = 0; i < redShirtHeights.size(); i++) {       // O(n) time
            // hold on to the RED & BLUE students
            int red = redShirtHeights.get(i);
            int blue = blueShirtHeights.get(i);
            // if the front row color is RED
            if(frontRowColor == "RED") {
                // if the RED student is taller than the BLUE student, return FALSE
                if(red >= blue) {
                    return false;
                }
                // if the front row color is BLUE
            } else {
                // if the BLUE student is taller than the RED student, return FALSE
                if(blue >= red) {
                    return false;
                }
            }
        }
        // if we successfully iterate through both arrays, the photo is valid, return TRUE
        return true;
    }
}