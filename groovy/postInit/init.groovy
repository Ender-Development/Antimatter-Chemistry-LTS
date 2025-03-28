import com.cleanroommc.groovyscript.helper.GroovyHelper;

log.cleanLog()
log.info("Groovy Version: " + GroovyHelper.getGroovyVersion())
log.info("GroovyScript Version: " + GroovyHelper.getGroovyScriptVersion())

// for (entry in ore('ingot*')) {
//     if (entry.getItem() == null) continue
//     if (entry.getItem().getRegistryName() == null) continue
//     def name = entry.getItem().getRegistryName().toString()
//     if (name.contains("alchemistry")) {
//         def full_name = entry.getDisplayName().split(" ")
//         def element = full_name[0].toLowerCase().capitalize()
//         def ore_name = "ingot${element}"
//         if (ore_dict.exists(ore_name)) {
//             log.info(element)
//         }
//     }
// }
