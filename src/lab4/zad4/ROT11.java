package lab4.zad4;

public class ROT11 implements Algorithm {
    static final String alphabet ="abcdefghijklmnopqrstuvwxyz";
    static final int offset =11;

    public ROT11(){

    }
    @Override
    public String crypt(String tocrypt_) {
        String crypt= "";
        for(int i=0;i<tocrypt_.length();i++){
            for (int j = 0; j< alphabet.length(); j++){
                if (tocrypt_.charAt(i) == alphabet.charAt(j))
                    crypt+=Character.toString(alphabet.charAt((j+ offset) % alphabet.length()));
            }
        }
        return crypt;
    }

    @Override
    public String decrypt(String todecrypt_) {
        String decrypt= "";
        for(int i=0;i<todecrypt_.length();i++){
            for (int j = 0; j< alphabet.length(); j++){
                if (todecrypt_.charAt(i) == alphabet.charAt(j)) {
                    int l=0;
                    if(j- offset <0)
                        l=j+ alphabet.length()- offset;
                    else
                        l=j- offset;
                    decrypt+=Character.toString(alphabet.charAt(l));
                }
            }
        }
        return decrypt;
    }
}
