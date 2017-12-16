
# Scala eXchange 2017 Workshop

### Follow the setup steps at [EasyForger setup](https://github.com/easyforger/easyforger/blob/master/doc/setup.md).

* While waiting for the setup to complete, understand the environment a bit.

* Read the name of the tasks being run by gradle, they give a good idea of what is happening.

### Follow the first mod steps at [Your first mod](https://github.com/easyforger/easyforger/blob/master/doc/first-mod.md).

* Run minecraft.

* Create a new world in creative mode.

* Test the new EFCreeper explosion.

* You can compare the explosion radius by exploding a normal Creeper.

### Add a custom held item for zombies

* Not all items can be held, experiment!

```scala
  zombie(
    common(
      heldItemMainHand = Items.DIAMOND_SWORD
    )
  )
```

* Now make the skeleton hold something.

### Configure the items dropped by the Skeleton

* Copy the json files to the proper asset location.

Json file: [Skeleton Drop Json](resources/ef_skeleton.json)

Copy to folder: `src/main/resources/assets/$mod_id/loot_tables/entities`

* Setup our skeleton to use that drop definition:

```scala
dropJson = s"$modId:entities/ef_skeleton"
```
* Do the same for the zombie.

### Create a new custom smelting recipe

* Run the game and try our some existing smelting recipes in the _Furnace_, to understand the game mechanics around that:
  * Grab a bunch of _Raw Porkchops_, put them in the _Furnace_;
  * Grab some _Coal_ and also put them in the _Furnace_;
  * Try out some other recipes (https://www.minecraftcraftingguide.net/smelting-guide/).

* Create a new smelting recipe to smelt an apple into a cake:

```scala
smelting(
  Items.APPLE to Items.CAKE
)
```

### Create a new custom crafting recipe

* Run the game and try out some existing recipes in the _Crafting Table_, to understand the game mechanics around that:
  * Break a _coal block_ into individual coal pieces;
  * Create a _diamond sword_;
  * Explore other recipes a bit: https://www.minecraftcraftingguide.net/ (or google for other guides).

* Create a new crafting recipe to turn coal into diamond:

```scala
crafting(
  Items.COAL to Items.DIAMOND
)
```

* Change the recipe to be a shaped recipe:

```scala
crafting(
  Items.COAL to Items.DIAMOND withShape(
    """
      |.cc
      |..c
      |...
    """.stripMargin
  )
)
```

* Create some other new recipes as you wish.

### Create a new custom Item: Explosion Rod

* Create a new class for the item:

```scala
class ItemExplosionRod(modId: String) extends EFItem(modId, "explosionrod") {
}
```

* Set the creative tab we will use to find the item inside the game:

```scala
setCreativeTab(CreativeTabs.MISC)
```

* Create the event handling that will trigger the explosion:

```scala
override def onEntitySwing(entity: EntityLivingBase, stack: ItemStack): Boolean = {
}
```

* Implement the explosion logic:

```scala
val target = entity.rayTrace(100, 1f)
    
entity.world.createExplosion(
  entity, target.getBlockPos.getX, target.getBlockPos.getY, target.getBlockPos.getZ, 4f, true)

false
```

* Instantiate the new item:

```scala
val explosionRod = new ItemExplosionRod(modId)
```

* Inside `init`, register your item:

```scala
explosionRod.register()
```

* Open the game and test the rod.

* Missing texture! Copy the texture file:

Texture file: [Explosion Rod Texture](resources/explosionrod.png)

Copy to folder: `src/main/resources/assets/$mod_id/textures/items`

* Also copy the json texture model:
  * double check the model id inside the file

Texture model: [Explosion Rod Texture Model](resources/explosionrod.json)

Copy to folder: `src/main/resources/assets/$mod_id/models/item`

* Test it again!

* Add a proper name to the item, copying the i18n file:

i18n file: [i18n file](resources/en_US.lang)

Copy to folder: `src/main/resources/assets/$mod_id/lang`

* Add a custom recipe to allow creating an _Explosion Rod_ with the crafting table.

### Create a new Item, a Banana

* Create the new item class:

```scala
class ItemBanana(modId: String) extends EFItemFood(modId, "banana", 5, 0.4f, false) {
}
```

* Add two potion effects to the item:

```scala
setPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 9 * 20, 1), 1f)
addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 5 * 20, 0), 0.5f)
```

* Copy the texture and texture model files to the assets folder:

Copy files: [Banana texture](resources/banana.png) and [Banana model json](resources/banana.json)

Note: don't forget to double check the mod id in the model json.

* Instantiate the new item:

```scala
val banana = new ItemBanana(modId)
```

* In the `init` method, register the new item:

```scala
banana.register()
```

* Start the game and test the new item.

### Create a new Sword

* Create the class for the Sword:

```scala
class ItemVenomSword(modId: String) extends EFItemSword(modId, "venomsword", ToolMaterial.IRON) {
}
```

* Add the custom logic to run when hitting an enemy:

```scala
override def hitEntity(stack: ItemStack, target: EntityLivingBase, attacker: EntityLivingBase): Boolean = {
  target.addPotionEffect(new PotionEffect(MobEffects.POISON, 3 * 20, 1, false, true))
  super.hitEntity(stack, target, attacker)
}
```

* Copy the texture and the texture model files:

Copy files: [Sword texture](resources/venomsword.png) and [Sword model json](resources/venomsword.png).

* Instantiate the item:

```scala
val venomSword = new ItemVenomSword(modId)
```

* And in the `init` method, register the item:

```scala
venomSword.register()
```

* Open the game and test it!

* Sad news: potion effect if not being correct applied at this moment, bug?

### Create a new Block:

* Create the class for the block and set it up:

```scala
class BlockCloth(modId: String) extends EFBlock(modId, "clothblock", Material.CLOTH) {
  setHardness(0.5f)
  setResistance(1.0f)
  setSoundType(SoundType.WOOD)

  dropItem = Items.BOOK
  quantityDropped = 3
}
```

* Copy the block texture file:

Copy file: [Block texture](resources/clothblock.png)

To folder: [Block textures folder](src/main/resources/assets/$mod_id/textures/blocks)

* Copy the model json files:

Copy item json model: [Block item json](resources/clothblock.json)

To Folder: [Block item model folder](src/main/resources/assets/$mod_id/models/item)

Copy Block json model: [Block model](resources/clothblock_model.json)

To Folder: [Block model folder](src/main/resources/assets/$mod_id/models/block)

Copy Block states model: [Block model](resources/states/clothblock.json)

To Folder: [Block states folder](src/main/resources/assets/$mod_id/blockstates)

Note: double check the mod id in all json files!

* Instantiate the block:

```scala
val cloth = new BlockCloth(modId)
```

* Register the block and add a recipe to create it:

```scala
cloth.register()
crafting(
  Items.STRING to cloth withShape
    """
      |sss
      |s.s
      |sss
    """.stripMargin
)
```

* Open the game and test it!
