package lab4.zad4;

public class Polibiusz implements Algorithm {
    static final char[][] polibiuszTable = new char[5][5];

    public Polibiusz() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                char startChar = 'a';
                startChar += j + (i * 5);
                if (startChar >= 'j')
                    startChar++;
                polibiuszTable[i][j] = startChar;
            }
        }
    }

    @Override
    public String crypt(String tocrypt_) {
        tocrypt_ = tocrypt_.toLowerCase();
        String crypt = "";
        for (int i = 0; i < tocrypt_.length(); i++) {
            char c = tocrypt_.charAt(i);
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (c == 'j') {
                        crypt += "24";
                        c = '0';
                    } else if (c == polibiuszTable[j][k]) {
                        crypt += Integer.toString(j + 1);
                        crypt += Integer.toString(k + 1);
                    }
                }
            }
        }
        return crypt;
    }

    @Override
    public String decrypt(String todecrypt_) {
        String decrypt = new String();
        int i = 0;
        while (i < todecrypt_.length()) {
            int a, b;
            a = Integer.parseInt(Character.toString(todecrypt_.charAt(i)));
            b = Integer.parseInt(Character.toString(todecrypt_.charAt(i + 1)));
            decrypt += polibiuszTable[a - 1][b - 1];
            i += 2;
        }
        return decrypt;
    }

}
