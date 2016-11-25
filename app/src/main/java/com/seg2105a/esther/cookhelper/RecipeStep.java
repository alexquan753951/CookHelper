/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-abedcd4 modeling language!*/

package com.seg2105a.esther.cookhelper;

// line 100 "model.ump"
// line 161 "model.ump"
public class RecipeStep
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RecipeStep Attributes
  private String number;
  private String description;
  private String timeRequired;
  private boolean completed;

  //RecipeStep Associations
  private Recipe recipe;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RecipeStep(String aNumber, String aDescription, String aTimeRequired, boolean aCompleted, Recipe aRecipe)
  {
    number = aNumber;
    description = aDescription;
    timeRequired = aTimeRequired;
    completed = aCompleted;
    boolean didAddRecipe = setRecipe(aRecipe);
    if (!didAddRecipe)
    {
      throw new RuntimeException("Unable to create recipeStep due to recipe");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNumber(String aNumber)
  {
    boolean wasSet = false;
    number = aNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setTimeRequired(String aTimeRequired)
  {
    boolean wasSet = false;
    timeRequired = aTimeRequired;
    wasSet = true;
    return wasSet;
  }

  public boolean setCompleted(boolean aCompleted)
  {
    boolean wasSet = false;
    completed = aCompleted;
    wasSet = true;
    return wasSet;
  }

  public String getNumber()
  {
    return number;
  }

  public String getDescription()
  {
    return description;
  }

  public String getTimeRequired()
  {
    return timeRequired;
  }

  public boolean getCompleted()
  {
    return completed;
  }

  public boolean isCompleted()
  {
    return completed;
  }

  public Recipe getRecipe()
  {
    return recipe;
  }

  public boolean setRecipe(Recipe aRecipe)
  {
    boolean wasSet = false;
    if (aRecipe == null)
    {
      return wasSet;
    }

    Recipe existingRecipe = recipe;
    recipe = aRecipe;
    if (existingRecipe != null && !existingRecipe.equals(aRecipe))
    {
      existingRecipe.removeRecipeStep(this);
    }
    recipe.addRecipeStep(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Recipe existingRecipe = recipe;
    recipe = null;
    if (existingRecipe != null)
    {
      existingRecipe.delete();
    }
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "number" + ":" + getNumber()+ "," +
            "description" + ":" + getDescription()+ "," +
            "timeRequired" + ":" + getTimeRequired()+ "," +
            "completed" + ":" + getCompleted()+ "]" + //RecipeSystem.getProperties().getProperty("line.separator") +
            "  " + "recipe = "+(getRecipe()!=null?Integer.toHexString(5):"null")//RecipeSystem.identityHashCode(getRecipe())):"null")
     + outputString;
  }
}