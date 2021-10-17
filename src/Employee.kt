class Employee (person : Person, employeeCode : Int, wage : Float) : Person(person.getName(), person.getAge(), person.getCpf(), person.getGender()) {

    private var employeeCode = employeeCode
    private var workStatus = "Active"
    private var wage  = wage

    override fun showPeopleInfo() {
        super.showPeopleInfo()
        println("Employee code: $employeeCode \nWork Status: $workStatus \nWage: $wage")

    }

    fun fire(){
        this.workStatus = "Fired"
    }

    fun getEmployeeCode() : Int{
        return this.employeeCode
    }

    fun setEmployeeCode(employeeCode : Int){
        this.employeeCode = employeeCode
    }

    fun getWorkStatus() : String{
        return this.workStatus
    }

    fun setWorkStatus(workStatus : String){
        this.workStatus = workStatus
    }

    fun getWage() : Float{
        return this.wage
    }

    fun setWage(wage : Float){
        this.wage = wage
    }



}