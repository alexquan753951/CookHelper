/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-abedcd4 modeling language!*/

package com.seg2105a.esther.cookhelper;
import java.util.*;

// line 108 "model.ump"
// line 135 "model.ump"
public class Category
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Category Attributes
  private String name;

  //Category Associations
  private List<Recipe> recipes;
  private System system;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Category(String aName, System aSystem)
  {
    name = aName;
    recipes = new ArrayList<Recipe>();
    boolean didAddSystem = setSystem(aSystem);
    if (!didAddSystem)
    {
      throw new RuntimeException("Unable to create category due to system");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Recipe getRecipe(int index)
  {
    Recipe aRecipe = recipes.get(index);
    return aRecipe;
  }

  public List<Recipe> getRecipes()
  {
    List<Recipe> newRecipes = Collections.unmodifiableList(recipes);
    return newRecipes;
  }

  public int numberOfRecipes()
  {
    int number = recipes.size();
    return number;
  }

  public boolean hasRecipes()
  {
    boolean has = recipes.size() > 0;
    return has;
  }

  public int indexOfRecipe(Recipe aRecipe)
  {
    int index = recipes.indexOf(aRecipe);
    return index;
  }

  public System getSystem()
  {
    return system;
  }

  public static int minimumNumberOfRecipes()
  {
    return 0;
  }

  public boolean addRecipe(Recipe aRecipe)
  {
    boolean wasAdded = false;
    if (recipes.contains(aRecipe)) { return false; }
    recipes.add(aRecipe);
    if (aRecipe.indexOfCategory(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aRecipe.addCategory(this);
      if (!wasAdded)
      {
        recipes.remove(aRecipe);
      }
    }
    return wasAdded;
  }

  public boolean removeRecipe(Recipe aRecipe)
  {
    boolean wasRemoved = false;
    if (!recipes.contains(aRecipe))
    {
      return wasRemoved;
    }

    int oldIndex = recipes.indexOf(aRecipe);
    recipes.remove(oldIndex);
    if (aRecipe.indexOfCategory(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aRecipe.removeCategory(this);
      if (!wasRemoved)
      {
        recipes.add(oldIndex,aRecipe);
      }
    }
    return wasRemoved;
  }

  public boolean addRecipeAt(Recipe aRecipe, int index)
  {  
    boolean wasAdded = false;
    if(addRecipe(aRecipe))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRecipes()) { index = numberOfRecipes() - 1; }
      recipes.remove(aRecipe);
      recipes.add(index, aRecipe);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRecipeAt(Recipe aRecipe, int index)
  {
    boolean wasAdded = false;
    if(recipes.contains(aRecipe))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRecipes()) { index = numberOfRecipes() - 1; }
      recipes.remove(aRecipe);
      recipes.add(index, aRecipe);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRecipeAt(aRecipe, index);
    }
    return wasAdded;
  }

  public boolean setSystem(System aSystem)
  {
    boolean wasSet = false;
    if (aSystem == null)
    {
      return wasSet;
    }

    System existingSystem = system;
    system = aSystem;
    if (existingSystem != null && !existingSystem.equals(aSystem))
    {
      existingSystem.removeCategory(this);
    }
    system.addCategory(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Recipe> copyOfRecipes = new ArrayList<Recipe>(recipes);
    recipes.clear();
    for(Recipe aRecipe : copyOfRecipes)
    {
      aRecipe.removeCategory(this);
    }
    System placeholderSystem = system;
    this.system = null;
    placeholderSystem.removeCategory(this);
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + //System.getProperties().getProperty("line.separator") +
            "  " + "system = "+(getSystem()!=null?Integer.toHexString(5):"null")//System.identityHashCode(getSystem())):"null")
     + outputString;
  }
}