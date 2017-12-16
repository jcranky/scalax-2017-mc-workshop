package com.jcranky.scalax

import com.easyforger.blocks.EFBlock
import net.minecraft.block.SoundType
import net.minecraft.block.material.Material
import net.minecraft.init.Items

class BlockCloth(modId: String) extends EFBlock(modId, "clothblock", Material.CLOTH) {
  setHardness(0.5f)
  setResistance(1.0f)
  setSoundType(SoundType.WOOD)

  dropItem = Items.BOOK
  quantityDropped = 3
}
