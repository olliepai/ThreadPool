package thread_pool;

import java.util.ArrayDeque;

public class ThreadPool {
	private int totalThreads;
	private Thread[] threads;
	private ArrayDeque<Task> taskQueue;
	
	public ThreadPool(int totalThreads) {
		this.totalThreads = totalThreads;
		
		taskQueue = new ArrayDeque<Task>();
		
		threads = new Thread[totalThreads];
		for (int i = 0; i < totalThreads; i++) {
			threads[i] = new Thread(new Worker(taskQueue));
		}
	}
	
	public void addTask(Task task) {
		taskQueue.add(task);
	}
	
	public void start() {
		for (int i = 0; i < totalThreads; i++) {
			threads[i].start();
		}
		
		for (int i = 0; i < totalThreads; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
