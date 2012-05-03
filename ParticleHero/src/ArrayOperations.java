

import java.util.Arrays;
public class ArrayOperations {
	
	  /*######################*/
	 /*   Concatenate Lists  */
	/*######################*/
	public static int[] concat(int[] array1, int[] array2) {
		int[] arrayOut = new int[array1.length+array2.length];
		System.arraycopy(array1, 0, arrayOut, 0, array1.length);
		System.arraycopy(array2,0,arrayOut,array1.length,
		array2.length);
		
		return arrayOut;
	}
	public static double[] concat(double[] array1, double[] array2) {
		double[] arrayOut = new double[array1.length+array2.length];
		System.arraycopy(array1, 0, arrayOut, 0, array1.length);
		System.arraycopy(array2,0,arrayOut,array1.length,
		array2.length);
		
		return arrayOut;
	}	
	public static Particle[] concat(Particle[] array1, Particle[] array2) {
		Particle[] arrayOut = new Particle[array1.length+array2.length];
		System.arraycopy(array1, 0, arrayOut, 0, array1.length);
		System.arraycopy(array2,0,arrayOut,array1.length,
		array2.length);
		
		return arrayOut;
	}
	public static double[][] concat(double[][] array1, double[][] array2) {
		double[][] arrayOut = new double[array1.length+array2.length][];
		System.arraycopy(array1, 0, arrayOut, 0, array1.length);
		System.arraycopy(array2,0,arrayOut,array1.length,
		array2.length);
		
		return arrayOut;
	}
	
	public static int[][] concat(int[][] array1, int[][] array2) {
		int[][] arrayOut = new int[array1.length+array2.length][];
		System.arraycopy(array1, 0, arrayOut, 0, array1.length);
		System.arraycopy(array2,0,arrayOut,array1.length,
		array2.length);
		
		return arrayOut;
	}
	public static Particle[][] concat(Particle[][] array1, Particle[][] array2) {
		Particle[][] arrayOut = new Particle[array1.length+array2.length][];
		System.arraycopy(array1, 0, arrayOut, 0, array1.length);
		System.arraycopy(array2,0,arrayOut,array1.length,
		array2.length);
		
		return arrayOut;
	}

	  /*######################*/
	 /*        Append        */
	/*######################*/
	public static int[] append(int[] arrayIn, int appendee) {
		int[] appendeeArrayForm = {appendee};
		int[] arrayOut = concat(arrayIn,appendeeArrayForm);

		return arrayOut;
	}
	public static double[] append(double[] arrayIn, double appendee) {
		double[] appendeeArrayForm = {appendee};
		double[] arrayOut = concat(arrayIn,appendeeArrayForm);

		return arrayOut;
	}	
	public static Particle[] append(Particle[] arrayIn, Particle appendee) {
		Particle[] appendeeArrayForm = {appendee};
		Particle[] arrayOut = concat(arrayIn,appendeeArrayForm);

		return arrayOut;
	}
	
	
	public static double[][] append(double[][] arrayIn, double[] appendee) {
		double[][] appendeeArrayForm = {appendee};
		double[][] arrayOut = concat(arrayIn,appendeeArrayForm);

		return arrayOut;
	}
	
	public static int[][] append(int[][] arrayIn, int[] appendee) {
		int[][] appendeeArrayForm = {appendee};
		int[][] arrayOut = concat(arrayIn,appendeeArrayForm);

		return arrayOut;
	}
	public static Particle[][] append(Particle[][] arrayIn, Particle[] appendee) {
		Particle[][] appendeeArrayForm = {appendee};
		Particle[][] arrayOut = concat(arrayIn,appendeeArrayForm);

		return arrayOut;
	}


	  /*######################*/
	 /*    Remove Element    */
	/*######################*/
	public static int[] removeElement(int[] arrayIn, int index) {
		int[] array1 = new int[index];
		int[] array2 = new int[arrayIn.length-index+1];
		array1 = Arrays.copyOfRange(arrayIn,0,index);
		array2 = Arrays.copyOfRange(arrayIn,index+1,arrayIn.length);
		return concat(array1,array2);		
	}
	public static double[] removeElement(double[] arrayIn, int index) {
		double[] array1 = new double[index];
		double[] array2 = new double[arrayIn.length-index+1];
		array1 = Arrays.copyOfRange(arrayIn,0,index);
		array2 = Arrays.copyOfRange(arrayIn,index+1,arrayIn.length);
		return concat(array1,array2);		
	}
	public static Particle[] removeElement(Particle[] arrayIn, int index) {
		Particle[] array1 = new Particle[index];
		Particle[] array2 = new Particle[arrayIn.length-index+1];
		array1 = Arrays.copyOfRange(arrayIn,0,index);
		array2 = Arrays.copyOfRange(arrayIn,index+1,arrayIn.length);
		return concat(array1,array2);		
	}
	
	
	/*####STUFF####*/
	public static Hole[] concat(Hole[] array1, Hole[] array2) {
		Hole[] arrayOut = new Hole[array1.length+array2.length];
		System.arraycopy(array1, 0, arrayOut, 0, array1.length);
		System.arraycopy(array2,0,arrayOut,array1.length,
		array2.length);
		
		return arrayOut;
	}
	public static Hole[][] concat(Hole[][] array1, Hole[][] array2) {
		Hole[][] arrayOut = new Hole[array1.length+array2.length][];
		System.arraycopy(array1, 0, arrayOut, 0, array1.length);
		System.arraycopy(array2,0,arrayOut,array1.length,
		array2.length);
		
		return arrayOut;
	}
	public static Hole[] append(Hole[] arrayIn, Hole appendee) {
		Hole[] appendeeArrayForm = {appendee};
		Hole[] arrayOut = concat(arrayIn,appendeeArrayForm);

		return arrayOut;
	}
	public static Hole[][] append(Hole[][] arrayIn, Hole[] appendee) {
		Hole[][] appendeeArrayForm = {appendee};
		Hole[][] arrayOut = concat(arrayIn,appendeeArrayForm);

		return arrayOut;
	}
	public static Hole[] removeElement(Hole[] arrayIn, int index) {
		Hole[] array1 = new Hole[index];
		Hole[] array2 = new Hole[arrayIn.length-index+1];
		array1 = Arrays.copyOfRange(arrayIn,0,index);
		array2 = Arrays.copyOfRange(arrayIn,index+1,arrayIn.length);
		return concat(array1,array2);		
	}
	
	
	
