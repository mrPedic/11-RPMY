import java.time.LocalDate
import java.time.Period

fun main() {
    // Данные именинника
    val birthdayPerson = "Ващило Владислава Витальевича"

    // Выбор текущей даты
    println("Выберите дату для сравнения:")
    println("1 - Использовать текущую дату")
    println("2 - Ввести дату вручную")
    print("Ваш выбор: ")

    val choice = readln().toInt()
    val currentDate = when (choice) {
        1 -> LocalDate.now()
        2 -> {
            print("Введите дату в формате ДД.ММ: ")
            val input = readln()
            val (day, month) = input.split(".").map { it.toInt() }
            LocalDate.of(LocalDate.now().year, month, day)
        }
        else -> {
            println("Некорректный выбор, будет использована текущая дата")
            LocalDate.now()
        }
    }

    // Ввод даты дня рождения
    print("Введите дату дня рождения (в формате ДД.ММ): ")
    val (birthDay, birthMonth) = readln().split(".").map { it.toInt() }
    val birthday = LocalDate.of(LocalDate.now().year, birthMonth, birthDay)

    // Рассчитываем следующий день рождения
    var nextBirthday = birthday
    if (nextBirthday.isBefore(currentDate) || nextBirthday.isEqual(currentDate)) {
        nextBirthday = nextBirthday.plusYears(1)
    }

    // Вычисляем период между датами
    val period = Period.between(currentDate, nextBirthday)
    val months = period.months
    val days = period.days

    // Формируем строку с результатом
    val result = "До дня рождения $birthdayPerson осталось ${months} ${month(months)} и ${days} ${days(days)}"
    println(result)
}

fun days(day: Int): String {
    return when {
        day % 10 == 1 && day % 100 != 11 -> "день"
        day % 10 in 2..4 && day % 100 !in 12..14 -> "дня"
        else -> "дней"
    }
}

fun month(month: Int): String {
    return when {
        month % 10 == 1 && month % 100 != 11 -> "месяц"
        month % 10 in 2..4 && month % 100 !in 12..14 -> "месяца"
        else -> "месяцев"
    }
}