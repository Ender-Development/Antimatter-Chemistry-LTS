def matter = [
    'amc_lts:antimatter_light_gray' : 'iron',
    'amc_lts:antimatter_orange' : 'copper',
    'amc_lts:antimatter_red' : 'iron_oxide',
    'amc_lts:antimatter_gray' : 'tantalum',
    'amc_lts:antimatter_pink' : 'magnesium',
    'amc_lts:antimatter_black' : 'carbon',
    'amc_lts:antimatter_green' : 'rubidium',
    'amc_lts:antimatter_brown' : 'neodymium',
    'amc_lts:antimatter_blue' : 'argon',
    'amc_lts:antimatter_purple' : 'iodine',
    'amc_lts:antimatter_cyan' : 'barium',
    'amc_lts:antimatter_lime' : 'neon',
    'amc_lts:antimatter_yellow' : 'sulfur',
    'amc_lts:antimatter_light_blue' : 'niobium',
    'amc_lts:antimatter_magenta' : 'gallium',
]

matter.each { key, value ->
    mods.minecraft.crafting.shapedBuilder()
        .output(item(key))
        .row('XXX')
        .row('XYX')
        .row('XXX')
        .key('X', ore('amcAntimatter'))
        .key('Y', element(value))
        .register()
}
