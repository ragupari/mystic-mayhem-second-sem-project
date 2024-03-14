import java.util.Scanner;
public class Player {
    private String name;
    private String userName;
    private int GC;
    private int XP;
    private Archer archer;
    private Knight knight;
    private Mage mage;
    private Healer healer;
    private Creature creature;
    private String homeland;

    public Player(String userName){
        this.userName = userName;
        this.name = FileReadWrite.readNthLine(this.userName,1)[1];
        this.GC = Integer.parseInt(FileReadWrite.readNthLine(this.userName,3)[1]);
        this.XP = Integer.parseInt(FileReadWrite.readNthLine(this.userName,4)[1]);
        this.homeland=FileReadWrite.readNthLine(this.userName,11)[1];
        this.archer = new Archer(this,this.homeland);
        this.knight = new Knight(this,this.homeland);
        this.mage = new Mage(this,this.homeland);
        this.healer = new Healer(this,this.homeland);
        this.creature = new Creature(this,this.homeland);
    }
    public void setHomeland(){
        this.homeland = FileReadWrite.readNthLine(this.userName,11)[1];
    }
    public Archer getArcher(){
        return this.archer;
    }
    public String getHomeland(){
        return this.homeland;
    }
    public Knight getKnight(){
        return this.knight;
    }
    public Mage getMage(){
        return this.mage;
    }
    public Healer getHealer(){
        return this.healer;
    }
    public Creature getCreature(){
        return this.creature;
    }
    public String getName(){
        return this.name;
    }
    public int getGC(){
        return this.GC;
    }
    public int getXP(){
        return this.XP;
    }
    public String getUserName(){
        return this.userName;
    }
    public void deductGC(int GC){
        this.GC -= GC;
    }
    public void addGC(int GC){
        this.GC += GC;
    }
    public void addXP(int XP){
        this.XP += XP;
    }
    public static String playerLogin() {

        csvHandle csvHandle = new csvHandle();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.print("New player[N] or Existing player[E]: ");
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("N")) {
            System.out.println("");
                System.out.print("Enter player name: ");
                String name = scanner.next();
                
                boolean userExists = true;
                while (userExists){
                    System.out.println("");
                    System.out.print("Enter a user name: ");
                    String userName = scanner.next();
                    
                    userExists = csvHandle.checkUserName(userName);
                    
                    int userID = csvHandle.getUserID();
                    if (userExists){
                        System.out.println("");
                        System.out.println("Username is alredy taken. Try another");
                    }else{
                        //System.out.print("Enter a password>> ");
                        //password = scanner.nextLine();
                        csvHandle.createNewUser(userID, name, userName);
                        csvHandle.createPlayerTXT(userName,userID, name);
                        System.out.println("");
                        System.out.println("User profile successfully created");
                        return userName;
                    }  
                }
            scanner.close();
            }
            else if (choice.equalsIgnoreCase("E")){
                System.out.println("");
                System.out.println("Enter your username: ");
                String userName = scanner.next();
                if (csvHandle.checkUserName(userName)){
                return userName;
                }
                else{
                    System.out.println("");
                    System.out.println("Invalid Username");
                
                    playerLogin();
                }
            }

            else{
                System.out.println("");
                System.out.println("Invalid Choice");}
                System.exit(0);
            playerLogin();
            return "";
    }
}
