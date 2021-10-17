open class Person (name : String, age : Int, cpf : String, gender : String){

    private var name = name
    private var age = age
    private  var cpf = cpf
    private  var gender = gender

    open fun showPeopleInfo(){
        println("Person name: ${this.name} \nPerson age: ${this.age} \nCPF: ${this.cpf} \nGender: ${this.gender}")
    }


    fun getName() : String{
        return this.name
    }

    fun getAge () : Int{
        return this.age
    }

    fun getCpf() : String{
        return this.cpf
    }
    fun getGender(): String{
        return this.gender
    }

    fun setName(name : String){
        this.name = name
    }

    fun setAge(age : Int){
        this.age = age
    }

    fun setCpf(cpf : String){
        this.cpf = cpf
    }

    fun setGender(gender : String){
        this.gender = gender
    }

}