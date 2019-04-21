public class Main {

    public static void main(String[] args) {
        FuzzyClustering cmean = new FuzzyClustering();
        cmean.createRandomData(100,2,(float) 1.0,(float) 10.0);
        cmean.run(4, 100, cmean.data);
        System.out.println("Hello World!");
    }
}
