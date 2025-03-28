mods.minecraft.crafting.shapedBuilder()
    .output(item('pickletweaks:hammer'))
    .row('XA')
    .row('YX')
    .key('Y', ore('stickWood'))
    .key('A', ore('ingotIron'))
    .key('X', ore('nuggetIron'))
    .replace()
    .register()

mods.minecraft.crafting.shapelessBuilder()
    .output(ore('dustCoal').getFirst())
    .input(item('pickletweaks:hammer:*'))
    .input(ore('coal'))
    .register()

mods.minecraft.crafting.shapedBuilder()
    .output(ore('stickBlackIron').getFirst() * 2)
    .row('X')
    .row('Y')
    .row('Y')
    .key('Y', ore('ingotBlackIron'))
    .key('X', item('pickletweaks:hammer:*'))
    .replace()
    .register()

def metals = [
    'Iron',
    'Gold',
    'Copper',
    'Tin',
    'Silver',
    'Lead',
    'Alumium',
    'Nickel',
    'Platinum',
    'Iridium',
    'Mithril',
    'Steel',
    'Electrum',
    'Invar',
    'Bronze',
    'Constantan',
    'Signalum',
    'Lumium',
    'Enderium'
]

for (metal in metals) {
    mods.minecraft.crafting.shapedBuilder()
        .output(ore("plate${metal}").getFirst())
        .row('X ')
        .row('YY')
        .key('Y', ore("ingot${metal}"))
        .key('X', item('pickletweaks:hammer:*'))
        .replace()
        .register()
}
