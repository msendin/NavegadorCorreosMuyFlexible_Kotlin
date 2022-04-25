package udl.eps.demos.navegadorcorreosmuyflexible_kotlin

class Correo(val de: String, val asunto: String, val texto: String)

private val de: String? = null
private val asunto: String? = null
private val texto: String? = null

/*fun Correo(de: String, asunto: String, texto: String) {
    this.de = de
    this.asunto = asunto
    this.texto = texto
}

 */

fun getDe(): String? {
    return de
}

fun getAsunto(): String? {
    return asunto
}

fun getTexto(): String? {
    return texto
}