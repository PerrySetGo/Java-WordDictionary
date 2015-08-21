import java.util.ArrayList;

class Dictionary {
private ArrayList<Word> mWords;
private Integer mDictionarySize;

public Dictionary(){
mWords = new ArrayList<Word>();
mDictionarySize = mWords.size(); //is this correct or does it need to be size of dictionary?
} //close constructor
	

public Integer getDictionarySize(){ 
	Integer dictionarySize = mDictionarySize;
	return dictionarySize;
}

}//close main class