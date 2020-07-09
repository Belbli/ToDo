import Vue from 'vue'

const todos = Vue.resource('/todo{/id}')

export default {
    add: todo => todos.save({}, todo),
    update: todo => todos.update({id: todo.id}, todo),
    remove: id => todos.remove({id})
}
