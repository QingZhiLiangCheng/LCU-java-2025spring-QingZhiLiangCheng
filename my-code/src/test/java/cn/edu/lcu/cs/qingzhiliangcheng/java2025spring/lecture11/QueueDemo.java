package cn.edu.lcu.cs.qingzhiliangcheng.java2025spring.lecture11;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列演示
 * 
 * @author Ling
 *
 */
class QueueDemo {

	/**
	 * 队列演示
	 */
	@Test
	public void queue() {
		Queue<Integer> queue = new LinkedList<Integer>();
		System.out.println("\tqueue = " + queue);

		// 进队列（队尾），若空间不足，抛出异常
		System.out.println("queue.offer(1) = " + queue.offer(1));
		System.out.println("\tqueue = " + queue);

		// 进队列，若空间不足，仅返回false，不抛异常
		System.out.println("queue.add(2) = " + queue.add(2));
		System.out.println("\tqueue = " + queue);

		// 查询队首元素，若队列空，返回null，不抛异常
		System.out.println("queue.peek() = " + queue.peek());
		System.out.println("\tqueue = " + queue);
		// 查询队首元素，若队列空，抛异常
		System.out.println("queue.element() = " + queue.element());
		System.out.println("\tqueue = " + queue);

		// 出队列（队首），若队列空，仅返回null，不抛异常
		System.out.println("queue.poll() = " + queue.poll());
		System.out.println("\tqueue = " + queue);
		// 出队列，若队列空，抛异常
		System.out.println("queue.remove() = " + queue.remove());
		System.out.println("\tqueue = " + queue);
	}

	/**
	 * <h5>双端队列演示</h5>
	 * <li>进队列：offer add</li>
	 * <li>出队列：poll remove</li>
	 * <li>查询：peek get</li>
	 * <li>以上三种操作都有队首队尾两种操作，如offerFirst offerLast</li>
	 * <li>建议使用 offer poll peek，因为它们不抛异常</li>
	 */
	@Test
	public void deque() {
		// 建议使用 offer peek poll
		Deque<Integer> deque = new LinkedList<Integer>();
		System.out.println("\tdeque = " + deque);

		deque.offer(1);
		deque.add(2);
		deque.offerFirst(3);
		deque.offerLast(4);

		System.out.println("\tdeque = " + deque);
		System.out.println("deque.remove() = " + deque.remove());
		System.out.println("\tdeque = " + deque);
		System.out.println("deque.pollLast() = " + deque.pollLast());
		System.out.println("\tdeque = " + deque);
	}

}
