public class Equipment {
    public static int[] getStat(String equip,  String type) {
        switch (equip){
            case "Armour":
                switch (type){
                    case "Chainmail":
                        int[]stat = {70, 0,1,0,-1};
                        return stat;
                    case "Regalia":
                        int[]stat2 = {105, 0,1,0,0};
                        return stat2;
                    case "Fleece":
                        int[]stat3 = {150, 0,+2,1,-1};
                        return stat3;
                    default: 
                        int[]stat4 = {0, 0,0,0,0};
                        return stat4;
                }
            case "Artefact":
                switch (type) {
                    case "Excalibur":
                        int[]stat = {150,2,0,0,0};
                        return stat;
                    case "Amulet":
                        int[]stat2 = {200,1,-1,1,1};
                        return stat2;
                    case "Crystal":
                        int[]stat3 = {210,2,1,-1,-1};
                        return stat3;
                    default: 
                        int[]stat4 = {0, 0,0,0,0};
                        return stat4;
                }
            default:
                int[]stat4 = {0, 0,0,0,0};
                return stat4;
        }
    }
}