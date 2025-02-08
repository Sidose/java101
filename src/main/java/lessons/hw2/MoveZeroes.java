package lessons.hw2;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        if (nums == null) {
            throw new RuntimeException("Incorrect input data");
        }

        if (nums.length == 0) {
            throw new RuntimeException("Array is empty");
        }

        if (nums.length > 10000) {
            throw new RuntimeException("Array is out of range");
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] == 0) {
                for(int j = i; j <= nums.length - 1; j++) {
                    if(j+1 <= nums.length - 1) {
                        int tmp = nums[j+1];
                        nums[j] = tmp;
                        nums[j+1] = 0;
                    }
                }
            }
        }


        for(int num: nums) {
            System.out.println(num);
        }
    }


    public static void main(String[] args) {
        int[] nums = {0, 10, 50, 0, 0, 20, 0,  30, 0, 40};

        moveZeroes(nums);
    }
}
