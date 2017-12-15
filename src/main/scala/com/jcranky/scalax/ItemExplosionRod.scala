package com.jcranky.scalax

import com.easyforger.items.EFItem
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.EntityLivingBase
import net.minecraft.item.ItemStack

class ItemExplosionRod(modId: String) extends EFItem(modId, "explosionrod") {
  setCreativeTab(CreativeTabs.MISC)

  override def onEntitySwing(entity: EntityLivingBase, stack: ItemStack): Boolean = {
    val target = entity.rayTrace(100, 1f)

    entity.world.createExplosion(
      entity, target.getBlockPos.getX, target.getBlockPos.getY, target.getBlockPos.getZ, 4f, true)

    false
  }
}
