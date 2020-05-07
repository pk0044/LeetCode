import com.pk.algorithms.QuickSort;
import com.pk.amazon.MergerIntervals;
import com.pk.amazon.SpiralMatrix_1;

public class App {

	public static void main(String[] args) {
		
//		QuickSort obj = new QuickSort();
//		obj.quickSort(0, 7);
//		obj.display();
		
//		MergerIntervals obj = new MergerIntervals();
//		int[][] a = {{4,5},{1,4},{0,1}};
//		System.out.println(obj.merge(a));
		
		SpiralMatrix_1 obj = new SpiralMatrix_1();
		int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		obj.spiralOrder(a);
	}

}
