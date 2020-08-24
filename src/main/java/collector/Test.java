package collector;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public void write (String filename, boolean cont) {
        try {
            CSVWriter writer;
            writer = new CSVWriter(new FileWriter(filename, cont));

            //Writing data to a csv file

            // Header
            if(!cont) {
                String[] headers = new String[4];
                headers[0] = "Turn";
                headers[1] = "Rank";
                headers[2] = "IsHit";
                headers[3] = "Value";
                writer.writeNext(headers);
            }

            writer.close();
            System.out.println("Data ghaha!!!");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
        Test t = new Test();
        t.write("test.csv", false);
    }
}
