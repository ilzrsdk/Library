import javax.xml.catalog.Catalog

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var Books = arrayOf(
    Book("Мастер и Маргарита","Булгаков", 1967, Genre.FICTION, BookStatus.BORROWED),
    Book("Преступление и наказание","Достоевский", 1866, Genre.FICTION, BookStatus.RESERVED),
    Book("Властелин колец", "Толкин", 1937, Genre.FANTASY, BookStatus.LOST),
    Book("Машина времени", "Уэллс", 1895, Genre.FANTASY, BookStatus.AVAILABLE)
    )


}