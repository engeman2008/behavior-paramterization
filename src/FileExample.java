import Interfaces.BufferReaderProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileExample {
  public static void main(String args[]) {
    try {
      String oneLine = processFile( (BufferedReader br) -> br.readLine());
      String twoLines = processFile( (BufferedReader br) -> br.readLine() + br.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String processFile(BufferReaderProcessor p) throws IOException {
    System.out.println(new File(".").getAbsolutePath());

    try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))){
      return p.process(br);
    }
  }
}
