import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class ReadWrite {

    public static void Write(String fileloc) {

        String data;

        System.out.println("Enter the data to be written");
        data = System.console().readLine();

        try {
            FileWriter fw = new FileWriter(fileloc);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Read(String loc) {

        try {
            FileReader fr = new FileReader(loc);
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {

        Write("C:\\Coding\\test.txt");
        Read("C:\\Coding\\C++\\test.cpp");

    }

}
