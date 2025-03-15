// Antimatter
def modsToDelete = [
    'black',
    'blue',
    'brown',
    'cyan',
    'gray',
    'green',
    'light_blue',
    'lime',
    'magenta',
    'orange',
    'pink',
    'purple',
    'red',
    'light_gray',
    'white',
    'yellow'
]

modsToDelete.each { color ->
    content.createBlock('antimatter_' + color).register()
}

