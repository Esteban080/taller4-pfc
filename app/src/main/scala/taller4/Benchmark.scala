package taller4

import org.scalameter.measure
import org.scalameter.withWarmer
import org.scalameter.Warmer

import scala.collection.parallel.immutable.ParVector
import scala.util.Random


class Benchmark {
  val opm = new Clase1()
  type Matriz = Vector[Vector[Int]]

  def CompararAlgoritmos(Funcion1: (Matriz, Matriz) => Matriz, Funcion2: (Matriz, Matriz) => Matriz)(m1: Matriz, m2: Matriz): (Double, Double, Double) = {
    val timeF1 = withWarmer(new Warmer.Default) measure {
      Funcion1(m1, m2)
    }
    val timeF2 = withWarmer(new Warmer.Default) measure {
      Funcion2(m1, m2)
    }

    val aceleracion = timeF1.value / timeF2.value
    (timeF1.value, timeF2.value, aceleracion)
  }


  def CompararProdPunto(Funcion1: (Vector[Int], Vector[Int]) => Int, Funcion2: (ParVector[Int], ParVector[Int]) => Int)(v1: Vector[Int], v2: Vector[Int], v3: ParVector[Int], v4: ParVector[Int]): (Double, Double, Double) = {
    val timeseq = withWarmer(new Warmer.Default) measure {
      Funcion1(v1, v2)
    }
    val timepar = withWarmer(new Warmer.Default) measure {
      Funcion2(v3, v4)
    }

    val aceleracion = timeseq.value / timepar.value
    (timeseq.value, timepar.value, aceleracion)

  }

}
