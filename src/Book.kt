class Book(
    val name: String, val author: String, val year: Int, val genre: Genre, var status: BookStatus) {

    fun printBook(number: Int): String {
        return number.toString().padEnd(3) + name.padEnd(35) + author.padEnd(15) +
                year.toString().padEnd(6) + genre.displayName.padEnd(28) + status.displayName
    }

}
fun printReport(books: Array<Book>) {
    println("====Отчет по каталогу====")
    printCount(books)
    println()
    printStatus(books)
    println()
    printGenre(books)
    println()
    printOldestAndNewest(books)
    printAverageYear(books)
    println()
}

fun printCount(books: Array<Book>) {
    println("Всего книг: ${books.size}")
}

fun printStatus(books: Array<Book>) {
    println("По статусу:")
    var available = 0
    var borrowed = 0
    var lost = 0
    var reserved = 0
    var archived = 0
    for (book in books) {
        when (book.status) {
            BookStatus.AVAILABLE -> available++
            BookStatus.BORROWED -> borrowed++
            BookStatus.LOST -> lost++
            BookStatus.RESERVED -> reserved++
            BookStatus.ARCHIVED -> archived++
        }
    }
    println("Доступно: $available")
    println("Выдано: $borrowed")
    println("Потеряно: $lost")
    println("Зарезервировано: $reserved")
    println("В архиве: $archived")
}

fun printGenre(books: Array<Book>) {
    println("По жанру:")
    var fiction = 0
    var scientific = 0
    var fantasy = 0
    var detective = 0
    var biography = 0
    var children = 0
    for (book in books) {
        when (book.genre) {
            Genre.FICTION -> fiction++
            Genre.SCIENTIFIC -> scientific++
            Genre.FANTASY -> fantasy++
            Genre.DETECTIVE -> detective++
            Genre.BIOGRAPHY -> biography++
            Genre.CHILDREN -> children++
        }
    }
    println("Художественная литература: $fiction")
    println("Научная литература: $scientific")
    println("Фантастика: $fantasy")
    println("Детектив: $detective")
    println("Биография: $biography")
    println("Детская литература: $children")
}

fun printOldestAndNewest(books: Array<Book>) {
    val oldest = books.minBy{ it.year }
    val newest = books.maxBy{ it.year }
    println("Самая старая книга: ${oldest.name} (${oldest.year})")
    println("Самая новая книга: ${newest.name} (${newest.year})")
}

fun printAverageYear(books: Array<Book>) {
    val average = books.sumOf{ it.year } / books.size
    println("Средний год: $average")
}

fun printAvailable(books: Array<Book>) {
    println("Доступные книги:")
    println("№".padEnd(3) + "Название".padEnd(35) + "Автор".padEnd(15) + "Год".padEnd(6) +
            "Жанр".padEnd(28) + "Статус")
    var found = 0
    for ((index, book) in books.withIndex()) {
        if (book.status == BookStatus.AVAILABLE) {
            println(book.printBook(index + 1))
            found++
        }
    }
    if (found == 0) println("Доступных книг нет")
}

fun printUserGenre(books: Array<Book>) {
    print("Введите жанр: ")
    val genre = readln().trim().uppercase()
    println("№".padEnd(3) + "Название".padEnd(35) + "Автор".padEnd(15) + "Год".padEnd(6) +
            "Жанр".padEnd(28) + "Статус")
    var found = 0
    for ((index, book) in books.withIndex()) {
        if (book.genre.toString() == genre) {
            println(book.printBook(index + 1))
            found++
        }
    }
    if (found == 0) println("Книг этого жанра нет")
}

fun printAfterYear(books: Array<Book>) {
    print("Введите год: ")
    val year = readln().toIntOrNull()
    if (year == null) { println("Ошибка ввода!"); return}
    println("№".padEnd(3) + "Название".padEnd(35) + "Автор".padEnd(15) + "Год".padEnd(6) +
            "Жанр".padEnd(28) + "Статус")
    var found = 0
    for ((index, book) in books.withIndex()) {
        if (book.year > year) {
            println(book.printBook(index + 1))
            found++
        }
    }
    if (found == 0) println("Таких книг нет")
}

fun giveBook(books: Array<Book>) {
    print("Введите номер книги для выдачи: ")
    val number = readln().toIntOrNull()
    if (number == null || number < 1 || number > books.size) {
        println("Ошибка! Книги с таким номером нет")
        return
    }
    val book = books[number - 1]
    if (book.status == BookStatus.AVAILABLE) {
        book.status = BookStatus.BORROWED
        println("Книга выдана")
    }
    else {
        println("Книга недоступна, так как на данный момент она ${book.status.displayName.lowercase()}")
    }
}

fun returnBook(books: Array<Book>) {
    print("Введите номер книги для возврата: ")
    val number = readln().toIntOrNull()
    if (number == null || number < 1 || number > books.size) {
        println("Ошибка! Книги с таким номером нет")
        return
    }
    val book = books[number - 1]
    if (book.status == BookStatus.BORROWED) {
        book.status = BookStatus.AVAILABLE
        println("Книга возвращена")
    }
    else {
        println("Книга не выдана, так как на данный момент она не выдана")
    }
}

fun loseBook(books: Array<Book>) {
    print("Введите номер книги, котрую потеряли: ")
    val number = readln().toIntOrNull()
    if (number == null || number < 1 || number > books.size) {
        println("Ошибка! Книги с таким номером нет")
        return
    }
    val book = books[number - 1]
    book.status = BookStatus.LOST
    println("Книга утеряна")
}

fun reserveBook(books: Array<Book>) {
    print("Введите номер книги для резервирования: ")
    val number = readln().toIntOrNull()
    if (number == null || number < 1 || number > books.size) {
        println("Ошибка! Книги с таким номером нет")
        return
    }
    val book = books[number - 1]
    if (book.status == BookStatus.AVAILABLE) {
        book.status = BookStatus.RESERVED
        println("Книга зарезервирована")
    }
    else {
        println("Книгу нельзя зарезервировать, так как на данный момент она ${book.status.displayName.lowercase()}")
    }
}