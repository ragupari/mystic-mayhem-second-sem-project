import java.io.*;

public class FileReadWrite {
    public static String[] readNthLine(String userName,int lineNumber){
        try{
        BufferedReader reader = new BufferedReader(new FileReader("Players/"+userName+".txt"));
        String line = null;
        int currentLine = 0;
        while ((line = reader.readLine()) != null) {
            currentLine++;
            if (currentLine == lineNumber) {
                String data[] = line.split(","); // Archer,Chainmail,Excalibur,1,1,0,0,0,Shooter
                reader.close();
                return data;
            }
        }
        
        reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
        }
        return null; // Line number not found
    }


public static void writeNthLine(String userName,int lineNumber, int indexWhichToChange, String content){
    try{
    File inputFile = new File("Players/"+userName+".txt");
    String line1[] = readNthLine(userName, 1);
    String line2[] = readNthLine(userName, 2);
    String line3[] = readNthLine(userName, 3);
    String line4[] = readNthLine(userName, 4);
    String line5[] = readNthLine(userName, 5);
    String line6[] = readNthLine(userName, 6);
    String line7[] = readNthLine(userName, 7);
    String line8[] = readNthLine(userName, 8);
    String line9[] = readNthLine(userName, 9);
    String line10[] = readNthLine(userName, 10);
    String line11[] = readNthLine(userName, 11);
    String [][] writeInput = {line1, line2, line3, line4, line5, line6, line7, line8, line9,line10,line11};
    FileWriter writer = new FileWriter("Players/"+userName+".txt");
            int count = 0;
            while (count<11){
                if (count == lineNumber-1){
                    writeInput[count][indexWhichToChange] = content;
                    String contentToWrite = "";
                    for (String i:writeInput[count]){
                        contentToWrite += (i+",");
                    }
                    writer.write(contentToWrite+"\n");
                    count++;
                }
                else{
                    String contentToWrite = "";
                    for (String i:writeInput[count]){
                        contentToWrite += (i+",");
                    }
                    writer.write(contentToWrite+"\n");
                    count++;
                }
             
            }  
            writer.close();      
    } catch (IOException e) {
    System.out.println("An error occurred while reading the file: " + e.getMessage());
    e.printStackTrace();
    }
}


}