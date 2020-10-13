package br.com.pablokalil.lmsapp

object SaboresService {

    fun getSabores() : List<Sabor> {
        val sabores = mutableListOf<Sabor>()

        for (i in 1..10) {
            val d = Sabor()
            d.nome = "Sabor $i"
            d.zero = "Zero $i"
            d.marca = "Marca $i"
            d.foto = "https://gizmodo.uol.com.br/wp-content/blogs.dir/8/files/2019/08/android-10-google.jpg"
            sabores.add(d)
        }
        return sabores
    }
}