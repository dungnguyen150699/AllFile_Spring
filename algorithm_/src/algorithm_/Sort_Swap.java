package algorithm_;

import java.util.Arrays;


public final class Sort_Swap {
	public int a = 1;
	
	public static void main(String[] args) {
		Sort_Swap sw = new Sort_Swap();
		Sort_Swap sw1 = new Sort_Swap();
		sw.a = 1; sw1.a = 2;
		sw = sw1;
		System.out.println(sw.a); // Result = 2 but why Integer not same
		
//		Integer x = 1;
//		Integer x1 = 2;
//		sw.Swap(x, x1);
//		System.out.println(x+"-"+x1);
	}

	// Swap dont need variable temp
	public static void Swap(Integer a, Integer b) {
		b = a + b;
		a = new Integer(b - a);
		b = new Integer(b - a);
		System.out.println(a + "-" + b);
	}
	


}

class Bubble_Sort {

	public static int a[] = { 1, 2, 3, 4, 5 };
	public static int a1[] = { 5, 4, 3, 2, 1 };

	/*
	 * Ý tưởng:
	 * 
	 * Xuất phát từ cuối dãy, đổi chỗ các cặp phần tử kế cận để đưa phần tử nhỏ hơn
	 * trong cặp phần tử đó về vị trí đầu dãy hiện hành, sau đó sẽ không xét đến nó
	 * ở bước tiếp theo
	 * 
	 * Ở lần xử lý thứ i có vị trí đầu dãy là i
	 * 
	 * Lặp lại xử lý trên cho đến khi không còn cặp phần tử nào để xét
	 */

	void BubbleSort(int a[], int n) { // Best = Bad = n(n-1)/2	
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
				if (a[j] < a[j - 1]) {
					a[j] = a[j] + a[j-1];
					a[j-1] = a[j] - a[j-1];
					a[j] = a[j] - a[j-1];
				}
//					Integer temp1 = new Integer(a[j]);
//					Integer temp2 = new Integer(a[j-1]);
//					Sort_Swap.Swap(temp1, temp2);
//					
//					a[j] = temp1.intValue();
//					a[j-1] = temp2.intValue();
			}

		}
		printArray(a);
	}
	
	void InterchangeSort(int a[], int n){ // Best = Bad = n(n-1)/2	
	    for (int i = 0; i < n - 1; i++)
	        for (int j = i + 1; j < n; j++)
		        if(a[i] > a[j]) {//nếu có nghịch thế thì đổi chỗ
					a[j] = a[j] + a[j-1];
					a[j-1] = a[j] - a[j-1];
					a[j] = a[j] - a[j-1];
		        }
//		        	Sort_Swap.Swap(a[i], a[j]);
	}

	void printArray(int a[]) {
		for (int i : a) {
			System.out.print(i);
		}
	}

	public static void main(String[] args) {
		Bubble_Sort bs = new Bubble_Sort();
		bs.BubbleSort(a1, a1.length);
		bs.InterchangeSort(a1, a1.length);
	}
}

class Insertion_Sort{
	
	public static int a[] = { 1, 2, 3, 4, 5 };
	public static int a1[] = { 5, 4, 3, 2, 1 };
	
	/*
	 * Ý tưởng chính:
		Tìm cách chèn phần tử a[i] vào vị trí thích hợp của đoạn đã được sắp để có dãy mới a[0] , a[1] ,... , a[i-1] trở nên có thứ tự
		Vị trí này chính là pos thỏa : a[pos-1] <= a[i ]< a[pos] (1 <= pos <= i) 

	 */
	void InsertionSort(int a[], int n){	// Best = n-1 ; Bad = n(n-1)/2
		int pos, x;
		for(int i = 1; i < n; i++){ //đoạn a[0] đã sắp
			x = a[i]; 
			pos = i;
			while(pos > 0 && x < a[pos-1]){
				a[pos] = a[pos-1];	// dời chỗ
				pos--;
			}
			a[pos] = x;
		}
	}
}

class Select_Sort{
	
	/*
	 * Ý tưởng: mô phỏng một trong những cách sắp xếp tự nhiên nhất trong thực tế:
		Chọn phần tử nhỏ nhất trong n phần tử ban đầu, đưa phần tử này về vị trí đúng là đầu dãy hiện hành
		Xem dãy hiện hành chỉ còn n-1 phần tử của dãy ban đầu, 
		bắt đầu từ vị trí thứ 2; lặp lại quá trình trên cho dãy hiện hành... đến khi dãy hiện hành chỉ còn 1 phần tử
	 */
	void SelectionSort(int a[], int n) // Best = bad = n(n-1)/2
	{
		int min; // chỉ số phần tử nhỏ nhất trong dãy hiện hành
		for (int  i = 0; i < n - 1; i++){
			min = i; 
			for(int j = i + 1; j < n; j++)
		   	   if (a[j] < a[min])
			       min = j; // ghi nhận vị trí phần tử nhỏ nhất
			if (min != i)
		   	   Sort_Swap.Swap(a[min], a[i]);
		}
	}
}

class BinarySort{
	
}
