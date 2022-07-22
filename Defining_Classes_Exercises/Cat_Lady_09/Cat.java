package Defining_Classes_Exercises.Cat_Lady_09;

public class Cat {
    private String catName;
    private String catType;
    private String thirdParameter;

    public Cat(String catName, String catType, String thirdParameter) {
        this.catName = catName;
        this.catType = catType;
        this.thirdParameter = thirdParameter;
    }

    public String getCatType() {
        return catType;
    }

    public String getThirdParameter() {
        return thirdParameter;
    }
    
}
