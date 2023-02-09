package es.kiketurry.talkingabout2023.flows

import kotlinx.coroutines.*

fun main2() = runBlocking {

    GlobalScope.launch {
        async { } //Lanzar tareas en paralelo
        async { } //Asi ahorramos tiempo
        val result = doAsync()
        println(result)
    }

}

suspend fun doAsync() = withContext(Dispatchers.IO) {
    1
}