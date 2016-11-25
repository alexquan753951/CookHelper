/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-abedcd4 modeling language!*/

package com.seg2105a.esther.cookhelper;
import java.util.*;

// line 114 "model.ump"
// line 142 "model.ump"
public class RecipeType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RecipeType Attributes
  private String name;

  //RecipeType Associations
  private List<Recipe> recipes;
  private RecipeSystem recipeSystem;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RecipeType(String aName, RecipeSystem aRecipeSystem)
  {
    name = aName;
    recipes = new ArrayList<Recipe>();
    boolean didAddSystem = setSystem(aRecipeSystem);
    if (!didAddSystem)
    {
      throw new RuntimeException("Unable to create recipeType due to recipeSystem");
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

  public RecipeSystem getRecipeSystem()
  {
    return recipeSystem;
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
    if (aRecipe.indexOfRecipeType(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aRecipe.addRecipeType(this);
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
    if (aRecipe.indexOfRecipeType(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aRecipe.removeRecipeType(this);
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

  public boolean setSystem(RecipeSystem aRecipeSystem)
  {
    boolean wasSet = false;
    if (aRecipeSystem == null)
    {
      return wasSet;
    }

    RecipeSystem existingRecipeSystem = recipeSystem;
    recipeSystem = aRecipeSystem;
    if (existingRecipeSystem != null && !existingRecipeSystem.equals(aRecipeSystem))
    {
      existingRecipeSystem.removeRecipeType(this);
    }
    recipeSystem.addRecipeType(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Recipe> copyOfRecipes = new ArrayList<Recipe>(recipes);
    recipes.clear();
    for(Recipe aRecipe : copyOfRecipes)
    {
      aRecipe.removeRecipeType(this);
    }
    RecipeSystem placeholderRecipeSystem = recipeSystem;
    this.recipeSystem = null;
    placeholderRecipeSystem.removeRecipeType(this);
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + //RecipeSystem.getProperties().getProperty("line.separator") +
            "  " + "recipeSystem = "+(getRecipeSystem()!=null?Integer.toHexString(5):"null")//RecipeSystem.identityHashCode(getRecipeSystem())):"null")
     + outputString;
  }
}