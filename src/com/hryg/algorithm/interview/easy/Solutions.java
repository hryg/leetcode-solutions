package com.hryg.algorithm.interview.easy;

public class Solutions {
    private static Solutions instance = new Solutions();

    private Solutions() {}

    public static Solutions getInstance() {
        return instance;
    }

    /**
     * 给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。
     * 不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。
     *
     * 示例：
     * 给定数组: nums = [1,1,2],
     * 你的函数应该返回新长度 2, 并且原数组nums的前两个元素必须是1和2
     * 不需要理会新的数组长度后面的元素
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        System.out.println("length:" + length);
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] == nums[j]) {
                    length--;
                    System.out.println("length--");
                    if (nums[length] != nums[j]) {
                        int temp = nums[length];
                        nums[length] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
        if (length == 2 && nums[0] == nums[1]) {
            length--;
        }
        String arr = "";
        for (int temp : nums) {
            arr += temp + " ";
        }
        System.out.println(arr);
        return length;
    }

    public static void main(String[] arg) {
        System.out.println("length:" + Solutions.getInstance().removeDuplicates(new int[]{1, 1, 1}));
    }
}
