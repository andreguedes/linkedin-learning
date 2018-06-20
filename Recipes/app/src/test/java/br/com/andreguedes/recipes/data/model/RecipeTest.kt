package br.com.andreguedes.recipes.data.model

import org.junit.Assert.*
import org.junit.Test

class RecipeTest {

    @Test
    fun shouldGetCorrectInfoFromWaterRecipeFile() {
        val stream = RecipeTest::class.java.getResourceAsStream("/recipes/water.txt")
        val recipe = Recipe.readFromStream(stream)
        assertNotNull(recipe)
        assertEquals("water", recipe!!.id)
        assertEquals("Water", recipe.title)
        assertEquals("Put glass under tap. Open tap. Close tap. Drink.", recipe.description.toString())
    }

}