package org.neptune.learning.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author bryan
 * 将生产新的异步任务与使用已完成任务的结果分离开来的服务。
 * 将提交任务和处理结果的代码进行解耦
 *
 */
public class MyCompletionService implements Callable<String> {
	private int id;

	public MyCompletionService(int i) {
		this.id = i;
	}

	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newCachedThreadPool();
		CompletionService<String> completion = new ExecutorCompletionService<String>(service);
		for (int i = 0; i < 10; i++) {
			completion.submit(new MyCompletionService(i));
		}
		
		for (int i = 0; i < 10; i++) {
		    System.out.println("index:" + i);
			System.out.println("taken:" + completion.take().get());
		}
		service.shutdown();
	}

	public String call() throws Exception {
		Integer time = (int) (Math.random() * 1000);
		try {
			System.out.println(this.id + " start");
			Thread.sleep(time);
			System.out.println(this.id + " end");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.id + ":" + time;
	}
}