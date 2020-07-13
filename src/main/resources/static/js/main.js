import Vue from 'vue'
import 'api/resource'
import VueResource from 'vue-resource'
import store from 'store/store'
import router from 'router/router'
import App from 'pages/App.vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import '@babel/polyfill'

Vue.use(Vuetify)
Vue.use(VueResource)

new Vue({
    vuetify: new Vuetify({}),
    el: '#app',
    store,
    router,
    render: a => a(App)
})

/*function getIndex(list, id) {
    for (var i = 0; i < list.length; i++ ) {
        if (list[i].id === id) {
            return i;
        }
    }

    return -1;
}

var todoApi = Vue.resource('/todo{/id}');

Vue.component('todo-form', {
    props: ['todos', 'todoAttr'],
    data: function() {
        return {
            id: '',
            title: '',
            description: ''
        }
    },
    watch: {
        todoAttr: function(newVal, oldVal) {
            this.title = newVal.title;
            this.description = newVal.description;
            this.id = newVal.id;
        }
    },
    template:
        '<div>' +
            '<input type="text" placeholder="ToDo Title" v-model="title" />' +
            '<input type="text" placeholder="ToDo Description" v-model="description" />' +
            '<input type="button" value="Add ToDo" @click="save" />' +
        '</div>',
    methods: {
        save: function() {
            var todo = { title: this.title, description: this.description };
            if(this.id) {
                todoApi.update({id: this.id}, todo).then(result => {
                    result.json().then(data => {

                        var index = this.todos.findIndex(item => item.id === data.id);
                        console.log(index);
                        //var index = getIndex(this.todos, data.id);
                        this.todos.splice(index, 1, data);
                        this.title = '';
                        this.description = '';
                    })
                })
            } else {
                todoApi.save({}, todo).then(result => {
                        result.json().then(data => {
                            this.todos.push(data);
                            this.title = '';
                            this.description = ''
                        })
                  }
                )
            }
        }
    }
});

Vue.component('todo-item', {
    props: ['todos', 'todo', 'editMethod'],
    template: '<div>' +
                      '<i>({{ todo.title }})</i> {{ todo.description }}' +
                      '<span style="position: absolute; right: 0">' +
                          '<input type="button" value="Edit" @click="edit" />' +
                          '<input type="button" value="X" @click="del" />' +
                      '</span>' +
                      '</div>',
     methods: {
            edit: function() {
                this.editMethod(this.todo);
            },
            del: function() {
                todoApi.remove({id: this.todo.id}).then(result => {
                    if (result.ok) {
                        this.todos.splice(this.todos.indexOf(this.todo), 1)
                    }
                })
            }
        }
});


Vue.component('todo-list', {

  props: ['todos'],
  data: function() {
      return {
          todo: null
      }
    },
  template: '<div>' +
                '<todo-form :todos="todos" :todoAttr="todo"/>' +
                '<todo-item v-for="todo in todos" :key="todo.id" :todo="todo" :editMethod="editMethod" :todos="todos" />' +
            '</div>',

                      methods: {
                        editMethod: function(todo) {
                            this.todo = todo;
                        }
                      }
});


var app = new Vue({
  el: '#app',
  template:
          '<div>' +
                  '<div v-if="!profile">Необходимо авторизоваться через <a href="/login">Google</a></div>' +
                  '<div v-else>' +
                      '<div>{{profile.name}}&nbsp;<a href="/logout">Выйти</a></div>' +
                      '<todo-list :todos="todos" />' +
                  '</div>' +
          '</div>',
  data: {
    todos: frontendData.todos,
    profile: frontendData.profile
  }
});*/
