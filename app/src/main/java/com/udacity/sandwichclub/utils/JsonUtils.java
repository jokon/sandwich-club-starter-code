package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject sandwichJson = new JSONObject(json);
            JSONObject name = sandwichJson.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownAsJson = name.getJSONArray("alsoKnownAs");
            String placeOfOrigin = sandwichJson.getString("placeOfOrigin");
            String description = sandwichJson.getString("description");
            String imageUrl = sandwichJson.getString("image");
            JSONArray ingredientsJson = sandwichJson.getJSONArray("ingredients");

            List<String> ingredients = new ArrayList<>();
            List<String> alsoKnownAs = new ArrayList<>();

            for (int ingredientId = 0; ingredientId < ingredientsJson.length(); ingredientId++) {
                ingredients.add(ingredientsJson.getString(ingredientId));
            }

            for (int knownAsId = 0; knownAsId < alsoKnownAsJson.length(); knownAsId++) {
                alsoKnownAs.add(alsoKnownAsJson.getString(knownAsId));
            }


            Sandwich sandwich = new Sandwich();
            sandwich.setMainName(mainName);
            sandwich.setAlsoKnownAs(alsoKnownAs);
            sandwich.setDescription(description);
            sandwich.setIngredients(ingredients);
            sandwich.setImage(imageUrl);
            sandwich.setPlaceOfOrigin(placeOfOrigin);
            return sandwich;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
