<template>
        <v-card class="mb-4">
            <v-card-text>
                <v-text-field class="pa-0" autocomplete="off" placeholder="ToDo Title" v-model="title" />
                <v-text-field class="pa-0" autocomplete="off" placeholder="ToDo Description" v-model="description" />

            <v-menu
                      v-model="menu"
                      :close-on-content-click="false"
                      transition="scale-transition"
                      offset-y
                      max-width="290px"
                      min-width="290px"
                    >
                      <template v-slot:activator="{ on, attrs }">
                        <v-text-field
                          v-model="computedDateFormatted"
                          label="Date Until"
                          hint="MM/DD/YYYY format"
                          persistent-hint
                          prepend-icon="event"
                          readonly
                          v-bind="attrs"
                          v-on="on"
                        ></v-text-field>
                      </template>
                      <v-date-picker v-model="dateUntil" no-title @input="menu = false"></v-date-picker>
                    </v-menu>
                    <v-btn class="bottom mt-2" @click="save">Add ToDo</v-btn>
            </v-card-text>
        </v-card>
</template>

<script>
import { mapActions } from 'vuex'

    import todoApi from 'api/todo'

    export default{
        props: ['todos', 'todoAttr'],
        data: vm => {
                return {
                    id: null,
                    title: '',
                    description: '',
                    dateUntil: new Date().toISOString().substr(0, 10),
                    dateFormatted: vm.formatDate(new Date().toISOString().substr(0, 10)),
                    menu: false,
                }
            },
            computed: {
                  computedDateFormatted () {
                    return this.formatDate(this.dateUntil)
                  },
                },

            watch: {
                      todoAttr: function(newVal, oldVal) {
                          this.title = newVal.title;
                          this.description = newVal.description;
                          this.id = newVal.id;
                          this.dateUntil = newVal.dateUntil
                      },
                       dateUntil (val) {
                            this.dateFormatted = this.formatDate(this.dateUntil)
                       },
                  },
        methods: {
        ...mapActions(['addTodoAction', 'updateTodoAction']),
            save: function() {
                const todo = { id: this.id, title: this.title, description: this.description, dateUntil: this.dateUntil};
                            if(this.id) {
                                this.updateTodoAction(todo)
                            } else {
                                this.addTodoAction(todo)
                            }
                            this.title = '';
                            this.description = '';
                            this.dateUntil = '';
                            this.id = null;
            },
            formatDate (dateUntil) {
                    if (!dateUntil) return null

                    const [year, month, day] = dateUntil.split('-')
                    return `${month}/${day}/${year}`
                  },
                  parseDate (dateUntil) {
                    if (!dateUntil) return null

                    const [month, day, year] = dateUntil.split('/')
                    return `${year}-${month.padStart(2, '0')}-${dateUntil.padStart(2, '0')}`
                  },
        }
    }
</script>

<style>
</style>