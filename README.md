
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

* Invent some other new recipes as you wish.

### 7

### 8

### 9

### 10

### 11

### 12

### 13

### 14

### 15
