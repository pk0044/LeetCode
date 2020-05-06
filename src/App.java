import com.pk.algorithms.QuickSort;
import com.pk.amazon.MergerIntervals;

public class App {

	public static void main(String[] args) {
		
//		QuickSort obj = new QuickSort();
//		obj.quickSort(0, 7);
//		obj.display();
		
		MergerIntervals obj = new MergerIntervals();
		int[][] a = {{4,5},{1,4},{0,1}};
		System.out.println(obj.merge(a));
	}

}
