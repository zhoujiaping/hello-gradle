def task(f){
	
}
def hello(c){
	c()
}
/*
task hello {
	println "work..."
}
同下
*/
task(hello(){
	println "work..."
})

