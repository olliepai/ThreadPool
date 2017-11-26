package thread_pool;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Worker implements Runnable {
	private ArrayDeque<Task> taskQueue;
	public Worker(ArrayDeque<Task> taskQueue) {
		this.taskQueue = taskQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!taskQueue.isEmpty()) {
			Task task = taskQueue.remove();
			task.perform();
		}
	}


}
