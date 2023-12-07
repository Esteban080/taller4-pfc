package taller4

import org.scalameter.measure
import org.scalameter.withWarmer
import org.scalameter.Warmer

import scala.collection.parallel.immutable.ParVector
import scala.util.Random


class Benchmark {
  val opm = new AlgoritmoMatriz()
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
  def tiemposAlgoritmos(tamMatriz: Int): Vector[Double] = {

    println("Longitud de la matriz: " + tamMatriz)

    val m1 = opm.matrizAlAzar(tamMatriz, 2)
    val m2 = opm.matrizAlAzar(tamMatriz, 2)

    val tiempoMultiMatriz = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
      val time = withWarmer(new Warmer.Default) measure {
        opm.multMatriz(m1, m2)
      }
      tiempoMultiMatriz(i) = time.value
    }

    val tiempoMultiMatrizPar = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
      val time = withWarmer(new Warmer.Default) measure {
        opm.multMatrizParalelo(m1, m2)
      }
      tiempoMultiMatrizPar(i) = time.value
    }

    val tiempoMultiMatrizRec = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
      val time = withWarmer(new Warmer.Default) measure {
        opm.multMatrizRec(m1, m2)
      }
      tiempoMultiMatrizRec(i) = time.value
    }

    val tiempoMultiMatrizRecPar = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
      val time = withWarmer(new Warmer.Default) measure {
        opm.multMatrizrecPar(m1, m2)
      }
      tiempoMultiMatrizRecPar(i) = time.value
    }

    val tiempoMultiStrassen = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
      val time = withWarmer(new Warmer.Default) measure {
        opm.multStrassen(m1, m2)
      }
      tiempoMultiStrassen(i) = time.value
    }

    val tiempoMultStrassenPar = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
      val time = withWarmer(new Warmer.Default) measure {
        opm.multStrassenPar(m1, m2)
      }
      tiempoMultStrassenPar(i) = time.value
    }
    Vector( tiempoMultiMatriz.sum / 100, tiempoMultiMatrizPar.sum / 100, tiempoMultiMatrizRec.sum / 100, tiempoMultiMatrizRecPar.sum
      / 100, tiempoMultiStrassen.sum / 100, tiempoMultStrassenPar.sum / 100)
  }
  def tiempoMatricesMultMatriz(): Unit = {
    val resultados = for {
      i <- 1 to 5
      size = math.pow(2, i).toInt
      m1 = opm.matrizAlAzar(size, 2)
      m2 = opm.matrizAlAzar(size, 2)
    } yield CompararAlgoritmos(opm.multMatriz, opm.multMatrizParalelo)(m1, m2)

    resultados.foreach(println)
  }
  def tiempoMatricesMultMatrizRec(): Unit = {
    val resultados = for {
      i <- 1 to 5
      size = math.pow(2, i).toInt
      m1 = opm.matrizAlAzar(size, 2)
      m2 = opm.matrizAlAzar(size, 2)
    } yield CompararAlgoritmos(opm.multMatrizRec, opm.multMatrizrecPar)(m1, m2)

    resultados.foreach(println)
  }
  def tiempoMatricesMultMatrizStrassen(): Unit = {
    val resultados = for {
      i <- 1 to 5
      size = math.pow(2, i).toInt
      m1 = opm.matrizAlAzar(size, 2)
      m2 = opm.matrizAlAzar(size, 2)
    } yield CompararAlgoritmos(opm.multStrassen, opm.multStrassenPar)(m1, m2)

    resultados.foreach(println)
  }

}
