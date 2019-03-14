import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class isBiggerSmarter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<int[]> list = new ArrayList<>();
        int id = 0;
        String s;
        while(true){
            s = br.readLine();
            if(s == null || s.equals(""))
                break;
            StringTokenizer str = new StringTokenizer(s);
            int weight = Integer.parseInt(str.nextToken());
            int IQ = Integer.parseInt(str.nextToken());
            list.add(new int[]{++id, weight, IQ});
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1[1] > o2[1])
                return 1;
            else if (o1[1] == o2[1])
                return 0;
            return -1;
        });
        int[] arr = new int[list.size()];
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(1, arr[i]);
            for (int k = 0; k < i; k++)
                if (list.get(i)[2] < list.get(k)[2] && list.get(i)[1] > list.get(k)[1]) {
                    arr[i] = Math.max(arr[k] + 1, arr[i]);
                }
        }
        int max = 0;
        for (int j : arr) {
            max = Math.max(j, max);
        }
        System.out.println(max);
        int[] sol = new int[max];

        boolean first = true;
        int last = 0;
        for (int j = arr.length - 1; j >= 0 && max > 0; j--) {
            if (arr[j] == max && (first || last < list.get(j)[2])) {
                last = list.get(j)[2];
                sol[--max] = list.get(j)[0];
                first = false;
            }
        }
        for (int j = 0; j < sol.length; j++) {
            System.out.println(sol[j]);
        }
    }
}
