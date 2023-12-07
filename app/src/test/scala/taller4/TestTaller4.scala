/**
 * Plantilla para pruebas
* @author Carlos Delgado
* @version 1.0
* @note 22 de Noviembre de 2023 
 */
package taller4

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner
import scala.collection.parallel.immutable.ParVector

@RunWith(classOf[JUnitRunner])
class TestTaller4 extends AnyFunSuite {
    test("prueba prodPunto #1") {
        val obj =  new AlgoritmoMatriz()
        val vector1 = Vector(1, 2, 3, 4)
        val vector2 = Vector(5, 6, 7, 8)
        val res = obj.prodPunto(vector1, vector2)
        assert(res == 70)
    }
    test("prueba prodPunto #2") {
        val obj =  new AlgoritmoMatriz()
        val vector1 = Vector(1, 2, 3, 4, 5)
        val vector2 = Vector(5, 6, 7, 8, 9)
        val res = obj.prodPunto(vector1, vector2)
        assert(res == 115)
    }
    test("prueba prodPunto #3") {
        val obj =  new AlgoritmoMatriz()
        val vector1 = Vector(1, 2, 3, 4, 5, 6)
        val vector2 = Vector(5, 6, 7, 8, 9, 10)
        val res = obj.prodPunto(vector1, vector2)
        assert(res == 175)
    }
    test("prueba prodPunto #4") {
        val obj =  new AlgoritmoMatriz()
        val vector1 = Vector(1, 2, 3, 4, 5, 6, 7)
        val vector2 = Vector(5, 6, 7, 8, 9, 10, 11)
        val res = obj.prodPunto(vector1, vector2)
        assert(res == 252)
    }
    test("prueba transpuesta #1") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2, 3), Vector(4, 5, 6), Vector(7, 8, 9))
        val res = obj.transpuesta(matriz1)
        assert(res == Vector(Vector(1, 4, 7), Vector(2, 5, 8), Vector(3, 6, 9)))
    }
    test("prueba transpuesta #2") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2, 3, 4), Vector(5, 6, 7, 8), Vector(9, 10, 11, 12), Vector(13, 14, 15, 16))
        val res = obj.transpuesta(matriz1)
        assert(res == Vector(Vector(1, 5, 9, 13), Vector(2, 6, 10, 14), Vector(3, 7, 11, 15), Vector(4, 8, 12, 16)))
    }
    test("prueba transpuesta #3") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2, 3, 4, 5), Vector(6, 7, 8, 9, 10), Vector(11, 12, 13, 14, 15), Vector(16, 17, 18, 19, 20), Vector(21, 22, 23, 24, 25))
        val res = obj.transpuesta(matriz1)
        assert(res == Vector(Vector(1, 6, 11, 16, 21), Vector(2, 7, 12, 17, 22), Vector(3, 8, 13, 18, 23), Vector(4, 9, 14, 19, 24), Vector(5, 10, 15, 20, 25)))
    }
    test("prueba transpuesta #4") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2, 3, 4, 5, 6), Vector(7, 8, 9, 10, 11, 12), Vector(13, 14, 15, 16, 17, 18), Vector(19, 20, 21, 22, 23, 24), Vector(25, 26, 27, 28, 29, 30), Vector(31, 32, 33, 34, 35, 36))
        val res = obj.transpuesta(matriz1)
        assert(res == Vector(Vector(1, 7, 13, 19, 25, 31), Vector(2, 8, 14, 20, 26, 32), Vector(3, 9, 15, 21, 27, 33), Vector(4, 10, 16, 22, 28, 34), Vector(5, 11, 17, 23, 29, 35), Vector(6, 12, 18, 24, 30, 36)))
    }
    test("Prueba multMatriz de matrices #1") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2), Vector(3, 4))
        val matriz2 = Vector(Vector(5, 6), Vector(7, 8))
        val res = obj.multMatriz(matriz1, matriz2)
        assert(res == Vector(Vector(19, 22), Vector(43, 50)))
    }
    test("Prueba multMatriz de matrices #2") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2, 3, 4), Vector(5, 6, 7, 8), Vector(9, 10, 11, 12), Vector(13, 14, 15, 16))
        val matriz2 = Vector(Vector(17, 18, 19, 20), Vector(21, 22, 23, 24), Vector(25, 26, 27, 28), Vector(29, 30, 31, 32))
        val res = obj.multMatriz(matriz1, matriz2)
        assert(res == Vector(Vector(250, 260, 270, 280), Vector(618, 644, 670, 696), Vector(986, 1028, 1070, 1112), Vector(1354, 1412, 1470, 1528)))
    }
    test("prueba multMatriz de matrices #3") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(4, 4, 2, 1), Vector(1, 2, 3, 4), Vector(4, 3, 2, 1), Vector(1, 2, 3, 4))
        val matriz2 = Vector(Vector(1, 2, 3, 4), Vector(4, 3, 2, 1), Vector(1, 2, 3, 4), Vector(4, 3, 2, 1))
        val res = obj.multMatriz(matriz1, matriz2)
        assert(res == Vector(Vector(26, 27, 28, 29), Vector(28, 26, 24, 22), Vector(22, 24, 26, 28), Vector(28, 26, 24, 22)))
    }
    test("prueba multMatriz de matrices #4") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(7, 8), Vector(4, 3))
        val matriz2 = Vector(Vector(51, 2), Vector(12, 5))
        val res = obj.multMatriz(matriz1, matriz2)
        assert(res == Vector(Vector(453, 54), Vector(240, 23)))
    }
    test("prueba multMatrizParalelo de matrices #1") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2), Vector(3, 4))
        val matriz2 = Vector(Vector(5, 6), Vector(7, 8))
        val res = obj.multMatrizParalelo(matriz1, matriz2)
        assert(res == Vector(Vector(19, 22), Vector(43, 50)))
    }
    test("prueba multMatrizParalelo de matrices #2") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2, 3, 4), Vector(5, 6, 7, 8), Vector(9, 10, 11, 12), Vector(13, 14, 15, 16))
        val matriz2 = Vector(Vector(17, 18, 19, 20), Vector(21, 22, 23, 24), Vector(25, 26, 27, 28), Vector(29, 30, 31, 32))
        val res = obj.multMatrizParalelo(matriz1, matriz2)
        assert(res == Vector(Vector(250, 260, 270, 280), Vector(618, 644, 670, 696), Vector(986, 1028, 1070, 1112), Vector(1354, 1412, 1470, 1528)))
    }
    test("prueba multMatrizParalelo de matrices #3") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(4, 4, 2, 1), Vector(1, 2, 3, 4), Vector(4, 3, 2, 1), Vector(1, 2, 3, 4))
        val matriz2 = Vector(Vector(1, 2, 3, 4), Vector(4, 3, 2, 1), Vector(1, 2, 3, 4), Vector(4, 3, 2, 1))
        val res = obj.multMatrizParalelo(matriz1, matriz2)
        assert(res == Vector(Vector(26, 27, 28, 29), Vector(28, 26, 24, 22), Vector(22, 24, 26, 28), Vector(28, 26, 24, 22)))
    }
    test("prueba multMatrizParalelo de matrices #4") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(7, 8), Vector(4, 3))
        val matriz2 = Vector(Vector(51, 2), Vector(12, 5))
        val res = obj.multMatrizParalelo(matriz1, matriz2)
        assert(res == Vector(Vector(453, 54), Vector(240, 23)))
    }
    test("pruebasubMatriz #1") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2, 3, 4), Vector(5, 6, 7, 8), Vector(9, 10, 11, 12), Vector(13, 14, 15, 16))
        val res = obj.subMatriz(matriz1, 0, 0, 2)
        assert(res == Vector(Vector(1, 2), Vector(5, 6)))
    }
    test("pruebasubMatriz #2") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2, 3, 4), Vector(5, 6, 7, 8), Vector(9, 10, 11, 12), Vector(13, 14, 15, 16))
        val res = obj.subMatriz(matriz1, 0, 2, 2)
        assert(res == Vector(Vector(3, 4), Vector(7, 8)))
    }
    test("pruebasubMatriz #3") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2, 3, 4, 5), Vector(6, 7, 8, 9, 10), Vector(11, 12, 13, 14, 15), Vector(16, 17, 18, 19, 20), Vector(21, 22, 23, 24, 25))
        val res = obj.subMatriz(matriz1, 0, 0, 2)
        assert(res == Vector(Vector(1, 2), Vector(6, 7)))
    }
    test("pruebasubMatriz #4") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2, 3, 4, 5), Vector(6, 7, 8, 9, 10), Vector(11, 12, 13, 14, 15), Vector(16, 17, 18, 19, 20), Vector(21, 22, 23, 24, 25))
        val res = obj.subMatriz(matriz1, 0, 2, 2)
        assert(res == Vector(Vector(3, 4), Vector(8, 9)))
    }
    test("PruebaSuma de matrices #1") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2), Vector(3, 4))
        val matriz2 = Vector(Vector(5, 6), Vector(7, 8))
        val res = obj.sumMatriz(matriz1, matriz2)
        assert(res == Vector(Vector(6, 8), Vector(10, 12)))
    }
    test("PruebaSuma de matrices #2") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2, 3, 4), Vector(5, 6, 7, 8), Vector(9, 10, 11, 12), Vector(13, 14, 15, 16))
        val matriz2 = Vector(Vector(17, 18, 19, 20), Vector(21, 22, 23, 24), Vector(25, 26, 27, 28), Vector(29, 30, 31, 32))
        val res = obj.sumMatriz(matriz1, matriz2)
        assert(res == Vector(Vector(18, 20, 22, 24), Vector(26, 28, 30, 32), Vector(34, 36, 38, 40), Vector(42, 44, 46, 48)))
    }
    test("pruebaSuma de matrices #3") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(4, 4, 2, 1), Vector(1, 2, 3, 4), Vector(4, 3, 2, 1), Vector(1, 2, 3, 4))
        val matriz2 = Vector(Vector(1, 2, 3, 4), Vector(4, 3, 2, 1), Vector(1, 2, 3, 4), Vector(4, 3, 2, 1))
        val res = obj.sumMatriz(matriz1, matriz2)
        assert(res == Vector(Vector(5, 6, 5, 5), Vector(5, 5, 5, 5), Vector(5, 5, 5, 5), Vector(5, 5, 5, 5)))
    }
    test("pruebaSuma de matrices #4") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(4, 5, 6, 8, 4, 5, 5, 4), Vector(7, 8, 1, 3, 4, 2, 1, 7), Vector(4, 2, 3, 7, 8, 9, 11, 2), Vector(14, 6, 7, 8, 4, 1, 5, 6), Vector(4, 5, 6, 8, 4, 5, 5, 4), Vector(4, 5, 6, 8, 5, 7, 8, 4), Vector(7, 5, 3, 47, 8, 45, 5, 7), Vector(1, 2, 34, 78, 84, 4, 1, 4))
        val matriz2 = Vector(Vector(8, 5, 4, 2, 1, 2, 3, 4), Vector(4, 5, 7, 8, 5, 8, 7, 9), Vector(4, 5, 6, 8, 4, 51, 5, 4), Vector(7, 8, 1, 3, 4, 2, 1, 17), Vector(4, 2, 3, 7, 8, 9, 11, 2), Vector(1, 6, 7, 8, 4, 1, 5, 6), Vector(4, 5, 6, 8, 4, 15, 5, 4), Vector(4, 25, 6, 8, 52, 7, 81, 4))
        val res = obj.sumMatriz(matriz1, matriz2)
        assert(res == Vector(Vector(12, 10, 10, 10, 5, 7, 8, 8), Vector(11, 13, 8, 11, 9, 10, 8, 16), Vector(8, 7, 9, 15, 12, 60, 16, 6), Vector(21, 14, 8, 11, 8, 3, 6, 23), Vector(8, 7, 9, 15, 12, 14, 16, 6), Vector(5, 11, 13, 16, 9, 8, 13, 10), Vector(11, 10, 9, 55, 12, 60, 10, 11), Vector(5, 27, 40, 86, 136, 11, 82, 8)))
    }
    test("prueba multMatrizRec de matrices #1") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2), Vector(3, 4))
        val matriz2 = Vector(Vector(5, 6), Vector(7, 8))
        val res = obj.multMatrizRec(matriz1, matriz2)
        assert(res == Vector(Vector(19, 22), Vector(43, 50)))
    }
    test("prueba mulMatrizRec de matrices #2"){
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2, 3, 4), Vector(5, 6, 7, 8), Vector(9, 10, 11, 12), Vector(13, 14, 15, 16))
        val matriz2 = Vector(Vector(17, 18, 19, 20), Vector(21, 22, 23, 24), Vector(25, 26, 27, 28), Vector(29, 30, 31, 32))
        val res = obj.multMatrizRec(matriz1, matriz2)
        assert(res == Vector(Vector(250, 260, 270, 280), Vector(618, 644, 670, 696), Vector(986, 1028, 1070, 1112), Vector(1354, 1412, 1470, 1528)))
    }
    test("prueba mulMatrizRec de matrices #3"){
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(4, 4, 2, 1), Vector(1, 2, 3, 4), Vector(4, 3, 2, 1), Vector(1, 2, 3, 4))
        val matriz2 = Vector(Vector(1, 2, 3, 4), Vector(4, 3, 2, 1), Vector(1, 2, 3, 4), Vector(4, 3, 2, 1))
        val res = obj.multMatrizRec(matriz1, matriz2)
        assert(res == Vector(Vector(26, 27, 28, 29), Vector(28, 26, 24, 22), Vector(22, 24, 26, 28), Vector(28, 26, 24, 22)))
    }
    test("prueba mulMatrizRec de matrices #4"){
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(7, 8), Vector(4, 3))
        val matriz2 = Vector(Vector(51, 2), Vector(12, 5))
        val res = obj.multMatrizRec(matriz1, matriz2)
        assert(res == Vector(Vector(453, 54), Vector(240, 23)))
    }
    test("prueba multMatrizRecPar de matrices #1") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2), Vector(3, 4))
        val matriz2 = Vector(Vector(5, 6), Vector(7, 8))
        val res = obj.multMatrizrecPar(matriz1, matriz2)
        assert(res == Vector(Vector(19, 22), Vector(43, 50)))
    }
    test("prueba multMatrizRecPar de matrices #2") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(1, 2, 3, 4), Vector(5, 6, 7, 8), Vector(9, 10, 11, 12), Vector(13, 14, 15, 16))
        val matriz2 = Vector(Vector(17, 18, 19, 20), Vector(21, 22, 23, 24), Vector(25, 26, 27, 28), Vector(29, 30, 31, 32))
        val res = obj.multMatrizrecPar(matriz1, matriz2)
        assert(res == Vector(Vector(250, 260, 270, 280), Vector(618, 644, 670, 696), Vector(986, 1028, 1070, 1112), Vector(1354, 1412, 1470, 1528)))
    }
    test("prueba multMatrizRecPar de matrices #3") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(4, 4, 2, 1), Vector(1, 2, 3, 4), Vector(4, 3, 2, 1), Vector(1, 2, 3, 4))
        val matriz2 = Vector(Vector(1, 2, 3, 4), Vector(4, 3, 2, 1), Vector(1, 2, 3, 4), Vector(4, 3, 2, 1))
        val res = obj.multMatrizrecPar(matriz1, matriz2)
        assert(res == Vector(Vector(26, 27, 28, 29), Vector(28, 26, 24, 22), Vector(22, 24, 26, 28), Vector(28, 26, 24, 22)))
    }
    test("prueba multMatrizRecPar de matrices #4") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(7, 8), Vector(4, 3))
        val matriz2 = Vector(Vector(51, 2), Vector(12, 5))
        val res = obj.multMatrizrecPar(matriz1, matriz2)
        assert(res == Vector(Vector(453, 54), Vector(240, 23)))
    }
    test("pruebaResta de matrices #1") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(4, 4, 2, 1), Vector(1, 2, 3, 4), Vector(4, 3, 2, 1), Vector(1, 2, 3, 4))
        val matriz2 = Vector(Vector(1, 2, 3, 4), Vector(4, 3, 2, 1), Vector(1, 2, 3, 4), Vector(4, 3, 2, 1))
        val res = obj.restaMatriz(matriz1, matriz2)
        assert(res == Vector(Vector(3, 2, -1, -3), Vector(-3, -1, 1, 3), Vector(3, 1, -1, -3), Vector(-3, -1, 1, 3)))
    }
    test("pruebaResta de matrices #2") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(4, 5, 6, 8, 4, 5, 5, 4), Vector(7, 8, 1, 3, 4, 2, 1, 7), Vector(4, 2, 3, 7, 8, 9, 11, 2), Vector(14, 6, 7, 8, 4, 1, 5, 6), Vector(4, 5, 6, 8, 4, 5, 5, 4), Vector(4, 5, 6, 8, 5, 7, 8, 4), Vector(7, 5, 3, 47, 8, 45, 5, 7), Vector(1, 2, 34, 78, 84, 4, 1, 4))
        val matriz2 = Vector(Vector(8, 5, 4, 2, 1, 2, 3, 4), Vector(4, 5, 7, 8, 5, 8, 7, 9), Vector(4, 5, 6, 8, 4, 51, 5, 4), Vector(7, 8, 1, 3, 4, 2, 1, 17), Vector(4, 2, 3, 7, 8, 9, 11, 2), Vector(1, 6, 7, 8, 4, 1, 5, 6), Vector(4, 5, 6, 8, 4, 15, 5, 4), Vector(4, 25, 6, 8, 52, 7, 81, 4))
        val res = obj.restaMatriz(matriz1, matriz2)
        assert(res == Vector(Vector(-4, 0, 2, 6, 3, 3, 2, 0), Vector(3, 3, -6, -5, -1, -6, -6, -2), Vector(0, -3, -3, -1, 4, -42, 6, -2), Vector(7, -2, 6, 5, 0, -1, 4, -11), Vector(0, 3, 3, 1, -4, -4, -6, 2), Vector(3, -1, -1, 0, 1, 6, 3, -2), Vector(3, 0, -3, 39, 4, 30, 0, 3), Vector(-3, -23, 28, 70, 32, -3, -80, 0)))
    }
    test("pruebaResta de matrices #3") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(4, 4, 2, 1), Vector(1, 2, 3, 4), Vector(4, 3, 2, 1), Vector(1, 2, 3, 4))
        val matriz2 = Vector(Vector(1, 2, 3, 4), Vector(4, 3, 2, 1), Vector(1, 2, 3, 4), Vector(4, 3, 2, 1))
        val res = obj.restaMatriz(matriz1, matriz2)
        assert(res == Vector(Vector(3, 2, -1, -3), Vector(-3, -1, 1, 3), Vector(3, 1, -1, -3), Vector(-3, -1, 1, 3)))
    }
    test("pruebaResta de matrices #4") {
        val obj =  new AlgoritmoMatriz()
        val matriz1 = Vector(Vector(7, 8), Vector(4, 3))
        val matriz2 = Vector(Vector(51, 2), Vector(12, 5))
        val res = obj.restaMatriz(matriz1, matriz2)
        assert(res == Vector(Vector(-44, 6), Vector(-8, -2)))
    }
    test("prueba prodPuntoParD #1"){
        val obj= new AlgoritmoMatriz()
        val vector1=ParVector(1,2,3,4)
        val vector2=ParVector(5,6,7,8)
        val res=obj.prodPuntoParD(vector1,vector2)
        assert(res==70)
    }
    test("prueba prodPuntoParD #2"){
        val obj= new AlgoritmoMatriz()
        val vector1=ParVector(1,2,3,4,5)
        val vector2=ParVector(5,6,7,8,9)
        val res=obj.prodPuntoParD(vector1,vector2)
        assert(res==115)
    }
    test("prueba prodPuntoParD #3"){
        val obj= new AlgoritmoMatriz()
        val vector1=ParVector(1,2,3,4,5,6)
        val vector2=ParVector(5,6,7,8,9,10)
        val res=obj.prodPuntoParD(vector1,vector2)
        assert(res==175)
    }
    test("prueba prodPuntoParD #4"){
        val obj= new AlgoritmoMatriz()
        val vector1=ParVector(1,2,3,4,5,6,7)
        val vector2=ParVector(5,6,7,8,9,10,11)
        val res=obj.prodPuntoParD(vector1,vector2)
        assert(res==252)
    }
    test("prueba multStrassend de matrices #1"){
        val obj= new AlgoritmoMatriz()
        val matriz1=Vector(Vector(1,2),Vector(3,4))
        val matriz2=Vector(Vector(5,6),Vector(7,8))
        val res=obj.multStrassen(matriz1,matriz2)
        assert(res==Vector(Vector(19,22),Vector(43,50)))
    }
    test("prueba multStrassend de matrices #2"){
        val obj= new AlgoritmoMatriz()
        val matriz1=Vector(Vector(1,2,3,4),Vector(5,6,7,8),Vector(9,10,11,12),Vector(13,14,15,16))
        val matriz2=Vector(Vector(17,18,19,20),Vector(21,22,23,24),Vector(25,26,27,28),Vector(29,30,31,32))
        val res=obj.multStrassen(matriz1,matriz2)
        assert(res==Vector(Vector(250,260,270,280),Vector(618,644,670,696),Vector(986,1028,1070,1112),Vector(1354,1412,1470,1528)))
    }
    test("prueba multStrassend de matrices #3"){
        val obj= new AlgoritmoMatriz()
        val matriz1=Vector(Vector(4,4,2,1),Vector(1,2,3,4),Vector(4,3,2,1),Vector(1,2,3,4))
        val matriz2=Vector(Vector(1,2,3,4),Vector(4,3,2,1),Vector(1,2,3,4),Vector(4,3,2,1))
        val res=obj.multStrassen(matriz1,matriz2)
        assert(res==Vector(Vector(26,27,28,29),Vector(28,26,24,22),Vector(22,24,26,28),Vector(28,26,24,22)))
    }
    test("prueba multStrassend de matrices #4"){
        val obj= new AlgoritmoMatriz()
        val matriz1=Vector(Vector(7,8,4,8),Vector(4,3,5,7),Vector(9,4,5,7),Vector(1,2,5,6))
        val matriz2=Vector(Vector(5,6,7,5),Vector(1,7,1,10),Vector(8,4,3,4),Vector(4,3,5,6))
        val res=obj.multStrassen(matriz1,matriz2)
        assert(res==Vector(Vector(107,138,109,179),Vector(91,86,81,112),Vector(117,123,117,147),Vector(71,58,54,81)))
    }
    test("prueba multStrassendPar de matrices #1"){
        val obj= new AlgoritmoMatriz()
        val matriz1=Vector(Vector(1,2),Vector(3,4))
        val matriz2=Vector(Vector(5,6),Vector(7,8))
        val res=obj.multStrassenPar(matriz1,matriz2)
        assert(res==Vector(Vector(19,22),Vector(43,50)))
    }
    test("prueba multStrassendPar de matrices #2"){
        val obj= new AlgoritmoMatriz()
        val matriz1=Vector(Vector(1,2,3,4),Vector(5,6,7,8),Vector(9,10,11,12),Vector(13,14,15,16))
        val matriz2=Vector(Vector(17,18,19,20),Vector(21,22,23,24),Vector(25,26,27,28),Vector(29,30,31,32))
        val res=obj.multStrassenPar(matriz1,matriz2)
        assert(res==Vector(Vector(250,260,270,280),Vector(618,644,670,696),Vector(986,1028,1070,1112),Vector(1354,1412,1470,1528)))
    }
    test("prueba multStrassendPar de matrices #3"){
        val obj= new AlgoritmoMatriz()
        val matriz1=Vector(Vector(7,8,9,5),Vector(4,3,5,7),Vector(9,4,5,7),Vector(1,2,5,6))
        val matriz2=Vector(Vector(5,6,7,5),Vector(1,7,1,10),Vector(8,4,3,4),Vector(4,3,5,6))
        val res=obj.multStrassenPar(matriz1,matriz2)
        assert(res==Vector(Vector(135, 149, 109, 181), Vector(91, 86, 81, 112), Vector(117, 123, 117, 147), Vector(71, 58, 54, 81)))
    }
    test("Prueba multStrassendPar de matrices #4"){
        val obj= new AlgoritmoMatriz()
        val matriz1=Vector(Vector(4,87,7,5,5,6,8,6),Vector(8,4,23,4,7,8,6,4),Vector(7,89,5,4,5,6,7,2),Vector(7,5,6,1,45,2,31,3),Vector(11,5,4,6,7,89,5,6),Vector(4,56,7,8,15,6,2,3),Vector(1,2,5,78,3,14,2,3),Vector(4,5,6,7,8,9,5,6))
        val matriz2=Vector(Vector(1,2,5,62,23,3,4,7),Vector(4,6,8,6,78,5,61,1),Vector(4,5,8,1,2,1,1,2),Vector(6,2,5,14,12,3,14,7),Vector(8,45,13,12,11,10,9,8),Vector(1,12,1,1,2,3,1,8),Vector(4,5,6,7,8,9,5,6),Vector(1,2,3,4,5,6,7,8))
        val res=obj.multStrassenPar(matriz1,matriz2)
        assert(res==Vector(Vector(494, 924, 934, 993, 7113, 645, 5533, 348), Vector(232, 612, 423, 749, 751, 251, 484, 322), Vector(483, 917, 926, 1152, 7294, 626, 5618, 322), Vector(546, 2286, 910, 1255, 1337, 808, 936, 659), Vector(254, 1504, 385, 1032, 1048, 498, 656, 978), Vector(441, 1158, 786, 915, 4778, 527, 3723, 358), Vector(546, 514, 525, 1247, 1217, 360, 1295, 737), Vector(189, 587, 304, 546, 754, 252, 573, 308)))
    }
}