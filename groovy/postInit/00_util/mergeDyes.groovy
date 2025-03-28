def colorOwner = "industrialforegoing"
def otherDyes = []

def colors = [
    'White',
    'Orange',
    'Magenta',
    'LightBlue',
    'Yellow',
    'Lime',
    'Pink',
    'Gray',
    'LightGray',
    'Cyan',
    'Purple',
    'Blue',
    'Brown',
    'Green',
    'Red',
    'Black'
]

def mcDyes = [
    'Purple' : 5,
    'Cyan' : 6,
    'LightGray' : 7,
    'Gray' : 8,
    'Pink' : 9,
    'Lime' : 10,
    'LightBlue' : 12,
    'Magenta' : 13,
    'Orange' : 14
]

for (color in colors) {
    def stringColor = "dye$color"
    for (dye in ore_dict.getItems(stringColor)) {
        if (owner(dye.item) == colorOwner) {
            ore_dict.clear(stringColor)
            ore_dict.add(stringColor, dye)
        } else {
            otherDyes.add(dye)
        }
    }
    for (dye in otherDyes) {
        if (owner(dye.item) == 'thermalfoundation') continue
        if (owner(dye.item) == 'minecraft' && mcDyes.containsValue(dye.getMetadata())) {
            mods.jei.ingredient.removeAndHide(dye)
        } else {
            crafting.shapelessBuilder()
                .output(ore(stringColor).getFirst())
                .input(item('pickletweaks:mortar_and_pestle'), dye)
                .register()
        }
    }
    otherDyes.clear()
}

static def owner(Item item) {
    return item.getRegistryName().getNamespace()
}
