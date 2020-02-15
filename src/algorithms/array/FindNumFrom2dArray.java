package algorithms.array;

public class FindNumFrom2dArray {
    public static void main(String[] args){
        FindNumFrom2dArray o = new FindNumFrom2dArray();
        int[][] arr = {{1,2,3,4,5},
                       {2,3,4,5,6},
                       {3,4,5,6,7},
                       {8,9,10,11,12}};
        System.out.println(o.Find(13, arr));
    }
    public boolean Find(int target, int [][] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0){
            return false;
        }
        int i = 0;
        int j = arr[0].length - 1;
        while (i < arr.length && j >= 0){
            if (arr[i][j] > target){
                j--;
            } else if (arr[i][j] < target){
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
