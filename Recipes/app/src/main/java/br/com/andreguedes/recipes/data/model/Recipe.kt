package br.com.andreguedes.recipes.data.model

import java.io.InputStream

class Recipe(val id: String?, val title: String?, val description: StringBuilder?) {

    companion object {

        private const val ID_PREFIX = "id="
        private const val TITLE_PREFIX = "title="

        fun readFromStream(stream: InputStream): Recipe? {
            var id: String? = null
            var title: String? = null
            val description = StringBuilder()

            val reader = stream.bufferedReader()
            do {
                val line = reader.readLine()
                if (line.startsWith(ID_PREFIX)) {
                    id = line.substring(ID_PREFIX.length)
                    continue
                } else if (line.startsWith(TITLE_PREFIX)) {
                    title = line.substring(TITLE_PREFIX.length)
                    continue
                } else {
                    if (description.isNotEmpty()) {
                        description.append("\n")
                    }
                    description.append(line)
                    break
                }
            } while (line != null)

            return Recipe(id, title, description)
        }

    }

}