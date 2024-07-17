import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Elements;

public class search_engine
{
    public static void main(String[] args) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the keyword to search over search engine:");
        String response = sc.nextLine();

        String url = "https://www.google.com/search?q="+response;

        Document doc = Jsoup.connect(url).get();
        String html = doc.html();
        Files.write(Paths.get("C:\\Users\\admin\\OneDrive\\Desktop\\New folder\\file.txt"),html.getBytes());

        Elements links = doc.select("cite");

        for(Element link:links)
        {
            System.out.println(link.text());
        }

        sc.close();
    }
}