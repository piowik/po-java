package lab1;

class LiczbyPierwsze {
    static int[] find(int target) {
        int tablica[] = new int[target];
        int j;
        int max = (int) Math.floor(Math.sqrt(target));
        for (int i=1; i<target; i++)
            tablica[i]=i;
        for (int i=2; i<=max; i++) {
            if (tablica[i] != 0) {
                j = 2*i;
                while (j<target) {
                    tablica[j] = 0;
                    j += i;
                }
            }
        }
        return tablica;
    }
}
