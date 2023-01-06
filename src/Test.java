public class Test {
    public static void main(String[] args) {
        int [] array = {1,2,3,3};
        System.out.println(checkDuplicate(array));
    }
    public static boolean checkDuplicate(int [] nums){
        for (int i = 0; i < nums.length ; i++) {
            int temp = nums[i];
            for (int j = i+1; j < nums.length ; j++) {
                if(temp == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
