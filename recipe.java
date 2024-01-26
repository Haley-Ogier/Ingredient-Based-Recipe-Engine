import java.util.Set;

public class recipe{
    //private String title;
    private String description;
    private String cooktime;
    private Set<String> ingredients;
    private String intructions;

    public recipe(String desc, String time, Set<String> ingred, String instruc){
        //title = givenTitle;
        description = desc;
        cooktime = time;
        ingredients = ingred;
        intructions = instruc;
    }

    public String getDescrip(){
        return description;
    }
    public String gettime(){
        return cooktime;
    }
    public Set<String> getIngred(){
        return ingredients;
    }
    public String getintruct(){
        return intructions;
    }

    public void setDescrip(String newDes){
        description = newDes;
    }
    public void settime(String newtime){
        cooktime = newtime;
    }
    public void addIngred(String toAdd){
        ingredients.add(toAdd);
    }
    public void setintruct(String newintr){
        intructions = newintr;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Description: ").append(description).append("\n");
        sb.append("Cook Time: ").append(cooktime).append("\n");
        sb.append("Ingredients: ");
        for (String ingredient : ingredients) {
            sb.append(ingredient).append(", ");
        }
        if (!ingredients.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("\n");
        sb.append("Instructions: ").append(intructions);
        return sb.toString();
    }
}