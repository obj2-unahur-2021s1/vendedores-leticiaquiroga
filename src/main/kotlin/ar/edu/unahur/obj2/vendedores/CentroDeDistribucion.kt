package ar.edu.unahur.obj2.vendedores

class CentroDeDistribucion  (ciudad: Ciudad){

    var vendedoresDeCentro = MutableList<Vendedor>()

    fun agregaVendedor(nuevoVendedor: Vendedor) {
        if(vendedoresDeCentro.contains(nuevoVendedor)){
            throw error("Ya existente el vendedor en Centro")
        }

        vendedoresDeCentro.add(nuevoVendedor)
    }
    //El vendedor estrella, que es el que tiene mayor puntaje total por certificaciones.

    fun vendedorEstrella() = vendedoresDeCentro.maxBy{it.puntajeCertificaciones()}

    //Si _puede cubrir_, o no, una ciudad dada. La condición es que al menos uno de los vendedores registrados pueda trabajar en esa ciudad.

    fun puedeCubrir(ciudad: Ciudad) = vendedoresDeCentro.any{it.puedeTrabajarEn(ciudad)}

    //La colección de _vendedores genéricos_ registrados. Un vendedor se considera genérico si tiene al menos una certificación que no es de productos.

    fun vendedorGenericos()= vendedoresDeCentro.filter { it.esGenerico() }

    //Si _es robusto_, la condición es que al menos 3 de sus vendedores registrados sea firme.

    fun esRobusto()=vendedoresDeCentro.filter { it.esFirme()}.size>3

}