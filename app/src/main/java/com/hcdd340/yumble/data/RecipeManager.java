package com.hcdd340.yumble.data;

import android.util.Log;

import com.hcdd340.yumble.R;

import org.javatuples.Decade;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Jason C. Nucciarone
 */
public class RecipeManager {
    private final static String DEBUG_TAG = "DATA_MANAGER";

    // Begin Singleton declaration
    private static RecipeManager recipeManager = null;

    private RecipeManager() {}

    public static RecipeManager getInstance() {
        if (recipeManager == null) {
            recipeManager = new RecipeManager();
        }

        return recipeManager;
    }
    // End Singleton declaration

    private int index = 0;
    private final LinkedList<Recipe> recipeList = new LinkedList<>();

    /**
     * Load first set of recipes on application start.
     */
    public void loadRecipes() {
        LinkedList<
                Decade<
                        String,
                        String,
                        ArrayList<String>,
                        Pair<Integer, String>,
                        Pair<String, String>,
                        String,
                        LinkedList<String>,
                        LinkedList<String>,
                        LinkedList<String>,
                        LinkedList<Pair<String, String>>
                >
        > tmpList = new LinkedList<
                Decade<
                    String,
                    String,
                    ArrayList<String>,
                    Pair<Integer, String>,
                    Pair<String, String>,
                    String,
                    LinkedList<String>,
                    LinkedList<String>,
                    LinkedList<String>,
                    LinkedList<Pair<String, String>>
                >>() {
            {
                add(new Decade<>(
                        "NucciTheBoss",
                        "Avocado Sandwich",
                        new ArrayList<>(Arrays.asList(
                            "quick and easy", "vegetarian"
                        )),
                        new Pair<>(R.drawable.avocado_sandwich, "Image of Avocado Sandwich"),
                        new Pair<>("10 min", "1"),
                        "Always a lunchtime favorite. It's simple, delicious, and refreshing! The measurements for the ingredients are all approximate, as this sandwich is best when tailored to personal taste. Particularly scrumptious on potato, oat, or country white bread. Enjoy!",
                        new LinkedList<>(Arrays.asList(
                                "2 slices bread",
                                "2 slices provolone cheese, or more as needed",
                                "¼ avocado - peeled, pitted, and thinly sliced",
                                "½ tomato, sliced",
                                "1½ teaspoons balsamic vinegar"
                        )),
                        new LinkedList<>(Arrays.asList(
                                "Lay 1 slice bread on a plate. Place provolone cheese on bread and top with avocado and tomato slices, respectively. Drizzle balsamic vinegar over tomato and top with remaining slice of bread."
                        )),
                        new LinkedList<>(Arrays.asList(
                                "You can substitute mozzarella cheese for the provolone cheese, if desired.",
                                "If available, I like to add fresh arugula or basil from the garden.",
                                "Turn this into a more wintry dish by toasting the bread first."
                        )),
                        new LinkedList<>()
                ));
                add(new Decade<>(
                        "NucciTheBoss",
                        "Hummus Mini Pizzas",
                        new ArrayList<>(Arrays.asList(
                            "vegetarian"
                        )),
                        new Pair<>(R.drawable.arugula_and_hummus_mini_pizzas, "Image of Arugula and Hummus Mini Pizzas"),
                        new Pair<>("10 min", "1"),
                        "Nice easy meal to feed yourself while on the run.",
                        new LinkedList<>(Arrays.asList(
                                "2 tablespoons hummus, or to taste",
                                "1 naan bread",
                                "1 cup arugula, or to taste",
                                "1 date, pitted and finely chopped",
                                "2 teaspoons pumpkin seeds",
                                "1 teaspoon balsamic vinegar, or to taste"
                        )),
                        new LinkedList<>(Arrays.asList(
                                "Spread hummus onto naan bread; top with arugula, date, and pumpkin seeds. Drizzle balsamic vinegar over pizza."
                        )),
                        new LinkedList<>(),
                        new LinkedList<>()
                ));
                add(new Decade<>(
                        "NucciTheBoss",
                        "Blueberry Coconut Bowl",
                        new ArrayList<>(Arrays.asList(
                            "vegetarian"
                        )),
                        new Pair<>(R.drawable.creamy_blueberry_coconut_ricotta_bowl, "Image of Creamy Blueberry Coconut Ricotta Bowl"),
                        new Pair<>("10 min", "1"),
                        "This filling breakfast bowl will jumpstart your day and keep you full all morning. It is chock full of protein and is super delicious and creamy.",
                        new LinkedList<>(Arrays.asList(
                                "¼ cup whole milk ricotta cheese",
                                "1 tablespoon coconut milk",
                                "1 tablespoon honey, or to taste",
                                "1 tablespoon slivered almonds",
                                "1 tablespoon sweetened flaked coconut",
                                "½ cup blueberries, or to taste"
                        )),
                        new LinkedList<>(Arrays.asList(
                                "Combine ricotta cheese and coconut milk in a bowl. Drizzle on honey and sprinkle with almonds and coconut. Top with blueberries."
                        )),
                        new LinkedList<>(),
                        new LinkedList<>()
                ));
                add(new Decade<>(
                        "NucciTheBoss",
                        "Pesto Penne with Sausage",
                        new ArrayList<>(Arrays.asList(
                            "quick and easy"
                        )),
                        new Pair<>(R.drawable.creamy_pesto_penne_with_sausage, "Image of Creamy Pesto Penne with Sausage"),
                        new Pair<>("25 min", "2"),
                        "Quick weeknight dinner. Ready in 15 minutes!",
                        new LinkedList<>(Arrays.asList(
                                "1 (16 ounce) package penne pasta",
                                "½ pound ground sausage",
                                "1 (1.2 ounce) package creamy pesto sauce mix (such as Knorr®)",
                                "1 cup milk",
                                "¼ cup olive oil"
                        )),
                        new LinkedList<>(Arrays.asList(
                                "Bring a large pot of lightly salted water to a boil. Cook penne at a boil, stirring occasionally, until tender yet firm to the bite, about 11 minutes; drain and transfer pasta to a bowl.",
                                "Heat a large skillet over medium-high heat. Cook and stir sausage in the hot skillet until browned and crumbly, 5 to 7 minutes; add to pasta.",
                                "Whisk pesto sauce mix, milk, and olive oil together in a small saucepan; bring to a boil while stirring constantly. Reduce heat to low and keep at a simmer until thickened, about 3 minutes; pour over pasta and sausage mixture and toss to coat."
                        )),
                        new LinkedList<>(Arrays.asList(
                                "For a lower-fat option, sub fat-free milk."
                        )),
                        new LinkedList<>()
                ));
                add(new Decade<>(
                        "NucciTheBoss",
                        "Eggs N' Fries",
                        new ArrayList<>(Arrays.asList(
                            "vegetarian", "quick and easy"
                        )),
                        new Pair<>(R.drawable.eggs_n_fries, "Image of Eggs N' Fries"),
                        new Pair<>("15 min", "1"),
                        "I just don't like eating plain eggs, so when I got this recipe from my grandmother it immediately became my favorite breakfast food.",
                        new LinkedList<>(Arrays.asList(
                                "1 teaspoon butter, or to taste",
                                "¼ cup frozen French fries, or to taste",
                                "2 eggs, beaten",
                                "1 pinch salt and ground black pepper to taste"
                        )),
                        new LinkedList<>(Arrays.asList(
                                "Melt butter in a skillet over medium heat. Cook and stir French fries in hot butter until browned and hot, 3 to 5 minutes. Add eggs and season with salt and black pepper; cook and stir until eggs are scrambled and set, 3 to 5 minutes."
                        )),
                        new LinkedList<>(),
                        new LinkedList<>()
                ));
                add(new Decade<>(
                        "NucciTheBoss",
                        "Garlic Quinoa",
                        new ArrayList<>(Arrays.asList(
                            "vegetarian", "kosher"
                        )),
                        new Pair<>(R.drawable.garlic_quinoa, "Image of Garlic Quinoa"),
                        new Pair<>("30 min", "4"),
                        "A quick and easy, basic quinoa recipe.",
                        new LinkedList<>(Arrays.asList(
                                "1 tablespoon butter",
                                "1 tablespoon minced garlic",
                                "2 cups chicken broth",
                                "1 cup quinoa"
                        )),
                        new LinkedList<>(Arrays.asList(
                                "Melt butter in a saucepan over medium heat. Cook and stir garlic in melted butter until just browned, about 5 minutes.",
                                "Pour chicken broth into the saucepan; add quinoa and stir. Bring the mixture to a boil, reduce heat to low, cover, and simmer until liquid is absorbed, about 15 minutes.",
                                "Remove saucepan from heat and rest mixture 5 minutes before fluffing with a fork."
                        )),
                        new LinkedList<>(Arrays.asList(
                                "Best served as a side dish to your main dish."
                        )),
                        new LinkedList<>()
                ));
                add(new Decade<>(
                        "NucciTheBoss",
                        "Roasted Green Beans",
                        new ArrayList<>(Arrays.asList(
                            "vegetarian", "quick and easy"
                        )),
                        new Pair<>(R.drawable.roasted_green_beans, "Image of Roasted Green Beans"),
                        new Pair<>("30 min", "4"),
                        "Roasted green beans are a great alternative to fast-food French fries. My family and friends love these as a snack or hors d'oeuvre. No matter how many I make, it's never enough!",
                        new LinkedList<>(Arrays.asList(
                                "2 pounds fresh green beans, trimmed",
                                "1 tablespoon olive oil, or as needed",
                                "1 teaspoon kosher saltc",
                                "½ teaspoon freshly ground black pepper"
                        )),
                        new LinkedList<>(Arrays.asList(
                                "Preheat the oven to 400 degrees F (200 degrees C).",
                                "Pat green beans dry with paper towels; spread onto a baking sheet. Drizzle with olive oil and sprinkle with salt and pepper. Use your hands to toss the beans until evenly coated with oil; spread out in a single layer.",
                                "Roast beans in the preheated oven until slightly shriveled with golden caramelized spots, 20 to 25 minutes."
                        )),
                        new LinkedList<>(),
                        new LinkedList<>()
                ));
                add(new Decade<>(
                        "NucciTheBoss",
                        "Sriracha Scrambled Eggs",
                        new ArrayList<>(Arrays.asList(
                            "spicy", "vegetarian", "quick and easy"
                        )),
                        new Pair<>(R.drawable.sriracha_scrambled_eggs, "Image of Sriracha Scrambled Eggs"),
                        new Pair<>("10 min", "1"),
                        "This is an excellent, spicy, quick-and-easy breakfast.",
                        new LinkedList<>(Arrays.asList(
                                "2 eggs",
                                "1 tablespoon half-and-half",
                                "1 teaspoon sriracha sauce, or to taste",
                                "salt and ground pepper to taste",
                                "2 tablespoons butter"
                        )),
                        new LinkedList<>(Arrays.asList(
                                "Beat eggs in a bowl with half-and-half, sriracha, salt, and pepper until smooth.",
                                "Melt butter in nonstick pan over medium-low heat, tilting the pan to cover surface entirely with butter. Cook egg mixture in pan, stirring to slowly scramble eggs, until the eggs are fully set, 3 to 5 minutes."
                        )),
                        new LinkedList<>(Arrays.asList(
                                "Serve with toast and hash brown potatoes for a complete meal.",
                                "Add cheese if you wish.",
                                "Can substitute Sriracha with your own recipe"
                        )),
                        new LinkedList<>()
                ));
                add(new Decade<>(
                        "NucciTheBoss",
                        "Steamy Microwave Zucchini",
                        new ArrayList<>(Arrays.asList(
                            "vegetarian", "kosher"
                        )),
                        new Pair<>(R.drawable.steamy_microwave_zucchini, "Image of Steamy Microwave Zucchini"),
                        new Pair<>("23 min", "4"),
                        "Super easy, healthy vegetables with great flavor!",
                        new LinkedList<>(Arrays.asList(
                                "2 zucchini, sliced",
                                "2 stalks celery, chopped",
                                "1 small onion, chopped",
                                "1 small onion, chopped",
                                "½ cup shredded Cheddar cheese"
                        )),
                        new LinkedList<>(Arrays.asList(
                                "Mix zucchini, celery, onion, and mushrooms in a microwave-safe dish. Cover dish with plastic wrap.",
                                "Cook on High until vegetables are steamed and slightly tender, about 6 minutes.",
                                "Pull plastic wrap away from dish, stir vegetables, sprinkle Cheddar cheese over the vegetables, and replace the plastic to seal tightly. Let dish sit until the cheese melts, 2 to 3 minutes. Stir vegetables to coat evenly with melted cheese."
                        )),
                        new LinkedList<>(),
                        new LinkedList<>()
                ));
                add(new Decade<>(
                        "NucciTheBoss",
                        "Tomato Basil Salmon",
                        new ArrayList<>(Arrays.asList(

                        )),
                        new Pair<>(R.drawable.tomato_basil_salmon, "Image of Tomato Basil Salmon"),
                        new Pair<>("30 min", "2"),
                        "This quick salmon dish is perfect for a weeknight dinner.",
                        new LinkedList<>(Arrays.asList(
                                "2 (6 ounce) boneless salmon fillets",
                                "1 tablespoon dried basil",
                                "1 tomato, thinly sliced",
                                "1 tablespoon olive oil",
                                "2 tablespoons grated Parmesan cheese"
                        )),
                        new LinkedList<>(Arrays.asList(
                                "Preheat oven to 375 degrees F (190 degrees C). Line a baking sheet with a piece of aluminum foil, and spray with nonstick cooking spray. Place the salmon fillets onto the foil, sprinkle with basil, top with tomato slices, drizzle with olive oil, and sprinkle with the Parmesan cheese.",
                                "Bake in the preheated oven until the salmon is opaque in the center, and the Parmesan cheese is lightly browned on top, about 20 minutes."
                        )),
                        new LinkedList<>(Arrays.asList(
                                "Serve with a side of sauteed spinach and a glass of pinot noir."
                        )),
                        new LinkedList<>()
                ));
            }
        };

        for (Decade<String, String, ArrayList<String>, Pair<Integer, String>, Pair<String, String>, String, LinkedList<String>, LinkedList<String>, LinkedList<String>, LinkedList<Pair<String, String>>> decade : tmpList) {
            try {
                recipeList.add(
                        new Recipe(
                                decade.getValue0(),
                                decade.getValue1(),
                                decade.getValue2(),
                                decade.getValue3().getValue0(),
                                decade.getValue3().getValue1(),
                                decade.getValue4(),
                                decade.getValue5(),
                                decade.getValue6(),
                                decade.getValue7(),
                                decade.getValue8(),
                                decade.getValue9()
                        )
                );
            } catch (Exception e) {
                Log.e(DEBUG_TAG, "An error occurred loading the recipes", e);
            }
        }
    }

    public void randomize() {
        Collections.shuffle(recipeList);
    }

    public Recipe getCurrentRecipe() {
        return recipeList.get(index);
    }

    public Recipe moveToPreviousRecipe() {
        index -= 1;

        if (index < 0) {
            index = recipeList.size() - 1;
        }

        return recipeList.get(index);
    }

    public Recipe moveToNextRecipe() {
        index += 1;

        if (index >= recipeList.size()) {
            index = 0;
        }

        return recipeList.get(index);
    }
}
