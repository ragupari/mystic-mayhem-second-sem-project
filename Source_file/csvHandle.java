
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class csvHandle{
    public static boolean checkUserName(String userName)  {
        ArrayList<String> userNames = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {
          BufferedReader br = new BufferedReader(new FileReader("players.csv"));
          while ((line = br.readLine()) != null)
          {
            String[] employee = line.split(splitBy);
            userNames.add(employee[2]);
          }
        }
        catch(IOException e) {
          return false;
        }
        boolean exists = userNames.contains(userName);
        // for (int i = 0; i <userNames.size(); i++){
        //   System.out.println(userNames.get(i));
        // }
        //System.out.println(exists);
        return exists;
      }

    public static int getUserID()  {
        ArrayList<String> userNames = new ArrayList<>();
        String line = "";
        String splitBy = ",";
        try {
          BufferedReader br = new BufferedReader(new FileReader("players.csv"));
          while ((line = br.readLine()) != null)
          {
            String[] employee = line.split(splitBy);
            userNames.add(employee[2]);
          }
        }
        catch(IOException e) {
          return 1;
        }
        return userNames.size()+1;
    }



      public static void createNewUser(int userID, String Name, String userName){

        String csvFilePath = "players.csv";
        String userIDStr = String.valueOf(userID);
        String[][] newData = {
                {userIDStr ,Name, userName,}
        };

        try {
            File file = new File(csvFilePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
            StringBuilder csvData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                csvData.append(line).append("\n");
            }
            reader.close();
            for (String[] data : newData) {
                StringBuilder newRow = new StringBuilder();
                for (int i = 0; i < data.length; i++) {
                    newRow.append("");
                    newRow.append(data[i].replaceAll("", ""));
                    newRow.append("");
                    if (i != data.length - 1) {
                        newRow.append(',');
                    }
                }
                newRow.append("\n");
                csvData.append(newRow);
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath));
            writer.write(csvData.toString());
            writer.close();

            //System.out.println("Use777r profile successfully created!");
        } catch (IOException e) {
            //System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
      }
      public static void createPlayerTXT(String userName, int ID, String name) {
        // Define the file path
        String filePath = (userName + ".txt");



        File directory = new File("Players");
        if (!directory.exists()) {
            directory.mkdir(); }

        try {
            // Create a FileWriter object
            FileWriter fileWriter = new FileWriter("Players/"+filePath);

            // Write to the file
            fileWriter.write("Name,"+name+"\n");
            fileWriter.write("User ID,"+ID+"\n");
            fileWriter.write("GC,500\n");
            fileWriter.write("XP,1\n");
            // fileWriter.write("Archer,None,0,0,0,0\n"); // archer, equip, current price, attack, defence, health, speed
            // fileWriter.write("Knights,None,0,0,0,0\n"); 
            // fileWriter.write("Mages,None,0,0,0,0\n"); 
            // fileWriter.write("Healers,None,0,0,0,0\n"); 
            // fileWriter.write("Mythical Creatures,None,0,0,0,0\n"); 

            fileWriter.write("Archer,None,None,None,None,None,None,None,None,0,\n"); // archer, equip, current price, attack, defence, health, speed
            fileWriter.write("Knight,None,None,None,None,None,None,None,None,0,\n"); 
            fileWriter.write("Mage,None,None,None,None,None,None,None,None,0,\n"); 
            fileWriter.write("Healer,None,None,None,None,None,None,None,None,0,\n"); 
            fileWriter.write("Creature,None,None,None,None,None,None,None,None,0,\n"); 
            fileWriter.write("War,None,None,\n");
            fileWriter.write("Homeground,Hillcrest,"); 

            // Close the FileWriter
            fileWriter.close();

            //System.out.println("File created and written successfully!");
        } catch (IOException e) {
            //System.out.println("An error occurred while writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

  public static String getStats(String userName, String reqInfoType, String reqStat) { //reqStat = None for ID, GC, XP
        String filePath = "Players/"+userName+".txt";
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
          
            String line = bufferedReader.readLine(); //Name
            String name = line.split(",")[1];   

            String line0 = bufferedReader.readLine(); //user
            String ID = line0.split(",")[1];

            String line1 = bufferedReader.readLine(); //GC
            String GC = line1.split(",")[1];

            String line2 = bufferedReader.readLine(); //XP
            String XP = line2.split(",")[1];

            String line3 = bufferedReader.readLine(); 
            String Archer[] = line3.split(",");//Archer

            String line4 = bufferedReader.readLine(); 
            String Knight[] = line4.split(",");

            String line5 = bufferedReader.readLine(); 
            String Mage[] = line5.split(",");

            String line6 = bufferedReader.readLine(); 
            String Healers[] = line6.split(",");

            String line7 = bufferedReader.readLine(); 
            String Creatures[] = line7.split(",");
            bufferedReader.close();

            switch (reqInfoType) {
              case "Name":
                  return name;
              case "GC":
                  return GC;
              case "ID":
                  return ID;
              case "XP":
                  return XP;
              case "Archer":
                  switch (reqStat) {
                      case "Armour":
                          return Archer[1];
                      case "Artefact":
                          return Archer[2];
                      case "Shooter":
                          return Archer[3];
                      case "Ranger":
                          return Archer[4];
                      case "Sunfire":
                          return Archer[5];
                      case "Zing":
                          return Archer[6];
                      case "Saggitarius":
                          return Archer[7];
                      case "current":
                          return Archer[8];
                  }
              case "Knight":
                  switch (reqStat) {
                      case "Armour":
                          return Knight[1];
                      case "Artefact":
                          return Knight[2];
                      case "Squire":
                          return Knight[3];
                      case "Cavalier":
                          return Knight[4];
                      case "Templar":
                          return Knight[5];
                      case "Zoro":
                          return Knight[6];
                      case "Swiftblade":
                          return Knight[7];
                      case "Current":
                          return Knight[8];
                  }
              case "Mage":
                  switch (reqStat) {
                      case "Armour":
                          return Mage[1];
                      case "Artefact":
                          return Mage[2];
                      case "Warlock":
                          return Mage[3];
                      case "Illusionist":
                          return Mage[4];
                      case "Enchanter":
                          return Mage[5];
                      case "Conjurer":
                          return Mage[6];
                      case "Eldritch":
                          return Mage[7];
                      case "Current":
                          return Mage[8];
                  }
          
              case "Healer":
                  switch (reqStat) {
                      case "Armour":
                          return Healers[1];
                      case "Artefact":
                          return Healers[2];
                      case "Soother":
                          return Healers[3];
                      case "Medic":
                          return Healers[4];
                      case "Alchemist":
                          return Healers[5];
                      case "Saint":
                          return Healers[6];
                      case "Lightbringer":
                          return Healers[7];
                      case "Current":
                          return Healers[8];
                  }
              case "Creature":
                  switch (reqStat) {
                      case "Armour":
                          return Creatures[1];
                      case "Artefact":
                          return Creatures[2];
                      case "Dragon":
                          return Creatures[3];
                      case "Basilisk":
                          return Creatures[4];
                      case "Hydra":
                          return Creatures[5];
                      case "Phoenix":
                          return Creatures[6];
                      case "Pegasus":
                          return Creatures[7];
                      case "Current":
                          return Creatures[8];
                  }
          }
          

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
  }

}