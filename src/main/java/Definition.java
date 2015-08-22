import java.util.ArrayList;

public class Definition {
  private static ArrayList<Definition> definitionInstances = new ArrayList<Definition>();
  private String mDefinitionText;
  private static int mDefinitionId;

 public Definition(String definitionText) {
    mDefinitionText = definitionText;
    definitionInstances.add(this);
    mDefinitionId = definitionInstances.size()+1;
  }

  public String getDefinitionText(){
  return mDefinitionText;
  }

  public static ArrayList<Definition> all(){
  return definitionInstances;
  }

  public static int getDefinitionId() {
  return mDefinitionId;
  }

  public static void clear() {
  definitionInstances = new ArrayList<Definition>();

}
  public static Definition find(int definitionId) {
    for (Definition definitionInstance : definitionInstances) {
      if (definitionId == Definition.getDefinitionId()) {
        return definitionInstance;
      }
    }
    return null;
  }
  
}