import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MarkdownParseTest {
    
    @Test
    public void addition() {
        assertEquals(2, 1+1);
    }

    
    @Test
    public void MyMardownTestSnippet1() throws IOException{
        Path snippet1Path = Path.of("/Users/Jery/Documents/GitHub/Markdown-parse/testSnippet1.md");
        String snippet1Content = Files.readString(snippet1Path);
        ArrayList<String> links = MarkdownParse.getLinks(snippet1Content);
        ArrayList<String> result = new ArrayList<String>();
        result.add("`google.com");
        assertEquals(result, links);
    }
    
    @Test
    public void MyMardownTestSnippet2() throws IOException{
        Path snippet2Path = Path.of("/Users/Jery/Documents/GitHub/Markdown-parse/testSnippet2.md");
        String snippet2Content = Files.readString(snippet2Path);
        ArrayList<String> links = MarkdownParse.getLinks(snippet2Content);
        ArrayList<String> result = new ArrayList<String>();
        result.add("a.com");
        result.add("a.com(())");
        result.add("example.com");
        assertEquals(result, links);
    }
    
    @Test
    public void MyMardownTestSnippet3() throws IOException{
        Path snippet3Path = Path.of("/Users/Jery/Documents/GitHub/Markdown-parse/testSnippet3.md");
        String snippet3Content = Files.readString(snippet3Path);
        ArrayList<String> links = MarkdownParse.getLinks(snippet3Content);
        ArrayList<String> result = new ArrayList<String>();
        result.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        assertEquals(result, links);
    }
    
    
    @Test
    public void reviewedCodeSnippet1() throws IOException{
        Graph graph = new Graph();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("`google.com");
        assertEquals(expected, graph.getLinks(Files.readString(Path.of("/Users/Jery/Documents/GitHub/Markdown-parse/testSnippet1.md"))));

    }

    @Test
    public void reviewedCodeSnippet2() throws IOException{
        Graph graph = new Graph();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("b.com");
        expected.add("a.com(())");
        expected.add("example.com");
        assertEquals(expected, graph.getLinks(Files.readString(Path.of("/Users/Jery/Documents/GitHub/Markdown-parse/testSnippet2.md"))));

    }

    @Test
    public void reviewedCodeSnippet3() throws IOException{
        Graph graph = new Graph();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        assertEquals(expected, graph.getLinks(Files.readString(Path.of("/Users/Jery/Documents/GitHub/Markdown-parse/testSnippet3.md"))));
    }
}
