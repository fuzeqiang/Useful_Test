package thread.pool;

import java.util.LinkedList;

public class ThreadPoolTest {

	private final int nThreads;

	private final PoolWorker[] threads;

	private final LinkedList queue;

	public ThreadPoolTest(int nThreads)
	{
		this.nThreads = nThreads;
		queue = new LinkedList();
		threads = new PoolWorker[nThreads];
		for (int i = 0; i < nThreads; i++) {
			threads[i] = new PoolWorker();
			threads[i].start();
		}
	}

	public void execute(Runnable r) {
		synchronized (queue) {
			queue.addLast(r);
			queue.notify();
		}
	}

	private class PoolWorker extends Thread {
		public void run() {
			Runnable r;
			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException ignored) {
						}
					}
					r = (Runnable) queue.removeFirst();
				}
				// If we don't catch RuntimeException,
				// the pool could leak threads
				try {
					r.run();
				} catch (RuntimeException e) {
					// You might want to log something here
				}
			}
		}
	}

	final static class Task implements Runnable {
		private int delay;
		public Task(int delay) {
			this.delay = delay;
		}
		public void run() {
			try {
				Thread.sleep(delay * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ", delay time: " + delay);
		}
	}

	public static void main(String[] args) {
		ThreadPoolTest pool = new ThreadPoolTest(5);
		for (int i = 1; i < 11; i++) {
			pool.execute(new Task(i));
		}
	}

}