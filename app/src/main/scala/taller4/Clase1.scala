package taller4

import common._


import scala.util.Random
import scala.collection.parallel.immutable.ParVector

class Clase1 {

  type Matriz = Vector[Vector[Int]]

  def matrizAlAzar(long: Int, vals: Int): Matriz = {
    val v = Vector.fill(long, long) {
      Random.nextInt(vals)
    }
    v
  }

  def vectorAlAzar(long: Int, vals: Int): Vector[Int]
  = {
    val v = Vector.fill(long) {
      Random.nextInt(vals)
    }
    v
  }

  def parVectorAlAzar(long: Int, vals: Int): ParVector[Int]
  = {
    val v = ParVector.fill(long) {
      Random.nextInt(vals)
    }
    v
  }

  def prodPunto(v1: Vector[Int], v2: Vector[Int]): Int = {
    (v1 zip v2).map({
      case (i, j)
      => i * j
    }).sum
  }

  def transpuesta(m: Matriz): Matriz = {
    val l = m.length
    Vector.tabulate(l, l)((i, j) => m(j)(i))
  }

  def multMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val l1 = m1.length
    val l2 = m2.length
    val m2t = transpuesta(m2)
    val m3: Matriz = Vector.tabulate(l1, l2)((i, j) => prodPunto(m1(i), m2t(j)))
    m3
  }

  def multMatrizParalelo(m1: Matriz, m2: Matriz): Matriz = {
    val longitud = m1.length
    val (parte1_m1, parte2_m1) = m1.splitAt(longitud / 2)
    val (multmatriz1, multmatriz2) = parallel(
      multMatriz(parte1_m1, m2),
      multMatriz(parte2_m1, m2)
    )
    multmatriz1 ++ multmatriz2
  }

  def subMatriz(m: Matriz, i: Int, j: Int, l: Int): Matriz = {
    if (i >= 0 && j >= 0 && (i + l) <= m.length && (j + l) <= m(0).length) {
      Vector.tabulate(l, l) { (fila, columna) => m(i + fila)(j + columna) }
    } else {
      Vector.empty
    }
  }

  def sumMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val filas = m1.length
    val columnas = m2.length
    Vector.tabulate(filas, columnas) { (i, j) => m1(i)(j) + m2(i)(j) }

  }

  def multMatrizRec(m1: Matriz, m2: Matriz): Matriz = {
    val n = m1.length
    if (n == 1) {
      multMatriz(m1, m2)
    } else {
      val indice = n/2

      val A11 = subMatriz(m1, 0, 0, indice)
      val A12 = subMatriz(m1, 0, indice, indice)
      val A21 = subMatriz(m1, indice, 0, indice)
      val A22 = subMatriz(m1, indice, indice, indice)

      val B11 = subMatriz(m2, 0, 0, indice)
      val B12 = subMatriz(m2, 0, indice, indice)
      val B21 = subMatriz(m2, indice, 0, indice)
      val B22 = subMatriz(m2, indice, indice, indice)

      val C11 = sumMatriz(multMatrizRec(A11, B11), multMatrizRec(A12, B21))
      val C12 = sumMatriz(multMatrizRec(A11, B12), multMatrizRec(A12, B22))
      val C21 = sumMatriz(multMatrizRec(A21, B11), multMatrizRec(A22, B21))
      val C22 = sumMatriz(multMatrizRec(A21, B12), multMatrizRec(A22, B22))

      Vector.tabulate(2 * indice, 2 * indice) { (i, j) =>
        if (i < indice && j < indice) C11(i)(j)
        else if (i < indice && j >= indice) C12(i)(j - indice)
        else if (i >= indice && j < indice) C21(i - indice)(j)
        else C22(i - indice)(j - indice)
      }
    }
  }

  def multMatrizrecPar(m1: Matriz, m2: Matriz): Matriz = {
    if (m1.length == 1) {
      multMatriz(m1, m2)
    } else {

      val indice = m1.length / 2

      val A11 = subMatriz(m1, 0, 0, indice)
      val A12 = subMatriz(m1, 0, indice, indice)
      val A21 = subMatriz(m1, indice, 0, indice)
      val A22 = subMatriz(m1, indice, indice, indice)

      val B11 = subMatriz(m2, 0, 0, indice)
      val B12 = subMatriz(m2, 0, indice, indice)
      val B21 = subMatriz(m2, indice, 0, indice)
      val B22 = subMatriz(m2, indice, indice, indice)

      val P1 = task(multMatrizrecPar(A11, B11))
      val P2 = task(multMatrizrecPar(A12, B21))
      val P3 = task(multMatrizrecPar(A11, B12))
      val P4 = task(multMatrizrecPar(A12, B22))
      val P5 = task(multMatrizrecPar(A21, B11))
      val P6 = task(multMatrizrecPar(A22, B21))
      val P7 = task(multMatrizrecPar(A21, B12))
      val P8 = task(multMatrizrecPar(A22, B22))

      val C11 = sumMatriz(P1.join(), P2.join())
      val C12 = sumMatriz(P3.join(), P4.join())
      val C21 = sumMatriz(P5.join(), P6.join())
      val C22 = sumMatriz(P7.join(), P8.join())

      val m3 = Vector.tabulate(2 * indice, 2 * indice) { (i, j) =>
        if (i < indice && j < indice) C11(i)(j)
        else if (i < indice && j >= indice) C12(i)(j - indice)
        else if (i >= indice && j < indice) C21(i - indice)(j)
        else C22(i - indice)(j - indice)
      }
      m3

    }
  }

  def restaMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val filas = m1.length
    val columnas = m2.length
    Vector.tabulate(filas, columnas) { (i, j) => m1(i)(j) - m2(i)(j) }

  }

  def prodPuntoParD(v1: ParVector[Int], v2: ParVector[Int]): Int = {
    (v1 zip v2).map({
      case (i, j) => i * j
    }).sum
  }

  private def unir(a: Matriz, b: Matriz, c: Matriz, d: Matriz): Matriz = {
    val ab = a.zip(b).map { case (filaA, filaB) => filaA ++ filaB }
    val cd = c.zip(d).map { case (filaC, filaD) => filaC ++ filaD }
    ab ++ cd
  }

  def multStrassen(a: Matriz, b: Matriz): Matriz = {
    val n = a.length
    if (n == 1) {
    Vector(Vector(a(0)(0) * b(0)(0)))
    } else {
      val A11 = subMatriz(a, 0, 0, n/2)
      val A12 = subMatriz(a, 0, n/2, n/2)
      val A21 = subMatriz(a, n/2, 0, n/2)
      val A22 = subMatriz(a, n/2, n/2, n/2)

      val B11 = subMatriz(b, 0, 0, n/2)
      val B12 = subMatriz(b, 0, n/2, n/2)
      val B21 = subMatriz(b, n/2, 0, n/2)
      val B22 = subMatriz(b, n/2, n/2, n/2)

      val p1 = multStrassen(sumMatriz(A11, A22), sumMatriz(B11, B22))
      val p2 = multStrassen(sumMatriz(A21, A22), B11)
      val p3 = multStrassen(A11, restaMatriz(B12, B22))
      val p4 = multStrassen(A22, restaMatriz(B21, B11))
      val p5 = multStrassen(sumMatriz(A11, A12), B22)
      val p6 = multStrassen(restaMatriz(A21, A11), sumMatriz(B11, B12))
      val p7 = multStrassen(restaMatriz(A12, A22), sumMatriz(B21, B22))
      val c11 = sumMatriz(restaMatriz(sumMatriz(p1, p4), p5), p7)
      val c12 = sumMatriz(p3, p5)
      val c21 = sumMatriz(p2, p4)
      val c22 = sumMatriz(sumMatriz(restaMatriz(p1, p2), p3), p6)

      unir(c11, c12, c21, c22)
    }
  }

  def multStrassenPar(a: Matriz, b: Matriz): Matriz = {
    val n = a.length
    if (n == 1) {
      Vector(Vector(a(0)(0) * b(0)(0)))
    } else {
      val A11 = subMatriz(a, 0, 0, n / 2)
      val A12 = subMatriz(a, 0, n / 2, n / 2)
      val A21 = subMatriz(a, n / 2, 0, n / 2)
      val A22 = subMatriz(a, n / 2, n / 2, n / 2)

      val B11 = subMatriz(b, 0, 0, n / 2)
      val B12 = subMatriz(b, 0, n / 2, n / 2)
      val B21 = subMatriz(b, n / 2, 0, n / 2)
      val B22 = subMatriz(b, n / 2, n / 2, n / 2)

      val p1 = task(multStrassenPar(sumMatriz(A11, A22), sumMatriz(B11, B22)))
      val p2 = task(multStrassenPar(sumMatriz(A21, A22), B11))
      val p3 = task(multStrassenPar(A11, restaMatriz(B12, B22)))
      val p4 = task(multStrassenPar(A22, restaMatriz(B21, B11)))
      val p5 = task(multStrassenPar(sumMatriz(A11, A12), B22))
      val p6 = task(multStrassenPar(restaMatriz(A21, A11), sumMatriz(B11, B12)))
      val p7 = task(multStrassenPar(restaMatriz(A12, A22), sumMatriz(B21, B22)))

      val c11 = sumMatriz(restaMatriz(sumMatriz(p1.join(), p4.join()), p5.join()), p7.join())
      val c12 = sumMatriz(p3.join(), p5.join())
      val c21 = sumMatriz(p2.join(), p4.join())
      val c22 = sumMatriz(sumMatriz(restaMatriz(p1.join(), p2.join()), p3.join()), p6.join())

      unir(c11, c12, c21, c22)
    }
  }
}