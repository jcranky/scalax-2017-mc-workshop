
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

### 5

### 6

### 7

### 8

### 9

### 10

### 11

### 12

### 13

### 14

### 15
