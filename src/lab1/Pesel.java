package lab1;

public class Pesel {
    private String pesel;

    public Pesel(String _pesel){
        pesel = _pesel;
    }

    static boolean check(String pesel){
        if (pesel.length() != 11)
            return false;
        int[] peselIntArray= new int[11];
        for(int i=0;i<11;i++) {
            peselIntArray[i] = Integer.parseInt(String.valueOf(pesel.charAt(i)));
        }
        int checkSum = peselIntArray[0] +
                3 * peselIntArray[1] +
                7 * peselIntArray[2] +
                9 * peselIntArray[3] +
                peselIntArray[4] +
                3 * peselIntArray[5] +
                7 * peselIntArray[6] +
                9 * peselIntArray[7] +
                peselIntArray[8] +
                3 * peselIntArray[9] +
                peselIntArray[10];
        checkSum %= 10;
        return checkSum == 0;
    }

}
