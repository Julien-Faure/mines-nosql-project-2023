import {Component, Inject, Vue} from 'vue-property-decorator';
import DatabaseService from "@/database/services/database.service";
import InjectionDatabaseSelectorComponent from '../injection-database-selector.vue';


@Component({
  components: {
    'database-selector': InjectionDatabaseSelectorComponent
  },
})
export default class Request1Component extends Vue{

  @Inject('databaseService') private databaseService: () => DatabaseService;

  async mounted() : Promise<void>{
    console.log("Request 1 component mounted");
  }

  async loadData() : Promise<void>{
    console.log("Salut toi !");
  }

}
