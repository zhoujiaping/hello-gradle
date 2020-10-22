
def numbers = [1,2,3,4,5,6]
def add(... nums){
    nums.inject {
        i,j->i+j
    }
}
println add(*numbers) // == [1,2,3,4,5,6]

def people = [
        new Person(name: 'John', age: 25),
        new Person(name: 'Anna', age: 21)
]

def friends = people*.name // friends = ['John', 'Anna']

println friends