package algorithms.others;

/**
 * 一个人被所有人认识，这个人被选为镇长
 */
public class FunnyTown {
    public int town(int num, String[] strs){
        if (num <= 0 || strs == null || strs.length == 0){
            return num == 1 ? 1 : -1;
        }
        int[] map = new int[num];
        String[] tmp = null;
        for (int i = 0; i < strs.length; i++){
            tmp = strs[i].split(" ");
            if (!tmp[0].equals(tmp[1])){
                map[Integer.valueOf(tmp[0]) - 1]--;
                map[Integer.valueOf(tmp[1]) - 1]++;
            }
        }
        for (int i = 0; i < map.length; i++){
            if (map[i] == num - 1){
                return i + 1;
            }
        }
        return -1;
    }
}

