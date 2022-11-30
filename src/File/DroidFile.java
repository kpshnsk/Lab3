package File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Fighth.Fighth;
public class DroidFile {

        public static void addToFile() throws IOException {
            FileWriter fw = new FileWriter( "fight.txt" );
            fw.write(Fighth.sb.toString());
            fw.close();
        }

        public static void readFile() throws IOException {
            FileReader fr = new FileReader( "fight.txt" );
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
            fr.close();
        }
}


