import java.util.Random;

public class Word {
  private String mName;
  private Integer mId;


  public Word(String name, int Id) {
    mName = name;
    mId = Id;
  }

  public String getName() {
    return mName;
  }

  public Integer getId() {
    return mId;
  }

}
