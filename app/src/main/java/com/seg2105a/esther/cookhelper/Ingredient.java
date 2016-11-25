/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-abedcd4 modeling language!*/

package com.seg2105a.esther.cookhelper;
import java.util.*;

// line 120 "model.ump"
// line 148 "model.ump"
public class Ingredient
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ingredient Attributes
  private String name;

  //Ingredient Associations
  private RecipeSystem recipeSystem;
  private List<Recipe> recipes;
  private List<RecipeStep> recipeSteps;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ingredient(String aName, RecipeSystem aRecipeSystem)
  {
    name = aName;
    boolean didAddSystem = setSystem(aRecipeSystem);
    if (!didAddSystem)
    {
      throw new RuntimeException("Unable to create ingredient due to recipeSystem");
    }
    recipes = new ArrayList<Recipe>();
    recipeSteps = new ArrayList<RecipeStep>();
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

  public RecipeSystem getRecipeSystem()
  {
    return recipeSystem;
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

  public RecipeStep getRecipeStep(int index)
  {
    RecipeStep aRecipeStep = recipeSteps.get(index);
    return aRecipeStep;
  }

  public List<RecipeStep> getRecipeSteps()
  {
    List<RecipeStep> newRecipeSteps = Collections.unmodifiableList(recipeSteps);
    return newRecipeSteps;
  }

  public int numberOfRecipeSteps()
  {
    int number = recipeSteps.size();
    return number;
  }

  public boolean hasRecipeSteps()
  {
    boolean has = recipeSteps.size() > 0;
    return has;
  }

  public int indexOfRecipeStep(RecipeStep aRecipeStep)
  {
    int index = recipeSteps.indexOf(aRecipeStep);
    return index;
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
      existingRecipeSystem.removeIngredient(this);
    }
    recipeSystem.addIngredient(this);
    wasSet = true;
    return wasSet;
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
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRecipe(Recipe aRecipe)
  {
    boolean wasRemoved = false;
    if (recipes.contains(aRecipe))
    {
      recipes.remove(aRecipe);
      wasRemoved = true;
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

  public static int minimumNumberOfRecipeSteps()
  {
    return 0;
  }

  public boolean addRecipeStep(RecipeStep aRecipeStep)
  {
    boolean wasAdded = false;
    if (recipeSteps.contains(aRecipeStep)) { return false; }
    recipeSteps.add(aRecipeStep);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRecipeStep(RecipeStep aRecipeStep)
  {
    boolean wasRemoved = false;
    if (recipeSteps.contains(aRecipeStep))
    {
      recipeSteps.remove(aRecipeStep);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addRecipeStepAt(RecipeStep aRecipeStep, int index)
  {  
    boolean wasAdded = false;
    if(addRecipeStep(aRecipeStep))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRecipeSteps()) { index = numberOfRecipeSteps() - 1; }
      recipeSteps.remove(aRecipeStep);
      recipeSteps.add(index, aRecipeStep);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRecipeStepAt(RecipeStep aRecipeStep, int index)
  {
    boolean wasAdded = false;
    if(recipeSteps.contains(aRecipeStep))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRecipeSteps()) { index = numberOfRecipeSteps() - 1; }
      recipeSteps.remove(aRecipeStep);
      recipeSteps.add(index, aRecipeStep);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRecipeStepAt(aRecipeStep, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    RecipeSystem placeholderRecipeSystem = recipeSystem;
    this.recipeSystem = null;
    placeholderRecipeSystem.removeIngredient(this);
    recipes.clear();
    recipeSteps.clear();
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