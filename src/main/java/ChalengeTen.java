import java.util.ArrayList;
import java.util.List;

public class ChalengeTen {
    public void mainChalengeTen() {
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);

        list2.add(2);
        list2.add(0);
        connections.add(list1);
        connections.add(list2);

        criticalConnections(2, connections);
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> criticalConnections = new ArrayList<>();
        List<Integer> sums = new ArrayList<>();

        for(int i=0;i<n;i++){
            int finalI = i;
            sums.add(connections.get(i)
                    .stream()
                    .filter(l -> l == finalI)
                    .mapToInt(l -> l)
                    .sum());
            System.out.println(sums);
        }
        return criticalConnections;
    }
}
