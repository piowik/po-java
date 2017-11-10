package lab5.zad4;

import io.indico.Indico;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FotoProgram {

    public static void main(String[] args) throws IndicoException {
        // single example
        Indico indico = new Indico("74b5fadff91a8343d795fe16e25a0105");
        String folderDir = "F:\\IntelliJ\\workspace\\java\\java-po\\src\\lab5\\lab4\\foto";
        File f = new File(folderDir);
        File[] matchingFiles = f.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("jpg");
            }
        });
        String[] paths = new String[matchingFiles.length];
        for (int i = 0; i < matchingFiles.length; i++) {
            System.out.println(matchingFiles[i].getAbsolutePath());
            paths[i] = matchingFiles[i].getAbsolutePath();
        }
        BatchIndicoResult multiple = null;
        try {
            multiple = indico.imageRecognition.predict(paths);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map<String, Double>> results = multiple.getImageRecognition();
        String output = "";
        int i = 0;
        for (Map<String, Double> map : results) {
            double maxChance = 0;
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();

                if ((double) pair.getValue() > maxChance) {
                    maxChance = (double) pair.getValue();
                    output = pair.getKey().toString();
                }
                it.remove();
            }
            String directoryPath = folderDir + "\\" + output;
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdir();
            }
            System.out.println(matchingFiles[i]);
            File activeFile = matchingFiles[i];
            activeFile.renameTo(new File(directoryPath + "\\"+  activeFile.getName()));
            i++;
            System.out.println(maxChance + ":" + output);
        }
    }
}
