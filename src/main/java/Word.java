public class Word {
  private String mName;
  private int mWordId;//may want to change this to size of collection class later.
  private String mDefinition;

  //constructor class
  public Word(String name, int wordId, String definition) {
    mName = name;
    mWordId = wordId;
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

}
