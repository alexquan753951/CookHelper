/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-abedcd4 modeling language!*/
package com.seg2105a.esther.cookhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.*;

// line 2 "model.ump"
// line 128 "model.ump"
public class System extends AppCompatActivity
{
  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //System Attributes
  private String database;

  //System Associations
  private List<Recipe> recipes;
  private List<Category> categories;
  private List<RecipeType> recipeTypes;
  private List<Ingredient> ingredients;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
  public System(String aDatabase)
  {
    database = aDatabase;
    recipes = new ArrayList<Recipe>();
    categories = new ArrayList<Category>();
    recipeTypes = new ArrayList<RecipeType>();
    ingredients = new ArrayList<Ingredient>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDatabase(String aDatabase)
  {
    boolean wasSet = false;
    database = aDatabase;
    wasSet = true;
    return wasSet;
  }

  public String getDatabase()
  {
    return database;
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

  public Category getCategory(int index)
  {
    Category aCategory = categories.get(index);
    return aCategory;
  }

  public List<Category> getCategories()
  {
    List<Category> newCategories = Collections.unmodifiableList(categories);
    return newCategories;
  }

  public int numberOfCategories()
  {
    int number = categories.size();
    return number;
  }

  public boolean hasCategories()
  {
    boolean has = categories.size() > 0;
    return has;
  }

  public int indexOfCategory(Category aCategory)
  {
    int index = categories.indexOf(aCategory);
    return index;
  }

  public RecipeType getRecipeType(int index)
  {
    RecipeType aRecipeType = recipeTypes.get(index);
    return aRecipeType;
  }

  public List<RecipeType> getRecipeTypes()
  {
    List<RecipeType> newRecipeTypes = Collections.unmodifiableList(recipeTypes);
    return newRecipeTypes;
  }

  public int numberOfRecipeTypes()
  {
    int number = recipeTypes.size();
    return number;
  }

  public boolean hasRecipeTypes()
  {
    boolean has = recipeTypes.size() > 0;
    return has;
  }

  public int indexOfRecipeType(RecipeType aRecipeType)
  {
    int index = recipeTypes.indexOf(aRecipeType);
    return index;
  }

  public Ingredient getIngredient(int index)
  {
    Ingredient aIngredient = ingredients.get(index);
    return aIngredient;
  }

  public List<Ingredient> getIngredients()
  {
    List<Ingredient> newIngredients = Collections.unmodifiableList(ingredients);
    return newIngredients;
  }

  public int numberOfIngredients()
  {
    int number = ingredients.size();
    return number;
  }

  public boolean hasIngredients()
  {
    boolean has = ingredients.size() > 0;
    return has;
  }

  public int indexOfIngredient(Ingredient aIngredient)
  {
    int index = ingredients.indexOf(aIngredient);
    return index;
  }

  public static int minimumNumberOfRecipes()
  {
    return 0;
  }

  public Recipe addRecipe(String aTitle, String aDescription, String aCookingTime, String aImage)
  {
    return new Recipe(aTitle, aDescription, aCookingTime, aImage, this);
  }

  public boolean addRecipe(Recipe aRecipe)
  {
    boolean wasAdded = false;
    if (recipes.contains(aRecipe)) { return false; }
    System existingSystem = aRecipe.getSystem();
    boolean isNewSystem = existingSystem != null && !this.equals(existingSystem);
    if (isNewSystem)
    {
      aRecipe.setSystem(this);
    }
    else
    {
      recipes.add(aRecipe);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRecipe(Recipe aRecipe)
  {
    boolean wasRemoved = false;
    //Unable to remove aRecipe, as it must always have a system
    if (!this.equals(aRecipe.getSystem()))
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

  public static int minimumNumberOfCategories()
  {
    return 0;
  }

  public Category addCategory(String aName)
  {
    return new Category(aName, this);
  }

  public boolean addCategory(Category aCategory)
  {
    boolean wasAdded = false;
    if (categories.contains(aCategory)) { return false; }
    System existingSystem = aCategory.getSystem();
    boolean isNewSystem = existingSystem != null && !this.equals(existingSystem);
    if (isNewSystem)
    {
      aCategory.setSystem(this);
    }
    else
    {
      categories.add(aCategory);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCategory(Category aCategory)
  {
    boolean wasRemoved = false;
    //Unable to remove aCategory, as it must always have a system
    if (!this.equals(aCategory.getSystem()))
    {
      categories.remove(aCategory);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addCategoryAt(Category aCategory, int index)
  {  
    boolean wasAdded = false;
    if(addCategory(aCategory))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCategories()) { index = numberOfCategories() - 1; }
      categories.remove(aCategory);
      categories.add(index, aCategory);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCategoryAt(Category aCategory, int index)
  {
    boolean wasAdded = false;
    if(categories.contains(aCategory))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCategories()) { index = numberOfCategories() - 1; }
      categories.remove(aCategory);
      categories.add(index, aCategory);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCategoryAt(aCategory, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfRecipeTypes()
  {
    return 0;
  }

  public RecipeType addRecipeType(String aName)
  {
    return new RecipeType(aName, this);
  }

  public boolean addRecipeType(RecipeType aRecipeType)
  {
    boolean wasAdded = false;
    if (recipeTypes.contains(aRecipeType)) { return false; }
    System existingSystem = aRecipeType.getSystem();
    boolean isNewSystem = existingSystem != null && !this.equals(existingSystem);
    if (isNewSystem)
    {
      aRecipeType.setSystem(this);
    }
    else
    {
      recipeTypes.add(aRecipeType);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRecipeType(RecipeType aRecipeType)
  {
    boolean wasRemoved = false;
    //Unable to remove aRecipeType, as it must always have a system
    if (!this.equals(aRecipeType.getSystem()))
    {
      recipeTypes.remove(aRecipeType);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addRecipeTypeAt(RecipeType aRecipeType, int index)
  {  
    boolean wasAdded = false;
    if(addRecipeType(aRecipeType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRecipeTypes()) { index = numberOfRecipeTypes() - 1; }
      recipeTypes.remove(aRecipeType);
      recipeTypes.add(index, aRecipeType);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRecipeTypeAt(RecipeType aRecipeType, int index)
  {
    boolean wasAdded = false;
    if(recipeTypes.contains(aRecipeType))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRecipeTypes()) { index = numberOfRecipeTypes() - 1; }
      recipeTypes.remove(aRecipeType);
      recipeTypes.add(index, aRecipeType);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRecipeTypeAt(aRecipeType, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfIngredients()
  {
    return 0;
  }

  public Ingredient addIngredient(String aName)
  {
    return new Ingredient(aName, this);
  }

  public boolean addIngredient(Ingredient aIngredient)
  {
    boolean wasAdded = false;
    if (ingredients.contains(aIngredient)) { return false; }
    System existingSystem = aIngredient.getSystem();
    boolean isNewSystem = existingSystem != null && !this.equals(existingSystem);
    if (isNewSystem)
    {
      aIngredient.setSystem(this);
    }
    else
    {
      ingredients.add(aIngredient);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeIngredient(Ingredient aIngredient)
  {
    boolean wasRemoved = false;
    //Unable to remove aIngredient, as it must always have a system
    if (!this.equals(aIngredient.getSystem()))
    {
      ingredients.remove(aIngredient);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addIngredientAt(Ingredient aIngredient, int index)
  {  
    boolean wasAdded = false;
    if(addIngredient(aIngredient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIngredients()) { index = numberOfIngredients() - 1; }
      ingredients.remove(aIngredient);
      ingredients.add(index, aIngredient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIngredientAt(Ingredient aIngredient, int index)
  {
    boolean wasAdded = false;
    if(ingredients.contains(aIngredient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIngredients()) { index = numberOfIngredients() - 1; }
      ingredients.remove(aIngredient);
      ingredients.add(index, aIngredient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIngredientAt(aIngredient, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=recipes.size(); i > 0; i--)
    {
      Recipe aRecipe = recipes.get(i - 1);
      aRecipe.delete();
    }
    for(int i=categories.size(); i > 0; i--)
    {
      Category aCategory = categories.get(i - 1);
      aCategory.delete();
    }
    for(int i=recipeTypes.size(); i > 0; i--)
    {
      RecipeType aRecipeType = recipeTypes.get(i - 1);
      aRecipeType.delete();
    }
    for(int i=ingredients.size(); i > 0; i--)
    {
      Ingredient aIngredient = ingredients.get(i - 1);
      aIngredient.delete();
    }
  }

  // line 8 "model.ump"
   public void addRecipe(){
    
  }

  // line 11 "model.ump"
   public void editRecipe(){
    
  }

  // line 14 "model.ump"
   public void deleteRecipe(){
    
  }

  // line 18 "model.ump"
   private void parseQuery(){
    
  }

  // line 22 "model.ump"
   private void sendToDatabase(){
    
  }

  // line 26 "model.ump"
   private void formatFromDatabase(){
    
  }

  // line 30 "model.ump"
   public void search(String query){
    
  }

  // line 33 "model.ump"
   public Recipe[] rankRecipes(){
     return new Recipe[2];
  }

  // line 36 "model.ump"
   public void createIngredient(){
    
  }

  // line 39 "model.ump"
   public void deleteIngredient(){
    
  }

  // line 42 "model.ump"
   public void createCategory(){
    
  }

  // line 45 "model.ump"
   public void deleteCategory(){
    
  }

  // line 48 "model.ump"
   public void createRecipeType(){
    
  }

  // line 51 "model.ump"
   public void deleteRecipeType(){
    
  }


  public String toString()
  {
    String outputString = "";
    return super.toString() + "["+
            "database" + ":" + getDatabase()+ "]"
     + outputString;
  }
}