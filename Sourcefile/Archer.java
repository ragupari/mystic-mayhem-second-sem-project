public class Archer extends Character{
    private String setArte;
    private String setArm;
    
    private int[] setArcherValues;


    public Archer(Player player,String homeland){
          super(getCurrent(player.getUserName()),getArmour(player.getUserName()),getArtefact(player.getUserName()),getStats(player.getUserName()),homeland,"Archer");
    }
    static String getCurrent(String userName){
        return FileReadWrite.readNthLine(userName, 5)[8];
    }
    static String getArmour(String userName){
          return FileReadWrite.readNthLine(userName, 5)[1];
    }

    static String getArtefact(String userName){
     return (FileReadWrite.readNthLine(userName, 5)[2]);
    }

     static int[] getStats( String userName){
        String current = FileReadWrite.readNthLine(userName, 5)[8];
        int attack, defence, health, speed;
        switch(current){
            case "Shooter":
                    int[] stats0 = {11,4,6,9};
                    return stats0;
  
            case "Ranger":
                    int[] stats1 = {14,5,8,10};
                    return stats1;
         
            case "Sunfire":
                    int[] stats2 = {15,5,7,14};
                    return stats2;
          
            case "Zing":
                    int[] stats3 = {16,9,11,14};
                    return stats3;
  
            case "Saggitarius":
                    int[] stats4 = {18,7,12,17};
                    return stats4;
   
            case "None":
                    int[] stats5 = {0,0,0,0};
                    return stats5;
        }
        return null;
     }
//      //public void setArcher(String userName){
//           this.setArm = FileReadWrite.readNthLine(userName, 5)[1];
//           this.setArte = FileReadWrite.readNthLine(userName, 5)[2];
//           this.setArcherValues = getStats(userName);
//           setCharacter(this.setArcherValues,this.setArte,this.setArm);
//     }
    public String getCharacter() {return "Archer";}
}