	public static BField[] concat(BField[] array1, BField[] array2) {
		BField[] arrayOut = new BField[array1.length+array2.length];
		System.arraycopy(array1, 0, arrayOut, 0, array1.length);
		System.arraycopy(array2,0,arrayOut,array1.length,
		array2.length);
		
		return arrayOut;
	}
	public static BField[][] concat(BField[][] array1, BField[][] array2) {
		BField[][] arrayOut = new BField[array1.length+array2.length][];
		System.arraycopy(array1, 0, arrayOut, 0, array1.length);
		System.arraycopy(array2,0,arrayOut,array1.length,
		array2.length);
		
		return arrayOut;
	}
	public static BField[] append(BField[] arrayIn, BField appendee) {
		BField[] appendeeArrayForm = {appendee};
		BField[] arrayOut = concat(arrayIn,appendeeArrayForm);

		return arrayOut;
	}
	public static BField[][] append(BField[][] arrayIn, BField[] appendee) {
		BField[][] appendeeArrayForm = {appendee};
		BField[][] arrayOut = concat(arrayIn,appendeeArrayForm);

		return arrayOut;
	}
	public static BField[] removeElement(BField[] arrayIn, int index) {
		BField[] array1 = new BField[index];
		BField[] array2 = new BField[arrayIn.length-index+1];
		array1 = Arrays.copyOfRange(arrayIn,0,index);
		array2 = Arrays.copyOfRange(arrayIn,index+1,arrayIn.length);
		return concat(array1,array2);		
	}
	
	
	
	
	public static RField[] concat(RField[] array1, RField[] array2) {
		RField[] arrayOut = new RField[array1.length+array2.length];
		System.arraycopy(array1, 0, arrayOut, 0, array1.length);
		System.arraycopy(array2,0,arrayOut,array1.length,
		array2.length);
		
		return arrayOut;
	}
	public static RField[][] concat(RField[][] array1, RField[][] array2) {
		RField[][] arrayOut = new RField[array1.length+array2.length][];
		System.arraycopy(array1, 0, arrayOut, 0, array1.length);
		System.arraycopy(array2,0,arrayOut,array1.length,
		array2.length);
		
		return arrayOut;
	}
	public static RField[] append(RField[] arrayIn, RField appendee) {
		RField[] appendeeArrayForm = {appendee};
		RField[] arrayOut = concat(arrayIn,appendeeArrayForm);

		return arrayOut;
	}
	public static RField[][] append(RField[][] arrayIn, RField[] appendee) {
		RField[][] appendeeArrayForm = {appendee};
		RField[][] arrayOut = concat(arrayIn,appendeeArrayForm);

		return arrayOut;
	}
	public static RField[] removeElement(RField[] arrayIn, int index) {
		RField[] array1 = new RField[index];
		RField[] array2 = new RField[arrayIn.length-index+1];
		array1 = Arrays.copyOfRange(arrayIn,0,index);
		array2 = Arrays.copyOfRange(arrayIn,index+1,arrayIn.length);
		return concat(array1,array2);		
	}
	
	
	
	
	public static EField[] concat(EField[] array1, EField[] array2) {
		EField[] arrayOut = new EField[array1.length+array2.length];
		System.arraycopy(array1, 0, arrayOut, 0, array1.length);
		System.arraycopy(array2,0,arrayOut,array1.length,
		array2.length);
		
		return arrayOut;
	}
	public static EField[][] concat(EField[][] array1, EField[][] array2) {
		EField[][] arrayOut = new EField[array1.length+array2.length][];
		System.arraycopy(array1, 0, arrayOut, 0, array1.length);
		System.arraycopy(array2,0,arrayOut,array1.length,
		array2.length);
		
		return arrayOut;
	}
	public static EField[] append(EField[] arrayIn, EField appendee) {
		EField[] appendeeArrayForm = {appendee};
		EField[] arrayOut = concat(arrayIn,appendeeArrayForm);

		return arrayOut;
	}
	public static EField[][] append(EField[][] arrayIn, EField[] appendee) {
		EField[][] appendeeArrayForm = {appendee};
		EField[][] arrayOut = concat(arrayIn,appendeeArrayForm);

		return arrayOut;
	}
	public static EField[] removeElement(EField[] arrayIn, int index) {
		EField[] array1 = new EField[index];
		EField[] array2 = new EField[arrayIn.length-index+1];
		array1 = Arrays.copyOfRange(arrayIn,0,index);
		array2 = Arrays.copyOfRange(arrayIn,index+1,arrayIn.length);
		return concat(array1,array2);		
	}
	
}
	