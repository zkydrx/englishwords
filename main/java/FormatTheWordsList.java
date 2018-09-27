import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-09-27
 * Time: 14:16:58
 * Description:
 */
public class FormatTheWordsList
{
    public static void parse(File file, File fileOut)
    {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try
        {
            br = new BufferedReader(new FileReader(file));
            bw = new BufferedWriter(new FileWriter(fileOut));
            String line = "";
            String subStr1 = "";
            String lineAfter = "";
            while ((line = br.readLine()) != null)
            {
                line = line.trim();
                subStr1 = line.replaceFirst(",", ".");
                System.out.println(subStr1);
                lineAfter = subStr1;
                bw.write(lineAfter);
                bw.newLine();
                bw.flush();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (br != null)
            {
                try
                {
                    br.close();
                    br = null;
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

            }
            if (bw != null)
            {
                try
                {
                    bw.close();
                    bw = null;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args)
    {
        File fileIn = new File("E:\\zky\\github\\englishwords\\main\\resources\\word.txt");
        File fileOut = new File("E:\\zky\\github\\englishwords\\main\\resources\\wordResult.txt");
        parse(fileIn, fileOut);
    }


}
