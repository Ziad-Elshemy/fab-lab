package eg.iti.mad.materialdesignday3;

public class PhoneData {
    private String letter;
    private String name;
    private String desc;

    public PhoneData(String letter, String name, String desc) {
        this.letter = letter;
        this.name = name;
        this.desc = desc;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "PhoneData{" +
                "letter=" + letter +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
