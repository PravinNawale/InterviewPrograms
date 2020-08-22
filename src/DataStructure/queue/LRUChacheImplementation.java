package DataStructure.queue;

/*
 * Least Recently Used Cache
 * if chache already present in the Queue then bring it to front and this is hit
 * if not remove and add new one this is page fault
 */
public class LRUChacheImplementation {

	public static void main(String[] args) {
		int[] cachePages = { 1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5 };
		Integer pageFrameSize = 3;
		int pageFaultCount = 0;
		int pageHitCount = 0;
		MyQueue<Integer> queue = new MyQueue<Integer>(pageFrameSize);
		for (int i = 0; i < cachePages.length; i++) {
			if (!queue.isFull()) {
				queue.enQueue(cachePages[i]);
				pageFaultCount++;
				System.out.println("Current State of Queue:=>" + queue);
			} else {
				if (queue.contains(cachePages[i])) {
					queue.deQueue();
					queue.enQueue(cachePages[i]);
					pageHitCount++;
				} else {
					queue.deQueue();
					queue.enQueue(cachePages[i]);
					pageFaultCount++;
				}
				System.out.println("Current State of Queue:=>" + queue);
			}
		}
		System.out.println("Total Page Faults:=>" + pageFaultCount);
		System.out.println("Total Page Hits:=>" + pageHitCount);
	}
}
