package com.rido.akupengenimo.data.local

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object HeroDataProvider {
    private var iconMap: Map<Int, String> = emptyMap()
    private var counterData: List<HeroCounter> = emptyList()


    fun loadExtraData(context: Context) {
        val gson = Gson()
        try {

            val iconJson = context.assets.open("roundIconMap.json").bufferedReader().use { it.readText() }
            val rawIconMap: Map<String, Int> = gson.fromJson(iconJson, object : TypeToken<Map<String, Int>>() {}.type)
            iconMap = rawIconMap.entries.associate { it.value to it.key }


            val counterJson = context.assets.open("heroescounter.json").bufferedReader().use { it.readText() }
            counterData = gson.fromJson(counterJson, object : TypeToken<List<HeroCounter>>() {}.type)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getIconById(id: Int): String = iconMap[id] ?: ""
    fun getCounterInfo(id: Int): HeroCounter? = counterData.find { it.id == id }
    fun getListHeroes(): List<Hero> {
        return listOf(
            Hero(
                132,
                name = "Marcel",
                description = "Support",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_2_1_60_2/100_dd980a8816698f1503cdb76201d17dd0.png",
                skills = listOf(
                    Skill(
                        "Passive: Platinum Snap",
                        "Marcel's split soul, Clemar, enters the camera to freeze the moment. Marcel's Basic Attacks deal 50 (+40% Total Physical Attack) (+40% Total Physical Defense) (+40% Total Magic Defense) Physical Damage but cannot Crit. He cannot benefit from extra Attack Speed. Extra HP is converted into 1.5% Hybrid Defense. Clemar automatically snaps photos of nearby enemy heroes, causing a brief Frozen Moment and dealing True Damage equal to 20 + 5% of their Max HP (can trigger attack effects). It also grants a shield of the same amount to Marcel and a nearby allied hero. This effect has a 12s cooldown per target; Marcel Basic Attacks reduce that target's cooldown by 1s."
                    ),
                    Skill(
                        "Skill 1: Close-up Focus",
                        "Marcel takes a quick photo of the target direction, dealing Physical Damage to enemies in a fan-shaped area and slowing them briefly."
                    ),
                    Skill(
                        "Skill 2: Flash Blast",
                        "Marcel activates the flash of his camera, dealing Physical Damage to nearby enemies and blinding them, reducing their vision range."
                    ),
                    Skill(
                        "Ultimate: The Perfect Moment",
                        "Marcel locks onto an enemy hero and takes a perfect shot, dealing massive True Damage based on the target's lost HP and revealing their position."
                    )
                )
            ),
            Hero(
                131,
                name = "Sora",
                description = "Fighter/Assassin",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_2_1_40/100_4749a1f7fe99cbedfc5ef23fc1287d6c.png",
                skills = listOf(
                    Skill(
                        "Passive: Starry Night",
                        "Sora's skills leave star marks on enemies hit. At full stacks, Sora's next attack deals extra Magic Damage and restores her HP."
                    ),
                    Skill(
                        "Skill 1: Meteor Shower",
                        "Sora calls down meteors in a target area, dealing continuous Magic Damage to enemies within the radius."
                    ),
                    Skill(
                        "Skill 2: Astral Dash",
                        "Sora dashes through enemies, dealing Magic Damage and gaining a temporary shield based on the number of enemies hit."
                    ),
                    Skill(
                        "Ultimate: Galaxy Burst",
                        "Sora unleashes a massive burst of astral energy around her, dealing high Magic Damage to all enemies in a large radius and knocking them back."
                    )
                )
            ),
            Hero(
                130,
                name = "Obsidia",
                description = "Marksman",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_2_1_18/100_92bcc9ad2c4c8165a888d34f086a4d28.png",
                skills = listOf(
                    Skill(
                        "Passive: Dark Resonance",
                        "Obsidia's Basic Attacks deal extra Physical Damage to enemies currently affected by any crowd control effects."
                    ),
                    Skill(
                        "Skill 1: Shadow Bolt",
                        "Obsidia fires a piercing bolt of dark energy in a straight line that damages and slows all enemies in its path."
                    ),
                    Skill(
                        "Skill 2: Abyssal Trap",
                        "Obsidia places a hidden trap on the ground that roots the first enemy who steps on it, dealing Physical Damage over time."
                    ),
                    Skill(
                        "Ultimate: Void Annihilation",
                        "Obsidia channels dark energy to fire a massive beam across the map, dealing devastating Physical Damage to all enemies hit."
                    )
                )
            ),
            Hero(
                129,
                name = "Zetian",
                description = "Mage",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_1_9_90/100_22dc8b16ea98a735027c3141b74ef841.png",
                skills = listOf(
                    Skill(
                        "Passive: Empress's Majesty",
                        "Zetian automatically recovers Mana and gains a brief Movement Speed boost whenever she hits an enemy hero with a skill."
                    ),
                    Skill(
                        "Skill 1: Imperial Decree",
                        "Zetian summons an energy blast at the target location, dealing Magic Damage and reducing the Magic Defense of enemies hit."
                    ),
                    Skill(
                        "Skill 2: Dragon's Wrath",
                        "Zetian unleashes a wave of draconic energy that knocks back nearby enemies and deals Magic Damage."
                    ),
                    Skill(
                        "Ultimate: Heaven's Judgment",
                        "Zetian summons a divine execution strike on all enemy heroes on the map, dealing Magic Damage and revealing their locations for a short duration."
                    )
                )
            ),
            Hero(
                128,
                name = "Kalea",
                description = "Fighter/Support",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_1_9_64/100_9c5f2904026ba88b7aba8c9b2722f4ad.png",
                skills = listOf(
                    Skill(
                        "Passive: Desert Blessing",
                        "Kalea gains extra Hybrid Defense for every enemy hero surrounding her, making her exceptionally durable in team fights."
                    ),
                    Skill(
                        "Skill 1: Sand Whirl",
                        "Kalea spins with her weapon, dealing continuous Physical Damage to nearby enemies and healing herself for a percentage of the damage dealt."
                    ),
                    Skill(
                        "Skill 2: Dune Dash",
                        "Kalea dashes forward, gaining a shield and enhancing her next Basic Attack to deal extra damage and slow the target."
                    ),
                    Skill(
                        "Ultimate: Oasis Call",
                        "Kalea summons a massive sandstorm that continuously deals Physical Damage, slows enemies, and provides continuous healing to allied heroes within the area."
                    )
                )
            ),
            Hero(
                127,
                name = "Lukas",
                description = "Fighter",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_1_9_20/100_454c13b2de7b7d1a20fbf553c620510d.png",
                skills = listOf(
                    Skill(
                        "Passive: Sacred Beast's Awakening",
                        "Lukas gains Sacred Energy when dealing or taking damage. At full energy, he enters an Awakened state, enhancing his abilities and Basic Attacks."
                    ),
                    Skill(
                        "Skill 1: Beast Strike",
                        "Lukas punches forward, dealing Physical Damage. In Awakened state, the attack range and damage are significantly increased."
                    ),
                    Skill(
                        "Skill 2: Earth Shatter",
                        "Lukas smashes the ground, dealing Physical Damage and slowing enemies. In Awakened state, this skill also causes a brief airborne effect."
                    ),
                    Skill(
                        "Ultimate: Final Roar",
                        "Lukas unleashes a powerful roar, dealing massive Physical Damage and stunning enemies in a wide cone in front of him."
                    )
                )
            ),
            Hero(
                126,
                name = "Suyou",
                description = "Assassin/Fighter",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_1_9_20/100_422ffc7849e8bb01629d2423054ed410.png",
                skills = listOf(
                    Skill(
                        "Passive: Transient Immortal",
                        "Suyou receives different buffs depending on whether he taps or holds his skills. Tapping grants extra Movement Speed, while holding grants Damage Reduction."
                    ),
                    Skill(
                        "Skill 1: Blade Surge",
                        "Tap: Suyou throws his weapon forward, dealing Physical Damage. Hold: Suyou charges in the target direction, dealing Physical Damage to enemies in his path."
                    ),
                    Skill(
                        "Skill 2: Soul Sever",
                        "Tap: Suyou performs a sweeping attack, dealing Physical Damage. Hold: Suyou unleashes a lethal strike on a single target, dealing Physical Damage based on the target's lost HP."
                    ),
                    Skill(
                        "Ultimate: Evil Queller",
                        "Tap: Suyou leaps and strikes the ground, dealing Physical Damage. Hold: Suyou fires a long-range energy blast, dealing massive Physical Damage and slowing enemies."
                    )
                )
            ),
            Hero(
                125,
                name = "Zhuxin",
                description = "Mage",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_92/100_13cfeec4bec7a27a09677e519f1ef9d2.png",
                skills = listOf(
                    Skill(
                        "Passive: Crimson Butterflies",
                        "Zhuxin converts the Mana spent on her skills into Crimson Butterflies. After they disappear, each one restores a portion of Zhuxin's Mana."
                    ),
                    Skill(
                        "Skill 1: Fluttering Grace",
                        "Zhuxin deals Magic Damage to enemies in a fan-shaped area and slows them. She also gains Crimson Butterflies upon hitting enemies."
                    ),
                    Skill(
                        "Skill 2: Lantern Flare",
                        "Zhuxin consumes Mana to deal Magic Damage to enemies in the target area. Hitting an enemy hero makes them Airborne and pulls them to the center of the skill."
                    ),
                    Skill(
                        "Ultimate: Crimson Beacon",
                        "Zhuxin blinks to the target location, gaining a Shield and creating a continuous field around her that deals Magic Damage to nearby enemies over time."
                    )
                )
            ),
            Hero(
                124,
                name = "Chip",
                description = "Support/Tank",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_85e15c66733cab7d8d73f7f725f31f1e.png",
                skills = listOf(
                    Skill(
                        "Passive: Snack Time!",
                        "Chip starts eating potato chips when out of combat, recovering lost HP over time to sustain himself on the map."
                    ),
                    Skill(
                        "Skill 1: Crash Course",
                        "Chip rams his hovercraft into the ground, dealing Magic Damage and applying Chip's Mark to enemies hit."
                    ),
                    Skill(
                        "Skill 2: Overtime",
                        "Chip gains Movement Speed and charges forward. His next Basic Attack is enhanced, dealing Magic Damage and knocking back the target."
                    ),
                    Skill(
                        "Ultimate: Shortcut",
                        "Chip drops the Main Portal on an enemy hero, dealing Magic Damage. Connecting Portals are created near allied heroes, allowing them to teleport directly to the Main Portal."
                    )
                )
            ),
            Hero(
                123,
                name = "Cici",
                description = "Fighter",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_4f970eb4b44b8c9fff2c511d8e856ff4.png",
                skills = listOf(
                    Skill(
                        "Passive: Performer's Delight",
                        "Cici generates a stack of Delight after dealing damage, increasing her Movement Speed and Spell Vamp. At full stacks, the effects are doubled."
                    ),
                    Skill(
                        "Skill 1: Yo-Yo Blitz",
                        "Cici throws her Yoyo at the nearest enemy within range, continuously dealing Physical Damage for multiple hits while she is free to move."
                    ),
                    Skill(
                        "Skill 2: Buoyant Bounce",
                        "Cici leaps to the target location. If she lands on an enemy, she deals Physical Damage and is able to leap again in another direction."
                    ),
                    Skill(
                        "Ultimate: Curtain Call",
                        "Cici throws her Yoyo at the target enemy hero and links them with another nearby enemy. Linked enemies share damage and are pulled together if they move too far apart."
                    )
                )
            ),
            Hero(
                122,
                name = "Nolan",
                description = "Assassin",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_0495066df0d828c149e7fe89aa63078b.png",
                skills = listOf(
                    Skill(
                        "Passive: Dimensional Rift",
                        "Nolan's skills leave a rift in the ground. When rifts intersect, they pull enemies to their center and explode, dealing Physical Damage. Nolan gains extra Energy when an enemy hero or Creep is hit by the explosion."
                    ),
                    Skill(
                        "Skill 1: Expansion",
                        "Nolan cuts a rift in front of him, dealing Physical Damage and slowing enemies hit."
                    ),
                    Skill(
                        "Skill 2: Gauge",
                        "Nolan charges in the target direction, dealing Physical Damage to enemies in his path and leaving a rift behind."
                    ),
                    Skill(
                        "Ultimate: Fracture",
                        "Nolan slashes enemies in a target area 3 times, dealing Physical Damage and leaving 3 rifts. Meanwhile, Nolan removes all debuffs on himself and slashes backward."
                    )
                )
            ),
            Hero(
                121,
                name = "Ixia",
                description = "Marksman",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_c5f758bd1141327d36f2c77928268ab7.png",
                skills = listOf(
                    Skill(
                        "Passive: Siphon Starlium",
                        "Ixia's Basic Attacks and skills apply a stack of Starlium Charge to enemies. When Ixia performs a Basic Attack on an enemy with 2 stacks, it consumes the stacks to deal extra Physical Damage and restore her HP."
                    ),
                    Skill(
                        "Skill 1: Dual Beam",
                        "Ixia fires 2 Starlium energy beams along the ground, dealing Physical Damage to enemies hit and slowing them. Upon hitting an enemy hero, Ixia gains Movement Speed."
                    ),
                    Skill(
                        "Skill 2: Star Helix",
                        "Ixia launches a canister of Starlium energy in the target direction, knocking back nearby enemies, pulling enemies in its path to the center line, and dealing Physical Damage."
                    ),
                    Skill(
                        "Ultimate: Full Barrage",
                        "Ixia disassembles her weapon into 6 cannons and enters the Barrage state. Her Basic Attack and skill range are greatly increased in a fan-shaped area, but she cannot move. Her Basic Attacks can hit up to 6 enemy units simultaneously."
                    )
                )
            ),
            Hero(
                120,
                name = "Arlott",
                description = "Fighter/Assassin",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_01450fec4397f8780ce0d11ab652c73d.png",
                skills = listOf(
                    Skill(
                        "Passive: Demon Gaze",
                        "Arlott's demonic eye leaves a mark on nearby enemy units that are affected by crowd control effects. The mark lasts for a period of time."
                    ),
                    Skill(
                        "Skill 1: Dauntless Strike",
                        "Arlott swings his lance forward, dealing Physical Damage and briefly stunning targets hit. Targets hit by the further half of the AoE are stunned for longer."
                    ),
                    Skill(
                        "Skill 2: Vengeance",
                        "Arlott charges at an enemy, dealing Physical Damage. If the target has a mark, this skill deals double damage, refreshes its cooldown, and restores Arlott's HP."
                    ),
                    Skill(
                        "Ultimate: Final Slash",
                        "Arlott sweeps his lance in a wide arc, dealing Physical Damage to enemies in the area and sweeping them to the edge of the AoE, briefly revealing their locations."
                    )
                )
            ),
            Hero(
                119,
                name = "Novaria",
                description = "Mage",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_12c811236741ae8e3fbdaa2d884b30a2.png",
                skills = listOf(
                    Skill(
                        "Passive: Star Trail",
                        "Novaria's Astral Spheres will continuously slow nearby enemies by 20%. When an Astral Sphere explodes, it deals Magic Damage equal to a percentage of the target's Max HP."
                    ),
                    Skill(
                        "Skill 1: Astral Meteor",
                        "Novaria summons an Astral Meteor to crash down at the target location, dealing Magic Damage and slowing enemies. Meteor fragments will then continuously strike the area, dealing Magic Damage."
                    ),
                    Skill(
                        "Skill 2: Astral Recall",
                        "Novaria summons an Astral Sphere from a distance and draws it towards her. While the Sphere is traveling, Novaria gains Movement Speed and can pass through terrain. When she catches the Sphere, she can launch it in a target direction to deal massive Magic Damage."
                    ),
                    Skill(
                        "Ultimate: Astral Echo",
                        "Novaria scatters Astral Echoes in a target direction. The Echoes will attach to enemy heroes hit, slowing them, revealing their locations, and increasing the hitbox size of the targets."
                    )
                )
            ),
            Hero(
                118,
                name = "Joy",
                description = "Assassin",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_6b5570b0e557e36501b4228fcdfcf164.png",
                skills = listOf(
                    Skill(
                        "Passive: Humph, Joy's Angry!",
                        "Joy becomes Angry! for 4s each time her skill deals damage to a non-minion enemy, during which she gains 100% extra Movement Speed and Damage Reduction."
                    ),
                    Skill(
                        "Skill 1: Look, Leonin Crystal!",
                        "Joy summons a Leonin Crystal at the target location, dealing Magic Damage to nearby enemies. The Crystal lasts for a short duration and can be used as a springboard for her Skill 2."
                    ),
                    Skill(
                        "Skill 2: Meow, Rhythm of Joy!",
                        "Joy dashes in the target direction, dealing Magic Damage to enemies in her path. Hitting an enemy or a Leonin Crystal allows her to cast this skill again (up to 5 times). Casting it to the beat of the music increases its damage and grants a shield."
                    ),
                    Skill(
                        "Ultimate: Ha, Electrifying Beats!",
                        "Joy can only cast this ultimate after she has successfully cast her Skill 2 five times in succession. She removes all control effects on herself, gains Movement Speed, and continuously deals Magic Damage to nearby enemies."
                    )
                )
            ),
            Hero(
                117,
                name = "Fredrinn",
                description = "Fighter/Tank",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_3f574825bd9192094f047a4abc6d5d05.png",
                skills = listOf(
                    Skill(
                        "Passive: Crystalline Armor",
                        "Fredrinn stores a percentage of the damage he takes as Crystal Energy. He can convert Crystal Energy into HP by dealing damage to enemies with his skills or Basic Attacks."
                    ),
                    Skill(
                        "Skill 1: Piercing Strike",
                        "Fredrinn thrusts his sword in the target direction, dealing Physical Damage to enemies hit and enhancing his next Basic Attack to gain extra attack range."
                    ),
                    Skill(
                        "Skill 2: Brave Assault",
                        "Fredrinn dashes in the target direction, dealing Physical Damage to the first non-minion enemy hit and enhancing his next Basic Attack to knock the target airborne."
                    ),
                    Skill(
                        "Skill 3: Energy Eruption",
                        "Fredrinn deals Physical Damage to nearby enemies and taunts them. Hitting a non-minion enemy reduces the cooldowns of his Skill 1 and Skill 2. Costs 1 Combo Point."
                    ),
                    Skill(
                        "Ultimate: Appraiser's Wrath",
                        "Fredrinn slams his sword in the target direction, dealing immense Physical Damage plus a percentage of his Crystal Energy to enemies in a fan-shaped area. Costs 3 Combo Points."
                    )
                )
            ),
            Hero(
                116,
                name = "Julian",
                description = "Assassin/Fighter",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_44891c699fb1c00fc4a7fa59ea95b8b3.png",
                skills = listOf(
                    Skill(
                        "Passive: Smith's Legacy",
                        "After casting two different skills, Julian enhances his third skill. Casting the enhanced skill resets the cooldowns of all his skills and enhances his Basic Attacks for 5s. Julian has no Ultimate skill; all his skills can be upgraded to Level 5."
                    ),
                    Skill(
                        "Skill 1: Scythe",
                        "Julian hurls a flying scythe in the target direction, dealing Magic Damage to enemies along the path and slowing them. (Enhanced: Hurls enhanced scythes that deal continuous damage and slow)."
                    ),
                    Skill(
                        "Skill 2: Sword",
                        "Julian summons a flying sword and dashes in the target direction, dealing Magic Damage to enemies in his path. (Enhanced: Summons multiple swords and dashes, becoming briefly invincible)."
                    ),
                    Skill(
                        "Skill 3: Chain",
                        "Julian casts a chain at the target location, dealing Magic Damage to enemies hit and immobilizing them. (Enhanced: Casts chains in a larger area, knocking enemies airborne and dealing continuous damage)."
                    )
                )
            ),
            Hero(
                115,
                name = "Xavier",
                description = "Mage",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_2_1_18_2/100_50a5b0dd98ed2378d9f618e5ef0d47b2.png",
                skills = listOf(
                    Skill(
                        "Passive: Transcendence",
                        "Xavier enhances his skills each time his skill hits an enemy hero. At Stage III, all his skills are greatly enhanced. The enhancement lasts for 5s and can be extended by hitting enemies."
                    ),
                    Skill(
                        "Skill 1: Infinite Extension",
                        "Xavier fires a Mystic Bullet that deals Magic Damage to enemies in its path. The Bullet's flying distance increases each time it hits an enemy or the Mystic Barrier."
                    ),
                    Skill(
                        "Skill 2: Mystic Field",
                        "Xavier conjures a Mystic Barrier that slows enemies who pass through it and speeds up allies. Hitting the Barrier with other skills expands it into a forbidden field that immobilizes enemies."
                    ),
                    Skill(
                        "Ultimate: Dawning Light",
                        "Xavier unleashes a massive beam of Mystic magic that deals Magic Damage to all enemies in a line across the map. Casting this skill directly puts him into Stage III of Transcendence."
                    )
                )
            ),
            Hero(
                114,
                name = "Melissa",
                description = "Marksman",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_2_1_18_2/100_8044c8e2e966533e8978b20f4ecb5cd9.png",
                skills = listOf(
                    Skill(
                        "Passive: Doll Buster",
                        "Melissa deals 125% damage to minions and summoned units (including Muddles)."
                    ),
                    Skill(
                        "Skill 1: Falling!",
                        "Melissa slides forward and gains extra Attack Speed for a short duration. Muddles will also move in the same direction."
                    ),
                    Skill(
                        "Skill 2: Eyes on You!",
                        "Melissa throws Muddles in a target direction, dealing Physical Damage to enemies and linking nearby enemy heroes. Basic Attacks hitting Muddles will deal damage to all linked enemies."
                    ),
                    Skill(
                        "Ultimate: Cuddles, Protect Me!",
                        "Melissa commands Cuddles to create a Field of Protection, knocking back nearby enemies and dealing Magic Damage. Enemy heroes cannot enter the field."
                    )
                )
            ),
            Hero(
                113,
                name = "Yin",
                description = "Fighter",
                photoUrl = "https://static.wikia.nocookie.net/mobile-legends/images/f/f6/Yin.png",
                skills = listOf(
                    Skill(
                        "Passive: Leave It to Me",
                        "Yin deals 120% damage when there are no allied heroes within 4 units around him."
                    ),
                    Skill(
                        "Skill 1: Charged Punch",
                        "Yin gains Movement Speed and enhances his next Basic Attack to deal massive Physical Damage in a rectangular area forward."
                    ),
                    Skill(
                        "Skill 2: Instant Blast",
                        "Yin dashes forward, leaving a Golden Ring behind. The ring will quickly catch up to Yin, dealing Physical Damage and stunning enemies in its path."
                    ),
                    Skill(
                        "Ultimate: My Turn",
                        "Yin pulls a designated enemy hero into his domain for 8s and turns into Lieh. In the domain, both cannot be affected by other heroes' skills. Lieh gains stronger skills and extra Defense."
                    )
                )
            ),
            Hero(
                112,
                name = "Edith",
                description = "Tank/Marksman",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_352f65059bc1180ae0fc066003d628e0.png",
                skills = listOf(
                    Skill(
                        "Passive: Overload",
                        "After each skill cast, Edith and Phylax become overloaded for 3s, during which Edith's Basic Attacks can trigger chain lightning that deals Magic Damage to up to 4 nearby enemies."
                    ),
                    Skill(
                        "Skill 1: Earth Shatter",
                        "Phylax deals Physical Damage to enemies in front and knocks them airborne. (Flight state: Edith casts Divine Retribution, dealing Magic Damage in a target area)."
                    ),
                    Skill(
                        "Skill 2: Onward",
                        "Phylax charges forward, dealing Physical Damage and tossing the first enemy hero hit over its shoulder. (Flight state: Edith fires a Lightning Bolt, dealing Magic Damage and immobilizing the first enemy hero hit)."
                    ),
                    Skill(
                        "Ultimate: Primal Wrath",
                        "Edith ejects herself from Phylax, gaining a shield and converting Phylax's accumulated Wrath into extra Attack Speed and Magic Lifesteal. Her Basic Attacks become ranged and deal Magic Damage."
                    )
                )
            ),
            Hero(
                111,
                name = "Floryn",
                description = "Support",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Floryn%20-%20Hero1121.png",
                skills = listOf(
                    Skill(
                        "Passive: Dew",
                        "Floryn carries Dew's Lantern, which can be shared with an allied hero to grant them extra attributes without taking up an equipment slot. The Lantern evolves as Floryn gathers energy."
                    ),
                    Skill(
                        "Skill 1: Sow",
                        "Floryn tosses an Energy Seed at a designated enemy, dealing Magic Damage. Healing fruits will then spawn and bounce to nearby allied heroes, restoring their HP."
                    ),
                    Skill(
                        "Skill 2: Sprout",
                        "Floryn casts a globule of energy in a designated direction, dealing Magic Damage to the first enemy hit. After a short delay, the energy explodes, dealing Magic Damage and stunning enemies in the area."
                    ),
                    Skill(
                        "Ultimate: Bloom",
                        "Floryn resonates with Dew's power, healing all allied heroes 5 times globally (ignores distance). The healing also damages nearby enemies each time it takes effect."
                    )
                )
            ),
            Hero(
                110,
                name = "Valentina",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Valentina%20-%20Hero1101.png",
                skills = listOf(
                    Skill(
                        "Passive: Primal Force",
                        "Valentina gains extra EXP each time she deals damage to an enemy hero. If the enemy hero's level is not higher than hers, a percentage of the damage dealt is converted into her HP."
                    ),
                    Skill(
                        "Skill 1: Shadow Strike",
                        "Valentina launches a Shadow Strike in a fan-shaped area, dealing Magic Damage and slowing enemies hit. Enemies hit by a Shadow Strike again within a short time are terrified."
                    ),
                    Skill(
                        "Skill 2: Arcane Shade",
                        "Valentina dashes in a target direction and fires 3 Shadow Bolts at the nearest enemies, dealing Magic Damage. She can cast this skill again within a short duration."
                    ),
                    Skill(
                        "Ultimate: I Am You",
                        "Valentina siphons the power of a designated enemy hero and slows them. For the next 12s, she can cast the siphoned enemy's Ultimate. Her Basic Attack type changes to match the enemy's."
                    )
                )
            ),
            Hero(
                109,
                name = "Aamon",
                description = "Assassin",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Aamon%20-%20Hero1091.png",
                skills = listOf(
                    Skill(
                        "Passive: Invisible Armor",
                        "Aamon enters the Camouflage state each time he hits an enemy with a skill, during which he cannot be targeted, restores HP, and gains Movement Speed. Exiting Camouflage enhances his Basic Attacks."
                    ),
                    Skill(
                        "Skill 1: Soul Shards",
                        "Aamon flings a shard at a nearby enemy, dealing Magic Damage. If it hits, Aamon's armor generates more shards that scatter around the target."
                    ),
                    Skill(
                        "Skill 2: Slayer Shards",
                        "Aamon throws shards forward, dealing Magic Damage and slowing the first non-minion enemy hit. The shards will then return to Aamon."
                    ),
                    Skill(
                        "Ultimate: Endless Shards",
                        "Aamon throws all shards to a designated enemy, slowing them. After a short delay, all shards on the ground will fly to the target, dealing massive Magic Damage based on the target's lost HP."
                    )
                )
            ),
            Hero(
                108,
                name = "Aulus",
                description = "Fighter",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_2_1_60_2/100_4a632ceb1dfcb3aad58a6d02a46a1c9e.png",
                skills = listOf(
                    Skill(
                        "Passive: Fighting Spirit",
                        "Aulus's Basic Attacks add a stack of Fighting Spirit to his axe. Each stack increases his Physical Attack and Physical Penetration. At max stacks, Aulus gains extra Movement Speed and Basic Attack damage."
                    ),
                    Skill(
                        "Skill 1: Aulus, Charge!",
                        "Aulus removes all slow effects and gains Movement Speed while holding the skill. Upon releasing it, he smashes the ground, dealing Physical Damage and slowing nearby enemies."
                    ),
                    Skill(
                        "Skill 2: The Power of Axe",
                        "Aulus unleashes his axe in a fan-shaped area, dealing Physical Damage. Each non-minion enemy hit enhances his next Basic Attacks to attack faster and restore his HP."
                    ),
                    Skill(
                        "Ultimate: Undying Fury",
                        "Passive: Aulus's Ultimate can be upgraded to enhance his axe (increases Basic Attack damage, Lifesteal, and Attack Range). Active: Aulus smashes the ground in a line, dealing Physical Damage and leaving a burning trail that damages and slows enemies."
                    )
                )
            ),
            Hero(
                107,
                name = "Natan",
                description = "Marksman",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Natan%20-%20Hero1071.png",
                skills = listOf(
                    Skill(
                        "Passive: Theory of Everything",
                        "Natan's Basic Attacks and skills deal Magic Damage. Each time his skill hits an enemy, he gains a stack of Entanglement, increasing his Attack Speed and Movement Speed."
                    ),
                    Skill(
                        "Skill 1: Superposition",
                        "Natan shoots a dense mass of energy in the target direction, dealing immense Magic Damage to enemies in its path."
                    ),
                    Skill(
                        "Skill 2: Interference!",
                        "Natan launches a gravitational attractor that drags enemies along its path, dealing Magic Damage. The attractor explodes at the end, knocking back nearby enemies."
                    ),
                    Skill(
                        "Ultimate: Entropy?",
                        "Natan summons a Reverse-Clone at the target location. The Clone copies all of Natan's attacks and movements in reverse. Natan can cast the skill again to dash toward the Clone."
                    )
                )
            ),
            Hero(
                106,
                name = "Phoveus",
                description = "Fighter",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_1_9_06/100_6bfe8ca7e60623a5261eac20e2b39d34.png",
                skills = listOf(
                    Skill(
                        "Passive: Demonic Intuition",
                        "Phoveus' weapon, Astaros, holds mysterious powers and is exceptionally sensitive to fast-moving prey. When an enemy hero uses Blink or Dash skills near Phoveus, it reduces the cooldowns of all his skills."
                    ),
                    Skill(
                        "Skill 1: Malefic Terror",
                        "Phoveus smashes the ground and unleashes Astaros Dread, dealing Magic Damage to the target and gaining a shield. This skill can hold multiple charges."
                    ),
                    Skill(
                        "Skill 2: Astaros Eye",
                        "Phoveus summons an Astaros Eye in a target area that deals Magic Damage. After a short delay, the Eye pulls all enemies in the area to its center."
                    ),
                    Skill(
                        "Ultimate: Demonic Force",
                        "Astaros keeps a watchful eye over an area. If an enemy hero uses Blink or Dash skills, Phoveus can instantly cast this skill to blink to their location and deliver a fierce blow, dealing Magic Damage."
                    )
                )
            ),
            Hero(
                105,
                name = "Beatrix",
                description = "Marksman",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Beatrix%20-%20Hero1051.png",
                skills = listOf(
                    Skill(
                        "Passive: Mechanical Genius",
                        "Beatrix can produce 4 weapons of remarkable firepower: Renner, Bennett, Wesker, and Nibiru. She can carry 2 weapons at once and switch between them."
                    ),
                    Skill(
                        "Skill 1: Masterful Gunner",
                        "Beatrix swaps her primary weapon with her secondary weapon she slung over her back, gaining an entirely new way to attack and use her Ultimate."
                    ),
                    Skill(
                        "Skill 2: Tactical Reposition",
                        "Beatrix dashes forward and fully reloads her current weapon, allowing her to shoot enemies continuously."
                    ),
                    Skill(
                        "Ultimate: Wesker/Renner/Bennett/Nibiru",
                        "Beatrix fires her current weapon's ultimate: Renner (long-range snipe), Bennett (bombardment area), Wesker (cone-shaped burst), or Nibiru (continuous volley)."
                    )
                )
            ),
            Hero(
                104,
                name = "Gloo",
                description = "Tank",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Gloo%20-%20Hero1041.png",
                skills = listOf(
                    Skill(
                        "Passive: Stick, Stick",
                        "Enemies gain a Sticky stack each time they are hit by Gloo's skills, decreasing their Movement Speed. Stacks up to 5 times. Gloo takes less damage from enemies with max Sticky stacks."
                    ),
                    Skill(
                        "Skill 1: Slam, Slam",
                        "Gloo reaches out and slams the ground, dealing Magic Damage to the enemy. Gloo also leaves a Goo behind that explodes after a short delay."
                    ),
                    Skill(
                        "Skill 2: Pass, Pass",
                        "Gloo stretches forth to deal Magic Damage to enemies in its path, immobilizing them. If this hits a Goo, Gloo dashes over to it, dragging enemies in its path."
                    ),
                    Skill(
                        "Ultimate: Split, Split",
                        "Gloo splits into multiple Goos, gaining Movement Speed and recovering HP. It can then attach itself to an enemy hero with max Sticky stacks, taking control of them and passing a portion of the damage received to them."
                    )
                )
            ),
            Hero(
                103,
                name = "Paquito",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Paquito%20-%20Hero1031.png",
                skills = listOf(
                    Skill(
                        "Passive: Champ Stance",
                        "Paquito builds stacks when hitting enemy heroes with his Basic Attacks or skills. At 3 stacks, he enters Champ Stance, enhancing his next skill and resetting its cooldown."
                    ),
                    Skill(
                        "Skill 1: Heavy Left Punch",
                        "Paquito throws a heavy blow, dealing Physical Damage and gaining a shield if an enemy hero is hit. (Enhanced: Deals more damage and grants a thicker shield)."
                    ),
                    Skill(
                        "Skill 2: Jab",
                        "Paquito dashes forward and throws a jab, dealing Physical Damage to all enemies in the area. (Enhanced: Deals even more damage in a larger area)."
                    ),
                    Skill(
                        "Ultimate: Knockout Strike",
                        "Paquito launches an elbow strike to all enemies in front, dealing Physical Damage and pushing them away. He then throws a haymaker that deals Physical Damage and slows targets. (Enhanced: Knocks enemies airborne instead of slowing)."
                    )
                )
            ),
            Hero(
                102,
                name = "Mathilda",
                description = "Support/Assassin",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Mathilda%20-%20Hero1021.png",
                skills = listOf(
                    Skill(
                        "Passive: Ancestral Guidance",
                        "Mathilda gains Ancestral Guidance while moving. When fully charged, her next Basic Attack is enhanced, dealing Magic Damage and increasing her Movement Speed."
                    ),
                    Skill(
                        "Skill 1: Soul Bloom",
                        "Mathilda summons wisps that surround her. As her movement distance increases, more wisps are attracted. Upon casting the skill again or after the duration, the wisps attack nearby enemies, dealing Magic Damage."
                    ),
                    Skill(
                        "Skill 2: Guiding Wind",
                        "Mathilda leaps to a target location and creates a field surrounding her. Allied heroes in the field gain a shield and can activate Guiding Wind to dash toward Mathilda."
                    ),
                    Skill(
                        "Ultimate: Circling Eagle",
                        "Mathilda applies a Soul Mark to the targeted hero and circles around them. During this time, wisps will rush to the target. She can cast the skill again to dash to the target, knocking back enemies in her path."
                    )
                )
            ),
            Hero(
                101,
                name = "Yve",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Yve%20-%20Hero1011.png",
                skills = listOf(
                    Skill(
                        "Passive: Galactic Power",
                        "Yve gains Galactic Power when dealing damage to enemy heroes with her skills. Each stack provides Movement Speed and increases the number of starfield blocks she can summon with her Ultimate."
                    ),
                    Skill(
                        "Skill 1: Void Blast",
                        "Yve detonates Galactic Energy in a designated area, dealing Magic Damage to the enemies hit. Targets in the central area will take extra damage."
                    ),
                    Skill(
                        "Skill 2: Void Crystal",
                        "Yve summons a Void Crystal in a designated area. Used again, the crystal radiates energy in the designated direction, continuously dealing Magic Damage to enemies and slowing them."
                    ),
                    Skill(
                        "Ultimate: Real World Manipulation",
                        "Yve creates a starfield that lasts for a duration, gaining a massive shield. She can tap or slide on the starfield to deal Magic Damage to enemies within the area."
                    )
                )
            ),
            Hero(
                100,
                name = "Brody",
                description = "Marksman",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Brody%20-%20Hero1001.png",
                skills = listOf(
                    Skill(
                        "Passive: Abyss Corrosion",
                        "Brody's Basic Attacks have a longer wind-up but deal massive Physical Damage and grant Movement Speed. Each Basic Attack inflicts an Abyss Mark on the target, increasing Brody's damage against them."
                    ),
                    Skill(
                        "Skill 1: Abyss Impact",
                        "Brody launches a shockwave in a designated direction, dealing Physical Damage, slowing enemies, and applying Abyss Marks. The damage and effects scale with each enemy hit."
                    ),
                    Skill(
                        "Skill 2: Corrosive Strike",
                        "Brody dashes to an enemy, dealing Physical Damage, stunning them, and applying Abyss Marks. He then gains Movement Speed and bounces off to move again."
                    ),
                    Skill(
                        "Ultimate: Torn-Apart Memory",
                        "Brody locks on to all targets within a large range, dealing Physical Damage. If a target has an Abyss Mark, the mark will detonate, dealing extra Physical Damage based on the target's lost HP and stacks."
                    )
                )
            ),
            Hero(
                99,
                name = "Barats",
                description = "Tank/Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Barats%20-%20Hero991.png",
                skills = listOf(
                    Skill(
                        "Passive: Big Guy",
                        "Each time Barats and Detona deal damage to a target with their skills, Detona gains a stack of Big Guy, increasing his physical size, Physical & Magic Defense, and Resilience. At 16 stacks, his Basic Attacks are enhanced."
                    ),
                    Skill(
                        "Skill 1: So-Called Teamwork",
                        "Detona spits contaminated oil in a fan-shaped area, dealing Physical Damage and slowing enemies. Barats then drops a firecracker, igniting the oil and dealing Physical Damage to enemies in the area."
                    ),
                    Skill(
                        "Skill 2: Missile \"Expert\"",
                        "Barats launches a missile to the designated area. Upon landing, a blast of flame shoots out from the rear, pushing enemies toward Barats and dealing Physical Damage."
                    ),
                    Skill(
                        "Ultimate: Detona's Welcome",
                        "Detona locks onto an enemy hero and devours them, suppressing them for a short duration. Detona then spits the target out, dealing Physical Damage and knocking them airborne."
                    )
                )
            ),
            Hero(
                98,
                name = "Khaleed",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Khaleed%20-%20Hero981.png",
                skills = listOf(
                    Skill(
                        "Passive: Sand Walk",
                        "Khaleed accumulates Desert Power while moving. When fully charged, he glides on sand, gaining Movement Speed and enhancing his next Basic Attack to deal massive area damage and slow enemies."
                    ),
                    Skill(
                        "Skill 1: Desert Tornado",
                        "Khaleed whirls his scimitar, dealing Physical Damage to nearby enemies. Upon hitting an enemy, he can leap in a designated direction and cast this skill again (up to 3 times)."
                    ),
                    Skill(
                        "Skill 2: Quicksand Guard",
                        "Khaleed channels the power of quicksand, recovering HP and gaining Damage Reduction. Quicksand appears under his feet, slowing nearby enemies."
                    ),
                    Skill(
                        "Ultimate: Raging Sandstorm",
                        "Khaleed summons a sandstorm and rushes toward a designated area, gaining crowd control immunity, pushing enemies in his path, and dealing Physical Damage. Upon reaching the destination, he smashes the ground, stunning enemies."
                    )
                )
            ),
            Hero(
                97,
                name = "Benedetta",
                description = "Assassin",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Benedetta%20-%20Hero971.png",
                skills = listOf(
                    Skill(
                        "Passive: Elapsed Daytime",
                        "When holding the Basic Attack button, Benedetta gathers Sword Intent. When fully charged, she unleashes a forward dash attack that deals Physical Damage. Only this dash can trigger her passive damage."
                    ),
                    Skill(
                        "Skill 1: Phantom Slash",
                        "Benedetta backs away quickly, leaving a shadow ahead that slashes forward, dealing Physical Damage. She then dashes forward to slash, dealing Physical Damage."
                    ),
                    Skill(
                        "Skill 2: An Eye for An Eye",
                        "Benedetta raises her weapon to defend, gaining Control Immunity and blocking damage from any source for a brief moment. She then stabs forward, dealing Physical Damage. If she successfully blocks a crowd control effect, the stab will stun the target."
                    ),
                    Skill(
                        "Ultimate: Alecto: Final Blow",
                        "Benedetta clinches Alecto and dashes forward, becoming invincible during the dash and slowing targets. After the dash, she detonates the Sword Intent in the path, continuously dealing Physical Damage to enemies."
                    )
                )
            ),
            Hero(
                96,
                name = "Luo Yi",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Luo%20yi%20-%20Hero961.png",
                skills = listOf(
                    Skill(
                        "Passive: Duality",
                        "Luo Yi's skills create marks of Yin and Yang on the battlefield and on enemy heroes. When two bearers of opposite marks come close, a Yin-Yang Reaction occurs, pulling them together, dealing Magic Damage, and stunning them."
                    ),
                    Skill(
                        "Skill 1: Dispersion",
                        "Luo Yi casts the energy of Yin/Yang in a designated direction, dealing Magic Damage and applying a mark to the first enemy hit. The energy then disperses, dealing damage to enemies behind."
                    ),
                    Skill(
                        "Skill 2: Rotation",
                        "Luo Yi summons an Aqua of Yin/Yang in a designated area, dealing Magic Damage and slowing enemies. The Aqua applies the corresponding mark to enemies within the area."
                    ),
                    Skill(
                        "Ultimate: Diversion",
                        "Luo Yi creates a teleport circle around herself. After a short delay, any allied heroes within the circle will be teleported to a designated location on the battlefield."
                    )
                )
            ),
            Hero(
                95,
                name = "Yu Zhong",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Yu%20Zhong%20-%20Hero951.png",
                skills = listOf(
                    Skill(
                        "Passive: Cursing Touch",
                        "Yu Zhong applies Sha Residue to enemies upon dealing damage. Sha Residue erupts upon reaching 5 stacks, dealing Physical Damage based on target's lost HP, restoring Yu Zhong's HP, and granting him Movement Speed."
                    ),
                    Skill(
                        "Skill 1: Dragon Tail",
                        "Yu Zhong infuses his power into his cloak and turns it into a weapon, dealing Physical Damage to nearby enemies. Enemies hit by the sharpened edge take more damage and grant him more Sha Residue."
                    ),
                    Skill(
                        "Skill 2: Soul Grip",
                        "Yu Zhong unleashes the Dragon Soul, dealing Physical Damage to all enemies in front and slowing them. Upon hitting an enemy, his next Basic Attack is enhanced, dealing extra damage and applying multiple stacks of Sha Residue."
                    ),
                    Skill(
                        "Skill 3: Furious Dive",
                        "Yu Zhong leaps towards a designated area with his full strength, dealing Physical Damage. He can dash again in the target direction, knocking enemies airborne in the area of effect."
                    ),
                    Skill(
                        "Ultimate: Black Dragon Form",
                        "Yu Zhong transforms into the Black Dragon, gaining max HP and ignoring obstacles. In this form, he knocks back enemies in his path. After transforming back to his half-dragon form, the range of all his skills is increased."
                    )
                )
            ),
            Hero(
                94,
                name = "Popol and Kupa",
                description = "Marksman",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Popol%20and%20Kupa%20-%20Hero941.png",
                skills = listOf(
                    Skill(
                        "Passive: We Are Friends",
                        "Popol always fights side by side with his best partner, Kupa. Popol's consecutive attacks enhance Kupa's damage. If Kupa is slain, Popol can pray for a short duration to summon him back to the battlefield."
                    ),
                    Skill(
                        "Skill 1: Bite 'em, Kupa!",
                        "Popol throws his spear at a target, dealing Physical Damage. Kupa then bites the target, dealing Physical Damage. (Alpha Wolf Form: Kupa strikes multiple times and stuns the target)."
                    ),
                    Skill(
                        "Skill 2: Kupa, Help!",
                        "Popol recalls Kupa to protect him, gaining a shield. Kupa deals Physical Damage to nearby enemies and slows them. (Alpha Wolf Form: Kupa knocks nearby enemies airborne)."
                    ),
                    Skill(
                        "Skill 3: Popol's Surprise",
                        "Popol sets a trap at the target location that detonates when an enemy steps on it, dealing Magic Damage, immobilizing them, and creating a frost zone that slows enemies."
                    ),
                    Skill(
                        "Ultimate: We Are Angry!",
                        "Popol and Kupa both become enraged for a duration. Popol gains Attack Speed and Movement Speed. Kupa transforms into the Alpha Wolf, gaining max HP, Physical Attack, and enhancing their other skills."
                    )
                )
            ),
            Hero(
                93,
                name = "Atlas",
                description = "Tank",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Atlas%20-%20Hero931.png",
                skills = listOf(
                    Skill(
                        "Passive: Frigid Breath",
                        "Atlas generates Frigid Breath around him each time he casts a skill. Enemies who stay in the area will have their Movement Speed and Attack Speed gradually reduced. They will be frozen if they stay too long."
                    ),
                    Skill(
                        "Skill 1: Annihilate",
                        "Atlas smashes the ground and causes 3 explosions, dealing Magic Damage to enemies. When ejected from his Mecha Sentry, both he and the mecha cast this skill."
                    ),
                    Skill(
                        "Skill 2: Perfect Match",
                        "Atlas ejects from his Mecha Sentry, gaining Movement Speed and damage reduction while the mecha follows him. When they reunite, the mecha deals Magic Damage to nearby enemies and stuns them."
                    ),
                    Skill(
                        "Ultimate: Fatal Links",
                        "Atlas hurls chains at all nearby enemy heroes, channeling to pull them towards him. He then smashes them in a target direction, dealing massive Magic Damage."
                    )
                )
            ),
            Hero(
                92,
                name = "Carmilla",
                description = "Support",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Carmilla%20-%20Hero921.png",
                skills = listOf(
                    Skill(
                        "Passive: Vampire Pact",
                        "Carmilla steals Physical and Magic Defense from enemy heroes while dealing damage to them. The stolen defense can be stacked up to 5 times and lasts for a few seconds."
                    ),
                    Skill(
                        "Skill 1: Crimson Flower",
                        "Carmilla summons Crimson Flowers spinning around her, dealing Magic Damage to nearby enemies and slowing them. Each time the flowers hit an enemy, Carmilla restores her HP."
                    ),
                    Skill(
                        "Skill 2: Bloodbath",
                        "Carmilla accumulates Bloodbath Energy, greatly increasing her Movement Speed. She can cast this skill again to unleash the energy to a designated enemy, dealing Magic Damage and stunning them."
                    ),
                    Skill(
                        "Ultimate: Curse of Blood",
                        "Carmilla casts the Curse of Blood at a designated enemy hero. The Curse spreads to other nearby enemy heroes, dealing Magic Damage and slowing them. Linked enemies will share damage and crowd control effects."
                    )
                )
            ),
            Hero(
                91,
                name = "Cecilion",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Cecilion%20-%20Hero911.png",
                skills = listOf(
                    Skill(
                        "Passive: Overflowing",
                        "OverflowingBuffCecilion increases his Max Mana by 10 and restores the same amount of Mana his skill hits an enemy target. Cooldown: 1 second.Cecilion has higher Max Mana and Mana Regen, and his skill damage scales with his Max Mana."
                    ),
                    Skill(
                        "Skill 1: Bat Impact",
                        "Cecilion orders a giant bat to dive in a designated direction, dealing Magic Damage to enemies on the path. The giant bat will stay at its destination and launch another attack, dealing Magic Damage to enemies and triggering Overflow. Casting this skill again within 6s increases its mana cost."
                    ),
                    Skill(
                        "Skill 2: Sanguine Claws",
                        "Cecilion summons a pair of claws in a designated position that will run towards each other, dealing Magic Damage to enemies on the path, pulling them to the center, and immobilizing them for 1s."
                    ),
                    Skill(
                        "Ultimate: Bats Feast",
                        "Cecilion awakens his Blood Demon power, increasing his Movement Speed by 60% and gaining Slow Immunity. Meanwhile, he shoots 40 bolts of blood energy at the enemies around him, each dealing Magic Damage and slowing them by 3% for 1s. Recovering HP each time a bolt hits an enemy."
                    )
                )
            ),
            Hero(
                90,
                name = "Silvanna",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Silvanna%20-%20Hero901.png",
                skills = listOf(
                    Skill(
                        "Passive: Knightess' Resolve",
                        "Silvanna's basic attacks deal Magic Damage. Her skills apply a mark to enemy heroes hit, reducing their Magic Defense by 3-6. Max 5 stacks. When the amount of marks reaches the maximum, Silvanna's skill deals 30% extra damage to the target."
                    ),
                    Skill(
                        "Skill 1: Cometic Lance",
                        "Silvanna strikes with her lance, dealing Magic Damage to enemies in the path and stunning the first enemy hero hit for 1s. Successful hits allow her to dash in a designated direction and strike again."
                    ),
                    Skill(
                        "Skill 2: Spiral Strangling",
                        "Silvanna stabs her lance in a designated direction and spins it for 6 times, dealing Magic Damage and pulling enemies to the center while generating a shield for herself."
                    ),
                    Skill(
                        "Ultimate: Imperial Justice",
                        "Silvanna leaps into an area, dealing Magic Damage to enemies and slowing them by 40%. Meanwhile, she creates a Circle of Light, restricting the enemy closest to the center from escaping for 3.5s. She gains 100% extra Attack Speed and 80% Magic Lifesteal inside the Circle."
                    )
                )
            ),
            Hero(
                89,
                name = "Wanwan",
                description = "Marksman",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Wanwan%20-%20Hero891.png",
                skills = listOf(
                    Skill(
                        "Passive: Tiger Pace",
                        "Wanwan reveals the Weaknesses and positions of enemy heroes hit by her weapons. She deals extra True Damage when hitting their Weaknesses. If she hits all Weaknesses of a target, she will increase her damage dealt to them by 40%. Wanwan can move a short distance when throwing a Swallow Dart."
                    ),
                    Skill(
                        "Skill 1: Swallow's Path",
                        "Wanwan fires a Fire Swallow in a designated direction, dealing Physical Damage to enemies along the path and triggering Tiger Pace. The Fire Swallow will turn into a zone of Swallow Daggers and strike back, dealing Physical Damage and stunning enemies caught in its path."
                    ),
                    Skill(
                        "Skill 2: Needles in Flowers",
                        "Wanwan removes all crowd control effects from herself immediately, triggers Tiger Pace, and unleashes deadly needles to nearby enemies, dealing Physical Damage."
                    ),
                    Skill(
                        "Ultimate: Crossbow of Tang",
                        "Wanwan activates her crossbow and shoots arrows at enemies whose Weaknesses are all hit. The arrows deal Physical Damage and will trigger Tiger Pace. Wanwan becomes invincible during this process and will switch to another target if the current one dies."
                    )
                )
            ),
            Hero(
                88,
                name = "Masha",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Masha%20-%20Hero881.png",
                skills = listOf(
                    Skill(
                        "Passive: Ancient Strength",
                        "Masha has 3 HP bars. Each time she loses an HP bar, she can block damage once. When she loses her first HP bar, she gains 25% Physical Lifesteal. When she loses her second HP bar, her Physical Lifesteal increases by 15%, and she reduces crowd control time by 60%."
                    ),
                    Skill(
                        "Skill 1: Wild Power",
                        "Masha awakens her Wild Power, dealing Physical Damage equal to a percentage of the target's Max HP with her Basic Attacks, while continuously losing her own HP. She gains extra Movement Speed and Attack Speed."
                    ),
                    Skill(
                        "Skill 2: Howl Shock",
                        "Masha roars forward and unleashes an energy shock, dealing Physical Damage to enemies and slowing them by 40%. Hitting an enemy hero disarms them for 2s."
                    ),
                    Skill(
                        "Ultimate: Thunder Strike",
                        "Masha launches a powerful charge at a designated target after consuming a percentage of her current HP, dealing massive Physical Damage based on her Max HP and slowing them by 90%."
                    )
                )
            ),
            Hero(
                87,
                name = "Baxia",
                description = "Tank",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Baxia%20-%20Hero871.png",
                skills = listOf(
                    Skill(
                        "Passive: Baxia Mark",
                        "Baxia activates the Baxia Mark permanently, reducing the final damage received by 15 (+1 Hero Level). At the same time Baxia's will reduce the enemy hero's Shield and HP Regen by 50% for 4 seconds when hit by his skills."
                    ),
                    Skill(
                        "Skill 1: Baxia-Shield Unity",
                        "Baxia retracts himself into his shield and accelerates forward. When hitting an enemy unit, he will deal Magic Damage to it and nearby enemies, stunning the target and knocking other nearby enemies back. He can cross obstacles while in this state."
                    ),
                    Skill(
                        "Skill 2: Shield of Spirit",
                        "Baxia throws his shield forward that will disappear upon hitting an enemy hero or creeps, dealing Magic Damage to the target and minions on the path. Meanwhile, marks them and slows them down. The shield disappears upon hitting an enemy hero or Creep, but the cooldown is greatly reduced."
                    ),
                    Skill(
                        "Ultimate: Tortoise's Puissance",
                        "Baxia deploys a frontal shield and dashes forward like a madman, increasing his Movement Speed while leaving a lava path along the way. Enemies in the path will take Magic Damage and be slowed. His Damage Reduction from Baxia Mark is boosted by 140%."
                    )
                )
            ),
            Hero(
                86,
                name = "Lylia",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Lylia%20-%20Hero861.png",
                skills = listOf(
                    Skill(
                        "Passive: Angry Gloom",
                        "Lylia gets power from Gloom, increasing her movement speed by 15% whenever she is within the area of Gloom. Additionally, every time Gloom is upgraded, her movement speed is increased by 5%, stacking up to 4 times."
                    ),
                    Skill(
                        "Skill 1: Magic Shockwave",
                        "Lylia sends out Gloom in a line, dealing Magic Damage to enemies along the path and slowing them by 40% for 1.5 seconds. If Gloom touches Shadow Energy, he will devour and detonate it."
                    ),
                    Skill(
                        "Skill 2: Shadow Energy",
                        "Lylia condenses Shadow Energy at a location, dealing Magic Damage to enemies hit and slowing them. If Shadow Energy is detonated by Gloom, it deals additional Magic Damage and turns into Gloom for 8 seconds, allowing further chain detonations."
                    ),
                    Skill(
                        "Ultimate: Black Shoes",
                        "Lylia returns to the Black Shoes' location 4 seconds ago, restoring all 5 Shadow Energy charges, 100% of her HP and Mana to the previous state, and getting an extra Max HP. She also gains extra Movement Speed for a few seconds."
                    )
                )
            ),
            Hero(
                85,
                name = "Dyroth",
                description = "Fighter",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_2_1_18/100_bf8dcb20923cee2407563e0fe88aa557.png",
                skills = listOf(
                    Skill(
                        "Passive: Wrath of the Abyss",
                        "When Dyrroth's Rage reaches 50%, he will enhance Burst Strike and Spectre Step. After every 2 Basic Attacks, Dyrroth will release Circle Strike, dealing Physical Damage to enemies in the circle and regenerating HP according to the damage he deals."
                    ),
                    Skill(
                        "Skill 1: Burst Strike",
                        "Dyrroth releases a burst strike in a designated direction. Each burst deals Physical Damage to enemies and slows them. Abyss Enhanced: Burst Strike has a longer range, deals 140% of the original damage, and its slow effect is doubled."
                    ),
                    Skill(
                        "Skill 2: Spectre Step",
                        "Dyrroth dashes in the designated direction. He will stop when he hits a target, dealing Physical Damage. When he uses this skill again, he will lock onto a target and release a Fatal Strike, dealing Physical Damage and reducing Physical Defense. Abyss Enhanced: Fatal Strike reduces Defense by 75%."
                    ),
                    Skill(
                        "Ultimate: Abysm Strike",
                        "After a short delay, Dyrroth launches a destructive strike in the target direction (cannot be interrupted), dealing Physical Damage equal to a base amount plus 20% of enemies' lost HP to enemies along the way and slowing them."
                    )
                )
            ),
            Hero(
                84,
                name = "Ling",
                description = "Assassin",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Ling%20-%20Hero841.png",
                skills = listOf(
                    Skill(
                        "Passive: Cloud Walker",
                        "Ling's superb Lightness Skill helps him leap among walls. When resting on the wall, He gains 4 Lightness Points per second and 5 extra Lightness Points each time he deals damage. Ling gains 1.6 times Crit Chance from all sources but only has 150% Critical Damage."
                    ),
                    Skill(
                        "Skill 1: Finch Poise",
                        "Ling casts his Lightness Skill, leaping onto the designated wall, entering half-stealth state, restoring Lightness Points more quickly and gaining 30% Movement Speed. If Ling receives damage, he will leave the half-stealth state."
                    ),
                    Skill(
                        "Skill 2: Defiant Sword",
                        "Ling charges in a designated direction and stabs the nearby enemies at his destination, dealing Physical Damage. If Ling casts this skill when he is on the wall, he'll dash to the target location on the ground, dealing AOE Physical Damage and slowing enemies."
                    ),
                    Skill(
                        "Ultimate: Tempest of Blades",
                        "Ling leaps into the air, becoming invincible and gaining extra Movement Speed. He then lands on the ground, dealing Physical Damage to enemies in the area, knocking those in the center airborne, and creating a Sword Field. He can touch the 4 Tempest of Blades to reset Defiant Sword's cooldown."
                    )
                )
            ),
            Hero(
                83,
                name = "X.Borg",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Xborg%20-%20Hero831.png",
                skills = listOf(
                    Skill(
                        "Passive: Firaga Armor",
                        "X.Borg's Firaga Armor inherits his Max HP and absorbs all incoming damage when it's active. When the Armor is destroyed, X.Borg will disengage from it and roll away, becoming immune to damage temporarily. The Armor's energy gradually regenerates in Armorless State."
                    ),
                    Skill(
                        "Skill 1: Fire Missiles",
                        "X.Borg sprays fire, dealing Physical Damage continuously to enemies in range. Enemies whose temperature reaches the limit will take True Damage. Armorless state: The attack area becomes narrower but longer, while the damage is reduced."
                    ),
                    Skill(
                        "Skill 2: Fire Stake",
                        "X.Borg shoots 5 Fire Stakes at the edge of the fan-shaped indicator and retrieves them after a short delay, dealing Physical Damage and pulling the enemies in the path toward him. Firaga Supplies in the path will also be retrieved."
                    ),
                    Skill(
                        "Ultimate: Last Insanity",
                        "X.Borg charges forward while rotating and spraying fire, dealing Physical Damage and slowing enemies. After 3 seconds, X.Borg's Firaga Armor will detonate, dealing True Damage based on the enemy's Max HP and destroying his armor."
                    )
                )
            ),
            Hero(
                82,
                name = "Terizla",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Terizla%20-%20Hero821.png",
                skills = listOf(
                    Skill(
                        "Passive: Body of Smith",
                        "Terizla gains 1% Damage Reduction for every 2.5% HP lost (up to 20% + Hero Level). He cannot gain Attack Speed and will convert every 1% attack speed he's supposed to receive into 1 Physical Attack."
                    ),
                    Skill(
                        "Skill 1: Revenge Strike",
                        "Terizla cracks the ground with his hammer and the fissure will spread out, dealing Physical Damage. After the fissure hits the first target, it drills into the target, slowing them and increasing Terizla's Movement Speed, then explodes for damage based on Lost HP."
                    ),
                    Skill(
                        "Skill 2: Execution Strike",
                        "Terizla waves his hammer in a fan-shaped area ahead up to 3 times. The first two attacks deal Physical Damage, while the third deals massive Physical Damage. Enemies hit will also be slowed."
                    ),
                    Skill(
                        "Ultimate: Penalty Zone",
                        "Terizla jumps to the designated area to smash down, causing Physical Damage and slowing enemies. He summons a Scaffold, which will reach out a hook to enemy heroes and pull them for 3 times, causing Physical Damage each time."
                    )
                )
            ),
            Hero(
                81,
                name = "Esmeralda",
                description = "Mage/Tank",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Esmeralda%20-%20Hero811.png",
                skills = listOf(
                    Skill(
                        "Passive: Starmoon Casket",
                        "Esmeralda manipulates Stardust and Frostmoon. Each of her Basic Attacks deals Physical Damage and Magic Damage, and grants the target a shield. The damage she deals ignores all shield effects and gradually transforms her shield into her HP."
                    ),
                    Skill(
                        "Skill 1: Frostmoon Shield",
                        "Esmeralda generates a shield for herself and increases her Movement Speed. Meanwhile, she gradually transforms the shields of nearby enemies into her own shield."
                    ),
                    Skill(
                        "Skill 2: Stardust Dance",
                        "Esmeralda waves Stardust and Frostmoon, dealing Physical Damage and Magic Damage to nearby enemies. Each time she deals damage to a hero, the cooldown of Frostmoon Shield is reduced by 1.5 seconds."
                    ),
                    Skill(
                        "Ultimate: Falling Starmoon",
                        "Esmeralda coalesces the power of Astrospace into Stardust and Frostmoon. She throws the Stardust to the designated location, dealing Physical Damage, and then blinks to the location to cast Frostmoon, dealing Magic Damage and immobilizing enemies in the area."
                    )
                )
            ),
            Hero(
                80,
                name = "Guinevere",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Guinevere%20-%20Hero801.png",
                skills = listOf(
                    Skill(
                        "Passive: Super Magic",
                        "Guinevere deals 25% extra damage to airborne enemies. Her Basic Attacks deal extra Magic Damage and accumulate Super Magic. When fully charged, her next Basic Attack is enhanced, dealing Magic Damage and restoring her HP while applying a mark."
                    ),
                    Skill(
                        "Skill 1: Energy Wave",
                        "Guinevere releases an energy orb in the designated direction, dealing Magic Damage to enemies hit and slowing them. Successfully hitting an enemy reduces all her skill cooldowns by 1 second."
                    ),
                    Skill(
                        "Skill 2: Spatial Migration",
                        "Guinevere thumps the ground and blinks to the target location, knocking nearby enemies airborne and dealing Magic Damage. She can reactivate the skill to blink in a designated direction and leave a lingering illusion behind."
                    ),
                    Skill(
                        "Ultimate: Violet Requiem",
                        "Guinevere creates a force field around her, dealing Magic Damage to nearby enemies over 2 seconds. If the enemies hit are already airborne or have maximum marks, they will be knocked airborne again. Guinevere is immune to crowd control while casting."
                    )
                )
            ),
            Hero(
                79,
                name = "Granger",
                description = "Marksman",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_1_9_22/100_9ed57f48f91012fd110935258cd1ab61.png",
                skills = listOf(
                    Skill(
                        "Passive: Caprice",
                        "Granger can load up to 6 bullets at a time. Each 6th bullet deals Critical Damage. Granger's Basic Attack deals more damage, but he gains 50% less Attack Speed from equipment or emblems."
                    ),
                    Skill(
                        "Skill 1: Rhapsody",
                        "Granger fully loads his gun and fires all his bullets in a forward direction, each dealing Physical Damage to enemies hit. Deals extra damage to creeps."
                    ),
                    Skill(
                        "Skill 2: Rondo",
                        "Granger dashes in the designated direction, and his next 2 Basic Attacks deal extra damage in 5 seconds. Each time Rhapsody hits an enemy, the cooldown of Rondo is reduced by 0.5 seconds."
                    ),
                    Skill(
                        "Ultimate: Death Sonata",
                        "Granger transforms his violin into a super cannon and fills it with 3 Super Bullets. He can move and shoot the Super Bullets, dealing Physical Damage to enemies hit and slowing them. The last Super Bullet deals Critical Damage."
                    )
                )
            ),
            Hero(
                78,
                name = "Khufra",
                description = "Tank",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Khufra%20-%20Hero781.png",
                skills = listOf(
                    Skill(
                        "Passive: Spell Curse",
                        "Khufra activates the Spell Curse left by Esmeralda every 12 seconds to increase the range of his next Basic Attack, dealing Magic Damage based on his Max HP and slowing the target. It also restores his HP."
                    ),
                    Skill(
                        "Skill 1: Tyrant's Revenge",
                        "Khufra pulls the bandage on his arms to launch himself in the specified direction, dealing Physical Damage to all enemy units on the path. When reaching the furthest distance or hitting a first enemy hero, Khufra will stop and knock the enemy airborne."
                    ),
                    Skill(
                        "Skill 2: Bouncing Ball",
                        "Khufra wraps himself with bandages into a magic bouncing ball, increasing his Physical and Magic Defense. Enemies trying to use blink skills to move across Khufra will be knocked airborne. The bouncing deals Magic Damage and slows enemies."
                    ),
                    Skill(
                        "Ultimate: Tyrant's Rage",
                        "Khufra pulls back all enemy targets around him toward his front, dealing Physical Damage and slowing them. If the enemies are knocked against walls, extra Physical Damage will be dealt, and they will be stunned instead of slowed."
                    )
                )
            ),
            Hero(
                77,
                name = "Badang",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Badang%20-%20Hero771.png",
                skills = listOf(
                    Skill(
                        "Passive: Chivalry Fist",
                        "After every 4 Basic Attacks, Badang's next Basic Attack deals extra Physical Damage and knocks enemies back. Enemies knocked into obstacles are stunned. Badang's Fist Wind also triggers this effect."
                    ),
                    Skill(
                        "Skill 1: Qigong Fist",
                        "Badang unleashes a gust of Qigong Fist, dealing Physical Damage to enemies in its path and slowing them. The Qigong Fist will explode upon hitting an obstacle, dealing Physical Damage."
                    ),
                    Skill(
                        "Skill 2: Fist Break",
                        "Badang dashes in the designated direction. If he hits an enemy hero, he knocks them back, dealing Physical Damage, and creates an obstacle behind them that lasts for 4 seconds."
                    ),
                    Skill(
                        "Ultimate: Fist Crack",
                        "Badang rapidly throws a flurry of punches in the designated direction, dealing Physical Damage to enemies multiple times. The punches generate Fist Wind that explodes upon hitting obstacles. Badang is immune to crowd control while casting."
                    )
                )
            ),
            Hero(
                76,
                name = "Faramis",
                description = "Support/Mage",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_4bed236fc260d9924b030e576793a26b.png",
                skills = listOf(
                    Skill(
                        "Passive: Vicious Retrieval",
                        "When units die near Faramis, they leave a soul fragment. Faramis can retrieve them to restore his HP and gain extra Magic Power. Upon death, he consumes the collected fragments to reduce his respawn timer."
                    ),
                    Skill(
                        "Skill 1: Shadow Stampede",
                        "Faramis enters the Shadow state, gaining Movement Speed, Physical & Magic Defense, and the ability to move through terrain. Enemies he moves through are marked and take Magic Damage. When he exits the state, marked enemies are pulled to him."
                    ),
                    Skill(
                        "Skill 2: Ghost Bursters",
                        "Faramis gathers Nether Energy, dealing Magic Damage to enemies in a fan-shaped area. The energy then splits and bounces to nearby enemies, dealing additional Magic Damage."
                    ),
                    Skill(
                        "Ultimate: Cult Altar",
                        "Faramis turns his surroundings into the Nether Realm, granting allied heroes a buff that grants extra HP and Movement Speed. If an allied hero's HP drops to zero during the ultimate, the buff is consumed instead to revive them with a portion of their HP and wipe their debuffs."
                    )
                )
            ),
            Hero(
                75,
                name = "Kadita",
                description = "Mage/Assassin",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Kadita%20-%20Hero751.png",
                skills = listOf(
                    Skill(
                        "Passive: Thalassophobia",
                        "Every 30 seconds, Kadita gains the Blessing of the Ocean. She recovers 65% of the HP she lost during the skill duration after 4 seconds of taking damage from enemy heroes."
                    ),
                    Skill(
                        "Skill 1: Ocean Oddity",
                        "Kadita becomes a mermaid and rides an ocean wave, dealing Magic Damage to enemies and slowing them. She gains Damage Reduction and Control Immunity while riding the wave. She can reactivate the skill to leave the wave early."
                    ),
                    Skill(
                        "Skill 2: Breath of the Ocean",
                        "Kadita summons an ocean puddle at the designated location. After a short delay, the puddle erupts, dealing Magic Damage and knocking enemies airborne. If cast during Ocean Oddity, it erupts instantly."
                    ),
                    Skill(
                        "Ultimate: Rough Waves",
                        "Kadita dives into the earth, sending a tsunami of waves in all directions, each dealing Magic Damage. She then surfaces and recalls the waves to her, dealing additional Magic Damage to enemies hit. Kadita is untargetable while submerged."
                    )
                )
            ),
            Hero(
                74,
                name = "Minsitthar",
                description = "Fighter",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_dbfdfa2d0a3cc95cbc197d0a14d5ecd1.png",
                skills = listOf(
                    Skill("Passive: Mark of the King", "Minsitthar's Basic Attacks and skills apply a mark to enemy heroes. After applying 5 marks, he detonates them, dealing True Damage and restoring a percentage of his Max HP."),
                    Skill("Skill 1: Spear of Glory", "Minsitthar thrusts his spear forward, dealing Physical Damage to enemies. Upon pulling it back, he drags the first enemy hero hit towards him and deals Physical Damage."),
                    Skill("Skill 2: Shield Assault", "Minsitthar awakens his shield, gaining Damage Reduction and enhancing his Basic Attacks. His enhanced Basic Attacks strike multiple enemies in a rectangular area, dealing Physical Damage and slowing them."),
                    Skill("Ultimate: King's Calling", "Minsitthar leaps forward and calls upon 4 Royal Guards to form a field. Enemies within the field are slowed and cannot use directional Blink skills. The Royal Guards will attack enemies in the field, dealing Physical Damage.")
                )
            ),
            Hero(
                73,
                name = "Harith",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Harith%20-%20Hero731.png",
                skills = listOf(
                    Skill("Passive: Key Insight", "Harith gains Insight from his Key. He reduces the duration of crowd control effects applied to him up to 45%, based on the number of nearby enemy heroes."),
                    Skill("Skill 1: Synchro Fission", "Harith creates a phantom of himself in the opposite direction and casts Synchro Fission, dealing Magic Damage to all enemies on the path. The center area deals massive Magic Damage."),
                    Skill("Skill 2: Chrono Dash", "Harith dashes to a designated location. Upon arriving, he steals Magic Attack from nearby enemy heroes, generates a shield, and enhances his next Basic Attack to deal Magic Damage and slow the target."),
                    Skill("Ultimate: Zaman Force", "Harith uses his Key to summon the Zaman Force. When the multidimensional rift appears, it reduces the cooldown of Chrono Dash by 4 seconds. The rift continuously slows nearby enemies and reduces Harith's skill cooldowns.")
                )
            ),
            Hero(
                72,
                name = "Thamuz",
                description = "Fighter",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_2_1_18/100_3e7e133556af2f5d82f49fa8624b6bd5.png",
                skills = listOf(
                    Skill("Passive: Grand Lord Lava", "When holding his scythes, Thamuz's Basic Attack has a chance to conjure a burst of lava beneath the target, dealing True Damage. Without scythes, he gains Movement Speed, and his next Basic Attack is enhanced."),
                    Skill("Skill 1: Molten Scythes", "Thamuz tosses his scythes in a designated direction, dealing Physical Damage to enemies along the path. The scythes will stay at the destination, dealing continuous Physical Damage and slowing enemies. Thamuz can retrieve the scythes to pull enemies slightly."),
                    Skill("Skill 2: Chasm Trample", "Thamuz jumps to a designated area, dealing Physical Damage and slowing enemies. If the scythes are traveling, they will return to him immediately, and Molten Scythes' cooldown is reset."),
                    Skill("Ultimate: Cauterant Inferno", "Thamuz spouts the lava stored in his body, dealing Physical Damage to nearby enemies and creating a cauterant atmosphere around him. He recovers HP every time he deals damage with his Basic Attack or Scythes, and gains extra Attack Speed.")
                )
            ),
            Hero(
                71,
                name = "Kimmy",
                description = "Marksman/Mage",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_1_9_642/100_3fa938873a71f33898f26b19db654b7d.png",
                skills = listOf(
                    Skill("Passive: Chemist's Instinct", "Kimmy can move and aim in other directions while shooting, but her attacks are less accurate. All her extra Attack Speed is converted into Movement Speed. Kimmy restores 15 energy each time she kills an enemy."),
                    Skill("Skill 1: Energy Transformation", "Kimmy's Basic Attacks become energy balls, dealing Magic Damage on hit and consuming energy. This skill can critically strike, but only benefits from 40% of Kimmy's Spell Vamp."),
                    Skill("Skill 2: Chemical Refinement", "Kimmy dashes in the target direction and shoots a chemical spray, dealing Magic Damage to enemies on the path and slowing them. She restores energy upon casting this skill."),
                    Skill("Ultimate: Maximum Charge", "Kimmy charges up and fires a luminous attack in the target direction. The projectile explodes upon hitting an enemy hero or reaching maximum range, dealing Magic Damage to nearby enemies.")
                )
            ),
            Hero(
                70,
                name = "Belerick",
                description = "Tank",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Belerick%20-%20Hero701.png",
                skills = listOf(
                    Skill("Passive: Deadly Thorns", "For every 50 damage Belerick takes, he has a 25% chance to shoot Deadly Thorns toward the nearest enemy unit, dealing Magic Damage. He also gains 30% extra HP from equipment and emblems."),
                    Skill("Skill 1: Ancient Seed", "Belerick releases vines in the target direction, dealing Magic Damage to enemies in the path and slowing them. The vines then leave an Ancient Seed on the ground that deals Magic Damage and taunts enemies hit for 1.2s."),
                    Skill("Skill 2: Nature's Strike", "Belerick increases his Movement Speed by 80% and enhances his next Basic Attack. The enhanced Basic Attack deals Magic Damage and slows the target, while restoring Belerick's HP."),
                    Skill("Ultimate: Wrath of Dryad", "Belerick throws vines around him, dealing Magic Damage to enemies hit and immobilizing them for 1.5s. Deadly Thorns' chance to trigger is increased when enemies hit him during this time.")
                )
            ),
            Hero(
                69,
                name = "Hanzo",
                description = "Assassin",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_1_9_47/100_746725e15c7577be6bb92b2665adf447.png",
                skills = listOf(
                    Skill("Passive: Ame no Habakiri", "Hanzo gains Demon Blood when units die near him. He can also absorb Demon Blood by dealing damage. Demon Blood is consumed to maintain his Kinjutsu: Pinnacle Ninja state."),
                    Skill("Skill 1: Ninjutsu: Demon Feast", "Hanzo unlocks this skill temporarily after 5 Basic Attacks. He devours a target Creep or Minion, instantly killing them and granting him a large amount of Demon Blood. (In Demon Pneuma state: Deals massive Physical Damage to the target)."),
                    Skill("Skill 2: Ninjutsu: Soul Reap", "Hanzo summons Demonic Spikes at the target location, dealing Physical Damage to enemies and slowing them. (In Demon Pneuma state: Hanzo dashes to the target location, dealing Physical Damage to enemies in his path)."),
                    Skill("Ultimate: Kinjutsu: Pinnacle Ninja", "Hanzo releases the Demon Pneuma from his body. The Demon Pneuma gains extra Movement Speed, Attack Speed, and a new set of skills. Hanzo's main body is left behind and remains vulnerable. If the Demon Pneuma is killed, Hanzo is stunned and severely weakened.")
                )
            ),
            Hero(
                68,
                name = "Lunox",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Lunox%20-%20Hero681.png",
                skills = listOf(
                    Skill("Passive: Dreamland Twist", "Lunox is twisted by the powers of Chaos and Order. When Lunox uses Power of Order, she gains 0.5% Spell Vamp for every 1% Magic Penetration. When Lunox uses Power of Chaos, she gains 0.5% Magic Penetration for every 1% of Spell Vamp."),
                    Skill("Skill 1: Starlight Pulse", "Lunox summons a rain of starlight upon nearby enemies, dealing Magic Damage. The starlight then returns to Lunox, restoring her HP. Grants one stack of Power of Order after use."),
                    Skill("Skill 2: Chaos Assault", "Lunox unleashes Chaos Energy at an enemy, dealing Magic Damage equal to a base amount plus a percentage of the target's Max HP. Grants one stack of Power of Chaos after use."),
                    Skill("Ultimate: Order & Chaos", "When in Power of Order, Lunox becomes a brilliant sphere of light, dealing continuous Magic Damage while becoming invincible. When in Power of Chaos, Lunox blinks in a target direction and removes the cooldown of Chaos Assault for a few seconds.")
                )
            ),
            Hero(
                67,
                name = "Leomord",
                description = "Fighter",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_6c205605c520867a534e4e74588a7208.png",
                skills = listOf(
                    Skill("Passive: The Oath Keeper", "Leomord's Basic Attacks are guaranteed to critically strike against enemies below 50% Max HP, dealing 200% damage. Leomord converts every 1% Crit Chance gained into 2 Physical Attack."),
                    Skill("Skill 1: Momentum", "Leomord lunges forward and gains a shield, dealing Physical Damage and slowing enemies. (Mounted State: Phantom Stomp - Leomord's horse leaps forward, stomping the ground and dealing Physical Damage)."),
                    Skill("Skill 2: Decimation Assault", "Leomord charges in the target direction, dealing Physical Damage to enemies in his path. (Mounted State: Phantom Charge - Leomord's horse charges in a line, knocking back enemies and dealing Physical Damage)."),
                    Skill("Ultimate: Phantom Steed", "Leomord summons Barbiel to rush to him, dealing Physical Damage to enemies on the path. If Barbiel comes in contact with Leomord, they will enter the Mounted State, gaining a new set of skills, Movement Speed, and extra Defense.")
                )
            ),
            Hero(
                66,
                name = "Vale",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Vale%20-%20Hero661.png",
                skills = listOf(
                    Skill("Passive: Windtalk", "Vale gains 1 stack of Windtalk each time he gets a kill or an assist that increases his Movement Speed by 8. This effect can stack up to 10 times."),
                    Skill("Skill 1: Wind Blade", "Vale unleashes two wind blades toward the left and right of a target area, each dealing Magic Damage to enemies in their path. Triggers Spell Vamp."),
                    Skill("Skill 2: Windblow", "Vale sends a whirlwind in the target direction, dealing Magic Damage to enemies hit and knocking them airborne for 1 second. When the whirlwind reaches its destination, it will remain and continuously deal Magic Damage."),
                    Skill("Ultimate: Windstorm", "Vale summons a windstorm at the target location, dealing Magic Damage to enemies and slowing them while continuously pulling them into its center. After 1.6 seconds, the windstorm will explode, dealing massive Magic Damage.")
                )
            ),
            Hero(
                65,
                name = "Claude",
                description = "Marksman",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Claude%20-%20Hero651.png",
                skills = listOf(
                    Skill("Passive: Battle Side-by-side", "Dexter launches an extra attack each time Claude's Basic Attack lands, dealing Physical Damage to the same target. Dexter's Basic Attack can also trigger Claude's attack effects with 30% effectiveness."),
                    Skill("Skill 1: Art of Thievery", "Claude attacks enemies in a fan-shaped area ahead, dealing Physical Damage and reducing their Movement Speed and Attack Speed. For each target hit, Claude gains extra Movement and Attack Speed (stacks up to 5 times)."),
                    Skill("Skill 2: Battle Mirror Image", "Claude leaves a mirror image of Dexter at a designated location that automatically attacks enemies. Claude can activate this skill again to switch places with the mirror image."),
                    Skill("Ultimate: Blazing Duet", "Claude and Dexter rapidly fire at the enemies nearby over 3 seconds, dealing Physical Damage to up to two targets each time they shoot. This skill benefits from Basic Attack effects and grants him a shield.")
                )
            ),
            Hero(
                64,
                name = "Aldous",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Aldous%20-%20Hero641%20.png",
                skills = listOf(
                    Skill("Passive: Contract: Transform", "After every 2 attacks, Aldous gains a shield on his next Basic Attack that absorbs damage. This shield effect can only be triggered once every few seconds."),
                    Skill("Skill 1: Contract: Soul Steal", "Aldous unleashes his inner energy to enhance his next Basic Attack, dealing Physical Damage. If he eliminates an enemy unit with this attack, he gains Soul Steal stacks, permanently increasing the damage of this skill."),
                    Skill("Skill 2: Contract: Explosion", "Aldous assumes a defensive stance, gaining Damage Reduction and Movement Speed while ignoring Basic Attacks. When the stance ends, he deals Physical Damage to nearby enemies and stuns them."),
                    Skill("Ultimate: Contract: Chase Fate", "Aldous gains vision of all enemy heroes for 5 seconds. He can use this skill again to dash toward a designated enemy hero. Upon hitting the target, he deals Physical Damage based on the target's Max HP and knocks them back.")
                )
            ),
            Hero(
                63,
                name = "Selena",
                description = "Assassin/Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Selena%20-%20Hero631.png",
                skills = listOf(
                    Skill("Passive: Symbiosis", "Selena can freely switch between Elven and Abyssal forms. In Elven form, her skills apply Abyssal Marks to her enemies. In Abyssal form, her skills consume these marks to deal extra Magic Damage."),
                    Skill("Skill 1: Abyssal Trap", "Selena summons an Abyssal Devil to lurk in a designated location. If an enemy approaches, the Devil will smother them, dealing Magic Damage and slowing them. (In Abyssal form: Garotte - Selena charges forward and slashes enemies)."),
                    Skill("Skill 2: Abyssal Arrow", "Selena fires an Abyssal Arrow in a designated direction, dealing Magic Damage and stunning the first enemy hit. The stun duration scales with the distance traveled. (In Abyssal form: Magic Strike - Selena dashes and strikes an enemy)."),
                    Skill("Ultimate: Primal Darkness", "Selena fuses with the Abyss, entering Abyssal form and gaining Movement Speed. She gets new Abyssal skills and her Basic Attacks deal extra Magic Damage. (In Abyssal form: Blessing of the Moon God - Reverts back to Elven form).")
                )
            ),
            Hero(
                62,
                name = "Kaja",
                description = "Support/Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Kaja%20-%20Hero621.png",
                skills = listOf(
                    Skill("Passive: Wrath Sanction", "Kaja achieves Wrath Sanction every 6 seconds. His next Basic Attack will send lightning to enemies, dealing Magic Damage based on the target's Max HP and paralyzing them. Paralyzing slows enemies and reduces their damage."),
                    Skill("Skill 1: Ring of Order", "Kaja releases a Ringed Electric Blade that quickly expands and contracts, dealing Magic Damage to enemies hit on its way out and back and paralyzing them. Restores Kaja's HP upon hit."),
                    Skill("Skill 2: Lightning Bomb", "Kaja dashes in the target direction while leaving 3 Lightning Bombs along the way. The Bombs will explode upon enemy contact, dealing Magic Damage to the enemy and paralyzing them."),
                    Skill("Ultimate: Divine Judgment", "Kaja suppresses a target enemy hero, dealing Magic Damage and pulling them along with him. The target's Magic Defense is reduced and Kaja absorbs it. Kaja paralyzes the target during the suppression.")
                )
            ),
            Hero(
                61,
                name = "Chang'e",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Chang'e%20-%20Hero611.png",
                skills = listOf(
                    Skill("Passive: Trouble Maker", "Each time Chang'e deals damage to an enemy unit, she leaves a mark on them and her next skill damage to them is increased by 2% (up to 40%)."),
                    Skill("Skill 1: Starmoon Shockwave", "Chang'e sends an energy ball forward, dealing Magic Damage to enemies in its path and slowing them. Crescent Moon: Chang'e sends 4 extra energy balls, each dealing Magic Damage and slowing enemies."),
                    Skill("Skill 2: Crescent Moon", "Chang'e summons a Crescent Moon to bless herself, gaining a shield and Movement Speed. While the shield is active, her skills and Basic Attacks are enhanced. Her Basic Attacks deal extra Magic Damage."),
                    Skill("Ultimate: Meteor Shower", "Chang'e gathers strength and increases her Movement Speed. Meanwhile, she launches 30 Meteors forward, each dealing Magic Damage. Crescent Moon: Chang'e casts 33 Meteors, and Crescent Moon casts Meteors along with her.")
                )
            ),
            Hero(
                60,
                name = "Hanabi",
                description = "Marksman",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Hanabi%20-%20Hero601.png",
                skills = listOf(
                    Skill("Passive: Ninjutsu: Petal Barrage", "Hanabi's Basic Attacks and Skills will launch Petal Blades after hitting a target, bouncing up to 4 times to nearby enemies. Bounces from her Basic Attacks inherit a portion of Attack Effects."),
                    Skill("Skill 1: Ninjutsu: Equinox", "Passive: Hanabi is immune to control effects when she has a shield from any source. Active: Hanabi gains a shield for 5 seconds. When the shield is active, she gains Movement Speed, Attack Speed, and a percentage of damage dealt will be added to this shield."),
                    Skill("Skill 2: Ninjutsu: Soul Scroll", "Hanabi fires the energy Kunai in the targeted direction, dealing Physical Damage to enemies along the way and reducing their Movement Speed. Enemy units hit will also be marked, allowing Hanabi's next Bounce Damage to deal full damage with no decay."),
                    Skill("Ultimate: Forbidden Jutsu: Higanbana", "Hanabi throws Higanbana in the targeted direction, dealing Physical Damage to the first enemy hero hit and immobilizing them. After a delay, Higanbana blooms, dealing Physical Damage to nearby enemies.")
                )
            ),
            Hero(
                59,
                name = "Uranus",
                description = "Tank",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Uranus%20-%20Hero591.png",
                skills = listOf(
                    Skill("Passive: Radiance", "Uranus absorbs the energy generated by incoming attacks to strengthen himself, regenerating HP every 0.8s. Each stack lasts 10s and can stack up to 20 times."),
                    Skill("Skill 1: Ionic Edge", "Uranus releases two energy blades that orbit around him, dealing Magic Damage to enemy targets and slowing them. Each time this skill deals damage, it leaves a mark that increases the damage of subsequent hits."),
                    Skill("Skill 2: Transcendent Ward", "Uranus charges to the target location, dealing Magic Damage to enemies along the way and slowing them. He generates a shield for himself that explodes at the end of its duration or when destroyed, dealing Magic Damage to nearby enemies."),
                    Skill("Ultimate: Consecration", "Uranus removes slow effects on himself, restores HP, and gains Movement Speed. He directly gains stacks of Radiance, increasing his shields received and HP Regen by 20% for 8s.")
                )
            ),
            Hero(
                58,
                name = "Martis",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Martis%20-%20Hero581.png",
                skills = listOf(
                    Skill("Passive: Asura's Wrath", "Each time Martis uses a skill, his Attack Speed will be increased by 30%, up to a maximum of 120%. He also gains extra Physical Attack at full stacks."),
                    Skill("Skill 1: Asura Aura", "Martis draws enemies to a fan-shaped area in front of him and deals Physical Damage, slowing them for 2 seconds."),
                    Skill("Skill 2: Mortal Coil", "Martis strikes in the designated direction 3 times, dealing Physical Damage and knocking enemies back. He can cast the skill again to dash forward, knocking enemies airborne and dealing Physical Damage. He gains Damage Reduction and Control Immunity during the skill."),
                    Skill("Ultimate: Decimation", "Martis lunges at a designated enemy hero, dealing Physical Damage. Deals True Damage if the enemy's HP is below 50%. If the enemy is killed, Martis can cast the skill again within 10s and gains 100% extra Movement Speed.")
                )
            ),
            Hero(
                57,
                name = "Valir",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Valir%20-%20Hero571.png",
                skills = listOf(
                    Skill("Passive: Ashing", "Valir's skills apply a stack of Ablaze to enemies hit, dealing Magic Damage based on their Max HP per second. At 3 stacks, the fire detonates, dealing massive Magic Damage and stunning the target."),
                    Skill("Skill 1: Burst Fireball", "Valir casts a fireball that explodes upon hitting an enemy, dealing Magic Damage and slowing them. The fireball leaves a fire zone on the ground that deals continuous Magic Damage. Valir stores up to 2 charges of this skill."),
                    Skill("Skill 2: Searing Torrent", "Valir unleashes a torrent of flames forward, knocking enemies back and dealing Magic Damage. A firewall will be created at the end of its path, dealing continuous Magic Damage and slowing enemies."),
                    Skill("Ultimate: Vengeance Flame", "Valir removes all debuffs on himself and conjures 4 Vengeance Flames. His subsequent skills consume a Flame to deal extra base damage and enhance the effects of his Skill 1 and Skill 2. He also gains Movement Speed.")
                )
            ),
            Hero(
                56,
                name = "Gusion",
                description = "Assassin/Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Gusion%20-%20Hero561.png",
                skills = listOf(
                    Skill("Passive: Dagger Specialist", "Each skill cast adds a rune to Gusion's dagger. At 4 stacks, his next Basic Attack deals additional Magic Damage based on the target's missing HP and restores his own HP."),
                    Skill("Skill 1: Sword Spike", "Gusion throws a dagger in the target direction, dealing Magic Damage and marking the first enemy hit. He can cast the skill again to dash behind the marked enemy, dealing Magic Damage."),
                    Skill("Skill 2: Shadowblade Slaughter", "Gusion throws a volley of five daggers in the target direction, each dealing Magic Damage and slowing enemies. He can cast the skill again to recall the daggers, dealing Magic Damage to enemies in their path."),
                    Skill("Ultimate: Incandescence", "Gusion dashes to the target location, resetting the cooldowns of his Skill 1 and Skill 2. If Skill 2 was cast before, he can throw another five daggers and recall a total of ten. He can dash again a short distance.")
                )
            ),
            Hero(
                55,
                name = "Angela",
                description = "Support",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Angela%20-%20Hero551.png",
                skills = listOf(
                    Skill("Passive: Smart Heart", "Angela gains extra Movement Speed each time she casts a skill. When attached to an allied hero, the Movement Speed boost is transferred to the allied hero."),
                    Skill("Skill 1: Love Waves", "Angela sends Love Waves forward, dealing Magic Damage to enemies and applying a Lover's Mark that increases damage taken and slows them. The waves also heal allied heroes hit. She stores up to 5 charges."),
                    Skill("Skill 2: Puppet-on-a-String", "Angela launches a Puppet String at a target enemy, dealing Magic Damage and gradually slowing them. If the enemy remains connected after a delay, they are immobilized and take heavy Magic Damage."),
                    Skill("Ultimate: Heartguard", "Angela channels to apply a massive shield to a designated allied hero across the map. She then attaches herself to the hero, allowing her to cast skills at zero Mana cost while moving with them.")
                )
            ),
            Hero(
                54,
                name = "Jawhead",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Jawhead%20-%20Hero541.png",
                skills = listOf(
                    Skill("Passive: Mecha Suppression", "Jawhead's attacks apply a stack of Mecha Suppression to non-minion enemies. Each stack increases the damage of Jawhead's Basic Attacks to that enemy by 8%."),
                    Skill("Skill 1: Smart Missiles", "Jawhead launches up to 12 missiles at random nearby enemies over a few seconds, with each missile dealing Physical Damage on hit."),
                    Skill("Skill 2: Ejector", "Jawhead gains Movement Speed and a shield. He can cast the skill again to fling the nearest unit (prioritizing heroes) to a target location, dealing Physical Damage to enemies in the area and stunning them. Can fling allies safely."),
                    Skill("Ultimate: Unstoppable Force", "Jawhead charges into a target enemy hero, dealing Physical Damage and briefly stunning them. Enemies around the target are knocked back and take the same amount of damage. Jawhead is immune to control effects during the charge.")
                )
            ),
            Hero(
                53,
                name = "Lesley",
                description = "Marksman/Assassin",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_2_1_18_2/100_2bd608ac82a1af4783c5d0fff0c280dc.png",
                skills = listOf(
                    Skill("Passive: Lethal Shot", "If Lesley doesn't take damage for 5 seconds, her next Basic Attack gains extra range, Critical Chance, and deals True Damage. Using skills resets Lethal Shot's cooldown. Her Physical Pen is converted to Critical Damage."),
                    Skill("Skill 1: Master of Camouflage", "Lesley enters the Camouflage state, gaining Movement Speed, extra Physical Attack, and double Energy Regen. The state ends if she takes or deals damage."),
                    Skill("Skill 2: Tactical Grenade", "Lesley throws a tactical grenade forward while slightly jumping back, dealing Physical Damage in a cone and knocking enemies back. Can be used to interrupt her Ultimate."),
                    Skill("Ultimate: Ultimate Snipe", "Lesley locks onto a target enemy hero and fires 4 Lethal Bullets from afar. Each bullet deals Physical Damage based on the target's lost HP. The bullets can be blocked by other enemy heroes.")
                )
            ),
            Hero(
                52,
                name = "Pharsa",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Pharsa%20-%20Hero521.png",
                skills = listOf(
                    Skill("Passive: Spiritual Unity", "Every few seconds, Verri assists Pharsa on her next attack against an enemy hero, dealing extra Magic Damage based on the target's Max HP and slowing them."),
                    Skill("Skill 1: Curse of Crow", "Pharsa unleashes a blast of magic, dealing Magic Damage to enemies hit and marking them. Her subsequent attacks or skills against marked enemies will consume the mark and stun them."),
                    Skill("Skill 2: Energy Impact", "Pharsa releases magic energy in the target direction, dealing Magic Damage to enemies in its path."),
                    Skill("Ultimate: Feathered Air Strike", "Pharsa takes flight and bombards a target area, dealing massive Magic Damage. This skill can be cast up to 4 times within the duration. She also has the 'Wings by Wings' skill to transform into Verri and fly over obstacles.")
                )
            ),
            Hero(
                51,
                name = "Helcurt",
                description = "Assassin",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_ffd27cd02c46f7075caedcd51de80d9a.png",
                skills = listOf(
                    Skill("Passive: Shadow of Styx", "Helcurt remains in the Prowler state until spotted by the enemy team, gaining extra Movement Speed and continuously regenerating HP. He gains extra Attack Speed and Movement Speed for 4 seconds upon being spotted. Any hero killed by Helcurt leaves a dark fog that explodes and spreads."),
                    Skill("Skill 1: Hidden Terror", "Passive: When Helcurt is in Prowler state, the skill terrifies enemy heroes hit and its cooldown decreases faster. Active: Helcurt blinks to the target location and deals Physical Damage to enemies, reducing their Movement Speed."),
                    Skill("Skill 2: Deadly Stinger", "Passive: Helcurt gains one Deadly Stinger for every 1.5s spent in Prowler state or on each Basic Attack (up to 5 stingers). Active: Helcurt fires all Deadly Stingers forward, each dealing Physical Damage to enemies. Deadly Stinger counts as a Basic Attack but cannot Crit."),
                    Skill("Ultimate: Dark Night Falls", "Helcurt summons the Dark Night, reducing all enemies' sight range and making them lose sight of their allies for 3s. During Dark Night, Helcurt gains 40% Movement Speed. The Dark Night makes it easier for Helcurt to leave enemies' sight range.")
                )
            ),
            Hero(
                50,
                name = "Zhask",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Zhask%20-%20Hero501.png",
                skills = listOf(
                    Skill("Passive: Decimation", "Upon death, Zhask summons a frenzied Nightmaric Spawn on the spot, which gradually loses HP over time until death."),
                    Skill("Skill 1: Nightmaric Spawn", "Zhask summons a Nightmaric Spawn that inherits a percentage of his Attributes. It automatically attacks nearby enemies by firing a Death Ray, dealing Magic Damage and slowing them. If Zhask is too far away, it will disappear."),
                    Skill("Skill 2: Mind Eater", "Zhask fires a penetrating mental missile in the designated direction, dealing Magic Damage. Afterward, Nightmaric Spawn will also use Mind Eater, dealing Magic Damage and stunning enemies. Fusion Enhanced: Increases the damage dealt by Mind Eater."),
                    Skill("Ultimate: Dominator's Descent", "Zhask selects a designated position to summon Nightmaric Spawn and fuses with it. Nightmaric Spawn inherits 100% of his attributes and gets extra attributes. His skills are enhanced during the fusion period. Use Again: Zhask immediately gets off the Spawn.")
                )
            ),
            Hero(
                49,
                name = "Hylos",
                description = "Tank",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Hylos%20-%20Hero491.png",
                skills = listOf(
                    Skill("Passive: Thickened Blood", "Hylos gains 1.5 extra Max HP for every 1 extra Max Mana he possesses. When out of Mana, Hylos can use his HP for skill casts."),
                    Skill("Skill 1: Law and Order", "Hylos gains 50% Movement Speed and causes his next Basic Attack to deal Magic Damage to the target, knock them back, and stun them for 1 second. The extra Movement Speed rapidly decays over the duration."),
                    Skill("Skill 2: Ring of Punishment", "Hylos releases the Ring of Punishment, dealing continuous Magic Damage to nearby enemies while slowing them and reducing their Attack Speed. Each stack increases the enemy's damage taken from the Ring. Consumes Mana per second while active."),
                    Skill("Ultimate: Glorious Pathway", "Hylos creates a huge pathway in the target direction, severely reducing enemies' Movement Speed. When on the pathway, Hylos gains Slow Immunity and recovers a percentage of his Max HP per second. Allied heroes moving along the pathway gain extra Movement Speed.")
                )
            ),
            Hero(
                48,
                name = "Diggie",
                description = "Support",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Diggie%20-%20Hero481.png",
                skills = listOf(
                    Skill("Passive: Young Again", "Upon death, Diggie reverses time and turns to egg form, in which he can continue to move around and gains a new set of skills. He cannot be targeted in egg form, provides vision, and will revive after a period of time."),
                    Skill("Skill 1: Auto Alarm Bomb", "Diggie throws an owl alarm at the target direction. The alarm will chase nearby enemies, dealing Magic Damage upon collision and slowing them. Diggie can store up to 2 charges."),
                    Skill("Skill 2: Reverse Time", "Diggie locks onto a target enemy hero, dealing Magic Damage and slowing them. After a short delay, the target will be pulled back to their set location and take Magic Damage again if they move too far away."),
                    Skill("Ultimate: Time Journey", "Diggie provides a shield for himself and surrounding allied heroes, becoming immune to Crowd Control effects for a short duration. During this time, Diggie also gains Movement Speed.")
                )
            ),
            Hero(
                47,
                name = "Lancelot",
                description = "Assassin",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Lancelot%20-%20Hero471%20(Revamped).png",
                skills = listOf(
                    Skill("Passive: Soul Cutter", "Each time Lancelot blinks or charges, his damage is increased by 7.5% for 4 seconds, stacking up to 30%."),
                    Skill("Skill 1: Puncture", "Lancelot charges in a designated direction, dealing Physical Damage to enemies along the way and applying a Sword Mark to the first unmarked enemy hit. If he successfully applies a mark, the cooldown of this skill will reset."),
                    Skill("Skill 2: Thorned Rose", "Lancelot strikes in the target direction 3 times, each time dealing Physical Damage. He's untargetable and invincible during this process. Enemies in the center take all 3 hits and are slowed. Only benefits from 50% Spell Vamp."),
                    Skill("Ultimate: Phantom Execution", "After a short period of charging, Lancelot performs an executioner's strike in the target direction, dealing massive Physical Damage. He is invincible throughout the process.")
                )
            ),
            Hero(
                46,
                name = "Odette",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Odette%20-%20Hero461%20(Revamped).png",
                skills = listOf(
                    Skill("Passive: Lakeshore Ambience", "After each skill cast, Odette's next Basic Attack or skill will cast a sound wave that rebounds between her and enemies, each bounce dealing Magic Damage."),
                    Skill("Skill 1: Avian Authority", "Odette concentrates energy to summon a swan to attack enemies, dealing Magic Damage and slowing them by 30% for 2 seconds."),
                    Skill("Skill 2: Blue Nova", "Odette releases magic energy balls forward, dealing Magic Damage to the enemy hit and immobilizing them. Another energy ball will then spawn and attack a nearby enemy, immobilizing them as well."),
                    Skill("Ultimate: Swan Song", "Odette leaps in a designated direction, gains a massive shield, and begins gathering energy, dealing continuous Magic Damage to enemies within the area for 5 seconds while slowing them. Requires constant channeling.")
                )
            ),
            Hero(
                45,
                name = "Argus",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Argus%20-%20Hero451.png",
                skills = listOf(
                    Skill("Passive: Warmonger", "When Argus' blade reaches 100 Malice Energy, he launches a Demonic Slash with his next Basic Attack, dealing Physical Damage and recovering HP. This attack ignores 40% of the target's Physical Defense."),
                    Skill("Skill 1: Demonic Grip", "Argus stretches out a demonic hand, dealing Physical Damage to the first enemy hit, stunning them, and pulling him and the target towards each other. He can cast the skill again to dash and strike."),
                    Skill("Skill 2: Meteoric Sword", "Argus thrusts his Demonic Blade, dealing Physical Damage to enemies hit and slowing them. Enemy heroes hit are Cursed and leave a Cursed Trail behind. Argus gains Movement Speed while on the trail."),
                    Skill("Ultimate: Eternal Evil", "Argus draws his Meteoric Sword, removes all debuffs (excluding Suppression), and becomes the Fallen Angel for 4 seconds, gaining Death Immunity. When the transformation ends, he converts all damage dealt during this state into HP.")
                )
            ),
            Hero(
                44,
                name = "Grock",
                description = "Tank",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Grock%20-%20Hero441.png",
                skills = listOf(
                    Skill("Passive: Bastion of Stone", "Grock gains a Shield equal to 10% of his Max HP and empowers his next Basic Attack to deal Physical Damage based on the target's Max HP. The cooldown reduces greatly when near terrain. Grock gains Control Immunity and extra Defense while the Shield is active."),
                    Skill("Skill 1: Mighty Swing", "Grock strikes forward with massive force, dealing Physical Damage. Enemies near an obstacle are launched airborne and take extra Physical Damage. If there are no obstacles, they are only knocked back slightly."),
                    Skill("Skill 2: Earthen Rampart", "After a brief delay, Grock summons a stone wall in the target area, dealing Physical Damage and knocking enemies towards him. He can cancel the wall early."),
                    Skill("Ultimate: Tectonic Charge", "Grock charges forward, dealing Physical Damage. Upon hitting terrain, he immediately stops and triggers a massive explosion that knocks nearby enemies airborne and deals massive Physical Damage. If it doesn't hit terrain, 50% of the cooldown is refunded.")
                )
            ),
            Hero(
                43,
                name = "Irithel",
                description = "Marksman",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Irithel%20-%20Hero431.png",
                skills = listOf(
                    Skill("Passive: Jungle Heart", "Irithel can shoot while moving. Each Basic Attack shoots 2 crossbow bolts that deal Physical Damage. Moving builds up Jungle Heart, and at max stacks, her next Basic Attack unleashes 1 additional bolt."),
                    Skill("Skill 1: Strafe", "Irithel launches a volley of arrows on the target area, dealing Physical Damage to enemies within and reducing their Physical Defense for 3 seconds."),
                    Skill("Skill 2: Force of the Queen", "Leo lets out a piercing roar, dealing Physical Damage to nearby enemies and slowing them by 40% for 2 seconds."),
                    Skill("Ultimate: Heavy Crossbow", "Irithel orders Leo to leap in the target direction and empowers her crossbow for 10 seconds. She gains extra Movement Speed, and her Basic Attacks shoot enhanced crossbow bolts dealing heavy area Physical Damage. Jungle Heart accumulates faster.")
                )
            ),
            Hero(
                42,
                name = "Harley",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Harley%20-%20Hero421.png",
                skills = listOf(
                    Skill("Passive: Magic Master", "Harley's Basic Attacks deal Magic Damage. His attacks reduce the enemy's Magic Defense for 3 seconds on hit, stacking up to 10 times."),
                    Skill("Skill 1: Poker Trick", "Harley throws multiple waves of cards in the target direction, dealing Magic Damage and granting him extra Attack Speed on hit. Enemies hit more than 3 times take less damage from subsequent hits."),
                    Skill("Skill 2: Space Escape", "Harley blinks in the designated direction, leaving a magic hat at his place, increasing his Movement Speed by 30% for 2 seconds. He can use the skill again to return to the hat."),
                    Skill("Ultimate: Deadly Magic", "Harley casts a magic ring of fire at a target enemy hero, dealing Magic Damage and slowing them. The ring stays for 4 seconds, during which Harley can hit the ring to damage the enemy. At the end, the ring explodes, dealing base damage plus a percentage of the damage taken during the duration.")
                )
            ),
            Hero(
                41,
                name = "Gatotkaca",
                description = "Tank",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Gatotkaca%20-%20Hero411.png",
                skills = listOf(
                    Skill("Passive: Steel Bones", "Gatotkaca gains Physical Defense equal to 2% of his lost HP (up to 100). For every 300 damage he takes, he gains 5 Rage. Upon reaching over 25 Rage, Gatotkaca's next Basic Attack becomes enhanced, consuming all Rage to deal extra Magic Damage and recover HP."),
                    Skill("Skill 1: Blast Iron Fist", "Gatotkaca slams the ground, creating a shattered zone in the target direction while dealing Magic Damage to enemies within. Enemies in the shattered zone will take continuous Magic Damage and be slowed."),
                    Skill("Skill 2: Unbreakable", "Gatotkaca begins channeling, then sprints in the target direction with a battle cry, forcing enemies on the path to attack him and dealing Magic Damage. The sprint distance scales with the channel time. Canceling the skill reduces its cooldown."),
                    Skill("Ultimate: Avatar of the Guardian", "Gatotkaca jumps to the target location, dealing massive Magic Damage to nearby enemies and knocking them airborne. Enemies near the center will be knocked airborne for a longer duration, while enemies on the fringes will be pulled to the center.")
                )
            ),
            Hero(
                40,
                name = "Karrie",
                description = "Marksman",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Karrie%20-%20Hero401.png",
                skills = listOf(
                    Skill("Passive: Lightwheel Mark", "Karrie's Basic Attacks and skills apply a stack of Lightwheel Mark on hit. Once a target has 5 stacks, the marks will turn into a lightwheel, dealing True Damage equal to 6%-8% of the target's Max HP."),
                    Skill("Skill 1: Spinning Lightwheel", "Karrie releases a sphere of surging energy in the target direction, dealing Physical Damage to enemies in its path. The sphere will stop upon hitting an enemy hero or reaching its max travel distance, continuously dealing Physical Damage to nearby enemies and slowing them."),
                    Skill("Skill 2: Phantom Step", "Karrie dashes in the target direction while throwing a lightwheel at the nearest enemy, dealing Physical Damage and applying a stack of Lightwheel Mark on them. When in Dual Wield state, Karrie throws two lightwheels instead."),
                    Skill("Ultimate: Speedy Lightwheel", "Karrie enters Dual Wield state for 6s, during which she gains Movement Speed and throws two lightwheels with each Basic Attack, each dealing a percentage of her Basic Attack damage and inheriting Attack Effects.")
                )
            ),
            Hero(
                39,
                name = "Roger",
                description = "Fighter/Marksman",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Roger%20-%20Hero391.png",
                skills = listOf(
                    Skill("Passive: Full Moon Curse", "Roger can freely switch between human and wolf forms. In human form, his Basic Attacks and skills deal additional damage based on the target's Current HP. In wolf form, they deal additional damage based on the target's Lost HP."),
                    Skill("Skill 1: Open Fire / Lycan Pounce", "Human Form: Roger shoots twice, dealing Physical Damage and slowing the enemy. The second net lowers their Defense. Wolf Form: Roger leaps toward the target, dealing Physical Damage to up to 3 enemies while becoming untargetable. Kills/Assists reduce its cooldown."),
                    Skill("Skill 2: Hunter's Steps / Bloodthirsty Howl", "Human Form: Roger gains Movement Speed for a short duration. Wolf Form: Roger lets out a howl, gaining extra Attack Speed. If there is an enemy with low HP in his field of vision, his Movement Speed increases drastically."),
                    Skill("Ultimate: Wolf Transformation / Restore Human Form", "Human Form: Roger lunges forward and turns into a wolf, dealing Physical Damage and slowing enemies. He gains Physical and Magic Defense. Wolf Form: Roger rolls in a direction and turns back into a human, gaining a shield.")
                )
            ),
            Hero(
                38,
                name = "Vexana",
                description = "Mage",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_39c9058219c59535e9ed07645c8d9dd3.png",
                skills = listOf(
                    Skill("Passive: Nether Touch", "Vexana and the Eternal Guard inflict Nether Curse on enemies hit. The Curse lasts 5 seconds and will cause the affected enemy to explode upon death, dealing Magic Damage to nearby enemies."),
                    Skill("Skill 1: Deathly Grasp", "Vexana unleashes a Deathly Grasp in the target direction, dealing Magic Damage to enemies in its path. The projectile stops upon hitting an enemy hero, terrifying them and knocking them back, then it explodes, dealing area Magic Damage and terrifying nearby enemies."),
                    Skill("Skill 2: Cursed Blast", "Vexana marks the target area with the power of the undead, striking it after a short delay and dealing immense Magic Damage to enemies hit."),
                    Skill("Ultimate: Eternal Guard", "Vexana summons an Eternal Guard at the target location, dealing Magic Damage to enemies hit and knocking them airborne. The Eternal Guard then joins Vexana in battle for 15 seconds. Its attacks deal area Magic Damage based on its target's Max HP.")
                )
            ),
            Hero(
                37,
                name = "Lapu-Lapu",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Lapu-Lapu%20-%20Hero371.png",
                skills = listOf(
                    Skill("Passive: Homeland Defender", "Each time Lapu-Lapu deals damage, he gains Bravery Blessing. When full, his next Basic Attack or Justice Blades will be enhanced, granting him a shield. The enhanced Basic Attack causes him to dash toward the target, dealing heavy Physical Damage."),
                    Skill("Skill 1: Justice Blades", "Lapu-Lapu releases two boomerangs in the target direction, dealing Physical Damage to enemies hit on the way out and back. (In Heavy Sword Stance: He slashes forward with his heavy sword, dealing massive Physical Damage and stunning enemies)."),
                    Skill("Skill 2: Jungle Warrior", "Lapu-Lapu slashes his twin blades and charges in a designated direction, dealing Physical Damage to enemies on the path. (In Heavy Sword Stance: He whirls his heavy sword, dealing Physical Damage and gaining Damage Reduction)."),
                    Skill("Ultimate: Bravest Fighter", "Lapu-Lapu leaps to the target location while combining his twin blades into one, dealing Physical Damage upon landing and slowing enemies. For the next 10 seconds, he enters Great Sword Stance, gaining enhanced skills, extra Defense, and increased Basic Attack damage.")
                )
            ),
            Hero(
                36,
                name = "Aurora",
                description = "Mage",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_1f3f900f917956e81d7764b9e5ffeb3d.png",
                skills = listOf(
                    Skill("Passive: Pride of Ice", "Upon taking fatal damage, Aurora freezes herself for 1.5 seconds, becoming invincible during this time and gradually recovering 30% Max HP. This effect has a 150 seconds cooldown. Aurora's freeze effects can also affect Turrets."),
                    Skill("Skill 1: Hailstone Blast", "Aurora summons an icy meteorite to strike at the target location, dealing Magic Damage and slowing targets hit. Afterward, 5 hailstones fall, each dealing Magic Damage."),
                    Skill("Skill 2: Frosty Breeze", "Aurora blows Frosty Breeze in a fan-shaped area, dealing Magic Damage to enemies hit, freezing them for 1 second, and creating a frozen area at the far-end that deals continuous Magic Damage."),
                    Skill("Ultimate: Frigid Glacier", "Aurora creates a frost path in the target direction, dealing Magic Damage and severely reducing enemies' Movement Speed. The frost path gradually becomes glaciers that spread until shattering, dealing massive Magic Damage and freezing targets.")
                )
            ),
            Hero(
                35,
                name = "Hilda",
                description = "Fighter/Tank",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Hilda%20-%20Hero351.png",
                skills = listOf(
                    Skill("Passive: Blessing of Wilderness", "Hilda regenerates 2% of her Max HP per second while staying in the bush. When entering a bush, she gains a shield equal to 15% of her Max HP. Her Basic Attacks and Skills apply a Wilderness Mark that reduces the target's Physical and Magic Defense."),
                    Skill("Skill 1: Combat Ritual", "Hilda activates the runic power of her great axe, increasing her Movement Speed by 60% for 3 seconds and enhancing her next Basic Attack to deal Physical Damage, slow the target, and damage enemies behind them."),
                    Skill("Skill 2: Art of Hunting", "Hilda locks onto an enemy target, dealing Physical Damage. This skill can be released up to 3 times. The 2nd attack deals area damage, and the 3rd attack knocks back the target and surrounding enemies."),
                    Skill("Ultimate: Power of Wildness", "Hilda launches a powerful slash on the target enemy, dealing massive Physical Damage and briefly stunning them. Nearby enemies also take damage. Each stack of Wilderness Mark makes this skill deal extra damage based on the target's Max HP.")
                )
            ),
            Hero(
                34,
                name = "Estes",
                description = "Support",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Estes%20-%20Hero341.png",
                skills = listOf(
                    Skill("Passive: Scripture of the Moon Elf", "Scripture of the Moon Elf slowly charges Estes with energy. At 100 stacks, his next Basic Attack is enhanced, dealing Magic Damage to the target and nearby enemies while slowing them."),
                    Skill("Skill 1: Moonlight Immersion", "Estes restores HP for a target hero immediately and links himself with them, slowly restoring more HP over time. Linking increases Estes' Hybrid Defense, Movement Speed, and energy charging speed. Being too far breaks the link."),
                    Skill("Skill 2: Domain of Moon Goddess", "Estes drops a flood of moonlight on the target area, dealing Magic Damage to enemy units within it. It turns into a domain that reveals enemies and severely slows them when they touch its edge."),
                    Skill("Ultimate: Blessing of Moon Goddess", "Estes casts an enhanced Moonlight Immersion on all nearby allied heroes. Within the next 8 seconds, Moonlight Immersion is enhanced and Estes continuously recovers a massive amount of his own HP.")
                )
            ),
            Hero(
                33,
                name = "Cyclops",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Cyclops%20-%20Hero331.png",
                skills = listOf(
                    Skill("Passive: Starlit Hourglass", "Each time Cyclops hits an enemy with his skills, all his skill cooldowns are reduced by 0.5s."),
                    Skill("Skill 1: Stardust Shock", "Cyclops casts two Stardust Disks forward, each dealing Magic Damage to enemies in its path."),
                    Skill("Skill 2: Planets Attack", "Cyclops conjures Starlit Spheres around himself while gaining 30% Movement Speed for 2s. The spheres automatically seek and attack nearby enemies (prioritizing heroes), exploding on collision and dealing Magic Damage."),
                    Skill("Ultimate: Star Power Lockdown", "Cyclops creates a Planetary Sphere and sends it after a target enemy hero or Creep, dealing massive Magic Damage and immobilizing them. The immobilization duration increases based on the sphere's travel distance.")
                )
            ),
            Hero(
                32,
                name = "Johnson",
                description = "Tank",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_9939e5cc09011a287a989b7d4b3aec4d.png",
                skills = listOf(
                    Skill("Passive: Electro Airbag", "When Johnson's HP drops below 30%, he gains a massive shield for 10 seconds. This effect has a 100-second cooldown."),
                    Skill("Skill 1: Impact Wrench", "Johnson throws his wrench toward the target location, dealing Magic Damage to enemies in its path. Enemies around the landing point are stunned for 0.8 seconds."),
                    Skill("Skill 2: Electromag Rays", "Johnson raises his shield, dealing continuous Magic Damage to enemies in a fan-shaped area in front of him and slowing them. He can use Basic Attacks and skills while the shield is raised."),
                    Skill("Ultimate: Full Throttle", "Johnson transforms into a car and accelerates. One allied hero can board the car. The car explodes upon hitting an enemy hero or obstacle, dealing Magic Damage to nearby enemies, stunning them, and leaving an electrified zone that damages and slows enemies.")
                )
            ),
            Hero(
                31,
                name = "Moskov",
                description = "Marksman",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Moskov%20-%20Hero311.png",
                skills = listOf(
                    Skill("Passive: Spear of Quiescence", "Moskov's Basic Attacks can penetrate the target and deal Critical Physical Damage to enemies behind them. Each Basic Attack hit reduces the cooldowns of Abyss Walker and Spear of Misery by 0.5 seconds."),
                    Skill("Skill 1: Abyss Walker", "Moskov teleports to the target location, increasing his Attack Speed to 1.15–1.5 times for 3 seconds. Meanwhile, his Basic Attack deals 10% more damage to enemies behind the primary target."),
                    Skill("Skill 2: Spear of Misery", "Moskov launches a powerful strike at the target enemy hero or Creep, dealing Physical Damage, knocking them back, and revealing their position. If the target collides with an enemy hero or wall when knocked back, they will both be stunned and take extra damage."),
                    Skill("Ultimate: Spear of Destruction", "Moskov throws the Spear of Destruction across the map. Upon hitting an enemy hero, it explodes, dealing massive Physical Damage and slowing them. A shadow of the spear remains on the target, granting Moskov vision and the ability to teleport to it within a short time.")
                )
            ),
            Hero(
                30,
                name = "Yi Sun-shin",
                description = "Assassin/Marksman",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Yi%20Sun-shin%20-%20Hero301.png",
                skills = listOf(
                    Skill("Passive: Heavenly Vow", "Yi Sun-shin attacks with his longbow and glaive according to his distance from the target. Weapon Mastery: After each weapon switch, the next two Basic Attacks will gain extra Attack Speed, deal Crit Damage, and grant Movement Speed for 1 second."),
                    Skill("Skill 1: Traceless", "Yi Sun-shin dashes forward and slashes with his glaive, dealing Physical Damage and becoming immune to control effects for 1 second. Each Weapon Mastery triggered reduces the cooldown of Traceless by 1 second."),
                    Skill("Skill 2: Blood Floods", "Tap: Yi Sun-shin slashes swiftly with his glaive, dealing Physical Damage. Hold: He shoots a powerful arrow, dealing Physical Damage. The arrow's damage scales with the hold time, up to 200%. He gains Weapon Mastery immediately when this skill is used."),
                    Skill("Ultimate: Mountain Shocker", "Yi Sun-shin summons a turtle ship and gains sight of the whole map for 5 seconds. He gains burst Movement Speed. When cast again, he commands the turtle ship to ram the target area, dealing Physical Damage and stunning enemies in the center. Then the fleet launches meteor showers at enemy heroes.")
                )
            ),
            Hero(
                29,
                name = "Ruby",
                description = "Fighter/Tank",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Ruby%20-%20Hero291.png",
                skills = listOf(
                    Skill("Passive: Let's Dance!", "Ruby gains extra Spell Vamp (based on level) and inherits 125% Spell Vamp Ratio from items (Basic Attacks cannot trigger Lifesteal). After each skill cast, Ruby can dash to another location, gaining Physical & Magic Defense for 4 seconds that stacks up to 3 times."),
                    Skill("Skill 1: Be Good!", "Ruby swings her scythe, dealing Physical Damage to enemies hit. She then unleashes a shockwave in the same direction, dealing Physical Damage to enemies hit and slowing them by 40% for 1 second."),
                    Skill("Skill 2: Don't Run, Wolf King!", "Ruby swings her scythe twice, each swing dealing Physical Damage to nearby enemies, stunning them for 0.5 seconds, and slowly pulling them toward her."),
                    Skill("Ultimate: I'm Offended!", "Ruby sweeps her scythe in the target direction, dealing massive Physical Damage to enemies hit, pulling them toward her, and stunning them for 0.5 seconds.")
                )
            ),
            Hero(
                28,
                name = "Alpha",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Alpha%20-%20Hero281.png",
                skills = listOf(
                    Skill("Passive: Beta, Advance!", "When Alpha uses a skill, Beta will be summoned to attack. Non-minion enemies hit by Beta 2 times will be Locked On. Locked On: After Alpha deals damage to the target, Beta will fire a laser at them, dealing True Damage and briefly applying a powerful slow."),
                    Skill("Skill 1: Rotary Impact", "Alpha unleashes an energy wave in the target direction, dealing Physical Damage to enemies in its path and slowing them. Beta then strafes enemies along the same path, dealing True Damage."),
                    Skill("Skill 2: Force Swing", "After a short delay, Alpha swings his blade in the target direction, dealing Physical Damage to enemies in a fan-shaped area and recovering HP for each enemy hit. Beta then strafes enemies in the same area, dealing True Damage."),
                    Skill("Ultimate: Spear of Alpha", "Beta dives into target location, dealing Physical Damage and stunning enemies. Alpha then leaps towards the same location, knocking enemies airborne and carrying them to the landing location. Alpha slams down, dealing heavy Physical Damage and slowing enemies. Beta then strafes the area 5 times for True Damage.")
                )
            ),
            Hero(
                27,
                name = "Sun",
                description = "Fighter",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_2_1_18_2/100_eb0864090b1d5307dfeba628de0d294a.png",
                skills = listOf(
                    Skill("Passive: Simian God", "Enemies hit by Sun and his Doppelgangers will have their Physical Defense reduced by 4% (stacks up to 10 times). Sun recovers HP equal to 50% of the Doppelganger's Physical Attack each time a Doppelganger deals damage."),
                    Skill("Skill 1: Endless Variety", "Sun hurls his Golden Staff in the target direction, dealing Physical Damage. Upon hitting an enemy hero/Creep or reaching max range, the Staff morphs into a Doppelganger that inherits a percentage of Sun's attributes and Attack Effects."),
                    Skill("Skill 2: Swift Exchange", "Sun hurls his Golden Staff in the target direction, dealing Physical Damage. He conjures a Doppelganger at his location, conceals himself, and moves with the Golden Staff. He reappears and retrieves the Staff when it hits an enemy or reaches max range."),
                    Skill("Ultimate: Clone Techniques", "Sun summons a Doppelganger that lasts 12 seconds and inherits up to 100% of his attributes and his Attack Effects. The Doppelganger takes increased damage.")
                )
            ),
            Hero(
                26,
                name = "Chou",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Chou%20-%20Hero261.png",
                skills = listOf(
                    Skill("Passive: Only Fast", "After travelling 5 units, Chou deals 180% damage on his next Basic Attack (cannot Crit), briefly slows the target by 80%, and reduces their Physical Defense for 3s (up to 2 stacks)."),
                    Skill("Skill 1: Jeet Kune Do", "Chou strikes in the target direction, dealing Physical Damage. This skill can be cast 3 times before it goes on cooldown. On the 3rd cast, Chou knocks enemies hit airborne. Hitting an enemy hero with the 3rd cast resets the cooldown of Shunpo."),
                    Skill("Skill 2: Shunpo", "Chou charges in the target direction gaining Control Immunity and a Physical Damage shield."),
                    Skill("Ultimate: The Way of Dragon", "Chou strikes the target enemy hero with a roundhouse kick, dealing Physical Damage and knocking them back. Cast this skill again to chase up the target, dealing massive extra Physical Damage mid-air.")
                )
            ),
            Hero(
                25,
                name = "Kagura",
                description = "Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Kagura%20-%20Hero251%20(Revamped).png",
                skills = listOf(
                    Skill("Passive: Yin Yang Gathering", "Upon retrieving the Seimei Umbrella, Kagura gains a shield, stuns nearby enemies for 0.5 seconds, and slows them by 60% for 1 second."),
                    Skill("Skill 1: Seimei Umbrella Open", "Kagura sends the Seimei Umbrella to the target location, dealing Magic Damage to enemies in its path and slowing them. The Umbrella automatically returns to her when she's too far away."),
                    Skill("Skill 2: Rasho Umbrella Flee", "With Umbrella: Kagura removes all debuffs on her and dashes in the target direction, leaving the Umbrella behind. Without Umbrella: Kagura dashes to the Umbrella's location, retrieving it and triggering her passive."),
                    Skill("Ultimate: Yin Yang Overturn", "With Umbrella: Kagura deals Magic Damage to nearby enemies, knocking them back and slowing them. Without Umbrella: She deals Magic Damage to enemies around the Umbrella and links them to it. After a delay, linked enemies are pulled to the Umbrella and take massive Magic Damage.")
                )
            ),
            Hero(
                24,
                name = "Natalia",
                description = "Assassin",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Natalia%20-%20Hero241.png",
                skills = listOf(
                    Skill("Passive: Assassin Instinct", "If Natalia stays in a bush without taking damage for 1 second, she enters Camouflage state and gains Movement Speed. Her next Basic Attack will teleport her behind her target, dealing Physical Damage and silencing them. Dealing/taking damage ends Camouflage."),
                    Skill("Skill 1: Claw Dash", "Natalia dashes in the target direction, dealing Physical Damage to enemies in her path. After hitting an enemy, she can cast this skill again within 5 seconds."),
                    Skill("Skill 2: Smoke Bomb", "Natalia releases a Smoke Bomb at her location, slowing enemies within while Natalia becomes completely immune to enemy Basic Attacks for 4 seconds."),
                    Skill("Ultimate: The Hunt", "Passive: Natalia gains extra Crit Chance. Active: Natalia immediately enters Assassin Instinct state and gains an enhanced Basic Attack. She can store up to 2 charges of this skill.")
                )
            ),
            Hero(
                23,
                name = "Gord",
                description = "Mage",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_1_9_47/100_6ba16b4ca438152a629e7706cbd7453d.png",
                skills = listOf(
                    Skill("Passive: Mystic Favor", "After Gord hits an enemy 4 times with Basic Attacks or skills within a short period of time, the next attack on the target will deal additional True Damage and slow them (the slow effect stacks up to 2 times)."),
                    Skill("Skill 1: Mystic Projectile", "Gord conjures a Mystic Orb that bounces in the target direction and explodes on the first enemy hit, dealing Magic Damage to enemies in the area, stunning them, and revealing their locations for 1 second."),
                    Skill("Skill 2: Mystic Injunction", "Gord creates an energy field in the target area, dealing continuous Magic Damage to enemies within it (up to 13 hits)."),
                    Skill("Ultimate: Mystic Gush", "Gord unleashes a massive energy beam in the target direction, dealing continuous Magic Damage to enemies hit every 0.2 seconds (up to 16 times). The direction of the beam can be slowly adjusted using the Joystick.")
                )
            ),
            Hero(
                22,
                name = "Freya",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Freya%20-%20Hero221.png",
                skills = listOf(
                    Skill("Passive: Power of Einherjar", "After casting a skill, Freya gains 200% Attack Speed for her next 2 Basic Attacks (stacks up to 6 times). Freya gains 1 stack of Sacred Orb on each Basic Attack and can spend them to cast Spirit Combo consecutively."),
                    Skill("Skill 1: Leap of Faith", "Freya jumps to the target location, dealing Physical Damage to enemies hit and pulling them towards her."),
                    Skill("Skill 2: Spirit Combo", "Freya strikes in the target direction, gaining a shield while dealing Physical Damage to enemies hit and slowing them. She can cast this skill again at the cost of 2 Sacred Orbs. On the 3rd cast, she leaps and smashes the area below, knocking enemies airborne."),
                    Skill("Ultimate: Valkyrie Descent", "Freya gains 6 stacks of Sacred Orb and enters the Valkyrie state, gaining a massive shield and extra Physical Attack. Her Basic Attacks become ranged and deal splash damage. The Valkyrie state lasts for 10 seconds.")
                )
            ),
            Hero(
                21,
                name = "Hayabusa",
                description = "Assassin",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_63cb1f44bf906b71767a000e38d8ab14.png",
                skills = listOf(
                    Skill("Passive: Ninjutsu: Trace of Shadow", "Hayabusa's attacks apply a stack of Shadow Mark on hit (up to 4 stacks). Each stack lasts 6 seconds and increases Hayabusa's damage to the enemy by 5%."),
                    Skill("Skill 1: Ninjutsu: Phantom Shuriken", "Hayabusa throws three returning shurikens in the target direction, dealing Physical Damage to enemies hit and slowing them. Enemies hit by multiple shurikens take reduced damage. Hayabusa restores energy for each non-Minion enemy hit. He also permanently gains Spell Vamp."),
                    Skill("Skill 2: Ninjutsu: Quad Shadow", "Hayabusa dashes in the target direction and releases four phantoms. The phantoms attach themselves to the first enemy hero hit, dealing Physical Damage and slowing them. Use Again: Hayabusa teleports to a phantom's location and reduces the cooldown of Phantom Shuriken."),
                    Skill("Ultimate: Ougi: Shadow Kill", "Hayabusa blends into the shadows and launches 6 single-target attacks on enemies in the area, each dealing Physical Damage. The attacks prioritize enemies with Shadow Mark and consume a mark to deal extra Physical Damage.")
                )
            ),
            Hero(
                20,
                name = "Lolita",
                description = "Support/Tank",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_55de18c865efe8e360b3b9ae463d76a2.png",
                skills = listOf(
                    Skill("Passive: Noumenon Energy Core", "Every 2.5 seconds, the Noumenon Energy Core grants a shield to Lolita and nearby allies. This shield can stack up to 6 times and lasts 30 seconds."),
                    Skill("Skill 1: Power Charge", "Lolita dashes in the target direction. Her next Basic Attack within 4 seconds will perform a short dash to the target, dealing Physical Damage and stunning them for 0.5 seconds. This damage is doubled against Minions."),
                    Skill("Skill 2: Guardian's Reflection", "Lolita raises her shield and reflects all incoming ranged Basic Attacks and Projectiles in the direction of the shield for 3 seconds. The shield breaks after taking a certain amount of damage."),
                    Skill("Ultimate: Noumenon Blast", "Lolita begins charging for 2 seconds while slowing enemies in a fan-shaped area. When charging is complete or stopped, Lolita slams her hammer on the ground, dealing Physical Damage and stunning enemies for up to 2 seconds based on charge time. Use Again: Lolita immediately stops charging and slams her hammer.")
                )
            ),
            Hero(
                19,
                name = "Minotaur",
                description = "Tank/Support",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Minotaur%20-%20Hero191.png",
                skills = listOf(
                    Skill("Passive: Rage Incarnate", "When Minotaur applies a control effect to an enemy hero with a skill, he reduces their Hybrid Defense. When he heals an allied hero with a skill, he increases their Hybrid Defense. These effects are doubled in Enraged state."),
                    Skill("Skill 1: Despair Stomp", "Minotaur jumps to the target location, dealing Physical Damage to enemies in the area and briefly knocking them airborne. Enemies hit are slowed, and his Basic Attacks are enhanced to deal extra Physical Damage. Enraged: Increases the AOE range and the damage dealt."),
                    Skill("Skill 2: Motivation Roar", "Minotaur motivates himself and nearby allied heroes, restoring HP for them and healing himself based on his lost HP. Enraged: Minotaur gains Enraged Regen for 2 seconds, restoring HP each time he's hit by a Basic Attack."),
                    Skill("Ultimate: Minoan Fury", "Minotaur enters Enraged State and smashes the ground 3 times. The first 2 hits deal Physical Damage and slow enemies, while the final hit deals True Damage and knocks targets airborne. Minotaur is immune to control effects during this attack. The Enraged state enhances his skills for 12 seconds.")
                )
            ),
            Hero(
                18,
                name = "Layla",
                description = "Marksman",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_6efe9abc2047f59d45fa1c88fb1261b7.png",
                skills = listOf(
                    Skill("Passive: Malefic Gun", "Layla deals increased damage to enemies farther away from her (starting at 100% and increasing to 130% at 6 units away). This does not include Turrets."),
                    Skill("Skill 1: Malefic Bomb", "Layla fires a Malefic Bomb in the target direction, dealing Physical Damage to the first enemy hit (can critically strike). Upon hitting an enemy, Layla's Basic Attacks and Void Projectile gain extra range for 3 seconds, and she gains Movement Speed."),
                    Skill("Skill 2: Void Projectile", "Layla fires an orb of Malefic Energy that explodes on hit, dealing Physical Damage to targets in the area and applying Magic Mark on them. When Layla hits an enemy with a Magic Mark, she deals Physical Damage to nearby enemies and stuns them for 0.25 seconds."),
                    Skill("Ultimate: Destruction Rush", "Layla fires a blast of Malefic Energy in the target direction, dealing massive Physical Damage to enemies in a line. Passive: The range of Layla's Void Projectile and Basic Attacks is increased. Her sight range is also slightly increased each time this skill is upgraded.")
                )
            ),
            Hero(
                17,
                name = "Fanny",
                description = "Assassin",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Fanny%20-%20Hero171.png",
                skills = listOf(
                    Skill("Passive: Air Superiority", "While flying, Fanny deals 10%–20% extra damage to enemies hit (scales with flying speed) and applies a stack of Prey Mark. Her subsequent skill hits on marked enemy heroes restore energy per stack."),
                    Skill("Skill 1: Tornado Strike", "Fanny whirls her blades, dealing Physical Damage to nearby enemies."),
                    Skill("Skill 2: Steel Cable", "Fanny shoots a cable in the target direction that pulls her to the first obstacle hit. She can cast this skill again within 2 seconds until her energy runs out. Fanny automatically casts Tornado Strike upon hitting an enemy mid-flight if her energy is sufficient."),
                    Skill("Ultimate: Cut Throat", "Fanny leaps at the target enemy hero or Creep with her blades, dealing massive Physical Damage. Each stack of Prey Mark on the target increases this damage by 20%.")
                )
            ),
            Hero(
                16,
                name = "Zilong",
                description = "Fighter/Assassin",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Zilong%20-%20Hero161.png",
                skills = listOf(
                    Skill("Passive: Dragon Flurry", "After every 3 Basic Attacks, Zilong triggers Dragon Flurry on the next Basic Attack, hitting the target 3 times. Each hit deals Physical Damage and heals himself."),
                    Skill("Skill 1: Spear Flip", "Zilong flings the target enemy over his head, dealing Physical Damage."),
                    Skill("Skill 2: Spear Strike", "Zilong lunges at the target enemy, dealing Physical Damage and reducing their Physical Defense for 2 seconds. He then launches a Basic Attack on the same target. The cooldown of Spear Strike is reset if Zilong kills an enemy."),
                    Skill("Ultimate: Supreme Warrior", "Zilong removes all Slow Effects on himself and gains Movement Speed, Attack Speed, and Slow Immunity for 7.5 seconds. For the duration, he can trigger Dragon Flurry after every 2 Basic Attacks.")
                )
            ),
            Hero(
                15,
                name = "Eudora",
                description = "Mage",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_2_1_42/100_1384ce93e5bdb142ea4e5e6b9f941ff1.png",
                skills = listOf(
                    Skill("Passive: Superconductor", "Eudora's skills inflict Superconductor for 3 seconds on hit, which triggers additional effects on her subsequent skills."),
                    Skill("Skill 1: Forked Lightning", "Eudora casts forked lightning, dealing Magic Damage to enemies in a fan-shaped area. Enemies affected by Superconductor will take extra Magic Damage after a short delay."),
                    Skill("Skill 2: Ball Lightning", "Eudora hurls an orb of lightning at the target enemy, dealing Magic Damage, stunning the target for 1.2 seconds, and reducing their Magic Defense. If the target is affected by Superconductor, the lightning orb will bounce to nearby enemies, dealing Magic Damage and stunning them."),
                    Skill("Ultimate: Thunder's Wrath", "Eudora calls down a blast of lightning on the target enemy, dealing massive Magic Damage. If the enemy is affected by Superconductor, dark clouds appear over their head and unleash an additional lightning strike, dealing Magic Damage to the target and nearby enemies.")
                )
            ),
            Hero(
                14,
                name = "Rafaela",
                description = "Support",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Rafaela%20-%20Hero141.png",
                skills = listOf(
                    Skill("Passive: Divine Resurrection", "At regular intervals, Rafaela can use a special skill to instantly resurrect a fallen allied hero after a brief channeling. The resurrected allied hero will respawn at the base and is granted increased Movement Speed."),
                    Skill("Skill 1: Light of Retribution", "Rafaela strikes the three nearest enemies with Light of Retribution, dealing Magic Damage, briefly revealing their positions, and slowing them. Enemies hit by this skill again within 5 seconds will take extra damage (stacks up to 3 times)."),
                    Skill("Skill 2: Holy Healing", "Rafaela calls upon Holy Light, restoring HP to nearby allied heroes, plus an additional amount to herself and the most injured allied hero in range. Also increases Movement Speed of nearby allied heroes and grants Slow Immunity for 1 second."),
                    Skill("Ultimate: Holy Baptism", "Rafaela unleashes the true power of Holy Light in the target direction, dealing Magic Damage to enemies in a line and stunning them for 1.5 seconds.")
                )
            ),
            Hero(
                13,
                name = "Clint",
                description = "Marksman",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Clint%20-%20Hero131.png",
                skills = listOf(
                    Skill("Passive: Double Shot", "After each skill cast, Clint's next Basic Attack within 4 seconds penetrates a line of enemies, dealing heavy Physical Damage. This damage can trigger attack effects, and can critically strike."),
                    Skill("Skill 1: Quick Draw", "Clint fires 5 bullets in quick succession in the target direction, each dealing Physical Damage to the enemy hit. The bullets spread evenly across a fan-shaped area. Enemies hit by multiple bullets take reduced damage after the first."),
                    Skill("Skill 2: Trapping Recoil", "Clint shoots a trap net in the target direction, slightly jumping back while dealing Physical Damage to the first enemy hit and immobilizing them. Successfully hitting an enemy reduces the cooldown of this skill by 40%."),
                    Skill("Ultimate: Grenade Bombardment", "Clint launches a grenade in the target direction that explodes on the first enemy hit, dealing Physical Damage and slowing them. Clint gains a grenade recharge over time (up to 5 charges).")
                )
            ),
            Hero(
                12,
                name = "Bruno",
                description = "Marksman",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage/100_68d7ca30f69cb691125e3f03cd782a53.png",
                skills = listOf(
                    Skill("Passive: Mecha Legs", "Bruno gains 2% extra Crit Chance each time he deals damage with his skills (up to 10 stacks). Bruno has higher Physical Attack but only gains 80% extra Attack Speed from all sources."),
                    Skill("Skill 1: Volley Shot", "Bruno kicks a Powerball on his next Basic Attack, dealing Physical Damage to the target and slowing them. The Powerball then bounces back toward Bruno and lands on the ground. He or an allied hero can retrieve the Powerball to perform another enhanced Basic Attack and reduce the cooldown of Flying Tackle."),
                    Skill("Skill 2: Flying Tackle", "Bruno makes a slide tackle in the target direction dealing Physical Damage to enemies in his path and stunning them. If the Powerball is bouncing back, Bruno draws the Powerball toward him."),
                    Skill("Ultimate: Worldie", "Bruno kicks his Energy Ball at the target enemy hero, dealing Physical Damage and knocking them back. The Energy Ball then bounces between nearby enemies up to 10 times, dealing Physical Damage and reducing their Physical Defense per hit.")
                )
            ),
            Hero(
                11,
                name = "Bane",
                description = "Fighter/Mage",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Bane%20-%20Hero111.png",
                skills = listOf(
                    Skill("Passive: Shark Bite", "Bane infuses his weapon with a stack of Tidal Energy each time he uses a skill (up to 2 stacks). Each of his subsequent Basic Attacks consumes a stack to deal Physical Damage equal to a percentage of the target's Max HP to nearby enemies."),
                    Skill("Skill 1: Crab Claw Cannon", "Bane fires his Crab Claw Cannon in the target direction, dealing Physical Damage to the first enemy hit and then increased damage to a random enemy behind them. Enemies hit are slowed by 10% for 1 second. High Physical Attack reduces this skill's cooldown."),
                    Skill("Skill 2: Ale", "Bane chugs his ale, recovering HP and gaining extra Movement Speed that decays over 2.5 seconds. Use Again: Bane spits venom in the target direction, dealing Magic Damage (scales up with charging time) to enemies in a fan-shaped area. High Magic Power reduces this skill's cooldown."),
                    Skill("Ultimate: Deadly Catch", "Bane summons a school of sharks to charge in a target direction, dealing massive Magic Damage, knocking enemies airborne for 0.8 seconds, and slowing them heavily. This skill deals 40% of damage to turrets.")
                )
            ),
            Hero(
                10,
                name = "Franco",
                description = "Tank",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Franco%20-%20Hero101.png",
                skills = listOf(
                    Skill("Passive: Wasteland Force", "If no damage is taken within 5 seconds, Franco gains 10% Movement Speed, recovers 1% Max HP per second, and begins accumulating Wasteland Force (up to 10 stacks). Franco will consume all Wasteland Force stacks on his next skill cast to increase the skill's damage by up to 150%."),
                    Skill("Skill 1: Iron Hook", "Franco launches an iron hook in the target direction. The hook will snag the first enemy unit hit, dealing Physical Damage dragging them to Franco."),
                    Skill("Skill 2: Fury Shock", "Franco lashes out, dealing Physical Damage equal to a base amount plus 4% of his Max HP to nearby enemies and slowing them by 70% for 1.5 seconds."),
                    Skill("Ultimate: Bloody Hunt", "Franco suppresses the target enemy hero for 1.8 seconds and strikes them 6 times over the duration, each time dealing Physical Damage.")
                )
            ),
            Hero(
                id = 9,
                name = "Akai",
                description = "Tank",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Akai%20-%20Hero091.png",
                skills = listOf(
                    Skill("Passive: Tai Chi", "Akai gains a shield based on his Total HP for 4 seconds on each skill cast and can mark enemy heroes and Creeps hit by his skills. Akai's Basic Attacks deal extra Physical Damage to marked enemies."),
                    Skill("Skill 1: Headbutt", "Akai charges in the target direction, dealing Physical Damage to enemies along the away. If Akai hits an enemy hero during this process, he'll knock them airborne for 0.5 seconds and be able to roll in the Joystick's direction once. Akai can cast Headbutt during Heavy Spin to adjust his position."),
                    Skill("Skill 2: Body Slam", "Akai smashes the ground with his body, dealing Physical Damage to nearby enemies based on his Total HP and slowing them by 45% for 2 seconds."),
                    Skill("Ultimate: Heavy Spin", "Akai removes all debuffs on him and spins for 4 seconds, gaining Slow Immunity while continuously dealing Physical Damage to nearby enemies and knocking them back. Enemies heroes knocked back will knock back other heroes they collide with. Akai also gradually increases his Movement Speed over the duration.")
                )
            ),
            Hero(
                id = 8,
                name = "Karina",
                description = "Assassin",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Karina%20-%20Hero081.png",
                skills = listOf(
                    Skill("Passive: Shadow Combo", "Karina's third consecutive attack on the same enemy deals extra True Damage based on their lost HP. If the target is an enemy hero, the cooldowns of Karina's non-Ultimate skills are reduced by 1.5 seconds."),
                    Skill("Skill 1: Dance of Blades", "Karina enters the Dance of Blades state for 3.5 seconds, gaining extra Movement Speed, blocking all incoming Basic Attacks, and reflecting Magic Damage back to the attacker. Her next Basic Attack deals Magic Damage, slows the target, and is a guaranteed critical strike."),
                    Skill("Skill 2: Dance of Death", "Karina launches a spinning slash, dealing heavy Magic Damage to nearby enemies."),
                    Skill("Ultimate: Shadow Assault", "Karina dashes to the target enemy hero, dealing Magic Damage, applying a Shadow Mark to them, and leaving a Shadowform behind them. If the enemy dies within the duration, the cooldown of this skill is reset. Use Again: Karina dashes back to the Shadowform's location, dealing Magic Damage along the way.")
                )
            ),
            Hero(
                id = 7,
                name = "Alucard",
                description = "Fighter/Assassin",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Alucard%20-%20Hero071.png",
                skills = listOf(
                    Skill("Passive: Pursuit", "After each skill cast, Alucard's next Basic Attack allows him to dash to the target's location and deal extra Physical Damage."),
                    Skill("Skill 1: Groundsplitter", "Alucard rolls to the target location and slams his blade on the ground, dealing Physical Damage to enemies hit and slowing them by 40% for 2 seconds."),
                    Skill("Skill 2: Whirling Smash", "Alucard launches a whirling slash, dealing Physical Damage to nearby enemies."),
                    Skill("Ultimate: Fission Wave", "Passive: Alucard permanently gains extra Hybrid Lifesteal. Active: Alucard absorbs the energy of enemies in the target area, reducing their Movement Speed and Hybrid Defense. He gains Defense per enemy hero hit and reduces his other skill cooldowns for 6 seconds. Use Again: He releases a shockwave, dealing massive Physical Damage.")
                )
            ),
            Hero(
                id = 6,
                name = "Tigreal",
                description = "Tank",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Tigreal%20-%20Hero061.png",
                skills = listOf(
                    Skill("Passive: Fearless", "Tigreal gains a stack of Fearless each time he casts a skill or is hit by a Basic Attack. After getting 4 stacks, Tigreal will consume all Fearless stacks to block the next incoming Basic Attack (including attacks from turrets)."),
                    Skill("Skill 1: Attack Wave", "Tigreal smashes the ground with his hammer and sends a shockwave forward that erupts 3 times, each time dealing Physical Damage to enemies along the fan-shaped area and slowing them for 1.5 seconds."),
                    Skill("Skill 2: Sacred Hammer", "Tigreal charges in a target direction, dealing Physical Damage to enemies along the way and pushing them to the end of the charge. Use Again: Tigreal can cast this skill again within 4 seconds, dealing Physical Damage to enemies in front of him and knocking them airborne for 1 second."),
                    Skill("Ultimate: Implosion", "Tigreal unleashes the power of his hammer, stunning and pulling nearby enemies to him for 2 seconds while dealing Physical Damage. The first half of the channeling can be interrupted by control effects, the second part cannot.")
                )
            ),
            Hero(
                id = 5,
                name = "Nana",
                description = "Mage/Support",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Nana%20-%20Hero051.png",
                skills = listOf(
                    Skill("Passive: Molina's Gift", "Upon taking fatal damage, Nana removes all debuffs on her and transforms, becoming untargetable and invincible, and gains 70% Movement Speed for 2 seconds. She also recovers 10% Max HP over the duration. Can only transform once every 150 seconds."),
                    Skill("Skill 1: Magic Boomerang", "Nana hurls her Magical Boomerang in the target direction, dealing Magic Damage to enemies hit on its way out and back. The damage is reduced for each additional enemy hit."),
                    Skill("Skill 2: Molina Smooch", "Nana summons Molina at the target location. Molina will chase the nearest enemy hero, dealing Magic Damage and transforming them for 1.5 seconds. The target is also slowed and their Magic Defense is reduced."),
                    Skill("Ultimate: Molina Blitz", "Nana summons Molina to strike the target area 3 times, each time dealing heavy Magic Damage to enemies within the area and slowing them. Enemies hit consecutively will be stunned for 1 second.")
                )
            ),
            Hero(
                id = 4,
                name = "Alice",
                description = "Mage/Tank",
                photoUrl = "https://akmweb.youngjoygame.com/web/svnres/img/mlbb/homepage_2_1_18/100_ec3d5c825e893947a235ea9ea59fff77.png",
                skills = listOf(
                    Skill("Passive: Crimson Blood Banquet", "When Alice's skills hit, she gains stacks of Crimson. Once Crimson reaches 2 stacks, Blood Banquet activates, dealing Magic Damage based on the target's Max HP to nearby enemies and recovering HP for Alice every 0.5 seconds."),
                    Skill("Skill 1: Crimson Gleam", "Alice fires blood energy forward, dealing Magic Damage. Before the blood energy dissipates, this skill can be cast again to activate Scarlet Shadow, allowing Alice to blink to the blood energy's location."),
                    Skill("Skill 2: Doom Waltz", "Alice performs a deadly dance, dealing Magic Damage to nearby enemies and slowing them by 70% for 1 second. If Blood Banquet is active, it also scorches enemies, dealing extra damage and healing Alice."),
                    Skill("Ultimate: Throne of Ruin", "Alice surrounds herself with blood, gaining Control Immunity and 50% Damage Reduction while slowing herself by 50%. After 1.5 seconds, she descends with force, dealing massive Magic Damage to all enemies in range and immobilizing them.")
                )
            ),
            Hero(
                id = 3,
                name = "Saber",
                description = "Assassin",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Saber%20-%20Hero031.png",
                skills = listOf(
                    Skill("Passive: Enemy's Bane", "Saber's attacks reduce enemies' Physical Defense for 5 seconds on hit. This effect stacks up to 5 times."),
                    Skill("Skill 1: Orbiting Swords", "Saber shoots out 5 swords that orbit around him, dealing Physical Damage to enemies. Using Basic Attacks or skills will launch one of the swords at the target."),
                    Skill("Skill 2: Charge", "Saber dashes in the target direction, dealing Physical Damage to enemies along the way while enhancing his next Basic Attack to deal extra damage and slow the target by 60%."),
                    Skill("Ultimate: Triple Sweep", "Saber charges at the target enemy hero, knocking them airborne for 1.2 seconds and striking them 3 times over the duration. The first two strikes deal Physical Damage, while the third strike deals massive Physical Damage.")
                )
            ),
            Hero(
                id = 2,
                name = "Balmond",
                description = "Fighter",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Balmond%20-%20Hero021.png",
                skills = listOf(
                    Skill("Passive: Bloodthirst", "Balmond recovers 5% Max HP after killing a Minion or Creep, and 20% Max HP after killing a hero."),
                    Skill("Skill 1: Soul Lock", "Balmond charges to the target direction for a set distance or until he hits an enemy hero, dealing Physical Damage to enemies along the way. The enemy hero hit will be knocked back slightly and slowed by 60% for 2 seconds."),
                    Skill("Skill 2: Cyclone Sweep", "Balmond gains 15% Movement Speed and spins his axe for 3 seconds, dealing continuous Physical Damage to nearby enemies. Each subsequent hit on the same enemy will deal 7.5% increased damage (up to 60%)."),
                    Skill("Ultimate: Lethal Counter", "Balmond unleashes a huge strike in the target direction (cannot be interrupted), dealing True Damage based on a flat amount plus a percentage of the target's Lost HP. Deals capped damage to non-hero units.")
                )
            ),
            Hero(
                id = 1,
                name = "Miya",
                description = "Marksman",
                photoUrl = "https://github.com/Lara3924/Lara_Image/raw/main/Miya%20-%20Hero011.png",
                skills = listOf(
                    Skill("Passive: Moon Blessing", "Each time Miya hits a target with her Basic Attack, she gains 5% Attack Speed for 4 seconds (stacks up to 5 times). After reaching full stacks, Miya summons a Moonlight Shadow with each Basic Attack that deals Physical Damage."),
                    Skill("Skill 1: Moon Arrow", "Miya shoots two extra arrows with each Basic Attack, dealing Physical Damage to the target enemy and 30% damage to nearby targets. This effect lasts 4 seconds."),
                    Skill("Skill 2: Arrow of Eclipse", "Miya launches an empowered arrow on the target area, dealing Physical Damage to enemies within and immobilizing them for 1.2 seconds. The arrow then splits into 6 scattering minor arrows, dealing damage and slowing the first enemy hit."),
                    Skill("Ultimate: Hidden Moonlight", "Miya removes all debuffs on her and conceals herself, gaining 35%–65% extra Movement Speed. This state lasts 2 seconds or until she launches an attack. Miya gains full stacks of Moon Blessing upon leaving the state.")
                )
            )
        )
    }
}