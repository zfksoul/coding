package test;

/**
* 
*
* @author zfk
* @date 2019年9月22日 下午4:32:57 
* 
*/
public class Test {

	public static void main(String[] args) {
		
		Card c = new Card();
		int[][][] a = new int[10][][];
	}

}

class Card{
	Tag t1 = new Tag(1);
	Card(){
		System.out.println("Card()--");
		t3 = new Tag(33);
	}	
	Tag t2 = new Tag(2);
	void f() {
		System.out.println("f()--");
	}
	Tag t3 = new Tag(3);
}

class Tag{
	Tag(int i){
		System.out.println("Tag()--"+i);
	}
}