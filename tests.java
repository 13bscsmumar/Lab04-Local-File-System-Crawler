
import java.io.*;
import java.util.*;

public class tests
{
  public static void main(String [] args)
  {
    testContent();
    findTest();
  }
  
  public static void testContent()
  {
    
    Crawler crawler = new Crawler();
    String directory = "C:\\Users\\Muhammad Umar\\Desktop\\";
    List<File> files = crawler.crawl(directory, 5);
    String keyword = "from";
    
    System.out.println("Searching in : " + directory);
    System.out.println("Expected Result : C:\\Users\\Muhammad Umar\\Desktop\\Lab4\\test.txt");
    
    for(File file: files)
    {
      if(( file.getName().endsWith("txt")) && crawler.hasWord(file, keyword) > 0)
      {
        System.out.println(keyword + " found in : " + file.getAbsolutePath());
      }
    }
  }
  
  public static void findTest()
  {
  
    Crawler crawler = new Crawler();
    String directory = "C:\\Users\\Muhammad Umar\\Desktop\\";
    String fname = "test.txt";
    
    System.out.println("Searching in :" + directory);
    System.out.println("Expected Result : C:\\Users\\Muhammad Umar\\Desktop\\Lab4\\test.txt");
    
    if(crawler.findFile(directory, 5, fname))
    {
      System.out.println("Test Passed!"); 
    }
    else
    {
      System.out.println("Test Failed!"); 
    }
  }
}
