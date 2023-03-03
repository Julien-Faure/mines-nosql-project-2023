import {Component, Inject, Vue} from 'vue-property-decorator';
import DatabaseService from "@/database/services/database.service";
import InjectionDatabaseSelectorComponent from '../injection-database-selector.vue';


@Component({
  components: {
    'database-selector': InjectionDatabaseSelectorComponent
  },
})
export default class Request2Component extends Vue{

  @Inject('databaseService') private databaseService: () => DatabaseService;

  public elapsed : number = 0;
  public payload : any = {};

  async mounted() : Promise<void>{
    console.log("Request 2 component mounted");
  }

  loadData() {
    const userNameTextbox = this.$el.querySelector('#userName') as HTMLInputElement;
    const productNameTextbox = this.$el.querySelector('#productName') as HTMLInputElement;
    const depthTextbox = this.$el.querySelector('#depth') as HTMLInputElement;

    this.databaseService().executeRequest2(userNameTextbox.value, productNameTextbox.value, Number.parseInt(depthTextbox.value))
      .then(value => {
        this.elapsed = value.elapsedMsTime!;
        this.payload = value.payload;
      });

  }

}
