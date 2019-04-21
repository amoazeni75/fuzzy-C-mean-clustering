import java.util.ArrayList;
import java.util.Random;

public class FuzzyClustering {
    public ArrayList<ArrayList<Float>> data;
    public ArrayList<ArrayList<Float>> clusterCenters;
    private float u[][];
    private int clusterCount;
    private int iteration;
    private int dimention;
    private int fuzziness;
    private double epsilon;

    public FuzzyClustering(){
        data = new ArrayList<>();
        clusterCenters = new ArrayList<>();
        fuzziness = 2;
        epsilon = 0.01;
    }

    public void run(int clusterNumber, int iter, ArrayList<ArrayList<Float>> data){
        this.clusterCount = clusterNumber;
        this.iteration = iter;
        this.data = data;

        //start algorithm
        //1 assign initial membership values
        assignInitialMembership();


        for (int i = 0; i < iteration; i++) {
            //2 calculate cluster centers
            calculateClusterCenters();

            //3
            updateMembershipValues();

            //4
        }
    }

    /**
     * in this function we genearte random data with specific option
     * @param numberOfData
     * @param dimention
     * @param minRange
     * @param maxRange
     */
    public void createRandomData(int numberOfData, int dimention, float minRange, float maxRange){
        this.dimention = dimention;
        Random r = new Random();
        for (int i = 0; i < numberOfData; i++) {
            ArrayList<Float> tmp = new ArrayList<>();
            for (int j = 0; j < dimention; j++) {
                tmp.add(r.nextFloat() * maxRange + minRange);
            }
            data.add(tmp);
        }
    }

    /**
     * this function generate membership value for each data
     */
    private void assignInitialMembership(){
        u = new float[data.size()][clusterCount];
        Random r = new Random();
        for (int i = 0; i < data.size(); i++) {
            float sum = 0;
            for (int j = 0; j < clusterCount; j++) {
                u[i][j] = r.nextFloat() * 10 + 1;
                sum += u[i][j];
            }
            for (int j = 0; j < clusterCount; j++) {
                u[i][j] = u[i][j] / sum;
            }
        }
    }

    /**
     * in this function we calculate value of each cluster
     */
    private void calculateClusterCenters(){
        clusterCenters.clear();
        for (int i = 0; i < clusterCount; i++) {
            ArrayList<Float> tmp = new ArrayList<>();
            for (int j = 0; j < dimention; j++) {
                float cluster_ij;
                float sum1 = 0;
                float sum2 = 0;
                for (int k = 0; k < data.size(); k++) {
                    double tt = Math.pow(u[i][j], fuzziness);
                    sum1 += tt * data.get(i).get(j);
                    sum2 += tt;
                }
                cluster_ij = sum1/sum2;
                tmp.add(cluster_ij);
            }
            clusterCenters.add(tmp);
        }
    }

    /**
     * in this function we will update membership value
     */
    private void updateMembershipValues(){

    }
}
