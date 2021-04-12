package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class VendedorTest : DescribeSpec({
  val misiones = Provincia(1300000)
  val sanIgnacio = Ciudad(misiones)

  describe("Vendedor fijo") {
    val obera = Ciudad(misiones)
    val vendedorFijo = VendedorFijo(obera)
//    val agregarCertificacion(cerTi01)

    describe("puedeTrabajarEn") {
      it("su ciudad de origen") {
        vendedorFijo.puedeTrabajarEn(obera).shouldBeTrue()
      }
      it("otra ciudad") {
        vendedorFijo.puedeTrabajarEn(sanIgnacio).shouldBeFalse()
      }
    }
    describe("es Versatil") {
      it("su ciudad de origen") {
        vendedorFijo.esVersatil().shouldBeFalse()
      }
    }
    describe("es influyente") {
      it("su ciudad de origen") {
        vendedorFijo.esInfluyente().shouldBeFalse()
      }
    }

  }

  describe("Viajante") {
    val cordoba = Provincia(10000000)
    val villaDolores = Ciudad(cordoba)
    val viajante = Viajante(listOf(cordoba))

    describe("puedeTrabajarEn") {
      it("una ciudad que no pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(sanIgnacio).shouldBeFalse()
      }
      it("una ciudad que si pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(villaDolores).shouldBeTrue()
      }
    }
    describe("es influyente") {
      it("la población total debe ser de 10 millones o superior") {
        viajante.esInfluyente().shouldBeTrue()
      }
    }
  }

  describe("comercio corresponsal") {

    val cordoba = Provincia(2000000)
    val sanjuan = Provincia(100000)
    val chubut = Provincia(30000)
    val santafe = Provincia(2500000)
    val buenosaires = Provincia(4000000)

    val carlosPaz = Ciudad(cordoba)
    val rodeo = Ciudad(sanjuan)
    val bariloche = Ciudad(chubut)
    val rosario = Ciudad(santafe)
    val hurlingham = Ciudad(buenosaires)

    val comercioCorresponsal = ComercioCorresponsal(listOf(carlosPaz,rodeo,bariloche,rosario,hurlingham))
    //val comercioCorresponsal = ComercioCorresponsal(listOf(rosario,rafaela,SanFrancisco,Diamante))

    describe("puedeTrabajarEn") {
      it("una ciudad que pertenece a una provincia habilitada") {
        comercioCorresponsal.puedeTrabajarEn(sanIgnacio).shouldBeFalse()
      }
      it("una ciudad que no pertenece a una provincia habilitada") {
        comercioCorresponsal.puedeTrabajarEn(carlosPaz).shouldBeTrue()
      }
    }
    describe("es influyente") {
      it("su ciudad de origen") {
        comercioCorresponsal.esInfluyente().shouldBeTrue()
      }
    }

  }
})
