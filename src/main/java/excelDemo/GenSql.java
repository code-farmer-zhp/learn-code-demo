package excelDemo;


import java.io.*;
import java.util.Scanner;

public class GenSql {
    public static void main(String[] args) throws Exception {

        File infile = new File("resh_gift_member.sql");
        File outfile = new File("fresh_gift_member_all.sql");

        BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(outfile), "UTF-8"));
        for (int db = 0; db < 8; db++) {
            fileWriter.write("use group" + db + ";");
            fileWriter.write("\r\n");
            for (int table = 0; table < 64; table++) {
                InputStreamReader inputStream = new InputStreamReader(
                        new FileInputStream(infile), "UTF-8");
                Scanner scanner = new Scanner(inputStream);
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    if (line.contains("fresh_gift_member")) {
                        line = line.replaceAll("fresh_gift_member", "fresh_gift_member" + table);
                    }
                    fileWriter.write(line);
                    fileWriter.write("\r\n");

                }
                inputStream.close();

            }
            fileWriter.flush();
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
