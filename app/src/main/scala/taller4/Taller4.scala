/**
 * Taller 3 - Programación Funcional
 * Autores: Esteban Revelo Salazar  2067507
 *          Juan migel posso        2259610
 *          Nicolás Mauricio Rojas  2259460
 * Profesor: Carlos A Delgado
 */
package taller4
import math._


object Taller4{

  def main(args: Array[String]): Unit = {

    val B = new Benchmark()
    val opm = new Clase1()
    val tam:Int= 4
    val m1 = opm.matrizAlAzar(tam, 2)
    val m2 = opm.matrizAlAzar(tam, 2)
    val v1 = opm.vectorAlAzar(tam, 10)
    val v2 = opm.vectorAlAzar(tam, 10)
    val v3 = opm.parVectorAlAzar(tam, 10)
    val v4 = opm.parVectorAlAzar(tam, 10)

    println("La comparacion de la funcion multMatriz y multMatrizParalelo es: "+ B.CompararAlgoritmos(opm.multMatriz, opm.multMatrizParalelo)(m1, m2))
    println("La comparacion de la funcion multMatrizRec y multMatrizRecPar es: "+ B.CompararAlgoritmos(opm.multMatrizRec, opm.multMatrizrecPar)(m1, m2))
    println("la comparacion de la funcion prodPunto y prodPuntoParD es: "+ B.CompararProdPunto(opm.prodPunto, opm.prodPuntoParD)(v1,v2,v3,v4))
    println("la comparacion de la funcion multStrassen y multStrassenPar es: "+ B.CompararAlgoritmos(opm.multStrassen, opm.multStrassenPar)(m1, m2))

    //println("m1: "+m1)
    //println("m2: "+m2)
    //println("Multiplicacion recursiva: "+opm.multMatrizRec(m1,m2))
    /*
    println("Submatrices de m1: "+opm.subMatriz(m1,0,0,tam/2))
    println("Submatrices de m1: "+opm.subMatriz(m1,tam/2,tam/2,tam/2))

     */
    /*
    val m1=Vector(Vector(0,1,1,0),Vector(1,0,0,1),Vector(1,0,0,1),Vector(0,1,1,0))
    val m2=Vector(Vector(1,0,1,1),Vector(0,0,0,1),Vector(0,0,1,0),Vector(1,1,0,0))

    */

    //val m1 = opm.matrizAlAzar(128,2)
    //val m2 = opm.matrizAlAzar(128,2)
    // El resultado de la multiplicación de m1 y m2 es:
    // Vector(Vector(8,5),Vector(13,8))/
    /*   val t1:Double=System.currentTimeMillis()
       opm.multMatrizRec(m1,m2)
       println("El tiempo de ejecucion de la multiplicacion recursiva secuencial es: "+(System.currentTimeMillis()-t1))
       val t2:Double=System.currentTimeMillis()
       opm.multMatrizrecPar(m1,m2)
       println("El tiempo de ejecucion de la multiplicacion paralela es: "+(System.currentTimeMillis()-t2))
       println("La Aceleracion es: "+(System.currentTimeMillis()-t1)/(System.currentTimeMillis()-t2))

    */
    /*
    val (parte1_m1, parte2_m1) = m1.splitAt(1)
    println(parte1_m1)
    println(parte2_m1)

     */
  }
}