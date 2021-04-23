package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class CentroDeDistribucionTest : DescribeSpec({
    val misiones = Provincia(1300000)
    val sanIgnacio = Ciudad(misiones)
    val cordoba = Provincia(10000000)
    val villaDolores = Ciudad(cordoba)

    describe("Centro De Distribucion Test") {
        val obera = Ciudad(misiones)
        val  vendedor1= VendedorFijo(obera)
        val  vendedor2= Viajante(listOf(cordoba))
        val  vendedor3= VendedorFijo(villaDolores)

        val centroDeDistribucion = CentroDeDistribucion(listOf(vendedor1,vendedor2,vendedor3))


       describe("puedeTrabajarEn") {
            it("una ciudad que pertenece a una provincia habilitada") {
                centroDeDistribucion.vendedorEstrella().toString(vendedor1)
            }
/*             it("una ciudad que no pertenece a una provincia habilitada") {
               centroDeDistribucion.vendedorEstrella().shouldBeTrue()
           }
        }
       describe("es influyente") {
            it("su ciudad de origen") {
                centroDeDistribucion.vendedorEstrella().shouldBeTrue()
            }*/
        }

    }
})
