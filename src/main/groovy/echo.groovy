println "echo"

def strategy = [
        {
            println 'a'
        },
        {
            println 'b'
        },
        {
            println 'c'
        }
]
def param = 97

strategy[param%3].call()

if(param < 100){
    return
}
strategy[param%3].call()

strategy = ['dog':{
    println 'DOG'
},'cat':{
    println 'CAT'
},'pig':{
    println 'PIG'
}]
def process5(){
    println 'PIG'
    println 'PIG'
    println 'PIG'
    println 'PIG'
    println 'PIG'
    println 'PIG'
    println 'PIG'
}
def process6(){
    println 'PIG'
    println 'PIG'
    println 'PIG'
    println 'PIG'
    println 'PIG'
    println 'PIG'
    println 'PIG'
}

if(param % 5 == 0){
    process5()
}else if(param % 6 == 0){
    process6()
}