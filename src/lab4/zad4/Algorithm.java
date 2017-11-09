package lab4.zad4;

interface Algorithm {
    default public String crypt(String toCrypt){
        return "";
    }
    default public String decrypt(String toDecrypt){
        return"";

    }
}