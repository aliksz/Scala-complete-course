package lectures.collections.visualization

import reftree.render._
import reftree.diagram._
import java.nio.file.Paths

object CollectionVisualization extends App {

  val renderer = Renderer(
    renderingOptions = RenderingOptions(density = 75),
    directory = Paths.get("q")
  ).tweakAnimation(_.withOnionSkinLayers(3))

  val a = Animation
    .startWith(List(1))
    .iterate(_ :+ 2, _ :+ 3, _ :+ 4)
    .iterate(_.filter(_%2 == 0))
    .build()

  val b = Animation
    .startWith(List(1))
    .iterate(2 :: _, 3 :: _, 4 :: _)
    .iterate(_.filter(_%2 == 0))
    .build()


  val d = Animation
    .startWith(Vector(1,2,3,5,6,7,8))
    .iterate(_ :+ 2)
    .build()

  val c = a + b + d

  renderer.render("list-append", c )

}
