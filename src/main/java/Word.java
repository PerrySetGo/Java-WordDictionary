import java.util.ArrayList;

public class Word {
  
  private static ArrayList<Word> instances = new ArrayList<Word>();
  private String mName;
  private static int mWordId;
  private String mDefinition;

  //constructor class
  public Word(String name, String definition) {
    mName = name;
    mWordId = instances.size()+1;
    mDefinition = definition;
    instances.add(this);
  }

  //getter methods
  public String getName() {
    return mName;
  }

  public static int getWordId() {
   // System.out.println(mWordId);
    return mWordId;
  }

  public String getDefinition(){
    return mDefinition;
  }

  //helper methods

  public static ArrayList<Word> all(){
  return instances;
  }

  public static void clear() {
  instances = new ArrayList<Word>();
  }

  public static Word find(int wordId) {
    for (Word instance : instances) {
      if (wordId == Word.getWordId()) {
        return instance;
      }
    }
    return null;
  }

}