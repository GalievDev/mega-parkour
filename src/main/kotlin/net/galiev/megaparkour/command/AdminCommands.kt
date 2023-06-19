package net.galiev.megaparkour.command

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import net.galiev.megaparkour.config.ConfigManager.write
import net.galiev.megaparkour.parkour.Parkour
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource

object AdminCommands {
    fun register(dispatcher: CommandDispatcher<ServerCommandSource>) {
        dispatcher.register(
            CommandManager.literal("pk")
                .then(CommandManager.literal("new").executes{newParkour(it)})
        )
    }

    private fun newParkour(context: CommandContext<ServerCommandSource>): Int {
        val parkour = Parkour("Galiev", "Gnida")
        write(parkour)

        return 1
    }

}