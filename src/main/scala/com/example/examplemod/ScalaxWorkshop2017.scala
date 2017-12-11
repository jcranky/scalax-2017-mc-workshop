package com.example.examplemod

import com.easyforger.base.EasyForger
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
      )
    )
  }
}
