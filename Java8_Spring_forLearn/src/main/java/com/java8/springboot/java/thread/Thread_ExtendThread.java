package com.java8.springboot.java.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Thread_ExtendThread extends Thread {
	public List<String> list;
	public Vector<String> vector;

	public Thread_ExtendThread(List<String> arrayList, Vector<String> vector) {
		this.list = list;
		this.vector = vector;
	}
	
	@Override
	public void run() {
			{
			try  {
				System.out.println("ok");
				// Displaying the thread that is running
				System.out.println("Thread " + Thread.currentThread().getId() + " is running");
//				list.add(Thread.currentThread().getId() + "ArrayList"); // Lỗi ở đây thì ko chạy vector ở dưới
				vector.add(Thread.currentThread().getId() + "Vector");	
//				System.out.println(list.toString());
				System.out.println(vector.toString());
			} catch (Exception e) {
				// Throwing an exception
				System.out.println(e.getMessage());
			}
		}
	}
}

//Main Class You should run config to multi class in here
class Multithread {
	public synchronized static void main(String[] args) {
//     int n = 8; // Number of threads
//     for (int i = 0; i < n; i++) {
//         Thread object
//             = new Thread(new Thread_ExtendThread());
//         object.start();
//     }
//		List<String> list = Collections.synchronizedList(new ArrayList<String>());
		List<String> list = new ArrayList();
		Vector<String> vector = new Vector<String>();
		list.add("List Synchronized Begin");
		vector.add("Vector Synchronized Begin");
		int n = 8; // Number of threads
		for (int i = 0; i < n; i++) {
			Thread object = new Thread(new Thread_ExtendThread(list, vector));
			object.start();
//			new Thread_ExtendThread(list, vector).start();
		}
//		synchronized(list){
//		Thread t = new Thread_ExtendThread(list,vector);
//		t.start();
//		t.stop();
		list.add("List Synchronized end");
		vector.add("Vector Synchronized end");
		
		// cái này sẽ ko thể in ra được vì nó đnag là đa luồng đm ở đây ngu đi chứ chả khôn hơn tý gì
		System.out.println(list.toString());
		System.out.println(vector.toString());
//		}
	}
}
