<template>
    <v-container class="my-5">
        <h1 class="subheading grey--text">Projects</h1>
        <!--v-expansion-panels>
          <v-expansion-panel>
            <v-expansion-panel-content v-for="project in projects" :key="project.title">
              <div slot="header" class="py-1">{{ project.title }}</div>
              <v-card>
                <v-card-text class="px-4 grey--text">
                  <div class="font-weight-bold">Due by {{ project.due }}</div>
                  <div>{{ project.content }}</div>
                </v-card-text>
              </v-card>
            </v-expansion-panel-content>
          </v-expansion-panel>
        </v-expansion-panels-->

        <v-expansion-panels
            >
              <v-expansion-panel v-for="project in projects" :key="project.title">
                <v-expansion-panel-header>{{ project.title }}</v-expansion-panel-header>
                <v-expansion-panel-content>
                  <v-card>
                                  <v-card-text class="px-4 grey--text">
                                    <div class="font-weight-bold">Due by {{ project.due }}</div>
                                    <div>{{ project.content }}</div>
                                  </v-card-text>
                                </v-card>
                </v-expansion-panel-content>
              </v-expansion-panel>
        </v-expansion-panels>
    </v-container>
</template>

<script>
export default {
  data() {
    return {
      projects: [
        { title: 'Design a new website', status: 'complete', person: 'The Net Ninja', due: '1st Jan 2019', status: 'ongoing', content: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt consequuntur eos eligendi illum minima adipisci deleniti, dicta mollitia enim explicabo fugiat quidem ducimus praesentium voluptates porro molestias non sequi animi!'},
        { title: 'Code up the homepage', status: 'complete', person: 'Chun Li', due: '10th Jan 2019', status: 'complete', content: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt consequuntur eos eligendi illum minima adipisci deleniti, dicta mollitia enim explicabo fugiat quidem ducimus praesentium voluptates porro molestias non sequi animi!'},
        { title: 'Design video thumbnails', status: 'complete', person: 'Ryu', due: '20th Dec 2018', status: 'complete', content: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt consequuntur eos eligendi illum minima adipisci deleniti, dicta mollitia enim explicabo fugiat quidem ducimus praesentium voluptates porro molestias non sequi animi!'},
        { title: 'Create a community forum', status: 'complete', person: 'Gouken', due: '20th Oct 2018', status: 'overdue', content: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt consequuntur eos eligendi illum minima adipisci deleniti, dicta mollitia enim explicabo fugiat quidem ducimus praesentium voluptates porro molestias non sequi animi!'},
      ]
    }
  },
  computed: {
    myProjects() {
      return this.projects.filter(project => {
        return project.person === 'Name'
      })
    }
  }
}
</script>
