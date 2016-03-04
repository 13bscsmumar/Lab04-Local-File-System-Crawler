//acknowledgements : Abdul Hannan Khan
import java.io.*;
import java.util.*;


public class lab04
{
   public List<File> crawl(String path, int depth)
   {
      List<File> fileList = new ArrayList<File>();
      
      if(depth > 0)
      {
        File directory = new File(path);


        File[] fList = directory.listFiles();
        if(fList.length > 0)
          for(File file: fList)
          {
            fileList.add(file);
          }
        
        File _file = new File(path);
        String[] directories = _file.list(new FilenameFilter() {
          @Override
          public boolean accept(File current, String name) {
            return new File(current, name).isDirectory();
          }
        });
        
        for(String dir: directories)
        {
          List<File> nextList = crawl(path + dir + "\\", depth - 1);
          
          for(File file: nextList)
          {
            fileList.add(file);
          }
        }
      }
      return fileList;
   }
  
  public int hasWord(File file, String word)
  {
    int count = 0;
    try 
    {
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) 
      {
        Scanner s2 = new Scanner(scanner.nextLine());
        while (s2.hasNext()) 
        {
          String s = s2.next();
          if (s.equalsIgnoreCase(word))
          {
            count++;
            break;
          }  
        }
      }

    } 
    catch (IOException e) 
    {
      e.printStackTrace();
    }
    return count;
  }
  
  public boolean findFile(String path, int depth, String fname)
  {
    List<File> files = crawl(path, depth);
    
    for(File file: files)
    {
      if(file.getName().equals(fname) )
      {
        System.out.println("File found at path: " + file.getAbsolutePath());
        return true;
      }
    }
    return false;
  }
}
