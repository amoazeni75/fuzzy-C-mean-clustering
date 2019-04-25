import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        FuzzyClustering cmean = new FuzzyClustering();

        //get number of class from user
        System.out.println("Please input number of cluster that you want :");
        Scanner sc= new Scanner(System.in);
        String read1 = sc.nextLine();

        //generate random data
        cmean.createRandomData(300,2,1,100, Integer.parseInt(read1));

        //write random data
        cmean.writeDataToFile(cmean.data, "data_set");

        //run clustering algorithm
        cmean.run(Integer.parseInt(read1), 100, cmean.data);

        //write cluster center to file
        cmean.writeDataToFile(cmean.clusterCenters, "cluster_centers");
        System.out.println("Clustering Finished!!!");
    }
}
