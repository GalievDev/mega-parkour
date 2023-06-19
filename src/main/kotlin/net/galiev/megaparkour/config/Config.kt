package net.galiev.megaparkour.config

import kotlinx.serialization.Serializable
import net.galiev.megaparkour.parkour.Parkour

@Serializable
data class Config(
        val mod: String = "Mega Parkour Fabric",
        val parkours: MutableList<Parkour> = mutableListOf()
)