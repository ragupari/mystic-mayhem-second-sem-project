public class Mage extends Character {
    private String setArm;
    private String setArte;
    private int[] setMageValues;

    public Mage(Player player,String homeland){
        super(getCurrent(player.getUserName()),getArmour(player.getUserName()),getArtefact(player.getUserName()),getStats(player.getUserName()), homeland,"Mage");
  }
  static String getCurrent(String userName){
      return FileReadWrite.readNthLine(userName, 7)[8];
  }

    static String getArmour(String userName) {
        return FileReadWrite.readNthLine(userName, 7)[1];
    }

    static String getArtefact(String userName) {
        return FileReadWrite.readNthLine(userName, 7)[2];
    }

    static int[] getStats(String userName) {
        String current = FileReadWrite.readNthLine(userName, 7)[8];
        int attack, defence, health, speed;
        switch (current) {
            case "Warlock":
                int[] stats0 = {12, 7, 10, 12};
                return stats0;

            case "Illusionist":
                int[] stats1 = {13, 8, 12, 14};
                return stats1;

            case "Enchanter":
                int[] stats2 = {16, 10, 13, 16};
                return stats2;

            case "Conjurer":
                int[] stats3 = {18, 15, 14, 12};
                return stats3;

            case "Eldritch":
                int[] stats4 = {19, 17, 18, 14};
                return stats4;

            case "None":
                int[] stats5 = {0, 0, 0, 0};
                return stats5;
        }
        return null;
    }

    // public void setMage(String userName) {
    //     this.setArm = FileReadWrite.readNthLine(userName, 7)[1];
    //     this.setArte = FileReadWrite.readNthLine(userName, 7)[2];
    //     this.setMageValues = getStats(userName);
    //     setCharacter(this.setMageValues, this.setArte, this.setArm);
    // }

}

