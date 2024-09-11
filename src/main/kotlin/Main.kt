package org.example

data class Task (
    val id:Int,
    var title: String,
    var description: String,
    var isCompleted: Boolean
)
fun addTask(tasks: MutableList<Task>, nextId: Int) {
    print("Enter task id:")
    val id = readLine()!!
    print("Enter task title:")
    val title = readLine()!!
    print("Enter task description: ")
    val description = readLine()!!
         if(title.isNotEmpty() or description.isNotEmpty()) {
        tasks.add(Task(nextId, title, description, false))
        println("Task Added") } else
             println("Task not Added")


}

fun viewTasks(tasks: List<Task>) {
    if (tasks.isEmpty()) {
        println("Task no available")
    }
    else {
        tasks.forEach {
            println("id:${it.id},title:${it.title},description:${it.description}") }
    }
}

fun updateTask(tasks: MutableList<Task>) {
    print("Enter task ID: ")
    val id = readLine()!!.toIntOrNull() ?: return
    print("Enter new title: ")
    val newtitle = readLine()!!
    print("Enter new description: ")
    val newdescription = readLine()!!
    tasks.find { it.id == id }?.let {
        it.title = newtitle; it.description = newdescription
        println("Task update ")
    } ?:
    println("Task not found")
}


fun deleteTask(tasks: MutableList<Task>) {
    print("Enter task ID: ")
    val id = readLine()!!.toIntOrNull() ?: return
    if(tasks.removeIf { it.id== id }) {
        println("task deleted")
    }else{
        println("task not found")
    }
}
 fun markAsCompleted(tasks: MutableList<Task>) {
       print("Enter task ID: ")
      val id = readLine()!!.toIntOrNull() ?: return
       val it = tasks.find { it.id == id }
           if(it!=null){
        it.isCompleted = true
        println("mark as completed")}
        else{
               println("task not found")
       }

 }

fun main() {
    val tasks = mutableListOf<Task>()
    var nextId = 1
    while (true) {
        println("1. Add Task")
        println("2. View All Tasks")
        println("3. Update Task")
        println("4. Delete Task")
        println("5. Mark Task as Completed")
        println("6. Exit")

        print("Choose an option: ")
        when (readLine()!!) {
            "1" -> addTask(tasks, nextId++)
            "2" -> viewTasks(tasks)
            "3" -> updateTask(tasks)
            "4" -> deleteTask(tasks)
            "5" -> markAsCompleted(tasks)
            "6" -> return
            else -> println("Invalid option")
        }
    }
}
