import java.util.*;

public class FIFO {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of frames: ");
        int numberOfFrames = sc.nextInt();

        System.out.println("Enter number of pages: ");
        int numberOfPages = sc.nextInt();

        System.out.println("Enter the page reference string (space-separated): ");
        int [] pageReferenceString = new int[numberOfPages];

        for (int i = 0; i < numberOfPages; i++) {
            pageReferenceString[i] = sc.nextInt();
        }

        int[] frames = new int[numberOfFrames];
        Arrays.fill(frames,-1);
        int pageFaults = 0;
        int pgHits = 0;
        int currentIndex = 0;

        for(int page : pageReferenceString) {
            boolean pageHit = false;

            for(int frame : frames) {
                if(frame == page) {
                    pageHit = true;
                    pgHits++;
                    break;
                }
            }

            if(!pageHit) {
                frames[currentIndex] = page;
                currentIndex = (currentIndex + 1) % numberOfFrames;
                pageFaults++;
            }

            System.out.println("Frames: ");

            for(int frame : frames) {
                System.out.println(frame + " ");
            }
            System.out.println();
        }

        System.out.println("Total Page Faults: " + pageFaults);
        float pfrate = (float) pageFaults / numberOfPages;
        System.out.println("Page fault rate: " + pfrate );
        System.out.println("Total Page Hits: "  + pgHits);
        float phrate = (float) pgHits / numberOfPages;
        System.out.println("Page Hit rate: " + phrate);
        sc.close();
    }
    
}
