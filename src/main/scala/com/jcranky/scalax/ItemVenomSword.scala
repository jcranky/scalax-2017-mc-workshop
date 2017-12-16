package com.jcranky.scalax

import com.easyforger.items.EFItemSword
import net.minecraft.entity.EntityLivingBase
import net.minecraft.init.MobEffects
import net.minecraft.item.Item.ToolMaterial
import net.minecraft.item.ItemStack
import net.minecraft.potion.PotionEffect

class ItemVenomSword(modId: String) extends EFItemSword(modId, "venomsword", ToolMaterial.IRON) {
  override def hitEntity(stack: ItemStack, target: EntityLivingBase, attacker: EntityLivingBase): Boolean = {
    target.addPotionEffect(new PotionEffect(MobEffects.POISON, 3 * 20, 3, false, true))
    super.hitEntity(stack, target, attacker)
  }
}
