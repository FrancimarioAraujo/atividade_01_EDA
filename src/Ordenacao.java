import java.util.Random;

public class Ordenacao implements Ordenacao_IF {

    @Override
    public boolean checaVetorOrdenado(Filme[] filmes) {
        for (int i = 0; i < filmes.length - 1; i++) {
            if (filmes[i].compareTo(filmes[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void bubbleSort(Filme[] filmes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bubbleSort'");
    }

    @Override
    public void selectionSort(Filme[] filmes) {
        int n = filmes.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {

                if (filmes[j].compareTo(filmes[min]) < 0) {
                    min = j;
                }
            }
            _swap(filmes, i, min);
        }
    }

    @Override
    public void insertionSort(Filme[] filmes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertionSort'");
    }

    @Override
    public void quickSort(Filme[] filmes) {
        _quickSort(filmes, 0, filmes.length - 1);
    }

    @Override
    public void quickSortRandom(Filme[] filmes) {
        _shuffle(filmes);
        _quickSort(filmes, 0, filmes.length - 1);
    }

    @Override
    public void mergeSort(Filme[] filmes) {
        if (filmes.length > 1) {
            int mid = filmes.length / 2;

            Filme[] left = new Filme[mid];
            Filme[] right = new Filme[filmes.length - mid];

            System.arraycopy(filmes, 0, left, 0, mid);
            System.arraycopy(filmes, mid, right, 0, filmes.length - mid);

            mergeSort(left);
            mergeSort(right);

            _merge(filmes, left, right);
        }
    }

    @Override
    public void countingSort(Filme[] filmes) {
        int k = 0;
        for (Filme filme : filmes) {
            if (filme.getNota() > k) {
                k = filme.getNota();
            }
        }

        int[] C = new int[k + 1];

        Filme[] B = new Filme[filmes.length];

        for (int j = 0; j < filmes.length; j++) {
            C[filmes[j].getNota()]++;
        }

        for (int i = 1; i <= k; i++) {
            C[i] += C[i - 1];
        }

        for (int j = 0; j < filmes.length; j++) {
            B[filmes.length - C[filmes[j].getNota()]] = filmes[j];
            C[filmes[j].getNota()]--;
        }

        for (int i = 0; i < filmes.length; i++) {
            filmes[i] = B[i];
        }
    }

    private static int _partition(Filme[] filmes, int left, int right) {
        Filme pivot = filmes[right];
        int i = (left - 1);
        for (int j = left; j < right; j++) {
            if (filmes[j].compareTo(pivot) < 0) {
                i++;
                _swap(filmes, i, j);
            }
        }
        _swap(filmes, i + 1, right);
        return i + 1;
    }

    private static void _shuffle(Filme[] filmes) {
        Random random = new Random();
        for (int i = 0; i < filmes.length; i++) {
            int randomIndexToSwap = random.nextInt(filmes.length);
            _swap(filmes, i, randomIndexToSwap);
        }
    }

    private static void _swap(Filme[] filmes, int i, int j) {
        Filme temp = filmes[i];
        filmes[i] = filmes[j];
        filmes[j] = temp;
    }

    private static void _quickSort(Filme[] filmes, int left, int right) {
        if (left < right) {
            int pivot = _partition(filmes, left, right);
            _quickSort(filmes, left, pivot - 1);
            _quickSort(filmes, pivot + 1, right);
        }
    }

    private static void _merge(Filme[] filmes, Filme[] left, Filme[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                filmes[k++] = left[i++];
            } else {
                filmes[k++] = right[j++];
            }
        }

        while (i < left.length) {
            filmes[k++] = left[i++];
        }

        while (j < right.length) {
            filmes[k++] = right[j++];
        }
    }
}
