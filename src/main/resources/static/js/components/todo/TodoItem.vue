<template>
     <!--v-card
        d-flex
        align-content-start
        flex-wrap
        class="ma-2"
        height="208px"
        width="214.4px"
        active-class="card"
     >
         <v-card-title class="headline">{{ todo.title }}</v-card-title>
         <v-card-subtitle> {{ todo.description }}</v-card-subtitle>

         <v-card-actions>
              <v-btn class="mb-2" text outlined color="primary" @click="edit">Edit</v-btn>
              <v-btn class="mb-2" text @click="del">
                <v-icon>delete</v-icon>
              </v-btn>
         </v-card-actions>
     </v-card-->
     <v-card flat>
             <v-layout wrap :class="`todo ${status} pa-4 pl-6 `">
               <v-flex xs6 md4>
                 <div class="caption grey--text">{{ todo.title }}</div>
                 <div>{{ todo.description }}</div>
               </v-flex>
               <v-flex xs6 sm4 md2>
                 <div class="caption grey--text">Person</div>
                 <div>Name</div>
               </v-flex>
               <v-flex xs6 sm4 md2>
                 <div class="caption grey--text">Due by</div>
                 <div>{{ todo.dateUntil }}</div>
               </v-flex>
               <v-flex xs2 sm4 md2>
                    <v-btn class="mb-2" text @click="edit"><v-icon>edit</v-icon></v-btn>
                    <v-btn class="mb-2" text @click="del">
                        <v-icon>delete</v-icon>
                    </v-btn>
               </v-flex>
                <v-flex xs2 sm4 md2>
                 <div class="right">
                   <v-chip small color="teal" :class="`${status} white--text my-2`">{{ status }}</v-chip>
                 </div>
               </v-flex>
             </v-layout>

             <v-divider></v-divider>
           </v-card>

</template>

<script>
import { mapActions } from 'vuex'
    export default{
        props: ['todo', 'editItem', 'todos'],
        data() {
            return{
                expandOnHover: false,
                status: 'complete'
            }
        },
        methods: {
        ...mapActions(['removeTodoAction']),
            edit() {
                this.editItem(this.todo)
            },
            del() {
                this.removeTodoAction(this.todo)
            }
        }
    }
</script>

<style>
.v-card__actions {
    position: absolute;
    bottom: 0;
}

.todo.complete{
  border-left: 4px solid #3cd1c2;
}
.todo.ongoing{
  border-left: 4px solid #ffaa2c;
}
.todo.overdue{
  border-left: 4px solid #f83e70;
}
.v-chip.complete{
  background: #3cd1c2;
}
.v-chip.ongoing{
  background: #ffaa2c;
}
.v-chip.overdue{
  background: #f83e70;
}

</style>