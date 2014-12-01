public class WordSearch{
  char[][] grid;
  int up;
  int down;
  int left;
  int right;
  int numWords;
  
  //Default Constructor
  public WordSearch(){
    grid = new char[10][10];
  }
  //Constructor With Parameters
  public WordSearch(int rows, int cols){
    grid = new char[rows][cols];
  }
  //toString() --------- Needs to display words in the wordsearch
  public String toString(){
    String a = "";
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++)
				a += grid[i][j] + " ";
			a += "\n";
		}
		return a;
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
  }
}
