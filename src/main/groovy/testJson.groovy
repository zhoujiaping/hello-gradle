import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

def jsonSlurper = new JsonSlurper()
def object = jsonSlurper.parseText('{ "name": "John Doe" } /* some comment */')

assert object instanceof Map
assert object.name == 'John Doe'

class Person {
    String name
    int age
}

def json = JsonOutput.toJson([new Person(name: 'John'), new Person(name: 'Max')])

assert json == '[{"name":"John"},{"name":"Max"}]'

JsonBuilder jb = new JsonBuilder([1, 2, 3])
println jb



