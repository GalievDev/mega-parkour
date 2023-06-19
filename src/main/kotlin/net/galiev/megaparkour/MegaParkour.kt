package net.galiev.megaparkour

import net.fabricmc.api.ModInitializer
import net.galiev.megaparkour.config.ConfigManager
import net.galiev.megaparkour.parkour.Parkour
import org.slf4j.LoggerFactory

object MegaParkour : ModInitializer {
    private val logger = LoggerFactory.getLogger("mega-parkour")

	override fun onInitialize() {
		ConfigManager
	}
}