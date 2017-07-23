package pool_test;

import java.util.Random;

import thread_pool.ThreadPool;

public class Runner {
	public static void main(String[] args) {
		ThreadPool tp = new ThreadPool(4);
		int[] nums = new int[1000000];
		
		for(int i = 0; i < 1000; i++){
			int x = i * 1000;
			tp.addTask(()->{
				for(int j = 0; j < 1000; j++){
					nums[x + j] = new Random().nextInt(1000000);
				}
				
				for(int j = 0; j < 1000; j++){
					for(int k = 0; k < 1000; k++){
						if(nums[x + k] > nums[x + j]){
							int temp = nums[x + k];
							nums[x + k] = nums[x + j];
							nums[x + j] = temp;
						}
						
					}
				}
			});
		}
		
		tp.start();
		
		for(int i : nums){
			System.out.println(i);
		}
	}
}
