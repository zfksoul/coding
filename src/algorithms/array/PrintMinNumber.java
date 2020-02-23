package algorithms.array;

public class PrintMinNumber {
    public static void main(String[] args){
        PrintMinNumber o = new PrintMinNumber();
        int[] numbers = {4, 32, 321};
        System.out.println(o.myPrintMinNumber(numbers));
    }
    public String myPrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0){
            return "";
        }
        for (int i = 0; i < numbers.length; i++){
            for (int j = i + 1; j < numbers.length; j++){
                int a = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int b = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (a > b){
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
        String res = "";
        for (int i = 0; i < numbers.length; i++){
            res += numbers[i];
        }
        return res;
    }
}
