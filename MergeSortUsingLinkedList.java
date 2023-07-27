import java.util.LinkedList;
import java.util.Scanner;

public class MergeSortUsingLinkedList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		LinkedList<Integer> LinkedList1 = new LinkedList<>();
		LinkedList<Integer> LinkedList2 = new LinkedList<>();
		int T = scn.nextInt();
		for(int i = 0 ; i < T ; i++) {
			
			int sizeLL1 = scn.nextInt();
			for(int j = 0 ; j < sizeLL1 ; j++) {
				int item = scn.nextInt();
				LinkedList1.addLast(item);
			}
			
			int sizeLL2 = scn.nextInt();
			for(int k = 0 ; k < sizeLL2 ; k++) {
				int item = scn.nextInt();
				LinkedList2.addLast(item);
			}
			
			LinkedList<Integer> merge = new LinkedList<>();
			merge = MergeSortLinkedList(LinkedList1 , LinkedList2) ;
			
			for(int l = 0 ; l < merge.size() ; l++) {
				System.out.print(merge.get(l) + " ");
			}
			System.out.println();
		}
		scn.close();
	}
	
	public static LinkedList<Integer> MergeSortLinkedList(LinkedList<Integer> LL1 , LinkedList<Integer> LL2) {
		
		LinkedList<Integer> merge = new LinkedList<>();
		
		while(!LL1.isEmpty() && !LL2.isEmpty()) {
			if(LL1.getFirst() < LL2.getFirst()) {
				int value = LL1.getFirst() ;
				merge.addLast(value);
				LL1.removeFirst();
			}else {
				int value = LL2.getFirst();	
				merge.addLast(value);
				LL2.removeFirst();
			}
		}
		
		if(LL1.isEmpty()) {
			while(!LL2.isEmpty()) {
				int value = LL2.getFirst();
				merge.addLast(value);
				LL2.removeFirst();
			}
		}
		if(LL2.isEmpty()) {
			while(!LL1.isEmpty()) {
				int value = LL1.getFirst();
				merge.addLast(value);
				LL1.removeFirst();
			}
		}
		return merge ;
	}
}
