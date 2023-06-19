package net.galiev.megaparkour.parkour

import kotlinx.serialization.Serializable
import net.galiev.megaparkour.config.ConfigManager.read
import net.minecraft.entity.SpawnRestriction.Location

@Serializable
class Parkour(
        private var name: String,
        private var author: String = "unknown",
        private var active: Boolean = false,
        private var waterRespawn: Boolean = true,
        private var lavaRespawn: Boolean = true,
        private var voidRespawn: Boolean = true,
        private var respawnAtCheckpoint: Boolean = true) {

    lateinit var spawn: Location
    lateinit var best: Location
    private var checkpoints: ArrayList<Location> = ArrayList()

    fun getName(): String = name

    fun setName(oldName: String, newName: String) {
        read().parkours.find { it.name == oldName }?.name = newName
    }

    fun getAuthor(): String = author

    fun setAuthor(parkourName: String, newAuthor: String) {
        read().parkours.find { it.name == parkourName }?.author = newAuthor
    }

    fun isActive(): Boolean = active

    fun setActive(parkourName: String, value: Boolean) {
        read().parkours.find { it.name == parkourName }?.active = value
    }

    fun getCheckpoints(): ArrayList<Location> = checkpoints

    fun deleteLastCheckpoint(): Boolean {
        val lastCheckpoint = checkpoints.last()

        read().parkours.find { it.name == name }?.checkpoints?.remove(lastCheckpoint)

        return true
    }
}