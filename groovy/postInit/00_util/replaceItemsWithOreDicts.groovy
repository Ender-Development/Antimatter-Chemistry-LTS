import cofh.core.util.crafting.ShapelessColorRecipeFactory.ShapelessColorRecipe

def replaceMap = [
    'White' : item('minecraft:dye', 15),
    'Orange' : item('minecraft:dye', 14),
    'Magenta' : item('minecraft:dye', 13),
    'LightBlue' : item('minecraft:dye', 12),
    'Yellow' : item('minecraft:dye', 11),
    'Lime' : item('minecraft:dye', 10),
    'Pink' : item('minecraft:dye', 9),
    'Gray' : item('minecraft:dye', 8),
    'LightGray' : item('minecraft:dye', 7),
    'Cyan' : item('minecraft:dye', 6),
    'Purple' : item('minecraft:dye', 5),
    'Blue' : item('minecraft:dye', 4),
    'Brown' : item('minecraft:dye', 3),
    'Green' : item('minecraft:dye', 2),
    'Red' : item('minecraft:dye', 1),
    'Black': item('minecraft:dye', 0)
]

crafting.streamRecipes()
    .filter(recipe -> {
        recipe.getIngredients().any(ingredient -> {
            ingredient != null
            && ingredient.matchingStacks.size() > 0
            && ingredient.matchingStacks.any(stack -> {
                stack != null && replaceMap.values().any({ i ->
                    stack in i
                })
            })
        })
    })
    .forEach(recipe -> {
        if (recipe instanceof ShapelessColorRecipe) {
            crafting.remove(recipe.group)
        }
    })
