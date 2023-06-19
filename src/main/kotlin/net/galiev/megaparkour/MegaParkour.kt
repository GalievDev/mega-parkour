package net.galiev.megaparkour

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.galiev.megaparkour.command.AdminCommands
import net.galiev.megaparkour.config.ConfigManager
import org.slf4j.LoggerFactory

object MegaParkour : ModInitializer {
    private val logger = LoggerFactory.getLogger("mega-parkour")

	override fun onInitialize() {
		ConfigManager
		CommandRegistrationCallback.EVENT.register(CommandRegistrationCallback { dispatcher, _, _ ->  AdminCommands.register(dispatcher)})
	}
}