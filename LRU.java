import java.util.*;

public class LRU {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of frames: ");
        int numberOfFrames = sc.nextInt();

        System.out.println("Enter number of pages: ");
        int numberOfPages = sc.nextInt();

        System.out.println("Enter the page reference string (Space-separated): ");
        int[] pageReferenceString = new int[numberOfPages];

        for (int i = 0; i < numberOfPages; i++) {
            pageReferenceString[i] = sc.nextInt();
        }

        LinkedList <Integer> frames = new LinkedList<>();
        int pageFaults = 0;

        for(int page : pageReferenceString) {
            if(!frames.contains(page)) {
                if(frames.size() >= numberOfFrames) {
                    frames.removeFirst();
                }

                frames.addLast(page);
                pageFaults++;
            }
            else {
                frames.remove(frames.indexOf(page));
                frames.addLast(page);
            }

            System.out.print("frames: ");

            for(int frame : frames) {
                System.out.print(frame + " ");
                }
                System.out.println();
        }

        

        System.out.println("Total page faults: " + pageFaults);
        sc.close();

    }
    
}
