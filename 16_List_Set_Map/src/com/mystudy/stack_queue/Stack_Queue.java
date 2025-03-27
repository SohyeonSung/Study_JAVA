package com.mystudy.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stack_Queue {

	public static void main(String[] args) {
		// 스택(Stack) 클래스 : 바닥이 막힌 통(상자)의 형태
		//    (후입선출 : LIFO - Last In First Out / FILO)
		// 주요메소드 : push(), pop(), peek()
		
		
		System.out.println("==== 스택(Stack) : LIFO - 후입선출 =====");
		Stack<String> stack = new Stack<String>();
		stack.push("1.첫째");
		stack.push("2.둘째");
		stack.push("3.셋째");
		stack.push("4.넷째");
		System.out.println("stack : " + stack);
		System.out.println("stack.size() : " + stack.size());
		
		System.out.println("--- peek() ---");
		System.out.println("stack.peek() : " + stack.peek());
		System.out.println("stack.peek() : " + stack.peek());
		
		System.out.println("stack : " + stack);
		System.out.println("stack.size() : " + stack.size());

		
		System.out.println("--- pop() -----");
//		System.out.println("stack.pop() : " + stack.pop());
//		System.out.println("stack.pop() : " + stack.pop());
//		System.out.println("stack.pop() : " + stack.pop());
//		System.out.println("stack.pop() : " + stack.pop());
		
		// 데이터 없을 때 pop() 사용시 : java.util.EmptyStackException
		//System.out.println("stack.pop() : " + stack.pop()); 
		
		System.out.println("stack : " + stack);
		System.out.println("stack.empty() : " + stack.empty());
		System.out.println("stack.size() : " + stack.size());
		

		System.out.println("--- 스택 전체데이터 사용 ---");

		// while (stack.size() > 0) { // 데이터가 있으면
		while (stack.empty()) { // 데이터가 있으면
			System.out.println("stack.pop() : " + stack.pop());
		}

		System.out.println("stack : " + stack);
		System.out.println("stack.empty() : " + stack.empty());
		System.out.println("stack.size() : " + stack.size());
		
		
		
		
		
		System.out.println("\n ==== Queue : FIFO (선입선출) =====");
		//큐(Queue) 인터페이스 : 파이프 형태(선입선출 : FIFO - First In First Out)
		// 주요기능 : offer(), poll(), peek()
		// LinkedList 클래스 큐 형로 사용
		//----------------
		Queue<String> queue = new LinkedList<String>();
		queue.offer("1번");
		queue.offer("2번");
		queue.offer("3번");
		queue.offer("4번");
				
		System.out.println("queue : " + queue);
		System.out.println("queue.size() : " + queue.size());
				
		String data = queue.peek();
		System.out.println("queue.peek() : " + data);
		System.out.println("queue.peek() : " + queue.peek());
		System.out.println("queue.peek() : " + queue.peek());
		
		System.out.println("queue : " + queue);
		System.out.println("queue.size() : " + queue.size());
		
		
		System.out.println(" --- poll() 데이터 꺼내 쓰기 --- ");
		
		System.out.println("queue.poll()" + queue.poll());
		System.out.println("queue.poll()" + queue.poll());
		System.out.println("queue.poll()" + queue.poll());
		System.out.println("queue.poll()" + queue.poll());
		System.out.println("queue.poll()" + queue.poll()); //null
	//	System.out.println("queue.remove()" + queue.remove()); 	//NoSerchElementException
		
		System.out.println("queue : " + queue);
		System.out.println("queue.size() : " + queue.size());
		
		System.out.println(" -- 큐 전체 데이터 꺼내서 사용 -- ");
		System.out.println("queue.size() : " + queue.size());
		System.out.println("queue.isEmpty() : " + queue.isEmpty());
		while (!queue.isEmpty()) {
			System.out.println("queue.poll()" + queue.poll().charAt(0));
		}
		System.out.println("queue.size() : " + queue.size());
		System.out.println("queue.isEmpty() : " + queue.isEmpty());
	
	}

}









