package util;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class Maths {

	static {
		// make a random sample
		int inputs = 10;
		INDArray features = Nd4j.zeros(inputs);
		for (int i=0; i<inputs; i++)
			features.putScalar(new int[] {i}, Math.random() < 0.5 ? 0 : 1);
		System.out.println("meow");
	}

	public static float mean (float[] x) {
		float sum = 0;
		for (float f : x) {
			sum += f;
		}
		return sum / x.length;
	}
	
	public static float std (float[] x) {
		float sum = 0;
		float mean = mean(x);
		for (float f : x) {
			sum += Math.pow((f - mean), 2);
		}
		return (float) Math.sqrt(sum / x.length);
	}
	
	public static void main(String[] args) {
		float[] a = {2, 4, 6};
		System.out.println("Mean: " + mean(a));
		System.out.println("STD: " + std(a));
	}

}
