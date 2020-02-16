package algorithms.tree;

public class VerifySquenceOfBST {
    public static void main(String[] args){
        VerifySquenceOfBST o = new VerifySquenceOfBST();
        int[] arr = {4,6,7,5};
        System.out.println(o.VerifySquenceOfBST(arr));
    }
    public boolean VerifySquenceOfBST(int [] arr) {
        if (arr == null || arr.length == 0){
            return false;
        }
        return process(arr, 0, arr.length - 1);
    }
    public boolean process(int[] arr, int l, int r){
        if (l >= r){
            return true;
        }
        int k = l;
        for(; k < r; k++){
            if (arr[k] >= arr[r]){
                break;
            }
        }
        for (int i = k; i < r; i++){
            if (arr[i] < arr[r]){
                return false;
            }
        }
        return process(arr, l, k - 1) && process(arr, k, r - 1);
    }
}
