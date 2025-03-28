import groovy.transform.Field
import net.minecraftforge.event.entity.player.ItemTooltipEvent
import net.minecraftforge.fml.common.Loader
import com.cleanroommc.groovyscript.compat.vanilla.OreDict


def formatTooltip(ItemTooltipEvent event) {
    def modName = event.getItemStack().item.getRegistryName().getNamespace()
    def formatedModName = Loader.instance().getIndexedModList().get(modName).getName()
        .replace('MatterOverdrive: Community Edition', 'MatterOverdrive: CE')
        .replace('The One Probe Community Edition', 'The One Probe: CE')
        .replace('Quantum Minecraft Dynamics', 'QMD')
        .replace('Nomifactory Edition', 'NE')
        .replace('AE2 Unofficial Extended Life', 'Applied Energistics 2: UEL')

    if (event.toolTip.size() > 1){
        def newTooltip = []
        def unformattedTooltip = [event.toolTip.get(0)]

        def ttColor;
        def ttCount;
        def ttWater;
        def ttMagnet;
        def ttPower;
        def ttHeat;
        def ttTemperature;
        def ttParticle;
        def ttRF;
        def ttRadius;
        def ttArea;
        def ttDurability;
        def ttCompost;
        def ttAttackDamage;
        def ttAttackSpeed;
        def ttRadResistance;
        def ttElectrolyte;
        def ttMatter;
        def ttKilled;
        def ttTotalDamage;
        def ttMiningLevel;
        def ttMiningSpeed;
        def ttBlocksMined;

        event.toolTip.subList(1, event.toolTip.size()).each { line ->
            switch(line) {
                case { it.contains('Power Tier') || it.contains('NBT') || it.contains(modName) || it.contains('None') || it.contains('When in') || it.isEmpty() }:
                    // ignore
                    break
                case { it.contains('Color') }:
                    ttColor = '§b ' + line
                    break
                case { it.contains('Count') }:
                    ttCount = '§b ' + line
                    break
                case { it.contains('Cooling Rate') }:
                    ttWater = '§b ' + line
                    break
                case { it.contains('Magnet Strength') }:
                    ttMagnet = '§b ' + line
                    break
                case { it.contains('Heat') }:
                    ttHeat = '§b ' + line
                    break
                case { it.contains('Operating Temperature') }:
                    ttTemperature = '§b ' + line
                    break
                case { it.contains('Power') }:
                    ttPower = '§b ' + line
                    break
                case { it.contains('Particle Efficiency') }:
                    ttParticle = '§b ' + line
                    break
                case { it.contains('RF') || it.contains('AE') || it.contains('FE') }:
                    ttRF = '§c ' + line
                    break
                case { it.contains('Durability') }:
                    ttDurability = '§f ' + line
                    break
                case { it.contains('Compost') }:
                    ttCompost = '§2 ' + line
                    break
                case { it.contains('Radius') }:
                    ttRadius = '§c Radius:§r ' + line.replace('Radius: ', '')
                    break
                case { it.contains('Area') }:
                    ttArea = '§c Area:§r ' + line.replace('Area: ', '')
                    break
                case { it.contains('Attack Damage') }:
                    ttAttackDamage = '§4 Attack Damage:§r ' + line.replace(' Attack Damage ', '').replace('+', '').replace('Attack Damage', '')
                    break
                case { it.contains('Attack Speed') }:
                    ttAttackSpeed = '§4 Attack Speed:§r' + line.replace(' Attack Speed', '')
                    break
                case { it.contains('Rad Resistance') }:
                    ttRadResistance = '§4 Rad Resistance:' + line.replace('Rad Resistance:', '')
                    break
                case { it.contains('Electrolyte') }:
                    ttElectrolyte = '§4 Chance to consume:' + line.replace('Electrolyte Consumption Probability:', '')
                    break
                case { it.contains('Matter') }:
                    ttMatter = '§4 Matter: ' + line.replace('Matter:', '')
                    break
                case { it.contains('Killed') }:
                    ttKilled = '§4 Overall Kills: ' + line.replace('Enemies Killed: ', '')
                    break
                case { it.contains('Damage Dealt') }:
                    ttTotalDamage = '§4 Dealt Damage: ' + line.replace('Damage Dealt: ', '')
                    break
                case { it.contains('Mining Level') }:
                    ttMiningLevel = '§4 Mining Level: ' + line.replace('Mining Level: ', '')
                    break
                case { it.contains('Mining Speed') }:
                    ttMiningSpeed = '§4 Mining Speed: ' + line.replace('Mining Speed: ', '')
                    break
                case { it.contains('Blocks Broken') }:
                    ttBlocksMined = '§4 Blocks Mined: ' + line.replace('Blocks Broken: ', '')
                    break
                default:
                    unformattedTooltip.add(line)
                    break
            }
        }

        // set order of tooltip lines
        if (ttColor) newTooltip.add(ttColor)
        if (ttCount) newTooltip.add(ttCount)
        if (ttWater) newTooltip.add(ttWater)
        if (ttMagnet) newTooltip.add(ttMagnet)
        if (ttPower) newTooltip.add(ttPower)
        if (ttHeat) newTooltip.add(ttHeat)
        if (ttTemperature) newTooltip.add(ttTemperature)
        if (ttParticle) newTooltip.add(ttParticle)
        if (ttRF) newTooltip.add(ttRF)
        if (ttRadius) newTooltip.add(ttRadius)
        if (ttArea) newTooltip.add(ttArea)
        if (ttCompost) newTooltip.add(ttCompost)
        if (ttDurability) newTooltip.add(ttDurability)
        if (ttAttackDamage) newTooltip.add(ttAttackDamage)
        if (ttAttackSpeed) newTooltip.add(ttAttackSpeed)
        if (ttRadResistance) newTooltip.add(ttRadResistance)
        if (ttElectrolyte) newTooltip.add(ttElectrolyte)
        if (ttMatter) newTooltip.add(ttMatter)
        if (ttKilled) newTooltip.add(ttKilled)
        if (ttTotalDamage) newTooltip.add(ttTotalDamage)
        if (ttBlocksMined) newTooltip.add(ttBlocksMined)
        if (ttMiningSpeed) newTooltip.add(ttMiningSpeed)
        if (ttMiningLevel) newTooltip.add(ttMiningLevel)


        event.toolTip.clear()
        event.toolTip.addAll(unformattedTooltip)

        def longestLine = ''
        def longestUnformatted = unformattedTooltip.max { it.length() }
        def longestNew = newTooltip.max { it.length() }

        if (longestUnformatted?.length() > longestNew?.length()) {
            longestLine = longestUnformatted
        } else {
            longestLine = longestNew
        }

        if (longestLine.length() < formatedModName.length()) {
            longestLine = formatedModName
        } else {
            longestLine += '    '
        }

        longestLine = longestLine.replaceAll('§.', '')

        if (unformattedTooltip.size() > 1) {
            event.toolTip.add('§8' + ('─' * longestLine.length()))
        }

        event.toolTip.addAll(newTooltip)

        if (newTooltip.size() > 0) {
            event.toolTip.add('§8' + ('─' * longestLine.length()))
        }
    }

    event.toolTip.add('§5§o' + formatedModName + '§r')
}

// Event Handler

event_manager.listen { ItemTooltipEvent event ->
    formatTooltip(event)
}
