package Trees.BinaryTree;

public class FamilyTreeObj
{
    private String name;
    private String relationship;
    public FamilyTreeObj(String iniName, String iniRelationship)
    {
        this.name = iniName;
        this.relationship = iniRelationship;
    }
    public boolean equals(Object other)
    {
        FamilyTreeObj otherObj = (FamilyTreeObj) other; //Casting
        if ((this.relationship.equals(otherObj.relationship)) && (this.name.equals(otherObj.name)))
            return true;
        else
            return false;
    }
    public String getName()
    {
        return name;
    }
    public String getRelationship()
    {
        return relationship;
    }
    public String toString()
    { //Obj memory address
        return (relationship + " " + name);
    }
}
