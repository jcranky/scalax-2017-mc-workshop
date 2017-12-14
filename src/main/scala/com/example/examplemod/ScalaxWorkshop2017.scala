package com.example.examplemod

import com.easyforger.base.EasyForger
import net.minecraft.init.Items
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(modid = ScalaxWorkshop2017.modId, name = "Scalax Workshop 2017 Mod", version = "0.6", modLanguage = "scala")
object ScalaxWorkshop2017 extends EasyForger {
  final val modId = "scalax-workshop-2017-mod"

  @EventHandler
  def init(event: FMLInitializationEvent): Unit = {
    println("Scalax Workshop 2017 Mod is running!")

    creatures( this,
      creeper(
        explosionRadius = 100
      ),
      zombie(
        common(
          heldItemMainHand = Items.DIAMOND_SWORD,
          dropJson = s"$modId:entities/ef_zombie"
        )
      ),
      skeleton(
        common(
          heldItemOffHand = Items.STONE_SWORD,
          dropJson = s"$modId:entities/ef_skeleton"
        )
      )
    )

    crafting(
      Items.COAL to Items.DIAMOND withShape(
        """
          |.cc
          |..c
          |...
        """.stripMargin
      )
    )

    smelting(
      Items.APPLE to Items.CAKE
    )
  }
}
