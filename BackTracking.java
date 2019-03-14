import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class BackTracking {
    public static boolean hasSolution = false;
    public static Set<Set<Integer>> tempSolution = new HashSet<>();
    public static int solutionSize = 0;
    public static int universeSize = 0;

    public static void setUp(){
        solutionSize = 15;
        universeSize = 31;
        Set<Integer> universe = UniverseBuilder(universeSize);
        ArrayList<Set<Integer>> subsets = new ArrayList<Set<Integer>>();
        Set<Integer> t1 = new HashSet<Integer>(Arrays.asList(1,2,3));
        Set<Integer> t2 = new HashSet<Integer>(Arrays.asList(4,5,6,7,8,9,10));
        Set<Integer> t3 = new HashSet<Integer>(Arrays.asList(1,11,12,13));
        Set<Integer> t4 = new HashSet<Integer>(Arrays.asList(4,14,15,16,17,18));
        Set<Integer> t5 = new HashSet<Integer>(Arrays.asList(11,19));
        Set<Integer> t6 = new HashSet<Integer>(Arrays.asList(5,20));
        Set<Integer> t7 = new HashSet<Integer>(Arrays.asList(14,21,22,23));
        Set<Integer> t8 = new HashSet<Integer>(Arrays.asList(15,19,24,25,26));
        Set<Integer> t9 = new HashSet<Integer>(Arrays.asList(27));
        Set<Integer> t10= new HashSet<Integer>(Arrays.asList(6,16,20,24));
        Set<Integer> t11 = new HashSet<Integer>(Arrays.asList(2,7,25,27,28,29));
        Set<Integer> t12 = new HashSet<Integer>(Arrays.asList(8,12,21,28,30));
        Set<Integer> t13 = new HashSet<Integer>(Arrays.asList(13,17,29,30));
        Set<Integer> t14 = new HashSet<Integer>(Arrays.asList(9,18,22,26,31));
        Set<Integer> t15 = new HashSet<Integer>(Arrays.asList(3,10,23,31));
        subsets.add(t1);
        subsets.add(t2);
        subsets.add(t3);
        subsets.add(t4);
        subsets.add(t5);
        subsets.add(t6);
        subsets.add(t7);
        subsets.add(t8);
        subsets.add(t9);
        subsets.add(t10);
        subsets.add(t11);
        subsets.add(t12);
        subsets.add(t13);
        subsets.add(t14);
        subsets.add(t15);
        boolean[] partialSolution = new boolean[subsets.size()];
        backtrack(universe, subsets, partialSolution, 0);
        printSolution(tempSolution);
    }

    public static void printSolution(Set<Set<Integer>> print){
        for(Set<Integer> set : print){
            System.out.println(set);
        }
    }

    public static Set<Integer> UniverseBuilder(int n){
        Set<Integer> universe = new HashSet<>();
        for(int i = 1; i <= n; i++)
            universe.add(i);
        return universe;
    }

    public static void backtrack(Set<Integer> universe, ArrayList<Set<Integer>> subsets, boolean[] partialSolution, int k){
        if(isSolution(universe, subsets, partialSolution))
            processSolution(subsets, partialSolution);
        else{
            boolean[] candidates = new boolean[2];
            candidates[0] = true;
            candidates[1] = false;
            for(int i = 0; i < candidates.length && k < partialSolution.length; i++){
                partialSolution[k] = candidates[i];
                backtrack(universe, subsets, partialSolution, k  +1);
            }
        }
    }

    private static boolean isSolution(Set<Integer> universe, ArrayList<Set<Integer>> subsets, boolean[] candidate) {
        int counter = 0;
        Set<Integer> temp = new HashSet<>();
        for(int i  = 0; i < candidate.length; i++){
            if(candidate[i]){
                counter++;
                if(counter == solutionSize && solutionSize != 0)
                    return false;
                temp.addAll(subsets.get(i));
            }
        }
        return temp.containsAll(universe);
    }

    private static void processSolution(ArrayList<Set<Integer>> subsets, boolean[] partialSolution){
        if(!hasSolution)
            hasSolution = true;
        tempSolution.clear();
        for(int i = 0; i < partialSolution.length; i++){
            if(partialSolution[i])
                tempSolution.add(subsets.get(i));
        }
        solutionSize = tempSolution.size();
    }
}
