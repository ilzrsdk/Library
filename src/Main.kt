import javax.xml.catalog.Catalog

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val books = arrayOf(
        Book("Мастер и Маргарита", "Булгаков", 1967, Genre.FICTION, BookStatus.BORROWED),
        Book("Преступление и наказание", "Достоевский", 1866, Genre.FICTION, BookStatus.RESERVED),
        Book("Властелин колец", "Толкин", 1954, Genre.FANTASY, BookStatus.LOST),
        Book("Машина времени", "Уэллс", 1895, Genre.FANTASY, BookStatus.AVAILABLE),
        Book("Краткая история времени", "Хокинг", 1988, Genre.SCIENTIFIC, BookStatus.AVAILABLE),
        Book("Убийство в Восточном экспрессе", "Кристи", 1934, Genre.DETECTIVE, BookStatus.AVAILABLE),
        Book("Приключения Шерлока Холмса", "Дойл", 1892, Genre.DETECTIVE, BookStatus.ARCHIVED),
        Book("Стив Джобс", "Айзексон", 2011, Genre.BIOGRAPHY, BookStatus.AVAILABLE),
        Book("Маленький принц", "Сент-Экзюпери", 1943, Genre.CHILDREN, BookStatus.AVAILABLE),
        Book("Винни-Пух", "Милн", 1926, Genre.CHILDREN, BookStatus.BORROWED),
        Book("Гарри Поттер и философский камень", "Роулинг", 1997, Genre.FANTASY, BookStatus.RESERVED),
        Book("Эгоистичный ген", "Докинз", 1976, Genre.SCIENTIFIC, BookStatus.ARCHIVED)
    )

    println("№".padEnd(3) + "Название".padEnd(35) + "Автор".padEnd(15) + "Год".padEnd(6) +
            "Жанр".padEnd(28) + "Статус")
    for (i in books.indices) {
        println(books[i].printBook(i + 1))
    }
    println()

    printAvailable(books)
    println()

    printUserGenre(books)
    println()

    printAfterYear(books)
    println()

    giveBook(books)
    println()

    loseBook(books)
    println()

    returnBook(books)
    println()

    reserveBook(books)
    println()
    
    printReport(books)

}