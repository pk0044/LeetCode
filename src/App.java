import java.util.ArrayList;
import java.util.List;

import com.pk.algorithms.QuickSort;
import com.pk.amazon.CopyListWithRandomPtr;
import com.pk.amazon.LargestRecHistorgram;
import com.pk.amazon.LongestPalSub;
import com.pk.amazon.MergerIntervals;
import com.pk.amazon.MostCommonWord;
import com.pk.amazon.NextPermute;
import com.pk.amazon.RemoveNthNode;
import com.pk.amazon.RemoveNthNode.ListNode;
import com.pk.amazon.Search2DMatrix2;
import com.pk.amazon.SortColors;
import com.pk.amazon.SpiralMatrix_1;
import com.pk.amazon.TopKFreqElements;
import com.pk.arrays.MaxChunkSort;
import com.pk.dp.CoinProblem;
import com.pk.dp.EditDistance;
import com.pk.dp.HouseRobber;
import com.pk.dp.JumpGame2;
import com.pk.dp.KeyBoard;
import com.pk.dp.LCS;
import com.pk.dp.LongestPalSubSeq;
import com.pk.dp.MinCoin;
import com.pk.dp.MinCostBruteForce;
import com.pk.dp.MinCostClimbingStairs;
import com.pk.dp.MinCostTickets;
import com.pk.dp.MinFallPathS;
import com.pk.dp.PerfectSquare;
import com.pk.stack.PostFix;

public class App {

	public static void main(String[] args) {
		
//		QuickSort obj = new QuickSort();
//		obj.quickSort(0, 7);
//		obj.display();
		
//		MergerIntervals obj = new MergerIntervals();
//		int[][] a = {{4,5},{1,4},{0,1}};
//		System.out.println(obj.merge(a));
		
//		SpiralMatrix_1 obj = new SpiralMatrix_1();
//		int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//		obj.spiralOrder(a);p
		
//		String name = "purushottam";
//		name = name + 'c';
//		System.out.println(name);
		
		
//		MostCommonWord obj = new MostCommonWord();
//		String[] banned = {"bob", "hit"};
//		System.out.println(obj.mostCommonWord("Bob. hIt, baLl", banned));
		
//		TopKFreqElements obj = new TopKFreqElements();
//		int[] a = {4,1,-1,2,-1,2,3};
//		int[] res = obj.topKFrequent(a, 2);
//		for(int i=0; i<res.length; i++) {
//			System.out.println(res[i]);
//		}
		
//		Search2DMatrix2 obj = new Search2DMatrix2();
//		int[][] a = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//		System.out.println(obj.searchMatrix(a, 5));
		
//		LongestPalSub obj = new LongestPalSub();
//		System.out.println(obj.longestPalindrome("aaabaaaa"));
		
//		LargestRecHistorgram obj = new LargestRecHistorgram();
//		int[] a = {2,1,5,6,2,3};
//		System.out.println(obj.largestRectangleArea(a));
		
//		JumpGame2 obj = new JumpGame2();
//		int[] a = {1,1,1,1,1};
//		System.out.println(obj.jump(a));
		
//		SortColors obj = new SortColors();
//		int[] a = {1,2,0};
//		obj.sortColors(a);
		
//		CopyListWithRandomPtr obj = new CopyListWithRandomPtr();
//		obj.createList();
//		obj.display();
//		System.out.println("########################################");
//		obj.copyRandomList(obj.head);
		
//		NextPermute obj = new NextPermute();
//		int[] a = {3, 2, 1};
//		obj.nextPermutation(a);
//		
		
//		MinCostBruteForce obj = new MinCostBruteForce();
//		int[][] a = {{1, 2, 1}, {3, 4, 2}, {1, 0, 1}};
//		System.out.println(obj.findMinCost(a));
//		
		
//		CoinProblem obj = new CoinProblem();
//		System.out.println(obj.findTotalWays(6));
//		System.out.println(obj.findTotalWaysUtilDP(6));
		
//		Test obj = new Test();
//		obj.tester();
		
//		LCS obj = new LCS();
//		System.out.println(obj.LCSBruteForce("abcde", "ace"));
		
//		LongestPalSubSeq obj = new LongestPalSubSeq();
//		System.out.println(obj.longestPalindromeSubseq("awaearatayau"));
		
//		JumpGame2 obj = new JumpGame2();
//		int[] a = {2, 3, 1, 1, 4};
//		System.out.println(obj.jump(a));
		
	//	System.out.println("/".charAt(0) - '0');
//		System.out.println(10^3);
////		System.out.println("4".charAt(0) - '0');
//		System.out.println(10^0 * ("4".charAt(0) - '0'));
		
//		ArrayList<String> A = new ArrayList<String>();
//
//
//		A.add("-1");
//	
//		PostFix obj = new PostFix();
//		
//		System.out.println(obj.evalRPN(A));
		
////		int[] a = {1, 2, 5};
////		CoinProblem obj = new CoinProblem();
////		System.out.println(obj.change(5, a));
//		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
//		MinFallPathS obj = new MinFallPathS();
//		System.out.println(obj.minFallingPathSum(a));
//	//	System.out.println(obj.minFallingPathSum(A));
//		
//		int[] days = {1,4,6,7,8,20};
//		int[] costs = {7,2,15};
//		MinCostTickets obj = new MinCostTickets();
//		System.out.println(obj.mincostTickets(days, costs));
//		
//		KeyBoard obj = new KeyBoard();
//		System.out.println(obj.minSteps(5));
//		
//		
//		HouseRobber obj = new HouseRobber();
//		int[] a = {1,2,3,1};
//		System.out.println(obj.rob(a));
//		
//		PerfectSquare obj = new PerfectSquare();
//		System.out.println(obj.numSquares(12));
		
		EditDistance obj = new EditDistance();
		System.out.println(obj.minDistance("horse", "ros"));
	}

}
