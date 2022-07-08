package chalengeNine;

import java.util.*;

public class ChalengeNine implements Travel {
    static Map<String, List<String>> reaches = new HashMap<>();

    public void chalengeMain() {
        Scanner scanner = new Scanner(System.in);
        setReaches();

        System.out.print("Local de partida: ");
        String from = scanner.nextLine();
        System.out.print("Local de chegada: ");
        String to = scanner.nextLine();
        System.out.print("Número de conexões: ");
        int numberConnections = scanner.nextInt();

        System.out.println(isReachable(from, to, numberConnections));
    }

    public void setReaches(){
        List<String> bsb = new ArrayList<>();
        bsb.add("GRU");
        bsb.add("NAT");
        bsb.add("SSA");
        List<String> gru = new ArrayList<>();
        gru.add("REC");
        gru.add("POA");
        List<String> ssa = new ArrayList<>();
        ssa.add("NAT");
        ssa.add("REC");
        reaches.put("POA", Collections.singletonList("BSB"));
        reaches.put("BSB", bsb);
        reaches.put("GRU", gru);
        reaches.put("NAT", new ArrayList<>());
        reaches.put("SSA", ssa);
        reaches.put("REC", new ArrayList<>());
        reaches.put("SDU", Collections.singletonList("SSA"));
        reaches.put("VCP", Collections.singletonList("SSA"));
    }

    @Override
    public boolean isReachable(String from, String to, int numberConnections) {
        if(reaches.get(from).contains(to)){
            return true;
        } else if(numberConnections == 0) {
            return false;
        } else {
            if(reaches.get(from).isEmpty()){
                return false;
            } else {
                isReachable(reaches.get(from).stream().findAny().get(), to, numberConnections - 1);
            }
        }
        return false;
    }
}
