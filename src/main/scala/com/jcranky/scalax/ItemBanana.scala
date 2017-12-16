package com.jcranky.scalax

import com.easyforger.items.EFItemFood
import net.minecraft.init.MobEffects
import net.minecraft.potion.PotionEffect

class ItemBanana(modId: String) extends EFItemFood(modId, "banana", 5, 0.4f, false) {
  setPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 9 * 20, 1), 1f)
  addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 5 * 20, 0), 0.5f)
}
