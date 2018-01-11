package lab10.watki;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

class Server implements Runnable {
    private Scanner in;
    private PrintStream out;
    private Socket s;
    private LinkedList<String> idList;
    private LinkedList<String> loginList;
    private LinkedList<String> passwordList;

    public Server(Socket s) throws IOException {
        this(s.getInputStream(), s.getOutputStream());
        this.s = s;
    }

    public Server(InputStream input, OutputStream output) {
        in = new Scanner(input);
        out = new PrintStream(output);
        idList = new LinkedList<>();
        loginList = new LinkedList<>();
        passwordList = new LinkedList<>();
        loginList.add("a");
        passwordList.add("b");

    }

    private void msg(String msg) {
        System.out.print("SRV: ");
        System.out.println(msg);
    }

    public void run() {
        msg("serving new connection");
        while ((!Thread.currentThread().isInterrupted()) && in.hasNextLine()) {
            String inputLine = in.nextLine();
            if (inputLine.contains("LOGIN")) {
                if (!inputLine.contains(";")) {
                    out.println("Uzycie komendy: LOGIN login;haslo");
                    continue;
                }
                inputLine = inputLine.substring(6);
                System.out.println(inputLine);
                int login_index = -1;
                String login = "";
                String password = "";
                int log_pass = 1;
                for (int i = 0; i < inputLine.length(); i++) {
                    if (";".equals(inputLine.charAt(i) + "")) {
                        log_pass = 2;
                        i++;
                    }
                    if (log_pass == 1) {
                        login += inputLine.charAt(i);
                    } else if (log_pass == 2) {
                        password += inputLine.charAt(i);
                    }
                }
                if (!"".equals(login) && !"".equals(password)) {
                    for (int j = 0; j < loginList.size(); j++) {
                        if (login.equals(loginList.get(j))) {
                            login_index = j;
                            break;
                        }
                    }
                    if (login_index != -1) {
                        if (password.equals(passwordList.get(login_index))) {
                            String id = GenId(login + password);
                            idList.add(id);
                            out.println(id);
                        } else {
                            out.println("Zle haslo, Odleglosc " + String.valueOf(levenshtein(login,password)));
                        }
                    }
                    else {
                        out.println("Zly login");
                    }
                }
            } else if (inputLine.contains("LOGOUT")) {
                inputLine = inputLine.substring(7);
                System.out.println(inputLine);
                int index = -1;
                for (int i = 0; i < idList.size(); i++) {
                    if (inputLine.equals(idList.get(i))) {
                        index = i;
                        break;
                    }
                }
                if (index != -1) {
                    idList.remove(index);
                    out.println("wylogowano");
                } else {
                    out.println("false");
                }
            } else if (inputLine.contains("LS")) {
                inputLine = inputLine.substring(3);
                int index = -1;
                for (int i = 0; i < idList.size(); i++) {
                    if (inputLine.equals(idList.get(i))) {
                        index = i;
                        break;
                    }
                }
                if (index != -1) {
                    idList.remove(index);
                    out.println("plik1;plik2");
                } else {
                    out.println("false");
                }
            } else if (inputLine.contains("GET")) {
                inputLine = inputLine.substring(4);
                int index = -1;
                for (int i = 0; i < idList.size(); i++) {
                    if (inputLine.equals(idList.get(i))) {
                        index = i;
                        break;
                    }
                }
                if (index != -1) {
                    idList.remove(index);
                    out.println("zawartosc pliku");
                } else {
                    out.println("false");
                }
            } else {
                out.println("Nieznana komenda");
            }
            msg(inputLine);

        }
        try {
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        msg("connection closed");
    }

    public static String GenId(String st) {
        Random generator = new Random();
        String id = "";
        int r = 1;
        String[] key = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "a", "b", "c", "d", "e", "f", "g", "h", "i",
                "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for (int i = 0; i < 10; i++) {
            id += key[generator.nextInt(36)];
        }
        return id;
    }

    public static int levenshtein(String first, String second) {
        int i, j, f_len, s_len, cost;
        int d[][];
        f_len = first.length();
        s_len = second.length();

        d = new int[f_len+1][s_len+1];

        for (i=0; i<=f_len; i++)
            d[i][0] = i;
        for (j=1; j<=s_len; j++)
            d[0][j] = j;

        for (i=1; i<=f_len; i++)
        {
            for (j=1; j<=s_len; j++)
            {
                if (first.charAt(i-1) == second.charAt(j-1))
                    cost = 0;
                else
                    cost = 1;

                d[i][j] = Math.min(d[i-1][j] + 1,
                        Math.min(d[i][j-1] + 1,
                                d[i-1][j-1] + cost));
            }
        }
        return d[f_len][s_len];
    }
}