package com.hcdd340.yumble.data;

import androidx.annotation.Nullable;

import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Jason C. Nucciarone
 */
public class Recipe {
    private String title;
    private String author;
    private ArrayList<String> tags;
    private Integer image;
    private String imageDesc;
    private Pair<String, String> statistics;
    private String desc;
    private LinkedList<String> ingredients;
    private LinkedList<String> instructions;
    private LinkedList<String> notes;
    private LinkedList<Pair<String, String>> nutrition;

    /**
     * Constructor for Recipe class.
     *
     * @param title Name of the recipe.
     * @param author Author of the recipe.
     * @param tags Metadata tags for recipe.
     * @param image Image shown in on recipe page.
     * @param imageDesc contentDescription for recipe image.
     * @param statistics [0] Cook time; [1] Servings.
     * @param desc Short description about recipe.
     * @param ingredients Ingredients needed to make recipe.
     * @param instructions Instructions to make recipe.
     * @param notes Author's notes about recipe/allowable substitution.
     * @param nutrition Nutrition info for recipe.
     */
    public Recipe(
            @Nullable String author,
            @Nullable String title,
            @Nullable ArrayList<String> tags,
            @Nullable Integer image,
            @Nullable String imageDesc,
            @Nullable Pair<String, String> statistics,
            @Nullable String desc,
            @Nullable LinkedList<String> ingredients,
            @Nullable LinkedList<String> instructions,
            @Nullable LinkedList<String> notes,
            @Nullable LinkedList<Pair<String, String>> nutrition ) {
        this.author = author;
        this.title = title;
        this.tags = tags;
        this.image = image;
        this.imageDesc = imageDesc;
        this.statistics = statistics;
        this.desc = desc;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.notes = notes;
        this.nutrition = nutrition;
    }

    /**
     * Get name of recipe.
     *
     * @return Recipe's name.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set new name for recipe.
     *
     * @param title New name for recipe.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get author of recipe.
     *
     * @return Author's name.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set new author for recipe.
     *
     * @param author New author for recipe.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get current metadata tags.
     *
     * @return ArrayList of metadata tags.
     */
    public ArrayList<String> getTags() {
        return tags;
    }

    /**
     * Set new metadata tags.
     *
     * @param tags ArrayList of new metadata tags.
     */
    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    /**
     * Get image for recipe.
     *
     * @return Recipe's image.
     */
    public Integer getImage() {
        return image;
    }

    /**
     * Set new image for recipe.
     *
     * @param image New image for recipe.
     */
    public void setImage(Integer image) {
        this.image = image;
    }

    /**
     * Get recipe image description.
     *
     * @return Recipe image description.
     */
    public String getImageDesc() {
        return imageDesc;
    }

    /**
     * Set new recipe image description.
     *
     * @param imageDesc New recipe image description.
     */
    public void setImageDesc(String imageDesc) {
        this.imageDesc = imageDesc;
    }

    /**
     * Get Cook Time and Servings information.
     *
     * @return Cook Time and Servings tuple. [0] Cook Time; [1] Servings.
     */
    public Pair<String, String> getStatistics() {
        return statistics;
    }

    /**
     * Set new Cook Time and Servings for recipe.
     *
     * @param statistics New Cook Time and Servings tuple. [0] Cook Time; [1] Servings.
     */
    public void setStatistics(Pair<String, String> statistics) {
        this.statistics = statistics;
    }

    /**
     * Get description of recipe.
     *
     * @return Recipe's description.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Set new description for recipe.
     *
     * @param desc New description for recipe.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Get ingredients for recipe.
     *
     * @return LinkedList of ingredients needed for recipe.
     */
    public LinkedList<String> getIngredients() {
        return ingredients;
    }

    /**
     * Set new ingredients for recipe.
     *
     * @param ingredients LinkedList of new ingredients for recipe.
     */
    public void setIngredients(LinkedList<String> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Get instructions for making recipe.
     *
     * @return LinkedList of instructions for making recipe.
     */
    public LinkedList<String> getInstructions() {
        return instructions;
    }

    /**
     * Set new instructions for making recipe.
     *
     * @param instructions LinkedList of new instructions to make recipe.
     */
    public void setInstructions(LinkedList<String> instructions) {
        this.instructions = instructions;
    }

    /**
     * Get notes for recipe.
     *
     * @return LinkedList of notes for recipe.
     */
    public LinkedList<String> getNotes() {
        return notes;
    }

    /**
     * Set new notes for recipe.
     *
     * @param notes LinkedList of new notes for recipe.
     */
    public void setNotes(LinkedList<String> notes) {
        this.notes = notes;
    }

    /**
     * Get nutrition info for recipe.
     *
     * @return LinkedList of nutrition info for recipe. [0] Name and content; [1] Daily percentage.
     */
    public LinkedList<Pair<String, String>> getNutrition() {
        return nutrition;
    }

    /**
     * Set new nutrition info for recipe.
     *
     * @param nutrition LinkedList of new nutrition info for recipe. [0] Name and content; [1] Daily percentage.
     */
    public void setNutrition(LinkedList<Pair<String, String>> nutrition) {
        this.nutrition = nutrition;
    }
}
