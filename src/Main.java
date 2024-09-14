public class Main {

	public static void main(String[] args) throws Exception {
		long inicio = System.nanoTime();

		TestesNanoTime testesNanoTime = new TestesNanoTime();
		testesNanoTime.preencherVetoresOrdenados();
		testesNanoTime.pecorrerVetor(testesNanoTime.vetor100milOrdenado);
		long fim = System.nanoTime();

		long duracao = fim - inicio;

		System.out.println(duracao);
	}
}
