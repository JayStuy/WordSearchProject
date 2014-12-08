import java.util.*;
import java.io.*;

public class WordSearch{
  private char[][] grid;
  private boolean up;
  private boolean down;
  private boolean left;
  private boolean right;
  private ArrayList<String> wordList = new ArrayList<String>();
  private int numWords;
  
  
  
  public ArrayList<String> loadDictionary() {
	String s = "zzz";
    	ArrayList<String> dictionary = new ArrayList<String>();
   	try {
	FileReader f = new FileReader("wordlist.txt");
        BufferedReader b = new BufferedReader(f);
	while( s != null ) {
	 s = b.readLine();
	     if ( s != null )
	     dictionary.add(s);
	     }
        }
   catch (IOException e) {}
   
   return dictionary;
}


  //Default Constructor
  public WordSearch(){
    grid = new char[10][10];
     for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++)
				grid[i][j] = '-';
  }
  //Constructor With Parameters
  public WordSearch(int rows, int cols){
    grid = new char[rows][cols];
     for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++)
				grid[i][j] = '-';
  }
  //toString() 
  public String toString(){
    String a = "";
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++)
				a += grid[i][j] + " ";
			a += "\n";
		}
		for (int i = 0; i<wordList.size(); i++){
			a+=wordList.get(i)+"/n";
		}
	return a;
  }
  
  //addWordH
  public boolean addWordH(int row, int col, String s) {
	int r = row, c = col;
	boolean canAdd;
	
	while (c < grid[r].length && grid[r][c] == '-')
		c ++;
	if (c < grid[r].length)
		canAdd = false;
	else {
		canAdd = true;
	}
	
	if (canAdd)
		for (int i = 0;i < s.length(); i ++)
		grid[r][i] = s.charAt(i);
	
	return canAdd;
}
	
  //fillGrid()
  public void fillGrid(){
  	for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++){
				if (grid[i][j]=='-'){
					Random rand = new Random();
					int r = rand.nextInt(26)+65;
					grid[i][j]= (char)r;
				}
				}
			}
  }
  //main
  public static void main(String[] args){
    //toString() Test--------------------------------------
    /*
    WordSearch s = new WordSearch();
    for (int i = 0; i < s.grid.length; i++)
			for (int j = 0; j < s.grid[i].length; j++)
				s.grid[i][j] = 'a';
		System.out.println(s.toString());
    */
	//-------------------------------------------------------
	 WordSearch ws = new WordSearch();
        
        //working horizontal words
        ws.addWordH(0, 0, "hello");
        ws.addWordH(2, 4, "batman");
        ws.addWordH(5, 1, "apple");

        //Horizontal index error checking
        ws.addWordH(-2, 4, "joker");
        ws.addWordH(10, 4, "unicorn");  
        ws.addWordH(3, -1, "cowboys");
        ws.addWordH(5, 8, "dogs");

        //horizontal collision checking
        ws.addWordH(5, 3, "plow");
        ws.addWordH(2, 0, "neato");
        /*
        //working vertical words
        ws.addWordV(1, 0, "nice");
        ws.addWordV(4, 9, "yankee");
        ws.addWordV(4, 4, "old");
        
        //Verical index error checking
        ws.addWordV(-2, 4, "joker");
        ws.addWordV(7, 4, "unicorn");   
        ws.addWordV(3, -1, "cowboys");
        ws.addWordV(5, 20, "dogs");
        
        //vertical collision checking
        ws.addWordV(0, 4, "ores");
        ws.addWordV(4, 9, "goober");
       
        //working diagonal words
        ws.addWordD(7, 0,  "cat");
        ws.addWordD(0, 0, "home");
        ws.addWordD(0, 3, "loam");
        //Diagonal index error checking
        ws.addWordD(-2, 0,  "cat");
        ws.addWordD(3, -1,  "whelm");
        ws.addWordD(7, 7,  "after");    

        //Diagonal collision checking
        ws.addWordD(0, 4, "ores");
        ws.addWordD(4, 4, "oats");

        System.out.println(ws);
        */
        ws.fillGrid();
        System.out.println(ws);
  }
}
