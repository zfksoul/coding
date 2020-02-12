package algorithms.tree;

/**
 * 时间复杂度O(n)
 * 空间复杂度O(logn)
 */
public class PaperFolding {
    public static void main(String[] args){
        PaperFolding o = new PaperFolding();
        o.printAllFolds(3);
    }
    public void printAllFolds(int n){
        if (n < 1){
            return;
        }
        printProcess(1, n, true);
        System.out.println();
    }

    private void printProcess(int i, int n, boolean down) {
        if (i > n){
            return;
        }
        printProcess(i + 1, n, down);
        System.out.print(down ? "down " : "up ");
        printProcess(i + 1, n, !down);
    }
}
