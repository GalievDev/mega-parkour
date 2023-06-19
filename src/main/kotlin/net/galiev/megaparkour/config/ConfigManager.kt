package net.galiev.megaparkour.config

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import java.io.File
import java.nio.file.Paths

object ConfigManager {
    private val json = Json { encodeDefaults = true; prettyPrint = true; ignoreUnknownKeys = true }
    private val configDir: File = Paths.get("", "config").toFile()
    private val configFile = File(configDir, "mega-parkour.json")

    init {
        if (!configFile.exists()) {
            if (!configDir.exists()) configDir.mkdir()
            configFile.apply {
                createNewFile()
                writeText(json.encodeToJsonElement(Config()).toString())
            }
        } else configFile.writeText(json.encodeToJsonElement(read()).toString())
    }

    fun read(): Config {
        return json.decodeFromString(configFile.readText())
    }
}