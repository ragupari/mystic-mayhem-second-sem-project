public class Healer extends Character {
    private String setArm;
    private String setArte;
    private int[] setHealerValues;

    public Healer(Player player, String homeland){
        super(getCurrent(player.getUserName()),getArmour(player.getUserName()),getArtefact(player.getUserName()),getStats(player.getUserName()),homeland,"Healer");
  }
  static String getCurrent(String userName){
      return FileReadWrite.readNthLine(userName, 8)[8];
  }
    static String getArmour(String userName) {
        return FileReadWrite.readNthLine(userName, 8)[1];
    }

    static String getArtefact(String userName) {
        return FileReadWrite.readNthLine(userName, 8)[2];
    }

    static int[] getStats(String userName) {
        String current = FileReadWrite.readNthLine(userName, 8)[8];
        int attack, defence, health, speed;
        switch (current) {
            case "Soother":
                int[] stats0 = {10, 8, 9, 6};
                return stats0;

            case "Medic":
                int[] stats1 = {12, 9, 10, 7};
                return stats1;

            case "Alchemist":
                int[] stats2 = {13, 13, 13, 13};
                return stats2;

            case "Saint":
                int[] stats3 = {16, 14, 17, 9};
                return stats3;

            case "Lightbringer":
                int[] stats4 = {17, 15, 19, 12};
                return stats4;

            case "None":
                int[] stats5 = {0, 0, 0, 0};
                return stats5;
        }
        return null;
    }

    // public void setHealer(String userName) {
    //     this.setArm = FileReadWrite.readNthLine(userName, 8)[1];
    //     this.setArte = FileReadWrite.readNthLine(userName, 8)[2];
    //     this.setHealerValues = getStats(userName);
    //     setCharacter(this.setHealerValues, this.setArte, this.setArm);
    // }

}
