import java.util.*;

public class Shoemaker {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for(int k = 0; k < cases; k++) {
            int size = input.nextInt();
            ArrayList<double[]> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                double days = input.nextInt();
                double  cost = input.nextInt();
                list.add(new double[2]);
                list.get(i)[0] = i + 1;
                list.get(i)[1] = (cost / days);
            }
            Collections.sort(list, (o1, o2) -> {
                if(o1[1] < o2[1])
                    return 1;
                else if(o1[1] == o2[1])
                    return 0;
                return -1;
            });
            for(int i = 0; i < size; i++){
                System.out.print((int)list.get(i)[0]);
                if(i != size -1)
                    System.out.print(" ");
            }
            if(k != cases - 1)
                System.out.println("\n");
            else
                System.out.println();
        }
    }
}

