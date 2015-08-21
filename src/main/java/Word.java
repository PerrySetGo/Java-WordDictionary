import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> instances = new ArrayList<Word>();
  private String mName;
  private int mWordId;//may want to change this to size of collection class later.
  private String mDefinition;

  //constructor class
  public Word(String name, String definition) {
    mName = name;
    mWordId = instances.size()+1;
    mDefinition = definition;
  }

  //getter methods
  public String getName() {
    return mName;
  }

  public int getWordId() {
    return mWordId;
  }

  public String getDefinition(){
    return mDefinition;
  }

  //setter methods

  public void addWord(){
   // mWords.add(/*some variable here*/);
  }

  public static ArrayList<Word> allWords(){
  return instances;
  }
}
