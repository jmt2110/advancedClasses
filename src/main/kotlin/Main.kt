import java.text.DecimalFormat

fun main(args: Array<String>) {
    println("Enter the employee name:")
    val empName = readLine()!!.toString()
    println("Enter the number corresponding to their Position:\n1. Administration\n2. Production\n3. Sales\n4. Maintenance\n5. Technical\n6. Secretarial")
    val empTitle = readLine()!!.toInt()
    var title = ""
    if (empTitle == 1){
        title = PositionTitle.Administration.toString()
    }
    else if (empTitle == 2){
        title = PositionTitle.Production.toString()
    }
    else if (empTitle == 3){
        title = PositionTitle.Sales.toString()
    }
    else if (empTitle == 4){
        title = PositionTitle.Maintenance.toString()
    }
    else if (empTitle == 5){
        title = PositionTitle.Technical.toString()
    }
    else if (empTitle == 6){
        title = PositionTitle.Secretarial.toString()
    }

    println("Is the employee salaried?\nEnter y/n")
    val empSalary = readLine()!!.toString()
    var salary = false
    if (empSalary.lowercase() == "y"){
        salary = true
        println("true")
    }
    else{
        salary = false
        println("false")
    }
    println("Enter the employee pay rate:\n(If salary enter yearly, if not enter hourly)")
    val empPayRate = readLine()!!.toDouble()
    println("Enter the employee shift:\n(1, 2, or 3)")
    val empShift = readLine()!!.toInt()

    val employee1 = Employee(empName, title, salary ,empPayRate, empShift)
    employee1.calculate()



}
enum class PositionTitle(val title: String){
    Administration("Administration"),
    Production("Production"),
    Sales("Sales"),
    Maintenance("Maintenance"),
    Technical("Technical"),
    Secretarial("Secretarial")
}

class Employee constructor(var name: String,
                           var position: String,
                           var salary: Boolean,
                           var payRate: Double,
                           var shift: Int
){

    fun calculate(){
        println("What is the number of hours worked?")
        val hoursIn = readLine()!!.toDouble()
        var money = DecimalFormat("$###,###,###.00") /// format for money

        if (salary == true){
            val weeklyPay = (payRate/52)
            val hrlyPay = weeklyPay/40
            if (shift == 2){ //2nd shift non-salaried
                if (hoursIn < 40){
                    val pay = weeklyPay * 1.05 //5% increase in pay
                    println("\n\nEmployee name: $name\nEmployee Position: $position\nEmployee Shift: $shift\nHours Worked: $hoursIn\nWeekly Pay: ${money.format(pay)}" )
                }
                else{
                    val overTime = hoursIn - 40 // subtract 40 hours on overtime
                    val overTimePay = overTime * ((hrlyPay * 1.05) * 1.5) //5% increase in pay and time and a half over time
                    val pay = weeklyPay + overTimePay
                    println("\n\n$name\n$position\nShift: $shift\nHours Worked: $hoursIn\nWeekly Pay: ${money.format(pay)}")
                }
            }
            else if (shift == 3){ //3rd shift non-salaried
                if (hoursIn < 40){
                    val pay = weeklyPay
                    println("\n\n$name\n$position\nShift: $shift\nHours Worked: $hoursIn\nWeekly Pay: ${money.format(pay)}")
                }
                else{
                    val overTime = hoursIn - 40 // subtract 40 hours on overtime
                    val overTimePay = overTime * ((hrlyPay * 1.10) * 1.5) //5% increase in pay and time and a half over time
                    val pay = weeklyPay + overTimePay
                    println("\n\n$name\n$position\nShift: $shift\nHours Worked: $hoursIn\nWeekly Pay: ${money.format(pay)}")
                }
            }
            else{ //1st shift non-salaried
                if (hoursIn < 40){
                    val pay = weeklyPay
                    println("\n\n$name\n$position\nShift: $shift\nHours Worked: $hoursIn\nWeekly Pay: ${money.format(pay)}")
                }
                else{
                    val overTime = hoursIn - 40 // subtract 40 hours on overtime
                    val overTimePay = overTime * hrlyPay
                    val pay = weeklyPay + overTimePay
                    println("\n\n$name\n$position\nShift: $shift\nHours Worked: $hoursIn\nWeekly Pay: ${money.format(pay)}")
                }
            }

        }
        else{ //not salary

            if (shift == 2){ //2nd shift non-salaried
                if (hoursIn < 40){
                    val pay = hoursIn * (payRate * 1.05) // 5% increase in pay
                    println("\n\n$name\n$position\nShift: $shift\nHours Worked: $hoursIn\nWeekly Pay: ${money.format(pay)}")
                }
                else{
                    val overTime = hoursIn - 40 // subtract 40 hours non overtime
                    val overTimePay = (overTime * (payRate * 1.05)) * 1.5 //overtime time and a half pay
                    val regularPay = 40 * (payRate * 1.05)
                    val pay = overTimePay + regularPay
                    println("\n\n$name\n$position\nShift: $shift\nHours Worked: $hoursIn\nWeekly Pay: ${money.format(pay)}")
                }

            }
            else if (shift == 3){ //3rd shift non-salaried
                if (hoursIn < 40){
                    val pay = hoursIn * (payRate * 1.1) //10% increase in pay
                    println("\n\n$name\n$position\nShift: $shift\nHours Worked: $hoursIn\nWeekly Pay: ${money.format(pay)}")
                }
                else{
                    val overTime = hoursIn - 40 // subtract 40 hours non overtime
                    val overTimePay = (overTime * (payRate * 1.1)) * 1.5 //overtime time and a half pay
                    val regularPay = 40 * (payRate * 1.1)
                    val pay = overTimePay + regularPay
                    println("\n\n$name\n$position\nShift: $shift\nHours Worked: $hoursIn\nWeekly Pay: ${money.format(pay)}")
                }

            }
            else{       //1st shift non-salaried
                if (hoursIn < 40){
                    val pay = hoursIn * payRate
                    println("\n\n$name\n$position\nShift: $shift\nHours Worked: $hoursIn\nWeekly Pay: ${money.format(pay)}")
                }
                else{
                    val overTime = hoursIn - 40 // subtract 40 hours non overtime
                    val overTimePay = (overTime * payRate) * 1.5 //overtime time and a half pay
                    val regularPay = 40 * payRate
                    val pay = overTimePay + regularPay
                    println("\n\n$name\n$position\nShift: $shift\nHours Worked: $hoursIn\nWeekly Pay: ${money.format(pay)}")
                }

            }

        }
    }
}