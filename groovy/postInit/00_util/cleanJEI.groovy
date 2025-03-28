def hide = [
    'itemfilters:missing',
    'minecraft:barrier',
    'minecraft:crafting_table',
    'minecraft:chain_command_block',
    'minecraft:command_block_minecart',
    'minecraft:command_block',
    'minecraft:farmland',
    'minecraft:filled_map',
    'minecraft:fireworks',
    'minecraft:grass_path',
    'minecraft:knowledge_book',
    'minecraft:mob_spawner',
    'minecraft:repeating_command_block',
    'minecraft:structure_block',
    'minecraft:structure_void',
    'minecraft:written_book',
    'qmd:block_blue_luminous_paint',
    'qmd:block_green_luminous_paint',
    'qmd:block_orange_luminous_paint',
    'rftools:camo_shield_block_opaque',
    'rftools:camo_shield_block',
    'rftools:invisible_shield_block_opaque',
    'rftools:invisible_shield_block',
    'rftools:notick_camo_shield_block_opaque',
    'rftools:notick_camo_shield_block',
    'rftools:notick_invisible_shield_block_opaque',
    'rftools:notick_invisible_shield_block',
    'rftools:notick_solid_shield_block_opaque',
    'rftools:notick_solid_shield_block',
    'rftools:solid_shield_block_opaque',
    'rftools:solid_shield_block'
]

hide.each { entry ->
    mods.jei.ingredient.removeAndHide(item(entry))
}
