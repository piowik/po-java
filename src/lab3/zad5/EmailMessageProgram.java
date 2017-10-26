package lab3.zad5;

public class EmailMessageProgram {
    public static void main(String[] argv) {
        System.out.print("Wysylam maila");

        EmailMessage wiadomosc = EmailMessage.builder()
                .addFrom("informatyka.4b@gmail.com")
                .addTo("piotrwiklinski@gmail.com")
                .addSubject("Mail test123")
                .addContent("Brak tresci")
                .build();
        wiadomosc.send();

    }
}
