//Word Search Project of Nick Ramkissoon and Jay Froment-Rudder Period 3

import java.util.*;
import java.io.*;

public class WordSearch{
  private char[][] grid;
  private ArrayList<String> wordList = new ArrayList<String>();
  
  
  
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
			a+=wordList.get(i)+"\n";
		}
	return a;
  }
  
  //addWordH
  public boolean addWordH(int row, int col, String s) {
	int r = row, c = col;
	s = s.toUpperCase();
	boolean canAdd;
	
	if (r < 0 || c < 0)
		canAdd = false;
	else if(r >= grid.length || c >= grid[r].length)
		canAdd = false;
	else if(c + s.length() - 1 >= grid[r].length)
		canAdd = false;
	else{
		while (c < grid[r].length && (grid[r][c] == '-' || grid[r][c] == s.charAt(c - col)))
			c ++;
		if (c < grid[r].length)
			canAdd = false;
		else {
			canAdd = true;
		}
	}
	
	if (canAdd)
		for (int i = 0;i < s.length(); i ++) {
		if(grid[r][col] == '-'){
			grid[r][col] = s.charAt(i);
			col ++;
		}
		else if(grid[row][c] == s.charAt(i))
			col ++;
		}
	if (canAdd)
	wordList.add(s);	
	return canAdd;
}

  //addWordV
  public boolean addWordV(int row, int col, String s) {
	int r = row, c = col;
	s = s.toUpperCase();
	boolean canAdd;
	
	if (r < 0 || c < 0)
		canAdd = false;
	else if(r >= grid.length || c >= grid[r].length)
		canAdd = false;
	else if(r + s.length() - 1 >= grid.length)
		canAdd = false;
	else{
		while (r < grid.length && (grid[r][c]== '-' || grid[r][c] == s.charAt(r - row))) 
			r ++;
		if (r < grid.length)
			canAdd = false;
		else {
			canAdd = true;
		}
	}
	
	if (canAdd)
		for (int i = 0;i < s.length(); i ++) {
		if(grid[row][c] == '-') {
			grid[row][c] = s.charAt(i);
			row ++;
		}
		else if(grid[row][c] == s.charAt(i))
			row++;
		}
	if (canAdd)
	wordList.add(s);
	return canAdd;
}

  //addWordD
  public boolean addWordD(int row, int col, String s) {
	int r = row, c = col;
	s = s.toUpperCase();
	boolean canAdd;
	
	if (r < 0 || c < 0)
		canAdd = false;
	else if(r >= grid.length || c >= grid[r].length)
		canAdd = false;
	else if(r + s.length() - 1 >= grid.length && c + s.length() - 1 >= grid[r].length)
		canAdd = false;
	else{
		boolean b = false;
		for (int n = 0; n < s.length(); n ++) {
			if (grid[r][c] != '-' && grid[r][c] != s.charAt(n)){
				b = false;
				n = s.length();
			}
			else{
				r ++;
				c ++;
				b = true;
			}
		}
		canAdd = b;
	}	
	
	if (canAdd)
		for (int i = 0; i < s.length(); i ++) {
		if (grid[row][col] == '-') {
			grid[row][col] = s.charAt(i);
			row ++;
			col ++;
		}
		else if(grid[row][col] == s.charAt(i)) {
			row ++;
			col ++;
		}
	}
	if (canAdd)
	wordList.add(s);
	return canAdd;
  }

  //addWords
  public void addWords(int n) {
	ArrayList<String> Words = new ArrayList();
	WordSearch ws1 = new WordSearch();
	Words = loadDictionary();
	Random rand = new Random();
	int m = 0;
	int l = n;

	for (int i = 0; i < Words.size(); i ++) {
		Words.set(i, (Words.get(i)).toUpperCase());
	}
	
	while (l > 1) {
		wordList.set(m, Words.remove(rand.nextInt(Words.size())));
		l --;
		m ++;
	}
	l = n;
	while (l > 1) {
		if (rand.nextInt(3) == 0) {
			ws1.addWordH(rand.nextInt(grid.length), rand.nextInt(grid[0].length), wordList.remove(rand.nextInt(wordList.size())));
			l --;
		}
		else if (rand.nextInt(3) == 1) {
			ws1.addWordV(rand.nextInt(grid.length), rand.nextInt(grid[0].length), wordList.remove(rand.nextInt(wordList.size())));
			l --;
		}
		else{
			ws1.addWordD(rand.nextInt(grid.length), rand.nextInt(grid[0].length), wordList.remove(rand.nextInt(wordList.size())));
			l --;
		}
  }
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
		
        System.out.println(ws.toString());
	System.out.println(ws);

	ws.addWords(4);
	System.out.println(ws);
	System.out.println(ws.toString());

	System.out.println("\n \nAfter fillGrid()");
	ws.fillGrid();
	System.out.println(ws.toString());

	ws.addWords(3);
	System.out.println(ws);
        
 	ws.fillGrid();
 	System.out.println(ws);
  }
}
