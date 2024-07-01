import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate


fun waitUntilDateChange(workingDate: LocalDate, targetDay: DayOfWeek) {
    while (true) {
        if (workingDate.dayOfWeek == targetDay) {
            return
        }
    }


}